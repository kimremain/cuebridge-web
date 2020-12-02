package com.jcuesoft.cuebridge.bex.dao;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToTaekangVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BexToTaekangDAO extends BaseDAO {
    
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.bex.dao.BexToTaekangDAO";
    
    public BexToTaekangDAO(){
        logger.debug("BexToTaekangDAO.logger:" + logger.getName());
    }

    public BexToTaekangVO getBexToTaekang(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexToTaekangDAO getBexToTaekang...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBexToTaekang", bexMasterRequestVO);
    }    
    

}
