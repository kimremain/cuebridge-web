package com.jcuesoft.cuebridge.common.filter;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcuesoft.cuebridge.common.module.CommonConstants;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;

public class DomainSessionFilter implements Filter {
    /**
     * logger
     */
    /*private Logger logger = LoggerFactory.getLogger(this.getClass());*/
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        
        RequestDispatcher rd = null;  
        
        StringBuffer requestedUrl = httpServletRequest.getRequestURL();
        
        if(logger.isDebugEnabled()){
            //logger.debug("requestedUrl:"+requestedUrl);
        }
        
        
        if(requestedUrl.toString().matches(".*(css|jpg|png|gif|ico|css|html|htm|js)")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        
        
        HttpSession session = httpServletRequest.getSession();
        
        String domainSession = (String) session.getAttribute(CommonConstants.SESSION_KEY_DOMAIN);
        
        String domain = httpServletRequest.getHeader("host").toLowerCase();
        
        logger.debug("### domainSession:"+domainSession);
        
        if(null == domainSession){
            logger.debug("### header[host]:"+domain);
            logger.debug("CommonSessionUtil.getCdCompany() :" + CommonSessionUtil.getCdCompany());
            logger.debug("CommonSessionUtil.getNmUser() :" + CommonSessionUtil.getNmUser());
            
            if(null != domain){
            
                // 해당 도메인의 prefix에 따른 cuebridgeSession를 설정한다.
                // youi
                if (domain.contains(CommonConstants.DOMAIN_YOUI)) {
                    session.setAttribute(CommonConstants.SESSION_KEY_DOMAIN, CommonConstants.DOMAIN_YOUI);
                    
                // mill
                } else if (domain.contains(CommonConstants.DOMAIN_MILL)) {
                    session.setAttribute(CommonConstants.SESSION_KEY_DOMAIN, CommonConstants.DOMAIN_MILL);
                    
                // star
                } else if (domain.contains(CommonConstants.DOMAIN_STAR)) {
                    session.setAttribute(CommonConstants.SESSION_KEY_DOMAIN, CommonConstants.DOMAIN_STAR);
                    
                // default - star
                // redirect 403-forbidden
                }
                else{
                    //session.setAttribute(CommonConstants.SESSION_KEY_DOMAIN, CommonConstants.DOMAIN_STAR);
                    rd = httpServletRequest.getRequestDispatcher("/error/403/select");
                    rd.forward(httpServletRequest, httpServletResponse);
                    return;
                    
                }
            }
            
        }else{
            
            if(!domain.contains(domainSession) ){
                if(logger.isWarnEnabled()){
                    logger.warn("### domainSession and currnet domain different!!");
                    logger.warn("domainSession :["+domainSession+"]");
                    logger.warn("current  domain  :["+domain+"]");
                }
                rd = httpServletRequest.getRequestDispatcher("/error/403/select");
                rd.forward(httpServletRequest, httpServletResponse);
                return;
            }
        }
        
        if(logger.isWarnEnabled()){
            logger.debug("### domainSessionFillter passed !! next filterchain.");
        }
        filterChain.doFilter(httpServletRequest, servletResponse);
        
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        if(logger.isDebugEnabled()){
            logger.debug("init DomainSessionFilter.");
        }
    }

}
