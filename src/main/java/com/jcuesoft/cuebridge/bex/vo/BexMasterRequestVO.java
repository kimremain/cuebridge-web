package com.jcuesoft.cuebridge.bex.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BexMasterRequestVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = 8747168783799819705L;

    private String searchNoReq;
    
    private String searchDmScreenStart; // 상담완료일시
    
    private String searchDmScreenEnd;
    
    private String searchDmCooperteStart; // 대출승인일시
    
    private String searchDmCooperteEnd;
    
    private String searchDmUptStart;// 심사완료일시
    
    private String searchDmUptEnd;
    
    private String searchDmRegStart; // 심사 실행일시
    
    private String searchDmRegEnd;
    
    private String searchCdPath; // 접수경로
    
    private String searchCdCooperate;// 거래처코드
    
    private String logDsRemk;
    
    public String getSearchDmScreenStart() {
        return searchDmScreenStart;
    }

    public void setSearchDmScreenStart(String searchDmScreenStart) {
        this.searchDmScreenStart = searchDmScreenStart;
    }
    public String getSearchDmScreenEnd() {
       
        return searchDmScreenEnd;
    }

    public void setSearchDmScreenEnd(String searchDmScreenEnd) {
        this.searchDmScreenEnd = searchDmScreenEnd;
    }

    public String getSearchDmCooperteStart() {
        return searchDmCooperteStart;
    }

    public void setSearchDmCooperteStart(String searchDmCooperteStart) {
        this.searchDmCooperteStart = searchDmCooperteStart;
    }

    public String getSearchDmCooperteEnd() {
        return searchDmCooperteEnd;
    }

    public void setSearchDmCooperteEnd(String searchDmCooperteEnd) {
        this.searchDmCooperteEnd = searchDmCooperteEnd;
    }
    
    public String getSearchDmRegStart() {
        return searchDmRegStart;
    }

    public void setSearchDmRegStart(String searchDmRegStart) {
        this.searchDmRegStart = searchDmRegStart;
    }

    public String getSearchDmRegEnd() {
        return searchDmRegEnd;
    }

    public void setSearchDmRegEnd(String searchDmRegEnd) {
        this.searchDmRegEnd = searchDmRegEnd;
    }

    /* BEX_MASTER getter/setter */ 

    private BigDecimal no;

    private String noReq;

    private String noEx;

    private String cdCooperate;

    private String noCooperate;

    private String noCooperateAct;

    private String cdScreen;

    private String cdPdt;

    private String dmCooperate;

    private BigDecimal amCooperate;

    private String dsCooperate;

    private Date dmReg;

    private String idReg;

    private Date dmUpt;

    private String idUpt;
    
    private String nmScreenPath;

    private String nmScreen;

    private BigDecimal amApp;
    
    private BigDecimal amCooperateExpect; 
    
    private String ynPartnerAct;
    
    private String cdCooperatePartner;
    
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

    public Date getDmReg() {
        return dmReg;
    }

    public void setDmReg(Date dmReg) {
        this.dmReg = dmReg;
    }

    public Date getDmUpt() {
        return dmUpt;
    }

    public void setDmUpt(Date dmUpt) {
        this.dmUpt = dmUpt;
    }

    public String getNmScreenPath() {
        return nmScreenPath;
    }

    public void setNmScreenPath(String nmScreenPath) {
        this.nmScreenPath = nmScreenPath;
    }

    public String getNmScreen() {
        return nmScreen;
    }

    public void setNmScreen(String nmScreen) {
        this.nmScreen = nmScreen;
    }

    public BigDecimal getAmApp() {
        return amApp;
    }

    public void setAmApp(BigDecimal amApp) {
        this.amApp = amApp;
    }

    public String getDmCooperate() {
        return dmCooperate;
    }

    public void setDmCooperate(String dmCooperate) {
        this.dmCooperate = dmCooperate;
    }

    public String getSearchDmUptStart() {
        return searchDmUptStart;
    }

    public void setSearchDmUptStart(String searchDmUptStart) {
        this.searchDmUptStart = searchDmUptStart;
    }

    public String getSearchDmUptEnd() {
        return searchDmUptEnd;
    }

    public void setSearchDmUptEnd(String searchDmUptEnd) {
        this.searchDmUptEnd = searchDmUptEnd;
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

    public String getSearchCdPath() {
        return searchCdPath;
    }

    public void setSearchCdPath(String searchCdPath) {
        this.searchCdPath = searchCdPath;
    }

    public String getSearchCdCooperate() {
        return searchCdCooperate;
    }

    public void setSearchCdCooperate(String searchCdCooperate) {
        this.searchCdCooperate = searchCdCooperate;
    }

    public String getLogDsRemk() {
        return logDsRemk;
    }

    public void setLogDsRemk(String logDsRemk) {
        this.logDsRemk = logDsRemk;
    }

    public BigDecimal getAmCooperateExpect() {
        return amCooperateExpect;
    }

    public void setAmCooperateExpect(BigDecimal amCooperateExpect) {
        this.amCooperateExpect = amCooperateExpect;
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

    public String getSearchNoReq() {
        return searchNoReq;
    }

    public void setSearchNoReq(String searchNoReq) {
        this.searchNoReq = searchNoReq;
    }

}
