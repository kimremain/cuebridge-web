package com.jcuesoft.cuebridge.bex.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.bex.dao.BexToAdvanceDAO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToAdvanceVO;
import com.jcuesoft.cuebridge.common.module.CommonHttpClient;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;
@Service
public class BexToAdvanceService extends BaseService {
    
    @Autowired
    private CommonBizService commonBizService;    
    @Autowired
    private BexMasterService bexMasterService;
    @Autowired
    private BexToAdvanceDAO bexToAdvanceDAO;    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    String excute(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexToActCashService excute");
        String resultCode = ""; //resultCode        
        String nmScreen = "";
        String resultPost = "";
        String resultMemo = "";
        String imgUrl = "";
        String extData = "/ext_data/";
        String extDataAgency = "/ext_data_agency/";        
        resultCode = "Success";        
        
        logger.debug("Call BexToAdvanceService excute getBexMasterNoEx");
        bexMasterRequestVO.setNoEx(commonBizService.getBexMasterNoEx(bexMasterRequestVO.getNoReq()));
        imgUrl = commonBizService.getStCustomerDsImgUrl(bexMasterRequestVO.getCdCooperate());
        logger.debug("Call BexToActCashService getStCustomerDsImgUrl:"+imgUrl);
        logger.debug("Call BexToActCashService excute insertBexMaster");
        bexMasterService.insertBexMaster(bexMasterRequestVO);
        logger.debug("Call BexToActCashService excute insertBexContact");
        bexMasterRequestVO.setNmScreen("접수");
        bexMasterRequestVO.setDsCooperate("최초실행");        
        bexMasterService.insertBexContact(bexMasterRequestVO);
        
        BexToAdvanceVO bexToAdvanceVO = new BexToAdvanceVO();
        bexToAdvanceVO = bexToAdvanceDAO.getBexToAdvance(bexMasterRequestVO);
        
        List <NameValuePair> sendParam = new ArrayList <NameValuePair>();
        sendParam.add(new BasicNameValuePair("pro_code", bexToAdvanceVO.getPro_code()));
        sendParam.add(new BasicNameValuePair("com_code", bexToAdvanceVO.getCom_code()));
        sendParam.add(new BasicNameValuePair("cooperate_code", bexToAdvanceVO.getCooperate_code()));
        sendParam.add(new BasicNameValuePair("collection_route", bexToAdvanceVO.getCollection_route()));
        sendParam.add(new BasicNameValuePair("agent_route", bexToAdvanceVO.getAgent_route()));
        sendParam.add(new BasicNameValuePair("agent_route_memo", bexToAdvanceVO.getAgent_route_memo()));
        sendParam.add(new BasicNameValuePair("member_contact", bexToAdvanceVO.getMember_contact()));
        sendParam.add(new BasicNameValuePair("member_contact_memo", bexToAdvanceVO.getMember_contact_memo()));
        sendParam.add(new BasicNameValuePair("member_route", bexToAdvanceVO.getMember_route()));
        sendParam.add(new BasicNameValuePair("member_route_memo", bexToAdvanceVO.getMember_route_memo()));
        sendParam.add(new BasicNameValuePair("collection_date", bexToAdvanceVO.getCollection_date()));
        sendParam.add(new BasicNameValuePair("collection_main", bexToAdvanceVO.getCollection_main()));
        sendParam.add(new BasicNameValuePair("collection_sub", bexToAdvanceVO.getCollection_sub()));

        sendParam.add(new BasicNameValuePair("name", bexToAdvanceVO.getName()));
        sendParam.add(new BasicNameValuePair("ssn11", bexToAdvanceVO.getSsn11()));
        sendParam.add(new BasicNameValuePair("ssn12", bexToAdvanceVO.getSsn12()));
        sendParam.add(new BasicNameValuePair("ph11", bexToAdvanceVO.getPh11()));
        sendParam.add(new BasicNameValuePair("ph12", bexToAdvanceVO.getPh12()));
        sendParam.add(new BasicNameValuePair("ph13", bexToAdvanceVO.getPh13()));
        
        sendParam.add(new BasicNameValuePair("ph21", bexToAdvanceVO.getPh21()));
        sendParam.add(new BasicNameValuePair("ph22", bexToAdvanceVO.getPh22()));
        sendParam.add(new BasicNameValuePair("ph23", bexToAdvanceVO.getPh23()));
        sendParam.add(new BasicNameValuePair("app_money", bexToAdvanceVO.getApp_money()));
        
        sendParam.add(new BasicNameValuePair("job_class", bexToAdvanceVO.getJob_class()));
        
        sendParam.add(new BasicNameValuePair("A_com_name", bexToAdvanceVO.getA_com_name()));
        
        sendParam.add(new BasicNameValuePair("A_ph31", bexToAdvanceVO.getA_ph31()));
        sendParam.add(new BasicNameValuePair("A_ph32", bexToAdvanceVO.getA_ph32()));
        sendParam.add(new BasicNameValuePair("A_ph33", bexToAdvanceVO.getA_ph33()));

        sendParam.add(new BasicNameValuePair("A_com_part", bexToAdvanceVO.getA_com_part()));
        sendParam.add(new BasicNameValuePair("A_worker_term_year", bexToAdvanceVO.getA_worker_term_year()));
        sendParam.add(new BasicNameValuePair("A_worker_term_month", bexToAdvanceVO.getA_worker_term_month()));

        sendParam.add(new BasicNameValuePair("A_pay", bexToAdvanceVO.getA_pay()));
        
        if(bexToAdvanceVO.getImg_url1().trim().length() != 0){
            commonUtil.copyFile(bexToAdvanceVO.getImg_url1(), bexToAdvanceVO.getImg_url1().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("img_url1", bexToAdvanceVO.getImg_url1().replace(extData, imgUrl)));
            sendParam.add(new BasicNameValuePair("img_type1", bexToAdvanceVO.getImg_type1()));
        }
        if(bexToAdvanceVO.getImg_url2().trim().length() != 0){
            commonUtil.copyFile(bexToAdvanceVO.getImg_url2(), bexToAdvanceVO.getImg_url2().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("img_url2", bexToAdvanceVO.getImg_url2().replace(extData, imgUrl)));
            sendParam.add(new BasicNameValuePair("img_type2", bexToAdvanceVO.getImg_type2()));
        }
        if(bexToAdvanceVO.getImg_url3().trim().length() != 0){
            commonUtil.copyFile(bexToAdvanceVO.getImg_url3(), bexToAdvanceVO.getImg_url3().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("img_url3", bexToAdvanceVO.getImg_url3().replace(extData, imgUrl)));
            sendParam.add(new BasicNameValuePair("img_type3", bexToAdvanceVO.getImg_type3()));
        }

        sendParam.add(new BasicNameValuePair("memo", bexToAdvanceVO.getMemo()));

        sendParam.add(new BasicNameValuePair("G1_name", bexToAdvanceVO.getG1_name()));
        sendParam.add(new BasicNameValuePair("G1_ssn11", bexToAdvanceVO.getG1_ssn11()));
        sendParam.add(new BasicNameValuePair("G1_ssn12", bexToAdvanceVO.getG1_ssn12()));
        
        sendParam.add(new BasicNameValuePair("G1_ph21", bexToAdvanceVO.getG1_ph21()));
        sendParam.add(new BasicNameValuePair("G1_ph22", bexToAdvanceVO.getG1_ph22()));
        sendParam.add(new BasicNameValuePair("G1_ph23", bexToAdvanceVO.getG1_ph23()));

        // 중개경로
        ArrayList agent_level;
        ArrayList agent_app_date;
        ArrayList agent_name;
        ArrayList agent_ssn;
        ArrayList agent_ph11;
        ArrayList agent_ph12;
        ArrayList agent_ph13;
        ArrayList agent_reg_code;
        String strSplit = ",";
        
        agent_level = new ArrayList(Arrays.asList(bexToAdvanceVO.getAgent_level().split(strSplit)));
        agent_app_date = new ArrayList(Arrays.asList(bexToAdvanceVO.getAgent_app_date().split(strSplit)));
        agent_name = new ArrayList(Arrays.asList(bexToAdvanceVO.getAgent_name().split(strSplit)));
        agent_ssn = new ArrayList(Arrays.asList(bexToAdvanceVO.getAgent_ssn().split(strSplit)));
        agent_ph11 = new ArrayList(Arrays.asList(bexToAdvanceVO.getAgent_ph11().split(strSplit)));
        agent_ph12 = new ArrayList(Arrays.asList(bexToAdvanceVO.getAgent_ph12().split(strSplit)));
        agent_ph13 = new ArrayList(Arrays.asList(bexToAdvanceVO.getAgent_ph13().split(strSplit)));
        agent_reg_code = new ArrayList(Arrays.asList(bexToAdvanceVO.getAgent_reg_code().split(strSplit)));
        
        for (int i = 0; i < agent_level.size(); i++){
            String strSeq = String.valueOf(i+1);
            sendParam.add(new BasicNameValuePair("agent"+strSeq+"_level", (String) agent_level.get(i)));
        }
        for (int i = 0; i < agent_app_date.size(); i++){
            String strSeq = String.valueOf(i+1);
            sendParam.add(new BasicNameValuePair("agent"+strSeq+"_app_date", (String) agent_app_date.get(i)));
        }
        for (int i = 0; i < agent_name.size(); i++){
            String strSeq = String.valueOf(i+1);
            sendParam.add(new BasicNameValuePair("agent"+strSeq+"_name", (String) agent_name.get(i)));
        }
        for (int i = 0; i < agent_ssn.size(); i++){
            String strSeq = String.valueOf(i+1);
            sendParam.add(new BasicNameValuePair("agent"+strSeq+"_ssn", (String) agent_ssn.get(i)));
        }
        for (int i = 0; i < agent_ph11.size(); i++){
            String strSeq = String.valueOf(i+1);
            sendParam.add(new BasicNameValuePair("agent"+strSeq+"_ph11", (String) agent_ph11.get(i)));
        }
        for (int i = 0; i < agent_ph12.size(); i++){
            String strSeq = String.valueOf(i+1);
            sendParam.add(new BasicNameValuePair("agent"+strSeq+"_ph12", (String) agent_ph12.get(i)));
        }
        for (int i = 0; i < agent_ph13.size(); i++){
            String strSeq = String.valueOf(i+1);
            sendParam.add(new BasicNameValuePair("agent"+strSeq+"_ph13", (String) agent_ph13.get(i)));
        }
        for (int i = 0; i < agent_reg_code.size(); i++){
            String strSeq = String.valueOf(i+1);
            sendParam.add(new BasicNameValuePair("agent"+strSeq+"_reg_code", (String) agent_reg_code.get(i)));
        }
        
        logger.debug("requestHttpPost parameter");
        for(NameValuePair dummy: sendParam){
            logger.debug(dummy.getName()+":["+dummy.getValue()+"]");
        }
        CommonHttpClient commonHttpClient = new CommonHttpClient();
        logger.debug("Call BexToActCashService requestHttpPost");
        resultPost = commonHttpClient.requestHttpPost(bexToAdvanceVO.getDs_url(),sendParam,"euc-kr");        
        logger.debug("POST Result : "+ resultPost);
        String removeString = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        resultPost = resultPost.trim();
        resultPost = resultPost.replaceAll(removeString, "");
        resultPost = resultPost.replaceAll("\"", "");        
        resultPost = resultPost.replaceAll("\\p{Z}", "");
        resultPost = resultPost.replaceAll("\n", "");
        resultPost = resultPost.replaceAll("\t", "");
        resultPost = resultPost.replaceAll("\\n", "");
        resultPost = resultPost.replaceAll("\\t", "");
        resultPost = resultPost.replaceAll("\r", "");
        resultPost = resultPost.replaceAll("\\r", "");
        resultPost = resultPost.replaceAll("\r\n", "");
        resultPost = resultPost.replaceAll("\\r\\n", "");
        resultPost = resultPost.replaceAll(System.getProperty("line.separator"), "");
        logger.debug("resultPost replace:"+resultPost);        
        
        if(resultPost.matches(".*status00.*")){
            nmScreen = "정상접수";
        }else if(resultPost.matches(".*status91.*")){
            nmScreen = "계약이끝난상품";
        }else if(resultPost.matches(".*status92.*")){
            nmScreen = "계약이끝난제휴사";
        }else if(resultPost.matches(".*status93.*")){
            nmScreen = "보증인입력실패";
        }else if(resultPost.matches(".*status94.*")){
            nmScreen = "회원중복신청";
        }else if(resultPost.matches(".*status95.*")){
            nmScreen = "지인정보입력실패";
        }else if(resultPost.matches(".*status96.*")){
            nmScreen = "이미지저장실패";
        }else if(resultPost.matches(".*status97.*")){
            nmScreen = "메모입력실패";
        }else if(resultPost.matches(".*status98.*")){
            nmScreen = "CFS조회실패";
        }else if(resultPost.matches(".*status99.*")){
            nmScreen = "회원정보입력실패";
        }else if(resultPost.matches(".*status88.*")){
            nmScreen = "알수없는오류";
        }else{
            nmScreen = "처리상태확인불가";
        }

        resultMemo = resultPost.substring(resultPost.length()-20);
        resultMemo = commonUtil.getHangul(resultMemo);
        bexMasterRequestVO.setNmScreen(nmScreen);
        bexMasterService.updateBexMaster(bexMasterRequestVO);
        bexMasterRequestVO.setNmScreen(nmScreen);
        bexMasterRequestVO.setDsCooperate(resultMemo);
        bexMasterService.insertBexContact(bexMasterRequestVO); 
        
        return resultCode;
    }
    
}
