package com.jcuesoft.cuebridge.brc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcLoanInfoDAO;
import com.jcuesoft.cuebridge.brc.dao.BrcSuretyDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcSuretyInfoResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSuretyRequestVO;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;

@Service
public class BrcSuretyService extends BaseService {
    @Autowired
    private BrcSuretyDAO brcSuretyDAO;
    
    @Autowired
    private BrcLoanInfoDAO brcLoanInfoDAO;    
    
    @Autowired
    private CommonBizService commonBizService;    
    
    public List<BrcSuretyInfoResponseVO> getBrcSuretyList(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception {
        logger.debug("Call BrcSuretyService getBrcSuretyList...");
        return brcSuretyDAO.getBrcSuretyList(brcSuretyRequestVO);
    }       
    
    public int insertBrcSurety(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        logger.debug("Call BrcSuretyService insertBrcSurety...");
        brcSuretyRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        return brcSuretyDAO.insertBrcSurety(brcSuretyRequestVO);
    }
    
    public int updateBrcSurety(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        logger.debug("Call BrcSuretyService updateBrcSurety...");
        brcSuretyRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        return brcSuretyDAO.updateBrcSurety(brcSuretyRequestVO);
    }
    
    public int deleteBrcSurety(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        logger.debug("Call BrcSuretyService deleteBrcSurety...");
        return brcSuretyDAO.deleteBrcSurety(brcSuretyRequestVO);
    }

    public BrcSuretyInfoResponseVO getBrcSuretyInfo(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception {
        logger.debug("Call BrcSuretyService getBrcSuretyInfo...");
        return brcSuretyDAO.getBrcSuretyInfo(brcSuretyRequestVO);
    }

    public String insertBrcSuretyInfo(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        logger.debug("Call BrcSuretyService insertBrcSuretyInfo...");
        brcSuretyRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        
        String resultCode = ""; //resultCode
        logger.debug(brcSuretyRequestVO.getNoReq());
        String brcSuretyNoSurety = commonBizService.getBrcSuretyNoSurety(brcSuretyRequestVO.getNoReq()); //보증인일련번호조회
        logger.debug(brcSuretyNoSurety);
        brcSuretyRequestVO.setNoSurety(brcSuretyNoSurety);
                
        /*StringBuffer dsEmail = new StringBuffer();        
        dsEmail.append(brcSuretyRequestVO.getDsEmail1());
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        logger.info(dsEmail.toString());
        dsEmail.append(brcSuretyRequestVO.getDsEmail2());
        logger.info(dsEmail.toString());
        brcSuretyRequestVO.setDsEmail(dsEmail.toString());
        
        //통화약속일시        
        if(brcSuretyRequestVO.getDmPromiseYMD().length() ==10 && brcSuretyRequestVO.getDmPromiseHH().length() ==2 && brcSuretyRequestVO.getDmPromiseMI().length() ==2)
        {
            StringBuffer dmPromise = new StringBuffer();
            dmPromise.append(brcSuretyRequestVO.getDmPromiseYMD());   
            dmPromise.append(brcSuretyRequestVO.getDmPromiseHH());
            dmPromise.append(brcSuretyRequestVO.getDmPromiseMI());
            brcSuretyRequestVO.setDmPromise(dmPromise.toString());       
        }     */   
        
        brcSuretyDAO.insertBrcSurety(brcSuretyRequestVO);
        brcSuretyDAO.insertBrcSuretyCompany(brcSuretyRequestVO);
        brcSuretyDAO.insertBrcSuretyHome(brcSuretyRequestVO);
        brcSuretyDAO.updateBrcLoanYnSurety(brcSuretyRequestVO.getNoReq());
        // 20150107 추가 by 김성준
        brcSuretyDAO.insertBrcSuretyHash(brcSuretyRequestVO);
        
        resultCode = "Success";
        return resultCode;
    }    
    
    public String updateBrcSuretyInfo(BrcSuretyRequestVO brcSuretyRequestVO)throws Exception{
        logger.debug("Call BrcSuretyService updateBrcSuretyInfo...");       
        brcSuretyRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        String resultCode = ""; //resultCode        
        /*StringBuffer dsEmail = new StringBuffer();
        
        dsEmail.append(brcSuretyRequestVO.getDsEmail1());
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        logger.info(dsEmail.toString());
        dsEmail.append(brcSuretyRequestVO.getDsEmail2());
        logger.info(dsEmail.toString());
        brcSuretyRequestVO.setDsEmail(dsEmail.toString());        
        
        //통화약속일시        
        if(brcSuretyRequestVO.getDmPromiseYMD().length() ==10 && brcSuretyRequestVO.getDmPromiseHH().length() ==2 && brcSuretyRequestVO.getDmPromiseMI().length() ==2)
        {
            StringBuffer dmPromise = new StringBuffer();
            dmPromise.append(brcSuretyRequestVO.getDmPromiseYMD());   
            dmPromise.append(brcSuretyRequestVO.getDmPromiseHH());
            dmPromise.append(brcSuretyRequestVO.getDmPromiseMI());
            brcSuretyRequestVO.setDmPromise(dmPromise.toString());       
        } */       
                          
        brcSuretyDAO.updateBrcSurety(brcSuretyRequestVO);              
        brcSuretyDAO.updateBrcSuretyCompany(brcSuretyRequestVO);
        brcSuretyDAO.updateBrcSuretyHash(brcSuretyRequestVO);   
        
        resultCode = "Success";
        return resultCode;
    }

}
