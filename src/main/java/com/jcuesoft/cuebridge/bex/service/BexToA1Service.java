package com.jcuesoft.cuebridge.bex.service;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.bex.dao.BexToA1DAO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToA1VO;
import com.jcuesoft.cuebridge.common.module.CommonHttpClient;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;
@Service
public class BexToA1Service extends BaseService {
    
    @Autowired
    private CommonBizService commonBizService;    
    @Autowired
    private BexMasterService bexMasterService;
    @Autowired
    private BexToA1DAO bexToA1DAO;    
    
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
        
        logger.debug("Call BexToA1Service excute getBexMasterNoEx");
        bexMasterRequestVO.setNoEx(commonBizService.getBexMasterNoEx(bexMasterRequestVO.getNoReq()));
        imgUrl = commonBizService.getStCustomerDsImgUrl(bexMasterRequestVO.getCdCooperate());
        logger.debug("Call BexToActCashService getStCustomerDsImgUrl:"+imgUrl);
        logger.debug("Call BexToActCashService excute insertBexMaster");
        bexMasterService.insertBexMaster(bexMasterRequestVO);
        logger.debug("Call BexToActCashService excute insertBexContact");
        bexMasterRequestVO.setNmScreen("접수");
        bexMasterRequestVO.setDsCooperate("최초실행");        
        bexMasterService.insertBexContact(bexMasterRequestVO);
        
        BexToA1VO bexToA1VO = new BexToA1VO();
        bexToA1VO = bexToA1DAO.getBexToA1(bexMasterRequestVO);
        
        List <NameValuePair> sendParam = new ArrayList <NameValuePair>();
        sendParam.add(new BasicNameValuePair("pro_code", bexToA1VO.getPro_code()));
        sendParam.add(new BasicNameValuePair("com_code", bexToA1VO.getCom_code()));
        sendParam.add(new BasicNameValuePair("cooperate_code", bexToA1VO.getCooperate_code()));
                
        sendParam.add(new BasicNameValuePair("info_coll_path", bexToA1VO.getInfo_coll_path()));
        sendParam.add(new BasicNameValuePair("coll_m1", bexToA1VO.getColl_m1()));
        sendParam.add(new BasicNameValuePair("coll_m1_memo99", bexToA1VO.getColl_m1_memo99()));
        sendParam.add(new BasicNameValuePair("coll_a1", bexToA1VO.getColl_a1()));
        sendParam.add(new BasicNameValuePair("coll_a1_memo1", bexToA1VO.getColl_a1_memo1()));
        sendParam.add(new BasicNameValuePair("coll_a1_memo99", bexToA1VO.getColl_a1_memo99()));
        sendParam.add(new BasicNameValuePair("coll_a2", bexToA1VO.getColl_a2()));
        sendParam.add(new BasicNameValuePair("coll_a2_memo99", bexToA1VO.getColl_a2_memo99()));
        sendParam.add(new BasicNameValuePair("coll_date", bexToA1VO.getColl_date()));
        sendParam.add(new BasicNameValuePair("coll_agent_name", bexToA1VO.getColl_agent_name()));
        sendParam.add(new BasicNameValuePair("coll_ceo_name", bexToA1VO.getColl_ceo_name()));
        sendParam.add(new BasicNameValuePair("coll_manager_name", bexToA1VO.getColl_manager_name()));
        
        sendParam.add(new BasicNameValuePair("name", bexToA1VO.getName()));
        sendParam.add(new BasicNameValuePair("ssn11", bexToA1VO.getSsn11()));
        sendParam.add(new BasicNameValuePair("ssn12", bexToA1VO.getSsn12()));
        sendParam.add(new BasicNameValuePair("ph11", bexToA1VO.getPh11()));
        sendParam.add(new BasicNameValuePair("ph12", bexToA1VO.getPh12()));
        sendParam.add(new BasicNameValuePair("ph13", bexToA1VO.getPh13()));
        
        sendParam.add(new BasicNameValuePair("ph21", bexToA1VO.getPh21()));
        sendParam.add(new BasicNameValuePair("ph22", bexToA1VO.getPh22()));
        sendParam.add(new BasicNameValuePair("ph23", bexToA1VO.getPh23()));
        sendParam.add(new BasicNameValuePair("app_money", bexToA1VO.getApp_money()));
        
        sendParam.add(new BasicNameValuePair("job_class", bexToA1VO.getJob_class()));
        
        sendParam.add(new BasicNameValuePair("A_com_name", bexToA1VO.getA_com_name()));
        
        sendParam.add(new BasicNameValuePair("A_ph31", bexToA1VO.getA_ph31()));
        sendParam.add(new BasicNameValuePair("A_ph32", bexToA1VO.getA_ph32()));
        sendParam.add(new BasicNameValuePair("A_ph33", bexToA1VO.getA_ph33()));

        sendParam.add(new BasicNameValuePair("A_com_part", bexToA1VO.getA_com_part()));
        sendParam.add(new BasicNameValuePair("A_worker_term_year", bexToA1VO.getA_worker_term_year()));
        sendParam.add(new BasicNameValuePair("A_worker_term_month", bexToA1VO.getA_worker_term_month()));

        sendParam.add(new BasicNameValuePair("A_pay", bexToA1VO.getA_pay()));
        
