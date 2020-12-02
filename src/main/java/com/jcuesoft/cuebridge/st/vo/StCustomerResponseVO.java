package com.jcuesoft.cuebridge.st.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StCustomerResponseVO extends BaseVO {

    /**
	 * 
	 */
    private static final long serialVersionUID = -8706305059704989223L;

    private BigDecimal no;

    private String cdCooperate;

    private String nmCustomer;

    private String dsUrl;

    private String ynUse;

    private String dmReg;

    private String idReg;

    private String dmUpt;

    private String idUpt;

    private String searchDmUpt;

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getCdCooperate() {
        return cdCooperate;
    }

    public void setCdCooperate(String cdCooperate) {
        this.cdCooperate = cdCooperate;
    }

    public String getNmCustomer() {
        return nmCustomer;
    }

    public void setNmCustomer(String nmCustomer) {
        this.nmCustomer = nmCustomer;
    }

    public String getDsUrl() {
        return dsUrl;
    }

    public void setDsUrl(String dsUrl) {
        this.dsUrl = dsUrl;
    }

    public String getYnUse() {
        return ynUse;
    }

    public void setYnUse(String ynUse) {
        this.ynUse = ynUse;
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

    public String getSearchDmUpt() {
        return searchDmUpt;
    }

    public void setSearchDmUpt(String searchDmUpt) {
        this.searchDmUpt = searchDmUpt;
    }

}
