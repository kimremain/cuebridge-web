package com.jcuesoft.cuebridge.brc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcContactDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcContactRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcContactResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSearchRequestVO;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.vo.LincusCommunicationVO;

@Service
public class BrcContactService  extends BaseService {
    /**
     * BrcContactDAO
     */
    @Autowired
    private BrcContactDAO BrcContactDAO;

    /**
     * 접촉이력 (통화,SMS,EAMIL)
     * 
     * @param BrcContactRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcContactResponseVO> getContactList(BrcContactRequestVO brcContactRequestVO) throws Exception {
        return BrcContactDAO.getContactList(brcContactRequestVO);
    }
    
    /**
     * SMS 접촉이력 
     * 
     * @param BrcContactRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcContactResponseVO> getContactSmsList(BrcContactRequestVO brcContactRequestVO) throws Exception {
        return BrcContactDAO.getContactSmsList(brcContactRequestVO);
    }
    
    /**
     * 리스트 내  접수메모 
     * 
     * @param BrcContactRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcContactResponseVO> getContactReqList(BrcContactRequestVO brcContactRequestVO) throws Exception {
        brcContactRequestVO.setCdContact("71201"); // 접수메모만 사용
        return BrcContactDAO.getContactReqList(brcContactRequestVO);
    }
    
    
    /**
     * getBrcContactOne
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public BrcContactResponseVO getBrcContactOne(BrcContactRequestVO brcContactRequestVO) throws Exception {
        return BrcContactDAO.getContactOne(brcContactRequestVO);
    }
    
    
    /**
     * insertLincusCommunication
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public int insertLincusCommunication(LincusCommunicationVO lincusCommunicationVO,BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        
        String memberListNo  =  lincusCommunicationVO.getMemberListNo();
        String dbFlag            = brcSearchRequestVO.getSearchLincusOpt();
        if(memberListNo == null || dbFlag == null){
            throw new Exception("메모 입력에 필수값이 없습니다.");
        }
        String tableNumber = memberListNo.substring(memberListNo.length()-2);
        lincusCommunicationVO.setTableNumber(tableNumber); 
        
        String dbLink = dbFlag.substring(0,3);
        if(dbLink.equals("UPS") || dbLink.equals("ERP")){
            lincusCommunicationVO.setDbLink(dbLink); 
        }else{
           throw new Exception("DB 선택값이 없습니다.");
        }
        
        logger.debug("tableNumber:"+tableNumber);
        logger.debug("dbLink:"+dbLink);
        return BrcContactDAO.insertLincusCommunication(lincusCommunicationVO);
    }
    
    /**
     * insertContact
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public int insertContact(BrcContactRequestVO brcContactRequestVO) throws Exception {
        brcContactRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        return BrcContactDAO.insertContact(brcContactRequestVO);
    }
    
    /**
     * updateContactDate
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public int updateContactDate(String noReq) throws Exception {
      
        return BrcContactDAO.updateContactDate(noReq);
    }

    /**
     * update
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public int updateContact(BrcContactRequestVO brcContactRequestVO) throws Exception {
        brcContactRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        return BrcContactDAO.updateContact(brcContactRequestVO);
    }

    /**
     * delete
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public int deleteContact(BrcContactRequestVO brcContactRequestVO) throws Exception {
        return BrcContactDAO.deleteContact(brcContactRequestVO);
    }

    public List<BrcContactResponseVO> getContactListForTooltip(BrcContactRequestVO brcContactRequestVO) {
        return BrcContactDAO.getContactListForTooltip(brcContactRequestVO);
    }

}