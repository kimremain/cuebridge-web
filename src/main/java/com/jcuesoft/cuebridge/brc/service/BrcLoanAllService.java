package com.jcuesoft.cuebridge.brc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcLoanAllDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanAllRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanAllResponseVO;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;

@Service
public class BrcLoanAllService extends BaseService{

    @Autowired
    private BrcLoanAllDAO brcLoanAllDAO;
    
    @Autowired
    private CommonBizService commonBizService;
    
    
    /**
     * getLoanAllPageList
     * 
     * @param brcLoanAllRequestVO
     * @return
     * @throws Exception
     */
    public PageList<BrcLoanAllResponseVO> getLoanAllPageList(BrcLoanAllRequestVO brcLoanAllRequestVO, PageBounds pageBounds) throws Exception {
        
        // 검색조건  페이징 이용시 requstVo를 사용할 수 없어 해쉬맵으로 재정의 DefaultParameterHandler.java 수정 
        Map<String, String> searchParams = new HashMap<String, String>();
        searchParams.put("searchCdStatus", brcLoanAllRequestVO.getSearchCdStatus());
        searchParams.put("searchIdScreen", brcLoanAllRequestVO.getSearchIdScreen());
        searchParams.put("searchCdPath", brcLoanAllRequestVO.getSearchCdPath());
        searchParams.put("searchDmColumn", brcLoanAllRequestVO.getSearchDmColumn());
        searchParams.put("searchDmStart", brcLoanAllRequestVO.getSearchDmStart());
        searchParams.put("searchDmEnd", brcLoanAllRequestVO.getSearchDmEnd());
        searchParams.put("searchNmCustom", brcLoanAllRequestVO.getSearchNmCustom());
        searchParams.put("searchNoCustom", brcLoanAllRequestVO.getSearchNoCustom());
        searchParams.put("searchNoReq", brcLoanAllRequestVO.getSearchNoReq());
        searchParams.put("searchNoCooperate", brcLoanAllRequestVO.getSearchNoCooperate());
        searchParams.put("searchNoTelMobile1", brcLoanAllRequestVO.getSearchNoTelMobile1());
        searchParams.put("searchNoTelMobile2", brcLoanAllRequestVO.getSearchNoTelMobile2());
        searchParams.put("searchNoTelMobile3", brcLoanAllRequestVO.getSearchNoTelMobile3());
        searchParams.put("searchYnSafekey", brcLoanAllRequestVO.getSearchYnSafekey());
        searchParams.put("searchCdTactic", brcLoanAllRequestVO.getSearchCdTactic());
        searchParams.put("searchCdRecruitGroup", brcLoanAllRequestVO.getSearchCdRecruitGroup());
        searchParams.put("searchCnSafekeyExt", brcLoanAllRequestVO.getSearchCnSafekeyExt());
        searchParams.put("searchYnReSale", brcLoanAllRequestVO.getSearchYnReSale());

        logger.debug("@@TGET@@ brcPromiseRequestVO " +brcLoanAllRequestVO);
        logger.debug("@@TGET@@ searchParams " +searchParams);
        
        PageList<BrcLoanAllResponseVO> pageList = (PageList<BrcLoanAllResponseVO>)  brcLoanAllDAO.getLoanAllPageList(searchParams,pageBounds);

        // 리스트에서 메모를 가져올 noReq 를 추출한다 .
        String contactNoReq = "";
        for (BrcLoanAllResponseVO d : pageList) {
            contactNoReq += d.getNoReq() + ",";
        }
        if (contactNoReq != "") {
           // contactNoReq = contactNoReq.substring(1, contactNoReq.length() - 1);
        }
        brcLoanAllRequestVO.setSearchContactNoReq(contactNoReq);
        logger.debug("@@TGET@@ contactNoReq " +contactNoReq);
        
       return pageList;
    }
    
    /**
     * getLoanAllList
     * 
     * @param brcLoanAllRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcLoanAllResponseVO> getLoanAllList(BrcLoanAllRequestVO brcLoanAllRequestVO) throws Exception {
        
        List<BrcLoanAllResponseVO>  data = brcLoanAllDAO.getLoanAllList(brcLoanAllRequestVO);

        String contactNoReq = "";
        for( BrcLoanAllResponseVO d : data )
        {
            contactNoReq += d.getNoReq()+",";
        }
        if(contactNoReq != ""){
            contactNoReq = contactNoReq.substring(1, contactNoReq.length()-1 );
        }
        brcLoanAllRequestVO.setSearchContactNoReq(contactNoReq);
        //map.put("brcLoanLeftList2"   ,contactNoReq);    //접수내역조회

       return data;
    }
    
    /**
     * getLoanStatusCount
     * 
     * @param StCodeRequestVO
     * @return
     * @throws Exception
     */
    public BrcLoanAllResponseVO getLoanStatusCount(BrcLoanAllRequestVO brcLoanAllRequestVO) throws Exception {
        return brcLoanAllDAO.getLoanStatusCount(brcLoanAllRequestVO);
    }
    

}