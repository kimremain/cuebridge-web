package com.jcuesoft.cuebridge.st.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StUserLogRequestVO extends BaseVO {

    private static final long serialVersionUID = 5435821108128478613L;

    private String searchIdUser;

    private String searchDmRegFrom;

    private String searchDmRegTo;

    private String searchDsPgmId;
    
    private String searchCdUserAction;
    
    private String logDsRemk;
    
    // UserLogFilter 에서 사용 
    
    private String idUser;

    private String noReq;

    private String dsUrl;

    private String cdUserAction;

    private String dsRemk;

    public String getSearchDmRegFrom() {
        return searchDmRegFrom;
    }

    public void setSearchDmRegFrom(String searchDmRegFrom) {
        this.searchDmRegFrom = searchDmRegFrom;
    }

    public String getSearchIdUser() {
        return searchIdUser;
    }

    public void setSearchIdUser(String searchIdUser) {
        this.searchIdUser = searchIdUser;
    }

    public String getSearchDmRegTo() {
        return searchDmRegTo;
    }

    public void setSearchDmRegTo(String searchDmRegTo) {
        this.searchDmRegTo = searchDmRegTo;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }

    public String getDsUrl() {
        return dsUrl;
    }

    public void setDsUrl(String dsUrl) {
        this.dsUrl = dsUrl;
    }

    public String getCdUserAction() {
        return cdUserAction;
    }

    public void setCdUserAction(String cdUserAction) {
        this.cdUserAction = cdUserAction;
    }

    public String getDsRemk() {
        return dsRemk;
    }

    public void setDsRemk(String dsRemk) {
        this.dsRemk = dsRemk;
    }

    public String getSearchDsPgmId() {
        return searchDsPgmId;
    }

    public void setSearchDsPgmId(String searchDsPgmId) {
        this.searchDsPgmId = searchDsPgmId;
    }

    public String getSearchCdUserAction() {
        return searchCdUserAction;
    }

    public void setSearchCdUserAction(String searchCdUserAction) {
        this.searchCdUserAction = searchCdUserAction;
    }

    public String getLogDsRemk() {
        return logDsRemk;
    }

    public void setLogDsRemk(String logDsRemk) {
        this.logDsRemk = logDsRemk;
    }


}














