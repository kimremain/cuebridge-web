package com.jcuesoft.cuebridge.common.jdbc.aspect;

import java.lang.invoke.MethodHandles;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jcuesoft.cuebridge.common.jdbc.ContextHolder;
import com.jcuesoft.cuebridge.common.jdbc.DataSourceType;
import com.jcuesoft.cuebridge.common.module.CommonConstants;

public class DomainNameBasedDatasourceAdvice {
    /**
     * logger
     */
    /*private Logger logger = LoggerFactory.getLogger(this.getClass());*/
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public Object determineDatasource(ProceedingJoinPoint joinPoint) throws Throwable {
        if (logger.isDebugEnabled()) {
            //String methodName = joinPoint.getSignature().getName();
            //logger.debug("=== before determineDatasource ===");
            //logger.debug("methodName:" + methodName);
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        List<String> headers = Collections.list(request.getHeaderNames());

        if(logger.isDebugEnabled()){
            for (String header : headers) {
    
                if (logger.isDebugEnabled()) {
                    //logger.debug("Header[" + header + "]:" + request.getHeader(header));
                }
            }
        }
//        String domain = request.getHeader("host");
        
        HttpSession session = request.getSession(false);
        
        String domainSession = (String) session.getAttribute(CommonConstants.SESSION_KEY_DOMAIN);
        
        if (domainSession != null) {
            // 해당 도메인의 prefix에 따른 dataSource를 설정한다.
            if (domainSession.contains(CommonConstants.DOMAIN_YOUI)) {
                ContextHolder.setDataSourceType(DataSourceType.DATASOURCE_YOUI);
                
            } else if (domainSession.contains(CommonConstants.DOMAIN_MILL)) {
                ContextHolder.setDataSourceType(DataSourceType.DATASOURCE_MILL);
                
            } else if (domainSession.contains(CommonConstants.DOMAIN_STAR)) {
                ContextHolder.setDataSourceType(DataSourceType.DATASOURCE_STAR);
            
            // default - null
            } 
            else {
                ContextHolder.setDataSourceType(DataSourceType.DATASOURCE_NULL);
            }
        }else{
            logger.debug("cuebridgeSession is not null for datasource rouing");
            throw new Exception("cuebridgeSession is not null for datasource rouing.");
        }

/*        domain = request.getHeader("host");

        if (domain != null) {
            // 해당 도메인의 prefix에 따른 dataSource를 설정한다.
            if (domain.contains("star")) {
                ContextHolder.setDataSourceType(DataSourceType.DATASOURCE_STAR);
            } else if (domain.contains("youi")) {
                ContextHolder.setDataSourceType(DataSourceType.DATASOURCE_YOUI);
            } else if (domain.contains("mill")) {
                ContextHolder.setDataSourceType(DataSourceType.DATASOURCE_MILL);
            }
        }else{
            ContextHolder.setDataSourceType(DataSourceType.DATASOURCE_STAR);
        }*/

//        joinPoint.proceed();
        
        if (logger.isDebugEnabled()) {
            logger.debug("DataSource ===> " + ContextHolder.getDataSourceType());
        }
        
        Object returnValue = joinPoint.proceed();
        // 20141002 주석 BY 김성준
        //ContextHolder.clearDataSourceType();

        if (logger.isDebugEnabled()) {
            //logger.debug("=== after determineDatasource ===");
        }
        return returnValue;

    }

}
