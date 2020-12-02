package com.jcuesoft.cuebridge.auth.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.auth.service.AuthService;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class AuthController extends BaseController{
    
    @Autowired
    private AuthService authService;    
    
    @RequestMapping("/auth/login")
    public ModelAndView  login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.debug("Call AuthController login {}", session.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/auth/login");
        return modelAndView;   
    }
    
    @RequestMapping("/auth/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("Call AuthController logout {}");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            CommonSessionUtil.removeSession();
            new CookieClearingLogoutHandler("JSESSIONID", "SPRING_SECURITY_REMEMBER_ME_COOKIE");
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        
        return new ModelAndView("redirect:/j_spring_security_logout");
    }
     

}
