package com.jcuesoft.cuebridge.bex.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jcuesoft.cuebridge.bex.dao.BexToBridgeDAO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToBridgeVO;
import com.jcuesoft.cuebridge.common.module.CommonHttpClient;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;
import com.jcuesoft.cuebridge.common.vo.CommonBizBrcInfoLegalVO;
import com.jcuesoft.cuebridge.common.vo.CommonBizBrcSupplyVO;
import com.jcuesoft.cuebridge.common.vo.CommonBizSafekeyOfferVO;

@Service
public class BexToBridgeService extends BaseService {
    @Autowired
    private CommonBizService commonBizService;    
    @Autowired
    private BexMasterService bexMasterService;
    @Autowired
    private BexToBridgeDAO bexToBridgeDAO;
    
    String excute(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexToBridgeService excute");
        String resultCode = ""; //resultCode        
        String imgUrl = "";
        String extData = "/ext_data/";
        String extDataAgency = "/ext_data_agency/";        
        resultCode = "Success";        
        
        logger.debug("Call BexToBridgeService excute getBexMasterNoEx");
        bexMasterRequestVO.setNoEx(commonBizService.getBexMasterNoEx(bexMasterRequestVO.getNoReq()));
        imgUrl = commonBizService.getStCustomerDsImgUrl(bexMasterRequestVO.getCdCooperate());
        logger.debug("Call BexToBridgeService getStCustomerDsImgUrl:"+imgUrl);
        logger.debug("Call BexToBridgeService excute insertBexMaster");
        bexMasterService.insertBexMaster(bexMasterRequestVO);
        logger.debug("Call BexToBridgeService excute insertBexContact");
        bexMasterRequestVO.setNmScreen("접수");
        bexMasterRequestVO.setDsCooperate("최초실행");        
        bexMasterService.insertBexContact(bexMasterRequestVO);
        
        BexToBridgeVO bexToBridgeVO = new BexToBridgeVO();
        bexToBridgeVO = bexToBridgeDAO.getBexToBridge(bexMasterRequestVO);
        
        List <NameValuePair> sendParam = new ArrayList <NameValuePair>();
        
        /*중개경로표시서*/
        List<CommonBizBrcSupplyVO> commonBizBrcSupplyVO = commonBizService.getBrcSupply(bexMasterRequestVO.getNoReq());
        String pipe = "";
        String noSupply = "";
        String dtSupply = "";
        String nmSupply = "";
        String noSupplyLoan = "";
        String noSupplySociety = "";
        String noSupplyTel = "";
        for(CommonBizBrcSupplyVO dummy : commonBizBrcSupplyVO){    
            noSupply = noSupply + pipe + dummy.getNoSupply();
            dtSupply = dtSupply + pipe + dummy.getDtSupply();
            nmSupply = nmSupply + pipe + dummy.getNmSupply();
            noSupplyLoan = noSupplyLoan + pipe + dummy.getNoSupplyLoan();
            noSupplySociety = noSupplySociety + pipe + dummy.getNoSupplySociety();
            noSupplyTel = noSupplyTel + pipe + dummy.getNoSuuplyTel();
            logger.debug("noSupply:"+noSupply);
            logger.debug("pipe:"+pipe);
            pipe = "||";
        }
        sendParam.add(new BasicNameValuePair("no_supply", noSupply));
        sendParam.add(new BasicNameValuePair("dt_supply", dtSupply));
        sendParam.add(new BasicNameValuePair("nm_supply", nmSupply));
        sendParam.add(new BasicNameValuePair("no_supply_loan", noSupplyLoan));
        sendParam.add(new BasicNameValuePair("no_supply_society", noSupplySociety));
        sendParam.add(new BasicNameValuePair("no_supply_tel", noSupplyTel));  
        
        /*정보적법수집확인서*/
        CommonBizBrcInfoLegalVO commonBizBrcInfoLegalVO = commonBizService.getBrcInfoLegal(bexMasterRequestVO.getNoReq());
        sendParam.add(new BasicNameValuePair("cd_info_collect", commonBizBrcInfoLegalVO.getCdInfoCollect()));
        sendParam.add(new BasicNameValuePair("cd_contact_cust", commonBizBrcInfoLegalVO.getCdContactCust()));
        sendParam.add(new BasicNameValuePair("ds_contact_cust", commonBizBrcInfoLegalVO.getDsContactCust()));
        sendParam.add(new BasicNameValuePair("cd_contact_agent", commonBizBrcInfoLegalVO.getCdContactAgent()));
        sendParam.add(new BasicNameValuePair("nm_contact_agent", commonBizBrcInfoLegalVO.getNmContactAgent()));
        sendParam.add(new BasicNameValuePair("ds_contact_agent", commonBizBrcInfoLegalVO.getDsContactAgent()));
        sendParam.add(new BasicNameValuePair("cd_call_agent", commonBizBrcInfoLegalVO.getCdCallAgent()));
        sendParam.add(new BasicNameValuePair("dt_agent", commonBizBrcInfoLegalVO.getDtAgent()));
        sendParam.add(new BasicNameValuePair("nm_agent_ceo", commonBizBrcInfoLegalVO.getNmAgentCeo()));
        sendParam.add(new BasicNameValuePair("nm_agent", commonBizBrcInfoLegalVO.getNmAgent()));
        sendParam.add(new BasicNameValuePair("nm_agent_manager", commonBizBrcInfoLegalVO.getNmAgentManager()));
        sendParam.add(new BasicNameValuePair("ds_agent_url", commonBizBrcInfoLegalVO.getDsAgentUrl()));
        
        /*신청정보*/
        sendParam.add(new BasicNameValuePair("cd_cooperate", bexToBridgeVO.getCd_cooperate()));
        sendParam.add(new BasicNameValuePair("no_cooperate", bexToBridgeVO.getNo_cooperate()));
        sendParam.add(new BasicNameValuePair("cd_path", bexToBridgeVO.getCd_path()));
        sendParam.add(new BasicNameValuePair("yn_surety", bexToBridgeVO.getYn_surety()));
        sendParam.add(new BasicNameValuePair("cd_pdt", bexToBridgeVO.getCd_pdt()));
        sendParam.add(new BasicNameValuePair("dd", bexToBridgeVO.getDd()));
        sendParam.add(new BasicNameValuePair("am_custom", bexToBridgeVO.getAm_custom()));
        sendParam.add(new BasicNameValuePair("cd_use", bexToBridgeVO.getCd_use()));
        sendParam.add(new BasicNameValuePair("cd_echanel", bexToBridgeVO.getCd_echanel()));
        sendParam.add(new BasicNameValuePair("cd_eportal", bexToBridgeVO.getCd_eportal()));
        sendParam.add(new BasicNameValuePair("nm_ekeyword", bexToBridgeVO.getNm_ekeyword()));
        sendParam.add(new BasicNameValuePair("cd_epath", bexToBridgeVO.getCd_epath()));
        sendParam.add(new BasicNameValuePair("ds_receive", bexToBridgeVO.getDs_receive()));
        
/*        String removeString = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        String tmpMemo = bexToBridgeVO.getDs_memo();
        tmpMemo.replaceAll("||", "split");
        tmpMemo.replaceAll(removeString, "");
        tmpMemo.replaceAll("split|", "||");
        sendParam.add(new BasicNameValuePair("ds_memo", tmpMemo));*/
        sendParam.add(new BasicNameValuePair("ds_memo", bexToBridgeVO.getDs_memo()));
        sendParam.add(new BasicNameValuePair("cd_recruit_group", bexToBridgeVO.getCd_recruit_group()));
        
        /*고객기본정보*/
        sendParam.add(new BasicNameValuePair("nm_custom", bexToBridgeVO.getNm_custom()));
        sendParam.add(new BasicNameValuePair("no_custom", bexToBridgeVO.getNo_custom()));
        sendParam.add(new BasicNameValuePair("cd_bank", bexToBridgeVO.getCd_bank()));
        sendParam.add(new BasicNameValuePair("no_bank_act", bexToBridgeVO.getNo_bank_act()));
        sendParam.add(new BasicNameValuePair("ds_email", bexToBridgeVO.getDs_email()));
        sendParam.add(new BasicNameValuePair("cd_marry", bexToBridgeVO.getCd_marry()));
        sendParam.add(new BasicNameValuePair("cd_knd_mobile", bexToBridgeVO.getCd_knd_mobile()));
        sendParam.add(new BasicNameValuePair("no_tel1_mobile", bexToBridgeVO.getNo_tel1_mobile()));
        sendParam.add(new BasicNameValuePair("no_tel2_mobile", bexToBridgeVO.getNo_tel2_mobile()));
        sendParam.add(new BasicNameValuePair("no_tel3_mobile", bexToBridgeVO.getNo_tel3_mobile()));
        sendParam.add(new BasicNameValuePair("no_fax1", bexToBridgeVO.getNo_fax1()));
        sendParam.add(new BasicNameValuePair("no_fax2", bexToBridgeVO.getNo_fax2()));
        sendParam.add(new BasicNameValuePair("no_fax3", bexToBridgeVO.getNo_fax3()));
        sendParam.add(new BasicNameValuePair("yn_nice_safekey", bexToBridgeVO.getYn_nice_safekey()));
        sendParam.add(new BasicNameValuePair("ds_nice_safekey", bexToBridgeVO.getDs_nice_safekey()));
        sendParam.add(new BasicNameValuePair("ds_nice_safekey_ext", bexToBridgeVO.getDs_nice_safekey_ext()));
        
        /*고객직장정보*/
        sendParam.add(new BasicNameValuePair("cd_job_kind", bexToBridgeVO.getCd_job_kind()));
        sendParam.add(new BasicNameValuePair("cd_rank", bexToBridgeVO.getCd_rank()));
        sendParam.add(new BasicNameValuePair("cd_job_act", bexToBridgeVO.getCd_job_act()));
        sendParam.add(new BasicNameValuePair("cd_job_status", bexToBridgeVO.getCd_job_status()));
        sendParam.add(new BasicNameValuePair("nm_comp", bexToBridgeVO.getNm_comp()));
        sendParam.add(new BasicNameValuePair("nm_dept", bexToBridgeVO.getNm_dept()));
        sendParam.add(new BasicNameValuePair("dt_reg_join", bexToBridgeVO.getDt_reg_join()));
        sendParam.add(new BasicNameValuePair("dd_pay", bexToBridgeVO.getDd_pay()));
        sendParam.add(new BasicNameValuePair("am_pay_month", bexToBridgeVO.getAm_pay_month()));
        sendParam.add(new BasicNameValuePair("no_post_comp", bexToBridgeVO.getNo_post_comp()));
        sendParam.add(new BasicNameValuePair("ds_strt_comp", bexToBridgeVO.getDs_strt_comp()));
        sendParam.add(new BasicNameValuePair("ds_addr_comp", bexToBridgeVO.getDs_addr_comp()));
        sendParam.add(new BasicNameValuePair("no_maintel1_comp", bexToBridgeVO.getNo_maintel1_comp()));
        sendParam.add(new BasicNameValuePair("no_maintel2_comp", bexToBridgeVO.getNo_maintel2_comp()));
        sendParam.add(new BasicNameValuePair("no_maintel3_comp", bexToBridgeVO.getNo_maintel3_comp()));
        
        /*고객주거정보*/
        sendParam.add(new BasicNameValuePair("dt_reg_home", bexToBridgeVO.getDt_reg_home()));
        sendParam.add(new BasicNameValuePair("am_deposit_home", bexToBridgeVO.getAm_deposit_home()));
        sendParam.add(new BasicNameValuePair("am_rent_home", bexToBridgeVO.getAm_rent_home()));
        sendParam.add(new BasicNameValuePair("no_post_home", bexToBridgeVO.getNo_post_home()));
        sendParam.add(new BasicNameValuePair("ds_strt_home", bexToBridgeVO.getDs_strt_home()));
        sendParam.add(new BasicNameValuePair("ds_addr_home", bexToBridgeVO.getDs_addr_home()));
        sendParam.add(new BasicNameValuePair("no_tel1_home", bexToBridgeVO.getNo_tel1_home()));
        sendParam.add(new BasicNameValuePair("no_tel2_home", bexToBridgeVO.getNo_tel2_home()));
        sendParam.add(new BasicNameValuePair("no_tel3_home", bexToBridgeVO.getNo_tel3_home()));
        sendParam.add(new BasicNameValuePair("no_post_cert", bexToBridgeVO.getNo_post_cert()));
        sendParam.add(new BasicNameValuePair("ds_strt_cert", bexToBridgeVO.getDs_strt_cert()));
        sendParam.add(new BasicNameValuePair("ds_addr_cert", bexToBridgeVO.getDs_addr_cert()));
        sendParam.add(new BasicNameValuePair("no_post_real", bexToBridgeVO.getNo_post_real()));
        sendParam.add(new BasicNameValuePair("ds_strt_real", bexToBridgeVO.getDs_strt_real()));
        sendParam.add(new BasicNameValuePair("ds_addr_real", bexToBridgeVO.getDs_addr_real()));
        
        /*보증인기본정보*/
        sendParam.add(new BasicNameValuePair("s_nm_custom", bexToBridgeVO.getS_nm_custom()));
        sendParam.add(new BasicNameValuePair("s_no_custom", bexToBridgeVO.getS_no_custom()));
        sendParam.add(new BasicNameValuePair("s_ds_email", bexToBridgeVO.getS_ds_email()));
        sendParam.add(new BasicNameValuePair("s_cd_marry", bexToBridgeVO.getS_cd_marry()));
        sendParam.add(new BasicNameValuePair("s_cd_knd_mobile", bexToBridgeVO.getS_cd_knd_mobile()));
        sendParam.add(new BasicNameValuePair("s_no_tel1_mobile", bexToBridgeVO.getS_no_tel1_mobile()));
        sendParam.add(new BasicNameValuePair("s_no_tel2_mobile", bexToBridgeVO.getS_no_tel2_mobile()));
        sendParam.add(new BasicNameValuePair("s_no_tel3_mobile", bexToBridgeVO.getS_no_tel3_mobile()));
        sendParam.add(new BasicNameValuePair("s_no_fax1", bexToBridgeVO.getS_no_fax1()));
        sendParam.add(new BasicNameValuePair("s_no_fax2", bexToBridgeVO.getS_no_fax2()));
        sendParam.add(new BasicNameValuePair("s_no_fax3", bexToBridgeVO.getS_no_fax3()));
        sendParam.add(new BasicNameValuePair("s_yn_nice_safekey", bexToBridgeVO.getS_yn_nice_safekey()));
        sendParam.add(new BasicNameValuePair("s_ds_nice_safekey", bexToBridgeVO.getS_ds_nice_safekey()));
        sendParam.add(new BasicNameValuePair("s_ds_nice_safekey_ext", bexToBridgeVO.getS_ds_nice_safekey_ext()));
        
        /*보증인직장정보*/
        sendParam.add(new BasicNameValuePair("s_cd_job_kind", bexToBridgeVO.getS_cd_job_kind()));
        sendParam.add(new BasicNameValuePair("s_cd_rank", bexToBridgeVO.getS_cd_rank()));
        sendParam.add(new BasicNameValuePair("s_cd_job_act", bexToBridgeVO.getS_cd_job_act()));
        sendParam.add(new BasicNameValuePair("s_cd_job_status", bexToBridgeVO.getS_cd_job_status()));
        sendParam.add(new BasicNameValuePair("s_nm_comp", bexToBridgeVO.getS_nm_comp()));
        sendParam.add(new BasicNameValuePair("s_nm_dept", bexToBridgeVO.getS_nm_dept()));
        sendParam.add(new BasicNameValuePair("s_dt_reg_join", bexToBridgeVO.getS_dt_reg_join()));
        sendParam.add(new BasicNameValuePair("s_dd_pay", bexToBridgeVO.getS_dd_pay()));
        sendParam.add(new BasicNameValuePair("s_am_pay_month", bexToBridgeVO.getS_am_pay_month()));
        sendParam.add(new BasicNameValuePair("s_no_post_comp", bexToBridgeVO.getS_no_post_comp()));
        sendParam.add(new BasicNameValuePair("s_ds_strt_comp", bexToBridgeVO.getS_ds_strt_comp()));
        sendParam.add(new BasicNameValuePair("s_ds_addr_comp", bexToBridgeVO.getS_ds_addr_comp()));
        sendParam.add(new BasicNameValuePair("s_no_maintel1_comp", bexToBridgeVO.getS_no_maintel1_comp()));
        sendParam.add(new BasicNameValuePair("s_no_maintel2_comp", bexToBridgeVO.getS_no_maintel2_comp()));
        sendParam.add(new BasicNameValuePair("s_no_maintel3_comp", bexToBridgeVO.getS_no_maintel3_comp()));
        
        /*보증인주거정보*/
        sendParam.add(new BasicNameValuePair("s_dt_reg_home", bexToBridgeVO.getS_dt_reg_home()));
        sendParam.add(new BasicNameValuePair("s_am_deposit_home", bexToBridgeVO.getS_am_deposit_home()));
        sendParam.add(new BasicNameValuePair("s_am_rent_home", bexToBridgeVO.getS_am_rent_home()));
        sendParam.add(new BasicNameValuePair("s_no_post_home", bexToBridgeVO.getS_no_post_home()));
        sendParam.add(new BasicNameValuePair("s_ds_strt_home", bexToBridgeVO.getS_ds_strt_home()));
        sendParam.add(new BasicNameValuePair("s_ds_addr_home", bexToBridgeVO.getS_ds_addr_home()));
        sendParam.add(new BasicNameValuePair("s_no_tel1_home", bexToBridgeVO.getS_no_tel1_home()));
        sendParam.add(new BasicNameValuePair("s_no_tel2_home", bexToBridgeVO.getS_no_tel2_home()));
        sendParam.add(new BasicNameValuePair("s_no_tel3_home", bexToBridgeVO.getS_no_tel3_home()));
        sendParam.add(new BasicNameValuePair("s_no_post_cert", bexToBridgeVO.getS_no_post_cert()));
        sendParam.add(new BasicNameValuePair("s_ds_strt_cert", bexToBridgeVO.getS_ds_strt_cert()));
        sendParam.add(new BasicNameValuePair("s_ds_addr_cert", bexToBridgeVO.getS_ds_addr_cert()));
        sendParam.add(new BasicNameValuePair("s_no_post_real", bexToBridgeVO.getS_no_post_real()));
        sendParam.add(new BasicNameValuePair("s_ds_strt_real", bexToBridgeVO.getS_ds_strt_real()));
        sendParam.add(new BasicNameValuePair("s_ds_addr_real", bexToBridgeVO.getS_ds_addr_real()));
        
        /*차주 보증인 세이프키연계기관,연계키 */
        CommonBizSafekeyOfferVO commonBizSafekeyOfferVO = new CommonBizSafekeyOfferVO();
        commonBizSafekeyOfferVO = commonBizService.getSafekeyOffer(bexMasterRequestVO.getNoReq());
        
        sendParam.add(new BasicNameValuePair("cd_nice_safekey_ext", commonBizSafekeyOfferVO.getCd_nice_safekey_ext()));
        sendParam.add(new BasicNameValuePair("ds_nice_safekey_ext", commonBizSafekeyOfferVO.getDs_nice_safekey_ext()));
        sendParam.add(new BasicNameValuePair("s_cd_nice_safekey_ext", commonBizSafekeyOfferVO.getS_cd_nice_safekey_ext()));
        sendParam.add(new BasicNameValuePair("s_ds_nice_safekey_ext", commonBizSafekeyOfferVO.getS_ds_nice_safekey_ext()));
        
        /*파일이관*/
        if(bexToBridgeVO.getDs_url() != null){
            @SuppressWarnings({ "rawtypes", "unchecked" })
            ArrayList arrFile = new ArrayList(Arrays.asList(bexToBridgeVO.getDs_url().split("\\|\\|")));      
            for (int i = 0; i < arrFile.size(); i++){
                commonUtil.copyFile((String) arrFile.get(i), ((String) arrFile.get(i)).replaceAll(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/") );
            }
            sendParam.add(new BasicNameValuePair("ds_url", bexToBridgeVO.getDs_url().replaceAll(extData, imgUrl)));            
        }
        
        /*파라미터확인*/
        logger.debug("requestHttpPost parameter");
        for(NameValuePair dummy: sendParam){
            logger.debug(dummy.getName()+":["+dummy.getValue()+"]");
        }
        
        /*송신*/
        CommonHttpClient commonHttpClient = new CommonHttpClient();
        logger.debug("Call BexToBridgeService requestHttpPost");
        String resultPost = commonHttpClient.requestHttpPost(bexToBridgeVO.getDs_url_server(),sendParam,"utf-8");
        logger.debug("POST Result : "+ resultPost);
        
        /*수신 결과처리*/
        java.lang.reflect.Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
        Gson gson = new Gson();
        Map<String, Object> resultMap = gson.fromJson(resultPost, mapType );
        if(resultMap.get("cd_result").equals("F")){
            bexMasterRequestVO.setNmScreen("접수실패");
            bexMasterRequestVO.setDsCooperate(resultMap.get("ds_result").toString());
            bexMasterService.updateBexMaster(bexMasterRequestVO);            
            bexMasterService.insertBexContact(bexMasterRequestVO); 
        }
        
        return resultCode;
    }
}
