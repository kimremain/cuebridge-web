package com.jcuesoft.cuebridge.auth.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class AuthRequestVO extends BaseVO {

    private static final long serialVersionUID = 3733398182738240427L;

    private String idUser;
    
    private String dsPwd;
    
    private String encryptLincusCookie;
    
    private String ynLoginByLincus;
    
    private String referer;

    
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getDsPwd() {
        return dsPwd;
    }

    public void setDsPwd(String dsPwd) {
        this.dsPwd = dsPwd;
    }

    public String getEncryptLincusCookie() {
        return encryptLincusCookie;
    }

    public void setEncryptLincusCookie(String encryptLincusCookie) {
        this.encryptLincusCookie = encryptLincusCookie;
    }
    
    public String getReferer() throws UnsupportedEncodingException {
        referer = (referer != null && referer != "") ? referer : "/"; 
        
        return URLDecoder.decode(referer,"UTF-8");
    }

    public void setReferer(String referer) throws UnsupportedEncodingException {
        this.referer =URLEncoder.encode(referer,"UTF-8");
    }

    public String getYnLoginByLincus() {
        return ynLoginByLincus;
    }

    public void setYnLoginByLincus(String ynLoginByLincus) {
        this.ynLoginByLincus = ynLoginByLincus;
    }
}
