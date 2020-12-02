package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcFileResponseVO extends BaseVO{
    
    /**
     * 
     */
    private static final long serialVersionUID = -5781832336409127297L;

    private BigDecimal no;

    private String noReq;

    private String noImg;

    private String cdFile;
    
    private String nmCdFile;

    private String nmFile;
    
    private String nmFileUser;

    private String dsPath;

    private String dsUrl;

    private String dsRemk;

    private String dmReg;
    
    private String dmRegChar;

    private String idReg;

    private String dmUpt;

    private String idUpt;
    
    private String dsFileBase64;

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

    public String getNoImg() {
        return noImg;
    }

    public void setNoImg(String noImg) {
        this.noImg = noImg;
    }

    public String getCdFile() {
        return cdFile;
    }

    public void setCdFile(String cdFile) {
        this.cdFile = cdFile;
    }
    
    public String getNmCdFile() {
        return nmCdFile;
    }

    public void setNmCdFile(String nmCdFile) {
        this.nmCdFile = nmCdFile;
    }

    public String getNmFile() {
        return nmFile;
    }

    public void setNmFile(String nmFile) {
        this.nmFile = nmFile;
    }

    public String getDsPath() {
        return dsPath;
    }

    public void setDsPath(String dsPath) {
        this.dsPath = dsPath;
    }

    public String getDsUrl() {
        return dsUrl;
    }

    public void setDsUrl(String dsUrl) {
        this.dsUrl = dsUrl;
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

    public String getNmFileUser() {
        return nmFileUser;
    }

    public void setNmFileUser(String nmFileUser) {
        this.nmFileUser = nmFileUser;
    }

    public String getDmRegChar() {
        return dmRegChar;
    }

    public void setDmRegChar(String dmRegChar) {
        this.dmRegChar = dmRegChar;
    }

    public String getDsFileBase64() {
        return dsFileBase64;
    }

    public void setDsFileBase64(String dsFileBase64) {
        this.dsFileBase64 = dsFileBase64;
    }    

    
}
