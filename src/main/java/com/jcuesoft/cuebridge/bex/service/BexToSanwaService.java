package com.jcuesoft.cuebridge.bex.service;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.bex.dao.BexToSanwaDAO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToSanwaVO;
import com.jcuesoft.cuebridge.common.module.CommonHttpClient;
import com.jcuesoft.cuebridge.common.module.CommonJPA;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;
import com.jcuesoft.cuebridge.common.vo.CommonBizBrcInfoLegalVO;
import com.jcuesoft.cuebridge.common.vo.CommonBizBrcSupplyVO;
@Service
public class BexToSanwaService extends BaseService {
    
    @Autowired
    private CommonBizService commonBizService;    
    @Autowired
    private BexMasterService bexMasterService;
    @Autowired
    private BexToSanwaDAO bexToSanwaDAO;
    
    String excute(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexToSanwaService excute");
        String resultCode = ""; //resultCode        
        String resultPost = "";  
        resultCode = "Success";        
        
        EntityManager em = CommonJPA.getentityManagerFactory().createEntityManager();
        commonJPAUtil.doTX(em, new Runnable() {            
            @Override
            public void run() {
                try {
                    bexMasterRequestVO.setNmScreen("접수");
                    bexMasterRequestVO.setDsCooperate("최초실행");
                    logger.debug("Call BexToSanwaService excute getBexMasterNoEx");
                    bexMasterRequestVO.setNoEx(commonBizService.getBexMasterNoEx(bexMasterRequestVO.getNoReq(), em));
                    logger.debug("Call BexToSanwaService excute insertBexMaster");
                    bexMasterService.insertBexMaster(bexMasterRequestVO, em);
                    logger.debug("Call BexToSanwaService excute insertBexContact");
                    bexMasterService.insertBexContact(bexMasterRequestVO, em);
                } catch (Exception e) {
                    logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    logger.debug(Arrays.toString(e.getStackTrace()).replaceAll(", ", "\n"));
                }
            }
        });

        BexToSanwaVO bexToSanwaVO = new BexToSanwaVO();
        bexToSanwaVO = bexToSanwaDAO.getBexToSanwa(bexMasterRequestVO);
        
        List <NameValuePair> sendParam = new ArrayList <NameValuePair>();
        sendParam.add(new BasicNameValuePair("agency_id" , bexToSanwaVO.getAgency_id()));
        sendParam.add(new BasicNameValuePair("app_id" , bexToSanwaVO.getApp_id()));
        sendParam.add(new BasicNameValuePair("cd_goods" , bexToSanwaVO.getCd_goods()));
        sendParam.add(new BasicNameValuePair("pnm" , bexToSanwaVO.getPnm()));
        sendParam.add(new BasicNameValuePair("ssn1" , bexToSanwaVO.getSsn1()));
        sendParam.add(new BasicNameValuePair("ssn2" , bexToSanwaVO.getSsn2()));
        sendParam.add(new BasicNameValuePair("zip_real_live1" , bexToSanwaVO.getZip_real_live1()));
        sendParam.add(new BasicNameValuePair("zip_real_live2" , bexToSanwaVO.getZip_real_live2()));
        sendParam.add(new BasicNameValuePair("addr_real_live1" , bexToSanwaVO.getAddr_real_live1()));
        sendParam.add(new BasicNameValuePair("addr_real_live2" , bexToSanwaVO.getAddr_real_live2()));
        
        sendParam.add(new BasicNameValuePair("zip_registry1" , bexToSanwaVO.getZip_registry1()));
        sendParam.add(new BasicNameValuePair("zip_registry2" , bexToSanwaVO.getZip_registry2()));
        sendParam.add(new BasicNameValuePair("addr_registry1" , bexToSanwaVO.getAddr_registry1()));
        sendParam.add(new BasicNameValuePair("addr_registry2" , bexToSanwaVO.getAddr_registry2()));
        sendParam.add(new BasicNameValuePair("cd_house_form" , bexToSanwaVO.getCd_house_form()));
        sendParam.add(new BasicNameValuePair("cd_house_own1" , bexToSanwaVO.getCd_house_own1()));
        sendParam.add(new BasicNameValuePair("cd_house_own2" , bexToSanwaVO.getCd_house_own2()));
        sendParam.add(new BasicNameValuePair("email" , bexToSanwaVO.getEmail()));
        sendParam.add(new BasicNameValuePair("yy_house_live" , bexToSanwaVO.getYy_house_live()));
        sendParam.add(new BasicNameValuePair("mm_house_live" , bexToSanwaVO.getMm_house_live()));
        sendParam.add(new BasicNameValuePair("amt_house_security" , bexToSanwaVO.getAmt_house_security()));
        sendParam.add(new BasicNameValuePair("amt_house_month" , bexToSanwaVO.getAmt_house_month()));
        sendParam.add(new BasicNameValuePair("cd_army" , bexToSanwaVO.getCd_army()));
        sendParam.add(new BasicNameValuePair("cd_insurance" , bexToSanwaVO.getCd_insurance()));
        sendParam.add(new BasicNameValuePair("cd_marry" , bexToSanwaVO.getCd_marry()));
        sendParam.add(new BasicNameValuePair("yn_dualwork" , bexToSanwaVO.getYn_dualwork()));
        sendParam.add(new BasicNameValuePair("ph1" , bexToSanwaVO.getPh1()));
        sendParam.add(new BasicNameValuePair("ph2" , bexToSanwaVO.getPh2()));
        sendParam.add(new BasicNameValuePair("ph3" , bexToSanwaVO.getPh3()));
        sendParam.add(new BasicNameValuePair("cd_relation_ph" , bexToSanwaVO.getCd_relation_ph()));
        sendParam.add(new BasicNameValuePair("pnm_ph" , bexToSanwaVO.getPnm_ph()));
        sendParam.add(new BasicNameValuePair("hp1" , bexToSanwaVO.getHp1()));
        sendParam.add(new BasicNameValuePair("hp2" , bexToSanwaVO.getHp2()));
        sendParam.add(new BasicNameValuePair("hp3" , bexToSanwaVO.getHp3()));
        sendParam.add(new BasicNameValuePair("cd_relation_hp" , bexToSanwaVO.getCd_relation_hp()));
        sendParam.add(new BasicNameValuePair("pnm_hp" , bexToSanwaVO.getPnm_hp()));
        sendParam.add(new BasicNameValuePair("car_type" , bexToSanwaVO.getCar_type()));
        sendParam.add(new BasicNameValuePair("car_number" , bexToSanwaVO.getCar_number()));
        sendParam.add(new BasicNameValuePair("amt_apply" , bexToSanwaVO.getAmt_apply()));
        sendParam.add(new BasicNameValuePair("dd_interest_payment" , bexToSanwaVO.getDd_interest_payment()));
        sendParam.add(new BasicNameValuePair("interest_payment_etc" , bexToSanwaVO.getInterest_payment_etc()));
        sendParam.add(new BasicNameValuePair("cd_use_type" , bexToSanwaVO.getCd_use_type()));
        sendParam.add(new BasicNameValuePair("comm_position" , bexToSanwaVO.getComm_position()));
        sendParam.add(new BasicNameValuePair("hh_comm_start" , bexToSanwaVO.getHh_comm_start()));
        sendParam.add(new BasicNameValuePair("hh_comm_end" , bexToSanwaVO.getHh_comm_end()));
        sendParam.add(new BasicNameValuePair("cd_bank" , bexToSanwaVO.getCd_bank()));
        sendParam.add(new BasicNameValuePair("account" , bexToSanwaVO.getAccount()));
        sendParam.add(new BasicNameValuePair("loan_finance1" , bexToSanwaVO.getLoan_finance1()));
        sendParam.add(new BasicNameValuePair("loan_first_amt1" , bexToSanwaVO.getLoan_first_amt1()));
        sendParam.add(new BasicNameValuePair("loan_balance_amt1" , bexToSanwaVO.getLoan_balance_amt1()));
        sendParam.add(new BasicNameValuePair("loan_due_amt1" , bexToSanwaVO.getLoan_due_amt1()));
        sendParam.add(new BasicNameValuePair("loan_due_date1" , bexToSanwaVO.getLoan_due_date1()));
        sendParam.add(new BasicNameValuePair("loan_finance2" , bexToSanwaVO.getLoan_finance2()));
        sendParam.add(new BasicNameValuePair("loan_first_amt2" , bexToSanwaVO.getLoan_first_amt2()));
        sendParam.add(new BasicNameValuePair("loan_balance_amt2" , bexToSanwaVO.getLoan_balance_amt2()));
        sendParam.add(new BasicNameValuePair("loan_due_amt2" , bexToSanwaVO.getLoan_due_amt2()));
        sendParam.add(new BasicNameValuePair("loan_due_date2" , bexToSanwaVO.getLoan_due_date2()));
        sendParam.add(new BasicNameValuePair("loan_finance3" , bexToSanwaVO.getLoan_finance3()));
        sendParam.add(new BasicNameValuePair("loan_first_amt3" , bexToSanwaVO.getLoan_first_amt3()));
        sendParam.add(new BasicNameValuePair("loan_balance_amt3" , bexToSanwaVO.getLoan_balance_amt3()));
        sendParam.add(new BasicNameValuePair("loan_due_amt3" , bexToSanwaVO.getLoan_due_amt3()));
        sendParam.add(new BasicNameValuePair("loan_due_date3" , bexToSanwaVO.getLoan_due_date3()));
        sendParam.add(new BasicNameValuePair("loan_finance4" , bexToSanwaVO.getLoan_finance4()));
        sendParam.add(new BasicNameValuePair("loan_first_amt4" , bexToSanwaVO.getLoan_first_amt4()));
        sendParam.add(new BasicNameValuePair("loan_balance_amt4" , bexToSanwaVO.getLoan_balance_amt4()));
        sendParam.add(new BasicNameValuePair("loan_due_amt4" , bexToSanwaVO.getLoan_due_amt4()));
        sendParam.add(new BasicNameValuePair("loan_due_date4" , bexToSanwaVO.getLoan_due_date4()));
        sendParam.add(new BasicNameValuePair("loan_finance5" , bexToSanwaVO.getLoan_finance5()));
        sendParam.add(new BasicNameValuePair("loan_first_amt5" , bexToSanwaVO.getLoan_first_amt5()));
        sendParam.add(new BasicNameValuePair("loan_balance_amt5" , bexToSanwaVO.getLoan_balance_amt5()));
        sendParam.add(new BasicNameValuePair("loan_due_amt5" , bexToSanwaVO.getLoan_due_amt5()));
        sendParam.add(new BasicNameValuePair("loan_due_date5" , bexToSanwaVO.getLoan_due_date5()));
        sendParam.add(new BasicNameValuePair("loan_finance6" , bexToSanwaVO.getLoan_finance6()));
        sendParam.add(new BasicNameValuePair("loan_first_amt6" , bexToSanwaVO.getLoan_first_amt6()));
        sendParam.add(new BasicNameValuePair("loan_balance_amt6" , bexToSanwaVO.getLoan_balance_amt6()));
        sendParam.add(new BasicNameValuePair("loan_due_amt6" , bexToSanwaVO.getLoan_due_amt6()));
        sendParam.add(new BasicNameValuePair("loan_due_date6" , bexToSanwaVO.getLoan_due_date6()));
        sendParam.add(new BasicNameValuePair("cd_job" , bexToSanwaVO.getCd_job()));
        sendParam.add(new BasicNameValuePair("company_zip1" , bexToSanwaVO.getCompany_zip1()));
        sendParam.add(new BasicNameValuePair("company_zip2" , bexToSanwaVO.getCompany_zip2()));
        sendParam.add(new BasicNameValuePair("company_addr1" , bexToSanwaVO.getCompany_addr1()));
        sendParam.add(new BasicNameValuePair("company_addr2" , bexToSanwaVO.getCompany_addr2()));
        sendParam.add(new BasicNameValuePair("cnm" , bexToSanwaVO.getCnm()));
        sendParam.add(new BasicNameValuePair("company_ph1" , bexToSanwaVO.getCompany_ph1()));
        sendParam.add(new BasicNameValuePair("company_ph2" , bexToSanwaVO.getCompany_ph2()));
        sendParam.add(new BasicNameValuePair("company_ph3" , bexToSanwaVO.getCompany_ph3()));
        sendParam.add(new BasicNameValuePair("cd_duty" , bexToSanwaVO.getCd_duty()));
        sendParam.add(new BasicNameValuePair("cd_business" , bexToSanwaVO.getCd_business()));
        sendParam.add(new BasicNameValuePair("amt_salary_year" , bexToSanwaVO.getAmt_salary_year()));
        sendParam.add(new BasicNameValuePair("dd_pay" , bexToSanwaVO.getDd_pay()));
        sendParam.add(new BasicNameValuePair("company_join" , bexToSanwaVO.getCompany_join()));
        sendParam.add(new BasicNameValuePair("cnt_employee" , bexToSanwaVO.getCnt_employee()));
        sendParam.add(new BasicNameValuePair("cd_worker" , bexToSanwaVO.getCd_worker()));
        sendParam.add(new BasicNameValuePair("comment" , bexToSanwaVO.getComment()));
        sendParam.add(new BasicNameValuePair("fnm_master" , bexToSanwaVO.getFnm_master()));
        sendParam.add(new BasicNameValuePair("fnm_document" , bexToSanwaVO.getFnm_document()));
        sendParam.add(new BasicNameValuePair("fnm_image" , bexToSanwaVO.getFnm_image()));
        sendParam.add(new BasicNameValuePair("branch_code" , bexToSanwaVO.getBranch_code()));
        sendParam.add(new BasicNameValuePair("special_customer" , bexToSanwaVO.getSpecial_customer()));
        
        // 중개경로표시
        List<CommonBizBrcSupplyVO> commonBizBrcSupplyVO = commonBizService.getBrcSupply(bexMasterRequestVO.getNoReq());        
        for(CommonBizBrcSupplyVO dummy : commonBizBrcSupplyVO){
            logger.debug("CommonBizBrcSupplyVO dummy");
            logger.debug(dummy.toString());
            int noSupply = Integer.parseInt(dummy.getNoSupply())-1;
            
            sendParam.add(new BasicNameValuePair("seq_agency_level_list[]" , Integer.toString(noSupply)));
            sendParam.add(new BasicNameValuePair("ymd_agency_list[]" , dummy.getDtSupply()));
            sendParam.add(new BasicNameValuePair("nm_agency_list[]" , dummy.getNmSupply()));
            sendParam.add(new BasicNameValuePair("no_agency_list[]" , dummy.getNoSupplyLoan()));
            sendParam.add(new BasicNameValuePair("regnm_agency_list[]" , dummy.getNoSupplySociety()));
            sendParam.add(new BasicNameValuePair("ph_agency_list[]" , commonUtil.setPhoneNumberFormat(dummy.getNoSuuplyTel())));
            //sendParam.add(new BasicNameValuePair("ph_agency_list[]" , dummy.getNoSuuplyTel1()+"-"+dummy.getNoSuuplyTel2()+"-"+dummy.getNoSuuplyTel3()));            
        }

        // 정보적법수집
        CommonBizBrcInfoLegalVO commonBizBrcInfoLegalVO = commonBizService.getBrcInfoLegal(bexMasterRequestVO.getNoReq());
        // 매체사 홈페이지 주소
        sendParam.add(new BasicNameValuePair("agency_homeurl" , commonBizBrcInfoLegalVO.getDsAgentUrl()));
        // 고객<>중개인 연락구분
        if(commonBizBrcInfoLegalVO.getCdInfoCollect().equals("71601")){
            sendParam.add(new BasicNameValuePair("route_type" , "0"));
        }else if(commonBizBrcInfoLegalVO.getCdInfoCollect().equals("71602")){
            sendParam.add(new BasicNameValuePair("route_type" , "1"));
        }
        // 중개인연락처 알게된 경로
        if(commonBizBrcInfoLegalVO.getCdContactCust().equals("71401")){
            sendParam.add(new BasicNameValuePair("route_agency" , "1000"));
        }else if(commonBizBrcInfoLegalVO.getCdContactCust().equals("71402")){
            sendParam.add(new BasicNameValuePair("route_agency" , "1000"));
        }else if(commonBizBrcInfoLegalVO.getCdContactCust().equals("71403")){
            sendParam.add(new BasicNameValuePair("route_agency" , "0100"));
        }else if(commonBizBrcInfoLegalVO.getCdContactCust().equals("71404")){
            sendParam.add(new BasicNameValuePair("route_agency" , "0010"));
        }else if(commonBizBrcInfoLegalVO.getCdContactCust().equals("71405")){
            sendParam.add(new BasicNameValuePair("route_agency" , "0001"));
        }else if(commonBizBrcInfoLegalVO.getCdContactCust().equals("71406")){
            sendParam.add(new BasicNameValuePair("route_agency" , "0001"));
        }else if(commonBizBrcInfoLegalVO.getCdContactCust().equals("71499")){
            sendParam.add(new BasicNameValuePair("route_agency" , "0001"));
        }        
        // 중개인연락처 알게된 경로 기타일 경우 서술
        sendParam.add(new BasicNameValuePair("route_agency_doc" , commonBizBrcInfoLegalVO.getDsContactCust()));
        // 고객연락방법
        if(commonBizBrcInfoLegalVO.getCdCallAgent().equals("71701")){
            sendParam.add(new BasicNameValuePair("conn_type" , "010000"));
        }else if(commonBizBrcInfoLegalVO.getCdCallAgent().equals("71702")){
            sendParam.add(new BasicNameValuePair("conn_type" , "001000"));
        }else if(commonBizBrcInfoLegalVO.getCdCallAgent().equals("71703")){
            sendParam.add(new BasicNameValuePair("conn_type" , "000100"));
        }else if(commonBizBrcInfoLegalVO.getCdCallAgent().equals("71704")){
            sendParam.add(new BasicNameValuePair("conn_type" , "000010"));
        }else if(commonBizBrcInfoLegalVO.getCdCallAgent().equals("71705")){
            sendParam.add(new BasicNameValuePair("conn_type" , "100000"));
        }else if(commonBizBrcInfoLegalVO.getCdCallAgent().equals("71799")){
            sendParam.add(new BasicNameValuePair("conn_type" , "000001"));
        }
        // 고객연락방법 기타일경우 서술
        sendParam.add(new BasicNameValuePair("conn_doc" , commonBizBrcInfoLegalVO.getDsContactAgent()));
        // 고객연락처 알게된 경로 비매핑 000000 하드코딩
        sendParam.add(new BasicNameValuePair("route_customer" , "000000"));
        // 제공제휴처 서술항목 비매핑
        sendParam.add(new BasicNameValuePair("route_customer_doc1" , " "));
        // 경로 기타일경우 서술항목 비매핑
        sendParam.add(new BasicNameValuePair("route_customer_doc2" , " "));
        // 고객정보적법확인서작성일
        sendParam.add(new BasicNameValuePair("legal_confirm_date" ,commonUtil.maskNumberString(commonBizBrcInfoLegalVO.getDtAgent(), "####-##-##")));
        // 대부중개 대표자 이름
        sendParam.add(new BasicNameValuePair("agency_representative" , commonBizBrcInfoLegalVO.getNmAgentCeo()));
        // 담당자 이름
        sendParam.add(new BasicNameValuePair("agency_staff" , commonBizBrcInfoLegalVO.getNmAgentManager()));        

        logger.debug("requestHttpPost parameter");
        for(NameValuePair dummy: sendParam){
            logger.debug(dummy.getName()+":["+dummy.getValue()+"]");
        }
                
        CommonHttpClient commonHttpClient = new CommonHttpClient();
        logger.debug("Call BexToSanwaService requestHttpPost");
        resultPost = commonHttpClient.requestHttpPost(bexToSanwaVO.getDs_url(),sendParam,"euc-kr");
        //resultPost = commonHttpClient.requestHttpPost("https://star-lincus.cashway.co.kr/test_ksj.php",sendParam,"euc-kr");
        
        resultPost = URLDecoder.decode(resultPost, "EUC-KR");        
        logger.debug("POST Result : "+ resultPost);

        
        return resultCode;
    }
    
}
