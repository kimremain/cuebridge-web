package com.jcuesoft.cuebridge.st.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StGroupCodeResponseVO extends BaseVO {

    /**
	 * 
	 */
    private static final long serialVersionUID = 3591402338126202141L;

    private BigDecimal no;

    private String cdGroup;

    private String nmGroup;

    private String cdParentGroup;

    private Date dmReg;

    private String idReg;

    private Date dmUpt;

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

    public String getNmGroup() {
        return nmGroup;
    }

    public void setNmGroup(String nmGroup) {
        this.nmGroup = nmGroup;
    }

    public String getCdParentGroup() {
        return cdParentGroup;
    }

    public void setCdParentGroup(String cdParentGroup) {
        this.cdParentGroup = cdParentGroup;
    }

    public Date getDmReg() {
        return dmReg;
    }

    public void setDmReg(Date dmReg) {
        this.dmReg = dmReg;
    }

    public String getIdReg() {
        return idReg;
    }

    public void setIdReg(String idReg) {
        this.idReg = idReg;
    }

    public Date getDmUpt() {
        return dmUpt;
    }

    public void setDmUpt(Date dmUpt) {
        this.dmUpt = dmUpt;
    }

    public String getIdUpt() {
        return idUpt;
    }

    public void setIdUpt(String idUpt) {
        this.idUpt = idUpt;
    }

}
