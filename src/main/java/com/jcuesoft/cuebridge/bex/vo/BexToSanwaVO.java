package com.jcuesoft.cuebridge.bex.vo;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BexToSanwaVO extends BaseVO{

    /**
     * 
     */
    private static final long serialVersionUID = 8618959217596522525L;

    private String ds_url;
    private String agency_id;
    private String app_id;
    private String cd_goods;
    private String pnm;
    private String ssn1;
    private String ssn2;
    private String zip_real_live1;
    private String zip_real_live2;
    private String addr_real_live1;
    private String addr_real_live2;
    private String zip_registry1;
    private String zip_registry2;
    private String addr_registry1;
    private String addr_registry2;
    private String cd_house_form;
    private String cd_house_own1;
    private String cd_house_own2;
    private String email;
    private String yy_house_live;
    private String mm_house_live;
    private String amt_house_security;
    private String amt_house_month;
    private String cd_army;
    private String cd_insurance;
    private String cd_marry;
    private String yn_dualwork;
    private String ph1;
    private String ph2;
    private String ph3;
    private String cd_relation_ph;
    private String pnm_ph;
    private String hp1;
    private String hp2;
    private String hp3;
    private String cd_relation_hp;
    private String pnm_hp;
    private String car_type;
    private String car_number;
    private String amt_apply;
    private String dd_interest_payment;
    private String interest_payment_etc;
    private String cd_use_type;
    private String comm_position;
    private String hh_comm_start;
    private String hh_comm_end;
    private String cd_bank;
    private String account;
    private String loan_finance1;
    private String loan_first_amt1;
    private String loan_balance_amt1;
    private String loan_due_amt1;
    private String loan_due_date1;
    private String loan_finance2;
    private String loan_first_amt2;
    private String loan_balance_amt2;
    private String loan_due_amt2;
    private String loan_due_date2;
    private String loan_finance3;
    private String loan_first_amt3;
    private String loan_balance_amt3;
    private String loan_due_amt3;
    private String loan_due_date3;
    private String loan_finance4;
    private String loan_first_amt4;
    private String loan_balance_amt4;
    private String loan_due_amt4;
    private String loan_due_date4;
    private String loan_finance5;
    private String loan_first_amt5;
    private String loan_balance_amt5;
    private String loan_due_amt5;
    private String loan_due_date5;
    private String loan_finance6;
    private String loan_first_amt6;
    private String loan_balance_amt6;
    private String loan_due_amt6;
    private String loan_due_date6;
    private String cd_job;
    private String company_zip1;
    private String company_zip2;
    private String company_addr1;
    private String company_addr2;
    private String cnm;
    private String company_ph1;
    private String company_ph2;
    private String company_ph3;
    private String cd_duty;
    private String cd_business;
    private String amt_salary_year;
    private String dd_pay;
    private String company_join;
    private String cnt_employee;
    private String cd_worker;
    private String comment;
    private String fnm_master;
    private String fnm_document;
    private String fnm_image;
    private String branch_code;
    private String special_customer;
    private String agency_homeurl;
    private String route_type;
    private String route_agency;
    private String route_agency_doc;
    private String conn_type;
    private String conn_doc;
    private String route_customer;
    private String route_customer_doc1;
    private String route_customer_doc2;
    private String legal_confirm_date;
    private String agency_representative;
    private String agency_staff;
    private String seq_agency_level_list[];
    private String ymd_agency_list[];
    private String nm_agency_list[];
    private String no_agency_list[];
    private String regnm_agency_list[];
    private String ph_agency_list[];
    
    public String getAgency_id() {
        return agency_id;
    }
    public void setAgency_id(String agency_id) {
        this.agency_id = agency_id;
    }
    public String getApp_id() {
        return app_id;
    }
    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }
    public String getCd_goods() {
        return cd_goods;
    }
    public void setCd_goods(String cd_goods) {
        this.cd_goods = cd_goods;
    }
    public String getPnm() {
        return pnm;
    }
    public void setPnm(String pnm) {
        this.pnm = pnm;
    }
    public String getSsn1() {
        return ssn1;
    }
    public void setSsn1(String ssn1) {
        this.ssn1 = ssn1;
    }
    public String getSsn2() {
        return ssn2;
    }
    public void setSsn2(String ssn2) {
        this.ssn2 = ssn2;
    }
    public String getZip_real_live1() {
        return zip_real_live1;
    }
    public void setZip_real_live1(String zip_real_live1) {
        this.zip_real_live1 = zip_real_live1;
    }
    public String getZip_real_live2() {
        return zip_real_live2;
    }
    public void setZip_real_live2(String zip_real_live2) {
        this.zip_real_live2 = zip_real_live2;
    }
    public String getAddr_real_live1() {
        return addr_real_live1;
    }
    public void setAddr_real_live1(String addr_real_live1) {
        this.addr_real_live1 = addr_real_live1;
    }
    public String getAddr_real_live2() {
        return addr_real_live2;
    }
    public void setAddr_real_live2(String addr_real_live2) {
        this.addr_real_live2 = addr_real_live2;
    }
    public String getZip_registry1() {
        return zip_registry1;
    }
    public void setZip_registry1(String zip_registry1) {
        this.zip_registry1 = zip_registry1;
    }
    public String getZip_registry2() {
        return zip_registry2;
    }
    public void setZip_registry2(String zip_registry2) {
        this.zip_registry2 = zip_registry2;
    }
    public String getAddr_registry1() {
        return addr_registry1;
    }
    public void setAddr_registry1(String addr_registry1) {
        this.addr_registry1 = addr_registry1;
    }
    public String getAddr_registry2() {
        return addr_registry2;
    }
    public void setAddr_registry2(String addr_registry2) {
        this.addr_registry2 = addr_registry2;
    }
    public String getCd_house_form() {
        return cd_house_form;
    }
    public void setCd_house_form(String cd_house_form) {
        this.cd_house_form = cd_house_form;
    }
    public String getCd_house_own1() {
        return cd_house_own1;
    }
    public void setCd_house_own1(String cd_house_own1) {
        this.cd_house_own1 = cd_house_own1;
    }
    public String getCd_house_own2() {
        return cd_house_own2;
    }
    public void setCd_house_own2(String cd_house_own2) {
        this.cd_house_own2 = cd_house_own2;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getYy_house_live() {
        return yy_house_live;
    }
    public void setYy_house_live(String yy_house_live) {
        this.yy_house_live = yy_house_live;
    }
    public String getMm_house_live() {
        return mm_house_live;
    }
    public void setMm_house_live(String mm_house_live) {
        this.mm_house_live = mm_house_live;
    }
    public String getAmt_house_security() {
        return amt_house_security;
    }
    public void setAmt_house_security(String amt_house_security) {
        this.amt_house_security = amt_house_security;
    }
    public String getAmt_house_month() {
        return amt_house_month;
    }
    public void setAmt_house_month(String amt_house_month) {
        this.amt_house_month = amt_house_month;
    }
    public String getCd_army() {
        return cd_army;
    }
    public void setCd_army(String cd_army) {
        this.cd_army = cd_army;
    }
    public String getCd_insurance() {
        return cd_insurance;
    }
    public void setCd_insurance(String cd_insurance) {
        this.cd_insurance = cd_insurance;
    }
    public String getCd_marry() {
        return cd_marry;
    }
    public void setCd_marry(String cd_marry) {
        this.cd_marry = cd_marry;
    }
    public String getYn_dualwork() {
        return yn_dualwork;
    }
    public void setYn_dualwork(String yn_dualwork) {
        this.yn_dualwork = yn_dualwork;
    }
    public String getPh1() {
        return ph1;
    }
    public void setPh1(String ph1) {
        this.ph1 = ph1;
    }
    public String getPh2() {
        return ph2;
    }
    public void setPh2(String ph2) {
        this.ph2 = ph2;
    }
    public String getPh3() {
        return ph3;
    }
    public void setPh3(String ph3) {
        this.ph3 = ph3;
    }
    public String getCd_relation_ph() {
        return cd_relation_ph;
    }
    public void setCd_relation_ph(String cd_relation_ph) {
        this.cd_relation_ph = cd_relation_ph;
    }
    public String getPnm_ph() {
        return pnm_ph;
    }
    public void setPnm_ph(String pnm_ph) {
        this.pnm_ph = pnm_ph;
    }
    public String getHp1() {
        return hp1;
    }
    public void setHp1(String hp1) {
        this.hp1 = hp1;
    }
    public String getHp2() {
        return hp2;
    }
    public void setHp2(String hp2) {
        this.hp2 = hp2;
    }
    public String getHp3() {
        return hp3;
    }
    public void setHp3(String hp3) {
        this.hp3 = hp3;
    }
    public String getCd_relation_hp() {
        return cd_relation_hp;
    }
    public void setCd_relation_hp(String cd_relation_hp) {
        this.cd_relation_hp = cd_relation_hp;
    }
    public String getPnm_hp() {
        return pnm_hp;
    }
    public void setPnm_hp(String pnm_hp) {
        this.pnm_hp = pnm_hp;
    }
    public String getCar_type() {
        return car_type;
    }
    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }
    public String getCar_number() {
        return car_number;
    }
    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }
    public String getAmt_apply() {
        return amt_apply;
    }
    public void setAmt_apply(String amt_apply) {
        this.amt_apply = amt_apply;
    }
    public String getDd_interest_payment() {
        return dd_interest_payment;
    }
    public void setDd_interest_payment(String dd_interest_payment) {
        this.dd_interest_payment = dd_interest_payment;
    }
    public String getInterest_payment_etc() {
        return interest_payment_etc;
    }
    public void setInterest_payment_etc(String interest_payment_etc) {
        this.interest_payment_etc = interest_payment_etc;
    }
    public String getCd_use_type() {
        return cd_use_type;
    }
    public void setCd_use_type(String cd_use_type) {
        this.cd_use_type = cd_use_type;
    }
    public String getComm_position() {
        return comm_position;
    }
    public void setComm_position(String comm_position) {
        this.comm_position = comm_position;
    }
    public String getHh_comm_start() {
        return hh_comm_start;
    }
    public void setHh_comm_start(String hh_comm_start) {
        this.hh_comm_start = hh_comm_start;
    }
    public String getHh_comm_end() {
        return hh_comm_end;
    }
    public void setHh_comm_end(String hh_comm_end) {
        this.hh_comm_end = hh_comm_end;
    }
    public String getCd_bank() {
        return cd_bank;
    }
    public void setCd_bank(String cd_bank) {
        this.cd_bank = cd_bank;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getLoan_finance1() {
        return loan_finance1;
    }
    public void setLoan_finance1(String loan_finance1) {
        this.loan_finance1 = loan_finance1;
    }
    public String getLoan_first_amt1() {
        return loan_first_amt1;
    }
    public void setLoan_first_amt1(String loan_first_amt1) {
        this.loan_first_amt1 = loan_first_amt1;
    }
    public String getLoan_balance_amt1() {
        return loan_balance_amt1;
    }
    public void setLoan_balance_amt1(String loan_balance_amt1) {
        this.loan_balance_amt1 = loan_balance_amt1;
    }
    public String getLoan_due_amt1() {
        return loan_due_amt1;
    }
    public void setLoan_due_amt1(String loan_due_amt1) {
        this.loan_due_amt1 = loan_due_amt1;
    }
    public String getLoan_due_date1() {
        return loan_due_date1;
    }
    public void setLoan_due_date1(String loan_due_date1) {
        this.loan_due_date1 = loan_due_date1;
    }
    public String getLoan_finance2() {
        return loan_finance2;
    }
    public void setLoan_finance2(String loan_finance2) {
        this.loan_finance2 = loan_finance2;
    }
    public String getLoan_first_amt2() {
        return loan_first_amt2;
    }
    public void setLoan_first_amt2(String loan_first_amt2) {
        this.loan_first_amt2 = loan_first_amt2;
    }
    public String getLoan_balance_amt2() {
        return loan_balance_amt2;
    }
    public void setLoan_balance_amt2(String loan_balance_amt2) {
        this.loan_balance_amt2 = loan_balance_amt2;
    }
    public String getLoan_due_amt2() {
        return loan_due_amt2;
    }
    public void setLoan_due_amt2(String loan_due_amt2) {
        this.loan_due_amt2 = loan_due_amt2;
    }
    public String getLoan_due_date2() {
        return loan_due_date2;
    }
    public void setLoan_due_date2(String loan_due_date2) {
        this.loan_due_date2 = loan_due_date2;
    }
    public String getLoan_finance3() {
        return loan_finance3;
    }
    public void setLoan_finance3(String loan_finance3) {
        this.loan_finance3 = loan_finance3;
    }
    public String getLoan_first_amt3() {
        return loan_first_amt3;
    }
    public void setLoan_first_amt3(String loan_first_amt3) {
        this.loan_first_amt3 = loan_first_amt3;
    }
    public String getLoan_balance_amt3() {
        return loan_balance_amt3;
    }
    public void setLoan_balance_amt3(String loan_balance_amt3) {
        this.loan_balance_amt3 = loan_balance_amt3;
    }
    public String getLoan_due_amt3() {
        return loan_due_amt3;
    }
    public void setLoan_due_amt3(String loan_due_amt3) {
        this.loan_due_amt3 = loan_due_amt3;
    }
    public String getLoan_due_date3() {
        return loan_due_date3;
    }
    public void setLoan_due_date3(String loan_due_date3) {
        this.loan_due_date3 = loan_due_date3;
    }
    public String getLoan_finance4() {
        return loan_finance4;
    }
    public void setLoan_finance4(String loan_finance4) {
        this.loan_finance4 = loan_finance4;
    }
    public String getLoan_first_amt4() {
        return loan_first_amt4;
    }
    public void setLoan_first_amt4(String loan_first_amt4) {
        this.loan_first_amt4 = loan_first_amt4;
    }
    public String getLoan_balance_amt4() {
        return loan_balance_amt4;
    }
    public void setLoan_balance_amt4(String loan_balance_amt4) {
        this.loan_balance_amt4 = loan_balance_amt4;
    }
    public String getLoan_due_amt4() {
        return loan_due_amt4;
    }
    public void setLoan_due_amt4(String loan_due_amt4) {
        this.loan_due_amt4 = loan_due_amt4;
    }
    public String getLoan_due_date4() {
        return loan_due_date4;
    }
    public void setLoan_due_date4(String loan_due_date4) {
        this.loan_due_date4 = loan_due_date4;
    }
    public String getLoan_finance5() {
        return loan_finance5;
    }
    public void setLoan_finance5(String loan_finance5) {
        this.loan_finance5 = loan_finance5;
    }
    public String getLoan_first_amt5() {
        return loan_first_amt5;
    }
    public void setLoan_first_amt5(String loan_first_amt5) {
        this.loan_first_amt5 = loan_first_amt5;
    }
    public String getLoan_balance_amt5() {
        return loan_balance_amt5;
    }
    public void setLoan_balance_amt5(String loan_balance_amt5) {
        this.loan_balance_amt5 = loan_balance_amt5;
    }
    public String getLoan_due_amt5() {
        return loan_due_amt5;
    }
    public void setLoan_due_amt5(String loan_due_amt5) {
        this.loan_due_amt5 = loan_due_amt5;
    }
    public String getLoan_due_date5() {
        return loan_due_date5;
    }
    public void setLoan_due_date5(String loan_due_date5) {
        this.loan_due_date5 = loan_due_date5;
    }
    public String getLoan_finance6() {
        return loan_finance6;
    }
    public void setLoan_finance6(String loan_finance6) {
        this.loan_finance6 = loan_finance6;
    }
    public String getLoan_first_amt6() {
        return loan_first_amt6;
    }
    public void setLoan_first_amt6(String loan_first_amt6) {
        this.loan_first_amt6 = loan_first_amt6;
    }
    public String getLoan_balance_amt6() {
        return loan_balance_amt6;
    }
    public void setLoan_balance_amt6(String loan_balance_amt6) {
        this.loan_balance_amt6 = loan_balance_amt6;
    }
    public String getLoan_due_amt6() {
        return loan_due_amt6;
    }
    public void setLoan_due_amt6(String loan_due_amt6) {
        this.loan_due_amt6 = loan_due_amt6;
    }
    public String getLoan_due_date6() {
        return loan_due_date6;
    }
    public void setLoan_due_date6(String loan_due_date6) {
        this.loan_due_date6 = loan_due_date6;
    }
    public String getCd_job() {
        return cd_job;
    }
    public void setCd_job(String cd_job) {
        this.cd_job = cd_job;
    }
    public String getCompany_zip1() {
        return company_zip1;
    }
    public void setCompany_zip1(String company_zip1) {
        this.company_zip1 = company_zip1;
    }
    public String getCompany_zip2() {
        return company_zip2;
    }
    public void setCompany_zip2(String company_zip2) {
        this.company_zip2 = company_zip2;
    }
    public String getCompany_addr1() {
        return company_addr1;
    }
    public void setCompany_addr1(String company_addr1) {
        this.company_addr1 = company_addr1;
    }
    public String getCompany_addr2() {
        return company_addr2;
    }
    public void setCompany_addr2(String company_addr2) {
        this.company_addr2 = company_addr2;
    }
    public String getCnm() {
        return cnm;
    }
    public void setCnm(String cnm) {
        this.cnm = cnm;
    }
    public String getCompany_ph1() {
        return company_ph1;
    }
    public void setCompany_ph1(String company_ph1) {
        this.company_ph1 = company_ph1;
    }
    public String getCompany_ph2() {
        return company_ph2;
    }
    public void setCompany_ph2(String company_ph2) {
        this.company_ph2 = company_ph2;
    }
    public String getCompany_ph3() {
        return company_ph3;
    }
    public void setCompany_ph3(String company_ph3) {
        this.company_ph3 = company_ph3;
    }
    public String getCd_duty() {
        return cd_duty;
    }
    public void setCd_duty(String cd_duty) {
        this.cd_duty = cd_duty;
    }
    public String getCd_business() {
        return cd_business;
    }
    public void setCd_business(String cd_business) {
        this.cd_business = cd_business;
    }
    public String getAmt_salary_year() {
        return amt_salary_year;
    }
    public void setAmt_salary_year(String amt_salary_year) {
        this.amt_salary_year = amt_salary_year;
    }
    public String getDd_pay() {
        return dd_pay;
    }
    public void setDd_pay(String dd_pay) {
        this.dd_pay = dd_pay;
    }
    public String getCompany_join() {
        return company_join;
    }
    public void setCompany_join(String company_join) {
        this.company_join = company_join;
    }
    public String getCnt_employee() {
        return cnt_employee;
    }
    public void setCnt_employee(String cnt_employee) {
        this.cnt_employee = cnt_employee;
    }
    public String getCd_worker() {
        return cd_worker;
    }
    public void setCd_worker(String cd_worker) {
        this.cd_worker = cd_worker;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getFnm_master() {
        return fnm_master;
    }
    public void setFnm_master(String fnm_master) {
        this.fnm_master = fnm_master;
    }
    public String getFnm_document() {
        return fnm_document;
    }
    public void setFnm_document(String fnm_document) {
        this.fnm_document = fnm_document;
    }
    public String getFnm_image() {
        return fnm_image;
    }
    public void setFnm_image(String fnm_image) {
        this.fnm_image = fnm_image;
    }
    public String getBranch_code() {
        return branch_code;
    }
    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }
    public String getSpecial_customer() {
        return special_customer;
    }
    public void setSpecial_customer(String special_customer) {
        this.special_customer = special_customer;
    }
    public String getAgency_homeurl() {
        return agency_homeurl;
    }
    public void setAgency_homeurl(String agency_homeurl) {
        this.agency_homeurl = agency_homeurl;
    }
    public String getRoute_type() {
        return route_type;
    }
    public void setRoute_type(String route_type) {
        this.route_type = route_type;
    }
    public String getRoute_agency() {
        return route_agency;
    }
    public void setRoute_agency(String route_agency) {
        this.route_agency = route_agency;
    }
    public String getRoute_agency_doc() {
        return route_agency_doc;
    }
    public void setRoute_agency_doc(String route_agency_doc) {
        this.route_agency_doc = route_agency_doc;
    }
    public String getConn_type() {
        return conn_type;
    }
    public void setConn_type(String conn_type) {
        this.conn_type = conn_type;
    }
    public String getConn_doc() {
        return conn_doc;
    }
    public void setConn_doc(String conn_doc) {
        this.conn_doc = conn_doc;
    }
    public String getRoute_customer() {
        return route_customer;
    }
    public void setRoute_customer(String route_customer) {
        this.route_customer = route_customer;
    }
    public String getRoute_customer_doc1() {
        return route_customer_doc1;
    }
    public void setRoute_customer_doc1(String route_customer_doc1) {
        this.route_customer_doc1 = route_customer_doc1;
    }
    public String getRoute_customer_doc2() {
        return route_customer_doc2;
    }
    public void setRoute_customer_doc2(String route_customer_doc2) {
        this.route_customer_doc2 = route_customer_doc2;
    }
    public String getLegal_confirm_date() {
        return legal_confirm_date;
    }
    public void setLegal_confirm_date(String legal_confirm_date) {
        this.legal_confirm_date = legal_confirm_date;
    }
    public String getAgency_representative() {
        return agency_representative;
    }
    public void setAgency_representative(String agency_representative) {
        this.agency_representative = agency_representative;
    }
    public String getAgency_staff() {
        return agency_staff;
    }
    public void setAgency_staff(String agency_staff) {
        this.agency_staff = agency_staff;
    }
    public String[] getSeq_agency_level_list() {
        return seq_agency_level_list;
    }
    public void setSeq_agency_level_list(String[] seq_agency_level_list) {
        this.seq_agency_level_list = seq_agency_level_list;
    }
    public String[] getYmd_agency_list() {
        return ymd_agency_list;
    }
    public void setYmd_agency_list(String[] ymd_agency_list) {
        this.ymd_agency_list = ymd_agency_list;
    }
    public String[] getNm_agency_list() {
        return nm_agency_list;
    }
    public void setNm_agency_list(String[] nm_agency_list) {
        this.nm_agency_list = nm_agency_list;
    }
    public String[] getNo_agency_list() {
        return no_agency_list;
    }
    public void setNo_agency_list(String[] no_agency_list) {
        this.no_agency_list = no_agency_list;
    }
    public String[] getRegnm_agency_list() {
        return regnm_agency_list;
    }
    public void setRegnm_agency_list(String[] regnm_agency_list) {
        this.regnm_agency_list = regnm_agency_list;
    }
    public String[] getPh_agency_list() {
        return ph_agency_list;
    }
    public void setPh_agency_list(String[] ph_agency_list) {
        this.ph_agency_list = ph_agency_list;
    }
    public String getDs_url() {
        return ds_url;
    }
    public void setDs_url(String ds_url) {
        this.ds_url = ds_url;
    }



    
}
