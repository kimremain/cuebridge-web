package com.jcuesoft.cuebridge.bex.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.bex.dao.BexToActCashDAO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToActCashVO;
import com.jcuesoft.cuebridge.common.module.CommonHttpClient;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;
@Service
public class BexToActCashService extends BaseService {
    
    @Autowired
    private CommonBizService commonBizService;    
    @Autowired
    private BexMasterService bexMasterService;
    @Autowired
    private BexToActCashDAO bexToActCashDAO;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    String excute(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexToActCashService excute");
        String resultCode = "Success";      
        String imgUrl = "";
        String extData = "/ext_data/";
        String extDataAgency = "/ext_data_agency/";        

        EntityManager em = commonJPAUtil.getEm();
        commonJPAUtil.doTX(em, new Runnable() {            
            @Override
            public void run() {
                try {
                    bexMasterRequestVO.setNmScreen("접수");
                    bexMasterRequestVO.setDsCooperate("최초실행");
                    logger.debug("Call BexToActCashService excute getBexMasterNoEx");
                    bexMasterRequestVO.setNoEx(commonBizService.getBexMasterNoEx(bexMasterRequestVO.getNoReq(), em));
                    logger.debug("Call BexToActCashService excute insertBexMaster");
                    bexMasterService.insertBexMaster(bexMasterRequestVO, em);
                    logger.debug("Call BexToActCashService excute insertBexContact");
                    bexMasterService.insertBexContact(bexMasterRequestVO, em);
                } catch (Exception e) {
                    logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    logger.debug(Arrays.toString(e.getStackTrace()).replaceAll(", ", "\n"));
                }
            }
        });        
        

        imgUrl = commonBizService.getStCustomerDsImgUrl(bexMasterRequestVO.getCdCooperate());
        logger.debug("Call BexToActCashService getStCustomerDsImgUrl:"+imgUrl);

        BexToActCashVO bexToActCashVO = new BexToActCashVO();
        bexToActCashVO = bexToActCashDAO.getBexToActCash(bexMasterRequestVO);
        
        List <NameValuePair> sendParam = new ArrayList <NameValuePair>();
        sendParam.add(new BasicNameValuePair("mode", bexToActCashVO.getMode()));
        sendParam.add(new BasicNameValuePair("nm_applicant", bexToActCashVO.getNm_applicant().trim()));
        sendParam.add(new BasicNameValuePair("ssn_applicant", bexToActCashVO.getSsn_applicant()));
        sendParam.add(new BasicNameValuePair("amt_apply", bexToActCashVO.getAmt_apply()));
        sendParam.add(new BasicNameValuePair("no_agency", bexToActCashVO.getNo_agency()));
        sendParam.add(new BasicNameValuePair("id_agency", bexToActCashVO.getId_agency()));
        sendParam.add(new BasicNameValuePair("hp", bexToActCashVO.getHp()));
        sendParam.add(new BasicNameValuePair("post_home", bexToActCashVO.getPost_home()));
        sendParam.add(new BasicNameValuePair("addr1_home", bexToActCashVO.getAddr1_home()));
        sendParam.add(new BasicNameValuePair("addr2_home", bexToActCashVO.getAddr2_home()));
        sendParam.add(new BasicNameValuePair("cd_hp_co", bexToActCashVO.getCd_hp_co()));
        sendParam.add(new BasicNameValuePair("cd_marry", bexToActCashVO.getCd_marry()));
        sendParam.add(new BasicNameValuePair("cd_job_class", bexToActCashVO.getCd_job_class()));
        sendParam.add(new BasicNameValuePair("nm_comp", bexToActCashVO.getNm_comp()));
        sendParam.add(new BasicNameValuePair("ph_comp", bexToActCashVO.getPh_comp()));
        sendParam.add(new BasicNameValuePair("nm_duty_comp", bexToActCashVO.getNm_duty_comp()));
        sendParam.add(new BasicNameValuePair("nm_part_comp", bexToActCashVO.getNm_part_comp()));
        sendParam.add(new BasicNameValuePair("ym_start_comp", bexToActCashVO.getYm_start_comp()));
        sendParam.add(new BasicNameValuePair("amt_monthly_income", bexToActCashVO.getAmt_monthly_income()));
        if(bexToActCashVO.getUrl_attach_file1().trim().length() != 0){
            commonUtil.copyFile(bexToActCashVO.getUrl_attach_file1(), bexToActCashVO.getUrl_attach_file1().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("url_attach_file1", bexToActCashVO.getUrl_attach_file1().replace(extData, imgUrl)));
        }        
        if(bexToActCashVO.getUrl_attach_file2().trim().length() != 0){
            commonUtil.copyFile(bexToActCashVO.getUrl_attach_file2(), bexToActCashVO.getUrl_attach_file2().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("url_attach_file2", bexToActCashVO.getUrl_attach_file2().replace(extData, imgUrl)));
        }        
        if(bexToActCashVO.getUrl_attach_file3().trim().length() != 0){
            commonUtil.copyFile(bexToActCashVO.getUrl_attach_file3(), bexToActCashVO.getUrl_attach_file3().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("url_attach_file3", bexToActCashVO.getUrl_attach_file3().replace(extData, imgUrl)));
        }
        if(bexToActCashVO.getUrl_attach_file4().trim().length() != 0){
            commonUtil.copyFile(bexToActCashVO.getUrl_attach_file4(), bexToActCashVO.getUrl_attach_file4().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("url_attach_file4", bexToActCashVO.getUrl_attach_file4().replace(extData, imgUrl)));
        }
        if(bexToActCashVO.getUrl_attach_file5().trim().length() != 0){
            commonUtil.copyFile(bexToActCashVO.getUrl_attach_file5(), bexToActCashVO.getUrl_attach_file5().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("url_attach_file5", bexToActCashVO.getUrl_attach_file5().replace(extData, imgUrl)));
        }
        if(bexToActCashVO.getUrl_attach_file6().trim().length() != 0){
            commonUtil.copyFile(bexToActCashVO.getUrl_attach_file6(), bexToActCashVO.getUrl_attach_file6().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("url_attach_file6", bexToActCashVO.getUrl_attach_file6().replace(extData, imgUrl)));
        }
        if(bexToActCashVO.getUrl_attach_file7().trim().length() != 0){
            commonUtil.copyFile(bexToActCashVO.getUrl_attach_file7(), bexToActCashVO.getUrl_attach_file7().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("url_attach_file7", bexToActCashVO.getUrl_attach_file7().replace(extData, imgUrl)));
        }
        if(bexToActCashVO.getUrl_attach_file8().trim().length() != 0){
            commonUtil.copyFile(bexToActCashVO.getUrl_attach_file8(), bexToActCashVO.getUrl_attach_file8().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("url_attach_file8", bexToActCashVO.getUrl_attach_file8().replace(extData, imgUrl)));
        }
        if(bexToActCashVO.getUrl_attach_file9().trim().length() != 0){
            commonUtil.copyFile(bexToActCashVO.getUrl_attach_file9(), bexToActCashVO.getUrl_attach_file9().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("url_attach_file9", bexToActCashVO.getUrl_attach_file9().replace(extData, imgUrl)));
        }
        if(bexToActCashVO.getUrl_attach_file10().trim().length() != 0){
            commonUtil.copyFile(bexToActCashVO.getUrl_attach_file10(), bexToActCashVO.getUrl_attach_file10().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("url_attach_file10", bexToActCashVO.getUrl_attach_file10().replace(extData, imgUrl)));
        }
        
        sendParam.add(new BasicNameValuePair("nm_grt_list", bexToActCashVO.getNm_grt_list().trim()));
        sendParam.add(new BasicNameValuePair("ssn_grt_list", bexToActCashVO.getSsn_grt_list()));
        sendParam.add(new BasicNameValuePair("hp_grt_list", bexToActCashVO.getHp_grt_list()));
        sendParam.add(new BasicNameValuePair("cd_job_class_grt_list", bexToActCashVO.getCd_job_class_grt_list()));
        sendParam.add(new BasicNameValuePair("cd_goods", bexToActCashVO.getCd_goods()));        
        // 중개경로
        ArrayList seq_agency_level_list;
        ArrayList ymd_agency_list;
        ArrayList nm_agency_list;
        ArrayList no_agency_list;
        ArrayList ph_agency_list;
        ArrayList no_institute_list;
        String strSplit = ",";
        
        seq_agency_level_list = new ArrayList(Arrays.asList(bexToActCashVO.getSeq_agency_level_list().split(strSplit)));
        ymd_agency_list = new ArrayList(Arrays.asList(bexToActCashVO.getYmd_agency_list().split(strSplit)));
        nm_agency_list = new ArrayList(Arrays.asList(bexToActCashVO.getNm_agency_list().split(strSplit)));
        no_agency_list = new ArrayList(Arrays.asList(bexToActCashVO.getNo_agency_list().split(strSplit)));
        ph_agency_list = new ArrayList(Arrays.asList(bexToActCashVO.getPh_agency_list().split(strSplit)));
        no_institute_list = new ArrayList(Arrays.asList(bexToActCashVO.getNo_institute_list().split(strSplit)));
        
        for (int i = 0; i < seq_agency_level_list.size(); i++){
            sendParam.add(new BasicNameValuePair("seq_agency_level_list", (String) seq_agency_level_list.get(i)));
        }
        for (int i = 0; i < ymd_agency_list.size(); i++){
            sendParam.add(new BasicNameValuePair("ymd_agency_list", (String) ymd_agency_list.get(i)));
        }
        for (int i = 0; i < nm_agency_list.size(); i++){
            sendParam.add(new BasicNameValuePair("nm_agency_list", (String) nm_agency_list.get(i)));
        }
        for (int i = 0; i < no_agency_list.size(); i++){
            sendParam.add(new BasicNameValuePair("no_agency_list", (String) no_agency_list.get(i)));
        }
        for (int i = 0; i < ph_agency_list.size(); i++){
            sendParam.add(new BasicNameValuePair("ph_agency_list", (String) ph_agency_list.get(i)));
        }
        for (int i = 0; i < no_institute_list.size(); i++){
            sendParam.add(new BasicNameValuePair("no_institute_list", (String) no_institute_list.get(i)));
        }
        
        sendParam.add(new BasicNameValuePair("seq_agency_level_list", bexToActCashVO.getSeq_agency_level_list()));
        sendParam.add(new BasicNameValuePair("ymd_agency_list", bexToActCashVO.getYmd_agency_list()));
        sendParam.add(new BasicNameValuePair("nm_agency_list", bexToActCashVO.getNm_agency_list()));
        sendParam.add(new BasicNameValuePair("no_agency_list", bexToActCashVO.getNo_agency_list()));
        sendParam.add(new BasicNameValuePair("ph_agency_list", bexToActCashVO.getPh_agency_list()));
        sendParam.add(new BasicNameValuePair("no_institute_list", bexToActCashVO.getNo_institute_list()));

        //20141022 적법수집데이터 추가 by 김성준
        sendParam.add(new BasicNameValuePair("agent_path_type", bexToActCashVO.getAgent_path_type()));
        sendParam.add(new BasicNameValuePair("agent_path_route", bexToActCashVO.getAgent_path_route()));
        sendParam.add(new BasicNameValuePair("agent_path_call", bexToActCashVO.getAgent_path_call()));
        sendParam.add(new BasicNameValuePair("agent_path_name", bexToActCashVO.getAgent_path_name()));
        sendParam.add(new BasicNameValuePair("agent_owner", bexToActCashVO.getAgent_owner()));
        sendParam.add(new BasicNameValuePair("agent_homepage", bexToActCashVO.getAgent_homepage()));
        sendParam.add(new BasicNameValuePair("agent_staff", bexToActCashVO.getAgent_staff()));
        sendParam.add(new BasicNameValuePair("agent_date", bexToActCashVO.getAgent_date()));
        sendParam.add(new BasicNameValuePair("agent_path_etc", bexToActCashVO.getAgent_path_etc()));
        // 20141114 연동메모 추가 by 김성준
        sendParam.add(new BasicNameValuePair("memo_agency", bexToActCashVO.getMemo_agency()));
        
        //20150120 추가 by 김성준 : 액트오류방지 임시값
        sendParam.add(new BasicNameValuePair("post_home_grt_list", "000000"));
        sendParam.add(new BasicNameValuePair("post_reg_grt_list", "000000"));
        sendParam.add(new BasicNameValuePair("post_comp_grt_list", "000000"));
        
        logger.debug("requestHttpPost parameter");
        for(NameValuePair dummy: sendParam){
            logger.debug(dummy.getName()+":"+dummy.getValue());
        }
        CommonHttpClient commonHttpClient = new CommonHttpClient();
        logger.debug("Call BexToActCashService requestHttpPost");
        String resultPost = commonHttpClient.requestHttpPost(bexToActCashVO.getDs_url(),sendParam,"euc-kr");
        logger.debug("POST Result : "+ resultPost);
        
        return resultCode;
    }
    
}
