package com.jcuesoft.cuebridge.brc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcLoanDAO;
import com.jcuesoft.cuebridge.brc.dao.BrcLoanInfoDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanCountVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanInfoResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanResponseVO;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;
import com.jcuesoft.cuebridge.ups.vo.MemberListInoutTmVO;

@Service
public class BrcLoanService extends BaseService {
    /**
     * brcLoanDAO
     */
    @Autowired
    private BrcLoanDAO brcLoanDAO;

    @Autowired
    private BrcLoanInfoDAO brcLoanInfoDAO;

    /**
     * commonSearchService
     */
    @Autowired
    private CommonBizService commonBizService;

    /**
     * 접수내역조회
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */

    public List<BrcLoanResponseVO> getBrcLoanLeftList(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanService getBrcLoanLeftList...");

        List<BrcLoanResponseVO> brcLoanLeftList = brcLoanDAO.getBrcLoanLeftList(brcLoanRequestVO); // 접수내역조회

        // 리스트에서 메모를 가져올 noReq 를 추출한다 .
        String contactNoReq = "";
        for (BrcLoanResponseVO d : brcLoanLeftList) {
            if ("71002".equals(d.getCdStatus()) || "71003".equals(d.getCdStatus()) || "71006".equals(d.getCdStatus())
                    || "71010".equals(d.getCdStatus())) { // 접수,상담중,재영업,익일영업
                contactNoReq += d.getNoReq() + ",";
            }
        }
        logger.debug("@@contact noReq@@ brc leftmenu : " + contactNoReq);
        brcLoanRequestVO.setSearchContactNoReq(contactNoReq);

        return brcLoanLeftList;
    }

    public List<BrcLoanResponseVO> getBrcLoanList(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanService getBrcLoanList...");
        List<BrcLoanResponseVO> brcLoanList = brcLoanDAO.getBrcLoanList(brcLoanRequestVO);

        // 리스트에서 메모를 가져올 noReq 를 추출한다 .
        String contactNoReq = "";
        for (BrcLoanResponseVO d : brcLoanList) {
            contactNoReq += d.getNoReq() + ",";
        }
        logger.debug("@@contact noReq@@ brc list : " + contactNoReq);
        brcLoanRequestVO.setSearchContactNoReq(contactNoReq);
        return brcLoanList;
    }
    
    public PageList<BrcLoanResponseVO> getBrcLoanList(BrcLoanRequestVO brcLoanRequestVO,PageBounds pageBounds) throws Exception {
        logger.debug("Call BrcLoanService getBrcLoanList...");
        
        Map<String, String> searchParams = new HashMap<String, String>();
        searchParams.put("idReg", brcLoanRequestVO.getIdReg());
        searchParams.put("searchCdStatus", brcLoanRequestVO.getSearchCdStatus());
        searchParams.put("searchNmCustom", brcLoanRequestVO.getSearchNmCustom());
        searchParams.put("searchNoCustom", brcLoanRequestVO.getSearchNoCustom());
        searchParams.put("searchNoTelMobile", brcLoanRequestVO.getSearchNoTelMobile());

        PageList<BrcLoanResponseVO> pageList = (PageList<BrcLoanResponseVO>) brcLoanDAO.getBrcLoanList(searchParams,pageBounds);

        // 리스트에서 메모를 가져올 noReq 를 추출한다 .
        String contactNoReq = "";
        for (BrcLoanResponseVO d : pageList) {
            contactNoReq += d.getNoReq() + ",";
        }
        logger.debug("@@contact noReq@@ brc list : " + contactNoReq);
        brcLoanRequestVO.setSearchContactNoReq(contactNoReq);
        return pageList;
    }
    

    public BrcLoanInfoResponseVO getBrcLoanInfo(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        return brcLoanInfoDAO.getBrcLoanInfo(brcLoanRequestVO);
    }
    
    public List<BrcLoanInfoResponseVO>  getBrcLoanMobilePhone(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        return brcLoanInfoDAO.getBrcLoanMobilePhone(brcLoanRequestVO);
    }

