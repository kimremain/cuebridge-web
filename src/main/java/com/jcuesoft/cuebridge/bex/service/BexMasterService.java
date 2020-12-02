package com.jcuesoft.cuebridge.bex.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.bex.dao.BexMasterDAO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterResponseVO;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;

@Service
public class BexMasterService  extends BaseService {
    /**
     * BexMasterDAO
     */
    @Autowired
    private BexMasterDAO bexMasterDAO;

    @Autowired
    private CommonBizService commonBizService;    
    
    @Autowired
    private BexToUpsService bexToUpsService; 
    
    @Autowired
    private BexToActCashService bexToActCashService;    
    
    @Autowired
    private BexToTaekangService bexToTaekangService;
    
    @Autowired
    private BexToBridgeService bexToBridgeService;
    
    @Autowired
    private BexToAdvanceService bexToAdvanceService;
    
    @Autowired
    private BexToA1Service bexToA1Service;
    
    @Autowired
    private BexToManualService bexToManualService;    
    
    @Autowired
    private BexToSanwaService bexToSanwaService;

    /**
     * getExListAll
     * 
     * @param brcMasterRequestVO
     * @return
     * @throws Exception
     */
    public List<BexMasterResponseVO> getExListAll(BexMasterRequestVO brcMasterRequestVO) throws Exception {
        
        if(brcMasterRequestVO.getSearchDmRegStart() == null && brcMasterRequestVO.getSearchDmRegEnd() == null )
        {
            Date today = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            brcMasterRequestVO.setSearchDmRegStart(simpleDateFormat.format(today));
            brcMasterRequestVO.setSearchDmRegEnd(simpleDateFormat.format(today));
        }

        return bexMasterDAO.getExListAll(brcMasterRequestVO);
    }

    public int insertBexMaster(BexMasterRequestVO bexMasterRequestVO) throws Exception {
        logger.debug("Call BexMasterService insertBexMaster...");
        return bexMasterDAO.insertBexMaster(bexMasterRequestVO);
    }

    public int insertBexContact(BexMasterRequestVO bexMasterRequestVO) throws Exception {
        logger.debug("Call BexMasterService insertBexContact...");
        return bexMasterDAO.insertBexContact(bexMasterRequestVO);
    }
    
    public int insertBexMaster(BexMasterRequestVO bexMasterRequestVO, EntityManager em) throws Exception {
        logger.debug("Call BexMasterService insertBexMaster...");
        return bexMasterDAO.insertBexMaster(bexMasterRequestVO, em);
    }

    public int insertBexContact(BexMasterRequestVO bexMasterRequestVO, EntityManager em) throws Exception {
        logger.debug("Call BexMasterService insertBexContact...");
        return bexMasterDAO.insertBexContact(bexMasterRequestVO, em);
    }    
    
    public int updateBexMaster(BexMasterRequestVO bexMasterRequestVO) throws Exception {
        logger.debug("Call BexMasterService updateBexMaster...");
        return bexMasterDAO.updateBexMaster(bexMasterRequestVO);
    }    
    
    public String insertBex(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        String resultCode = ""; //resultCode        
        resultCode = "Success";               
        // cdCooperate 실행거래처코드
        
        // YSM계열사의 경우 직접 DB처리
        if(bexMasterRequestVO.getCdCooperate().equals("70301")
                ||bexMasterRequestVO.getCdCooperate().equals("70302")
                ||bexMasterRequestVO.getCdCooperate().equals("70303")
                ||bexMasterRequestVO.getCdCooperate().equals("70314")){
            logger.debug("Call bexToUpsService excute");
            resultCode = bexToUpsService.excute(bexMasterRequestVO);
        }// 액트캐쉬
        else if(bexMasterRequestVO.getCdCooperate().equals("70304")){
            logger.debug("Call bexToActCashService excute");
            resultCode = bexToActCashService.excute(bexMasterRequestVO);
        }// 태강대부
        else if(bexMasterRequestVO.getCdCooperate().equals("70305")){
            logger.debug("Call bexToTaekangService excute");
            resultCode = bexToTaekangService.excute(bexMasterRequestVO);
        }// YSM브리지
        else if(bexMasterRequestVO.getCdCooperate().equals("70306")
                ||bexMasterRequestVO.getCdCooperate().equals("70307")
                ||bexMasterRequestVO.getCdCooperate().equals("70308")){
            logger.debug("Call bexToTaekangService excute");
            resultCode = bexToBridgeService.excute(bexMasterRequestVO);
        }// 어드밴스대부
        else if(bexMasterRequestVO.getCdCooperate().equals("70310")){
            logger.debug("Call bexToAdvanceService excute");
            resultCode = bexToAdvanceService.excute(bexMasterRequestVO);
        }// 에이원대부
        else if(bexMasterRequestVO.getCdCooperate().equals("70311")){
            logger.debug("Call bexToA1Service excute");
            resultCode = bexToA1Service.excute(bexMasterRequestVO);
        }// 산와머니
        else if(bexMasterRequestVO.getCdCooperate().equals("70313")){
            logger.debug("Call bexToSeoulLoService excute");
            resultCode = bexToSanwaService.excute(bexMasterRequestVO);
        }// 전산시스템 비연동 거래처 (종로캐피탈, 서울캐피탈, 동남캐피탈)
        else if(bexMasterRequestVO.getCdCooperate().equals("70309") 
                || bexMasterRequestVO.getCdCooperate().equals("70312") 
                || bexMasterRequestVO.getCdCooperate().equals("70315")){
            logger.debug("Call bexToManualService excute");
            resultCode = bexToManualService.excute(bexMasterRequestVO);
        }
        else{
            resultCode = "Fail:처리불가 거래처";
        }
        
        return resultCode;        
    }

    public List<BexMasterResponseVO> getBexMasterList(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexMasterService getBexMasterList...");
        return bexMasterDAO.getBexMasterList(bexMasterRequestVO);
    }

    public BexMasterResponseVO getBexMasterOne(BexMasterRequestVO bexMasterRequestVO) {
        logger.debug("Call BexMasterService getBexMasterOne...");
        return bexMasterDAO.getBexMasterOne(bexMasterRequestVO);
    }

}