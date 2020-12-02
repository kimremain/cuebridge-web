package com.jcuesoft.cuebridge.bex.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BexMasterResponseVO extends BaseVO {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2475530403256174016L;

    private BigDecimal no;

    private String noReq;
    
    private String noCustomHash;

    private String noEx;
    
    private String ynPartnerAct;
    
    private String cdCooperatePartner;

    private String cdCooperate;

    private String noCooperate;

    private String noCooperateAct;

    private String cdScreen;

    private String cdPdt;

    private String dmCooperate;

    private BigDecimal amCooperate;
    
    private BigDecimal amCooperateExpect;

    private String dsCooperate;

    private String dmReg;

    private String idReg;

    private String dmUpt;

    private String idUpt;

    private String nmScreenPath;
  
    private String nmBexPdt;
    
    private String nmScreen;

    private BigDecimal amApp;

    private String contactCnt; // 메모건수 
    
    private String nmCustom;
    
    private String noCustom;    
    
    //------------//
    private String nmPdt;
    private String cdPath;
    private String idScreen;
    private String nmIdScreen;
    private String dmScreen;
    private String dmReceive;
    
    public String getNmPdt() {
        return nmPdt;
    }

    public void setNmPdt(String nmPdt) {
        this.nmPdt = nmPdt;
    }

    public String getNmCustom() {
        return nmCustom;
    }
    
    public void setNmCustom(String nmCustom) {
        this.nmCustom = nmCustom;
    }
   
    public String getIdScreen() {
        return idScreen;
    }

    public void setIdScreen(String idScreen) {
        this.idScreen = idScreen;
    }
    
    public String getNmScreen() {
        return nmScreen;
    }
    
    public void setNmScreen(String nmScreen) {
        this.nmScreen = nmScreen;
    }

    public String getDmScreen() {
        return dmScreen;
    }

    public void setDmScreen(String dmScreen) {
        this.dmScreen = dmScreen;
    }
    
    
    
    //------------//
    
    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }

    public String getNoEx() {
        return noEx;
    }

    public void setNoEx(String noEx) {
        this.noEx = noEx;
    }

    public String getCdCooperate() {
        return cdCooperate;
    }

    public void setCdCooperate(String cdCooperate) {
        this.cdCooperate = cdCooperate;
    }

    public String getNoCooperate() {
        return noCooperate;
    }

    public void setNoCooperate(String noCooperate) {
        this.noCooperate = noCooperate;
    }

    public String getNoCooperateAct() {
        return noCooperateAct;
    }

    public void setNoCooperateAct(String noCooperateAct) {
        this.noCooperateAct = noCooperateAct;
    }

    public String getCdScreen() {
        return cdScreen;
    }

    public void setCdScreen(String cdScreen) {
        this.cdScreen = cdScreen;
    }

    public String getCdPdt() {
        return cdPdt;
    }

    public void setCdPdt(String cdPdt) {
        this.cdPdt = cdPdt;
    }

    public String getDmCooperate() {
        return dmCooperate;
    }

    public void setDmCooperate(String dmCooperate) {
        this.dmCooperate = dmCooperate;
    }

    public BigDecimal getAmCooperate() {
        return amCooperate;
    }

    public void setAmCooperate(BigDecimal amCooperate) {
        this.amCooperate = amCooperate;
    }

    public String getDsCooperate() {
        return dsCooperate;
    }

    public void setDsCooperate(String dsCooperate) {
        this.dsCooperate = dsCooperate;
    }

    public String getDmReg() {
        return dmReg;
    }

    public void setDmReg(String dmReg) {
        this.dmReg = dmReg;
    }

    public String getIdReg() {
        return idReg;
    }

    public void setIdReg(String idReg) {
        this.idReg = idReg;
    }

    public String getDmUpt() {
        return dmUpt;
    }

    public void setDmUpt(String dmUpt) {
        this.dmUpt = dmUpt;
    }

    public String getIdUpt() {
        return idUpt;
    }

    public void setIdUpt(String idUpt) {
        this.idUpt = idUpt;
    }

    public String getNmScreenPath() {
        return nmScreenPath;
    }

    public void setNmScreenPath(String nmScreenPath) {
        this.nmScreenPath = nmScreenPath;
    }

    public BigDecimal getAmApp() {
        return amApp;
    }

    public void setAmApp(BigDecimal amApp) {
        this.amApp = amApp;
    }

    public String getNmIdScreen() {
        return nmIdScreen;
    }

    public void setNmIdScreen(String nmIdScreen) {
        this.nmIdScreen = nmIdScreen;
    }

    public String getContactCnt() {
        return contactCnt;
    }

    public void setContactCnt(String contactCnt) {
        this.contactCnt = contactCnt;
    }

    public String getCdPath() {
        return cdPath;
    }

    public void setCdPath(String cdPath) {
        this.cdPath = cdPath;
    }

    public String getDmReceive() {
        return dmReceive;
    }

    public void setDmReceive(String dmReceive) {
        this.dmReceive = dmReceive;
    }

    public String getNmBexPdt() {
        return nmBexPdt;
    }

    public void setNmBexPdt(String nmBexPdt) {
        this.nmBexPdt = nmBexPdt;
    }

    public BigDecimal getAmCooperateExpect() {
        return amCooperateExpect;
    }

    public void setAmCooperateExpect(BigDecimal amCooperateExpect) {
        this.amCooperateExpect = amCooperateExpect;
    }

    public String getNoCustomHash() {
        return noCustomHash;
    }

    public void setNoCustomHash(String noCustomHash) {
        this.noCustomHash = noCustomHash;
    }

    public String getYnPartnerAct() {
        return ynPartnerAct;
    }

    public void setYnPartnerAct(String ynPartnerAct) {
        this.ynPartnerAct = ynPartnerAct;
    }

    public String getCdCooperatePartner() {
        return cdCooperatePartner;
    }

    public void setCdCooperatePartner(String cdCooperatePartner) {
        this.cdCooperatePartner = cdCooperatePartner;
    }

    public String getNoCustom() {
        return noCustom;
    }

    public void setNoCustom(String noCustom) {
        this.noCustom = noCustom;
    }
    
}
