package com.jcuesoft.cuebridge.common.pagination;

import java.sql.PreparedStatement;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

@Intercepts({ @Signature(type = ParameterHandler.class, method = "setParameters", args = { PreparedStatement.class }) })
public class ParameterInterceptor implements Interceptor{
    private static final String tag = ParameterInterceptor.class.getName();
    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        ParameterHandler  parameterHandler = (ParameterHandler)invocation.getTarget();
 /*       MetaObject metaParameterHandler= MetaObject.forObject(parameterHandler, DEFAULT_OBJECT_FACTORY,DEFAULT_OBJECT_WRAPPER_FACTORY, null);
        Object parameterObj =metaParameterHandler
                .getValue("parameterObject");
        BoundSql boundSql = (BoundSql) metaParameterHandler
                .getValue("boundSql");
        MappedStatement mappedStatement = (MappedStatement) metaParameterHandler
                .getValue("mappedStatement");
        String id = mappedStatement.getId();
        String className = id.substring(0, id.lastIndexOf("."));*/
//        Class<?>  classObj = Class.forName(className);
//        //根据配置加密
//        TableSeg tableSeg = classObj.getAnnotation(TableSeg.class);
//        if(tableSeg!=null){
//            String[] fields = tableSeg.encryptFields();
//            if(fields.length>0){
//                EncryptParameter  as = new EncryptParameterImpl(mappedStatement, parameterObj, boundSql);
//                as.encryptParamter(fields);
//            }
//        }
        //继续执行
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        // 当目标类是ParameterHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的
        // 次数
        if (target instanceof ParameterHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        // TODO Auto-generated method stub
        
    }

}
