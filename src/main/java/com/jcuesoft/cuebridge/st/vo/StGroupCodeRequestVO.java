package com.jcuesoft.cuebridge.st.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StGroupCodeRequestVO extends BaseVO {

    /**
	 * 
	 */
    private static final long serialVersionUID = 7784531237148012796L;

    private BigDecimal no;
    
    @NotBlank @Pattern(regexp="^(\\d{3})", message="그룹코드는 3자리 숫자만 허용합니다.") 
    private String cdGroup;
    
    @NotBlank(message="그룹코드명을 입력하셔야 합니다.")
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
