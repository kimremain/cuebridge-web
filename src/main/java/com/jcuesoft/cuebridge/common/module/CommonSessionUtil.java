package com.jcuesoft.cuebridge.common.module;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jcuesoft.cuebridge.auth.vo.AuthDTO;


public class CommonSessionUtil extends BaseModule{

    
    public static Object getAttribute() {
        HttpSession httpSession = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        return httpSession.getAttribute(CommonConstants.SESSION_KEY_USER);
    }

    public static String getIdUser() {
        AuthDTO authDTO = (AuthDTO) getAttribute();
        return (authDTO != null) ? authDTO.getIdUser() : " ";
    }


    public static String getNmUser() {
        AuthDTO authDTO = (AuthDTO) getAttribute();
        return (authDTO != null) ? authDTO.getNmUser() : " ";
    }


    public static String getCdTeam() {
        AuthDTO authDTO = (AuthDTO) getAttribute();
        return (authDTO != null) ? authDTO.getCdTeam() : " ";
    }


    public static String getDsUrl() {
        AuthDTO authDTO = (AuthDTO) getAttribute();
        return (authDTO != null) ? authDTO.getDsUrl() : " ";
    }


    public static String getYnConfirm() {
        AuthDTO authDTO = (AuthDTO) getAttribute();
        return (authDTO != null) ? authDTO.getYnConfirm() : " ";
    }


    public static String getFaxNo() {
        AuthDTO authDTO = (AuthDTO) getAttribute();
        return (authDTO != null) ? authDTO.getFaxNo() : " ";
    }


    public static String getNoFaxCompany() {
        AuthDTO authDTO = (AuthDTO) getAttribute();
        return (authDTO != null) ? authDTO.getNoFaxCompany() : " ";
    }


    public static String getCdCompany() {
        AuthDTO authDTO = (AuthDTO) getAttribute();
        return (authDTO != null) ? authDTO.getCdCompany() : " ";
    }


    public static String getYnAdmin() {
        AuthDTO authDTO = (AuthDTO) getAttribute();
        return (authDTO != null) ? authDTO.getYnAdmin() : " ";
    }


    public static String getYnScreen() {
        AuthDTO authDTO = (AuthDTO) getAttribute();
        return (authDTO != null) ? authDTO.getYnScreen() : " ";
    }
    
    public static void removeSession() {
        HttpSession httpSession = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        if(httpSession!=null){
            httpSession.invalidate();
        }        
    }
    
    
    
    
}
