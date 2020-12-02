package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcExcelReportRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcExcelReportResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BrcExcelReportDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.BrcExcelReportDAO";

    /**
     * getBrcExcelReportList
     *
     * @param brcExcelReportRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcExcelReportResponseVO> getBrcExcelReportList(BrcExcelReportRequestVO brcExcelReportRequestVO) throws Exception {
        logger.debug("Call BrcExcelReportDAO getBrcExcelReportList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBrcExcelReportList", brcExcelReportRequestVO);
    }
}
