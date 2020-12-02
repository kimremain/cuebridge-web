package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcReAppVO extends BaseVO{

    /**
     * 
     */
    private static final long serialVersionUID = 4930736062530537779L;

    private String noReqFrom;
    
    private String noReqTo;
    
    private String noSuretyFrom;
    
    private String noSuretyTo;
    
    private String idReg;
    
    private BigDecimal brcFileSeq;
    
    private BigDecimal brcFileNo;
    
    private String brcFileNmFile;
    
    private String brcFileDsPath;
    

    public String getNoReqFrom() {
        return noReqFrom;
    }

    public void setNoReqFrom(String noReqFrom) {
        this.noReqFrom = noReqFrom;
    }

    public String getNoReqTo() {
        return noReqTo;
    }

    public void setNoReqTo(String noReqTo) {
        this.noReqTo = noReqTo;
    }

    public String getIdReg() {
        return idReg;
    }

    public void setIdReg(String idReg) {
        this.idReg = idReg;
    }

    public String getNoSuretyFrom() {
        return noSuretyFrom;
    }

    public void setNoSuretyFrom(String noSuretyFrom) {
        this.noSuretyFrom = noSuretyFrom;
    }

    public String getNoSuretyTo() {
        return noSuretyTo;
    }

    public void setNoSuretyTo(String noSuretyTo) {
        this.noSuretyTo = noSuretyTo;
    }


    public BigDecimal getBrcFileNo() {
        return brcFileNo;
    }

    public void setBrcFileNo(BigDecimal brcFileNo) {
        this.brcFileNo = brcFileNo;
    }

    public BigDecimal getBrcFileSeq() {
        return brcFileSeq;
    }

    public void setBrcFileSeq(BigDecimal brcFileSeq) {
        this.brcFileSeq = brcFileSeq;
    }

    public String getBrcFileNmFile() {
        return brcFileNmFile;
    }

    public void setBrcFileNmFile(String brcFileNmFile) {
        this.brcFileNmFile = brcFileNmFile;
    }

    public String getBrcFileDsPath() {
        return brcFileDsPath;
    }

    public void setBrcFileDsPath(String brcFileDsPath) {
        this.brcFileDsPath = brcFileDsPath;
    }

    
    
    
}
