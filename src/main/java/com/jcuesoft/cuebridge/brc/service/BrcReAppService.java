package com.jcuesoft.cuebridge.brc.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcReAppDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcReAppFileListVO;
import com.jcuesoft.cuebridge.brc.vo.BrcReAppSuretyListVO;
import com.jcuesoft.cuebridge.brc.vo.BrcReAppVO;
import com.jcuesoft.cuebridge.common.module.CommonFileUpload;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;
import com.jcuesoft.cuebridge.common.service.CommonCacheService;
@Service
public class BrcReAppService extends BaseService{
    
    @Autowired
    private BrcReAppDAO brcReAppDAO;
    
    @Autowired
    private CommonBizService commonBizService;
    
    @Autowired
    private CommonCacheService commonCacheService;
    
    @Autowired
    private BrcFileService brcFileService;    

    private BrcReAppVO brcReAppVO;
    
    public int buildBrcLoan(BrcReAppVO brcReAppVO ) throws Exception {
        logger.debug("Call BrcReAppService buildBrcLoan...");
        return brcReAppDAO.buildBrcLoan(brcReAppVO);
    }
    
    public int buildBrcCustom(BrcReAppVO brcReAppVO ) throws Exception {
        logger.debug("Call BrcReAppService buildBrcCustom...");
        return brcReAppDAO.buildBrcCustom(brcReAppVO);
    }
    
    public int buildBrcCustomHome(BrcReAppVO brcReAppVO ) throws Exception {
        logger.debug("Call BrcReAppService buildBrcCustomHome...");
        return brcReAppDAO.buildBrcCustomHome(brcReAppVO);
    }
    
    public int buildBrcCustomCompany(BrcReAppVO brcReAppVO ) throws Exception {
        logger.debug("Call BrcReAppService buildBrcCustomCompany...");
        return brcReAppDAO.buildBrcCustomCompany(brcReAppVO);
    }
    
    public int buildBrcSurety(BrcReAppVO brcReAppVO ) throws Exception {
        logger.debug("Call BrcReAppService buildBrcSurety...");
        return brcReAppDAO.buildBrcSurety(brcReAppVO);
    }
    
    public int buildBrcSuretyHome(BrcReAppVO brcReAppVO ) throws Exception {
        logger.debug("Call BrcReAppService buildBrcSuretyHome...");
        return brcReAppDAO.buildBrcSuretyHome(brcReAppVO);
    }
    
    public int buildBrcSuretyCompany(BrcReAppVO brcReAppVO ) throws Exception {
        logger.debug("Call BrcReAppService buildBrcSuretyCompany...");
        return brcReAppDAO.buildBrcSuretyCompany(brcReAppVO);
    }
    
    public int buildBrcFile(BrcReAppVO brcReAppVO ) throws Exception {
        logger.debug("Call BrcReAppService buildBrcFile...");
        return brcReAppDAO.buildBrcFile(brcReAppVO);
    }
    
    public int buildBrcContact(BrcReAppVO brcReAppVO ) throws Exception {
        logger.debug("Call BrcReAppService buildBrcContact...");
        return brcReAppDAO.buildBrcContact(brcReAppVO);
    }
    
    public int buildBrcCustomHash(BrcReAppVO brcReAppVO ) throws Exception {
        logger.debug("Call BrcReAppService buildBrcCustomHash...");
        return brcReAppDAO.buildBrcCustomHash(brcReAppVO);
    }    
    
    public List<BrcReAppSuretyListVO> getSuretyList(BrcReAppVO brcReAppVO) throws Exception{
        logger.debug("Call BrcReAppService getSuretyList...");
        return brcReAppDAO.getSuretyList(brcReAppVO);
    }
    
    public List<BrcReAppFileListVO> getBrcFileList(BrcReAppVO brcReAppVO) throws Exception{
        logger.debug("Call BrcReAppService getBrcFileList...");
        return brcReAppDAO.getBrcFileList(brcReAppVO);
    }    
    
