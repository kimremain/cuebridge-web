package com.jcuesoft.cuebridge.bex.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BexToActCashVO extends BaseVO{

    /**
     * 
     */
    private static final long serialVersionUID = 8273563343631103857L;
    
    //IN PARAM
    private String noReq;
    private String noEx;
    
    //신청정보 매핑항목
    private String ds_url;
    private String mode;
    private String nm_applicant;
    private String ssn_applicant;
    private String amt_apply;
    private String no_agency;    
    private String id_agency;
    private String hp;
    private String post_home;
    private String addr1_home;
    private String addr2_home;
    private String cd_hp_co;
    private String cd_marry;
    private String cd_job_class;
    private String nm_comp;
    private String ph_comp;
    private String nm_duty_comp;
    private String nm_part_comp;
    private String ym_start_comp;
    private String amt_monthly_income;
    private String url_attach_file1;
    private String url_attach_file2;
    private String url_attach_file3;
    private String url_attach_file4;
    private String url_attach_file5;
    private String url_attach_file6;
    private String url_attach_file7;
    private String url_attach_file8;
    private String url_attach_file9;
    private String url_attach_file10;    
    private String cd_goods;    
    private String memo_agency;
    
    //보증인정보 매핑항목
    private String nm_grt_list;    
    private String ssn_grt_list;
    private String hp_grt_list;
    private String cd_job_class_grt_list;
    
    //접수경로 매핑항목
    private String seq_agency_level_list;
    private String ymd_agency_list;
    private String nm_agency_list;
    private String no_agency_list;
    private String ph_agency_list;
    private String no_institute_list;    
    
    //적접수집 매핑항목
    private String agent_path_type;
    private String agent_path_route;
    private String agent_path_call;
    private String agent_path_name;
    private String agent_owner;
    private String agent_homepage;
    private String agent_staff;
    private String agent_date;
    private String agent_path_etc;
    
    //신청정보
    private String cd_used_apply;
    private String c3_bank;
    private String account_bank;
    private String yn_secret;
    private String yn_vehicle_own;
    private String etc_vehicles;
    private String ph_home;
    private String cd_ph_co_home;
    private String nm_ph_owner;
    private String rel_ph_owner;
    private String cd_house_type_home;
    private String ym_house_home;
    private String cd_live_type_home;
    private long amt_rent_deposit_home;
    private long amt_rent_monthly_home;
    private String nm_owner_home;
    private String rel_owner_home;
    private String post_reg;
    private String addr1_reg;
    private String addr2_reg;
    private String cd_house_type_reg;
    private String ym_house_reg;
    private String cd_live_type_reg;
    private long amt_rent_deposit_reg;
    private long amt_rent_monthly_reg;
    private String nm_owner_reg;
    private String rel_owner_reg;
    private String cd50_live_together;
    private String cd_industry;
    private String post_comp;
    private String addr1_comp;
    private String addr2_comp;
    private String fax_comp;
    private String yn_medi_insu_comp;
    private String cd_scale_comp;
    private long cnt_worker;
    private String no_biz_licence;
    private String cd_employ_type;
    private String cd_dd_income;
    private long amt_year_income;
    private String nm_univ;
    private String cd_attend_univ;
    private String cd_grade_univ;
    private String no_univ;
    private String yyyy_enter_univ;
    private String nm_part_univ;
    private String ph_univ;
    private String post_univ;
    private String addr1_univ;
    private String addr2_univ;
    private String etc_job;
    private String cd_army;
    private String etc_apply_path;
    private String nm_agency_sub;
    private String cd_advertisement;

    //지인정보
    private String nm_friend_list;
    private String ssn_friend_list;
    private String rel_friend_list;
    private String yn_live_together_list;
    private String hp_list;
    private String ph_home_list;
    private String post_home_list;
    private String addr1_home_list;
    private String addr2_home_list;
    private String nm_comp_friends_list;
    private String ph_comp_list;
    private String yn_secret_list;
    private String etc_memo_list;

    //보증인정보
    private String rel_grt_list;
    private String ph_home_grt_list;
    private String post_home_grt_list;
    private String addr1_home_grt_list;
    private String addr2_home_grt_list;
    private String post_reg_grt_list;
    private String addr1_reg_grt_list;
    private String addr2_reg_grt_list;
    private String post_comp_grt_list;
    private String addr1_comp_grt_list;
    private String addr2_comp_grt_list;
    private String nm_comp_grt_list;
    private String ph_comp_grt_list;
    private String etc_memo_grt_list;

    //타사대출
    private String cd_loan_bank_type_list;
    private String cd_loan_type_list;
    private String nm_comp_list;
    private long amt_loan_first_list;
    private long amt_balance_list;
    private long amt_monthly_receipt_list;
    private String dd_receipt_list;

    //심사정보
    private String yn_realman_chk;
    private String nm_hp_owner;
    private String rel_hp_owner;
    private long amt_hp_unpaid;
    private String dd_receipt;
    private String cd_comp_chk;
    private String nm_comp_chk_talk;
    

    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public String getNm_applicant() {
        return nm_applicant;
    }
    public void setNm_applicant(String nm_applicant) {
        this.nm_applicant = nm_applicant;
    }
    public String getSsn_applicant() {
        return ssn_applicant;
    }
    public void setSsn_applicant(String ssn_applicant) {
        this.ssn_applicant = ssn_applicant;
    }
    public String getAmt_apply() {
        return amt_apply;
    }
    public void setAmt_apply(String amt_apply) {
        this.amt_apply = amt_apply;
    }
    public String getNo_agency() {
        return no_agency;
    }
    public void setNo_agency(String no_agency) {
        this.no_agency = no_agency;
    }
    public String getId_agency() {
        return id_agency;
    }
    public void setId_agency(String id_agency) {
        this.id_agency = id_agency;
    }
    public String getMemo_agency() {
        return memo_agency;
    }
    public void setMemo_agency(String memo_agency) {
        this.memo_agency = memo_agency;
    }
    public String getHp() {
        return hp;
    }
    public void setHp(String hp) {
        this.hp = hp;
    }
    public String getPost_home() {
        return post_home;
    }
    public void setPost_home(String post_home) {
        this.post_home = post_home;
    }
    public String getAddr1_home() {
        return addr1_home;
    }
    public void setAddr1_home(String addr1_home) {
        this.addr1_home = addr1_home;
    }
    public String getAddr2_home() {
        return addr2_home;
    }
    public void setAddr2_home(String addr2_home) {
        this.addr2_home = addr2_home;
    }
    public String getCd_hp_co() {
        return cd_hp_co;
    }
    public void setCd_hp_co(String cd_hp_co) {
        this.cd_hp_co = cd_hp_co;
    }
    public String getCd_marry() {
        return cd_marry;
    }
    public void setCd_marry(String cd_marry) {
        this.cd_marry = cd_marry;
    }
    public String getCd_used_apply() {
        return cd_used_apply;
    }
    public void setCd_used_apply(String cd_used_apply) {
        this.cd_used_apply = cd_used_apply;
    }
    public String getC3_bank() {
        return c3_bank;
    }
    public void setC3_bank(String c3_bank) {
        this.c3_bank = c3_bank;
    }
    public String getAccount_bank() {
        return account_bank;
    }
    public void setAccount_bank(String account_bank) {
        this.account_bank = account_bank;
    }
    public String getYn_secret() {
        return yn_secret;
    }
    public void setYn_secret(String yn_secret) {
        this.yn_secret = yn_secret;
    }
    public String getYn_vehicle_own() {
        return yn_vehicle_own;
    }
    public void setYn_vehicle_own(String yn_vehicle_own) {
        this.yn_vehicle_own = yn_vehicle_own;
    }
    public String getEtc_vehicles() {
        return etc_vehicles;
    }
    public void setEtc_vehicles(String etc_vehicles) {
        this.etc_vehicles = etc_vehicles;
    }
    public String getPh_home() {
        return ph_home;
    }
    public void setPh_home(String ph_home) {
        this.ph_home = ph_home;
    }
    public String getCd_ph_co_home() {
        return cd_ph_co_home;
    }
    public void setCd_ph_co_home(String cd_ph_co_home) {
        this.cd_ph_co_home = cd_ph_co_home;
    }
    public String getNm_ph_owner() {
        return nm_ph_owner;
    }
    public void setNm_ph_owner(String nm_ph_owner) {
        this.nm_ph_owner = nm_ph_owner;
    }
    public String getRel_ph_owner() {
        return rel_ph_owner;
    }
    public void setRel_ph_owner(String rel_ph_owner) {
        this.rel_ph_owner = rel_ph_owner;
    }
    public String getCd_house_type_home() {
        return cd_house_type_home;
    }
    public void setCd_house_type_home(String cd_house_type_home) {
        this.cd_house_type_home = cd_house_type_home;
    }
    public String getYm_house_home() {
        return ym_house_home;
    }
    public void setYm_house_home(String ym_house_home) {
        this.ym_house_home = ym_house_home;
    }
    public String getCd_live_type_home() {
        return cd_live_type_home;
    }
    public void setCd_live_type_home(String cd_live_type_home) {
        this.cd_live_type_home = cd_live_type_home;
    }
    public long getAmt_rent_deposit_home() {
        return amt_rent_deposit_home;
    }
    public void setAmt_rent_deposit_home(long amt_rent_deposit_home) {
        this.amt_rent_deposit_home = amt_rent_deposit_home;
    }
    public long getAmt_rent_monthly_home() {
        return amt_rent_monthly_home;
    }
    public void setAmt_rent_monthly_home(long amt_rent_monthly_home) {
        this.amt_rent_monthly_home = amt_rent_monthly_home;
    }
    public String getNm_owner_home() {
        return nm_owner_home;
    }
    public void setNm_owner_home(String nm_owner_home) {
        this.nm_owner_home = nm_owner_home;
    }
    public String getRel_owner_home() {
        return rel_owner_home;
    }
    public void setRel_owner_home(String rel_owner_home) {
        this.rel_owner_home = rel_owner_home;
    }
    public String getPost_reg() {
        return post_reg;
    }
    public void setPost_reg(String post_reg) {
        this.post_reg = post_reg;
    }
    public String getAddr1_reg() {
        return addr1_reg;
    }
    public void setAddr1_reg(String addr1_reg) {
        this.addr1_reg = addr1_reg;
    }
    public String getAddr2_reg() {
        return addr2_reg;
    }
    public void setAddr2_reg(String addr2_reg) {
        this.addr2_reg = addr2_reg;
    }
    public String getCd_house_type_reg() {
        return cd_house_type_reg;
    }
    public void setCd_house_type_reg(String cd_house_type_reg) {
        this.cd_house_type_reg = cd_house_type_reg;
    }
    public String getYm_house_reg() {
        return ym_house_reg;
    }
    public void setYm_house_reg(String ym_house_reg) {
        this.ym_house_reg = ym_house_reg;
    }
    public String getCd_live_type_reg() {
        return cd_live_type_reg;
    }
    public void setCd_live_type_reg(String cd_live_type_reg) {
        this.cd_live_type_reg = cd_live_type_reg;
    }
    public long getAmt_rent_deposit_reg() {
        return amt_rent_deposit_reg;
    }
    public void setAmt_rent_deposit_reg(long amt_rent_deposit_reg) {
        this.amt_rent_deposit_reg = amt_rent_deposit_reg;
    }
    public long getAmt_rent_monthly_reg() {
        return amt_rent_monthly_reg;
    }
    public void setAmt_rent_monthly_reg(long amt_rent_monthly_reg) {
        this.amt_rent_monthly_reg = amt_rent_monthly_reg;
    }
    public String getNm_owner_reg() {
        return nm_owner_reg;
    }
    public void setNm_owner_reg(String nm_owner_reg) {
        this.nm_owner_reg = nm_owner_reg;
    }
    public String getRel_owner_reg() {
        return rel_owner_reg;
    }
    public void setRel_owner_reg(String rel_owner_reg) {
        this.rel_owner_reg = rel_owner_reg;
    }
    public String getCd50_live_together() {
        return cd50_live_together;
    }
    public void setCd50_live_together(String cd50_live_together) {
        this.cd50_live_together = cd50_live_together;
    }
    public String getCd_job_class() {
        return cd_job_class;
    }
    public void setCd_job_class(String cd_job_class) {
        this.cd_job_class = cd_job_class;
    }
    public String getNm_comp() {
        return nm_comp;
    }
    public void setNm_comp(String nm_comp) {
        this.nm_comp = nm_comp;
    }
    public String getCd_industry() {
        return cd_industry;
    }
    public void setCd_industry(String cd_industry) {
        this.cd_industry = cd_industry;
    }
    public String getPost_comp() {
        return post_comp;
    }
    public void setPost_comp(String post_comp) {
        this.post_comp = post_comp;
    }
    public String getAddr1_comp() {
        return addr1_comp;
    }
    public void setAddr1_comp(String addr1_comp) {
        this.addr1_comp = addr1_comp;
    }
    public String getAddr2_comp() {
        return addr2_comp;
    }
    public void setAddr2_comp(String addr2_comp) {
        this.addr2_comp = addr2_comp;
    }
    public String getPh_comp() {
        return ph_comp;
    }
    public void setPh_comp(String ph_comp) {
        this.ph_comp = ph_comp;
    }
    public String getFax_comp() {
        return fax_comp;
    }
    public void setFax_comp(String fax_comp) {
        this.fax_comp = fax_comp;
    }
    public String getNm_duty_comp() {
        return nm_duty_comp;
    }
    public void setNm_duty_comp(String nm_duty_comp) {
        this.nm_duty_comp = nm_duty_comp;
    }
    public String getNm_part_comp() {
        return nm_part_comp;
    }
    public void setNm_part_comp(String nm_part_comp) {
        this.nm_part_comp = nm_part_comp;
    }
    public String getYm_start_comp() {
        return ym_start_comp;
    }
    public void setYm_start_comp(String ym_start_comp) {
        this.ym_start_comp = ym_start_comp;
    }
    public String getYn_medi_insu_comp() {
        return yn_medi_insu_comp;
    }
    public void setYn_medi_insu_comp(String yn_medi_insu_comp) {
        this.yn_medi_insu_comp = yn_medi_insu_comp;
    }
    public String getCd_scale_comp() {
        return cd_scale_comp;
    }
    public void setCd_scale_comp(String cd_scale_comp) {
        this.cd_scale_comp = cd_scale_comp;
    }
    public long getCnt_worker() {
        return cnt_worker;
    }
    public void setCnt_worker(long cnt_worker) {
        this.cnt_worker = cnt_worker;
    }
    public String getNo_biz_licence() {
        return no_biz_licence;
    }
    public void setNo_biz_licence(String no_biz_licence) {
        this.no_biz_licence = no_biz_licence;
    }
    public String getCd_employ_type() {
        return cd_employ_type;
    }
    public void setCd_employ_type(String cd_employ_type) {
        this.cd_employ_type = cd_employ_type;
    }
    public String getCd_dd_income() {
        return cd_dd_income;
    }
    public void setCd_dd_income(String cd_dd_income) {
        this.cd_dd_income = cd_dd_income;
    }
    public String getAmt_monthly_income() {
        return amt_monthly_income;
    }
    public void setAmt_monthly_income(String amt_monthly_income) {
        this.amt_monthly_income = amt_monthly_income;
    }
    public long getAmt_year_income() {
        return amt_year_income;
    }
    public void setAmt_year_income(long amt_year_income) {
        this.amt_year_income = amt_year_income;
    }
    public String getNm_univ() {
        return nm_univ;
    }
    public void setNm_univ(String nm_univ) {
        this.nm_univ = nm_univ;
    }
    public String getCd_attend_univ() {
        return cd_attend_univ;
    }
    public void setCd_attend_univ(String cd_attend_univ) {
        this.cd_attend_univ = cd_attend_univ;
    }
    public String getCd_grade_univ() {
        return cd_grade_univ;
    }
    public void setCd_grade_univ(String cd_grade_univ) {
        this.cd_grade_univ = cd_grade_univ;
    }
    public String getNo_univ() {
        return no_univ;
    }
    public void setNo_univ(String no_univ) {
        this.no_univ = no_univ;
    }
    public String getYyyy_enter_univ() {
        return yyyy_enter_univ;
    }
    public void setYyyy_enter_univ(String yyyy_enter_univ) {
        this.yyyy_enter_univ = yyyy_enter_univ;
    }
    public String getNm_part_univ() {
        return nm_part_univ;
    }
    public void setNm_part_univ(String nm_part_univ) {
        this.nm_part_univ = nm_part_univ;
    }
    public String getPh_univ() {
        return ph_univ;
    }
    public void setPh_univ(String ph_univ) {
        this.ph_univ = ph_univ;
    }
    public String getPost_univ() {
        return post_univ;
    }
    public void setPost_univ(String post_univ) {
        this.post_univ = post_univ;
    }
    public String getAddr1_univ() {
        return addr1_univ;
    }
    public void setAddr1_univ(String addr1_univ) {
        this.addr1_univ = addr1_univ;
    }
    public String getAddr2_univ() {
        return addr2_univ;
    }
    public void setAddr2_univ(String addr2_univ) {
        this.addr2_univ = addr2_univ;
    }
    public String getEtc_job() {
        return etc_job;
    }
    public void setEtc_job(String etc_job) {
        this.etc_job = etc_job;
    }
    public String getCd_army() {
        return cd_army;
    }
    public void setCd_army(String cd_army) {
        this.cd_army = cd_army;
    }
    public String getEtc_apply_path() {
        return etc_apply_path;
    }
    public void setEtc_apply_path(String etc_apply_path) {
        this.etc_apply_path = etc_apply_path;
    }
    public String getUrl_attach_file1() {
        return url_attach_file1;
    }
    public void setUrl_attach_file1(String url_attach_file1) {
        this.url_attach_file1 = url_attach_file1;
    }
    public String getUrl_attach_file2() {
        return url_attach_file2;
    }
    public void setUrl_attach_file2(String url_attach_file2) {
        this.url_attach_file2 = url_attach_file2;
    }
    public String getUrl_attach_file3() {
        return url_attach_file3;
    }
    public void setUrl_attach_file3(String url_attach_file3) {
        this.url_attach_file3 = url_attach_file3;
    }
    public String getUrl_attach_file4() {
        return url_attach_file4;
    }
    public void setUrl_attach_file4(String url_attach_file4) {
        this.url_attach_file4 = url_attach_file4;
    }
    public String getUrl_attach_file5() {
        return url_attach_file5;
    }
    public void setUrl_attach_file5(String url_attach_file5) {
        this.url_attach_file5 = url_attach_file5;
    }
    public String getUrl_attach_file6() {
        return url_attach_file6;
    }
    public void setUrl_attach_file6(String url_attach_file6) {
        this.url_attach_file6 = url_attach_file6;
    }
    public String getUrl_attach_file7() {
        return url_attach_file7;
    }
    public void setUrl_attach_file7(String url_attach_file7) {
        this.url_attach_file7 = url_attach_file7;
    }
    public String getUrl_attach_file8() {
        return url_attach_file8;
    }
    public void setUrl_attach_file8(String url_attach_file8) {
        this.url_attach_file8 = url_attach_file8;
    }
    public String getUrl_attach_file9() {
        return url_attach_file9;
    }
    public void setUrl_attach_file9(String url_attach_file9) {
        this.url_attach_file9 = url_attach_file9;
    }
    public String getUrl_attach_file10() {
        return url_attach_file10;
    }
    public void setUrl_attach_file10(String url_attach_file10) {
        this.url_attach_file10 = url_attach_file10;
    }
    public String getCd_goods() {
        return cd_goods;
    }
    public void setCd_goods(String cd_goods) {
        this.cd_goods = cd_goods;
    }
    public String getNm_agency_sub() {
        return nm_agency_sub;
    }
    public void setNm_agency_sub(String nm_agency_sub) {
        this.nm_agency_sub = nm_agency_sub;
    }
    public String getCd_advertisement() {
        return cd_advertisement;
    }
    public void setCd_advertisement(String cd_advertisement) {
        this.cd_advertisement = cd_advertisement;
    }
    public String getNm_friend_list() {
        return nm_friend_list;
    }
    public void setNm_friend_list(String nm_friend_list) {
        this.nm_friend_list = nm_friend_list;
    }
    public String getSsn_friend_list() {
        return ssn_friend_list;
    }
    public void setSsn_friend_list(String ssn_friend_list) {
        this.ssn_friend_list = ssn_friend_list;
    }
    public String getRel_friend_list() {
        return rel_friend_list;
    }
    public void setRel_friend_list(String rel_friend_list) {
        this.rel_friend_list = rel_friend_list;
    }
    public String getYn_live_together_list() {
        return yn_live_together_list;
    }
    public void setYn_live_together_list(String yn_live_together_list) {
        this.yn_live_together_list = yn_live_together_list;
    }
    public String getHp_list() {
        return hp_list;
    }
    public void setHp_list(String hp_list) {
        this.hp_list = hp_list;
    }
    public String getPh_home_list() {
        return ph_home_list;
    }
    public void setPh_home_list(String ph_home_list) {
        this.ph_home_list = ph_home_list;
    }
    public String getPost_home_list() {
        return post_home_list;
    }
    public void setPost_home_list(String post_home_list) {
        this.post_home_list = post_home_list;
    }
    public String getAddr1_home_list() {
        return addr1_home_list;
    }
    public void setAddr1_home_list(String addr1_home_list) {
        this.addr1_home_list = addr1_home_list;
    }
    public String getAddr2_home_list() {
        return addr2_home_list;
    }
    public void setAddr2_home_list(String addr2_home_list) {
        this.addr2_home_list = addr2_home_list;
    }
    public String getNm_comp_friends_list() {
        return nm_comp_friends_list;
    }
    public void setNm_comp_friends_list(String nm_comp_friends_list) {
        this.nm_comp_friends_list = nm_comp_friends_list;
    }
    public String getPh_comp_list() {
        return ph_comp_list;
    }
    public void setPh_comp_list(String ph_comp_list) {
        this.ph_comp_list = ph_comp_list;
    }
    public String getYn_secret_list() {
        return yn_secret_list;
    }
    public void setYn_secret_list(String yn_secret_list) {
        this.yn_secret_list = yn_secret_list;
    }
    public String getEtc_memo_list() {
        return etc_memo_list;
    }
    public void setEtc_memo_list(String etc_memo_list) {
        this.etc_memo_list = etc_memo_list;
    }
    public String getNm_grt_list() {
        return nm_grt_list;
    }
    public void setNm_grt_list(String nm_grt_list) {
        this.nm_grt_list = nm_grt_list;
    }
    public String getSsn_grt_list() {
        return ssn_grt_list;
    }
    public void setSsn_grt_list(String ssn_grt_list) {
        this.ssn_grt_list = ssn_grt_list;
    }
    public String getRel_grt_list() {
        return rel_grt_list;
    }
    public void setRel_grt_list(String rel_grt_list) {
        this.rel_grt_list = rel_grt_list;
    }
    public String getHp_grt_list() {
        return hp_grt_list;
    }
    public void setHp_grt_list(String hp_grt_list) {
        this.hp_grt_list = hp_grt_list;
    }
    public String getPh_home_grt_list() {
        return ph_home_grt_list;
    }
    public void setPh_home_grt_list(String ph_home_grt_list) {
        this.ph_home_grt_list = ph_home_grt_list;
    }
    public String getPost_home_grt_list() {
        return post_home_grt_list;
    }
    public void setPost_home_grt_list(String post_home_grt_list) {
        this.post_home_grt_list = post_home_grt_list;
    }
    public String getAddr1_home_grt_list() {
        return addr1_home_grt_list;
    }
    public void setAddr1_home_grt_list(String addr1_home_grt_list) {
        this.addr1_home_grt_list = addr1_home_grt_list;
    }
    public String getAddr2_home_grt_list() {
        return addr2_home_grt_list;
    }
    public void setAddr2_home_grt_list(String addr2_home_grt_list) {
        this.addr2_home_grt_list = addr2_home_grt_list;
    }
    public String getPost_reg_grt_list() {
        return post_reg_grt_list;
    }
    public void setPost_reg_grt_list(String post_reg_grt_list) {
        this.post_reg_grt_list = post_reg_grt_list;
    }
    public String getAddr1_reg_grt_list() {
        return addr1_reg_grt_list;
    }
    public void setAddr1_reg_grt_list(String addr1_reg_grt_list) {
        this.addr1_reg_grt_list = addr1_reg_grt_list;
    }
    public String getAddr2_reg_grt_list() {
        return addr2_reg_grt_list;
    }
    public void setAddr2_reg_grt_list(String addr2_reg_grt_list) {
        this.addr2_reg_grt_list = addr2_reg_grt_list;
    }
    public String getPost_comp_grt_list() {
        return post_comp_grt_list;
    }
    public void setPost_comp_grt_list(String post_comp_grt_list) {
        this.post_comp_grt_list = post_comp_grt_list;
    }
    public String getAddr1_comp_grt_list() {
        return addr1_comp_grt_list;
    }
    public void setAddr1_comp_grt_list(String addr1_comp_grt_list) {
        this.addr1_comp_grt_list = addr1_comp_grt_list;
    }
    public String getAddr2_comp_grt_list() {
        return addr2_comp_grt_list;
    }
    public void setAddr2_comp_grt_list(String addr2_comp_grt_list) {
        this.addr2_comp_grt_list = addr2_comp_grt_list;
    }
    public String getNm_comp_grt_list() {
        return nm_comp_grt_list;
    }
    public void setNm_comp_grt_list(String nm_comp_grt_list) {
        this.nm_comp_grt_list = nm_comp_grt_list;
    }
    public String getPh_comp_grt_list() {
        return ph_comp_grt_list;
    }
    public void setPh_comp_grt_list(String ph_comp_grt_list) {
        this.ph_comp_grt_list = ph_comp_grt_list;
    }
    public String getCd_job_class_grt_list() {
        return cd_job_class_grt_list;
    }
    public void setCd_job_class_grt_list(String cd_job_class_grt_list) {
        this.cd_job_class_grt_list = cd_job_class_grt_list;
    }
    public String getEtc_memo_grt_list() {
        return etc_memo_grt_list;
    }
    public void setEtc_memo_grt_list(String etc_memo_grt_list) {
        this.etc_memo_grt_list = etc_memo_grt_list;
    }
    public String getCd_loan_bank_type_list() {
        return cd_loan_bank_type_list;
    }
    public void setCd_loan_bank_type_list(String cd_loan_bank_type_list) {
        this.cd_loan_bank_type_list = cd_loan_bank_type_list;
    }
    public String getCd_loan_type_list() {
        return cd_loan_type_list;
    }
    public void setCd_loan_type_list(String cd_loan_type_list) {
        this.cd_loan_type_list = cd_loan_type_list;
    }
    public String getNm_comp_list() {
        return nm_comp_list;
    }
    public void setNm_comp_list(String nm_comp_list) {
        this.nm_comp_list = nm_comp_list;
    }
    public long getAmt_loan_first_list() {
        return amt_loan_first_list;
    }
    public void setAmt_loan_first_list(long amt_loan_first_list) {
        this.amt_loan_first_list = amt_loan_first_list;
    }
    public long getAmt_balance_list() {
        return amt_balance_list;
    }
    public void setAmt_balance_list(long amt_balance_list) {
        this.amt_balance_list = amt_balance_list;
    }
    public long getAmt_monthly_receipt_list() {
        return amt_monthly_receipt_list;
    }
    public void setAmt_monthly_receipt_list(long amt_monthly_receipt_list) {
        this.amt_monthly_receipt_list = amt_monthly_receipt_list;
    }
    public String getDd_receipt_list() {
        return dd_receipt_list;
    }
    public void setDd_receipt_list(String dd_receipt_list) {
        this.dd_receipt_list = dd_receipt_list;
    }
    public String getYn_realman_chk() {
        return yn_realman_chk;
    }
    public void setYn_realman_chk(String yn_realman_chk) {
        this.yn_realman_chk = yn_realman_chk;
    }
    public String getNm_hp_owner() {
        return nm_hp_owner;
    }
    public void setNm_hp_owner(String nm_hp_owner) {
        this.nm_hp_owner = nm_hp_owner;
    }
    public String getRel_hp_owner() {
        return rel_hp_owner;
    }
    public void setRel_hp_owner(String rel_hp_owner) {
        this.rel_hp_owner = rel_hp_owner;
    }
    public long getAmt_hp_unpaid() {
        return amt_hp_unpaid;
    }
    public void setAmt_hp_unpaid(long amt_hp_unpaid) {
        this.amt_hp_unpaid = amt_hp_unpaid;
    }
    public String getDd_receipt() {
        return dd_receipt;
    }
    public void setDd_receipt(String dd_receipt) {
        this.dd_receipt = dd_receipt;
    }
    public String getCd_comp_chk() {
        return cd_comp_chk;
    }
    public void setCd_comp_chk(String cd_comp_chk) {
        this.cd_comp_chk = cd_comp_chk;
    }
    public String getNm_comp_chk_talk() {
        return nm_comp_chk_talk;
    }
    public void setNm_comp_chk_talk(String nm_comp_chk_talk) {
        this.nm_comp_chk_talk = nm_comp_chk_talk;
    }
    public String getSeq_agency_level_list() {
        return seq_agency_level_list;
    }
    public void setSeq_agency_level_list(String seq_agency_level_list) {
        this.seq_agency_level_list = seq_agency_level_list;
    }
    public String getYmd_agency_list() {
        return ymd_agency_list;
    }
    public void setYmd_agency_list(String ymd_agency_list) {
        this.ymd_agency_list = ymd_agency_list;
    }
    public String getNm_agency_list() {
        return nm_agency_list;
    }
    public void setNm_agency_list(String nm_agency_list) {
        this.nm_agency_list = nm_agency_list;
    }
    public String getNo_agency_list() {
        return no_agency_list;
    }
    public void setNo_agency_list(String no_agency_list) {
        this.no_agency_list = no_agency_list;
    }
    public String getPh_agency_list() {
        return ph_agency_list;
    }
    public void setPh_agency_list(String ph_agency_list) {
        this.ph_agency_list = ph_agency_list;
    }
    public String getNo_institute_list() {
        return no_institute_list;
    }
    public void setNo_institute_list(String no_institute_list) {
        this.no_institute_list = no_institute_list;
    }
    public String getNoReq() {
        return noReq;
    }
    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }
    public String getNoEx() {
        return noEx;
    }
    public void setNoEx(String noEx) {
        this.noEx = noEx;
    }
    public String getDs_url() {
        return ds_url;
    }
    public void setDs_url(String ds_url) {
        this.ds_url = ds_url;
    }
    public String getAgent_path_type() {
        return agent_path_type;
    }
    public void setAgent_path_type(String agent_path_type) {
        this.agent_path_type = agent_path_type;
    }
    public String getAgent_path_route() {
        return agent_path_route;
    }
    public void setAgent_path_route(String agent_path_route) {
        this.agent_path_route = agent_path_route;
    }
    public String getAgent_path_call() {
        return agent_path_call;
    }
    public void setAgent_path_call(String agent_path_call) {
        this.agent_path_call = agent_path_call;
    }
    public String getAgent_path_name() {
        return agent_path_name;
    }
    public void setAgent_path_name(String agent_path_name) {
        this.agent_path_name = agent_path_name;
    }
    public String getAgent_owner() {
        return agent_owner;
    }
    public void setAgent_owner(String agent_owner) {
        this.agent_owner = agent_owner;
    }
    public String getAgent_homepage() {
        return agent_homepage;
    }
    public void setAgent_homepage(String agent_homepage) {
        this.agent_homepage = agent_homepage;
    }
    public String getAgent_staff() {
        return agent_staff;
    }
    public void setAgent_staff(String agent_staff) {
        this.agent_staff = agent_staff;
    }
    public String getAgent_date() {
        return agent_date;
    }
    public void setAgent_date(String agent_date) {
        this.agent_date = agent_date;
    }
    public String getAgent_path_etc() {
        return agent_path_etc;
    }
    public void setAgent_path_etc(String agent_path_etc) {
        this.agent_path_etc = agent_path_etc;
    }

    

}
