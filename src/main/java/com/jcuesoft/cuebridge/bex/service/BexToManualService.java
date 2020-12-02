package com.jcuesoft.cuebridge.bex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;

@Service
public class BexToManualService extends BaseService {
    @Autowired
    private CommonBizService commonBizService;    
    @Autowired
    private BexMasterService bexMasterService;
    
    String excute(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexToChongLoService excute");
        String resultCode = ""; //resultCode        
        resultCode = "Success";        
        logger.debug("Call BexToManualService :" + bexMasterRequestVO.getCdCooperate());
        logger.debug("Call BexToManualService excute getBexMasterNoEx");
        bexMasterRequestVO.setNoEx(commonBizService.getBexMasterNoEx(bexMasterRequestVO.getNoReq()));
        logger.debug("Call BexToManualService excute insertBexMaster");
        bexMasterService.insertBexMaster(bexMasterRequestVO);
        logger.debug("Call BexToManualService excute insertBexContact");
        bexMasterRequestVO.setNmScreen("접수");
        bexMasterRequestVO.setDsCooperate("최초실행");        
        bexMasterService.insertBexContact(bexMasterRequestVO);

        return resultCode;
    }
}
