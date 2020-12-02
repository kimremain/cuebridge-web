package com.jcuesoft.cuebridge.st.vo;

import java.util.Date;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StSettingRequestVO extends BaseVO {

    /**
	 * 
	 */
    private static final long serialVersionUID = -5234285815676881111L;

    private String ynDailyBatch;

    private String ynScreenAssign;
    
    private String ynSyncUser;
    
    private String ynSyncTeam;
    
    private String ynOnlineBatch;

    private String ynUserMsg;

    private String dsNiceCd;

    private String dsNiceTcpId;

    private String dsNiceFtpId;

    private String dsNiceFtpPwd;

    private Date dmReg;

    private String idReg;

    private Date dmUpt;

    private String idUpt;

    public String getYnDailyBatch() {
        return ynDailyBatch;
    }

    public void setYnDailyBatch(String ynDailyBatch) {
        this.ynDailyBatch = ynDailyBatch;
    }

    public String getYnOnlineBatch() {
        return ynOnlineBatch;
    }

    public void setYnOnlineBatch(String ynOnlineBatch) {
        this.ynOnlineBatch = ynOnlineBatch;
    }

    public String getYnUserMsg() {
        return ynUserMsg;
    }

    public void setYnUserMsg(String ynUserMsg) {
        this.ynUserMsg = ynUserMsg;
    }

    public String getDsNiceCd() {
        return dsNiceCd;
    }

    public void setDsNiceCd(String dsNiceCd) {
        this.dsNiceCd = dsNiceCd;
    }

    public String getDsNiceTcpId() {
        return dsNiceTcpId;
    }

    public void setDsNiceTcpId(String dsNiceTcpId) {
        this.dsNiceTcpId = dsNiceTcpId;
    }

    public String getDsNiceFtpId() {
        return dsNiceFtpId;
    }

    public void setDsNiceFtpId(String dsNiceFtpId) {
        this.dsNiceFtpId = dsNiceFtpId;
    }

    public String getDsNiceFtpPwd() {
        return dsNiceFtpPwd;
    }

    public void setDsNiceFtpPwd(String dsNiceFtpPwd) {
        this.dsNiceFtpPwd = dsNiceFtpPwd;
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

    public String getYnScreenAssign() {
        return ynScreenAssign;
    }

    public void setYnScreenAssign(String ynScreenAssign) {
        this.ynScreenAssign = ynScreenAssign;
    }

    public String getYnSyncUser() {
        return ynSyncUser;
    }

    public void setYnSyncUser(String ynSyncUser) {
        this.ynSyncUser = ynSyncUser;
    }

    public String getYnSyncTeam() {
        return ynSyncTeam;
    }

    public void setYnSyncTeam(String ynSyncTeam) {
        this.ynSyncTeam = ynSyncTeam;
    }

}
