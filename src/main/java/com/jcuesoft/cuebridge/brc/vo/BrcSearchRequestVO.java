package com.jcuesoft.cuebridge.brc.vo;


import com.jcuesoft.cuebridge.common.vo.BaseVO;

/**
 *
 */
public class BrcSearchRequestVO extends BaseVO {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3207662019423231053L;
    
    private String noReq;
    
    private String ynSurety;
    
    private String lincusId;
    
    private String idReceive; 
    
    private String searchNmCustom;
    
    private String searchConfirm;

    private String searchNoCustomFirst;

    private String searchNoCustomSecond;

    private String searchNoCustomFull;
    
    private String searchNoMobile1;

    private String searchNoMobile2;

    private String searchNoMobile3;
    
    private String searchNoMobileSecond1;

    private String searchNoMobileSecond2;

    private String searchNoMobileSecond3;
    
    private String searchNoMobileFull;
    
    private String searchNoTel1;

    private String searchNoTel2;

    private String searchNoTel3;
    
    private String searchNoComTel1;

    private String searchNoComTel2;

    private String searchNoComTel3;
    
    private String searchLincusOpt;
    
    private String searchLincusKey;
    
    private String searchLincusNum;

    private String searchLincusType;
    
    private String searchIP;

    private String cdCompany;
    
    private String noTel;
    
    private String dsRemk;
    
    private String searchSsnHash;
    
    private String searchHpHash;
    
    

    public String getSearchNmCustom() {
        return searchNmCustom;
    }

    public void setSearchNmCustom(String searchNmCustom) {
        this.searchNmCustom = searchNmCustom;
    }

    public String getSearchNoCustomFirst() {
        return searchNoCustomFirst;
    }

    public void setSearchNoCustomFirst(String searchNoCustomFirst) {
        this.searchNoCustomFirst = searchNoCustomFirst;
    }

    public String getSearchNoCustomSecond() {
        return searchNoCustomSecond;
    }

    public void setSearchNoCustomSecond(String searchNoCustomSecond) {
        this.searchNoCustomSecond = searchNoCustomSecond;
    }
    
    public String getSearchNoCustom() {
        return searchNoCustomFirst+searchNoCustomSecond;
    }

    public String getSearchConfirm() {
        return searchConfirm;
    }

    public void setSearchConfirm(String searchConfirm) {
        this.searchConfirm = searchConfirm;
    }
    public String getSearchNoMobile1() {
        return searchNoMobile1;
    }

    public void setSearchNoMobile1(String searchNoMobile1) {
        this.searchNoMobile1 = searchNoMobile1;
    }

    public String getSearchNoMobile2() {
        return searchNoMobile2;
    }

    public void setSearchNoMobile2(String searchNoMobile2) {
        this.searchNoMobile2 = searchNoMobile2;
    }

    public String getSearchNoMobile3() {
        return searchNoMobile3;
    }

    public void setSearchNoMobile3(String searchNoMobile3) {
        this.searchNoMobile3 = searchNoMobile3;
    }

    public String getSearchNoTel1() {
        return searchNoTel1;
    }

    public void setSearchNoTel1(String searchNoTel1) {
        this.searchNoTel1 = searchNoTel1;
    }

    public String getSearchNoTel2() {
        return searchNoTel2;
    }

    public void setSearchNoTel2(String searchNoTel2) {
        this.searchNoTel2 = searchNoTel2;
    }

    public String getSearchNoTel3() {
        return searchNoTel3;
    }

    public void setSearchNoTel3(String searchNoTel3) {
        this.searchNoTel3 = searchNoTel3;
    }

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }

    public String getYnSurety() {
        return ynSurety;
    }

    public void setYnSurety(String ynSurety) {
        this.ynSurety = ynSurety;
    }

    public String getSearchNoMobileFull() {
        return searchNoMobileFull;
    }

    public void setSearchNoMobileFull(String searchNoMobileFull) {
        this.searchNoMobileFull = searchNoMobileFull;
    }

    public String getSearchNoComTel1() {
        return searchNoComTel1;
    }

    public void setSearchNoComTel1(String searchNoComTel1) {
        this.searchNoComTel1 = searchNoComTel1;
    }

    public String getSearchNoComTel2() {
        return searchNoComTel2;
    }

    public void setSearchNoComTel2(String searchNoComTel2) {
        this.searchNoComTel2 = searchNoComTel2;
    }

    public String getSearchNoComTel3() {
        return searchNoComTel3;
    }

    public void setSearchNoComTel3(String searchNoComTel3) {
        this.searchNoComTel3 = searchNoComTel3;
    }

    public String getSearchLincusOpt() {
        return searchLincusOpt;
    }

    public void setSearchLincusOpt(String searchLincusOpt) {
        this.searchLincusOpt = searchLincusOpt;
    }

    public String getSearchLincusKey() {
        return searchLincusKey;
    }

    public void setSearchLincusKey(String searchLincusKey) {
        this.searchLincusKey = searchLincusKey;
    }

    public String getSearchLincusNum() {
        return searchLincusNum;
    }

    public void setSearchLincusNum(String searchLincusNum) {
        this.searchLincusNum = searchLincusNum;
    }

    public String getSearchLincusType() {
        return searchLincusType;
    }

    public void setSearchLincusType(String searchLincusType) {
        this.searchLincusType = searchLincusType;
    }

    public String getSearchNoMobileSecond1() {
        return searchNoMobileSecond1;
    }

    public void setSearchNoMobileSecond1(String searchNoMobileSecond1) {
        this.searchNoMobileSecond1 = searchNoMobileSecond1;
    }

    public String getSearchNoMobileSecond2() {
        return searchNoMobileSecond2;
    }

    public void setSearchNoMobileSecond2(String searchNoMobileSecond2) {
        this.searchNoMobileSecond2 = searchNoMobileSecond2;
    }

    public String getSearchNoMobileSecond3() {
        return searchNoMobileSecond3;
    }

    public void setSearchNoMobileSecond3(String searchNoMobileSecond3) {
        this.searchNoMobileSecond3 = searchNoMobileSecond3;
    }

    public String getLincusId() {
        return lincusId;
    }

    public void setLincusId(String lincusId) {
        this.lincusId = lincusId;
    }

    public String getNoTel() {
        return noTel;
    }

    public void setNoTel(String noTel) {
        this.noTel = noTel;
    }

    public String getDsRemk() {
        return dsRemk;
    }

    public void setDsRemk(String dsRemk) {
        this.dsRemk = dsRemk;
    }

    public String getCdCompany() {
        return cdCompany;
    }

    public void setCdCompany(String cdCompany) {
        this.cdCompany = cdCompany;
    }

    public String getSearchNoCustomFull() {
        return searchNoCustomFull;
    }

    public void setSearchNoCustomFull(String searchNoCustomFull) {
        this.searchNoCustomFull = searchNoCustomFull;
    }

    public String getIdReceive() {
        return idReceive;
    }

    public void setIdReceive(String idReceive) {
        this.idReceive = idReceive;
    }

    public String getSearchIP() {
        return searchIP;
    }

    public void setSearchIP(String searchIP) {
        this.searchIP = searchIP;
    }

    public String getSearchSsnHash() {
        return searchSsnHash;
    }

    public void setSearchSsnHash(String searchSsnHash) {
        this.searchSsnHash = searchSsnHash;
    }

    public String getSearchHpHash() {
        return searchHpHash;
    }

    public void setSearchHpHash(String searchHpHash) {
        this.searchHpHash = searchHpHash;
    }
    


    
    
}

