package com.jcuesoft.cuebridge.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.vo.CodeVO;
import com.jcuesoft.cuebridge.st.vo.StCompVO;

@Repository
public class CommonCacheDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.common.dao.CommonCacheDAO";

    /**
     * ST_COMP 법인정보조회
     * 

     * @return
     * @throws Exception
     */
    public StCompVO getStCompOne() throws Exception{
        logger.debug("Call CommonCacheDAO getStCompOne...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getStCompOne");
    }    
    
  
    /**
     * ST_CODE 공통코드조회
     * 
     * @param cdGroup
     * @return
     * @throws Exception
     */
    public List<CodeVO> getStCodeList(String cdGroup) throws Exception {
        logger.debug("Call CommonCacheDAO getStCodeList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStCodeList", cdGroup);
    }
    
    /**
     * ST_CODE 공통코드조회 : 미입력된 ' ' ROW 추가
     * 
     * @param cdGroup
     * @return
     * @throws Exception
     */
    public List<CodeVO> getStCodeListWithBlank(String cdGroup) throws Exception {
        logger.debug("Call CommonCacheDAO getStCodeListWithBlank...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStCodeListWithBlank", cdGroup);
    }    
    
    /**
     * ST_PDT 상품리스트조회
     * 
     * @return
     * @throws Exception
     */
    public List<CodeVO> getStPdtList() throws Exception {
        logger.debug("Call CommonCacheDAO getStPdtList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStPdtList");
    }
    
    /**
     * ST_PGM 프로그램 리스트 조회
     * 
     * @return
     * @throws Exception
     */
    public List<CodeVO> getStPgmList() throws Exception {
        logger.debug("Call CommonCacheDAO getStPgmList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStPgmList");
    }
    
    /**
     * ST_TEAM 팀리스트조회
     * 
     * @return
     * @throws Exception
     */    
    public List<CodeVO> getStTeamList() throws Exception{
        logger.debug("Call CommonCacheDAO getStTeamList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStTeamList");
    }    

    
    /**
     * 이메일리스트조회 / 관리방안 추후검토
     * 
     * @return
     * @throws Exception
     */    
    public List<CodeVO> getEmailList() {
        logger.debug("Call CommonCacheDAO getEmailList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getEmailList");
    }        
    
    /**
     * 약속시각리스트조회 / 관리방안 추후검토
     * 
     * @return
     * @throws Exception
     */    
    public List<CodeVO> getHHList() throws Exception{
        logger.debug("Call CommonCacheDAO getHHList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getHHList");
    }     
    
    /**
     * 약속분리스트조회 / 관리방안 추후검토
     * 
     * @return
     * @throws Exception
     */    
    public List<CodeVO> getMIList() throws Exception{
        logger.debug("Call CommonCacheDAO getMIList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getMIList");
    }

    public List<CodeVO> getStUserList() {
        logger.debug("Call CommonCacheDAO getStUserListScreen...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStUserList");
    }
    
    public List<CodeVO> getStUserListScreen() {
        logger.debug("Call CommonCacheDAO getStUserListScreen...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStUserListScreen");
    }

    public String getDsNasImgPath() {
        logger.debug("Call CommonCacheDAO getDsNasImgPath...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getDsNasImgPath");
    }         
    

}