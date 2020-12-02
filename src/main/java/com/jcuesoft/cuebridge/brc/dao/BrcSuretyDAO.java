package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcSuretyInfoResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSuretyRequestVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BrcSuretyDAO extends BaseDAO {
    

    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.brcSurety";
    
    public BrcSuretyDAO(){
        logger.debug("BrcSuretyDAO.logger:" + logger.getName());
    }
    
    public BrcSuretyInfoResponseVO getBrcSuretyInfo(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        logger.debug("BrcSuretyInfoResponseVO.getBrcSuretyInfo:" + brcSuretyRequestVO.getNoReq());
        logger.debug("BrcSuretyInfoResponseVO.getBrcSuretyInfo:" + brcSuretyRequestVO.getNoSurety());
        logger.debug("BrcSuretyInfoResponseVO.getBrcSuretyInfo:" + brcSuretyRequestVO.getSearchNoReq());
        logger.debug("BrcSuretyInfoResponseVO.getBrcSuretyInfo:" + brcSuretyRequestVO.getSearchNoSurety());
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBrcSuretyInfo", brcSuretyRequestVO);
    }
    
    public List<BrcSuretyInfoResponseVO> getBrcSuretyList(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBrcSuretyList", brcSuretyRequestVO);
    }
    
    public int insertBrcSurety(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertBrcSurety", brcSuretyRequestVO);
    }    
    
    public int insertBrcSuretyHash(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertBrcSuretyHash", brcSuretyRequestVO);
    }
    
    public int updateBrcSurety(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateBrcSurety", brcSuretyRequestVO);
    }    
    
    public int deleteBrcSurety(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        return sqlSession.update(MAPPER_NAMESPACE+ ".deleteBrcSurety", brcSuretyRequestVO);
    }

    public int insertBrcSuretyCompany(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertBrcSuretyCompany", brcSuretyRequestVO);
    }
    
    public int insertBrcSuretyHome(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertBrcSuretyHome", brcSuretyRequestVO);
    }

    public int updateBrcSuretyCompany(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception {
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateBrcSuretyCompany", brcSuretyRequestVO); 
    }    
    
    public int updateBrcSuretyHash(BrcSuretyRequestVO brcSuretyRequestVO) throws Exception{
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateBrcSuretyHash", brcSuretyRequestVO);
    }    
    
    public int updateBrcLoanYnSurety(String noReq) throws Exception{
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateBrcLoanYnSurety", noReq); 
    }
    
}
