package com.jcuesoft.cuebridge.st.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.st.vo.StUserRequestVO;
import com.jcuesoft.cuebridge.st.vo.StUserResponseVO;

@Repository
public class StUserDAO extends BaseDAO{

    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.st.dao.stUser";

    public StUserDAO() {        
        logger.debug("StUserDAO.logger:" + logger.getName());
    }
    
    public List<StUserResponseVO> getStUserList(StUserRequestVO stUserRequestVO) throws Exception{
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStUserList", stUserRequestVO);
    }

    public StUserResponseVO getStUserOne(StUserRequestVO stUserRequestVO) {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getStUserOne", stUserRequestVO);
    }
    
    public int updateStUser(StUserRequestVO stUserRequestVO) throws Exception{
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateStUser", stUserRequestVO);
    }
}
