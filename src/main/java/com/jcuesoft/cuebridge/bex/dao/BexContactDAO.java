package com.jcuesoft.cuebridge.bex.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.bex.vo.BexContactRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexContactResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BexContactDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.bex.dao.contact";
    
    /**
     * getExListAll
     * 
     * @param bexMasterRequestVO
     * @return
     * @throws Exception
     */
    public List<BexContactResponseVO> getExContact(BexContactRequestVO bexContactRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getExContact", bexContactRequestVO);
    }
}