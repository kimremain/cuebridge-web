package com.jcuesoft.cuebridge.st.vo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class StProgramRequestVO extends BaseVO {

    private static final long serialVersionUID = 6308938334542520408L;

    private String searchDsPgm;

    private String no;

    //   // \d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])-[1-4]\d{6}  // 주민등록 번호
//    @Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$")  // 이메일
    @Size(min=4, max=20) @Pattern(regexp="^([a-zA-Z0-9]+)$", message="프로그램명은 영숫자만 허용합니다.")  // 영문숫자
    private String dsPgmId;
    
    @Size(min=4, max=40, message="프로그램이름은 {min}자 이상 {max}자 이하로 입력하여 주십시오.")
    private String dsPgm;

    @Size(min=3, max=100, message="프로그램 URL은 [min]자이상 {max}자 이하로 입력하여 주십시오.")
    private String dsUrl;

    @NotBlank @Size(min=1, max=6, message="온라인 배치 구분코드를 선택하여 주세요.")
    private String cdOnoff;

    @NotBlank(message="관리자프로그램여부를 선택하여 주십시오.")
    private String ynAdmin;
    
    @NotBlank(message="적용 여부를 선택하여 주십시오.")
    private String ynApply;

//    @NotBlank @Size(min=1, max=400)
    private String dsHelp;

    private String dmReg;

    private String idReg;

    private String dmUpt;

    private String idUpt;
    
    private String errMsg;


    public String getSearchDsPgm() {
        return searchDsPgm;
    }

    public void setSearchDsPgm(String searchDsPgm) {
        this.searchDsPgm = searchDsPgm;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDsPgmId() {
        return dsPgmId;
    }

    public void setDsPgmId(String dsPgmId) {
        this.dsPgmId = dsPgmId;
    }

    public String getDsPgm() {
        return dsPgm;
    }

    public void setDsPgm(String dsPgm) {
        this.dsPgm = dsPgm;
    }

    public String getDsUrl() {
        return dsUrl;
    }

    public void setDsUrl(String dsUrl) {
        this.dsUrl = dsUrl;
    }

    public String getCdOnoff() {
        return cdOnoff;
    }

    public void setCdOnoff(String cdOnoff) {
        this.cdOnoff = cdOnoff;
    }

    public String getYnAdmin() {
        return ynAdmin;
    }

    public void setYnAdmin(String ynAdmin) {
        this.ynAdmin = ynAdmin;
    }

    public String getYnApply() {
        return ynApply;
    }

    public void setYnApply(String ynApply) {
        this.ynApply = ynApply;
    }

    public String getDsHelp() {
        return dsHelp;
    }

    public void setDsHelp(String dsHelp) {
        this.dsHelp = dsHelp;
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

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
