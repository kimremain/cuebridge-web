package com.jcuesoft.cuebridge.bex.dao;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToSanwaVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BexToSanwaDAO extends BaseDAO {
    
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.bex.dao.BexToSanwaDAO";
    
    public BexToSanwaDAO(){
        logger.debug("BexToA1DAO.logger:" + logger.getName());
    }

    public BexToSanwaVO getBexToSanwa(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexToSanwaDAO getBexToSanwa...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBexToSanwa", bexMasterRequestVO);
    }    
    

}
