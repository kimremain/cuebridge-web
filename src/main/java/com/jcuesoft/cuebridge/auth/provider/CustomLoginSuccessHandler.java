package com.jcuesoft.cuebridge.auth.provider;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import com.jcuesoft.cuebridge.auth.service.AuthService;
import com.jcuesoft.cuebridge.auth.vo.AuthDTO;
import com.jcuesoft.cuebridge.auth.vo.AuthRequestVO;
import com.jcuesoft.cuebridge.auth.vo.AuthResponseVO;
import com.jcuesoft.cuebridge.common.module.CommonUtil;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    
    @Autowired
    private AuthService authService;    
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public CustomLoginSuccessHandler() {
        logger.debug("Call CustomLoginSuccessHandler ...");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        logger.debug("Call CustomLoginSuccessHandler onAuthenticationSuccess...");        

        try {
            HttpSession session = request.getSession();
            AuthDTO authDTO = (AuthDTO)SecurityContextHolder.getContext().getAuthentication().getDetails();
            //logger.debug("Welcome login_success! {}, {}", session.getId(), authDTO.getUsername()+"/"+authDTO.getPassword());
            logger.debug("Welcome login_success! {}, {}", session.getId(), authDTO.getUsername());
            AuthRequestVO authRequestVO = new AuthRequestVO();
            AuthResponseVO authResponseVO = new AuthResponseVO();
            authRequestVO.setIdUser(authDTO.getUsername());
            authResponseVO = authService.getUserInfoByIdUser(authRequestVO);
            authDTO.setIdUser(authResponseVO.getIdUser());
            authDTO.setNmUser(authResponseVO.getNmUser());
            authDTO.setCdTeam(authResponseVO.getCdTeam());
            authDTO.setYnConfirm(authResponseVO.getYnConfirm());
            authDTO.setFaxNo(authResponseVO.getFaxNumber());
            authDTO.setYnAdmin(authResponseVO.getYnAdmin());
            authDTO.setYnScreen(authResponseVO.getYnScreen());
            authDTO.setNoFaxCompany(authResponseVO.getNoFaxCompany());
            authDTO.setCdCompany(CommonUtil.getDomainCompany(request.getRequestURL().toString()));
            logger.debug(ToStringBuilder.reflectionToString(authDTO, ToStringStyle.MULTI_LINE_STYLE));
            
            session.setAttribute("userVO", authDTO);
        } catch (Exception e) {
            logger.error("onAuthenticationSuccess doing session make exception:", e);
            e.printStackTrace();
        }

        String redirectUrl = getReturnUrl(request, response);
        if (redirectUrl != null && redirectUrl.getBytes().length > 0) {
            logger.debug("previous redirectUrl :["+redirectUrl+"]");
            response.sendRedirect(redirectUrl);
        }else{
            response.sendRedirect("/");
        }
        
    }

    private String getReturnUrl(HttpServletRequest request, HttpServletResponse response) {
        RequestCache requestCache = new HttpSessionRequestCache();
        org.springframework.security.web.savedrequest.SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest == null) {
            return request.getSession().getServletContext().getContextPath();
        }
        return savedRequest.getRedirectUrl();
    }

}
