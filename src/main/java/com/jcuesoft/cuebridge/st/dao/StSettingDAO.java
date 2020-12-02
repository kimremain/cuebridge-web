package com.jcuesoft.cuebridge.st.dao;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.st.vo.StSettingRequestVO;
import com.jcuesoft.cuebridge.st.vo.StSettingResponseVO;

@Repository
public class StSettingDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.st.dao.setting";

    /**
     * SqlSession
     */
    // @Autowired
    // private SqlSession sqlSession;

    /**
     * getSettingOne
     * 
     * @param StSettingRequestVO
     * @return
     * @throws Exception
     */
    public StSettingResponseVO getSettingOne(StSettingRequestVO StSettingRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getSettingOne", StSettingRequestVO);
    }

    /**
     * updateCode
     * 
     * @param StSettingRequestVO
     * @return
     * @throws Exception
     */
    public int updateSetting(StSettingRequestVO StSettingRequestVO) throws Exception {
        return sqlSession.update(MAPPER_NAMESPACE + ".updateSetting", StSettingRequestVO);
    }
}