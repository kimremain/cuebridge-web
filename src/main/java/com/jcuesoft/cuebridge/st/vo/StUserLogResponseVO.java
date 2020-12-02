package com.jcuesoft.cuebridge.st.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StUserLogResponseVO extends BaseVO {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7766660423870546632L;

    private BigDecimal no;

    private String idUser;

    private String noSeq;

    private String noReq;

    private String nmUser;

    private String dsPgm;

    private String cdUserAction;

    private String dsRemk;

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

    public String getNoSeq() {
        return noSeq;
    }

    public void setNoSeq(String noSeq) {
        this.noSeq = noSeq;
    }

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }

    public String getDsPgm() {
        return dsPgm;
    }

    public void setDsPgm(String dsPgm) {
        this.dsPgm = dsPgm;
    }

    public String getCdUserAction() {
        return cdUserAction;
    }

    public void setCdUserAction(String cdUserAction) {
        this.cdUserAction = cdUserAction;
    }

    public String getDsRemk() {
        return dsRemk;
    }

    public void setDsRemk(String dsRemk) {
        this.dsRemk = dsRemk;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUpt() {
        return idUpt;
    }

    public void setIdUpt(String idUpt) {
        this.idUpt = idUpt;
    }

    public String getNmUser() {
        return nmUser;
    }

    public void setNmUser(String nmUser) {
        this.nmUser = nmUser;
    }

}
