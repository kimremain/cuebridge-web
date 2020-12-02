package com.jcuesoft.cuebridge.brc.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcImageListResponseVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = 7523569025961899853L;
    
    private String noReq;
    private String noRcvTel;
    private String dmRcv;
    private String dsMsg;
    private String dsFile;
    private String dsFileBase64;
    
    public String getNoRcvTel() {
        return noRcvTel;
    }
    public void setNoRcvTel(String noRcvTel) {
        this.noRcvTel = noRcvTel;
    }
    public String getDmRcv() {
        return dmRcv;
    }
    public void setDmRcv(String dmRcv) {
        this.dmRcv = dmRcv;
    }
    public String getDsMsg() {
        return dsMsg;
    }
    public void setDsMsg(String dsMsg) {
        this.dsMsg = dsMsg;
    }
    public String getDsFile() {
        return dsFile;
    }
    public void setDsFile(String dsFile) {
        this.dsFile = dsFile;
    }
    public String getNoReq() {
        return noReq;
    }
    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }
    public String getDsFileBase64() {
        return dsFileBase64;
    }
    public void setDsFileBase64(String dsFileBase64) {
        this.dsFileBase64 = dsFileBase64;
    }
   
    

}
