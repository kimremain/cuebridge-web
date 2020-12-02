package com.jcuesoft.cuebridge.st.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StCodeResponseVO extends BaseVO {

    /**
	 * 
	 */
    private static final long serialVersionUID = -5198772484084953955L;

    private BigDecimal no;

    private String cdGroup;

    private String cd;

    private String nmCd;

    private String ynUse;

    private String noOrder;

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

    public String getCdGroup() {
        return cdGroup;
    }

    public void setCdGroup(String cdGroup) {
        this.cdGroup = cdGroup;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getNmCd() {
        return nmCd;
    }

    public void setNmCd(String nmCd) {
        this.nmCd = nmCd;
    }

    public String getYnUse() {
        return ynUse;
    }

    public void setYnUse(String ynUse) {
        this.ynUse = ynUse;
    }

    public String getNoOrder() {
        return noOrder;
    }

    public void setNoOrder(String noOrder) {
        this.noOrder = noOrder;
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
