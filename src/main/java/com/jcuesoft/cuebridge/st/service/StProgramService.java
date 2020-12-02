package com.jcuesoft.cuebridge.st.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.st.dao.StProgramDAO;
import com.jcuesoft.cuebridge.st.vo.StProgramRequestVO;
import com.jcuesoft.cuebridge.st.vo.StProgramResponseVO;

@Service
public class StProgramService extends BaseService {
    /**
     * StProgramDAO
     */
    @Autowired
    private StProgramDAO stProgramDAO;

    /**
     * getProgramList
     *
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    public List<StProgramResponseVO> getProgramList(StProgramRequestVO stProgramRequestVO) throws Exception {
        logger.debug("Call StProgramService getProgramList...");
        return stProgramDAO.getProgramList(stProgramRequestVO);
    }

    /**
     * getProgramOne
     *
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    public StProgramResponseVO getProgramOne(StProgramRequestVO stProgramRequestVO) throws Exception {
        logger.debug("Call StProgramService getProgramOne...");
        return stProgramDAO.getProgramOne(stProgramRequestVO);
    }

    /**
     * insertProgram
     *
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    public int insertProgram(StProgramRequestVO stProgramRequestVO) throws Exception {
        logger.debug("Call StProgramService insertProgram...");
        stProgramRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        return stProgramDAO.insertProgram(stProgramRequestVO);
    }
    // Test
    public int insertProgramTest(StProgramRequestVO stProgramRequestVO) throws Exception {
        
        throw new Exception("StProgramService.insertProgramTest  Exception ");

    }
    /**
     * deleteProgram
     *
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    public int deleteProgram(StProgramRequestVO stProgramRequestVO) throws Exception {
        logger.debug("Call StProgramService deleteProgram...");
        return stProgramDAO.deleteProgram(stProgramRequestVO);
    }

    /**
     * updateProgram
     *
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    public int updateProgram(StProgramRequestVO stProgramRequestVO) throws Exception {
        logger.debug("Call StProgramService updateProgram...");
        stProgramRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        return stProgramDAO.updateProgram(stProgramRequestVO);
    }
}