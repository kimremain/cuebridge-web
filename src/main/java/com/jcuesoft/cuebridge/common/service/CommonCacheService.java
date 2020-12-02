package com.jcuesoft.cuebridge.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.common.dao.CommonCacheDAO;
import com.jcuesoft.cuebridge.common.vo.CodeVO;
import com.jcuesoft.cuebridge.st.vo.StCompVO;

@Service
public class CommonCacheService extends BaseService {
    /**
     * logger
     */
    /*private Logger logger = LoggerFactory.getLogger(this.getClass());*/
    /*final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());*/
    
    /**
     * commonSearchDAO
     */
    @Autowired
    private CommonCacheDAO commonCacheDAO;

    
    /**
     * ST_SETUP 환경설정
     * 
     * @return
     * @throws Exception
     */
    public String getDsNasImgPath() throws Exception {
        logger.debug("Call CommonCacheService getDsNasImgPath...");
        return commonCacheDAO.getDsNasImgPath();
    }
    
    /**
     * ST_COMP 법인정보
     * 
     * @return
     * @throws Exception
     */
    public StCompVO getStCompOne() throws Exception {
        logger.debug("Call CommonCacheService getStCompOne...");
        return commonCacheDAO.getStCompOne();
    }
    
    
    /**
     * ST_CODE 공통코드조회
     * 
     * @param cdGroup
     * @return
     * @throws Exception
     */
    public List<CodeVO> getStCodeList(String cdGroup) throws Exception {
        logger.debug("Call CommonCacheService getStCodeList...");
        return commonCacheDAO.getStCodeList(cdGroup);
    }
    
    /**
     * ST_CODE 공통코드조회 : 미입력된 ' ' ROW 추가
     * 
     * @param cdGroup
     * @return
     * @throws Exception
     */    
    public List<CodeVO> getStCodeListWithBlank(String cdGroup) throws Exception {
        logger.debug("Call CommonCacheService getStCodeListWithBlank...");
        return commonCacheDAO.getStCodeListWithBlank(cdGroup);
    }    
    
    /**
     * ST_PDT 상품리스트조회
     * 
     * @return
     * @throws Exception
     */
    public List<CodeVO> getStPdtList() throws Exception {
        logger.debug("Call CommonCacheService getStPdtList...");
        return commonCacheDAO.getStPdtList();
    }
    
    /**
     * ST_PGM 프로그램 리스트조회
     * 
     * @return
     * @throws Exception
     */
    public List<CodeVO> getStPgmList() throws Exception {
        logger.debug("Call CommonCacheService getStPgmList...");
        return commonCacheDAO.getStPgmList();
    }
    
    /**
     * ST_TEAM 팀리스트조회
     * 
     * @return
     * @throws Exception
     */    
    public List<CodeVO> getStTeamList() throws Exception {
        logger.debug("Call CommonCacheService getStPdtList...");
        return commonCacheDAO.getStTeamList();
    }    
    
    /**
     * 이메일리스트조회
     * 
     * @return
     * @throws Exception
     */    
    public List<CodeVO> getEmailList() throws Exception {
        logger.debug("Call CommonCacheService getEmailList...");
        return commonCacheDAO.getEmailList();
    }        
    
    /**
     * 약속시각리스트조회 / 관리방안 추후검토
     * 
     * @return
     * @throws Exception
     */    
    public List<CodeVO> getHHList() throws Exception {
        logger.debug("Call CommonCacheService getHHList...");
        return commonCacheDAO.getHHList();
    }      
    
    /**
     * 약속분리스트조회 / 관리방안 추후검토
     * 
     * @return
     * @throws Exception
     */    
    public List<CodeVO> getMIList() throws Exception {
        logger.debug("Call CommonCacheService getMIList...");
        return commonCacheDAO.getMIList();
    }
    
    /**
     * 약속분리스트조회 / 관리방안 추후검토
     * 
     * @return
     * @throws Exception
     */  
    public List<CodeVO>  getStUserList() {
        logger.debug("Call CommonCacheService getMIList...");
        return commonCacheDAO.getStUserList();
    }  
    
    public List<CodeVO>  getStUserListScreen() {
        logger.debug("Call CommonCacheService getMIList...");
        return commonCacheDAO.getStUserListScreen();
    }          
    
}