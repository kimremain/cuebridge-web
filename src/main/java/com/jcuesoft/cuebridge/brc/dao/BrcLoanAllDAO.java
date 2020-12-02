package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcLoanAllRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanAllResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;

@Repository
public class BrcLoanAllDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.loanall";

    /**
     * getLoanAllList
     * 
     * @param brcLoanAllRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcLoanAllResponseVO> getLoanAllList(BrcLoanAllRequestVO brcLoanAllRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getLoanAllList", brcLoanAllRequestVO);
    }
    
    /**
     * getLoanAllList
     * 
     * @param brcLoanAllRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcLoanAllResponseVO> getLoanAllPageList(Map<String,String> searchParams,PageBounds pageBounds) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getLoanAllList", searchParams,pageBounds);
    }


    /**
     * getLoanStatusCount
     * 
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    public BrcLoanAllResponseVO getLoanStatusCount(BrcLoanAllRequestVO brcLoanAllRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getLoanStatusCount", brcLoanAllRequestVO);
    }
   
    
}