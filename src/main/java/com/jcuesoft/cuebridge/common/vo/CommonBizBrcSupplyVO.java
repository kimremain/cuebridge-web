package com.jcuesoft.cuebridge.common.vo;


public class CommonBizBrcSupplyVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = 3513938127459823899L;
    
    // 제공자 일련번호
    private String noSupply;
    // 제공일자
    private String dtSupply;
    // 제공자명
    private String nmSupply;
    // 제공자대부중개번호
    private String noSupplyLoan;
    // 제공자협회등록번호
    private String noSupplySociety;
    // 제공자전화번호 전체 미가공 원본
    private String noSuuplyTel;    
    // 제공자전화번호 좌
    private String noSuuplyTel1;
    // 제공자전화번호 중
    private String noSuuplyTel2;
    // 제공자전화번호 우
    private String noSuuplyTel3;
    
    public String getNoSupply() {
        return noSupply;
    }
    public void setNoSupply(String noSupply) {
        this.noSupply = noSupply;
    }
    public String getDtSupply() {
        return dtSupply;
    }
    public void setDtSupply(String dtSupply) {
        this.dtSupply = dtSupply;
    }
    public String getNmSupply() {
        return nmSupply;
    }
    public void setNmSupply(String nmSupply) {
        this.nmSupply = nmSupply;
    }
    public String getNoSupplyLoan() {
        return noSupplyLoan;
    }
    public void setNoSupplyLoan(String noSupplyLoan) {
        this.noSupplyLoan = noSupplyLoan;
    }
    public String getNoSupplySociety() {
        return noSupplySociety;
    }
    public void setNoSupplySociety(String noSupplySociety) {
        this.noSupplySociety = noSupplySociety;
    }
    public String getNoSuuplyTel1() {
        return noSuuplyTel1;
    }
    public void setNoSuuplyTel1(String noSuuplyTel1) {
        this.noSuuplyTel1 = noSuuplyTel1;
    }
    public String getNoSuuplyTel2() {
        return noSuuplyTel2;
    }
    public void setNoSuuplyTel2(String noSuuplyTel2) {
        this.noSuuplyTel2 = noSuuplyTel2;
    }
    public String getNoSuuplyTel3() {
        return noSuuplyTel3;
    }
    public void setNoSuuplyTel3(String noSuuplyTel3) {
        this.noSuuplyTel3 = noSuuplyTel3;
    }
    public String getNoSuuplyTel() {
        return noSuuplyTel;
    }
    public void setNoSuuplyTel(String noSuuplyTel) {
        this.noSuuplyTel = noSuuplyTel;
    }

}