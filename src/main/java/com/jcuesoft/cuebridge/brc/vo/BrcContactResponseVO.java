package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcContactResponseVO extends BaseVO {
    
    /**
     * 
     */
    private static final long serialVersionUID = -1615402877794541185L;

    private BigDecimal no;

    private String noReq;

    private String noContactSeq;
    
    private String noContactModel;

    private String cdCallKind;

    private String cdCaller;

    private String cdCallLocal;

    private String ynImportant;

    private String dmPromise;

    private String ynRecord;

    private String noRecord;

    private String dsMemo;

    private String dmReg;

    private String idReg;

    private String dmUpt;

    private String idUpt;
    
    private String nmReg;
    
    // sms 
    private String rcvPhnId;
    private String sndPhnId;
    private String nmResult;
    
    
    public String getNmReg() {
        return nmReg;
    }

    public void setNmReg(String nmReg) {
        this.nmReg = nmReg;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }

    public String getNoContactSeq() {
        return noContactSeq;
    }

    public void setNoContactSeq(String noContactSeq) {
        this.noContactSeq = noContactSeq;
    }

    public String getCdCallKind() {
        return cdCallKind;
    }

    public void setCdCallKind(String cdCallKind) {
        this.cdCallKind = cdCallKind;
    }

    public String getCdCaller() {
        return cdCaller;
    }

    public void setCdCaller(String cdCaller) {
        this.cdCaller = cdCaller;
    }

    public String getCdCallLocal() {
        return cdCallLocal;
    }

    public void setCdCallLocal(String cdCallLocal) {
        this.cdCallLocal = cdCallLocal;
    }

    public String getYnImportant() {
        return ynImportant;
    }

    public void setYnImportant(String ynImportant) {
        this.ynImportant = ynImportant;
    }

    public String getDmPromise() {
        return dmPromise;
    }

    public void setDmPromise(String dmPromise) {
        this.dmPromise = dmPromise;
    }

    public String getYnRecord() {
        return ynRecord;
    }

    public void setYnRecord(String ynRecord) {
        this.ynRecord = ynRecord;
    }

    public String getNoRecord() {
        return noRecord;
    }

    public void setNoRecord(String noRecord) {
        this.noRecord = noRecord;
    }

    public String getDsMemo() {
        return dsMemo;
    }

    public void setDsMemo(String dsMemo) {
        this.dsMemo = dsMemo;
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

    public String getNoContactModel() {
        return noContactModel;
    }

    public void setNoContactModel(String noContactModel) {
        this.noContactModel = noContactModel;
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

    public String getNmResult() {
        return nmResult;
    }

    public void setNmResult(String nmResult) {
        this.nmResult = nmResult;
    }
    
    
}
