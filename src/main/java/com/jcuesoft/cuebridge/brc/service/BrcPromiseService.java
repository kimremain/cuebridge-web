package com.jcuesoft.cuebridge.brc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcPromiseDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcPromiseRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcPromiseResponseVO;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.BaseService;

@Service
public class BrcPromiseService extends BaseService {

    @Autowired
    private BrcPromiseDAO brcPromiseDAO;

    /**
     * getPromiseList
     * 
     * @param BrcContactRequestVO
     * @return
     * @throws Exception
     */
    public Map<String, List<BrcPromiseResponseVO>> getPromiseList(BrcPromiseRequestVO brcPromiseRequestVO) throws Exception {

        Map<String, List<BrcPromiseResponseVO>> map = new HashMap<String, List<BrcPromiseResponseVO>>();

        List<BrcPromiseResponseVO> data = brcPromiseDAO.getPromiseList(brcPromiseRequestVO);
        map.put("brcLoanLeftList", data); // 접수내역조회

        String contactNoReq = "";
        for (BrcPromiseResponseVO d : data) {
            contactNoReq += d.getNoReq() + ",";
        }
        if (contactNoReq != "") {
            contactNoReq = contactNoReq.substring(1, contactNoReq.length() - 1);
        }
        brcPromiseRequestVO.setSearchContactNoReq(contactNoReq);
        // map.put("brcLoanLeftList2" ,contactNoReq); //접수내역조회

        return map;
    }

    /**
     * getPromisePageList
     * 
     * @param BrcContactRequestVO
     * @return
     * @throws Exception
     */
    public PageList<BrcPromiseResponseVO> getPromisePageList(BrcPromiseRequestVO brcPromiseRequestVO, PageBounds pageBounds) throws Exception {
        
        // 검색조건  페이징 이용시 requstVo를 사용할 수 없어 해쉬맵으로 재정의 
        Map<String, String> searchParams = new HashMap<String, String>();
        searchParams.put("searchIdScreen", brcPromiseRequestVO.getSearchIdScreen());
        searchParams.put("searchDmPromiseStart", brcPromiseRequestVO.getSearchDmPromiseStart());
        searchParams.put("searchDmPromiseEnd", brcPromiseRequestVO.getSearchDmPromiseEnd());
        searchParams.put("searchNmCustom", brcPromiseRequestVO.getSearchNmCustom());
        searchParams.put("searchNoCustom", brcPromiseRequestVO.getSearchNoCustom());
        
        logger.debug("@@TGET@@ brcPromiseRequestVO " +brcPromiseRequestVO);
        logger.debug("@@TGET@@ searchParams " +searchParams);
        
        PageList<BrcPromiseResponseVO> pageList = (PageList<BrcPromiseResponseVO>)  brcPromiseDAO.getPromisePageList(searchParams, pageBounds);

        // 리스트에서 메모를 가져올 noReq 를 추출한다 .
        String contactNoReq = "";
        for (BrcPromiseResponseVO d : pageList) {
            contactNoReq += d.getNoReq() + ",";
            logger.debug("@@TGET@@ foreach " +d.getNoReq());
        }
        if (contactNoReq != "") {
            //contactNoReq = contactNoReq.substring(1, contactNoReq.length() - 1);
        }
        
        brcPromiseRequestVO.setSearchContactNoReq(contactNoReq);
        logger.debug("@@TGET@@ contactNoReq " +contactNoReq);

        return pageList;
    }

}