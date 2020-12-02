package com.jcuesoft.cuebridge.brc.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.brc.service.BrcMisscallService;
import com.jcuesoft.cuebridge.brc.vo.BrcMisscallRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcMisscallResponseVO;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.pagination.Order;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class BrcMisscallController extends BaseController {

    @Autowired
    private BrcMisscallService brcMisscallService;

    /**
     * commonSearchService
     */
    @Autowired
    private CommonCacheService commonCacheService;

    /**
     * IVR 미스콜 조회
     *
     * @param request
     * @param response
     */
    @RequestMapping("/brc/misscall/select")
    public ModelAndView noticeTelMain(HttpServletRequest request, HttpServletResponse response,
            ModelAndView modelAndView,
            BrcMisscallRequestVO brcMisscallRequestVO,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "25") int limit,
            @RequestParam(required = false, defaultValue = "NO") String sort,
            @RequestParam(required = false, defaultValue = "DESC") String dir
            ) throws Exception {

        
        // 로그인 & 권한체크
        /*super.LoginCheck(request, response);*/
        
        if("history".equals(brcMisscallRequestVO.getSearchMode())){
            
            // 코드조회 
            modelAndView.addObject("code715", commonCacheService.getStCodeList("715")); //통화처리 구분코드 
            
            PageBounds pageBounds = new PageBounds(page, limit);
            pageBounds.getOrders().add(Order.create(sort, dir));
            
            PageList<BrcMisscallResponseVO> pageList = brcMisscallService.getMisscallHistoryList(brcMisscallRequestVO,pageBounds);
            modelAndView.addObject("pageList", pageList);
            modelAndView.addObject("requestVO", brcMisscallRequestVO);
            modelAndView.setViewName("/brc/brcMisscallHistory.tiles");
        }else{
            // 코드조회 
            modelAndView.addObject("code715", commonCacheService.getStCodeList("715")); //통화처리 구분코드 
            
            List<BrcMisscallResponseVO> misscallList = brcMisscallService.getMisscallList(brcMisscallRequestVO); 
            
            modelAndView.addObject("misscallList", misscallList);
            modelAndView.addObject("requestVO", brcMisscallRequestVO);
            modelAndView.setViewName("/brc/brcMisscallV.tiles");
        }
        
        return modelAndView;
    }
    
    
    /**
     * IVR 상태 일괄변경 
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/brc/misscall/updatebatch", method = RequestMethod.POST  , produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody HashMap<String, String>  updateLoanAll(HttpServletRequest request, HttpServletResponse response, 
            BrcMisscallRequestVO brcMisscallRequestVO)
            throws Exception {
        brcMisscallRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        HashMap<String, String> result = new HashMap<String, String>();
        try{
            brcMisscallService.updateBatchCdCallProc(brcMisscallRequestVO);
            result.put("result", "success");
        }catch(Exception e) {
            result.put("result", "fail");
            e.printStackTrace();
            result.put("message",  e.getMessage());
        }
        return result;

    }
    
    
}