package com.jcuesoft.cuebridge.st.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.st.vo.StUserLogRequestVO;
import com.jcuesoft.cuebridge.st.vo.StUserLogResponseVO;

@Repository
public class StUserLogDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.st.dao.StUserLogDAO";

    /**
     * getStUserLogList 
     *
     * @param stUserLogRequestVO
     * @return
     * @throws Exception
     */
    public List<StUserLogResponseVO> getStUserLogList(Map<String,String> searchParams) throws Exception {
        logger.debug("Call StUserLogDAO getList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStUserLogPageList", searchParams);
    }
    
    /**
     * getPageList
     *
     * @param VO
     * @return
     * @throws Exception
     */
    public List<StUserLogResponseVO> getStUserLogList(Map<String,String> searchParams, PageBounds pageBounds) throws Exception {
        logger.debug("Call StUserLogDAO getList...");

        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStUserLogPageList", searchParams, pageBounds);
    }
    
    
    /**
     * insertStUserLog
     *
     * @param VO
     * @return
     * @throws Exception
     */
    public int insertStUserLog(StUserLogRequestVO VO) throws Exception {
        logger.debug("Call StUserLogDAO insertStUserLog...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertStUserLog", VO);
    }

}
