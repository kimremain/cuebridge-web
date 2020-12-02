package com.jcuesoft.cuebridge.st.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StPermissionRequestVO extends BaseVO {


    /**
     * 
     */
    private static final long serialVersionUID = -7227667892215173730L;
    
    private String selectIdUser;

    private String[] authorize;
    
    private String authPgmID;
    
    private String idReg;
    
    private String idUpt;
    
    public String getAuthPgmID() {
        return authPgmID;
    }

    public void setAuthPgmID(String authPgmID) {
        this.authPgmID = authPgmID;
    }

    public String getSelectIdUser() {
        return selectIdUser;
    }

    public void setSelectIdUser(String selectIdUser) {
        this.selectIdUser = selectIdUser;
    }

    public String[] getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String[] authorize) {
        this.authorize = authorize;
    }

    public String getIdReg() {
        return idReg;
    }

    public void setIdReg(String idReg) {
        this.idReg = idReg;
    }

    public String getIdUpt() {
        return idUpt;
    }

    public void setIdUpt(String idUpt) {
        this.idUpt = idUpt;
    }
    
    

  
    
}
