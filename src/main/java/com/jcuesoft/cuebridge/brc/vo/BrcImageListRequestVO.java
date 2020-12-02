package com.jcuesoft.cuebridge.brc.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcImageListRequestVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = -1872663553467893228L;

    private String searchKind;
    
    private String searchParam;
    
    private String dsFile;
    
    private String dsFileBase64;
    
    private String noReq;

    public String getSearchKind() {
        return searchKind;
    }

    public void setSearchKind(String searchKind) {
        this.searchKind = searchKind;
    }

    public String getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }

    public String getDsFile() {
        return dsFile;
    }

    public void setDsFile(String dsFile) {
        this.dsFile = dsFile;
    }

    public String getDsFileBase64() {
        return dsFileBase64;
    }

    public void setDsFileBase64(String dsFileBase64) {
        this.dsFileBase64 = dsFileBase64;
    }
   
    

}
