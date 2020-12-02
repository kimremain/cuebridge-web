package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcLoanResponseVO extends BaseVO {

    private static final long serialVersionUID = -6370040550844634537L;

    private String noReq;

    private String cdStatus;
    
    private String nmStatus;

    private String nmCustom;

    private String cdPath;
    
    private String cdEpath;
    
    private String cdPathFlag;

    private String dsMemo;
    
    private String noTelMobile;
    
    private String idReceive;
    
    private String idScreen;
    
    private String dmPromise;
    
    private String dmContact;
    
    private BigDecimal amCustom;
    

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }

    public String getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
    }
    
    

    public String getNmStatus() {
        return nmStatus;
    }

    public void setNmStatus(String nmStatus) {
        this.nmStatus = nmStatus;
    }

    public String getNmCustom() {
        return nmCustom;
    }

    public void setNmCustom(String nmCustom) {
        this.nmCustom = nmCustom;
    }

    public String getCdPath() {
        return cdPath;
    }

    public void setCdPath(String cdPath) {
        this.cdPath = cdPath;
    }

    public String getCdPathFlag() {
        return cdPathFlag;
    }

    public void setCdPathFlag(String cdPathFlag) {
        this.cdPathFlag = cdPathFlag;
    }

    public String getDsMemo() {
        return dsMemo;
    }

    public void setDsMemo(String dsMemo) {
        this.dsMemo = dsMemo;
    }

    public String getNoTelMobile() {
        return noTelMobile;
    }

    public void setNoTelMobile(String noTelMobile) {
        this.noTelMobile = noTelMobile;
    }

    public String getIdReceive() {
        return idReceive;
    }

    public void setIdReceive(String idReceive) {
        this.idReceive = idReceive;
    }

    public String getDmPromise() {
        return dmPromise;
    }

    public void setDmPromise(String dmPromise) {
        this.dmPromise = dmPromise;
    }

    public String getDmContact() {
        return dmContact;
    }

    public void setDmContact(String dmContact) {
        this.dmContact = dmContact;
    }

    public BigDecimal getAmCustom() {
        return amCustom;
    }

    public void setAmCustom(BigDecimal amCustom) {
        this.amCustom = amCustom;
    }

    public String getIdScreen() {
        return idScreen;
    }

    public void setIdScreen(String idScreen) {
        this.idScreen = idScreen;
    }

    public String getCdEpath() {
        return cdEpath;
    }

    public void setCdEpath(String cdEpath) {
        this.cdEpath = cdEpath;
    }

}
