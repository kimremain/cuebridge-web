package com.jcuesoft.cuebridge.brc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcSearchDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcSearchRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSearchResponseVO;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.vo.LincusMemberVO;

@Service
public class BrcSearchService extends BaseService {

    @Autowired
    private BrcSearchDAO brcSearchDAO;
    
    /**
     * 린커스 ERP 회원정보 조회 
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public LincusMemberVO getErpCustomInfo(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getErpCustomInfo(brcSearchRequestVO);
    }
    
    /**
     * 린커스 ERP 보증인 정보 조회
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public LincusMemberVO getErpSuretyInfo(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getErpSuretyInfo(brcSearchRequestVO);
    }
    
    /**
     * 린커스 UPS 회원정보 조회 
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public LincusMemberVO getUpsCustomInfo(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getUpsCustomInfo(brcSearchRequestVO);
    }
    
    /**
     * 린커스 UPS 보증인 정보 조회
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public LincusMemberVO getUpsSuretyInfo(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getUpsSuretyInfo(brcSearchRequestVO);
    }
    
    
    /**
     * 연계검사 전체
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchAll(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationSearchAll(brcSearchRequestVO);
    }
    
    /**
     * 연계검사 ERP
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchErp(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationSearchErp(brcSearchRequestVO);
    }
    
    /**
     * 연계검사 UPS
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchUps(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationSearchUps(brcSearchRequestVO);
    }
    
    /**
     * 연계검사 Tim
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchTim(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationSearchTim(brcSearchRequestVO);
    }
    
    /**
     * 연계검사 Bridge
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchBridge(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationSearchBridge(brcSearchRequestVO);
    }
    
    /**
     * 보증인 연계검사 ERP
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchSuretyErp(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationSearchSuretyErp(brcSearchRequestVO);
    }
    
    /**
     * 보증인 연계검사 UPS
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchSuretyUps(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationSearchSuretyUps(brcSearchRequestVO);
    }
    
    /**
     * 보증인 연계검사 Tim
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchSuretyTim(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationSearchSuretyTim(brcSearchRequestVO);
    }
    
    /**
     * 보증인 연계검사 Bridge
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationSearchSuretyBridge(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationSearchSuretyBridge(brcSearchRequestVO);
    }
    
    /**
     * HP 통합 
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationHpSearch(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationHpSearch(brcSearchRequestVO);

    }
    
    /**
     * 주민번호 통합
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationJuminSearch(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationJuminSearch(brcSearchRequestVO);

    }
    
    /**
     * 통합해쉬
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getRelationHashSearch(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getRelationHashSearch(brcSearchRequestVO);

    }    
    
    
    /**
     * 주의전화
     * 
     * @param brcSearchRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSearchResponseVO> getStNoticeTel(BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        return brcSearchDAO.getStNoticeTel(brcSearchRequestVO);

    }    
    
}