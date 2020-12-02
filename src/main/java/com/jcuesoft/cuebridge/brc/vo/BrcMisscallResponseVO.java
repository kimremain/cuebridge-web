package com.jcuesoft.cuebridge.brc.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcMisscallResponseVO extends BaseVO {
    
    
    /**
     * 
     */
    private static final long serialVersionUID = 2707448532901765971L;
    
    private String no;          
    private String noTel;  
    private String noTel1Mobile;  
    private String noTel2Mobile;  
    private String noTel3Mobile;  
    
    private String cdCallProc;      
    private String dsRemk;          
    private String dmReg;           
    private String idReg;           
    private String dmUpt;           
    private String idUpt;
    private String cnCustomTel;
    private String cnSuretyTel;
    private String cnMisscall;
    private String dmRegMin;
    private String dmRegMax;
    
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getNoTel() {
        return noTel;
    }
    public void setNoTel(String noTel) {
        this.noTel = noTel;
    }
    public String getCdCallProc() {
        return cdCallProc;
    }
    public void setCdCallProc(String cdCallProc) {
        this.cdCallProc = cdCallProc;
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
    public String getIdUpt() {
        return idUpt;
    }
    public void setIdUpt(String idUpt) {
        this.idUpt = idUpt;
    }
    public String getCnCustomTel() {
        return cnCustomTel;
    }
    public void setCnCustomTel(String cnCustomTel) {
        this.cnCustomTel = cnCustomTel;
    }
    public String getCnMisscall() {
        return cnMisscall;
    }
    public void setCnMisscall(String cnMisscall) {
        this.cnMisscall = cnMisscall;
    }
    public String getDmRegMin() {
        return dmRegMin;
    }
    public void setDmRegMin(String dmRegMin) {
        this.dmRegMin = dmRegMin;
    }
    public String getDmRegMax() {
        return dmRegMax;
    }
    public void setDmRegMax(String dmRegMax) {
        this.dmRegMax = dmRegMax;
    }
    public String getCnSuretyTel() {
        return cnSuretyTel;
    }
    public void setCnSuretyTel(String cnSuretyTel) {
        this.cnSuretyTel = cnSuretyTel;
    }
    public String getNoTel1Mobile() {
        return noTel1Mobile;
    }
    public void setNoTel1Mobile(String noTel1Mobile) {
        this.noTel1Mobile = noTel1Mobile;
    }
    public String getNoTel2Mobile() {
        return noTel2Mobile;
    }
    public void setNoTel2Mobile(String noTel2Mobile) {
        this.noTel2Mobile = noTel2Mobile;
    }
    public String getNoTel3Mobile() {
        return noTel3Mobile;
    }
    public void setNoTel3Mobile(String noTel3Mobile) {
        this.noTel3Mobile = noTel3Mobile;
    }
}