    public void brcReAppProcedure(String noReqFrom) throws Exception{
        logger.debug("Call BrcReAppProcedure ...");
        
        brcReAppVO = new BrcReAppVO();
        brcReAppVO.setNoReqFrom(noReqFrom);
        brcReAppVO.setNoReqTo(commonBizService.getBrcLoanNoReq());
        brcReAppVO.setIdReg(CommonSessionUtil.getIdUser());
        logger.debug("Call BrcReAppProcedure buildBrcLoan...");
        buildBrcLoan(brcReAppVO);
        logger.debug("Call BrcReAppProcedure buildBrcCustom...");
        buildBrcCustom(brcReAppVO);
        logger.debug("Call BrcReAppProcedure buildBrcCustomHome...");
        buildBrcCustomHome(brcReAppVO);
        logger.debug("Call BrcReAppProcedure buildBrcCustomCompany...");
        buildBrcCustomCompany(brcReAppVO);
        logger.debug("Call BrcReAppProcedure buildBrcContact...");
        buildBrcContact(brcReAppVO);
        logger.debug("Call BrcReAppProcedure buildBrcContact...");
        buildBrcCustomHash(brcReAppVO);
        logger.debug("Call BrcReAppProcedure buildBrcCustomHash...");
/*     20141113 주석 by 김성준 : 재접수시 보증인정보 제외요청   
        List<BrcReAppSuretyListVO> brcReAppSuretyListVOs = brcReAppDAO.getSuretyList(brcReAppVO);
        for(BrcReAppSuretyListVO dummy : brcReAppSuretyListVOs){
            brcReAppVO.setNoSuretyFrom(dummy.getNoSurety());
            brcReAppVO.setNoSuretyTo(commonBizService.getBrcSuretyNoSurety(brcReAppVO.getNoReqTo()));
            logger.debug("Call BrcReAppProcedure buildBrcSurety...");
            buildBrcSurety(brcReAppVO);
            logger.debug("Call BrcReAppProcedure buildBrcSuretyHome...");
            buildBrcSuretyHome(brcReAppVO);
            logger.debug("Call BrcReAppProcedure buildBrcSuretyCompany...");
            buildBrcSuretyCompany(brcReAppVO);
        }
*/
        
        List<BrcReAppFileListVO> brcReAppFileListVOs = brcReAppDAO.getBrcFileList(brcReAppVO);
        logger.debug("Call BrcReAppProcedure brcReAppFileListVOs.size():"+brcReAppFileListVOs.size());
        if(brcReAppFileListVOs.size()>0){
            logger.debug("Call BrcReAppProcedure CommonUtil...");
            logger.debug("Call BrcReAppProcedure CommonFileUpload...");
            CommonFileUpload commonFileUpload = new CommonFileUpload();
            logger.debug("Call BrcReAppProcedure getDsNasImgPath...");
            String nasPath = commonCacheService.getDsNasImgPath();
            String nmCompShort = commonCacheService.getStCompOne().getNmCompShortEng();
            BigDecimal noSeq;
            String extension;
            
            String dsPath = commonFileUpload.getImgSavePath(nasPath);
            String nmFile;
            
            for(BrcReAppFileListVO dummy : brcReAppFileListVOs){
                logger.debug("Call BrcReAppProcedure brcReAppFileListVOs...");
                noSeq = brcFileService.getBrcFileSeq(); 
                extension = commonFileUpload.getFileExtension(dummy.getNmFile());
                nmFile = commonFileUpload.getImgFileName(nmCompShort,brcReAppVO.getNoReqTo(), noSeq) + "." + extension;            
                commonUtil.copyFile(dummy.getDsPath()+dummy.getNmFile(), dsPath+nmFile);
                
                brcReAppVO.setBrcFileNo(dummy.getNo());
                brcReAppVO.setBrcFileSeq(noSeq);
                brcReAppVO.setBrcFileDsPath(dsPath);
                brcReAppVO.setBrcFileNmFile(nmFile);
                logger.debug("Call BrcReAppProcedure buildBrcFile...");
                buildBrcFile(brcReAppVO);
            }
        }


    }

}
