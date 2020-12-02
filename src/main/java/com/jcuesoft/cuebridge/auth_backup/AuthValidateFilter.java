package com.jcuesoft.cuebridge.auth_backup;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jcuesoft.cuebridge.auth.service.AuthService;
import com.jcuesoft.cuebridge.auth.vo.AuthRequestVO;
import com.jcuesoft.cuebridge.auth.vo.AuthResponseVO;

public class AuthValidateFilter implements Filter {
    
    @Autowired
    private AuthService authService;    

    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    static AuthRequestVO authRequestVO = new AuthRequestVO();
    static AuthResponseVO authResponseVO = new AuthResponseVO();
    String redirectUrl;
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,
            ServletException {
        logger.debug("Call AuthValidateFilter doFilter...");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;     
        String redirectUrl = "";
        String path = ((HttpServletRequest) servletRequest).getRequestURI();
        if (path.startsWith("/login/form/select") 
                || path.startsWith("/js/") 
                || path.startsWith("/css/")
                || path.startsWith("/images/")
                ) {
            logger.debug("AuthValidateFilter bypass url:"+path);
            filterChain.doFilter(httpServletRequest, servletResponse);
        } else {
            logger.debug("AuthValidateFilter url:"+path);
            try 
            {
                boolean byPassLogin = true;
                // 브리지 세션 검증
/*                if(checkBridgeSession()== true){
                    logger.debug("checkBridgeSession true");
                    byPassLogin = true;
                }*/
                
                if(byPassLogin == false){
                    // 유효 인증수단 없을경우 로그인 페이지 redirect
                    String referer = URLEncoder.encode(httpServletRequest.getRequestURL().toString(),"UTF-8");
                    redirectUrl = "/login/form/select?referer="+referer;
                }

            } catch (Exception e) {
                logger.error("AuthValidateFilter Exception :", e);
            }
            if(redirectUrl.equals("")){
                filterChain.doFilter(httpServletRequest, servletResponse);
            }else{
                httpServletResponse.sendRedirect(redirectUrl);
            }
            
        }        

        
    }
    

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
