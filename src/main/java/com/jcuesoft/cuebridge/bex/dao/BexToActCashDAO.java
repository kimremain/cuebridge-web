package com.jcuesoft.cuebridge.bex.dao;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexToActCashVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BexToActCashDAO extends BaseDAO {
    
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.bex.dao.BexToActCashDAO";
    
    public BexToActCashDAO(){
        logger.debug("BexToActCashDAO.logger:" + logger.getName());
    }

    public BexToActCashVO getBexToActCash(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexToActCashDAO getBexToActCash...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBexToActCash", bexMasterRequestVO);
    }    
    

}
