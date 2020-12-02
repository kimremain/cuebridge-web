package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcLoanCountVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.ups.vo.MemberListInoutTmVO;

@Repository
public class BrcLoanDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.BrcLoanDAO";

    /**
     * getBrcLoanLeftList
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcLoanResponseVO> getBrcLoanLeftList(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanDAO getBrcLoanLeftList...");
        logger.debug("Call BrcLoanDAO ID:"+brcLoanRequestVO.getLeftSearchId());
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBrcLoanLeftList", brcLoanRequestVO);
    }

    /**
     * getBrcContactLeftList
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcLoanResponseVO> getBrcContactLeftList(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanDAO getBrcContactLeftList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBrcContactLeftList", brcLoanRequestVO);
    }
    
    /**
     * getBrcLoanList
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcLoanResponseVO> getBrcLoanList(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanDAO getBrcLoanList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBrcLoanList", brcLoanRequestVO);
    }    
    
    /**
     * getBrcLoanList
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcLoanResponseVO> getBrcLoanList(Map<String,String> searchParams,PageBounds pageBounds) throws Exception {
        logger.debug("Call BrcLoanDAO getBrcLoanList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBrcLoanList", searchParams,pageBounds);
    }    

    /**
     * insertBrcLoan
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    public int insertBrcLoan(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanDAO insertBrcLoan...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertBrcLoan", brcLoanRequestVO);
    }

    /**
     * insertBrcCustom
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    public int insertBrcCustom(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanDAO insertBrcCustom...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertBrcCustom", brcLoanRequestVO);
    }

    /**
     * insertBrcCustomCompany
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    public int insertBrcCustomCompany(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanDAO insertBrcCustomCompany...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertBrcCustomCompany", brcLoanRequestVO);
    }

    /**
     * insertBrcCustomHome
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */    
    public int insertBrcCustomHome(BrcLoanRequestVO brcLoanRequestVO) throws Exception{
        logger.debug("Call BrcLoanDAO insertBrcCustomHome...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertBrcCustomHome", brcLoanRequestVO);
    }
    
    /**
     * insertBrcHash
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */    
    public int insertBrcCustomHash(BrcLoanRequestVO brcLoanRequestVO) throws Exception{
        logger.debug("Call BrcLoanDAO insertBrcHash...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertBrcCustomHash", brcLoanRequestVO);
    }    

    public BrcLoanCountVO getBrcLoanCount(BrcLoanRequestVO brcLoanRequestVO) {
        logger.debug("Call BrcLoanDAO getBrcLoanCount...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBrcLoanCount", brcLoanRequestVO);
    }
    
    /**
     * updateCdStatus
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    public int updateCdStatus(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanService updateCdStatus...");
        return sqlSession.update(MAPPER_NAMESPACE + ".updateCdStatus",brcLoanRequestVO);
        
    }

    public List<MemberListInoutTmVO> getMemberListInoutTmList(String noReq) {
        logger.debug("Call BrcLoanDAO getMemberListInoutTmList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getMemberListInoutTmList", noReq);
    }
}