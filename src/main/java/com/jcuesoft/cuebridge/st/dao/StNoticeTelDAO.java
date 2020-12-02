package com.jcuesoft.cuebridge.st.dao;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.st.vo.StNoticeTelRequestVO;

@Repository
public class StNoticeTelDAO extends BaseDAO{
    
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.st.dao.StNoticeTelDAO";
    
    public StNoticeTelDAO(){
        logger.debug("StNoticeTelDAO.logger:" + logger.getName());
    }

    public int insertStNoticeTel(StNoticeTelRequestVO stNoticeTelRequestVO) throws Exception {
        logger.debug("Call StNoticeTelDAO insertStNoticeTel...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertStNoticeTel", stNoticeTelRequestVO);
    }
}
