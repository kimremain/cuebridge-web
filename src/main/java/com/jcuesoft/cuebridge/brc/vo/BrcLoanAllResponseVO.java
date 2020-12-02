package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcLoanAllResponseVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = -7618623949774215128L;
    
    // 상태별 건수
    private String cntToday;
    private String cnt71001;
    private String cnt71002;
    private String cnt71003;
    private String cnt71004;
    private String cnt71006;
    private String cnt71013;
    
    public String getCntToday() {
        return cntToday;
    }

    public void setCntToday(String cntToday) {
        this.cntToday = cntToday;
    }

    public String getCnt71001() {
        return cnt71001;
    }

    public void setCnt71001(String cnt71001) {
        this.cnt71001 = cnt71001;
    }

    public String getCnt71002() {
        return cnt71002;
    }

    public void setCnt71002(String cnt71002) {
        this.cnt71002 = cnt71002;
    }

    public String getCnt71003() {
        return cnt71003;
    }

    public void setCnt71003(String cnt71003) {
        this.cnt71003 = cnt71003;
    }

    public String getCnt71004() {
        return cnt71004;
    }

    public void setCnt71004(String cnt71004) {
        this.cnt71004 = cnt71004;
    }

    public String getCnt71006() {
        return cnt71006;
    }

    public void setCnt71006(String cnt71006) {
        this.cnt71006 = cnt71006;
    }

    private String nmCustom;
    
    private String noCustom;
    
    private String customBirth;
    
    private String noSex;
    
    private String ynNiceSafekey;
    
    private String dsNiceSafekey;
    
    private String bexCount;
    
    public String getCustomBirth() {
        return customBirth;
    }

    public void setCustomBirth(String customBirth) {
        this.customBirth = customBirth;
    }

    public String getNmCustom() {
        return nmCustom;
    }

    public void setNmCustom(String nmCustom) {
        this.nmCustom = nmCustom;
    }

    public String getNoCustom() {
        return noCustom;
    }

    public void setNoCustom(String noCustom) {
        this.noCustom = noCustom;
    }

    private BigDecimal no;
 
    private String noReq;

    private String cdCooperate;

    private String noCooperate;

    private String cdPath;

    private String cdStatus;

    private String ynSurety;

    private String dtCbAgree;

    private String cdPdt;

    private String dd;

    private BigDecimal amCustom;

    private BigDecimal amCooperate;

    private BigDecimal amApp;

    private String cdUse;

    private String cdReject;

    private String cdEchanel;

    private String cdEportal;
 
    private String nmEkeyword;

    private String cdEpath;

    private String cdAuth;

    private String idReceive;

    private String idScreen;

    private String idAuth;

    private String dsReceive;

    private String dsScreen;

    private String dmReceive;

    private String dmScreen;

    private String dmAuth;

    private String dmPromise;

    private String dmReg;

    private String idReg;

    private String dmUpt;

    private String idUpt;

    private String dmContact;
    
    private String dsAssRank;
    
    private String cdTactic;
    
    private String receiveDiff;

    private String dmReject;
    
    private String cnSafekeyExt;
    
    private String cdRecruitGroup;

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

    public String getCdPath() {
        return cdPath;
    }

    public void setCdPath(String cdPath) {
        this.cdPath = cdPath;
    }

    public String getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
    }

    public String getYnSurety() {
        return ynSurety;
    }

    public void setYnSurety(String ynSurety) {
        this.ynSurety = ynSurety;
    }

    public String getDtCbAgree() {
        return dtCbAgree;
    }

    public void setDtCbAgree(String dtCbAgree) {
        this.dtCbAgree = dtCbAgree;
    }

    public String getCdPdt() {
        return cdPdt;
    }

    public void setCdPdt(String cdPdt) {
        this.cdPdt = cdPdt;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public BigDecimal getAmCustom() {
        return amCustom;
    }

    public void setAmCustom(BigDecimal amCustom) {
        this.amCustom = amCustom;
    }

    public BigDecimal getAmCooperate() {
        return amCooperate;
    }

    public void setAmCooperate(BigDecimal amCooperate) {
        this.amCooperate = amCooperate;
    }

    public BigDecimal getAmApp() {
        return amApp;
    }

    public void setAmApp(BigDecimal amApp) {
        this.amApp = amApp;
    }

    public String getCdUse() {
        return cdUse;
    }

    public void setCdUse(String cdUse) {
        this.cdUse = cdUse;
    }

    public String getCdReject() {
        return cdReject;
    }

    public void setCdReject(String cdReject) {
        this.cdReject = cdReject;
    }

    public String getCdEchanel() {
        return cdEchanel;
    }

    public void setCdEchanel(String cdEchanel) {
        this.cdEchanel = cdEchanel;
    }

    public String getCdEportal() {
        return cdEportal;
    }

    public void setCdEportal(String cdEportal) {
        this.cdEportal = cdEportal;
    }

    public String getNmEkeyword() {
        return nmEkeyword;
    }

    public void setNmEkeyword(String nmEkeyword) {
        this.nmEkeyword = nmEkeyword;
    }

    public String getCdEpath() {
        return cdEpath;
    }

    public void setCdEpath(String cdEpath) {
        this.cdEpath = cdEpath;
    }

    public String getCdAuth() {
        return cdAuth;
    }

    public void setCdAuth(String cdAuth) {
        this.cdAuth = cdAuth;
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

    public String getIdAuth() {
        return idAuth;
    }

    public void setIdAuth(String idAuth) {
        this.idAuth = idAuth;
    }

    public String getDsReceive() {
        return dsReceive;
    }

    public void setDsReceive(String dsReceive) {
        this.dsReceive = dsReceive;
    }

    public String getDsScreen() {
        return dsScreen;
    }

    public void setDsScreen(String dsScreen) {
        this.dsScreen = dsScreen;
    }

    public String getDmReceive() {
        return dmReceive;
    }

    public void setDmReceive(String dmReceive) {
        this.dmReceive = dmReceive;
    }

    public String getDmScreen() {
        return dmScreen;
    }

    public void setDmScreen(String dmScreen) {
        this.dmScreen = dmScreen;
    }

    public String getDmAuth() {
        return dmAuth;
    }

    public void setDmAuth(String dmAuth) {
        this.dmAuth = dmAuth;
    }

    public String getDmPromise() {
        return dmPromise;
    }

    public void setDmPromise(String dmPromise) {
        this.dmPromise = dmPromise;
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

    public String getDmContact() {
        return dmContact;
    }

    public void setDmContact(String dmContact) {
        this.dmContact = dmContact;
    }

    public String getYnNiceSafekey() {
        return ynNiceSafekey;
    }

    public void setYnNiceSafekey(String ynNiceSafekey) {
        this.ynNiceSafekey = ynNiceSafekey;
    }

    public String getNoSex() {
        return noSex;
    }

    public void setNoSex(String noSex) {
        this.noSex = noSex;
    }

    public String getBexCount() {
        return bexCount;
    }

    public void setBexCount(String bexCount) {
        this.bexCount = bexCount;
    }

    public String getDsNiceSafekey() {
        return dsNiceSafekey;
    }

    public void setDsNiceSafekey(String dsNiceSafekey) {
        this.dsNiceSafekey = dsNiceSafekey;
    }

    public String getDsAssRank() {
        return dsAssRank;
    }

    public void setDsAssRank(String dsAssRank) {
        this.dsAssRank = dsAssRank;
    }

    public String getCdTactic() {
        return cdTactic;
    }

    public void setCdTactic(String cdTactic) {
        this.cdTactic = cdTactic;
    }

    public String getReceiveDiff() {
        return receiveDiff;
    }

    public void setReceiveDiff(String receiveDiff) {
        this.receiveDiff = receiveDiff;
    }

    public String getDmReject() {
        return dmReject;
    }

    public void setDmReject(String dmReject) {
        this.dmReject = dmReject;
    }

    public String getCdRecruitGroup() {
        return cdRecruitGroup;
    }

    public void setCdRecruitGroup(String cdRecruitGroup) {
        this.cdRecruitGroup = cdRecruitGroup;
    }

    public String getCnSafekeyExt() {
        return cnSafekeyExt;
    }

    public void setCnSafekeyExt(String cnSafekeyExt) {
        this.cnSafekeyExt = cnSafekeyExt;
    }

    public String getCnt71013() {
        return cnt71013;
    }

    public void setCnt71013(String cnt71013) {
        this.cnt71013 = cnt71013;
    }
    
    
}
