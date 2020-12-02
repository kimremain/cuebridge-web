package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcReAppFileListVO;
import com.jcuesoft.cuebridge.brc.vo.BrcReAppSuretyListVO;
import com.jcuesoft.cuebridge.brc.vo.BrcReAppVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;
@Repository
public class BrcReAppDAO extends BaseDAO{
    
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.BrcReAppDAO";

    public int buildBrcLoan(BrcReAppVO brcReAppVO) throws Exception{
        logger.debug("Call BrcReAppDAO buildBrcLoan...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".buildBrcLoan", brcReAppVO);
    }

    public int buildBrcCustom(BrcReAppVO brcReAppVO)  throws Exception{
        logger.debug("Call BrcReAppDAO buildBrcCustom...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".buildBrcCustom", brcReAppVO);
    }

    public int buildBrcCustomHome(BrcReAppVO brcReAppVO) throws Exception {
        logger.debug("Call BrcReAppDAO buildBrcCustomHome...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".buildBrcCustomHome", brcReAppVO);
    }

    public int buildBrcCustomCompany(BrcReAppVO brcReAppVO) throws Exception {
        logger.debug("Call BrcReAppDAO buildBrcCustomCompany...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".buildBrcCustomCompany", brcReAppVO);
    }

    public int buildBrcSurety(BrcReAppVO brcReAppVO) throws Exception {
        logger.debug("Call BrcReAppDAO buildBrcSurety...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".buildBrcSurety", brcReAppVO);
    }

    public int buildBrcSuretyHome(BrcReAppVO brcReAppVO) throws Exception {
        logger.debug("Call BrcReAppDAO buildBrcSuretyHome...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".buildBrcSuretyHome", brcReAppVO);
    }

    public int buildBrcSuretyCompany(BrcReAppVO brcReAppVO) throws Exception {
        logger.debug("Call BrcReAppDAO buildBrcSuretyCompany...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".buildBrcSuretyCompany", brcReAppVO);
    }

    public int buildBrcFile(BrcReAppVO brcReAppVO) throws Exception {
        logger.debug("Call BrcReAppDAO buildBrcFile...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".buildBrcFile", brcReAppVO);
    }

    public int buildBrcContact(BrcReAppVO brcReAppVO) throws Exception {
        logger.debug("Call BrcReAppDAO buildBrcContact...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".buildBrcContact", brcReAppVO);
    }
    
    public int buildBrcCustomHash(BrcReAppVO brcReAppVO) throws Exception {
        logger.debug("Call BrcReAppDAO buildBrcCustomHash...");
        return sqlSession.insert(MAPPER_NAMESPACE + ".buildBrcCustomHash", brcReAppVO);
    }

    public List<BrcReAppSuretyListVO> getSuretyList(BrcReAppVO brcReAppVO) throws Exception {
        logger.debug("Call BrcReAppDAO getSuretyList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getSuretyList", brcReAppVO);
    }

    public List<BrcReAppFileListVO> getBrcFileList(BrcReAppVO brcReAppVO) throws Exception {
        logger.debug("Call BrcReAppDAO getBrcFileList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBrcFileList", brcReAppVO);
    }

}
