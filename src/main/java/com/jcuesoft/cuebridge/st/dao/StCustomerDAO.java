package com.jcuesoft.cuebridge.st.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.st.vo.StCustomerRequestVO;
import com.jcuesoft.cuebridge.st.vo.StCustomerResponseVO;

@Repository
public class StCustomerDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.st.dao.customer";

    /**
     * SqlSession
     */
    // @Autowired
    // private SqlSession sqlSession;

    /**
     * getStCustomerList
     * 
     * @param stCustomerRequestVO
     * @return
     * @throws Exception
     */
    public List<StCustomerResponseVO> getStCustomerList(StCustomerRequestVO stCustomerRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStCustomerList", stCustomerRequestVO);
    }

    /**
     * getStCustomerOne
     * 
     * @param stCustomerRequestVO
     * @return
     * @throws Exception
     */
    public StCustomerResponseVO getStCustomerOne(StCustomerRequestVO stCustomerRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getStCustomerOne", stCustomerRequestVO);
    }

    /**
     * insert
     * 
     * @param stCustomerRequestVO
     * @return
     * @throws Exception
     */
    public int insertCustomer(StCustomerRequestVO stCustomerRequestVO) throws Exception {
        return sqlSession.insert(MAPPER_NAMESPACE + ".insert", stCustomerRequestVO);
    }

    /**
     * delete
     * 
     * @param sampleRequestVO
     * @return
     * @throws Exception
     */
    public int deleteCustomer(StCustomerRequestVO stCustomerRequestVO) throws Exception {
        return sqlSession.delete(MAPPER_NAMESPACE + ".delete", stCustomerRequestVO);
    }

    /**
     * update
     * 
     * @param stCustomerRequestVO
     * @return
     * @throws Exception
     */
    public int updateCustomer(StCustomerRequestVO stCustomerRequestVO) throws Exception {
        return sqlSession.update(MAPPER_NAMESPACE + ".update", stCustomerRequestVO);
    }
}