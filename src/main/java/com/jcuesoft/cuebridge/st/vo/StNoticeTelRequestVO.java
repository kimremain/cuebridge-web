package com.jcuesoft.cuebridge.st.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StNoticeTelRequestVO extends BaseVO{

    /**
     * 
     */
    private static final long serialVersionUID = 5770275930841244514L;
    
    private String noTel;
    
    private String dsRemk;
    
    private String idReg;

    public String getNoTel() {
        return noTel;
    }

    public void setNoTel(String noTel) {
        this.noTel = noTel;
    }

    public String getDsRemk() {
        return dsRemk;
    }

    public void setDsRemk(String dsRemk) {
        this.dsRemk = dsRemk;
    }

    public String getIdReg() {
        return idReg;
    }

    public void setIdReg(String idReg) {
        this.idReg = idReg;
    }

}
