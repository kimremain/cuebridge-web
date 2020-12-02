package com.jcuesoft.cuebridge.st.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.st.dao.StUserDAO;
import com.jcuesoft.cuebridge.st.vo.StUserRequestVO;
import com.jcuesoft.cuebridge.st.vo.StUserResponseVO;

@Service
public class StUserService extends BaseService {
    
    @Autowired
    private StUserDAO dao;
    
    public List<StUserResponseVO> getStUserList(StUserRequestVO stUserRequestVO) throws Exception {

        return dao.getStUserList(stUserRequestVO);
    }

    public StUserResponseVO getStUserOne(StUserRequestVO stUserRequestVO) throws Exception{
        return dao.getStUserOne(stUserRequestVO);
    }

    public int updateStUser(StUserRequestVO stUserRequestVO) throws Exception{
        stUserRequestVO.setIdUser(CommonSessionUtil.getIdUser());
        return dao.updateStUser(stUserRequestVO);
    }

}
