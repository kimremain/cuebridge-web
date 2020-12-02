package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcSuretyResponseVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = 7087013460326792701L;

    private String searchNoReq;
    
    private String searchNoSurety;    
    
    private BigDecimal no;

    private String noReq;

    private String noSurety;

    private String nmCustom;

    private String noCustom;

    private String dsEmail;

    private String dsEmail1;    
    
    private String dsEmail2;

    private String cdMarry;

    private String cdKndMobile;

    private String noTel1Mobile;

    private String noTel2Mobile;

    private String noTel3Mobile;

    private String ynAuthMobile;
    
    private String ynNiceSafekey;

    private String cdKndEtc;

    private String noTel1Etc1;

    private String noTel2Etc1;

    private String noTel3Etc1;

    private String ynAuthEtc;

    private String noFax1;

    private String noFax2;

    private String noFax3;

    private String dmReg;

    private String idReg;

    private String dmUpt;

    private String idUpt;
    
    private String cdJobKind;
    
    /* brc_custom 현재미사용 필드   */
    private String cdBank;
    private String noBankAct;

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
    
    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getSearchNoReq() {
        return searchNoReq;
    }

    public void setSearchNoReq(String searchNoReq) {
        this.searchNoReq = searchNoReq;
    }

    public String getSearchNoSurety() {
        return searchNoSurety;
    }

    public void setSearchNoSurety(String searchNoSurety) {
        this.searchNoSurety = searchNoSurety;
    }
    
    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }    
    public String getNoSurety() {
        return noSurety;
    }

    public void setNoSurety(String noSurety) {
        this.noSurety = noSurety;
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

    public String getNoMaintel3Comp() {
        return noMaintel3Comp;
    }

    public void setNoMaintel3Comp(String noMaintel3Comp) {
        this.noMaintel3Comp = noMaintel3Comp;
    }

    public String getCdJobKind() {
        return cdJobKind;
    }

    public void setCdJobKind(String cdJobKind) {
        this.cdJobKind = cdJobKind;
    }

    public String getYnNiceSafekey() {
        return ynNiceSafekey;
    }

    public void setYnNiceSafekey(String ynNiceSafekey) {
        this.ynNiceSafekey = ynNiceSafekey;
    }    
    
    

}
