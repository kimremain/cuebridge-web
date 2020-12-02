package com.jcuesoft.cuebridge.st.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.st.vo.StSmssendResponseVO;

@Repository
public class StSmssendDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.st.dao.StSmssendDAO";

    public List<StSmssendResponseVO> getStSmssendList(Map<String,String> searchParams) throws Exception {
        logger.debug("Call StSmssendDAO getStSmssendList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStSmssendList", searchParams);
    }
    
    /**
     * getPageList
     *
     * @param VO
     * @return
     * @throws Exception
     */
    public List<StSmssendResponseVO> getStSmssendList(Map<String,String> searchParams, PageBounds pageBounds) throws Exception {
        logger.debug("Call StSmssendDAO getStSmssendList...");

        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStSmssendList", searchParams, pageBounds);
    }
    
}
