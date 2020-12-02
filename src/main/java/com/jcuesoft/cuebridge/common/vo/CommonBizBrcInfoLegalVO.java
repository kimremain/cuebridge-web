package com.jcuesoft.cuebridge.common.vo;

public class CommonBizBrcInfoLegalVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = -7680902726961716643L;

    // 성명
    private String nmCustom;    
    // 주민번호 7자리 출력
    private String noCustom;    
    // 성별 = 남:M 여:F 확인불가:' '
    private String dsSex;
    
    // 작성일자
    private String dtAgent;
    // 작성업체명
    private String nmAgent;
    // 작성업체대표자
    private String nmAgentCeo;
    // 작성업체담당자
    private String nmAgentManager;    
    //작성업체홈페이지주소
    private String dsAgentUrl;
    
    // 정보수집경로코드 
    // 71601   고객=>중개인 연락
    // 71602   중개인=>고객 연락
    private String cdInfoCollect;
        
    /* #####################
     * 고객=>중개인 연락 일경우 START
     * #####################*/
    // 고객접촉구분코드
    // 71401    인터넷광고-전화
    // 71402    인터넷광고-홈페이지
    // 71403    신문광고
    // 71404    전단지광고
    // 71405    방문신청
    // 71406    제휴처제공
    // 71499    기타    
    private String cdContactCust;
    // 고객접촉비고 = 기타일경우 서술내용
    private String dsContactCust;
    /* #####################
     * 고객=>중개인 연락 일경우 END
     * #####################*/
    
    /* #####################
     * 중개인=>고객 연락 일경우 START
     * #####################*/
    // 중개인접촉구분코드
    // 71801    제휴쳐제공
    // 71899    기타
    private String cdContactAgent;
    // 중개인접촉제휴쳐 =  서술
    private String nmContactAgent;
    // 중개인접촉구분비고 = 중개인접촉구분코드 기타일경우 서술
    private String dsContactAgent;
    // 중개인고객연락방법코드
    private String cdCallAgent;
    /* #####################
     * 중개인=>고객 연락 일경우 END
     * #####################*/    


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

    public String getDsSex() {
        return dsSex;
    }

    public void setDsSex(String dsSex) {
        this.dsSex = dsSex;
    }

    public String getCdInfoCollect() {
        return cdInfoCollect;
    }

    public void setCdInfoCollect(String cdInfoCollect) {
        this.cdInfoCollect = cdInfoCollect;
    }

    public String getCdContactCust() {
        return cdContactCust;
    }

    public void setCdContactCust(String cdContactCust) {
        this.cdContactCust = cdContactCust;
    }

    public String getDsContactCust() {
        return dsContactCust;
    }

    public void setDsContactCust(String dsContactCust) {
        this.dsContactCust = dsContactCust;
    }

    public String getCdContactAgent() {
        return cdContactAgent;
    }

    public void setCdContactAgent(String cdContactAgent) {
        this.cdContactAgent = cdContactAgent;
    }

    public String getNmContactAgent() {
        return nmContactAgent;
    }

    public void setNmContactAgent(String nmContactAgent) {
        this.nmContactAgent = nmContactAgent;
    }

    public String getDsContactAgent() {
        return dsContactAgent;
    }

    public void setDsContactAgent(String dsContactAgent) {
        this.dsContactAgent = dsContactAgent;
    }

    public String getCdCallAgent() {
        return cdCallAgent;
    }

    public void setCdCallAgent(String cdCallAgent) {
        this.cdCallAgent = cdCallAgent;
    }

    public String getDtAgent() {
        return dtAgent;
    }

    public void setDtAgent(String dtAgent) {
        this.dtAgent = dtAgent;
    }

    public String getNmAgentCeo() {
        return nmAgentCeo;
    }

    public void setNmAgentCeo(String nmAgentCeo) {
        this.nmAgentCeo = nmAgentCeo;
    }

    public String getNmAgentManager() {
        return nmAgentManager;
    }

    public void setNmAgentManager(String nmAgentManager) {
        this.nmAgentManager = nmAgentManager;
    }

    public String getNmAgent() {
        return nmAgent;
    }

    public void setNmAgent(String nmAgent) {
        this.nmAgent = nmAgent;
    }

    public String getDsAgentUrl() {
        return dsAgentUrl;
    }

    public void setDsAgentUrl(String dsAgentUrl) {
        this.dsAgentUrl = dsAgentUrl;
    }
    
    
}