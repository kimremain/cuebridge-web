package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcSearchRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSearchResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.common.vo.LincusMemberVO;

@Repository
public class BrcSearchDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.search";

    /**
     * 린커스 ERP 회원정보 조회 
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public LincusMemberVO getErpCustomInfo(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getErpCustomInfo", brcSearchRequestVO); 
    }
    
    /**
     * 린커스 ERP 보증인 정보 조회
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public LincusMemberVO getErpSuretyInfo(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getErpSuretyInfo", brcSearchRequestVO); 
    }
    
    /**
     * 린커스 UPS 회원정보 조회 
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public LincusMemberVO getUpsCustomInfo(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getUpsCustomInfo", brcSearchRequestVO); 
    }
    
    /**
     * 린커스 UPS 보증인 정보 조회
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public LincusMemberVO getUpsSuretyInfo(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getUpsSuretyInfo", brcSearchRequestVO); 
    }
    
    /**
     * getRelationSearchAll
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchAll(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationSearchAll", brcSearchRequestVO);
    }
    
    /**
     * getRelationSearchErp
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchErp(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationSearchErp", brcSearchRequestVO);
    }
    
    /**
     * getRelationSearchTim
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchTim(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationSearchTim", brcSearchRequestVO);
    }
    
    /**
     * getRelationSearchUps
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchUps(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationSearchUps", brcSearchRequestVO);
    }
    
    /**
     * getRelationSearchBridge
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchBridge(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationSearchBridge", brcSearchRequestVO);
    }
    
    /**
     * getRelationSearchSuretyErp
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchSuretyErp(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationSearchSuretyErp", brcSearchRequestVO);
    }
    
    /**
     * getRelationSearchSuretyTim
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchSuretyTim(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationSearchSuretyTim", brcSearchRequestVO);
    }
    
    /**
     * getRelationSearchSuretyUps
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchSuretyUps(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationSearchSuretyUps", brcSearchRequestVO);
    }
    
    /**
     * getRelationSearchSuretyBridge
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchSuretyBridge(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationSearchSuretyBridge", brcSearchRequestVO);
    }
    
    /**
     * getRelationHpSearch
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationHpSearch(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationHpSearch", brcSearchRequestVO);
    }
    
    /**
     * getRelationJuminSearch
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationJuminSearch(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationJuminSearch", brcSearchRequestVO);
    }
    
    /**
     * getRelationHashSearch
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationHashSearch(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getRelationHashSearch", brcSearchRequestVO);
    }    

    /**
     * getStNoticeTel
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getStNoticeTel(BrcSearchRequestVO brcSearchRequestVO) {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getStNoticeTel", brcSearchRequestVO);
    }

   
}