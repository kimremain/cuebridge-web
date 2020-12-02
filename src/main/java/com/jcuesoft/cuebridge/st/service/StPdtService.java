package com.jcuesoft.cuebridge.st.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.st.dao.StPdtDAO;
import com.jcuesoft.cuebridge.st.vo.StPdtRequestVO;
import com.jcuesoft.cuebridge.st.vo.StPdtResponseVO;

@Service
public class StPdtService extends BaseService {
    /**
     * stPdtDAO
     */
    @Autowired
    private StPdtDAO stPdtDAO;

    /**
     * getStPdtList
     * 
     * @param StPdtRequestVO
     * @return
     * @throws Exception
     */
    public PageList<StPdtResponseVO> getStPdtList(StPdtRequestVO stPdtRequestVO, PageBounds pageBounds) throws Exception {
        // 검색조건  
        Map<String, String> searchParams = new HashMap<String, String>();
        searchParams.put("searchNmPdt", stPdtRequestVO.getSearchNmPdt());
        
        PageList<StPdtResponseVO> pageList = (PageList<StPdtResponseVO>)  stPdtDAO.getStPdtList(searchParams,pageBounds);
        
        return pageList;
    }

    /**
     * getStPdtOne
     * 
     * @param StPdtRequestVO
     * @return
     * @throws Exception
     */
    public StPdtResponseVO getStPdtOne(StPdtRequestVO stPdtRequestVO) throws Exception {
        return stPdtDAO.getStPdtOne(stPdtRequestVO);
    }

    /**
     * insert
     * 
     * @param StPdtRequestVO
     * @return
     * @throws Exception
     */
    public int insertPdt(StPdtRequestVO stPdtRequestVO) throws Exception {
        stPdtRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        return stPdtDAO.insertPdt(stPdtRequestVO);
    }

    /**
     * update
     * 
     * @param sampleRequestVO
     * @return
     * @throws Exception
     */
    public int updatePdt(StPdtRequestVO stPdtRequestVO) throws Exception {
        stPdtRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        return stPdtDAO.updatePdt(stPdtRequestVO);
    }

    /**
     * delete
     * 
     * @param stPdtRequestVO
     * @return
     * @throws Exception
     */
    public int deletePdt(StPdtRequestVO stPdtRequestVO) throws Exception {
        return stPdtDAO.deletePdt(stPdtRequestVO);
    }
}