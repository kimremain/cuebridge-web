package com.jcuesoft.cuebridge.brc.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcFileDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcFileRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcFileResponseVO;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;

@Service
public class BrcFileService extends BaseService {

    @Autowired
    private BrcFileDAO dao;    
    
    public List<BrcFileResponseVO> getBrcFileList(BrcFileRequestVO brcFileRequestVO) throws Exception {
        return dao.getBrcFileList(brcFileRequestVO);
    }    
    
    public int insertBrcFile(BrcFileRequestVO brcFileRequestVO) throws Exception{
        brcFileRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        return dao.insertBrcFile(brcFileRequestVO);
    }
    
    public int updateBrcFile(BrcFileRequestVO brcFileRequestVO) throws Exception{
        brcFileRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        return dao.updateBrcFile(brcFileRequestVO);
    }
    
    public int deleteBrcFile(BrcFileRequestVO brcFileRequestVO) throws Exception{
        
        // 파일삭제 
        String deleteFilePath = brcFileRequestVO.getDsPath()+"/"+brcFileRequestVO.getNmFile();
        boolean delResult = commonUtil.deleteFile(deleteFilePath);
        
        logger.debug("@@파일삭제@@ deleteFilePath:"+deleteFilePath + " 삭제결과:"+delResult);
        
        if(delResult){
            dao.deleteBrcFile(brcFileRequestVO);
        }
         
        return 1;
    }    
    
    public BigDecimal getBrcFileSeq() throws Exception{
        return dao.getBrcFileSeq();
    }
}
