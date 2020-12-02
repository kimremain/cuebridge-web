package com.jcuesoft.cuebridge.bex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.bex.dao.BexToUpsDAO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToUpsVO;
import com.jcuesoft.cuebridge.brc.vo.BrcFileResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSuretyResponseVO;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;
import com.jcuesoft.cuebridge.common.vo.CommonBizSafekeyOfferVO;

@Service
public class BexToUpsService extends BaseService{
    
    @Autowired 
    private BexToUpsDAO bexToUpsDAO;
    
    @Autowired
    private CommonBizService commonBizService;
    
    @Autowired
    private BexMasterService bexMasterService;    
    
    String excute(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        String resultCode = ""; //resultCode        
        resultCode = "Success";
        logger.debug("Call BexToUpsService excute");
        BexToUpsVO bexToUpsVO = new BexToUpsVO();
        bexToUpsVO.setDataImgNasComNm(commonUtil.getdataImgNasComNm(bexMasterRequestVO.getCdCooperate()));
        bexToUpsVO.setUpsDbLink(commonUtil.getUpsDbLink(bexMasterRequestVO.getCdCooperate()));
        //bexToUpsVO.setHsjDbLink(commonUtil.getHsjDbLink(bexMasterRequestVO.getCdCooperate()));
        bexToUpsVO.setErpDbLink(commonUtil.getErpDbLink(bexMasterRequestVO.getCdCooperate()));
        bexToUpsVO.setUnixTime(commonUtil.getUnixTime());
        bexToUpsVO.setNoReq(bexMasterRequestVO.getNoReq());        
        bexToUpsVO.setIdPdtUid(getStPdtIdPdtUid(bexToUpsVO));       //임시세팅:운영시 상품정보의 컬럼참조
        logger.debug("Call BexToUpsService excuteYSM setIdPdtUid:"+bexToUpsVO.getIdPdtUid());
        
        /*차주 보증인 세이프키연계기관,연계키 */
        CommonBizSafekeyOfferVO commonBizSafekeyOfferVO = new CommonBizSafekeyOfferVO();
        commonBizSafekeyOfferVO = commonBizService.getSafekeyOffer(bexMasterRequestVO.getNoReq());
        bexToUpsVO.setSafeKeyOperCode(commonBizSafekeyOfferVO.getCd_nice_safekey_ext());
        bexToUpsVO.setSafeKeyReqseq(commonBizSafekeyOfferVO.getDs_nice_safekey_ext());

        // 실행마스터 채번
        bexToUpsVO.setNoEx(commonBizService.getBexMasterNoEx(bexMasterRequestVO.getNoReq()));        
        logger.debug("Call BexToUpsService #1"); 
        bexMasterRequestVO.setNoEx(bexToUpsVO.getNoEx());
        
        // 기고객여부 판단
        String erpMemberListNo = selectErpMemberListNo(bexToUpsVO);
        logger.debug("Call BexMasterService excuteYSM erpMemberListNo:"+erpMemberListNo); 
        // 20170113 수정 by 김성준 : 유아이일 경우 ADD실행 X
        // 20170228 수정 by 김성준 : 모든 법인  ADD실행 X
        logger.debug("Call BexToUpsService UPS BIZ #1");
        bexToUpsVO.setStatus("A");
        bexToUpsVO.setRejectCode("");
        bexMasterRequestVO.setNmScreenPath("UPS");
        
        // 실행마스터 생성
        logger.debug("Call BexToUpsService excuteYSM #2");
        bexMasterService.insertBexMaster(bexMasterRequestVO);
        // 실행접촉이력 생성
        logger.debug("Call BexToUpsService excuteYSM #2");
        bexMasterService.insertBexContact(bexMasterRequestVO);     
        
/*        if(erpMemberListNo.equals("0") || bexMasterRequestVO.getCdCooperate().equals("70301")){
            logger.debug("Call BexToUpsService UPS BIZ #1");
            bexToUpsVO.setStatus("A");
            bexToUpsVO.setRejectCode("");
            bexMasterRequestVO.setNmScreenPath("UPS");
            
            // 실행마스터 생성
            logger.debug("Call BexToUpsService excuteYSM #2");
            bexMasterService.insertBexMaster(bexMasterRequestVO);
            // 실행접촉이력 생성
            logger.debug("Call BexToUpsService excuteYSM #2");
            bexMasterService.insertBexContact(bexMasterRequestVO);            
        }else{
            logger.debug("Call BexToUpsService excuteYSM BIZ #1");
            bexToUpsVO.setStatus("X");
            bexToUpsVO.setRejectCode("13252");
            bexMasterRequestVO.setNmScreenPath("ADD");
            
            // 실행마스터 생성
            logger.debug("Call BexToUpsService excuteYSM #2");
            bexMasterService.insertBexMaster(bexMasterRequestVO);
            // 실행접촉이력 생성
            logger.debug("Call BexToUpsService excuteYSM #2");
            bexMasterRequestVO.setNmScreen("접수");
            bexMasterRequestVO.setDsCooperate("최초실행");
            bexMasterService.insertBexContact(bexMasterRequestVO);            
            // ADDLOAN 생성
            bexToUpsVO.setErpMemberListNo(erpMemberListNo);
            bexToUpsVO.setAddloanNoSeq(bexToUpsDAO.getAddloanNoSeq(bexToUpsVO));

            insertAddloan(bexToUpsVO);
        } */       
        
        // UPS KEY 채번
        logger.debug("Call BexToUpsService insertBex #3");   
        bexToUpsVO.setMemberListNo(bexToUpsDAO.getMemberListNoSeq(bexToUpsVO));
        // MEMBER_LIST 생성
        logger.debug("Call BexToUpsService insertBex #4"); 
        insertMemberList(bexToUpsVO);
        // MEMBER_LIST_EXTRA 생성
        logger.debug("Call BexToUpsService insertBex #5"); 
        insertMemberListExtra(bexToUpsVO);
        
        logger.debug("Call BexToUpsService insertBex #6"); 
        List<BrcSuretyResponseVO> brcSuretyResponseVO = bexToUpsDAO.getSuretyList(bexToUpsVO);
        logger.debug("Call BexToUpsService insertBex #7"); 
        for(BrcSuretyResponseVO dummy :  brcSuretyResponseVO){
            logger.debug("Call BexToUpsService insertBex #7-1"); 
            bexToUpsVO.setNoSurety(dummy.getNoSurety());
            // GUARANTOR 채번
            logger.debug("Call BexToUpsService insertBex #7-2"); 
            bexToUpsVO.setGuarantorNo(bexToUpsDAO.getGuarantorNoSeq(bexToUpsVO));       
            // GUARANTOR 생성
            logger.debug("Call BexToUpsService insertBex #7-3"); 
            insertGuarantor(bexToUpsVO);
            // GUARANTOR_EXTRA 생성
            logger.debug("Call BexToUpsService insertBex #7-4"); 
            insertGuarantorExtra(bexToUpsVO);            
        }
        // COMMUNICATION_XX 생성
        logger.debug("Call BexToUpsService insertBex #8"); 
        bexToUpsVO.setCommunicationNm(commonUtil.getCommunicationNm(bexToUpsVO.getMemberListNo()));
        insertCommunication(bexToUpsVO);
        // LOAN_CERTIFY 생성
        logger.debug("Call BexToUpsService insertBex #9"); 
        insertLoanCertify(bexToUpsVO);
        
        // AGENT_LEVEL 생성
        logger.debug("Call BexToUpsService insertBex #12");
        bexToUpsVO.setAgentLevelNo(bexToUpsDAO.getAgentLevelNoSeq(bexToUpsVO));
        bexToUpsVO.setAddloanNoSeq(bexToUpsDAO.getAddloanNoSeq(bexToUpsVO));
        insertAgentLevel(bexToUpsVO);
        
        // DATA_IMG 생성
        logger.debug("Call BexToUpsService insertBex #10");
        String nasRootPath = commonUtil.getdataImgNasRootPath(bexMasterRequestVO.getCdCooperate());
        List<BrcFileResponseVO> brcFileResponseVO = bexToUpsDAO.getBrcFileList(bexToUpsVO);
        for(BrcFileResponseVO dummy : brcFileResponseVO){
            logger.debug("Call BexToUpsService insertBex #10-1");
            bexToUpsVO.setBrcFileNo(dummy.getNo());
            logger.debug("Call BexToUpsService insertBex #10-2");
            bexToUpsVO.setDataImgNo(bexToUpsDAO.getDataImgNoSeq(bexToUpsVO));
            logger.debug("Call BexToUpsService insertBex #10-3");
            bexToUpsVO.setDataImgFileName(bexToUpsVO.getDataImgNasComNm()+"_"
                                                        +bexToUpsVO.getMemberListNo()+"_"
                                                        +dummy.getDmRegChar()+"_"
                                                        +bexToUpsVO.getDataImgNo());
            logger.debug("Call BexToUpsService insertBex #10-4");
            bexToUpsVO.setDataImgPath(nasRootPath+"/"
                                                    +dummy.getDmRegChar().substring(0, 4)+"/"
                                                    +dummy.getDmRegChar().substring(0, 8)+"/");
            logger.debug("Call BexToUpsService insertBex #10-5");
            bexToUpsDAO.insertDataImg(bexToUpsVO);
            logger.debug("Call BexToUpsService insertBex #10-6");
            
            commonUtil.copyFile(dummy.getDsPath()+dummy.getNmFile(),
                    bexToUpsVO.getDataImgPath()+bexToUpsVO.getDataImgFileName());
        }
        
        // MEMBER_LIST_INOUT_TM 생성
        logger.debug("Call BexToUpsService insertBex #11");
        resultCode = commonBizService.procUpsMeberListInoutTm(bexMasterRequestVO.getNoReq(), "Y", bexMasterRequestVO.getCdCooperate(), bexToUpsVO.getMemberListNo());

        return resultCode;
    }
    
