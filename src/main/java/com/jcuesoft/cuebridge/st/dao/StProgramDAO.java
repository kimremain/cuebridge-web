package com.jcuesoft.cuebridge.st.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.st.vo.StProgramRequestVO;
import com.jcuesoft.cuebridge.st.vo.StProgramResponseVO;

@Repository
public class StProgramDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.st.dao.StProgramDAO";

    /**
     * getProgramList
     *
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    public List<StProgramResponseVO> getProgramList(StProgramRequestVO stProgramRequestVO) throws Exception {
        logger.debug("Call StProgramDAO getProgramList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getProgramList", stProgramRequestVO);
    }

    /**
     * getProgramOne
     *
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    public StProgramResponseVO getProgramOne(StProgramRequestVO stProgramRequestVO) throws Exception {
        logger.debug("Call StProgramDAO getProgramOne...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getProgramOne", stProgramRequestVO);
    }

    /**
     * insertProgram
     *
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    public int insertProgram(StProgramRequestVO stProgramRequestVO) throws Exception {
        logger.debug("Call StProgramDAO insertProgram...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertProgram", stProgramRequestVO);
    }

    /**
     * deleteProgram
     *
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    public int deleteProgram(StProgramRequestVO stProgramRequestVO) throws Exception {
        logger.debug("Call StProgramDAO deleteProgram...");
        return sqlSession.delete(MAPPER_NAMESPACE + ".deleteProgram", stProgramRequestVO);
    }

    /**
     * updateProgram
     *
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    public int updateProgram(StProgramRequestVO stProgramRequestVO) throws Exception {
        logger.debug("Call StProgramDAO updateProgram...");
        return sqlSession.update(MAPPER_NAMESPACE + ".updateProgram", stProgramRequestVO);
    }

}