package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcLoanInfoResponseVO extends BaseVO{

    /**
     * 
     */
    private static final long serialVersionUID = -7854752597902702573L;
    
    private BigDecimal cnSurety;
    
    private String noReq;
    
    private String cdPath;
    
    private String cdStatus;
    
    private String dtCbAgree;
    
    private String cdPdt;
    
    private BigDecimal amCustom;
    
    private String cdReject;

    private String cdCancel;
    
    private String nmEkeyword;
    
    private String idScreen;
    
    private String cdAuth;
    
    private Date dmPromise;
    
    private String dmPromiseYMD;
    
    private String dmPromiseHH;
    
    private String dmPromiseMI;
    
    private String noCustom;
    
    private String nmCustom;
    
    private String dsEmail;
    
    private String dsScreen;
    
    private String cdMarry;
    
    private String cdKndMobile;
    
    private String  noSurety;
    
    private String  noTelMobileAll;
    
    private String noTel1Mobile;
    
    private String noTel2Mobile;
    
    private String noTel3Mobile;
    
    private String ynNiceSafekey;

    private String dsNiceSafekey;
    
    private BigDecimal cnSafekeyExt; 
    
    private String dsCooperate;
    
    private String ynCdtInquiry;
    
    private String dsAccessIp;
    
    private String cdRecruitGroup;
    
    private String noPostRealFront;
    
    private String noPostRealRear;
    
    private String dsStrtReal;
    
    private String dsAddrReal;
    
    private String dsCntCb;
    private String dsAmtCb;
    private String ds1stRank;
    private String ds2ndRank;
    private String dsPiRank;
    private String dsAssRank;
    private String cdTactic;
    private String cdTacticLimit;
    
    // BRC_CUSTOM_COMPANY
    private String cdJobKind;
    private String cdJobAct;
    private String cdJobStatus;
    private String nmComp;
    private String nmDept;
    private String cdRank;
    private String dtRegJoin;
    private String amPayMonth;
    private String noMaintel1Comp;
    private String noMaintel2Comp;
    private String noMaintel3Comp;
    
    
    
    
    public String getCdJobAct() {
        return cdJobAct;
    }

    public void setCdJobAct(String cdJobAct) {
        this.cdJobAct = cdJobAct;
    }

    public String getCdJobStatus() {
        return cdJobStatus;
    }

    public void setCdJobStatus(String cdJobStatus) {
        this.cdJobStatus = cdJobStatus;
    }

    public String getNmComp() {
        return nmComp;
    }

    public void setNmComp(String nmComp) {
        this.nmComp = nmComp;
    }

    public String getNmDept() {
        return nmDept;
    }

    public void setNmDept(String nmDept) {
        this.nmDept = nmDept;
    }

    public String getCdRank() {
        return cdRank;
    }

    public void setCdRank(String cdRank) {
        this.cdRank = cdRank;
    }

    public String getDtRegJoin() {
        return dtRegJoin;
    }

    public void setDtRegJoin(String dtRegJoin) {
        this.dtRegJoin = dtRegJoin;
    }

    public String getAmPayMonth() {
        return amPayMonth;
    }

    public void setAmPayMonth(String amPayMonth) {
        this.amPayMonth = amPayMonth;
    }

    public String getNoMaintel1Comp() {
        return noMaintel1Comp;
    }

    public void setNoMaintel1Comp(String noMaintel1Comp) {
        this.noMaintel1Comp = noMaintel1Comp;
    }

    public String getNoMaintel2Comp() {
        return noMaintel2Comp;
    }

    public void setNoMaintel2Comp(String noMaintel2Comp) {
        this.noMaintel2Comp = noMaintel2Comp;
    }

    public String getNoMaintel3Comp() {
        return noMaintel3Comp;
    }

    public void setNoMaintel3Comp(String noMaintel3Comp) {
        this.noMaintel3Comp = noMaintel3Comp;
    }

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
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

    public BigDecimal getAmCustom() {
        return amCustom;
    }

    public void setAmCustom(BigDecimal amCustom) {
        this.amCustom = amCustom;
    }

    public String getNmEkeyword() {
        return nmEkeyword;
    }

    public void setNmEkeyword(String nmEkeyword) {
        this.nmEkeyword = nmEkeyword;
    }

    public String getCdAuth() {
        return cdAuth;
    }

    public void setCdAuth(String cdAuth) {
        this.cdAuth = cdAuth;
    }

    public Date getDmPromise() {
        return dmPromise;
    }

    public void setDmPromise(Date dmPromise) {
        this.dmPromise = dmPromise;
    }

    public String getNoCustom() {
        return noCustom;
    }

    public void setNoCustom(String noCustom) {
        this.noCustom = noCustom;
    }

    public String getNmCustom() {
        return nmCustom;
    }

    public void setNmCustom(String nmCustom) {
        this.nmCustom = nmCustom;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getCdMarry() {
        return cdMarry;
    }

    public void setCdMarry(String cdMarry) {
        this.cdMarry = cdMarry;
    }

    public String getCdKndMobile() {
        return cdKndMobile;
    }

    public void setCdKndMobile(String cdKndMobile) {
        this.cdKndMobile = cdKndMobile;
    }

    public String getNoTel1Mobile() {
        return noTel1Mobile;
    }

    public void setNoTel1Mobile(String noTel1Mobile) {
        this.noTel1Mobile = noTel1Mobile;
    }

    public String getNoTel2Mobile() {
        return noTel2Mobile;
    }

    public void setNoTel2Mobile(String noTel2Mobile) {
        this.noTel2Mobile = noTel2Mobile;
    }

    public String getNoTel3Mobile() {
        return noTel3Mobile;
    }

    public void setNoTel3Mobile(String noTel3Mobile) {
        this.noTel3Mobile = noTel3Mobile;
    }

    public String getCdJobKind() {
        return cdJobKind;
    }

    public void setCdJobKind(String cdJobKind) {
        this.cdJobKind = cdJobKind;
    }

    public String getCdReject() {
        return cdReject;
    }

    public void setCdReject(String cdReject) {
        this.cdReject = cdReject;
    }

    public String getDmPromiseYMD() {
        return dmPromiseYMD;
    }

    public void setDmPromiseYMD(String dmPromiseYMD) {
        this.dmPromiseYMD = dmPromiseYMD;
    }

    public String getDmPromiseHH() {
        return dmPromiseHH;
    }

    public void setDmPromiseHH(String dmPromiseHH) {
        this.dmPromiseHH = dmPromiseHH;
    }

    public String getDmPromiseMI() {
        return dmPromiseMI;
    }

    public void setDmPromiseMI(String dmPromiseMI) {
        this.dmPromiseMI = dmPromiseMI;
    }

    public BigDecimal getCnSurety() {
        return cnSurety;
    }

    public void setCnSurety(BigDecimal cnSurety) {
        this.cnSurety = cnSurety;
    }

    public String getYnNiceSafekey() {
        return ynNiceSafekey;
    }

    public void setYnNiceSafekey(String ynNiceSafekey) {
        this.ynNiceSafekey = ynNiceSafekey;
    }

    public String getDsNiceSafekey() {
        return dsNiceSafekey;
    }

    public void setDsNiceSafekey(String dsNiceSafekey) {
        this.dsNiceSafekey = dsNiceSafekey;
    }

    public String getCdCancel() {
        return cdCancel;
    }

    public void setCdCancel(String cdCancel) {
        this.cdCancel = cdCancel;
    }

    public String getDsScreen() {
        return dsScreen;
    }

    public void setDsScreen(String dsScreen) {
        this.dsScreen = dsScreen;
    }

    public String getIdScreen() {
        return idScreen;
    }

    public void setIdScreen(String idScreen) {
        this.idScreen = idScreen;
    }

    public String getDsCntCb() {
        return dsCntCb;
    }

    public void setDsCntCb(String dsCntCb) {
        this.dsCntCb = dsCntCb;
    }

    public String getDsAmtCb() {
        return dsAmtCb;
    }

    public void setDsAmtCb(String dsAmtCb) {
        this.dsAmtCb = dsAmtCb;
    }

    public String getDs1stRank() {
        return ds1stRank;
    }

    public void setDs1stRank(String ds1stRank) {
        this.ds1stRank = ds1stRank;
    }

    public String getDs2ndRank() {
        return ds2ndRank;
    }

    public void setDs2ndRank(String ds2ndRank) {
        this.ds2ndRank = ds2ndRank;
    }

    public String getDsPiRank() {
        return dsPiRank;
    }

    public void setDsPiRank(String dsPiRank) {
        this.dsPiRank = dsPiRank;
    }

    public String getCdTactic() {
        return cdTactic;
    }

    public void setCdTactic(String cdTactic) {
        this.cdTactic = cdTactic;
    }

    public String getCdTacticLimit() {
        return cdTacticLimit;
    }

    public void setCdTacticLimit(String cdTacticLimit) {
        this.cdTacticLimit = cdTacticLimit;
    }

    public String getDsAssRank() {
        return dsAssRank;
    }

    public void setDsAssRank(String dsAssRank) {
        this.dsAssRank = dsAssRank;
    }

    public String getDsCooperate() {
        return dsCooperate;
    }

    public void setDsCooperate(String dsCooperate) {
        this.dsCooperate = dsCooperate;
    }

    public String getNoTelMobileAll() {
        return noTelMobileAll;
    }

    public void setNoTelMobileAll(String noTelMobileAll) {
        this.noTelMobileAll = noTelMobileAll;
    }

    public String getNoSurety() {
        return noSurety;
    }

    public void setNoSurety(String noSurety) {
        this.noSurety = noSurety;
    }

    public String getYnCdtInquiry() {
        return ynCdtInquiry;
    }

    public void setYnCdtInquiry(String ynCdtInquiry) {
        this.ynCdtInquiry = ynCdtInquiry;
    }

    public String getDsAccessIp() {
        return dsAccessIp;
    }

    public void setDsAccessIp(String dsAccessIp) {
        this.dsAccessIp = dsAccessIp;
    }

    public String getNoPostRealFront() {
        return noPostRealFront;
    }

    public void setNoPostRealFront(String noPostRealFront) {
        this.noPostRealFront = noPostRealFront;
    }

    public String getNoPostRealRear() {
        return noPostRealRear;
    }

    public void setNoPostRealRear(String noPostRealRear) {
        this.noPostRealRear = noPostRealRear;
    }

    public String getDsStrtReal() {
        return dsStrtReal;
    }

    public void setDsStrtReal(String dsStrtReal) {
        this.dsStrtReal = dsStrtReal;
    }

    public String getDsAddrReal() {
        return dsAddrReal;
    }

    public void setDsAddrReal(String dsAddrReal) {
        this.dsAddrReal = dsAddrReal;
    }

    public String getCdRecruitGroup() {
        return cdRecruitGroup;
    }

    public void setCdRecruitGroup(String cdRecruitGroup) {
        this.cdRecruitGroup = cdRecruitGroup;
    }

    public BigDecimal getCnSafekeyExt() {
        return cnSafekeyExt;
    }

    public void setCnSafekeyExt(BigDecimal cnSafekeyExt) {
        this.cnSafekeyExt = cnSafekeyExt;
    }
    
    
    
}
