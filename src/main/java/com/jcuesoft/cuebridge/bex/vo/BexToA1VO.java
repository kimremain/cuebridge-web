package com.jcuesoft.cuebridge.bex.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BexToA1VO extends BaseVO{


    
    
    /**
     * 
     */
    private static final long serialVersionUID = -1749314463076819998L;
    /*    
     * 매핑컬럼기술
     * */
    //접수처정보 
    private String ds_url;
    private String pro_code;
    private String com_code;
    private String cooperate_code;
    
   // 정보적법수집
    private String info_coll_path;
    private String coll_m1;
    private String coll_m1_memo99;
    private String coll_a1;
    private String coll_a1_memo1;
    private String coll_a1_memo99;
    private String coll_a2;
    private String coll_a2_memo99;
    private String coll_date;
    private String coll_agent_name;
    private String coll_ceo_name;
    private String coll_manager_name;
    
    //회원정보
    private String name;
    private String ssn11;
    private String ssn12;
    private String ph11;
    private String ph12;
    private String ph13;    
    private String ph21;
    private String ph22;
    private String ph23;    
    private String app_money;
    
    //본인직장정보;
    //직장 - 급여소득자;
    private String job_class;
    private String A_com_name;    
    private String A_ph31;
    private String A_ph32;
    private String A_ph33;
    private String A_com_part;
    private String A_worker_term_year;
    private String A_worker_term_month;
    private String A_pay;    
    //이미지;
    private String img_url1;
    private String img_url2;
    private String img_url3;
    private String img_type1;
    private String img_type2;
    private String img_type3;    
    //메모;
    private String memo;        
    
    //보증인
    private String G1_name;
    private String G1_ssn11;
    private String G1_ssn12;
    private String G1_ph11;
    private String G1_ph12;
    private String G1_ph13;
    private String G1_ph21;
    private String G1_ph22;
    private String G1_ph23;
    private String G1_zip11;
    private String G1_zip12;
    private String G1_addr11;
    private String G1_addr12;

    //중개경로
    private String agent_level;
    private String agent_app_date;
    private String agent_name;
    private String agent_ssn;
    private String agent_ph11;
    private String agent_ph12;
    private String agent_ph13;
    private String agent_assn;
    
    private String agent1_level;
    private String agent1_app_date;
    private String agent1_name;
    private String agent1_ssn;
    private String agent1_assn;
    private String agent1_ph11;
    private String agent1_ph12;
    private String agent1_ph13;
    private String agent2_level;
    private String agent2_app_date;
    private String agent2_name;
    private String agent2_ssn;
    private String agent2_assn;
    private String agent2_ph11;
    private String agent2_ph12;
    private String agent2_ph13;
    private String agent3_level;
    private String agent3_app_date;
    private String agent3_name;
    private String agent3_ssn;
    private String agent3_assn;
    private String agent3_ph11;
    private String agent3_ph12;
    private String agent3_ph13;
    private String agent4_level;
    private String agent4_app_date;
    private String agent4_name;
    private String agent4_ssn;
    private String agent4_assn;
    private String agent4_ph11;
    private String agent4_ph12;
    private String agent4_ph13;
    private String agent5_level;
    private String agent5_app_date;
    private String agent5_name;
    private String agent5_ssn;
    private String agent5_assn;
    private String agent5_ph11;
    private String agent5_ph12;
    private String agent5_ph13;
    private String agent6_level;
    private String agent6_app_date;
    private String agent6_name;
    private String agent6_ssn;
    private String agent6_assn;
    private String agent6_ph11;
    private String agent6_ph12;
    private String agent6_ph13;
    private String agent7_level;
    private String agent7_app_date;
    private String agent7_name;
    private String agent7_ssn;
    private String agent7_assn;
    private String agent7_ph11;
    private String agent7_ph12;
    private String agent7_ph13;
    private String agent8_level;
    private String agent8_app_date;
    private String agent8_name;
    private String agent8_ssn;
    private String agent8_assn;
    private String agent8_ph11;
    private String agent8_ph12;
    private String agent8_ph13;
    private String agent9_level;
    private String agent9_app_date;
    private String agent9_name;
    private String agent9_ssn;
    private String agent9_assn;
    private String agent9_ph11;
    private String agent9_ph12;
    private String agent9_ph13;
    
    
    /*    
     * 비매핑컬럼기술
     * */    
    //회원정보;
    private String ph1_name;
    private String ph1_rel;
    private String ph2_name;
    private String ph2_rel;
    private String marry;
    private String living_family;
    private String post;
    //결혼 기혼 - 배우자 존재시;
    private String C_name;
    private String C_ssn11;
    private String C_ssn12;
    private String C_ph21;
    private String C_ph22;
    private String C_ph23;
    private String C_ph2_name;
    private String C_ph2_name_rel;
    //거주 정보;
    private String zip11;
    private String zip12;
    private String addr11;
    private String addr12;
    private String zip41;
    private String zip42;
    private String addr41;
    private String addr42;
    private String house_own_type_cat_no;
    private String house_type_cat_no;
    private String h_size1;
    private String h_price1;
    private String h_price2;
    private String h_term2;
    private String h_price3_1;
    private String h_price3_2;
    private String h_term3;
    private String house_owner_name;
    private String house_owner;
    
    //직장 - 급여소득자;
    private String A_com_type_cat_no;
    private String A_zip21;
    private String A_zip22;
    private String A_addr21;
    private String A_addr22;
    private String A_ph51;
    private String A_ph52;
    private String A_ph53;
    private String A_work_type_cat_no;
    private String A_com_workers;
    private String A_com_grade_cat_no;
    private String insurance;
    private String A_pay_day;
    private String A_bonus_percent;
    private String A_s_yincome;
    private String A_s_incometype;
    private String A_ceo_name;
    private String A_s_com;
    private String A_retire_date;
    private String A_retire_money_cat_no;
    private String A_retire_money;
    private String A_pay_attach;
    //직장 - 자영업자;
    private String B_com_name;
    private String B_ph31;
    private String B_ph32;
    private String B_ph33;
    private String B_ph41;
    private String B_ph42;
    private String B_ph43;
    private String B_com_medic_security;
    private String B_ssn1;
    private String B_ssn2;
    private String B_ssn3;
    private String B_manage_term_year;
    private String B_manage_term_month;
    private String B_com_income;
    private String B_c_worker;
    private String B_zip21;
    private String B_zip22;
    private String B_addr21;
    private String B_addr22;
    private String B_price1;
    private String B_price2;
    //직장 - 학생;
    private String D_com_name;
    private String D_com_depart;
    private String D_school_grade_cat_no;
    private String D_school_status_cat_no;
    private String D_ph31;
    private String D_ph32;
    private String D_ph33;
    private String D_zip21;
    private String D_zip22;
    private String D_addr21;
    private String D_addr22;
    private String D_sc_army;
    private String D_sc_alba_chk;
    private String D_sc_alba_name;
    private String D_pay;
    private String D_pay_day;
    private String D_zip31;
    private String D_zip32;
    private String D_addr31;
    private String D_addr32;
    private String D_ph51;
    private String D_ph52;
    private String D_ph53;
    //직장 - 공무원;
    private String F_com_name;
    private String F_com_part;
    private String F_com_grade_cat_no;
    private String F_com_degree;
    private String F_pay_year;
    private String F_pay;
    private String F_pay_day;
    private String F_zip21;
    private String F_zip22;
    private String F_addr21;
    private String F_addr22;
    private String F_ph61;
    private String F_ph62;
    private String F_ph63;
    private String F_ph31;
    private String F_ph32;
    private String F_ph33;
    //직장 - 군인;
    private String G_com_name;
    private String G_com_grade;
    private String G_com_ssn;
    private String G_date21;
    private String G_date22;
    private String G_date23;
    private String G_pay_year;
    private String G_pay;
    private String G_pay_day;
    private String G_zip21;
    private String G_zip22;
    private String G_addr21;
    private String G_addr22;
    private String G_ph61;
    private String G_ph62;
    private String G_ph63;
    private String G_ph31;
    private String G_ph32;
    private String G_ph33;
    //직장 - 기타;
    private String E_com_name;
    private String E_com_part;
    private String E_com_grade_cat_no;
    private String E_com_type_cat_no;
    private String E_pay_year;
    private String E_pay;
    private String E_pay_day;
    private String E_zip21;
    private String E_zip22;
    private String E_addr21;
    private String E_addr22;
    private String E_ph31;
    private String E_ph32;
    private String E_ph33;
    private String E_ph61;
    private String E_ph62;
    private String E_ph63;
    //기타자산정보;
    private String etc_money1;
    private String etc_money2;
    private String etc_money3;
    private String etc_money4;
    //차량 존재시;
    private String car_brand;
    private String car_year;
    private String car_number;
    private String car_mastername;
    private String car_rel;
    //적금 존재시;
    private String etcbank_mastername;
    private String etcbank_money;
    private String etcbank_name_cat_no;
    private String etcbank_jum;
    //저축성보험 존재시;
    private String insurance_mastername;
    private String insurance_monthmoney;
    private String insurance_lastday;
    private String insurance_number;
    private String insurance_outmoney;
    private String insurance_lastmoney;
    //부동산 존재시;
    private String etc_mastername;
    private String etc_rel;
    private String etc_zip11;
    private String etc_zip12;
    private String etc_addr11;
    private String etc_addr12;
    //대출정보;
    private String virtual_bank_cat_no;
    private String virtual_bank_jum;
    private String virtual_bank_ssn;
    private String bank_name_cat_no;
    private String guest_bank_jum;
    private String guest_bank_ssn;
    private String in_bank_cat_no;
    private String in_bank_jum;
    private String in_bank_ssn;
    private String payment_day;
    private String used_money_cat_no;
    //타사대출이용정보(다중 등록가능 - 배열로 처리해서 넘겨줌);
    private String loan_type[];
    private String loan_com_name[];
    private String start_money[];
    private String loan_money[];
    private String out_loan_type_cat_no[];
    private String out_loan_return_type_cat_no[];
    private String monthly_return_money[];
    private String last_date[];
    //비상연락망(다중 등록가능 - 첫번째일때 변수명이 J1으로 시작, 두번째 J2, 세번째 J3..);
    //* 3명이상 입력해야합니다.;
    private String J1_name;
    private String J1_man_relation_cat_no;
    private String J1_ssn11;
    private String J1_ssn12;
    private String J1_guarantor;
    private String J1_house_type;
    private String J1_ph11;
    private String J1_ph12;
    private String J1_ph13;
    private String J1_ph21;
    private String J1_ph22;
    private String J1_ph23;
    private String J1_zip11;
    private String J1_zip12;
    private String J1_addr11;
    private String J1_addr12;
    private String J1_com_name;
    private String J1_ph31;
    private String J1_ph32;
    private String J1_ph33;
    private String J1_income_type;
    private String J1_income_other;
    private String J1_zip31;
    private String J1_zip32;
    private String J1_addr31;
    private String J1_addr32;
    private String jj_cnt;

    //추가 항목;
    private String check_app;
    private String m_ph11;
    private String m_ph12;
    private String m_ph13;
    private String Insong_type;
    private String credit_hope_score;
    public String getPro_code() {
        return pro_code;
    }
    public void setPro_code(String pro_code) {
        this.pro_code = pro_code;
    }
    public String getCom_code() {
        return com_code;
    }
    public void setCom_code(String com_code) {
        this.com_code = com_code;
    }
    public String getCooperate_code() {
        return cooperate_code;
    }
    public void setCooperate_code(String cooperate_code) {
        this.cooperate_code = cooperate_code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSsn11() {
        return ssn11;
    }
    public void setSsn11(String ssn11) {
        this.ssn11 = ssn11;
    }
    public String getSsn12() {
        return ssn12;
    }
    public void setSsn12(String ssn12) {
        this.ssn12 = ssn12;
    }
    public String getPh11() {
        return ph11;
    }
    public void setPh11(String ph11) {
        this.ph11 = ph11;
    }
    public String getPh12() {
        return ph12;
    }
    public void setPh12(String ph12) {
        this.ph12 = ph12;
    }
    public String getPh13() {
        return ph13;
    }
    public void setPh13(String ph13) {
        this.ph13 = ph13;
    }
    public String getPh21() {
        return ph21;
    }
    public void setPh21(String ph21) {
        this.ph21 = ph21;
    }
    public String getPh22() {
        return ph22;
    }
    public void setPh22(String ph22) {
        this.ph22 = ph22;
    }
    public String getPh23() {
        return ph23;
    }
    public void setPh23(String ph23) {
        this.ph23 = ph23;
    }
    public String getJob_class() {
        return job_class;
    }
    public void setJob_class(String job_class) {
        this.job_class = job_class;
    }
    public String getA_com_name() {
        return A_com_name;
    }
    public void setA_com_name(String a_com_name) {
        A_com_name = a_com_name;
    }
    public String getA_ph31() {
        return A_ph31;
    }
    public void setA_ph31(String a_ph31) {
        A_ph31 = a_ph31;
    }
    public String getA_ph32() {
        return A_ph32;
    }
    public void setA_ph32(String a_ph32) {
        A_ph32 = a_ph32;
    }
    public String getA_ph33() {
        return A_ph33;
    }
    public void setA_ph33(String a_ph33) {
        A_ph33 = a_ph33;
    }
    public String getA_com_part() {
        return A_com_part;
    }
    public void setA_com_part(String a_com_part) {
        A_com_part = a_com_part;
    }
    public String getA_worker_term_year() {
        return A_worker_term_year;
    }
    public void setA_worker_term_year(String a_worker_term_year) {
        A_worker_term_year = a_worker_term_year;
    }
    public String getA_worker_term_month() {
        return A_worker_term_month;
    }
    public void setA_worker_term_month(String a_worker_term_month) {
        A_worker_term_month = a_worker_term_month;
    }
    public String getA_pay() {
        return A_pay;
    }
    public void setA_pay(String a_pay) {
        A_pay = a_pay;
    }
    public String getImg_url1() {
        return img_url1;
    }
    public void setImg_url1(String img_url1) {
        this.img_url1 = img_url1;
    }
    public String getImg_url2() {
        return img_url2;
    }
    public void setImg_url2(String img_url2) {
        this.img_url2 = img_url2;
    }
    public String getImg_url3() {
        return img_url3;
    }
    public void setImg_url3(String img_url3) {
        this.img_url3 = img_url3;
    }
    public String getImg_type1() {
        return img_type1;
    }
    public void setImg_type1(String img_type1) {
        this.img_type1 = img_type1;
    }
    public String getImg_type2() {
        return img_type2;
    }
    public void setImg_type2(String img_type2) {
        this.img_type2 = img_type2;
    }
    public String getImg_type3() {
        return img_type3;
    }
    public void setImg_type3(String img_type3) {
        this.img_type3 = img_type3;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getG1_name() {
        return G1_name;
    }
    public void setG1_name(String g1_name) {
        G1_name = g1_name;
    }
    public String getG1_ssn11() {
        return G1_ssn11;
    }
    public void setG1_ssn11(String g1_ssn11) {
        G1_ssn11 = g1_ssn11;
    }
    public String getG1_ssn12() {
        return G1_ssn12;
    }
    public void setG1_ssn12(String g1_ssn12) {
        G1_ssn12 = g1_ssn12;
    }
    public String getG1_ph11() {
        return G1_ph11;
    }
    public void setG1_ph11(String g1_ph11) {
        G1_ph11 = g1_ph11;
    }
    public String getG1_ph12() {
        return G1_ph12;
    }
    public void setG1_ph12(String g1_ph12) {
        G1_ph12 = g1_ph12;
    }
    public String getG1_ph13() {
        return G1_ph13;
    }
    public void setG1_ph13(String g1_ph13) {
        G1_ph13 = g1_ph13;
    }
    public String getG1_ph21() {
        return G1_ph21;
    }
    public void setG1_ph21(String g1_ph21) {
        G1_ph21 = g1_ph21;
    }
    public String getG1_ph22() {
        return G1_ph22;
    }
    public void setG1_ph22(String g1_ph22) {
        G1_ph22 = g1_ph22;
    }
    public String getG1_ph23() {
        return G1_ph23;
    }
    public void setG1_ph23(String g1_ph23) {
        G1_ph23 = g1_ph23;
    }
    public String getG1_zip11() {
        return G1_zip11;
    }
    public void setG1_zip11(String g1_zip11) {
        G1_zip11 = g1_zip11;
    }
    public String getG1_zip12() {
        return G1_zip12;
    }
    public void setG1_zip12(String g1_zip12) {
        G1_zip12 = g1_zip12;
    }
    public String getG1_addr11() {
        return G1_addr11;
    }
    public void setG1_addr11(String g1_addr11) {
        G1_addr11 = g1_addr11;
    }
    public String getG1_addr12() {
        return G1_addr12;
    }
    public void setG1_addr12(String g1_addr12) {
        G1_addr12 = g1_addr12;
    }
    public String getAgent_level() {
        return agent_level;
    }
    public void setAgent_level(String agent_level) {
        this.agent_level = agent_level;
    }
    public String getAgent_app_date() {
        return agent_app_date;
    }
    public void setAgent_app_date(String agent_app_date) {
        this.agent_app_date = agent_app_date;
    }
    public String getAgent_name() {
        return agent_name;
    }
    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }
    public String getAgent_ssn() {
        return agent_ssn;
    }
    public void setAgent_ssn(String agent_ssn) {
        this.agent_ssn = agent_ssn;
    }
    public String getAgent_ph11() {
        return agent_ph11;
    }
    public void setAgent_ph11(String agent_ph11) {
        this.agent_ph11 = agent_ph11;
    }
    public String getAgent_ph12() {
        return agent_ph12;
    }
    public void setAgent_ph12(String agent_ph12) {
        this.agent_ph12 = agent_ph12;
    }
    public String getAgent_ph13() {
        return agent_ph13;
    }
    public void setAgent_ph13(String agent_ph13) {
        this.agent_ph13 = agent_ph13;
    }
    public String getAgent1_level() {
        return agent1_level;
    }
    public void setAgent1_level(String agent1_level) {
        this.agent1_level = agent1_level;
    }
    public String getAgent1_app_date() {
        return agent1_app_date;
    }
    public void setAgent1_app_date(String agent1_app_date) {
        this.agent1_app_date = agent1_app_date;
    }
    public String getAgent1_name() {
        return agent1_name;
    }
    public void setAgent1_name(String agent1_name) {
        this.agent1_name = agent1_name;
    }
    public String getAgent1_ssn() {
        return agent1_ssn;
    }
    public void setAgent1_ssn(String agent1_ssn) {
        this.agent1_ssn = agent1_ssn;
    }
    public String getAgent1_ph11() {
        return agent1_ph11;
    }
    public void setAgent1_ph11(String agent1_ph11) {
        this.agent1_ph11 = agent1_ph11;
    }
    public String getAgent1_ph12() {
        return agent1_ph12;
    }
    public void setAgent1_ph12(String agent1_ph12) {
        this.agent1_ph12 = agent1_ph12;
    }
    public String getAgent1_ph13() {
        return agent1_ph13;
    }
    public void setAgent1_ph13(String agent1_ph13) {
        this.agent1_ph13 = agent1_ph13;
    }
    public String getAgent2_level() {
        return agent2_level;
    }
    public void setAgent2_level(String agent2_level) {
        this.agent2_level = agent2_level;
    }
    public String getAgent2_app_date() {
        return agent2_app_date;
    }
    public void setAgent2_app_date(String agent2_app_date) {
        this.agent2_app_date = agent2_app_date;
    }
    public String getAgent2_name() {
        return agent2_name;
    }
    public void setAgent2_name(String agent2_name) {
        this.agent2_name = agent2_name;
    }
    public String getAgent2_ssn() {
        return agent2_ssn;
    }
    public void setAgent2_ssn(String agent2_ssn) {
        this.agent2_ssn = agent2_ssn;
    }
    public String getAgent2_ph11() {
        return agent2_ph11;
    }
    public void setAgent2_ph11(String agent2_ph11) {
        this.agent2_ph11 = agent2_ph11;
    }
    public String getAgent2_ph12() {
        return agent2_ph12;
    }
    public void setAgent2_ph12(String agent2_ph12) {
        this.agent2_ph12 = agent2_ph12;
    }
    public String getAgent2_ph13() {
        return agent2_ph13;
    }
    public void setAgent2_ph13(String agent2_ph13) {
        this.agent2_ph13 = agent2_ph13;
    }
    public String getAgent3_level() {
        return agent3_level;
    }
    public void setAgent3_level(String agent3_level) {
        this.agent3_level = agent3_level;
    }
    public String getAgent3_app_date() {
        return agent3_app_date;
    }
    public void setAgent3_app_date(String agent3_app_date) {
        this.agent3_app_date = agent3_app_date;
    }
    public String getAgent3_name() {
        return agent3_name;
    }
    public void setAgent3_name(String agent3_name) {
        this.agent3_name = agent3_name;
    }
    public String getAgent3_ssn() {
        return agent3_ssn;
    }
    public void setAgent3_ssn(String agent3_ssn) {
        this.agent3_ssn = agent3_ssn;
    }
    public String getAgent3_ph11() {
        return agent3_ph11;
    }
    public void setAgent3_ph11(String agent3_ph11) {
        this.agent3_ph11 = agent3_ph11;
    }
    public String getAgent3_ph12() {
        return agent3_ph12;
    }
    public void setAgent3_ph12(String agent3_ph12) {
        this.agent3_ph12 = agent3_ph12;
    }
    public String getAgent3_ph13() {
        return agent3_ph13;
    }
    public void setAgent3_ph13(String agent3_ph13) {
        this.agent3_ph13 = agent3_ph13;
    }
    public String getAgent4_level() {
        return agent4_level;
    }
    public void setAgent4_level(String agent4_level) {
        this.agent4_level = agent4_level;
    }
    public String getAgent4_app_date() {
        return agent4_app_date;
    }
    public void setAgent4_app_date(String agent4_app_date) {
        this.agent4_app_date = agent4_app_date;
    }
    public String getAgent4_name() {
        return agent4_name;
    }
    public void setAgent4_name(String agent4_name) {
        this.agent4_name = agent4_name;
    }
    public String getAgent4_ssn() {
        return agent4_ssn;
    }
    public void setAgent4_ssn(String agent4_ssn) {
        this.agent4_ssn = agent4_ssn;
    }
    public String getAgent4_ph11() {
        return agent4_ph11;
    }
    public void setAgent4_ph11(String agent4_ph11) {
        this.agent4_ph11 = agent4_ph11;
    }
    public String getAgent4_ph12() {
        return agent4_ph12;
    }
    public void setAgent4_ph12(String agent4_ph12) {
        this.agent4_ph12 = agent4_ph12;
    }
    public String getAgent4_ph13() {
        return agent4_ph13;
    }
    public void setAgent4_ph13(String agent4_ph13) {
        this.agent4_ph13 = agent4_ph13;
    }
    public String getAgent5_level() {
        return agent5_level;
    }
    public void setAgent5_level(String agent5_level) {
        this.agent5_level = agent5_level;
    }
    public String getAgent5_app_date() {
        return agent5_app_date;
    }
    public void setAgent5_app_date(String agent5_app_date) {
        this.agent5_app_date = agent5_app_date;
    }
    public String getAgent5_name() {
        return agent5_name;
    }
    public void setAgent5_name(String agent5_name) {
        this.agent5_name = agent5_name;
    }
    public String getAgent5_ssn() {
        return agent5_ssn;
    }
    public void setAgent5_ssn(String agent5_ssn) {
        this.agent5_ssn = agent5_ssn;
    }
    public String getAgent5_ph11() {
        return agent5_ph11;
    }
    public void setAgent5_ph11(String agent5_ph11) {
        this.agent5_ph11 = agent5_ph11;
    }
    public String getAgent5_ph12() {
        return agent5_ph12;
    }
    public void setAgent5_ph12(String agent5_ph12) {
        this.agent5_ph12 = agent5_ph12;
    }
    public String getAgent5_ph13() {
        return agent5_ph13;
    }
    public void setAgent5_ph13(String agent5_ph13) {
        this.agent5_ph13 = agent5_ph13;
    }
    public String getAgent6_level() {
        return agent6_level;
    }
    public void setAgent6_level(String agent6_level) {
        this.agent6_level = agent6_level;
    }
    public String getAgent6_app_date() {
        return agent6_app_date;
    }
    public void setAgent6_app_date(String agent6_app_date) {
        this.agent6_app_date = agent6_app_date;
    }
    public String getAgent6_name() {
        return agent6_name;
    }
    public void setAgent6_name(String agent6_name) {
        this.agent6_name = agent6_name;
    }
    public String getAgent6_ssn() {
        return agent6_ssn;
    }
    public void setAgent6_ssn(String agent6_ssn) {
        this.agent6_ssn = agent6_ssn;
    }
    public String getAgent6_ph11() {
        return agent6_ph11;
    }
    public void setAgent6_ph11(String agent6_ph11) {
        this.agent6_ph11 = agent6_ph11;
    }
    public String getAgent6_ph12() {
        return agent6_ph12;
    }
    public void setAgent6_ph12(String agent6_ph12) {
        this.agent6_ph12 = agent6_ph12;
    }
    public String getAgent6_ph13() {
        return agent6_ph13;
    }
    public void setAgent6_ph13(String agent6_ph13) {
        this.agent6_ph13 = agent6_ph13;
    }
    public String getAgent7_level() {
        return agent7_level;
    }
    public void setAgent7_level(String agent7_level) {
        this.agent7_level = agent7_level;
    }
    public String getAgent7_app_date() {
        return agent7_app_date;
    }
    public void setAgent7_app_date(String agent7_app_date) {
        this.agent7_app_date = agent7_app_date;
    }
    public String getAgent7_name() {
        return agent7_name;
    }
    public void setAgent7_name(String agent7_name) {
        this.agent7_name = agent7_name;
    }
    public String getAgent7_ssn() {
        return agent7_ssn;
    }
    public void setAgent7_ssn(String agent7_ssn) {
        this.agent7_ssn = agent7_ssn;
    }
    public String getAgent7_ph11() {
        return agent7_ph11;
    }
    public void setAgent7_ph11(String agent7_ph11) {
        this.agent7_ph11 = agent7_ph11;
    }
    public String getAgent7_ph12() {
        return agent7_ph12;
    }
    public void setAgent7_ph12(String agent7_ph12) {
        this.agent7_ph12 = agent7_ph12;
    }
    public String getAgent7_ph13() {
        return agent7_ph13;
    }
    public void setAgent7_ph13(String agent7_ph13) {
        this.agent7_ph13 = agent7_ph13;
    }
    public String getAgent8_level() {
        return agent8_level;
    }
    public void setAgent8_level(String agent8_level) {
        this.agent8_level = agent8_level;
    }
    public String getAgent8_app_date() {
        return agent8_app_date;
    }
    public void setAgent8_app_date(String agent8_app_date) {
        this.agent8_app_date = agent8_app_date;
    }
    public String getAgent8_name() {
        return agent8_name;
    }
    public void setAgent8_name(String agent8_name) {
        this.agent8_name = agent8_name;
    }
    public String getAgent8_ssn() {
        return agent8_ssn;
    }
    public void setAgent8_ssn(String agent8_ssn) {
        this.agent8_ssn = agent8_ssn;
    }
    public String getAgent8_ph11() {
        return agent8_ph11;
    }
    public void setAgent8_ph11(String agent8_ph11) {
        this.agent8_ph11 = agent8_ph11;
    }
    public String getAgent8_ph12() {
        return agent8_ph12;
    }
    public void setAgent8_ph12(String agent8_ph12) {
        this.agent8_ph12 = agent8_ph12;
    }
    public String getAgent8_ph13() {
        return agent8_ph13;
    }
    public void setAgent8_ph13(String agent8_ph13) {
        this.agent8_ph13 = agent8_ph13;
    }
    public String getAgent9_level() {
        return agent9_level;
    }
    public void setAgent9_level(String agent9_level) {
        this.agent9_level = agent9_level;
    }
    public String getAgent9_app_date() {
        return agent9_app_date;
    }
    public void setAgent9_app_date(String agent9_app_date) {
        this.agent9_app_date = agent9_app_date;
    }
    public String getAgent9_name() {
        return agent9_name;
    }
    public void setAgent9_name(String agent9_name) {
        this.agent9_name = agent9_name;
    }
    public String getAgent9_ssn() {
        return agent9_ssn;
    }
    public void setAgent9_ssn(String agent9_ssn) {
        this.agent9_ssn = agent9_ssn;
    }
    public String getAgent9_ph11() {
        return agent9_ph11;
    }
    public void setAgent9_ph11(String agent9_ph11) {
        this.agent9_ph11 = agent9_ph11;
    }
    public String getAgent9_ph12() {
        return agent9_ph12;
    }
    public void setAgent9_ph12(String agent9_ph12) {
        this.agent9_ph12 = agent9_ph12;
    }
    public String getAgent9_ph13() {
        return agent9_ph13;
    }
    public void setAgent9_ph13(String agent9_ph13) {
        this.agent9_ph13 = agent9_ph13;
    }
    public String getPh1_name() {
        return ph1_name;
    }
    public void setPh1_name(String ph1_name) {
        this.ph1_name = ph1_name;
    }
    public String getPh1_rel() {
        return ph1_rel;
    }
    public void setPh1_rel(String ph1_rel) {
        this.ph1_rel = ph1_rel;
    }
    public String getPh2_name() {
        return ph2_name;
    }
    public void setPh2_name(String ph2_name) {
        this.ph2_name = ph2_name;
    }
    public String getPh2_rel() {
        return ph2_rel;
    }
    public void setPh2_rel(String ph2_rel) {
        this.ph2_rel = ph2_rel;
    }
    public String getMarry() {
        return marry;
    }
    public void setMarry(String marry) {
        this.marry = marry;
    }
    public String getLiving_family() {
        return living_family;
    }
    public void setLiving_family(String living_family) {
        this.living_family = living_family;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getC_name() {
        return C_name;
    }
    public void setC_name(String c_name) {
        C_name = c_name;
    }
    public String getC_ssn11() {
        return C_ssn11;
    }
    public void setC_ssn11(String c_ssn11) {
        C_ssn11 = c_ssn11;
    }
    public String getC_ssn12() {
        return C_ssn12;
    }
    public void setC_ssn12(String c_ssn12) {
        C_ssn12 = c_ssn12;
    }
    public String getC_ph21() {
        return C_ph21;
    }
    public void setC_ph21(String c_ph21) {
        C_ph21 = c_ph21;
    }
    public String getC_ph22() {
        return C_ph22;
    }
    public void setC_ph22(String c_ph22) {
        C_ph22 = c_ph22;
    }
    public String getC_ph23() {
        return C_ph23;
    }
    public void setC_ph23(String c_ph23) {
        C_ph23 = c_ph23;
    }
    public String getC_ph2_name() {
        return C_ph2_name;
    }
    public void setC_ph2_name(String c_ph2_name) {
        C_ph2_name = c_ph2_name;
    }
    public String getC_ph2_name_rel() {
        return C_ph2_name_rel;
    }
    public void setC_ph2_name_rel(String c_ph2_name_rel) {
        C_ph2_name_rel = c_ph2_name_rel;
    }
    public String getZip11() {
        return zip11;
    }
    public void setZip11(String zip11) {
        this.zip11 = zip11;
    }
    public String getZip12() {
        return zip12;
    }
    public void setZip12(String zip12) {
        this.zip12 = zip12;
    }
    public String getAddr11() {
        return addr11;
    }
    public void setAddr11(String addr11) {
        this.addr11 = addr11;
    }
    public String getAddr12() {
        return addr12;
    }
    public void setAddr12(String addr12) {
        this.addr12 = addr12;
    }
    public String getZip41() {
        return zip41;
    }
    public void setZip41(String zip41) {
        this.zip41 = zip41;
    }
    public String getZip42() {
        return zip42;
    }
    public void setZip42(String zip42) {
        this.zip42 = zip42;
    }
    public String getAddr41() {
        return addr41;
    }
    public void setAddr41(String addr41) {
        this.addr41 = addr41;
    }
    public String getAddr42() {
        return addr42;
    }
    public void setAddr42(String addr42) {
        this.addr42 = addr42;
    }
    public String getHouse_own_type_cat_no() {
        return house_own_type_cat_no;
    }
    public void setHouse_own_type_cat_no(String house_own_type_cat_no) {
        this.house_own_type_cat_no = house_own_type_cat_no;
    }
    public String getHouse_type_cat_no() {
        return house_type_cat_no;
    }
    public void setHouse_type_cat_no(String house_type_cat_no) {
        this.house_type_cat_no = house_type_cat_no;
    }
    public String getH_size1() {
        return h_size1;
    }
    public void setH_size1(String h_size1) {
        this.h_size1 = h_size1;
    }
    public String getH_price1() {
        return h_price1;
    }
    public void setH_price1(String h_price1) {
        this.h_price1 = h_price1;
    }
    public String getH_price2() {
        return h_price2;
    }
    public void setH_price2(String h_price2) {
        this.h_price2 = h_price2;
    }
    public String getH_term2() {
        return h_term2;
    }
    public void setH_term2(String h_term2) {
        this.h_term2 = h_term2;
    }
    public String getH_price3_1() {
        return h_price3_1;
    }
    public void setH_price3_1(String h_price3_1) {
        this.h_price3_1 = h_price3_1;
    }
    public String getH_price3_2() {
        return h_price3_2;
    }
    public void setH_price3_2(String h_price3_2) {
        this.h_price3_2 = h_price3_2;
    }
    public String getH_term3() {
        return h_term3;
    }
    public void setH_term3(String h_term3) {
        this.h_term3 = h_term3;
    }
    public String getHouse_owner_name() {
        return house_owner_name;
    }
    public void setHouse_owner_name(String house_owner_name) {
        this.house_owner_name = house_owner_name;
    }
    public String getHouse_owner() {
        return house_owner;
    }
    public void setHouse_owner(String house_owner) {
        this.house_owner = house_owner;
    }
    public String getA_com_type_cat_no() {
        return A_com_type_cat_no;
    }
    public void setA_com_type_cat_no(String a_com_type_cat_no) {
        A_com_type_cat_no = a_com_type_cat_no;
    }
    public String getA_zip21() {
        return A_zip21;
    }
    public void setA_zip21(String a_zip21) {
        A_zip21 = a_zip21;
    }
    public String getA_zip22() {
        return A_zip22;
    }
    public void setA_zip22(String a_zip22) {
        A_zip22 = a_zip22;
    }
    public String getA_addr21() {
        return A_addr21;
    }
    public void setA_addr21(String a_addr21) {
        A_addr21 = a_addr21;
    }
    public String getA_addr22() {
        return A_addr22;
    }
    public void setA_addr22(String a_addr22) {
        A_addr22 = a_addr22;
    }
    public String getA_ph51() {
        return A_ph51;
    }
    public void setA_ph51(String a_ph51) {
        A_ph51 = a_ph51;
    }
    public String getA_ph52() {
        return A_ph52;
    }
    public void setA_ph52(String a_ph52) {
        A_ph52 = a_ph52;
    }
    public String getA_ph53() {
        return A_ph53;
    }
    public void setA_ph53(String a_ph53) {
        A_ph53 = a_ph53;
    }
    public String getA_work_type_cat_no() {
        return A_work_type_cat_no;
    }
    public void setA_work_type_cat_no(String a_work_type_cat_no) {
        A_work_type_cat_no = a_work_type_cat_no;
    }
    public String getA_com_workers() {
        return A_com_workers;
    }
    public void setA_com_workers(String a_com_workers) {
        A_com_workers = a_com_workers;
    }
    public String getA_com_grade_cat_no() {
        return A_com_grade_cat_no;
    }
    public void setA_com_grade_cat_no(String a_com_grade_cat_no) {
        A_com_grade_cat_no = a_com_grade_cat_no;
    }
    public String getInsurance() {
        return insurance;
    }
    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
    public String getA_pay_day() {
        return A_pay_day;
    }
    public void setA_pay_day(String a_pay_day) {
        A_pay_day = a_pay_day;
    }
    public String getA_bonus_percent() {
        return A_bonus_percent;
    }
    public void setA_bonus_percent(String a_bonus_percent) {
        A_bonus_percent = a_bonus_percent;
    }
    public String getA_s_yincome() {
        return A_s_yincome;
    }
    public void setA_s_yincome(String a_s_yincome) {
        A_s_yincome = a_s_yincome;
    }
    public String getA_s_incometype() {
        return A_s_incometype;
    }
    public void setA_s_incometype(String a_s_incometype) {
        A_s_incometype = a_s_incometype;
    }
    public String getA_ceo_name() {
        return A_ceo_name;
    }
    public void setA_ceo_name(String a_ceo_name) {
        A_ceo_name = a_ceo_name;
    }
    public String getA_s_com() {
        return A_s_com;
    }
    public void setA_s_com(String a_s_com) {
        A_s_com = a_s_com;
    }
    public String getA_retire_date() {
        return A_retire_date;
    }
    public void setA_retire_date(String a_retire_date) {
        A_retire_date = a_retire_date;
    }
    public String getA_retire_money_cat_no() {
        return A_retire_money_cat_no;
    }
    public void setA_retire_money_cat_no(String a_retire_money_cat_no) {
        A_retire_money_cat_no = a_retire_money_cat_no;
    }
    public String getA_retire_money() {
        return A_retire_money;
    }
    public void setA_retire_money(String a_retire_money) {
        A_retire_money = a_retire_money;
    }
    public String getA_pay_attach() {
        return A_pay_attach;
    }
    public void setA_pay_attach(String a_pay_attach) {
        A_pay_attach = a_pay_attach;
    }
    public String getB_com_name() {
        return B_com_name;
    }
    public void setB_com_name(String b_com_name) {
        B_com_name = b_com_name;
    }
    public String getB_ph31() {
        return B_ph31;
    }
    public void setB_ph31(String b_ph31) {
        B_ph31 = b_ph31;
    }
    public String getB_ph32() {
        return B_ph32;
    }
    public void setB_ph32(String b_ph32) {
        B_ph32 = b_ph32;
    }
    public String getB_ph33() {
        return B_ph33;
    }
    public void setB_ph33(String b_ph33) {
        B_ph33 = b_ph33;
    }
    public String getB_ph41() {
        return B_ph41;
    }
    public void setB_ph41(String b_ph41) {
        B_ph41 = b_ph41;
    }
    public String getB_ph42() {
        return B_ph42;
    }
    public void setB_ph42(String b_ph42) {
        B_ph42 = b_ph42;
    }
    public String getB_ph43() {
        return B_ph43;
    }
    public void setB_ph43(String b_ph43) {
        B_ph43 = b_ph43;
    }
    public String getB_com_medic_security() {
        return B_com_medic_security;
    }
    public void setB_com_medic_security(String b_com_medic_security) {
        B_com_medic_security = b_com_medic_security;
    }
    public String getB_ssn1() {
        return B_ssn1;
    }
    public void setB_ssn1(String b_ssn1) {
        B_ssn1 = b_ssn1;
    }
    public String getB_ssn2() {
        return B_ssn2;
    }
    public void setB_ssn2(String b_ssn2) {
        B_ssn2 = b_ssn2;
    }
    public String getB_ssn3() {
        return B_ssn3;
    }
    public void setB_ssn3(String b_ssn3) {
        B_ssn3 = b_ssn3;
    }
    public String getB_manage_term_year() {
        return B_manage_term_year;
    }
    public void setB_manage_term_year(String b_manage_term_year) {
        B_manage_term_year = b_manage_term_year;
    }
    public String getB_manage_term_month() {
        return B_manage_term_month;
    }
    public void setB_manage_term_month(String b_manage_term_month) {
        B_manage_term_month = b_manage_term_month;
    }
    public String getB_com_income() {
        return B_com_income;
    }
    public void setB_com_income(String b_com_income) {
        B_com_income = b_com_income;
    }
    public String getB_c_worker() {
        return B_c_worker;
    }
    public void setB_c_worker(String b_c_worker) {
        B_c_worker = b_c_worker;
    }
    public String getB_zip21() {
        return B_zip21;
    }
    public void setB_zip21(String b_zip21) {
        B_zip21 = b_zip21;
    }
    public String getB_zip22() {
        return B_zip22;
    }
    public void setB_zip22(String b_zip22) {
        B_zip22 = b_zip22;
    }
    public String getB_addr21() {
        return B_addr21;
    }
    public void setB_addr21(String b_addr21) {
        B_addr21 = b_addr21;
    }
    public String getB_addr22() {
        return B_addr22;
    }
    public void setB_addr22(String b_addr22) {
        B_addr22 = b_addr22;
    }
    public String getB_price1() {
        return B_price1;
    }
    public void setB_price1(String b_price1) {
        B_price1 = b_price1;
    }
    public String getB_price2() {
        return B_price2;
    }
    public void setB_price2(String b_price2) {
        B_price2 = b_price2;
    }
    public String getD_com_name() {
        return D_com_name;
    }
    public void setD_com_name(String d_com_name) {
        D_com_name = d_com_name;
    }
    public String getD_com_depart() {
        return D_com_depart;
    }
    public void setD_com_depart(String d_com_depart) {
        D_com_depart = d_com_depart;
    }
    public String getD_school_grade_cat_no() {
        return D_school_grade_cat_no;
    }
    public void setD_school_grade_cat_no(String d_school_grade_cat_no) {
        D_school_grade_cat_no = d_school_grade_cat_no;
    }
    public String getD_school_status_cat_no() {
        return D_school_status_cat_no;
    }
    public void setD_school_status_cat_no(String d_school_status_cat_no) {
        D_school_status_cat_no = d_school_status_cat_no;
    }
    public String getD_ph31() {
        return D_ph31;
    }
    public void setD_ph31(String d_ph31) {
        D_ph31 = d_ph31;
    }
    public String getD_ph32() {
        return D_ph32;
    }
    public void setD_ph32(String d_ph32) {
        D_ph32 = d_ph32;
    }
    public String getD_ph33() {
        return D_ph33;
    }
    public void setD_ph33(String d_ph33) {
        D_ph33 = d_ph33;
    }
    public String getD_zip21() {
        return D_zip21;
    }
    public void setD_zip21(String d_zip21) {
        D_zip21 = d_zip21;
    }
    public String getD_zip22() {
        return D_zip22;
    }
    public void setD_zip22(String d_zip22) {
        D_zip22 = d_zip22;
    }
    public String getD_addr21() {
        return D_addr21;
    }
    public void setD_addr21(String d_addr21) {
        D_addr21 = d_addr21;
    }
    public String getD_addr22() {
        return D_addr22;
    }
    public void setD_addr22(String d_addr22) {
        D_addr22 = d_addr22;
    }
    public String getD_sc_army() {
        return D_sc_army;
    }
    public void setD_sc_army(String d_sc_army) {
        D_sc_army = d_sc_army;
    }
    public String getD_sc_alba_chk() {
        return D_sc_alba_chk;
    }
    public void setD_sc_alba_chk(String d_sc_alba_chk) {
        D_sc_alba_chk = d_sc_alba_chk;
    }
    public String getD_sc_alba_name() {
        return D_sc_alba_name;
    }
    public void setD_sc_alba_name(String d_sc_alba_name) {
        D_sc_alba_name = d_sc_alba_name;
    }
    public String getD_pay() {
        return D_pay;
    }
    public void setD_pay(String d_pay) {
        D_pay = d_pay;
    }
    public String getD_pay_day() {
        return D_pay_day;
    }
    public void setD_pay_day(String d_pay_day) {
        D_pay_day = d_pay_day;
    }
    public String getD_zip31() {
        return D_zip31;
    }
    public void setD_zip31(String d_zip31) {
        D_zip31 = d_zip31;
    }
    public String getD_zip32() {
        return D_zip32;
    }
    public void setD_zip32(String d_zip32) {
        D_zip32 = d_zip32;
    }
    public String getD_addr31() {
        return D_addr31;
    }
    public void setD_addr31(String d_addr31) {
        D_addr31 = d_addr31;
    }
    public String getD_addr32() {
        return D_addr32;
    }
    public void setD_addr32(String d_addr32) {
        D_addr32 = d_addr32;
    }
    public String getD_ph51() {
        return D_ph51;
    }
    public void setD_ph51(String d_ph51) {
        D_ph51 = d_ph51;
    }
    public String getD_ph52() {
        return D_ph52;
    }
    public void setD_ph52(String d_ph52) {
        D_ph52 = d_ph52;
    }
    public String getD_ph53() {
        return D_ph53;
    }
    public void setD_ph53(String d_ph53) {
        D_ph53 = d_ph53;
    }
    public String getF_com_name() {
        return F_com_name;
    }
    public void setF_com_name(String f_com_name) {
        F_com_name = f_com_name;
    }
    public String getF_com_part() {
        return F_com_part;
    }
    public void setF_com_part(String f_com_part) {
        F_com_part = f_com_part;
    }
    public String getF_com_grade_cat_no() {
        return F_com_grade_cat_no;
    }
    public void setF_com_grade_cat_no(String f_com_grade_cat_no) {
        F_com_grade_cat_no = f_com_grade_cat_no;
    }
    public String getF_com_degree() {
        return F_com_degree;
    }
    public void setF_com_degree(String f_com_degree) {
        F_com_degree = f_com_degree;
    }
    public String getF_pay_year() {
        return F_pay_year;
    }
    public void setF_pay_year(String f_pay_year) {
        F_pay_year = f_pay_year;
    }
    public String getF_pay() {
        return F_pay;
    }
    public void setF_pay(String f_pay) {
        F_pay = f_pay;
    }
    public String getF_pay_day() {
        return F_pay_day;
    }
    public void setF_pay_day(String f_pay_day) {
        F_pay_day = f_pay_day;
    }
    public String getF_zip21() {
        return F_zip21;
    }
    public void setF_zip21(String f_zip21) {
        F_zip21 = f_zip21;
    }
    public String getF_zip22() {
        return F_zip22;
    }
    public void setF_zip22(String f_zip22) {
        F_zip22 = f_zip22;
    }
    public String getF_addr21() {
        return F_addr21;
    }
    public void setF_addr21(String f_addr21) {
        F_addr21 = f_addr21;
    }
    public String getF_addr22() {
        return F_addr22;
    }
    public void setF_addr22(String f_addr22) {
        F_addr22 = f_addr22;
    }
    public String getF_ph61() {
        return F_ph61;
    }
    public void setF_ph61(String f_ph61) {
        F_ph61 = f_ph61;
    }
    public String getF_ph62() {
        return F_ph62;
    }
    public void setF_ph62(String f_ph62) {
        F_ph62 = f_ph62;
    }
    public String getF_ph63() {
        return F_ph63;
    }
    public void setF_ph63(String f_ph63) {
        F_ph63 = f_ph63;
    }
    public String getF_ph31() {
        return F_ph31;
    }
    public void setF_ph31(String f_ph31) {
        F_ph31 = f_ph31;
    }
    public String getF_ph32() {
        return F_ph32;
    }
    public void setF_ph32(String f_ph32) {
        F_ph32 = f_ph32;
    }
    public String getF_ph33() {
        return F_ph33;
    }
    public void setF_ph33(String f_ph33) {
        F_ph33 = f_ph33;
    }
    public String getG_com_name() {
        return G_com_name;
    }
    public void setG_com_name(String g_com_name) {
        G_com_name = g_com_name;
    }
    public String getG_com_grade() {
        return G_com_grade;
    }
    public void setG_com_grade(String g_com_grade) {
        G_com_grade = g_com_grade;
    }
    public String getG_com_ssn() {
        return G_com_ssn;
    }
    public void setG_com_ssn(String g_com_ssn) {
        G_com_ssn = g_com_ssn;
    }
    public String getG_date21() {
        return G_date21;
    }
    public void setG_date21(String g_date21) {
        G_date21 = g_date21;
    }
    public String getG_date22() {
        return G_date22;
    }
    public void setG_date22(String g_date22) {
        G_date22 = g_date22;
    }
    public String getG_date23() {
        return G_date23;
    }
    public void setG_date23(String g_date23) {
        G_date23 = g_date23;
    }
    public String getG_pay_year() {
        return G_pay_year;
    }
    public void setG_pay_year(String g_pay_year) {
        G_pay_year = g_pay_year;
    }
    public String getG_pay() {
        return G_pay;
    }
    public void setG_pay(String g_pay) {
        G_pay = g_pay;
    }
    public String getG_pay_day() {
        return G_pay_day;
    }
    public void setG_pay_day(String g_pay_day) {
        G_pay_day = g_pay_day;
    }
    public String getG_zip21() {
        return G_zip21;
    }
    public void setG_zip21(String g_zip21) {
        G_zip21 = g_zip21;
    }
    public String getG_zip22() {
        return G_zip22;
    }
    public void setG_zip22(String g_zip22) {
        G_zip22 = g_zip22;
    }
    public String getG_addr21() {
        return G_addr21;
    }
    public void setG_addr21(String g_addr21) {
        G_addr21 = g_addr21;
    }
    public String getG_addr22() {
        return G_addr22;
    }
    public void setG_addr22(String g_addr22) {
        G_addr22 = g_addr22;
    }
    public String getG_ph61() {
        return G_ph61;
    }
    public void setG_ph61(String g_ph61) {
        G_ph61 = g_ph61;
    }
    public String getG_ph62() {
        return G_ph62;
    }
    public void setG_ph62(String g_ph62) {
        G_ph62 = g_ph62;
    }
    public String getG_ph63() {
        return G_ph63;
    }
    public void setG_ph63(String g_ph63) {
        G_ph63 = g_ph63;
    }
    public String getG_ph31() {
        return G_ph31;
    }
    public void setG_ph31(String g_ph31) {
        G_ph31 = g_ph31;
    }
    public String getG_ph32() {
        return G_ph32;
    }
    public void setG_ph32(String g_ph32) {
        G_ph32 = g_ph32;
    }
    public String getG_ph33() {
        return G_ph33;
    }
    public void setG_ph33(String g_ph33) {
        G_ph33 = g_ph33;
    }
    public String getE_com_name() {
        return E_com_name;
    }
    public void setE_com_name(String e_com_name) {
        E_com_name = e_com_name;
    }
    public String getE_com_part() {
        return E_com_part;
    }
    public void setE_com_part(String e_com_part) {
        E_com_part = e_com_part;
    }
    public String getE_com_grade_cat_no() {
        return E_com_grade_cat_no;
    }
    public void setE_com_grade_cat_no(String e_com_grade_cat_no) {
        E_com_grade_cat_no = e_com_grade_cat_no;
    }
    public String getE_com_type_cat_no() {
        return E_com_type_cat_no;
    }
    public void setE_com_type_cat_no(String e_com_type_cat_no) {
        E_com_type_cat_no = e_com_type_cat_no;
    }
    public String getE_pay_year() {
        return E_pay_year;
    }
    public void setE_pay_year(String e_pay_year) {
        E_pay_year = e_pay_year;
    }
    public String getE_pay() {
        return E_pay;
    }
    public void setE_pay(String e_pay) {
        E_pay = e_pay;
    }
    public String getE_pay_day() {
        return E_pay_day;
    }
    public void setE_pay_day(String e_pay_day) {
        E_pay_day = e_pay_day;
    }
    public String getE_zip21() {
        return E_zip21;
    }
    public void setE_zip21(String e_zip21) {
        E_zip21 = e_zip21;
    }
    public String getE_zip22() {
        return E_zip22;
    }
    public void setE_zip22(String e_zip22) {
        E_zip22 = e_zip22;
    }
    public String getE_addr21() {
        return E_addr21;
    }
    public void setE_addr21(String e_addr21) {
        E_addr21 = e_addr21;
    }
    public String getE_addr22() {
        return E_addr22;
    }
    public void setE_addr22(String e_addr22) {
        E_addr22 = e_addr22;
    }
    public String getE_ph31() {
        return E_ph31;
    }
    public void setE_ph31(String e_ph31) {
        E_ph31 = e_ph31;
    }
    public String getE_ph32() {
        return E_ph32;
    }
    public void setE_ph32(String e_ph32) {
        E_ph32 = e_ph32;
    }
    public String getE_ph33() {
        return E_ph33;
    }
    public void setE_ph33(String e_ph33) {
        E_ph33 = e_ph33;
    }
    public String getE_ph61() {
        return E_ph61;
    }
    public void setE_ph61(String e_ph61) {
        E_ph61 = e_ph61;
    }
    public String getE_ph62() {
        return E_ph62;
    }
    public void setE_ph62(String e_ph62) {
        E_ph62 = e_ph62;
    }
    public String getE_ph63() {
        return E_ph63;
    }
    public void setE_ph63(String e_ph63) {
        E_ph63 = e_ph63;
    }
    public String getEtc_money1() {
        return etc_money1;
    }
    public void setEtc_money1(String etc_money1) {
        this.etc_money1 = etc_money1;
    }
    public String getEtc_money2() {
        return etc_money2;
    }
    public void setEtc_money2(String etc_money2) {
        this.etc_money2 = etc_money2;
    }
    public String getEtc_money3() {
        return etc_money3;
    }
    public void setEtc_money3(String etc_money3) {
        this.etc_money3 = etc_money3;
    }
    public String getEtc_money4() {
        return etc_money4;
    }
    public void setEtc_money4(String etc_money4) {
        this.etc_money4 = etc_money4;
    }
    public String getCar_brand() {
        return car_brand;
    }
    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }
    public String getCar_year() {
        return car_year;
    }
    public void setCar_year(String car_year) {
        this.car_year = car_year;
    }
    public String getCar_number() {
        return car_number;
    }
    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }
    public String getCar_mastername() {
        return car_mastername;
    }
    public void setCar_mastername(String car_mastername) {
        this.car_mastername = car_mastername;
    }
    public String getCar_rel() {
        return car_rel;
    }
    public void setCar_rel(String car_rel) {
        this.car_rel = car_rel;
    }
    public String getEtcbank_mastername() {
        return etcbank_mastername;
    }
    public void setEtcbank_mastername(String etcbank_mastername) {
        this.etcbank_mastername = etcbank_mastername;
    }
    public String getEtcbank_money() {
        return etcbank_money;
    }
    public void setEtcbank_money(String etcbank_money) {
        this.etcbank_money = etcbank_money;
    }
    public String getEtcbank_name_cat_no() {
        return etcbank_name_cat_no;
    }
    public void setEtcbank_name_cat_no(String etcbank_name_cat_no) {
        this.etcbank_name_cat_no = etcbank_name_cat_no;
    }
    public String getEtcbank_jum() {
        return etcbank_jum;
    }
    public void setEtcbank_jum(String etcbank_jum) {
        this.etcbank_jum = etcbank_jum;
    }
    public String getInsurance_mastername() {
        return insurance_mastername;
    }
    public void setInsurance_mastername(String insurance_mastername) {
        this.insurance_mastername = insurance_mastername;
    }
    public String getInsurance_monthmoney() {
        return insurance_monthmoney;
    }
    public void setInsurance_monthmoney(String insurance_monthmoney) {
        this.insurance_monthmoney = insurance_monthmoney;
    }
    public String getInsurance_lastday() {
        return insurance_lastday;
    }
    public void setInsurance_lastday(String insurance_lastday) {
        this.insurance_lastday = insurance_lastday;
    }
    public String getInsurance_number() {
        return insurance_number;
    }
    public void setInsurance_number(String insurance_number) {
        this.insurance_number = insurance_number;
    }
    public String getInsurance_outmoney() {
        return insurance_outmoney;
    }
    public void setInsurance_outmoney(String insurance_outmoney) {
        this.insurance_outmoney = insurance_outmoney;
    }
    public String getInsurance_lastmoney() {
        return insurance_lastmoney;
    }
    public void setInsurance_lastmoney(String insurance_lastmoney) {
        this.insurance_lastmoney = insurance_lastmoney;
    }
    public String getEtc_mastername() {
        return etc_mastername;
    }
    public void setEtc_mastername(String etc_mastername) {
        this.etc_mastername = etc_mastername;
    }
    public String getEtc_rel() {
        return etc_rel;
    }
    public void setEtc_rel(String etc_rel) {
        this.etc_rel = etc_rel;
    }
    public String getEtc_zip11() {
        return etc_zip11;
    }
    public void setEtc_zip11(String etc_zip11) {
        this.etc_zip11 = etc_zip11;
    }
    public String getEtc_zip12() {
        return etc_zip12;
    }
    public void setEtc_zip12(String etc_zip12) {
        this.etc_zip12 = etc_zip12;
    }
    public String getEtc_addr11() {
        return etc_addr11;
    }
    public void setEtc_addr11(String etc_addr11) {
        this.etc_addr11 = etc_addr11;
    }
    public String getEtc_addr12() {
        return etc_addr12;
    }
    public void setEtc_addr12(String etc_addr12) {
        this.etc_addr12 = etc_addr12;
    }
    public String getApp_money() {
        return app_money;
    }
    public void setApp_money(String app_money) {
        this.app_money = app_money;
    }
    public String getVirtual_bank_cat_no() {
        return virtual_bank_cat_no;
    }
    public void setVirtual_bank_cat_no(String virtual_bank_cat_no) {
        this.virtual_bank_cat_no = virtual_bank_cat_no;
    }
    public String getVirtual_bank_jum() {
        return virtual_bank_jum;
    }
    public void setVirtual_bank_jum(String virtual_bank_jum) {
        this.virtual_bank_jum = virtual_bank_jum;
    }
    public String getVirtual_bank_ssn() {
        return virtual_bank_ssn;
    }
    public void setVirtual_bank_ssn(String virtual_bank_ssn) {
        this.virtual_bank_ssn = virtual_bank_ssn;
    }
    public String getBank_name_cat_no() {
        return bank_name_cat_no;
    }
    public void setBank_name_cat_no(String bank_name_cat_no) {
        this.bank_name_cat_no = bank_name_cat_no;
    }
    public String getGuest_bank_jum() {
        return guest_bank_jum;
    }
    public void setGuest_bank_jum(String guest_bank_jum) {
        this.guest_bank_jum = guest_bank_jum;
    }
    public String getGuest_bank_ssn() {
        return guest_bank_ssn;
    }
    public void setGuest_bank_ssn(String guest_bank_ssn) {
        this.guest_bank_ssn = guest_bank_ssn;
    }
    public String getIn_bank_cat_no() {
        return in_bank_cat_no;
    }
    public void setIn_bank_cat_no(String in_bank_cat_no) {
        this.in_bank_cat_no = in_bank_cat_no;
    }
    public String getIn_bank_jum() {
        return in_bank_jum;
    }
    public void setIn_bank_jum(String in_bank_jum) {
        this.in_bank_jum = in_bank_jum;
    }
    public String getIn_bank_ssn() {
        return in_bank_ssn;
    }
    public void setIn_bank_ssn(String in_bank_ssn) {
        this.in_bank_ssn = in_bank_ssn;
    }
    public String getPayment_day() {
        return payment_day;
    }
    public void setPayment_day(String payment_day) {
        this.payment_day = payment_day;
    }
    public String getUsed_money_cat_no() {
        return used_money_cat_no;
    }
    public void setUsed_money_cat_no(String used_money_cat_no) {
        this.used_money_cat_no = used_money_cat_no;
    }
    public String[] getLoan_type() {
        return loan_type;
    }
    public void setLoan_type(String[] loan_type) {
        this.loan_type = loan_type;
    }
    public String[] getLoan_com_name() {
        return loan_com_name;
    }
    public void setLoan_com_name(String[] loan_com_name) {
        this.loan_com_name = loan_com_name;
    }
    public String[] getStart_money() {
        return start_money;
    }
    public void setStart_money(String[] start_money) {
        this.start_money = start_money;
    }
    public String[] getLoan_money() {
        return loan_money;
    }
    public void setLoan_money(String[] loan_money) {
        this.loan_money = loan_money;
    }
    public String[] getOut_loan_type_cat_no() {
        return out_loan_type_cat_no;
    }
    public void setOut_loan_type_cat_no(String[] out_loan_type_cat_no) {
        this.out_loan_type_cat_no = out_loan_type_cat_no;
    }
    public String[] getOut_loan_return_type_cat_no() {
        return out_loan_return_type_cat_no;
    }
    public void setOut_loan_return_type_cat_no(String[] out_loan_return_type_cat_no) {
        this.out_loan_return_type_cat_no = out_loan_return_type_cat_no;
    }
    public String[] getMonthly_return_money() {
        return monthly_return_money;
    }
    public void setMonthly_return_money(String[] monthly_return_money) {
        this.monthly_return_money = monthly_return_money;
    }
    public String[] getLast_date() {
        return last_date;
    }
    public void setLast_date(String[] last_date) {
        this.last_date = last_date;
    }
    public String getJ1_name() {
        return J1_name;
    }
    public void setJ1_name(String j1_name) {
        J1_name = j1_name;
    }
    public String getJ1_man_relation_cat_no() {
        return J1_man_relation_cat_no;
    }
    public void setJ1_man_relation_cat_no(String j1_man_relation_cat_no) {
        J1_man_relation_cat_no = j1_man_relation_cat_no;
    }
    public String getJ1_ssn11() {
        return J1_ssn11;
    }
    public void setJ1_ssn11(String j1_ssn11) {
        J1_ssn11 = j1_ssn11;
    }
    public String getJ1_ssn12() {
        return J1_ssn12;
    }
    public void setJ1_ssn12(String j1_ssn12) {
        J1_ssn12 = j1_ssn12;
    }
    public String getJ1_guarantor() {
        return J1_guarantor;
    }
    public void setJ1_guarantor(String j1_guarantor) {
        J1_guarantor = j1_guarantor;
    }
    public String getJ1_house_type() {
        return J1_house_type;
    }
    public void setJ1_house_type(String j1_house_type) {
        J1_house_type = j1_house_type;
    }
    public String getJ1_ph11() {
        return J1_ph11;
    }
    public void setJ1_ph11(String j1_ph11) {
        J1_ph11 = j1_ph11;
    }
    public String getJ1_ph12() {
        return J1_ph12;
    }
    public void setJ1_ph12(String j1_ph12) {
        J1_ph12 = j1_ph12;
    }
    public String getJ1_ph13() {
        return J1_ph13;
    }
    public void setJ1_ph13(String j1_ph13) {
        J1_ph13 = j1_ph13;
    }
    public String getJ1_ph21() {
        return J1_ph21;
    }
    public void setJ1_ph21(String j1_ph21) {
        J1_ph21 = j1_ph21;
    }
    public String getJ1_ph22() {
        return J1_ph22;
    }
    public void setJ1_ph22(String j1_ph22) {
        J1_ph22 = j1_ph22;
    }
    public String getJ1_ph23() {
        return J1_ph23;
    }
    public void setJ1_ph23(String j1_ph23) {
        J1_ph23 = j1_ph23;
    }
    public String getJ1_zip11() {
        return J1_zip11;
    }
    public void setJ1_zip11(String j1_zip11) {
        J1_zip11 = j1_zip11;
    }
    public String getJ1_zip12() {
        return J1_zip12;
    }
    public void setJ1_zip12(String j1_zip12) {
        J1_zip12 = j1_zip12;
    }
    public String getJ1_addr11() {
        return J1_addr11;
    }
    public void setJ1_addr11(String j1_addr11) {
        J1_addr11 = j1_addr11;
    }
    public String getJ1_addr12() {
        return J1_addr12;
    }
    public void setJ1_addr12(String j1_addr12) {
        J1_addr12 = j1_addr12;
    }
    public String getJ1_com_name() {
        return J1_com_name;
    }
    public void setJ1_com_name(String j1_com_name) {
        J1_com_name = j1_com_name;
    }
    public String getJ1_ph31() {
        return J1_ph31;
    }
    public void setJ1_ph31(String j1_ph31) {
        J1_ph31 = j1_ph31;
    }
    public String getJ1_ph32() {
        return J1_ph32;
    }
    public void setJ1_ph32(String j1_ph32) {
        J1_ph32 = j1_ph32;
    }
    public String getJ1_ph33() {
        return J1_ph33;
    }
    public void setJ1_ph33(String j1_ph33) {
        J1_ph33 = j1_ph33;
    }
    public String getJ1_income_type() {
        return J1_income_type;
    }
    public void setJ1_income_type(String j1_income_type) {
        J1_income_type = j1_income_type;
    }
    public String getJ1_income_other() {
        return J1_income_other;
    }
    public void setJ1_income_other(String j1_income_other) {
        J1_income_other = j1_income_other;
    }
    public String getJ1_zip31() {
        return J1_zip31;
    }
    public void setJ1_zip31(String j1_zip31) {
        J1_zip31 = j1_zip31;
    }
    public String getJ1_zip32() {
        return J1_zip32;
    }
    public void setJ1_zip32(String j1_zip32) {
        J1_zip32 = j1_zip32;
    }
    public String getJ1_addr31() {
        return J1_addr31;
    }
    public void setJ1_addr31(String j1_addr31) {
        J1_addr31 = j1_addr31;
    }
    public String getJ1_addr32() {
        return J1_addr32;
    }
    public void setJ1_addr32(String j1_addr32) {
        J1_addr32 = j1_addr32;
    }
    public String getJj_cnt() {
        return jj_cnt;
    }
    public void setJj_cnt(String jj_cnt) {
        this.jj_cnt = jj_cnt;
    }
    public String getCheck_app() {
        return check_app;
    }
    public void setCheck_app(String check_app) {
        this.check_app = check_app;
    }
    public String getM_ph11() {
        return m_ph11;
    }
    public void setM_ph11(String m_ph11) {
        this.m_ph11 = m_ph11;
    }
    public String getM_ph12() {
        return m_ph12;
    }
    public void setM_ph12(String m_ph12) {
        this.m_ph12 = m_ph12;
    }
    public String getM_ph13() {
        return m_ph13;
    }
    public void setM_ph13(String m_ph13) {
        this.m_ph13 = m_ph13;
    }
    public String getInsong_type() {
        return Insong_type;
    }
    public void setInsong_type(String insong_type) {
        Insong_type = insong_type;
    }
    public String getCredit_hope_score() {
        return credit_hope_score;
    }
    public void setCredit_hope_score(String credit_hope_score) {
        this.credit_hope_score = credit_hope_score;
    }
    public String getDs_url() {
        return ds_url;
    }
    public void setDs_url(String ds_url) {
        this.ds_url = ds_url;
    }
    public String getInfo_coll_path() {
        return info_coll_path;
    }
    public void setInfo_coll_path(String info_coll_path) {
        this.info_coll_path = info_coll_path;
    }
    public String getColl_m1() {
        return coll_m1;
    }
    public void setColl_m1(String coll_m1) {
        this.coll_m1 = coll_m1;
    }
    public String getColl_m1_memo99() {
        return coll_m1_memo99;
    }
    public void setColl_m1_memo99(String coll_m1_memo99) {
        this.coll_m1_memo99 = coll_m1_memo99;
    }
    public String getColl_a1() {
        return coll_a1;
    }
    public void setColl_a1(String coll_a1) {
        this.coll_a1 = coll_a1;
    }
    public String getColl_a1_memo1() {
        return coll_a1_memo1;
    }
    public void setColl_a1_memo1(String coll_a1_memo1) {
        this.coll_a1_memo1 = coll_a1_memo1;
    }
    public String getColl_a1_memo99() {
        return coll_a1_memo99;
    }
    public void setColl_a1_memo99(String coll_a1_memo99) {
        this.coll_a1_memo99 = coll_a1_memo99;
    }
    public String getColl_a2() {
        return coll_a2;
    }
    public void setColl_a2(String coll_a2) {
        this.coll_a2 = coll_a2;
    }
    public String getColl_a2_memo99() {
        return coll_a2_memo99;
    }
    public void setColl_a2_memo99(String coll_a2_memo99) {
        this.coll_a2_memo99 = coll_a2_memo99;
    }
    public String getColl_date() {
        return coll_date;
    }
    public void setColl_date(String coll_date) {
        this.coll_date = coll_date;
    }
    public String getColl_agent_name() {
        return coll_agent_name;
    }
    public void setColl_agent_name(String coll_agent_name) {
        this.coll_agent_name = coll_agent_name;
    }
    public String getColl_ceo_name() {
        return coll_ceo_name;
    }
    public void setColl_ceo_name(String coll_ceo_name) {
        this.coll_ceo_name = coll_ceo_name;
    }
    public String getColl_manager_name() {
        return coll_manager_name;
    }
    public void setColl_manager_name(String coll_manager_name) {
        this.coll_manager_name = coll_manager_name;
    }
    public String getAgent_assn() {
        return agent_assn;
    }
    public void setAgent_assn(String agent_assn) {
        this.agent_assn = agent_assn;
    }
    public String getAgent1_assn() {
        return agent1_assn;
    }
    public void setAgent1_assn(String agent1_assn) {
        this.agent1_assn = agent1_assn;
    }
    public String getAgent2_assn() {
        return agent2_assn;
    }
    public void setAgent2_assn(String agent2_assn) {
        this.agent2_assn = agent2_assn;
    }
    public String getAgent3_assn() {
        return agent3_assn;
    }
    public void setAgent3_assn(String agent3_assn) {
        this.agent3_assn = agent3_assn;
    }
    public String getAgent4_assn() {
        return agent4_assn;
    }
    public void setAgent4_assn(String agent4_assn) {
        this.agent4_assn = agent4_assn;
    }
    public String getAgent5_assn() {
        return agent5_assn;
    }
    public void setAgent5_assn(String agent5_assn) {
        this.agent5_assn = agent5_assn;
    }
    public String getAgent6_assn() {
        return agent6_assn;
    }
    public void setAgent6_assn(String agent6_assn) {
        this.agent6_assn = agent6_assn;
    }
    public String getAgent7_assn() {
        return agent7_assn;
    }
    public void setAgent7_assn(String agent7_assn) {
        this.agent7_assn = agent7_assn;
    }
    public String getAgent8_assn() {
        return agent8_assn;
    }
    public void setAgent8_assn(String agent8_assn) {
        this.agent8_assn = agent8_assn;
    }
    public String getAgent9_assn() {
        return agent9_assn;
    }
    public void setAgent9_assn(String agent9_assn) {
        this.agent9_assn = agent9_assn;
    }

    
}
