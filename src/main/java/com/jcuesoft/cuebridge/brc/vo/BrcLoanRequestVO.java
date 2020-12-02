package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcLoanRequestVO extends BaseVO {

    private static final long serialVersionUID = 3343641961920283544L;
    
    private String updateBatchNo[];

    private String updateCdStatus;
    
    private String updateCdReject;
    
    private String updateCdCancel;
    
    private String updateIdScreen;
    
    private String searchNoReq;
    
    private String searchNoSurety;
    
    private String searchCdStatus;
    
    private String searchNmCustom;
    
    private String searchNoCustom;
    
    private String searchNoTelMobile; 
    
    private String searchContactNoReq;
    
    private String noReq;

    private String idReg;

    private String leftSearchId;

    private String cdPath;

    private String cdPdt;

    private String nmCustom;

    private String noTelMobile;
    
    private String noTel1Mobile;

    private String noTel2Mobile;

    private String noTel3Mobile;

    private String noCustom1;

    private String noCustom2;

    private String dsEmail;

    private String dsEmail1;

    private String dsEmail2;

    private String cdMarry;

    private String cdJobKind;

    private String amCustom;

    private String cdStatus;
    
    private String dtCbAgree;
    
    private String cdReject;
    
    private String cdCancel;
    
    private String nmEkeyword;
    
    private String cdAuth;
    
    private String dmPromise;
    
    private String dmPromiseYMD;
    
    private String dmPromiseHH;
    
    private String dmPromiseMI;
    
    private String noCustom;
    
    private String cdKndMobile;
    
    private String beforeCdStatus;
    
    private String dsCooperate;
    
    private String ynCdtInquiry;
    
    private String noPostRealFront;
    
    private String noPostRealRear;
    
    private String dsStrtReal;
    
    private String dsAddrReal;
    
    private String cdRecruitGroup;
    
    /* brc_loan 현재미사용 필드   */
    private String cdCooperate;
    private String noCooperate;
    private String ynSurety;
    private String dd;
    private BigDecimal amCooperate;
    private BigDecimal amApp;
    private String cdUse;
    private String cdEchanel;
    private String cdEportal;
    private String cdEpath;
    private String idReceive;
    private String idScreen;
    private String idAuth;
    private String dsReceive;
    private String dsScreen;
    private Date dmReceive;
    private Date dmScreen;
    private Date dmAuth;
    private Date dmReg;
    private Date dmUpt;
    private String idUpt;

    /* brc_custom 현재미사용 필드   */
    private String cdBank;
    private String noBankAct;
    private String ynAuthMobile;
    private String cdKndEtc;
    private String noTel1Etc1;
    private String noTel2Etc1;
    private String noTel3Etc1;
    private String ynAuthEtc;
    private String ynNiceSafekey;
    private String noFax1;
    private String noFax2;
    private String noFax3;

    /* brc_custom_company 현재미사용 필드   */
    private String cdRank;
    private String cdJobAct;
    private String cdJobStatus;
    private String nmComp;
    private String nmDept;
    private String dtRegJoin;
    private String ddPay;
    private BigDecimal amPayMonth;
    private String noPostComp;
    private String dsStrtComp;
    private String dsAddrComp;
    private String noTel1Comp;
    private String noTel2Comp;
    private String noTel3Comp;
    private String noExtComp;
    private String noMaintel1Comp;
    private String noMaintel2Comp;
    private String noMaintel3Comp;    

    /*페이징변수*/
    private int page ;    
    private int limit ;    
    private String sort ;    
    private String dir ;    

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }

    public String getIdReg() {
        return idReg;
    }

    public void setIdReg(String idReg) {
        this.idReg = idReg;
    }

    public String getCdPath() {
        return cdPath;
    }

    public void setCdPath(String cdPath) {
        this.cdPath = cdPath;
    }

    public String getCdPdt() {
        return cdPdt;
    }

    public void setCdPdt(String cdPdt) {
        this.cdPdt = cdPdt;
    }

    public String getNmCustom() {
        return nmCustom;
    }

    public void setNmCustom(String nmCustom) {
        this.nmCustom = nmCustom;
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

    public String getNoCustom1() {
        return noCustom1;
    }

    public void setNoCustom1(String noCustom1) {
        this.noCustom1 = noCustom1;
    }

    public String getNoCustom2() {
        return noCustom2;
    }

    public void setNoCustom2(String noCustom2) {
        this.noCustom2 = noCustom2;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsEmail1() {
        return dsEmail1;
    }

    public void setDsEmail1(String dsEmail1) {
        this.dsEmail1 = dsEmail1;
    }

    public String getDsEmail2() {
        return dsEmail2;
    }

    public void setDsEmail2(String dsEmail2) {
        this.dsEmail2 = dsEmail2;
    }

    public String getCdMarry() {
        return cdMarry;
    }

    public void setCdMarry(String cdMarry) {
        this.cdMarry = cdMarry;
    }

    public String getCdJobKind() {
        return cdJobKind;
    }

    public void setCdJobKind(String cdJobKind) {
        this.cdJobKind = cdJobKind;
    }

    public String getAmCustom() {
        return amCustom;
    }

    public void setAmCustom(String amCustom) {
        this.amCustom = amCustom;
    }

    public String getSearchNoReq() {
        return searchNoReq;
    }

    public void setSearchNoReq(String searchNoReq) {
        this.searchNoReq = searchNoReq;
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

    public String getCdReject() {
        return cdReject;
    }

    public void setCdReject(String cdReject) {
        this.cdReject = cdReject;
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

    public String getDmPromise() {
        return dmPromise;
    }

    public void setDmPromise(String dmPromise) {
        this.dmPromise = dmPromise;
    }

    public String getNoCustom() {
        return noCustom;
    }

    public void setNoCustom(String noCustom) {
        this.noCustom = noCustom;
    }

    public String getCdKndMobile() {
        return cdKndMobile;
    }

    public void setCdKndMobile(String cdKndMobile) {
        this.cdKndMobile = cdKndMobile;
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

    public String getYnSurety() {
        return ynSurety;
    }

    public void setYnSurety(String ynSurety) {
        this.ynSurety = ynSurety;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
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

    public String getCdEpath() {
        return cdEpath;
    }

    public void setCdEpath(String cdEpath) {
        this.cdEpath = cdEpath;
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

    public String getIdUpt() {
        return idUpt;
    }

    public void setIdUpt(String idUpt) {
        this.idUpt = idUpt;
    }

    public String getCdBank() {
        return cdBank;
    }

    public void setCdBank(String cdBank) {
        this.cdBank = cdBank;
    }

    public String getNoBankAct() {
        return noBankAct;
    }

    public void setNoBankAct(String noBankAct) {
        this.noBankAct = noBankAct;
    }

    public String getYnAuthMobile() {
        return ynAuthMobile;
    }

    public void setYnAuthMobile(String ynAuthMobile) {
        this.ynAuthMobile = ynAuthMobile;
    }

    public String getCdKndEtc() {
        return cdKndEtc;
    }

    public void setCdKndEtc(String cdKndEtc) {
        this.cdKndEtc = cdKndEtc;
    }

    public String getNoTel1Etc1() {
        return noTel1Etc1;
    }

    public void setNoTel1Etc1(String noTel1Etc1) {
        this.noTel1Etc1 = noTel1Etc1;
    }

    public String getNoTel2Etc1() {
        return noTel2Etc1;
    }

    public void setNoTel2Etc1(String noTel2Etc1) {
        this.noTel2Etc1 = noTel2Etc1;
    }

    public String getNoTel3Etc1() {
        return noTel3Etc1;
    }

    public void setNoTel3Etc1(String noTel3Etc1) {
        this.noTel3Etc1 = noTel3Etc1;
    }

    public String getYnAuthEtc() {
        return ynAuthEtc;
    }

    public void setYnAuthEtc(String ynAuthEtc) {
        this.ynAuthEtc = ynAuthEtc;
    }

    public String getNoFax1() {
        return noFax1;
    }

    public void setNoFax1(String noFax1) {
        this.noFax1 = noFax1;
    }

    public String getNoFax2() {
        return noFax2;
    }

    public void setNoFax2(String noFax2) {
        this.noFax2 = noFax2;
    }

    public String getNoFax3() {
        return noFax3;
    }

    public void setNoFax3(String noFax3) {
        this.noFax3 = noFax3;
    }

    public String getCdRank() {
        return cdRank;
    }

    public void setCdRank(String cdRank) {
        this.cdRank = cdRank;
    }

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

    public String getDtRegJoin() {
        return dtRegJoin;
    }

    public void setDtRegJoin(String dtRegJoin) {
        this.dtRegJoin = dtRegJoin;
    }

    public String getDdPay() {
        return ddPay;
    }

    public void setDdPay(String ddPay) {
        this.ddPay = ddPay;
    }

    public BigDecimal getAmPayMonth() {
        return amPayMonth;
    }

    public void setAmPayMonth(BigDecimal amPayMonth) {
        this.amPayMonth = amPayMonth;
    }

    public String getNoPostComp() {
        return noPostComp;
    }

    public void setNoPostComp(String noPostComp) {
        this.noPostComp = noPostComp;
    }

    public String getDsStrtComp() {
        return dsStrtComp;
    }

    public void setDsStrtComp(String dsStrtComp) {
        this.dsStrtComp = dsStrtComp;
    }

    public String getDsAddrComp() {
        return dsAddrComp;
    }

    public void setDsAddrComp(String dsAddrComp) {
        this.dsAddrComp = dsAddrComp;
    }

    public String getNoTel1Comp() {
        return noTel1Comp;
    }

    public void setNoTel1Comp(String noTel1Comp) {
        this.noTel1Comp = noTel1Comp;
    }

    public String getNoTel2Comp() {
        return noTel2Comp;
    }

    public void setNoTel2Comp(String noTel2Comp) {
        this.noTel2Comp = noTel2Comp;
    }

    public String getNoTel3Comp() {
        return noTel3Comp;
    }

    public void setNoTel3Comp(String noTel3Comp) {
        this.noTel3Comp = noTel3Comp;
    }

    public String getNoExtComp() {
        return noExtComp;
    }

    public void setNoExtComp(String noExtComp) {
        this.noExtComp = noExtComp;
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

    public String getNoMaintel3Comp() {
        return noMaintel3Comp;
    }

    public void setNoMaintel3Comp(String noMaintel3Comp) {
        this.noMaintel3Comp = noMaintel3Comp;
    }

    public String getSearchNoSurety() {
        return searchNoSurety;
    }

    public void setSearchNoSurety(String searchNoSurety) {
        this.searchNoSurety = searchNoSurety;
    }

    public String getNoTelMobile() {
        return noTelMobile;
    }

    public void setNoTelMobile(String noTelMobile) {
        this.noTelMobile = noTelMobile;
    }

    public String getSearchCdStatus() {
        return searchCdStatus;
    }

    public void setSearchCdStatus(String searchCdStatus) {
        this.searchCdStatus = searchCdStatus;
    }

    public String getSearchNmCustom() {
        return searchNmCustom;
    }

    public void setSearchNmCustom(String searchNmCustom) {
        this.searchNmCustom = searchNmCustom;
    }

    public String getSearchNoCustom() {
        return searchNoCustom;
    }

    public void setSearchNoCustom(String searchNoCustom) {
        this.searchNoCustom = searchNoCustom;
    }

    public String getSearchNoTelMobile() {
        return searchNoTelMobile;
    }

    public void setSearchNoTelMobile(String searchNoTelMobile) {
        this.searchNoTelMobile = searchNoTelMobile;
    }

    public String getSearchContactNoReq() {
        return searchContactNoReq;
    }

    public void setSearchContactNoReq(String searchContactNoReq) {
        this.searchContactNoReq = searchContactNoReq;
    }

    public String getUpdateCdStatus() {
        return updateCdStatus;
    }

    public void setUpdateCdStatus(String updateCdStatus) {
        this.updateCdStatus = updateCdStatus;
    }

    public String getUpdateIdScreen() {
        return updateIdScreen;
    }

    public void setUpdateIdScreen(String updateIdScreen) {
        this.updateIdScreen = updateIdScreen;
    }

    public Date getDmReceive() {
        return dmReceive;
    }

    public void setDmReceive(Date dmReceive) {
        this.dmReceive = dmReceive;
    }

    public Date getDmScreen() {
        return dmScreen;
    }

    public void setDmScreen(Date dmScreen) {
        this.dmScreen = dmScreen;
    }

    public Date getDmAuth() {
        return dmAuth;
    }

    public void setDmAuth(Date dmAuth) {
        this.dmAuth = dmAuth;
    }

    public String getYnNiceSafekey() {
        return ynNiceSafekey;
    }

    public void setYnNiceSafekey(String ynNiceSafekey) {
        this.ynNiceSafekey = ynNiceSafekey;
    }

    public String getCdCancel() {
        return cdCancel;
    }

    public void setCdCancel(String cdCancel) {
        this.cdCancel = cdCancel;
    }

    public String getBeforeCdStatus() {
        return beforeCdStatus;
    }

    public void setBeforeCdStatus(String beforeCdStatus) {
        this.beforeCdStatus = beforeCdStatus;
    }

    public String getLeftSearchId() {
        return leftSearchId;
    }

    public void setLeftSearchId(String leftSearchId) {
        this.leftSearchId = leftSearchId;
    }

    public String getUpdateCdReject() {
        return updateCdReject;
    }

    public void setUpdateCdReject(String updateCdReject) {
        this.updateCdReject = updateCdReject;
    }

    public String getUpdateCdCancel() {
        return updateCdCancel;
    }

    public void setUpdateCdCancel(String updateCdCancel) {
        this.updateCdCancel = updateCdCancel;
    }

    public String[] getUpdateBatchNo() {
        return updateBatchNo;
    }

    public void setUpdateBatchNo(String updateBatchNo[]) {
        this.updateBatchNo = updateBatchNo;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDsCooperate() {
        return dsCooperate;
    }

    public void setDsCooperate(String dsCooperate) {
        this.dsCooperate = dsCooperate;
    }

    public String getYnCdtInquiry() {
        return ynCdtInquiry;
    }

    public void setYnCdtInquiry(String ynCdtInquiry) {
        this.ynCdtInquiry = ynCdtInquiry;
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



}


