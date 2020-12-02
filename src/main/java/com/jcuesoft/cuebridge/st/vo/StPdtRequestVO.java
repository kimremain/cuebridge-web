package com.jcuesoft.cuebridge.st.vo;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StPdtRequestVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = 8767309848405896764L;

    private BigDecimal no;
    
    private String cdCooperate;
    
    @NotBlank @Pattern(regexp="^(\\d{5})", message="상품코드는 5자리 숫자만 허용합니다.") 
    private String cdPdt;
    
    @NotBlank(message="상품명을 입력하셔야 합니다.")
    private String nmPdt;

    private String idPdtUid;

    private BigDecimal rtNor;

    private BigDecimal rtDly;

    private String cdKndPay;

    private BigDecimal noMonthPay;

    private BigDecimal rtMonthPay;

    private String ynUse;

    private String dmReg;

    private String idReg;

    private String dmUpt;

    private String idUpt;
    
    private String searchNmPdt;
    
    private String cdSales;

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

    public String getCdPdt() {
        return cdPdt;
    }

    public void setCdPdt(String cdPdt) {
        this.cdPdt = cdPdt;
    }

    public String getNmPdt() {
        return nmPdt;
    }

    public void setNmPdt(String nmPdt) {
        this.nmPdt = nmPdt;
    }

    public String getIdPdtUid() {
        return idPdtUid;
    }

    public void setIdPdtUid(String idPdtUid) {
        this.idPdtUid = idPdtUid;
    }

    public BigDecimal getRtNor() {
        return rtNor;
    }

    public void setRtNor(BigDecimal rtNor) {
        this.rtNor = rtNor;
    }

    public BigDecimal getRtDly() {
        return rtDly;
    }

    public void setRtDly(BigDecimal rtDly) {
        this.rtDly = rtDly;
    }

    public String getCdKndPay() {
        return cdKndPay;
    }

    public void setCdKndPay(String cdKndPay) {
        this.cdKndPay = cdKndPay;
    }

    public BigDecimal getNoMonthPay() {
        return noMonthPay;
    }

    public void setNoMonthPay(BigDecimal noMonthPay) {
        this.noMonthPay = noMonthPay;
    }

    public BigDecimal getRtMonthPay() {
        return rtMonthPay;
    }

    public void setRtMonthPay(BigDecimal rtMonthPay) {
        this.rtMonthPay = rtMonthPay;
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

    public String getSearchNmPdt() {
        return searchNmPdt;
    }

    public void setSearchNmPdt(String searchNmPdt) {
        this.searchNmPdt = searchNmPdt;
    }

    public String getCdSales() {
        return cdSales;
    }

    public void setCdSales(String cdSales) {
        this.cdSales = cdSales;
    }

    
}
