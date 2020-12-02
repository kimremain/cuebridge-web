package com.jcuesoft.cuebridge.bex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.bex.dao.BexContactDAO;
import com.jcuesoft.cuebridge.bex.vo.BexContactRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexContactResponseVO;
import com.jcuesoft.cuebridge.common.service.BaseService;

@Service
public class BexContactService  extends BaseService {
    /**
     * BexContactDAO
     */
    @Autowired
    private BexContactDAO bexContactDAO;

    /**
     * getExListAll
     * 
     * @param brcMasterRequestVO
     * @return
     * @throws Exception
     */
    public List<BexContactResponseVO> getExContact(BexContactRequestVO bexContactRequestVO) throws Exception {
        return bexContactDAO.getExContact(bexContactRequestVO);
    }
}