        if(bexToA1VO.getImg_url1().trim().length() != 0){
            commonUtil.copyFile(bexToA1VO.getImg_url1(), bexToA1VO.getImg_url1().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("img_url1", bexToA1VO.getImg_url1().replace(extData, imgUrl)));
            sendParam.add(new BasicNameValuePair("img_type1", bexToA1VO.getImg_type1()));
        }
        if(bexToA1VO.getImg_url2().trim().length() != 0){
            commonUtil.copyFile(bexToA1VO.getImg_url2(), bexToA1VO.getImg_url2().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("img_url2", bexToA1VO.getImg_url2().replace(extData, imgUrl)));
            sendParam.add(new BasicNameValuePair("img_type2", bexToA1VO.getImg_type2()));
        }
        if(bexToA1VO.getImg_url3().trim().length() != 0){
            commonUtil.copyFile(bexToA1VO.getImg_url3(), bexToA1VO.getImg_url3().replace(extData, extDataAgency+bexMasterRequestVO.getCdCooperate()+"/"));
            sendParam.add(new BasicNameValuePair("img_url3", bexToA1VO.getImg_url3().replace(extData, imgUrl)));
            sendParam.add(new BasicNameValuePair("img_type3", bexToA1VO.getImg_type3()));
        }

        sendParam.add(new BasicNameValuePair("memo", bexToA1VO.getMemo()));

        sendParam.add(new BasicNameValuePair("G1_name", bexToA1VO.getG1_name()));
        sendParam.add(new BasicNameValuePair("G1_ssn11", bexToA1VO.getG1_ssn11()));
        sendParam.add(new BasicNameValuePair("G1_ssn12", bexToA1VO.getG1_ssn12()));
        
        sendParam.add(new BasicNameValuePair("G1_ph21", bexToA1VO.getG1_ph21()));
        sendParam.add(new BasicNameValuePair("G1_ph22", bexToA1VO.getG1_ph22()));
        sendParam.add(new BasicNameValuePair("G1_ph23", bexToA1VO.getG1_ph23()));

        // 중개경로
        ArrayList agent_level;
        ArrayList agent_app_date;
        ArrayList agent_name;
        ArrayList agent_ssn;
        ArrayList agent_ph11;
        ArrayList agent_ph12;
        ArrayList agent_ph13;
        ArrayList agent_assn;
        String strSplit = ",";
        
        agent_level = new ArrayList(Arrays.asList(bexToA1VO.getAgent_level().split(strSplit)));
        agent_app_date = new ArrayList(Arrays.asList(bexToA1VO.getAgent_app_date().split(strSplit)));
        agent_name = new ArrayList(Arrays.asList(bexToA1VO.getAgent_name().split(strSplit)));
        agent_ssn = new ArrayList(Arrays.asList(bexToA1VO.getAgent_ssn().split(strSplit)));
        agent_ph11 = new ArrayList(Arrays.asList(bexToA1VO.getAgent_ph11().split(strSplit)));
        agent_ph12 = new ArrayList(Arrays.asList(bexToA1VO.getAgent_ph12().split(strSplit)));
        agent_ph13 = new ArrayList(Arrays.asList(bexToA1VO.getAgent_ph13().split(strSplit)));
        agent_assn = new ArrayList(Arrays.asList(bexToA1VO.getAgent_assn().split(strSplit)));
        
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
        for (int i = 0; i < agent_assn.size(); i++){
            String strSeq = String.valueOf(i+1);
            sendParam.add(new BasicNameValuePair("agent"+strSeq+"_assn", (String) agent_assn.get(i)));
        }
        
        logger.debug("requestHttpPost parameter");
        for(NameValuePair dummy: sendParam){
            logger.debug(dummy.getName()+":["+dummy.getValue()+"]");
        }
        CommonHttpClient commonHttpClient = new CommonHttpClient();
        logger.debug("Call BexToActCashService requestHttpPost");
        resultPost = commonHttpClient.requestHttpPost(bexToA1VO.getDs_url(),sendParam,"euc-kr");
        resultPost = URLDecoder.decode(resultPost, "EUC-KR");
        //resultPost = commonHttpClient.requestHttpPost("https://star-lincus.cashway.co.kr",sendParam,"euc-kr");
        
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
        
        if(resultPost.matches(".*status0.*")){
            nmScreen = "정상접수";
        }else if(resultPost.matches(".*status90.*")){
            nmScreen = "제휴사이력제입력실패";
        }else if(resultPost.matches(".*status91.*")){
            nmScreen = "계약이끝난상품";
        }else if(resultPost.matches(".*status92.*")){
            nmScreen = "계약이끝난제휴사";
        }else if(resultPost.matches(".*status95.*")){
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

        
        resultMemo = commonUtil.getHangul(resultPost);
        //resultMemo = resultMemo.substring(resultPost.length()-100);
        bexMasterRequestVO.setNmScreen(nmScreen);
        bexMasterService.updateBexMaster(bexMasterRequestVO);
        bexMasterRequestVO.setNmScreen(nmScreen);
        bexMasterRequestVO.setDsCooperate(resultMemo);
        bexMasterService.insertBexContact(bexMasterRequestVO); 
        
        return resultCode;
    }
    
}
