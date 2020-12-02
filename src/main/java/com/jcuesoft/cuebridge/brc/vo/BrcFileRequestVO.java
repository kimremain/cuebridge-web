package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcFileRequestVO extends BaseVO{
    
    /**
     * 
     */
    private static final long serialVersionUID = 4610411922177101385L;

    private MultipartFile file;    
    
    private BigDecimal no;

    private String noReq;

    private String noImg;

    private String cdFile;

    private String nmFile;
    
    private String nmFileUser;

    private String dsPath;

    private String dsUrl;

    private String dsRemk;

    private Date dmReg;

    private String idReg;

    private Date dmUpt;

    private String idUpt;
    
    private String dsFileFrom;

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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getNmFileUser() {
        return nmFileUser;
    }

    public void setNmFileUser(String nmFileUser) {
        this.nmFileUser = nmFileUser;
    }

    public String getDsFileFrom() {
        return dsFileFrom;
    }

    public void setDsFileFrom(String dsFileFrom) {
        this.dsFileFrom = dsFileFrom;
    }


}
