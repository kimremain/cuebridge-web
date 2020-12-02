package com.jcuesoft.cuebridge.st.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StSmssendResponseVO extends BaseVO {


    /**
     * 
     */
    private static final long serialVersionUID = 557459096704424033L;

    private BigDecimal no;
    
    private String cdKind;

    private String noReq;
    
    private String nmReg;
    
    private String dmSend;
    
    private String noSend;
    
    private String noRcv;
    
    private String dsMsg;
    
    private String nmResult;

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

    public String getNmReg() {
        return nmReg;
    }

    public void setNmReg(String nmReg) {
        this.nmReg = nmReg;
    }

    public String getDmSend() {
        return dmSend;
    }

    public void setDmSend(String dmSend) {
        this.dmSend = dmSend;
    }

    public String getNoSend() {
        return noSend;
    }

    public void setNoSend(String noSend) {
        this.noSend = noSend;
    }

    public String getNoRcv() {
        return noRcv;
    }

    public void setNoRcv(String noRcv) {
        this.noRcv = noRcv;
    }

    public String getDsMsg() {
        return dsMsg;
    }

    public void setDsMsg(String dsMsg) {
        this.dsMsg = dsMsg;
    }

    public String getNmResult() {
        return nmResult;
    }

    public void setNmResult(String nmResult) {
        this.nmResult = nmResult;
    }

    public String getCdKind() {
        return cdKind;
    }

    public void setCdKind(String cdKind) {
        this.cdKind = cdKind;
    }

 
    
}
