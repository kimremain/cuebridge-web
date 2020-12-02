package com.jcuesoft.cuebridge.auth.dao;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.auth.vo.AuthRequestVO;
import com.jcuesoft.cuebridge.auth.vo.AuthResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class AuthDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.auth.dao";

    
    public String getLoginDecrypt(String encryptStr) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getLoginDecrypt", encryptStr);
    }
    
    public String getCorrectCookieId(String encryptStr) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getLoginDecrypt", encryptStr);
    }

    public AuthResponseVO getUserInfoByIdUser(AuthRequestVO authRequestVO) {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getUserInfoByIdUser", authRequestVO);
    }

    public AuthResponseVO getUserInfoByDsPwd(AuthRequestVO authRequestVO) {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getUserInfoByDsPwd", authRequestVO);
    }    
    
}
