package com.jcuesoft.cuebridge.brc.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcLoanAllRequestVO extends BaseVO {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6316321120210312335L;
    
    // BRC_LOAN  
    private String searchNoReq;
    private String searchNoCooperate;
    private String searchCdStatus; // 상태
    private String searchIdScreen; // 상담자
    private String searchCdPath;   // 접수경루 
    
    private String searchDmColumn;   // 조회필드
    private String searchDmStart;
    private String searchDmEnd;
    private String searchCdRecruitGroup;
    private String searchCnSafekeyExt;;
        
    // BRC_CUSTOM
    private String searchNmCustom;
    private String searchNoCustom;
    private String searchContactNoReq; // 조회할 접촉이력 

    private String searchNoTelMobile1;
    private String searchNoTelMobile2;
    private String searchNoTelMobile3;
    private String searchYnSafekey; // safekey 유무
    
    //CSS
    private String searchCdTactic; // 판정결과
    
    private String searchYnReSale;
    
     
    
    // update batch 
    private String updateKind;
    private String updateCdStatus;
    private String updateCdReject;
    private String updateCdCancel;
    private String updateIdScreen;
    private String[] updateBatchNo;
    
    // 심사요청 일괄처리 기능 추가 
    private String excuteCdCooperate;
    
    public String getSearchCdStatus() {
        return searchCdStatus;
    }
    public void setSearchCdStatus(String searchCdStatus) {
        this.searchCdStatus = searchCdStatus;
    }
    public String getSearchIdScreen() {
        return searchIdScreen;
    }
    public void setSearchIdScreen(String searchIdScreen) {
        this.searchIdScreen = searchIdScreen;
    }
    public String getSearchCdPath() {
        return searchCdPath;
    }
    public void setSearchCdPath(String searchCdPath) {
        this.searchCdPath = searchCdPath;
    }
    public String getSearchDmColumn() {
        return searchDmColumn;
    }
    public void setSearchDmColumn(String searchDmColumn) {
        this.searchDmColumn = searchDmColumn;
    }
    public String getSearchDmStart() {
        return searchDmStart;
    }
    public void setSearchDmStart(String searchDmStart) {
        this.searchDmStart = searchDmStart;
    }
    public String getSearchDmEnd() {
        return searchDmEnd;
    }
    public void setSearchDmEnd(String searchDmEnd) {
        this.searchDmEnd = searchDmEnd;
    }
    public String getSearchNoReq() {
        return searchNoReq;
    }
    public void setSearchNoReq(String searchNoReq) {
        this.searchNoReq = searchNoReq;
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
    public String getUpdateIdScreen() {
        return updateIdScreen;
    }
    public void setUpdateIdScreen(String updateIdScreen) {
        this.updateIdScreen = updateIdScreen;
    }
    public String[] getUpdateBatchNo() {
        return updateBatchNo;
    }
    public void setUpdateBatchNo(String[] updateBatchNo) {
        this.updateBatchNo = updateBatchNo;
    }
    public String getSearchNoTelMobile1() {
        return searchNoTelMobile1;
    }
    public void setSearchNoTelMobile1(String searchNoTelMobile1) {
        this.searchNoTelMobile1 = searchNoTelMobile1;
    }
    public String getSearchNoTelMobile2() {
        return searchNoTelMobile2;
    }
    public void setSearchNoTelMobile2(String searchNoTelMobile2) {
        this.searchNoTelMobile2 = searchNoTelMobile2;
    }
    public String getSearchNoTelMobile3() {
        return searchNoTelMobile3;
    }
    public void setSearchNoTelMobile3(String searchNoTelMobile3) {
        this.searchNoTelMobile3 = searchNoTelMobile3;
    }
    public String getSearchCdTactic() {
        return searchCdTactic;
    }
    public void setSearchCdTactic(String searchCdTactic) {
        this.searchCdTactic = searchCdTactic;
    }
    public String getSearchYnSafekey() {
        return searchYnSafekey;
    }
    public void setSearchYnSafekey(String searchYnSafekey) {
        this.searchYnSafekey = searchYnSafekey;
    }
    public String getSearchNoCooperate() {
        return searchNoCooperate;
    }
    public void setSearchNoCooperate(String searchNoCooperate) {
        this.searchNoCooperate = searchNoCooperate;
    }
    public String getSearchCdRecruitGroup() {
        return searchCdRecruitGroup;
    }
    public void setSearchCdRecruitGroup(String searchCdRecruitGroup) {
        this.searchCdRecruitGroup = searchCdRecruitGroup;
    }
    public String getSearchCnSafekeyExt() {
        return searchCnSafekeyExt;
    }
    public void setSearchCnSafekeyExt(String searchCnSafekeyExt) {
        this.searchCnSafekeyExt = searchCnSafekeyExt;
    }
    public String getUpdateKind() {
        return updateKind;
    }
    public void setUpdateKind(String updateKind) {
        this.updateKind = updateKind;
    }
    public String getExcuteCdCooperate() {
        return excuteCdCooperate;
    }
    public void setExcuteCdCooperate(String excuteCdCooperate) {
        this.excuteCdCooperate = excuteCdCooperate;
    }
    public String getSearchYnReSale() {
        return searchYnReSale;
    }
    public void setSearchYnReSale(String searchYnReSale) {
        this.searchYnReSale = searchYnReSale;
    } 
    
}


