package com.jcuesoft.cuebridge.brc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcExcelReportDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcExcelReportRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcExcelReportResponseVO;
import com.jcuesoft.cuebridge.common.service.BaseService;

@Service
public class BrcExcelReportService extends BaseService {
    /**
     * brcExcelReportDAO
     */
    @Autowired
    private BrcExcelReportDAO brcExcelReportDAO;

    /**
     * getBrcExcelReportList
     *
     * @param brcExcelReportRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcExcelReportResponseVO> getBrcExcelReportList(BrcExcelReportRequestVO brcExcelReportRequestVO) throws Exception {
        logger.debug("Call BrcExcelReportService getBrcExcelReportList...");
        return brcExcelReportDAO.getBrcExcelReportList(brcExcelReportRequestVO);
    }
}
