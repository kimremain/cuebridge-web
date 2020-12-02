package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcMisscallRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcMisscallResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;

@Repository
public class BrcMisscallDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.misscall";
    
    public List<BrcMisscallResponseVO> getMisscallHistoryList(Map<String,String> searchParams,PageBounds pageBounds) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getMisscallHistoryList", searchParams,pageBounds);
    }
    
    public List<BrcMisscallResponseVO> getMisscallList(BrcMisscallRequestVO brcMisscallRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getMisscallList", brcMisscallRequestVO);
    }
    
    
    public BrcMisscallResponseVO getMisscallCount() throws Exception {
        logger.debug("Call BrcMisscallDAO getMisscallCount...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getMisscallCount");
    }
    
    
    public int updateMisscall(BrcMisscallRequestVO brcMisscallRequestVO) {
        logger.debug("Call BrcMisscallDAO updateBatchCdCallProc...");
        return sqlSession.update(MAPPER_NAMESPACE + ".updateMisscall", brcMisscallRequestVO);
    }
    
    public int updateMisscallOverlap(BrcMisscallRequestVO brcMisscallRequestVO) {
        logger.debug("Call BrcMisscallDAO updateMisscallOverlap...");
        return sqlSession.update(MAPPER_NAMESPACE + ".updateMisscallOverlap", brcMisscallRequestVO);
    }
    
    public int updateBatchCdCallProc(BrcMisscallRequestVO brcMisscallRequestVO) {
        logger.debug("Call BrcMisscallDAO updateBatchCdCallProc...");
        return sqlSession.update(MAPPER_NAMESPACE + ".updateBatchCdCallProc", brcMisscallRequestVO);
    }
    
   
}