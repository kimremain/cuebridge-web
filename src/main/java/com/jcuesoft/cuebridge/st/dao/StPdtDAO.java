package com.jcuesoft.cuebridge.st.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.st.vo.StPdtRequestVO;
import com.jcuesoft.cuebridge.st.vo.StPdtResponseVO;

@Repository
public class StPdtDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.st.dao.pdt";

    /**
     * SqlSession
     */
    // @Autowired
    // private SqlSession sqlSession;

    /**
     * getStPdtList
     * 
     * @param stPdtRequestVO
     * @return
     * @throws Exception
     */
    public List<StPdtResponseVO> getStPdtList(Map<String,String> searchParams,PageBounds pageBounds) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStPdtList", searchParams,pageBounds);
    }

    /**
     * getStPdtOne
     * 
     * @param stPdtRequestVO
     * @return
     * @throws Exception
     */
    public StPdtResponseVO getStPdtOne(StPdtRequestVO stPdtRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getStPdtOne", stPdtRequestVO);
    }

    /**
     * insert
     * 
     * @param stPdtRequestVO
     * @return
     * @throws Exception
     */
    public int insertPdt(StPdtRequestVO stPdtRequestVO) throws Exception {
        return sqlSession.insert(MAPPER_NAMESPACE + ".insert", stPdtRequestVO);
    }

    /**
     * delete
     * 
     * @param sampleRequestVO
     * @return
     * @throws Exception
     */
    public int deletePdt(StPdtRequestVO stPdtRequestVO) throws Exception {
        return sqlSession.delete(MAPPER_NAMESPACE + ".delete", stPdtRequestVO);
    }

    /**
     * update
     * 
     * @param stPdtRequestVO
     * @return
     * @throws Exception
     */
    public int updatePdt(StPdtRequestVO stPdtRequestVO) throws Exception {
        return sqlSession.update(MAPPER_NAMESPACE + ".update", stPdtRequestVO);
    }
}