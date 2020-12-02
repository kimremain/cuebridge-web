package com.jcuesoft.cuebridge.bex.dao;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToA1VO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BexToA1DAO extends BaseDAO {
    
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.bex.dao.BexToA1DAO";
    
    public BexToA1DAO(){
        logger.debug("BexToA1DAO.logger:" + logger.getName());
    }

    public BexToA1VO getBexToA1(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexToAdvanceVO getBexToA1...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBexToA1", bexMasterRequestVO);
    }    
    

}
