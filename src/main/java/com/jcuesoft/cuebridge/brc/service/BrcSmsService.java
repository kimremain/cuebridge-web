package com.jcuesoft.cuebridge.brc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcSmsDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcContactRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSmsRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSmsResponseVO;
import com.jcuesoft.cuebridge.common.module.CommonUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;

@Service
public class BrcSmsService  extends BaseService {
    
    @Autowired
    private BrcContactService brcContactService;    
    /**
     * BrcContactDAO
     */
    @Autowired
    private BrcSmsDAO BrcSmsDAO;

    /**
     * SMS 발송문장 리스트
     * 
     * @param BrcSmsRequestVO
     * @return
     * @throws Exception
     */ 
    public List<BrcSmsResponseVO> getSmsMessage(BrcSmsRequestVO brcSmsRequestVO) throws Exception {
        return BrcSmsDAO.getSmsMessage(brcSmsRequestVO);
    }
    
    /**
     * SMS 발송문장 
     * 
     * @param BrcSmsRequestVO
     * @return
     * @throws Exception
     */ 
    public BrcSmsResponseVO getSmsMessageOne(BrcSmsRequestVO brcSmsRequestVO) throws Exception {
        return BrcSmsDAO.getSmsMessageOne(brcSmsRequestVO);
    }
    
    
    /**
     * SMS 발송번호 
     * 
     * @param BrcSmsRequestVO
     * @return
     * @throws Exception
     */ 
    public List<BrcSmsResponseVO> getSendNumber(BrcSmsRequestVO brcSmsRequestVO) throws Exception {
        return BrcSmsDAO.getSendNumber(brcSmsRequestVO);
    }
    
    public void sendSms(BrcSmsRequestVO brcSmsRequestVO, BrcContactRequestVO brcContactRequestVO) throws Exception{
        
        String seq = "";
        
        logger.debug("brcSmsRequestVO.getSndMsg().getBytes() utf:"+brcSmsRequestVO.getSndMsg().getBytes("utf-8").length);
        logger.debug("brcSmsRequestVO.getSndMsg().getBytes() euc:"+brcSmsRequestVO.getSndMsg().getBytes("euc-kr").length);
        logger.debug("brcSmsRequestVO.getSndMsg().getBytes() KSC:"+brcSmsRequestVO.getSndMsg().getBytes("ksc5601").length);
        logger.debug("brcSmsRequestVO.getSndMsg().getBytes() ISO:"+brcSmsRequestVO.getSndMsg().getBytes("iso-8859-1").length);
        
        if(CommonUtil.checkMmsMessage(brcSmsRequestVO.getSndMsg()) == true){
            logger.debug("mms");
            seq = getMmsSeq();
            brcSmsRequestVO.setSeq(seq);
            brcContactRequestVO.setCdEtc1("LG_MMS");
            BrcSmsDAO.insertMms(brcSmsRequestVO);
        }else{
            logger.debug("sms");
            seq = getSmsSeq();
            brcSmsRequestVO.setSeq(seq);
            brcContactRequestVO.setCdEtc1("LG_SMS");
            BrcSmsDAO.insertSms(brcSmsRequestVO);            
        }
     
        
        // 발송이력저장 
        brcContactRequestVO.setDsMemo(brcSmsRequestVO.getSndMsg());
        brcContactRequestVO.setNoContactModel(seq);// SMS 시퀀스 
        brcContactService.insertContact(brcContactRequestVO);
        // 최종 접촉이력 갱신
        brcContactService.updateContactDate(brcSmsRequestVO.getNoReq());        
        
    }
   
   private String getSmsSeq() throws Exception {
       return BrcSmsDAO.getSmsSeq();
    }

   private String getMmsSeq() throws Exception {
       return BrcSmsDAO.getMmsSeq();
    }

/**
    * 법인별 SMS수신용 데이터set
    * 
    * @return BrcSmsResponseVO
    * @throws Exception
    */ 
 
  public BrcSmsResponseVO getMmsInfo() throws Exception {
      return BrcSmsDAO.getMmsInfo();
  }  
    
}