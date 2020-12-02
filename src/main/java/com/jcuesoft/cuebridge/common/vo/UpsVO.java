package com.jcuesoft.cuebridge.common.vo;

public class UpsVO extends BaseVO{

    /**
     * 
     */
    private static final long serialVersionUID = 2863360494653550597L;
    
    
    // BEX_MASTER 실행여부
    private String ynEx;
    
    
    //BRC_LOAN PARAM
    
    private String noReq;
    
    private String dtCbAgree;
    
    private String dmReg; // yyyymmdd
    
    private String cdPath;
    
    private String idScreen;
    
    private String cdCooperate;
    
    // UPS 필드
    private String upsNo;    
    
    private String cdKind;
    
    private String dtAgreeInfo;
    
    private String dtmReg;
    
    private String idReg;

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }



    public String getUpsNo() {
        return upsNo;
    }

    public void setUpsNo(String upsNo) {
        this.upsNo = upsNo;
    }

    public String getDtCbAgree() {
        return dtCbAgree;
    }

    public void setDtCbAgree(String dtCbAgree) {
        this.dtCbAgree = dtCbAgree;
    }

    public String getDmReg() {
        return dmReg;
    }

    public void setDmReg(String dmReg) {
        this.dmReg = dmReg;
    }

    public String getCdPath() {
        return cdPath;
    }

    public void setCdPath(String cdPath) {
        this.cdPath = cdPath;
    }

    public String getIdScreen() {
        return idScreen;
    }

    public void setIdScreen(String idScreen) {
        this.idScreen = idScreen;
    }

    public String getCdCooperate() {
        return cdCooperate;
    }

    public void setCdCooperate(String cdCooperate) {
        this.cdCooperate = cdCooperate;
    }

    public String getCdKind() {
        return cdKind;
    }

    public void setCdKind(String cdKind) {
        this.cdKind = cdKind;
    }

    public String getDtAgreeInfo() {
        return dtAgreeInfo;
    }

    public void setDtAgreeInfo(String dtAgreeInfo) {
        this.dtAgreeInfo = dtAgreeInfo;
    }

    public String getDtmReg() {
        return dtmReg;
    }

    public void setDtmReg(String dtmReg) {
        this.dtmReg = dtmReg;
    }

    public String getIdReg() {
        return idReg;
    }

    public void setIdReg(String idReg) {
        this.idReg = idReg;
    }

    public String getYnEx() {
        return ynEx;
    }

    public void setYnEx(String ynEx) {
        this.ynEx = ynEx;
    }
    
    

}
