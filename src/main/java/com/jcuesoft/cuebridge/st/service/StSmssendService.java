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
import com.jcuesoft.cuebridge.st.dao.StSmssendDAO;
import com.jcuesoft.cuebridge.st.vo.StSmssendRequestVO;
import com.jcuesoft.cuebridge.st.vo.StSmssendResponseVO;

@Service
public class StSmssendService extends BaseService {

    @Autowired
    private StSmssendDAO stSmssendDAO;

    /*
     * getPageList
     * 
     * @param StUserLogRequestVO
     * @return List<StUserLogResponseVO>
     * @throws Exception
     */
    public List<StSmssendResponseVO> getStSmssendList(StSmssendRequestVO stSmssendRequestVO) throws Exception {
   
            
        Map<String, String> searchParams = this.getSmssendSearchParam(stSmssendRequestVO);
        List<StSmssendResponseVO> tmpList = stSmssendDAO.getStSmssendList(searchParams);
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
    public PageList<StSmssendResponseVO> getStSmssendList(StSmssendRequestVO stSmssendRequestVO, PageBounds pageBounds) throws Exception {
        
        Map<String, String> searchParams = this.getSmssendSearchParam(stSmssendRequestVO);
        PageList<StSmssendResponseVO> pageList = (PageList<StSmssendResponseVO>)  stSmssendDAO.getStSmssendList(searchParams, pageBounds);

        return pageList;
    }

    public Map<String, String> getSmssendSearchParam(StSmssendRequestVO stSmssendRequestVO) throws Exception {
        
        if(stSmssendRequestVO.getSearchDmRegFrom() == null && stSmssendRequestVO.getSearchDmRegTo() == null ){
            Date today = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            stSmssendRequestVO.setSearchDmRegFrom(simpleDateFormat.format(today));
            stSmssendRequestVO.setSearchDmRegTo(simpleDateFormat.format(today));
        }

        Map<String, String> searchParams = new HashMap<String, String>();
        searchParams.put("searchIdReg", stSmssendRequestVO.getSearchIdReg());
        searchParams.put("searchDmRegFrom", stSmssendRequestVO.getSearchDmRegFrom());
        searchParams.put("searchDmRegTo", stSmssendRequestVO.getSearchDmRegTo());
        searchParams.put("searchNoReq", stSmssendRequestVO.getSearchNoReq());
        searchParams.put("searchNoRcv", stSmssendRequestVO.getSearchNoRcv());

        return searchParams;
    }
    

}
