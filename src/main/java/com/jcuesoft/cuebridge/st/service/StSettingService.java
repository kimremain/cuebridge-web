package com.jcuesoft.cuebridge.st.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.st.dao.StSettingDAO;
import com.jcuesoft.cuebridge.st.vo.StSettingRequestVO;
import com.jcuesoft.cuebridge.st.vo.StSettingResponseVO;

@Service
public class StSettingService extends BaseService {
    /**
     * stSettingDAO
     */
    @Autowired
    private StSettingDAO stSettingDAO;

    /**
     * getSettingOne
     * 
     * @param stSettingRequestVO
     * @return
     * @throws Exception
     */
    public StSettingResponseVO getSettingOne(StSettingRequestVO stSettingRequestVO) throws Exception {
        return stSettingDAO.getSettingOne(stSettingRequestVO);
    }

    /**
     * update
     * 
     * @param stSettingRequestVO
     * @return
     * @throws Exception
     */
    public int updateSetting(StSettingRequestVO stSettingRequestVO) throws Exception {
        stSettingRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        return stSettingDAO.updateSetting(stSettingRequestVO);
    }

}