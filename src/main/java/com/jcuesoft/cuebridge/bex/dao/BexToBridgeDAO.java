package com.jcuesoft.cuebridge.bex.dao;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToBridgeVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BexToBridgeDAO extends BaseDAO {
    
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.bex.dao.BexToBridgeDAO";
    
    public BexToBridgeDAO(){
        logger.debug("BexToBridgeDAO.logger:" + logger.getName());
    }

    public BexToBridgeVO getBexToBridge(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexToBridgeVO getBexToBridge...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBexToBridge", bexMasterRequestVO);
    }    
    

}
