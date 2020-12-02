package com.jcuesoft.cuebridge.brc.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcSmsResponseVO extends BaseVO {
    
    
    /**
     * 
     */
    private static final long serialVersionUID = -8239807037956586068L;
    
    private String no;
    private String smsDiv;
    private String message;
    private String shortMessage;
    private String mabagerCode;
    private String managerTeam;
    private String smsType;
    private String noTelForMms;
    
    
    public String getSmsDiv() {
        return smsDiv;
    }
    public void setSmsDiv(String smsDiv) {
        this.smsDiv = smsDiv;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMabagerCode() {
        return mabagerCode;
    }
    public void setMabagerCode(String mabagerCode) {
        this.mabagerCode = mabagerCode;
    }
    public String getManagerTeam() {
        return managerTeam;
    }
    public void setManagerTeam(String managerTeam) {
        this.managerTeam = managerTeam;
    }
    public String getSmsType() {
        return smsType;
    }
    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getShortMessage() {
        return shortMessage;
    }
    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }
    
    
    private String sendPhone;
    private String sendTeamCode;

    public String getSendPhone() {
        return sendPhone;
    }
    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone;
    }
    public String getSendTeamCode() {
        return sendTeamCode;
    }
    public void setSendTeamCode(String sendTeamCode) {
        this.sendTeamCode = sendTeamCode;
    }
    public String getNoTelForMms() {
        return noTelForMms;
    }
    public void setNoTelForMms(String noTelForMms) {
        this.noTelForMms = noTelForMms;
    }
    
    
    
    
    
}