    int insertMemberList(BexToUpsVO bexToUpsVO ) throws Exception {
        logger.debug("Call BexMasterService insertMemberList...");
        return bexToUpsDAO.insertMemberList(bexToUpsVO);
    }    
    
    int insertMemberListExtra(BexToUpsVO bexToUpsVO ) throws Exception {
        logger.debug("Call BexMasterService insertMemberListExtra...");
        return bexToUpsDAO.insertMemberListExtra(bexToUpsVO);
    }    
    
    int insertGuarantor(BexToUpsVO bexToUpsVO ) throws Exception {
        logger.debug("Call BexMasterService insertGuarantor...");
        return bexToUpsDAO.insertGuarantor(bexToUpsVO);
    }
    
    int insertGuarantorExtra(BexToUpsVO bexToUpsVO ) throws Exception {
        logger.debug("Call BexMasterService insertMemberListExtra...");
        return bexToUpsDAO.insertGuarantorExtra(bexToUpsVO);
    }   
    
    int insertCommunication(BexToUpsVO bexToUpsVO ) throws Exception {
        logger.debug("Call BexMasterService insertCommunication...");
        return bexToUpsDAO.insertCommunication(bexToUpsVO);
    }    
    
    int insertLoanCertify(BexToUpsVO bexToUpsVO ) throws Exception {
        logger.debug("Call BexMasterService insertLoanCertify...");
        return bexToUpsDAO.insertLoanCertify(bexToUpsVO);
    }  
    
    int insertDataImg(BexToUpsVO bexToUpsVO ) throws Exception {
        logger.debug("Call BexMasterService insertDataImg...");
        return bexToUpsDAO.insertDataImg(bexToUpsVO);
    }
    
    int insertAddloan(BexToUpsVO bexToUpsVO) throws Exception  {
        logger.debug("Call BexMasterService insertAddloan...");
        return bexToUpsDAO.insertAddloan(bexToUpsVO);
    }    
    
    int insertAgentLevel(BexToUpsVO bexToUpsVO) throws Exception  {
        logger.debug("Call BexMasterService insertAgentLevel...");
        return bexToUpsDAO.insertAgentLevel(bexToUpsVO);
    }
    
    String selectErpMemberListNo(BexToUpsVO bexToUpsVO) throws Exception  {
        logger.debug("Call BexMasterService selectErpMemberlistNo...");
        return bexToUpsDAO.selectErpMemberListNo(bexToUpsVO);
    }    
    
    String getStPdtIdPdtUid(BexToUpsVO bexToUpsVO) throws Exception {
        logger.debug("Call BexMasterService getStPdtIdPdtUid...");
        return bexToUpsDAO.getStPdtIdPdtUid(bexToUpsVO);
    }     

}
