package com.jcuesoft.cuebridge.brc.vo;


import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcPromiseRequestVO extends BaseVO {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8845030680793229165L;
    
    // BRC_LOAN  
    private String searchIdScreen;         // 심사자
    private String searchDmPromiseStart;// 약속일
    private String searchDmPromiseEnd;   

    // BRC_CUSTOM
    private String searchNmCustom;      //고객명
    private String searchNoCustom;       //주민번호
    
    private String searchContactNoReq; // 조회할 접촉이력 
    
    public String getSearchContactNoReq() {
        return searchContactNoReq;
    }
    public void setSearchContactNoReq(String searchContactNoReq) {
        this.searchContactNoReq = searchContactNoReq;
    }
    
    public String getSearchIdScreen() {
        return searchIdScreen;
    }
    public void setSearchIdScreen(String searchIdScreen) {
        this.searchIdScreen = searchIdScreen;
    }
    public String getSearchDmPromiseStart() {
        return searchDmPromiseStart;
    }
    public void setSearchDmPromiseStart(String searchDmPromiseStart) {
        this.searchDmPromiseStart = searchDmPromiseStart;
    }
    public String getSearchDmPromiseEnd() {
        return searchDmPromiseEnd;
    }
    public void setSearchDmPromiseEnd(String searchDmPromiseEnd) {
        this.searchDmPromiseEnd = searchDmPromiseEnd;
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


}

