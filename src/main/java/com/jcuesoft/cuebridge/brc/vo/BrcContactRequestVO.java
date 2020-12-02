package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcContactRequestVO extends BaseVO {

    
    /**
     * 
     */
    private static final long serialVersionUID = -3106697049459635067L;

    private BigDecimal no;

    private String noReq;
    
    private String cdContact; 
    
    private String noContactSeq;

    private String cdCallKind;

    private String cdCaller;

    private String cdCallLocal;

    private String ynImportant;

    private String dmPromise;

    private String ynRecord;

    private String noRecord;

    private String dsMemo;
    
    private String memoStepFlag;// 동의서 안내 전/후 메모구분값 

    private String dmReg;

    private String idReg;

    private String dmUpt;

    private String idUpt;
    
    private String noContactModel;
    
    private String searchNoReq;
    
    private String cdEtc1;
    
    
    private String[] searchContactNoReq; // 조회할 접촉이력 

    public String[] getSearchContactNoReq() {
        return searchContactNoReq;
    }

    public void setSearchContactNoReq(String[] searchContactNoReq) {
        this.searchContactNoReq = searchContactNoReq;
    }
    
    public String getSearchNoReq() {
        return searchNoReq;
    }

    public void setSearchNoReq(String searchNoReq) {
        this.searchNoReq = searchNoReq;
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

    public String getCdContact() {
        return cdContact;
    }

    public void setCdContact(String cdContact) {
        this.cdContact = cdContact;
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

    public String getMemoStepFlag() {
        return memoStepFlag;
    }

    public void setMemoStepFlag(String memoStepFlag) {
        this.memoStepFlag = memoStepFlag;
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

    public String getCdEtc1() {
        return cdEtc1;
    }

    public void setCdEtc1(String cdEtc1) {
        this.cdEtc1 = cdEtc1;
    }

}
