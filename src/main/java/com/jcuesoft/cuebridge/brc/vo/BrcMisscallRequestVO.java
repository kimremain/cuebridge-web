package com.jcuesoft.cuebridge.brc.vo;


import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcMisscallRequestVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = -102718141260435951L;

    private String searchMode;
    private String searchNoTel;
    private String searchCdCallProc;
    private String searchDmRegStart;
    private String searchDmRegEnd;
    
    
    
    private String updateBatchNo[];
    private String updateBatchNoTel[];
    private String updateBatchDsRemk[];
    private String updateCdCallProc;
    
    // 업데이트 항목 
    private String no;
    private String noTel;
    private String dsRemk;
    private String idUpt;
    private String cdCallProc;

   
    public String getSearchNoTel() {
        return searchNoTel;
    }
    public void setSearchNoTel(String searchNoTel) {
        this.searchNoTel = searchNoTel;
    }
    public String getSearchCdCallProc() {
        return searchCdCallProc;
    }
    public void setSearchCdCallProc(String searchCdCallProc) {
        this.searchCdCallProc = searchCdCallProc;
    }
    public String getSearchDmRegStart() {
        return searchDmRegStart;
    }
    public void setSearchDmRegStart(String searchDmRegStart) {
        this.searchDmRegStart = searchDmRegStart;
    }
    public String getSearchDmRegEnd() {
        return searchDmRegEnd;
    }
    public void setSearchDmRegEnd(String searchDmRegEnd) {
        this.searchDmRegEnd = searchDmRegEnd;
    }
    
    public String getIdUpt() {
        return idUpt;
    }
    public void setIdUpt(String idUpt) {
        this.idUpt = idUpt;
    }
    public String[] getUpdateBatchNo() {
        return updateBatchNo;
    }
    public void setUpdateBatchNo(String[] updateBatchNo) {
        this.updateBatchNo = updateBatchNo;
    }
    public String getUpdateCdCallProc() {
        return updateCdCallProc;
    }
    public void setUpdateCdCallProc(String updateCdCallProc) {
        this.updateCdCallProc = updateCdCallProc;
    }
    public String getSearchMode() {
        return searchMode;
    }
    public void setSearchMode(String searchMode) {
        this.searchMode = searchMode;
    }
    public String[] getUpdateBatchNoTel() {
        return updateBatchNoTel;
    }
    public void setUpdateBatchNoTel(String updateBatchNoTel[]) {
        this.updateBatchNoTel = updateBatchNoTel;
    }
    public String[] getUpdateBatchDsRemk() {
        return updateBatchDsRemk;
    }
    public void setUpdateBatchDsRemk(String updateBatchDsRemk[]) {
        this.updateBatchDsRemk = updateBatchDsRemk;
    }
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
    public String getDsRemk() {
        return dsRemk;
    }
    public void setDsRemk(String dsRemk) {
        this.dsRemk = dsRemk;
    }
    public String getCdCallProc() {
        return cdCallProc;
    }
    public void setCdCallProc(String cdCallProc) {
        this.cdCallProc = cdCallProc;
    }
   
    
}

