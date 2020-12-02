package com.jcuesoft.cuebridge.bex.dao;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToAdvanceVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BexToAdvanceDAO extends BaseDAO {
    
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.bex.dao.BexToAdvanceDAO";
    
    public BexToAdvanceDAO(){
        logger.debug("BexToAdvanceDAO.logger:" + logger.getName());
    }

    public BexToAdvanceVO getBexToAdvance(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexToAdvanceVO getBexToTaekang...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBexToAdvance", bexMasterRequestVO);
    }    
    

}
