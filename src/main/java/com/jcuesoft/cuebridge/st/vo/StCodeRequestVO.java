package com.jcuesoft.cuebridge.st.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StCodeRequestVO extends BaseVO {

    /**
    	 * 
    	 */

    private static final long serialVersionUID = -597644696200454879L;

    private BigDecimal no;
    
    @NotBlank(message="그룹코드 값이 없습니다.")
    private String cdGroup;
    
    @NotBlank @Pattern(regexp="^(\\d{5})", message="코드는 5자리 숫자만 허용합니다.") 
    private String cd;
    
    @NotBlank(message="코드명을 입력하셔야 합니다.")
    private String nmCd;

    private String ynUse;

    private String noOrder;

    private Date dmReg;

    private String idReg;

    private Date dmUpt;

    private String idUpt;

    private String searchGroupCode;

    
    // 순서 일괄변경 
    private String[] changeOrderCodeNo;    
    
    private String[] changeOrderNum;    
   
    private String qryChangeOrderCodeNo; // mapper 에서 사용할 변경할 순서
    
    private String qryChangeOrderNum;     // mapper 에서 사용할 변경할 코드번호
    
    public String[] getChangeOrderCodeNo() {
        return changeOrderCodeNo;
    }

    public void setChangeOrderCodeNo(String[] changeOrderCodeNo) {
        this.changeOrderCodeNo = changeOrderCodeNo;
    }

    public String[] getChangeOrderNum() {
        return changeOrderNum;
    }

    public void setChangeOrderNum(String[] changeOrderNum) {
        this.changeOrderNum = changeOrderNum;
    }

    public String getQryChangeOrderCodeNo() {
        return qryChangeOrderCodeNo;
    }

    public void setQryChangeOrderCodeNo(String qryChangeOrderCodeNo) {
        this.qryChangeOrderCodeNo = qryChangeOrderCodeNo;
    }

    public String getQryChangeOrderNum() {
        return qryChangeOrderNum;
    }

    public void setQryChangeOrderNum(String qryChangeOrderNum) {
        this.qryChangeOrderNum = qryChangeOrderNum;
    }
    
    public String getSearchGroupCode() {
        return searchGroupCode;
    }

    public void setSearchGroupCode(String searchGroupCode) {
        this.searchGroupCode = searchGroupCode;
    }

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
