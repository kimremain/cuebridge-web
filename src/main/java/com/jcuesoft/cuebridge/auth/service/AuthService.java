package com.jcuesoft.cuebridge.auth.service;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.auth.dao.AuthDAO;
import com.jcuesoft.cuebridge.auth.vo.AuthRequestVO;
import com.jcuesoft.cuebridge.auth.vo.AuthResponseVO;
import com.jcuesoft.cuebridge.common.service.BaseService;

@Service
public class AuthService extends BaseService {

    @Autowired
    private AuthDAO authDAO;
    
    @Autowired
    ServletContext servletContext;
    
    public String getLoginCookieDecrypt(String encryptStr) throws Exception {
        logger.debug("Call AuthService getLoginCookieDecrypt");
        return authDAO.getLoginDecrypt(encryptStr);
    }
    
    public String getCorrectCookieId(String encryptStr) throws Exception {
        logger.debug("Call AuthService getCorrectCookieId");
        return authDAO.getCorrectCookieId(encryptStr);
    }

    public AuthResponseVO getUserInfoByDsPwd(AuthRequestVO authRequestVO) throws Exception {
        logger.debug("Call AuthService getUserInfoByDsPwd");
        return authDAO.getUserInfoByDsPwd(authRequestVO);
    }
    
    public AuthResponseVO getUserInfoByIdUser(AuthRequestVO authRequestVO) throws Exception {
        logger.debug("Call AuthService getUserInfoByIdUser");
        return authDAO.getUserInfoByIdUser(authRequestVO);
    }    

    
}