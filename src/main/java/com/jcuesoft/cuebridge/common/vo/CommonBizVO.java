package com.jcuesoft.cuebridge.common.vo;

public class CommonBizVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = 1901402794885718225L;
    
    
    private String messageKind; // 메세지 종류 
    
    private String messageNo;  // 메세지 시퀀스 번호 
    
    private String brcLonaNoReq; // 고객정보 키
     
    private String idScreen; // 심사자 아이디 
    
    public String getMessageKind() {
        return messageKind;
    }
    public void setMessageKind(String messageKind) {
        this.messageKind = messageKind;
    }
    public String getMessageNo() {
        return messageNo;
    }
    public void setMessageNo(String messageNo) {
        this.messageNo = messageNo;
    }
    public String getBrcLonaNoReq() {
        return brcLonaNoReq;
    }
    public void setBrcLonaNoReq(String brcLonaNoReq) {
        this.brcLonaNoReq = brcLonaNoReq;
    }
    public String getIdScreen() {
        return idScreen;
    }
    public void setIdScreen(String idScreen) {
        this.idScreen = idScreen;
    }
    
    // 치환할 컬럼 
    private String message;
    private String nmCustom; // 고객명 
    private String nmScreen; // 심사자
    private String noFax; // 팩스번호

    private String rcvPhnId; // 수신전화번호
    private String rcvName; // 수신자명
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getNmCustom() {
        return nmCustom;
    }
    public void setNmCustom(String nmCustom) {
        this.nmCustom = nmCustom;
    }
    public String getNmScreen() {
        return nmScreen;
    }
    public void setNmScreen(String nmScreen) {
        this.nmScreen = nmScreen;
    }
    public String getNoFax() {
        return noFax;
    }
    public void setNoFax(String noFax) {
        this.noFax = noFax;
    }
    public String getRcvPhnId() {
        return rcvPhnId;
    }
    public void setRcvPhnId(String rcvPhnId) {
        this.rcvPhnId = rcvPhnId;
    }
    public String getRcvName() {
        return rcvName;
    }
    public void setRcvName(String rcvName) {
        this.rcvName = rcvName;
    }
    
    
    
    
    
}