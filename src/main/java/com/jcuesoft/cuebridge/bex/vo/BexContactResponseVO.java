package com.jcuesoft.cuebridge.bex.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BexContactResponseVO extends BaseVO {
    
    /**
     * 
     */
    private static final long serialVersionUID = -671481656964780962L;
    
    private  String nmScreen;
    
    public String getNmScreen() {
        return nmScreen;
    }

    public void setNmScreen(String nmScreen) {
        this.nmScreen = nmScreen;
    }

    private BigDecimal no;

    private String noReq;
    
    private String noEx;
    
    private String noContactSeq;
    
    private String dsCooperate;

    private String dmReg;

    private String idReg;

    private String dmUpt;

    private String idUpt;

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

    public String getNoEx() {
        return noEx;
    }

    public void setNoEx(String noEx) {
        this.noEx = noEx;
    }

    public String getNoContactSeq() {
        return noContactSeq;
    }

    public void setNoContactSeq(String noContactSeq) {
        this.noContactSeq = noContactSeq;
    }

    public String getDsCooperate() {
        return dsCooperate;
    }

    public void setDsCooperate(String dsCooperate) {
        this.dsCooperate = dsCooperate;
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
    
    
}
