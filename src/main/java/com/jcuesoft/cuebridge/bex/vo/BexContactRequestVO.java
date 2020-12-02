package com.jcuesoft.cuebridge.bex.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BexContactRequestVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = 5336584420929546214L;

    private BigDecimal no;

    private String noReq;
    
    private String noEx;
      
    private String noContactSeq;
    
    private String dsCooperate;

    private Date dmReg;

    private String idReg;

    private Date dmUpt;

    private String idUpt;
   
    private String searchNoEx;
                        
    private String searchNoReq;
    
    public String getSearchNoEx() {
        return searchNoEx;
    }

    public void setSearchNoEx(String searchNoEx) {
    	logger.debug("#################searchNoEx" +searchNoEx);
        this.searchNoEx = searchNoEx;
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

    public Date getDmReg() {
        return dmReg;
    }

    public void setDmReg(Date dmReg) {
        this.dmReg = dmReg;
    }

    public Date getDmUpt() {
        return dmUpt;
    }

    public void setDmUpt(Date dmUpt) {
        this.dmUpt = dmUpt;
    }

    public String getIdReg() {
        return idReg;
    }

    public void setIdReg(String idReg) {
        this.idReg = idReg;
    }

    public String getIdUpt() {
        return idUpt;
    }

    public void setIdUpt(String idUpt) {
        this.idUpt = idUpt;
    }

}
