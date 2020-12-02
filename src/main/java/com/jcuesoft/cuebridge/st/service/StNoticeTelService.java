package com.jcuesoft.cuebridge.st.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.st.dao.StNoticeTelDAO;
import com.jcuesoft.cuebridge.st.vo.StNoticeTelRequestVO;
@Service
public class StNoticeTelService extends BaseService{
    @Autowired
    private StNoticeTelDAO stNoticeTelDAO;

    public int insertStNoticeTel(StNoticeTelRequestVO stNoticeTelRequestVO) throws Exception {
        logger.debug("Call StNoticeTelService insertStNoticeTel...");
        return stNoticeTelDAO.insertStNoticeTel(stNoticeTelRequestVO);
    }


}
