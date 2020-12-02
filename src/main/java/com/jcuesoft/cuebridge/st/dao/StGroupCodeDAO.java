package com.jcuesoft.cuebridge.st.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.st.vo.StGroupCodeRequestVO;
import com.jcuesoft.cuebridge.st.vo.StGroupCodeResponseVO;

@Repository
public class StGroupCodeDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.st.dao.groupcode";

    /**
     * SqlSession
     */
    // @Autowired
    // private SqlSession sqlSession;

    /**
     * getGroupCodeList
     * 
     * @param stGroupCodeRequestVO
     * @return
     * @throws Exception
     */
    public List<StGroupCodeResponseVO> getGroupCodeList(StGroupCodeRequestVO stGroupCodeRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getGroupCodeList", stGroupCodeRequestVO);
    }

    /**
     * getStGroupCodeOne
     * 
     * @param stGroupCodeRequestVO
     * @return
     * @throws Exception
     */
    public StGroupCodeResponseVO getGroupCodeOne(StGroupCodeRequestVO stGroupCodeRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getGroupCodeOne", stGroupCodeRequestVO);
    }

    /**
     * insertGroupCode
     * 
     * @param stGroupCodeRequestVO
     * @return
     * @throws Exception
     */
    public int insertGroupCode(StGroupCodeRequestVO stGroupCodeRequestVO) throws Exception {
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertGroupCode", stGroupCodeRequestVO);
    }

    /**
     * deleteGroupCode
     * 
     * @param sampleRequestVO
     * @return
     * @throws Exception
     */
    public int deleteGroupCode(StGroupCodeRequestVO stGroupCodeRequestVO) throws Exception {
        return sqlSession.delete(MAPPER_NAMESPACE + ".deleteGroupCode", stGroupCodeRequestVO);
    }

    /**
     * updateGroupCode
     * 
     * @param stGroupCodeRequestVO
     * @return
     * @throws Exception
     */
    public int updateGroupCode(StGroupCodeRequestVO stGroupCodeRequestVO) throws Exception {
        return sqlSession.update(MAPPER_NAMESPACE + ".updateGroupCode", stGroupCodeRequestVO);
    }
}