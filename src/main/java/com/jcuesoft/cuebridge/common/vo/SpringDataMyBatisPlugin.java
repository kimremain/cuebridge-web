package com.jcuesoft.cuebridge.common.vo;

import java.lang.invoke.MethodHandles;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jcuesoft.cuebridge.common.dao.Pagenation;

/**
 * MyBatis plugin which allows functions of the form
 * 
 * : {@link Pagenation}<T> someFunction(...,{@link Pageable} pageable,...)
 * 
 * to work properly using spring-datas {@link Pageable} and {@link Page} interfaces.
 * 
 */
// ISSUE 1: bad query transformation.
// ISSUE 2: The function must use Pagenation instead of Page, otherwise mybatis
// will
// choke.
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class,
        ResultHandler.class }) })
public class SpringDataMyBatisPlugin implements Interceptor {
    /*Logger logger = LoggerFactory.getLogger(this.getClass());*/
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Object intercept(Invocation arg0) throws Throwable {

        boolean pageable = false;
        Pageable pageableObject = null;
        MappedStatement stmt = null;

        for (Object o : arg0.getArgs()) {
            if (o != null) {
                if (Pageable.class.isAssignableFrom(o.getClass())) {
                    pageable = true;
                    pageableObject = (Pageable) o;

                    // TODO : remove log
                    if (logger.isDebugEnabled()) {
                        logger.debug("== intercept : SpringDataMyBatisPlugin --> Pageable!! ");
                    }
                }
                if (o instanceof MappedStatement) {
                    stmt = (MappedStatement) o;
                }
            }
        }

        Object ret = arg0.proceed();

        if (pageable && pageableObject != null && stmt != null) {
            int total = -1;

            Executor exec = (Executor) arg0.getTarget();
            Statement sqlstmt = exec.getTransaction().getConnection().createStatement();

            // This is a bit shady. I might want to replace it by finding a
            // similar function on the same
            // mapper. For example: FunctionA => countOfFunctionA

            // Convert the select ... from ... statement to a count statement.
            // TODO: remove paginating LIMITS and such.
            ResultSet s = sqlstmt.executeQuery(stmt.getSqlSource().getBoundSql(null).getSql().replace('\n', ' ')
                    .replaceFirst("[S|s][E|e][L|l][E|e][C|c][T\t]\\s+.*[F|f][R|r][O|o][M|m]", "SELECT count(*) from "));

            s.next();
            total = s.getShort(1);

            Pagenation<?> pi = new Pagenation<Object>((List) ret, pageableObject, total);
            return pi;
        }

        return ret;
    }

    @Override
    public Object plugin(Object arg0) {
        return Plugin.wrap(arg0, (Interceptor) this);
    }

    @Override
    public void setProperties(Properties arg0) {

    }
}