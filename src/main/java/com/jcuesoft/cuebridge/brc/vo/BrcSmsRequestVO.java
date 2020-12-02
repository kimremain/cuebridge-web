package com.jcuesoft.cuebridge.brc.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcSmsRequestVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = 48553171931219829L;
    
    private String searchDiv;
    private String searchSmsMsg;
    private String searchSmsNo;
    private String searchBranchCode;
    private String[] searchRcvNo; // 발송번호
    private String noReq;
    private String smsMessage;
    private String smsMessageNo;
    private String smsReceiveNumber;
    private String smsSendNumber;
    
    private String cmpMsgId;
    private String usrId;
    private String usedCd;
    private String reservedFg;
    private String reservedDttm;
    private String rcvPhnId;
    private String sndPhnId;
    private String sndMsg;
    private String cmpSndDttm;
    private String smsStatus;
    private String comCd;
    private String memberListNo;
    private String contractInfoNo;
    private String workerId;
    private String saveTime;
    private String modeType;
    private String smsType;
    private String smsDiv;
    
    private String seq;
    
    
    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsedCd() {
        return usedCd;
    }

    public void setUsedCd(String usedCd) {
        this.usedCd = usedCd;
    }

    public String getReservedFg() {
        return reservedFg;
    }

    public void setReservedFg(String reservedFg) {
        this.reservedFg = reservedFg;
    }

    public String getReservedDttm() {
        return reservedDttm;
    }

    public void setReservedDttm(String reservedDttm) {
        this.reservedDttm = reservedDttm;
    }

    
    public String getRcvPhnId() {
        return rcvPhnId;
    }

    public void setRcvPhnId(String rcvPhnId) {
        this.rcvPhnId = rcvPhnId;
    }

    public String getSndPhnId() {
        return sndPhnId;
    }

    public void setSndPhnId(String sndPhnId) {
        this.sndPhnId = sndPhnId;
    }

    public String getSndMsg() {
        return sndMsg;
    }

    public void setSndMsg(String sndMsg) {
        this.sndMsg = sndMsg;
    }

    public String getCmpSndDttm() {
        return cmpSndDttm;
    }

    public void setCmpSndDttm(String cmpSndDttm) {
        this.cmpSndDttm = cmpSndDttm;
    }

    public String getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    public String getComCd() {
        return comCd;
    }

    public void setComCd(String comCd) {
        this.comCd = comCd;
    }

    public String getMemberListNo() {
        return memberListNo;
    }

    public void setMemberListNo(String memberListNo) {
        this.memberListNo = memberListNo;
    }

    public String getContractInfoNo() {
        return contractInfoNo;
    }

    public void setContractInfoNo(String contractInfoNo) {
        this.contractInfoNo = contractInfoNo;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(String saveTime) {
        this.saveTime = saveTime;
    }

    public String getModeType() {
        return modeType;
    }

    public void setModeType(String modeType) {
        this.modeType = modeType;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getSmsDiv() {
        return smsDiv;
    }

    public void setSmsDiv(String smsDiv) {
        this.smsDiv = smsDiv;
    }

    public String getSearchDiv() {
        return searchDiv;
    }

    public void setSearchDiv(String searchDiv) {
        this.searchDiv = searchDiv;
    }

    public String getSearchSmsMsg() {
        return searchSmsMsg;
    }

    public void setSearchSmsMsg(String searchSmsMsg) {
        this.searchSmsMsg = searchSmsMsg;
    }

    public String getSearchBranchCode() {
        return searchBranchCode;
    }

    public void setSearchBranchCode(String searchBranchCode) {
        this.searchBranchCode = searchBranchCode;
    }

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }

    public String getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(String smsMessage) {
        this.smsMessage = smsMessage;
    }

    public String getSmsMessageNo() {
        return smsMessageNo;
    }

    public void setSmsMessageNo(String smsMessageNo) {
        this.smsMessageNo = smsMessageNo;
    }

    public String getSmsReceiveNumber() {
        return smsReceiveNumber;
    }

    public void setSmsReceiveNumber(String smsReceiveNumber) {
        this.smsReceiveNumber = smsReceiveNumber;
    }

    public String getSmsSendNumber() {
        return smsSendNumber;
    }

    public void setSmsSendNumber(String smsSendNumber) {
        this.smsSendNumber = smsSendNumber;
    }

    public String getSearchSmsNo() {
        return searchSmsNo;
    }

    public void setSearchSmsNo(String searchSmsNo) {
        this.searchSmsNo = searchSmsNo;
    }

    public String getCmpMsgId() {
        return cmpMsgId;
    }

    public void setCmpMsgId(String cmpMsgId) {
        this.cmpMsgId = cmpMsgId;
    }

    public String[] getSearchRcvNo() {
        return searchRcvNo;
    }

    public void setSearchRcvNo(String[] searchRcvNo) {
        this.searchRcvNo = searchRcvNo;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    
    
    
    
    
}
