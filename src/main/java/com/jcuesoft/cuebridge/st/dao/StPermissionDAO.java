package com.jcuesoft.cuebridge.st.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.st.vo.StPermissionRequestVO;
import com.jcuesoft.cuebridge.st.vo.StPermissionResponseVO;

@Repository
public class StPermissionDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.st.dao.permission";

    /**
     * getStCustomerList
     * 
     * @param stCustomerRequestVO
     * @return
     * @throws Exception
     */
    public List<StPermissionResponseVO> getUserPermissionList(StPermissionRequestVO stPermissionRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getUserPermissionList", stPermissionRequestVO);
    }

    /**
     * insertUserPermission
     * 
     * @param stPermissionRequestVO
     * @return
     * @throws Exception
     */
    public int insertUserPermission(StPermissionRequestVO stPermissionRequestVO) throws Exception {
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertUserPermission", stPermissionRequestVO);
    }
    
    /**
     * insertUserPermissionHistory
     * 
     * @param stPermissionRequestVO
     * @return
     * @throws Exception
     */
    public int insertUserPermissionHistory(StPermissionRequestVO stPermissionRequestVO) throws Exception {
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertUserPermissionHistory", stPermissionRequestVO);
    }
    
    

    /**
     * deleteUserPermission
     * 
     * @param stPermissionRequestVO
     * @return
     * @throws Exception
     */
    public int deleteUserPermission(StPermissionRequestVO stPermissionRequestVO) throws Exception {
        return sqlSession.delete(MAPPER_NAMESPACE + ".deleteUserPermission", stPermissionRequestVO);
    }
}