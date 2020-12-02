package com.jcuesoft.cuebridge.st.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.st.dao.StPermissionDAO;
import com.jcuesoft.cuebridge.st.vo.StPermissionRequestVO;
import com.jcuesoft.cuebridge.st.vo.StPermissionResponseVO;

@Service
public class StPermissionService extends BaseService {
    /**
     * stCustomerDAO
     */
    @Autowired
    private StPermissionDAO stPermissionDAO;

    /**
     * stPermissionRequestVO
     * 
     * @param StCustomerRequestVO
     * @return
     * @throws Exception
     */
    public List<StPermissionResponseVO> getUserPermissionList(StPermissionRequestVO stPermissionRequestVO) throws Exception {
        return stPermissionDAO.getUserPermissionList(stPermissionRequestVO);
    }
    
    /**
     * updatePermission
     * 
     * @param stPermissionRequestVO
     * @return
     * @throws Exception
     */
    public int updatePermission(StPermissionRequestVO stPermissionRequestVO) throws Exception {
        
        stPermissionRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        stPermissionRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        
        logger.debug("@@TGET@@ 로그인 세션 ID :" +CommonSessionUtil.getIdUser());
        
        // 현재 권한정보를 로그테이블에 담는다. 
        stPermissionDAO.insertUserPermissionHistory(stPermissionRequestVO);
        
        stPermissionDAO.deleteUserPermission(stPermissionRequestVO);
        logger.debug("@@TGET@@ 권한 삭제 ID :" +stPermissionRequestVO.getSelectIdUser());
        String[] authPageArr =  stPermissionRequestVO.getAuthorize(); 
        
        logger.debug("@@TGET@@:" +authPageArr);
        if(authPageArr != null){
            for(int i=0 ; i < authPageArr.length ; i++){
                stPermissionRequestVO.setAuthPgmID(authPageArr[i]);
                logger.debug("@@TGET@@ 권한 INSERT " +authPageArr[i]);
                stPermissionDAO.insertUserPermission(stPermissionRequestVO);
            }
        }
       
        return 1;
    }
    

    


}