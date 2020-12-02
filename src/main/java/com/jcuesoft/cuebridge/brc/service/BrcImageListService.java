package com.jcuesoft.cuebridge.brc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcImageListDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcImageListRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcImageListResponseVO;
import com.jcuesoft.cuebridge.common.service.BaseService;

@Service
public class BrcImageListService extends BaseService{

    @Autowired
    private BrcImageListDAO brcImageListDAO;


    public List<BrcImageListResponseVO> getFaxList(BrcImageListRequestVO brcImageListRequestVO) throws Exception {
        logger.debug("Call BrcImageListService getFaxList...");
        return brcImageListDAO.getFaxList(brcImageListRequestVO);
    }
    
    public List<BrcImageListResponseVO> getMmsList(BrcImageListRequestVO brcImageListRequestVO) throws Exception {
        logger.debug("Call BrcImageListService getMmsList...");
        return brcImageListDAO.getMmsList(brcImageListRequestVO);
    }

}