    public String updateBrcLoanInfo(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        String resultCode = ""; // resultCode

        // 통화약속일시
        if (brcLoanRequestVO.getDmPromiseYMD().length() == 10 && brcLoanRequestVO.getDmPromiseHH().length() == 2
                && brcLoanRequestVO.getDmPromiseMI().length() == 2) {
            StringBuffer dmPromise = new StringBuffer();
            dmPromise.append(brcLoanRequestVO.getDmPromiseYMD());
            dmPromise.append(brcLoanRequestVO.getDmPromiseHH());
            dmPromise.append(brcLoanRequestVO.getDmPromiseMI());
            brcLoanRequestVO.setDmPromise(dmPromise.toString());
        } else {
            brcLoanRequestVO.setDmPromise("");
        }        
        
        brcLoanInfoDAO.updateBrcLoan(brcLoanRequestVO);
        logger.debug("updateBrcLoan");
        brcLoanInfoDAO.updateBrcCustom(brcLoanRequestVO);
        logger.debug("updateBrcCustom");
        brcLoanInfoDAO.updateBrcCustomCompany(brcLoanRequestVO);
        logger.debug("updateBrcCustomHome");
        brcLoanInfoDAO.updateBrcCustomHome(brcLoanRequestVO);        
        // 20150107 추가 by 김성준
        logger.debug("updateBrcCustomHash");
        brcLoanInfoDAO.updateBrcCustomHash(brcLoanRequestVO);

        // 비대면관리대장 오픈후주석
        resultCode = commonBizService.procUpsMeberListInoutTm(brcLoanRequestVO.getNoReq(), "Y", "", "");
        logger.debug("updateBrcLoanInfo procUpsMeberListInoutTm resultCode:" + resultCode);
        resultCode = "success";
        return resultCode;
    }

    /**
     * 신규접수정보저장(BRC_LOAN, BRC_CUSTOM, BRC_CUSTOM_COMPANY)
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    public String insertBrc(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanService insertBrc...");

        String resultCode = ""; // resultCode
        String brcLoanNoReq = commonBizService.getBrcLoanNoReq(); // 접수일련번호조회

        // 하루에 9999건 이상 접수 됐을때
        if ("0000".equals(brcLoanNoReq.substring(8))) {
            resultCode = "fail - over";
        }
        // 정상 접수 처리
        else {
            // 접수일련번호
            brcLoanRequestVO.setNoReq(brcLoanNoReq);

            // 등록자
            //String regID = " ".equals(CommonSessionUtil.getLoginId()) ? brcLoanRequestVO.getIdReceive() : CommonSessionUtil.getLoginId();
            //brcLoanRequestVO.setIdReg(regID);

            // insert
            brcLoanDAO.insertBrcLoan(brcLoanRequestVO);
            brcLoanDAO.insertBrcCustom(brcLoanRequestVO);
            brcLoanDAO.insertBrcCustomCompany(brcLoanRequestVO);
            brcLoanDAO.insertBrcCustomHome(brcLoanRequestVO);
            // 20150107 추가 by 김성준
            brcLoanDAO.insertBrcCustomHash(brcLoanRequestVO);

            // resultCode
            resultCode = "success";
        }

        return resultCode;
    }

    public BrcLoanCountVO getBrcLoanCount(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanService getBrcLoanCount...");
        return brcLoanDAO.getBrcLoanCount(brcLoanRequestVO);
    }

    /**
     * updateCdStatus
     *
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    public int updateCdStatus(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call BrcLoanService updateCdStatus...");

        return brcLoanDAO.updateCdStatus(brcLoanRequestVO);

    }

    public List<MemberListInoutTmVO> getMemberListInoutTmList(String noReq) {
        logger.debug("Call BrcLoanService getMemberListInoutTmList...");
        return brcLoanDAO.getMemberListInoutTmList(noReq);
    }

}