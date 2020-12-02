package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcReAppFileListVO extends BaseVO{

    /**
     * 
     */
    private static final long serialVersionUID = 7207516723433860588L;
    
    private BigDecimal no;
    
    private String noReq;
    
    private String noImg;
    
    private String dsPath;
    
    private String nmFile;

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

    public String getDsPath() {
        return dsPath;
    }

    public void setDsPath(String dsPath) {
        this.dsPath = dsPath;
    }

    public String getNmFile() {
        return nmFile;
    }

    public void setNmFile(String nmFile) {
        this.nmFile = nmFile;
    }

    public String getNoImg() {
        return noImg;
    }

    public void setNoImg(String noImg) {
        this.noImg = noImg;
    }

    

}
