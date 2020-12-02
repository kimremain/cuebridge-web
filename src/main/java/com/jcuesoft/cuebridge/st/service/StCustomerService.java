package com.jcuesoft.cuebridge.st.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.st.dao.StCustomerDAO;
import com.jcuesoft.cuebridge.st.vo.StCustomerRequestVO;
import com.jcuesoft.cuebridge.st.vo.StCustomerResponseVO;

@Service
public class StCustomerService extends BaseService {
    /**
     * stCustomerDAO
     */
    @Autowired
    private StCustomerDAO stCustomerDAO;

    /**
     * getStCustomerList
     * 
     * @param StCustomerRequestVO
     * @return
     * @throws Exception
     */
    public List<StCustomerResponseVO> getStCustomerList(StCustomerRequestVO stCustomerRequestVO) throws Exception {
        return stCustomerDAO.getStCustomerList(stCustomerRequestVO);
    }

    /**
     * getStCustomerOne
     * 
     * @param StCustomerRequestVO
     * @return
     * @throws Exception
     */
    public StCustomerResponseVO getStCustomerOne(StCustomerRequestVO stCustomerRequestVO) throws Exception {
        return stCustomerDAO.getStCustomerOne(stCustomerRequestVO);
    }

    /**
     * insert
     * 
     * @param StCustomerRequestVO
     * @return
     * @throws Exception
     */
    public int insertCustomer(StCustomerRequestVO stCustomerRequestVO) throws Exception {
        stCustomerRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        return stCustomerDAO.insertCustomer(stCustomerRequestVO);
    }

    /**
     * update
     * 
     * @param sampleRequestVO
     * @return
     * @throws Exception
     */
    public int updateCustomer(StCustomerRequestVO stCustomerRequestVO) throws Exception {
        stCustomerRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        return stCustomerDAO.updateCustomer(stCustomerRequestVO);
    }

    /**
     * delete
     * 
     * @param stCustomerRequestVO
     * @return
     * @throws Exception
     */
    public int deleteCustomer(StCustomerRequestVO stCustomerRequestVO) throws Exception {
        return stCustomerDAO.deleteCustomer(stCustomerRequestVO);
    }
}