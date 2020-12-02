package com.jcuesoft.cuebridge.st.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.st.dao.StGroupCodeDAO;
import com.jcuesoft.cuebridge.st.vo.StGroupCodeRequestVO;
import com.jcuesoft.cuebridge.st.vo.StGroupCodeResponseVO;

@Service
public class StGroupCodeService extends BaseService {
    /**
     * stGroupCodeDAO
     */
    @Autowired
    private StGroupCodeDAO stGroupCodeDAO;

    /**
     * getGroupCodeList
     * 
     * @param StGroupCodeRequestVO
     * @return
     * @throws Exception
     */
    public List<StGroupCodeResponseVO> getGroupCodeList(StGroupCodeRequestVO stGroupCodeRequestVO) throws Exception {
        return stGroupCodeDAO.getGroupCodeList(stGroupCodeRequestVO);
    }

    /**
     * getGroupCodeOne
     * 
     * @param StGroupCodeRequestVO
     * @return
     * @throws Exception
     */
    public StGroupCodeResponseVO getGroupCodeOne(StGroupCodeRequestVO stGroupCodeRequestVO) throws Exception {
        return stGroupCodeDAO.getGroupCodeOne(stGroupCodeRequestVO);
    }

    /**
     * insert
     * 
     * @param StGroupCodeRequestVO
     * @return
     * @throws Exception
     */
    public int insertGroupCode(StGroupCodeRequestVO stGroupCodeRequestVO) throws Exception {
        
        stGroupCodeRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        StGroupCodeResponseVO a = this.getGroupCodeOne(stGroupCodeRequestVO);
        if(a == null){
            return stGroupCodeDAO.insertGroupCode(stGroupCodeRequestVO);
        }else{
            throw new Exception("이미 존재하는 그룹코드 입니다. ");
        }
    }

    /**
     * update
     * 
     * @param sampleRequestVO
     * @return
     * @throws Exception
     */
    public int updateGroupCode(StGroupCodeRequestVO stGroupCodeRequestVO) throws Exception {
        stGroupCodeRequestVO.setIdUpt(CommonSessionUtil.getIdUser());

        return stGroupCodeDAO.updateGroupCode(stGroupCodeRequestVO);
    }

    /**
     * delete
     * 
     * @param stGroupCodeRequestVO
     * @return
     * @throws Exception
     */
    public int deleteGroupCode(StGroupCodeRequestVO stGroupCodeRequestVO) throws Exception {
        return stGroupCodeDAO.deleteGroupCode(stGroupCodeRequestVO);
    }
}