package com.jcuesoft.cuebridge.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jcuesoft.cuebridge.common.module.CommonJPAUtil;

public abstract class BaseDAO extends SqlSessionDaoSupport {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected SqlSessionTemplate sqlSession;
    
    protected static CommonJPAUtil commonJPAUtil = new CommonJPAUtil();

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
        sqlSession = (SqlSessionTemplate) this.getSqlSession();
    }

    // protected <S> S getMapper(Class<S> clazz) {
    // return getSqlSession().getMapper(clazz);
    // }

}
