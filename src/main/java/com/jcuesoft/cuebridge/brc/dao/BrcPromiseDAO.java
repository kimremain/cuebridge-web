package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcPromiseRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcPromiseResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;

@Repository
public class BrcPromiseDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.promise";


    /**
     * getPromisePageList
     * 
     * @param brcPromiseRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcPromiseResponseVO> getPromisePageList(Map<String, String> searchParams,PageBounds pageBounds) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getPromiseList", searchParams , pageBounds);
    }
    
    
    /**
     * getPromiseList
     * 
     * @param brcPromiseRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcPromiseResponseVO> getPromiseList(BrcPromiseRequestVO brcPromiseRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getPromiseList", brcPromiseRequestVO);
    }
   
}