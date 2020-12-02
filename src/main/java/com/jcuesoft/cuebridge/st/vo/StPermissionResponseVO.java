package com.jcuesoft.cuebridge.st.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StPermissionResponseVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = 7020128219470613542L;
    
    private String dsPgm;
    private String dsUrl;

    
    private BigDecimal no;

    private String noUserId;

    private String dsPgmId;

    private String ynS;

    private String ynU;

    private String ynD;

    private String ynE;

    private String ynP;

    private String ynA;

    public String getDsPgm() {
        return dsPgm;
    }

    public void setDsPgm(String dsPgm) {
        this.dsPgm = dsPgm;
    }

    public String getDsUrl() {
        return dsUrl;
    }

    public void setDsUrl(String dsUrl) {
        this.dsUrl = dsUrl;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getNoUserId() {
        return noUserId;
    }

    public void setNoUserId(String noUserId) {
        this.noUserId = noUserId;
    }

    public String getDsPgmId() {
        return dsPgmId;
    }

    public void setDsPgmId(String dsPgmId) {
        this.dsPgmId = dsPgmId;
    }

    public String getYnS() {
        return ynS;
    }

    public void setYnS(String ynS) {
        this.ynS = ynS;
    }

    public String getYnU() {
        return ynU;
    }

    public void setYnU(String ynU) {
        this.ynU = ynU;
    }

    public String getYnD() {
        return ynD;
    }

    public void setYnD(String ynD) {
        this.ynD = ynD;
    }

    public String getYnE() {
        return ynE;
    }

    public void setYnE(String ynE) {
        this.ynE = ynE;
    }

    public String getYnP() {
        return ynP;
    }

    public void setYnP(String ynP) {
        this.ynP = ynP;
    }

    public String getYnA() {
        return ynA;
    }

    public void setYnA(String ynA) {
        this.ynA = ynA;
    }
    
    
    
}
