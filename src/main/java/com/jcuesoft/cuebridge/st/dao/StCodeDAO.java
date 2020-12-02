package com.jcuesoft.cuebridge.st.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.st.vo.StCodeRequestVO;
import com.jcuesoft.cuebridge.st.vo.StCodeResponseVO;

@Repository
public class StCodeDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.st.dao.code";

    /**
     * SqlSession
     */
    // @Autowired
    // private SqlSession sqlSession;

    /**
     * getCodeList
     * 
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    public List<StCodeResponseVO> getCodeList(StCodeRequestVO stCodeRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getCodeList", stCodeRequestVO);
    }

    /**
     * getCodeOne
     * 
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    public StCodeResponseVO getCodeOne(StCodeRequestVO stCodeRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getCodeOne", stCodeRequestVO);
    }


    /**
     * insertCode
     * 
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    public int insertCode(StCodeRequestVO stCodeRequestVO) throws Exception {
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertCode", stCodeRequestVO);
    }

    /**
     * updateCode
     * 
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    public int updateCode(StCodeRequestVO stCodeRequestVO) throws Exception {
        return sqlSession.update(MAPPER_NAMESPACE + ".updateCode", stCodeRequestVO);
    }

    /**
     * updateCodeOrder
     * 
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    public int updateCodeOrder(StCodeRequestVO stCodeRequestVO) throws Exception {
        return sqlSession.update(MAPPER_NAMESPACE + ".updateCodeOrder", stCodeRequestVO);
    }

    /**
     * deleteCode
     * 
     * @param sampleRequestVO
     * @return
     * @throws Exception
     */
    public int deleteCode(StCodeRequestVO stCodeRequestVO) throws Exception {
        return sqlSession.delete(MAPPER_NAMESPACE + ".deleteCode", stCodeRequestVO);
    }

}