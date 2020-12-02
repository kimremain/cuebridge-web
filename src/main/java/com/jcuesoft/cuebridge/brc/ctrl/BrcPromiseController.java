package com.jcuesoft.cuebridge.brc.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.brc.service.BrcContactService;
import com.jcuesoft.cuebridge.brc.service.BrcPromiseService;
import com.jcuesoft.cuebridge.brc.vo.BrcContactRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcContactResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcPromiseRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcPromiseResponseVO;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class BrcPromiseController extends BaseController {

    /**
     * brcLoanService
     */
    @Autowired
    private BrcPromiseService brcPromiseService;

    @Autowired
    private BrcContactService brcContactService;

    /**
     * commonSearchService
     */
    @Autowired
    private CommonCacheService commonCacheService;

    /**
     * 약속시간 접수건 리스트 BRC02
     *
     * @param request
     * @param response
     */
    @RequestMapping("/brc/promise/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response,
            BrcContactRequestVO brcContactRequestVO,
            BrcPromiseRequestVO brcPromiseRequestVO,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "25") int limit,
            @RequestParam(required = false, defaultValue = "name") String sort,
            @RequestParam(required = false, defaultValue = "asc") String dir
            )
            throws Exception {
        
        // 로그인 & 권한체크
        /*super.LoginCheck(request,response);*/
        
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.addObject("userCode", commonCacheService.getStUserListScreen()); //사용자 코드
        
        // 약속자리스트
        PageBounds pageBounds = new PageBounds(page, limit);
        PageList<BrcPromiseResponseVO> promiseList = brcPromiseService.getPromisePageList(brcPromiseRequestVO,pageBounds);
        modelAndView.addObject("pageList", promiseList);
        
        // 리스트 내  접수메모 이력조회
        if(brcPromiseRequestVO.getSearchContactNoReq() != ""){
            brcContactRequestVO.setSearchContactNoReq(brcPromiseRequestVO.getSearchContactNoReq().split(","));
            List<BrcContactResponseVO> contactList = brcContactService.getContactReqList(brcContactRequestVO);
            modelAndView.addObject("contactList", contactList);
        }
        
        modelAndView.addObject("requestVO", brcPromiseRequestVO);
        modelAndView.setViewName("/brc/brcPromiseV.tiles");
        return modelAndView;

    }
    
}