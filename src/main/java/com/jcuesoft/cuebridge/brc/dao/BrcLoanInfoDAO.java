package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcLoanInfoResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanRequestVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BrcLoanInfoDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.BrcLoanInfoDAO";

    public BrcLoanInfoResponseVO getBrcLoanInfo(BrcLoanRequestVO brcLoanRequestVO) {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBrcLoanInfo", brcLoanRequestVO);
    }
    public List<BrcLoanInfoResponseVO>  getBrcLoanMobilePhone(BrcLoanRequestVO brcLoanRequestVO) {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBrcLoanMobilePhone", brcLoanRequestVO);
    }

    public int updateBrcLoan(BrcLoanRequestVO brcLoanRequestVO) {
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateBrcLoan", brcLoanRequestVO);
    }

    public int updateBrcCustom(BrcLoanRequestVO brcLoanRequestVO) {
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateBrcCustom", brcLoanRequestVO);
    }

    public int updateBrcCustomCompany(BrcLoanRequestVO brcLoanRequestVO) {
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateBrcCustomCompany", brcLoanRequestVO);
    }
    public int updateBrcCustomHash(BrcLoanRequestVO brcLoanRequestVO) {
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateBrcCustomHash", brcLoanRequestVO);
    }
    public int updateBrcCustomHome(BrcLoanRequestVO brcLoanRequestVO) {
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateBrcCustomHome", brcLoanRequestVO);
    }


}