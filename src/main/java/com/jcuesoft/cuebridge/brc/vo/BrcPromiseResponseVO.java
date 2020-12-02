package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcPromiseResponseVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = -4903090630992908629L;
    
    private String noReq;
    private String dmPromise;
    private String idReceive;
    private String idScreen;
    
    private String nmCustom;
    private BigDecimal amApp;
    private String cdStatus;
    private String dmContact;
    private String dmReceive;
    
    public String getNoReq() {
        return noReq;
    }
    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }
    public String getDmPromise() {
        return dmPromise;
    }
    public void setDmPromise(String dmPromise) {
        this.dmPromise = dmPromise;
    }
    public String getIdReceive() {
        return idReceive;
    }
    public void setIdReceive(String idReceive) {
        this.idReceive = idReceive;
    }
    public String getIdScreen() {
        return idScreen;
    }
    public void setIdScreen(String idScreen) {
        this.idScreen = idScreen;
    }
    public String getNmCustom() {
        return nmCustom;
    }
    public void setNmCustom(String nmCustom) {
        this.nmCustom = nmCustom;
    }
    public BigDecimal getAmApp() {
        return amApp;
    }
    public void setAmApp(BigDecimal amApp) {
        this.amApp = amApp;
    }
    public String getCdStatus() {
        return cdStatus;
    }
    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
    }
    public String getDmContact() {
        return dmContact;
    }
    public void setDmContact(String dmContact) {
        this.dmContact = dmContact;
    }
    public String getDmReceive() {
        return dmReceive;
    }
    public void setDmReceive(String dmReceive) {
        this.dmReceive = dmReceive;
    }
}
