package com.jcuesoft.cuebridge.brc.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcFileRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcFileResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;
@Repository
public class BrcFileDAO extends BaseDAO {

    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.brcFile";
    
    public BrcFileDAO() {        
        logger.debug("BrcFileDAO.logger:" + logger.getName());
    }    
    
    public List<BrcFileResponseVO> getBrcFileList(BrcFileRequestVO brcFileRequestVO) throws Exception{
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBrcFileList", brcFileRequestVO);
    }    
    
    public int insertBrcFile(BrcFileRequestVO brcFileRequestVO) throws Exception{
        return sqlSession.update(MAPPER_NAMESPACE+ ".insertBrcFile", brcFileRequestVO);
    }
    
    public int updateBrcFile(BrcFileRequestVO brcFileRequestVO) throws Exception{
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateBrcFile", brcFileRequestVO);
    }    
    
    public int deleteBrcFile(BrcFileRequestVO brcFileRequestVO) throws Exception{
        return sqlSession.update(MAPPER_NAMESPACE+ ".deleteBrcFile", brcFileRequestVO);
    }     
    
    public BigDecimal getBrcFileSeq() throws Exception{
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBrcFileSeq");
    }
}
