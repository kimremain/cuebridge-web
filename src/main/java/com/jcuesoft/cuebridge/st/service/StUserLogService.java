package com.jcuesoft.cuebridge.st.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.st.dao.StUserLogDAO;
import com.jcuesoft.cuebridge.st.vo.StUserLogRequestVO;
import com.jcuesoft.cuebridge.st.vo.StUserLogResponseVO;

@Service
public class StUserLogService extends BaseService {

    @Autowired
    private StUserLogDAO stUserLogDAO;

    /*
     * getPageList
     * 
     * @param StUserLogRequestVO
     * @return List<StUserLogResponseVO>
     * @throws Exception
     */
    public List<StUserLogResponseVO> getStUserLogList(StUserLogRequestVO stUserLogRequestVO) throws Exception {
   
            
        Map<String, String> searchParams = this.getUserLogSearchParam(stUserLogRequestVO);
        List<StUserLogResponseVO> tmpList = stUserLogDAO.getStUserLogList(searchParams);
        return tmpList;
    }
    
    
    /**
     * getPageList
     * 
     * @param StUserLogRequestVO
     * @param PageBounds
     * @return PageList<StUserLogResponseVO>
     * @throws Exception
     */
    public PageList<StUserLogResponseVO> getStUserLogList(StUserLogRequestVO stUserLogRequestVO, PageBounds pageBounds) throws Exception {
        
       
        Map<String, String> searchParams = this.getUserLogSearchParam(stUserLogRequestVO);
        PageList<StUserLogResponseVO> pageList = (PageList<StUserLogResponseVO>)  stUserLogDAO.getStUserLogList(searchParams, pageBounds);

        return pageList;
    }
    
    /**
     * getUserLogSearchParam
     * 
     * @param StUserLogRequestVO
     * @return  Map<String, String>
     * @throws Exception
     */
    public Map<String, String> getUserLogSearchParam(StUserLogRequestVO stUserLogRequestVO) throws Exception {
        
        if(stUserLogRequestVO.getSearchDmRegFrom() == null && stUserLogRequestVO.getSearchDmRegTo() == null ){
            Date today = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            stUserLogRequestVO.setSearchDmRegFrom(simpleDateFormat.format(today));
            stUserLogRequestVO.setSearchDmRegTo(simpleDateFormat.format(today));
        }

        Map<String, String> searchParams = new HashMap<String, String>();
        searchParams.put("searchIdUser", stUserLogRequestVO.getSearchIdUser());
        searchParams.put("searchDmRegFrom", stUserLogRequestVO.getSearchDmRegFrom());
        searchParams.put("searchDmRegTo", stUserLogRequestVO.getSearchDmRegTo());
        searchParams.put("searchDsPgmId", stUserLogRequestVO.getSearchDsPgmId());
        searchParams.put("searchCdUserAction", stUserLogRequestVO.getSearchCdUserAction());
  
        return searchParams;
    }
    
    
    /**
     * insertStUserLog
     *
     * @param VO
     * @throws Exception
     */
    public void insertStUserLog(StUserLogRequestVO VO) throws Exception {
        logger.debug("Call StUserLogService insertStUserLog...");
        stUserLogDAO.insertStUserLog(VO);
    }

}
