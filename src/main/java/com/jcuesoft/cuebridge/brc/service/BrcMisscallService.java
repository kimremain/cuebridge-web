package com.jcuesoft.cuebridge.brc.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.brc.dao.BrcMisscallDAO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcMisscallRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcMisscallResponseVO;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.BaseService;

@Service
public class BrcMisscallService extends BaseService {

    @Autowired
    private BrcMisscallDAO brcMisscallDAO;
    
    @Autowired
    private BrcLoanService brcLoanService;

    /**
     * 미스콜 히스토리
     * 
     * @param brcMisscallRequestVO
     * @param pageBounds
     * @return
     * @throws Exception
     */
    public PageList<BrcMisscallResponseVO> getMisscallHistoryList(BrcMisscallRequestVO brcMisscallRequestVO, PageBounds pageBounds) throws Exception {
        
        if(brcMisscallRequestVO.getSearchDmRegStart() == null && brcMisscallRequestVO.getSearchDmRegEnd() == null )
        {
            Date today = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            brcMisscallRequestVO.setSearchDmRegStart(simpleDateFormat.format(today));
            brcMisscallRequestVO.setSearchDmRegEnd(simpleDateFormat.format(today));
        }
        
        Map<String, String> searchParams = new HashMap<String, String>();
        searchParams.put("searchNoTel", brcMisscallRequestVO.getSearchNoTel());
        searchParams.put("searchCdCallProc", brcMisscallRequestVO.getSearchCdCallProc());
        searchParams.put("searchDmRegStart", brcMisscallRequestVO.getSearchDmRegStart());
        searchParams.put("searchDmRegEnd", brcMisscallRequestVO.getSearchDmRegEnd());
        
        PageList<BrcMisscallResponseVO> pageList = (PageList<BrcMisscallResponseVO>)  brcMisscallDAO.getMisscallHistoryList(searchParams,pageBounds);
        return pageList;
    }
    
    /**
     * 미스콜 접수대상 리스트 
     * 
     * @param brcMisscallRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcMisscallResponseVO> getMisscallList(BrcMisscallRequestVO brcMisscallRequestVO) throws Exception {
        return brcMisscallDAO.getMisscallList(brcMisscallRequestVO);
    }
    
    /**
     * 미스콜 건수
     * 
     * @param brcMisscallRequestVO
     * @return
     * @throws Exception
     */
    public BrcMisscallResponseVO getMisscallCount() throws Exception {
        return brcMisscallDAO.getMisscallCount();
    }
    
    /**
     * 미스콜 처리상태 변경 
     * 
     * @param brcMisscallRequestVO
     * @return
     * @throws Exception
     */
    public int updateBatchCdCallProc(BrcMisscallRequestVO brcMisscallRequestVO) throws Exception { 
           
            String[] updateBatchNo       =  brcMisscallRequestVO.getUpdateBatchNo(); 

            brcMisscallRequestVO.setCdCallProc(brcMisscallRequestVO.getUpdateCdCallProc()); // 변경할 상태값 
            brcMisscallRequestVO.setIdUpt(CommonSessionUtil.getIdUser()); // 처리자 
 
            for(int i = 0; i < updateBatchNo.length ; i++ ){
                
                String arr[] = updateBatchNo[i].split("-"); // updateBatchNo = 시퀀스-전화번호-비고
                
                brcMisscallRequestVO.setNo(arr[0]);
                brcMisscallRequestVO.setNoTel(arr[1]);
                
                // 비고 입력한 경우 
                if( arr.length > 2){     
                    brcMisscallRequestVO.setDsRemk(arr[2]);
                }
                logger.debug("@@ brcMisscallRequestVO "+ brcMisscallRequestVO);
                
                // 선택한 미스콜에 처리상태를 변경한다.
                brcMisscallDAO.updateMisscall(brcMisscallRequestVO);
                                
                // 중복건이 있는경우 미처리 상태를 변경한다. 
                brcMisscallDAO.updateMisscallOverlap(brcMisscallRequestVO);
                
                // 처리 변경상태가 접수인 경우 접수처리를 한다.
                if("71502".equals(brcMisscallRequestVO.getUpdateCdCallProc())){   
                    
                    String noTel = brcMisscallRequestVO.getNoTel();
                    String noTel1 = "";
                    String noTel2 = "";
                    String noTel3 = "";
                    
                    noTel1 = noTel.substring(0,3);
                    if(noTel.length() == 11){
                        noTel2 = noTel.substring(3,7);  
                        noTel3 = noTel.substring(7,11);
                    }else{ 
                        noTel2 = noTel.substring(3,6);
                        noTel3 = noTel.substring(6,10);
                    }

                    BrcLoanRequestVO brcLoanRequestVO = new BrcLoanRequestVO();
                    brcLoanRequestVO.setCdPath("70403");
                    brcLoanRequestVO.setNmCustom("통화예약");
                    brcLoanRequestVO.setNoTel1Mobile(noTel1);
                    brcLoanRequestVO.setNoTel2Mobile(noTel2);
                    brcLoanRequestVO.setNoTel3Mobile(noTel3);
                    brcLoanRequestVO.setIdReg(CommonSessionUtil.getIdUser());
                    //brcLoanRequestVO.setIdScreen("10006");
                    
                    logger.debug("@@@@@@@@@@@ 접수");
                    logger.debug("@@brcLoanRequestVO:"+brcLoanRequestVO);
                    
                    String resultCode = brcLoanService.insertBrc(brcLoanRequestVO);
                    if(resultCode != "success"){
                        throw new Exception("접수처리중 오류가 발생했습니다.");
                    }
                    
                }
        }     
        
        return 1;
    }    

}