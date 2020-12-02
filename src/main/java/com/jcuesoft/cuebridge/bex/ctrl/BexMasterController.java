package com.jcuesoft.cuebridge.bex.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.bex.service.BexContactService;
import com.jcuesoft.cuebridge.bex.service.BexMasterService;
import com.jcuesoft.cuebridge.bex.vo.BexContactRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexContactResponseVO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterResponseVO;
import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;


@Controller
public class BexMasterController extends BaseController {
    
    /**
     * bexMasterService
     */
    @Autowired
    private BexMasterService bexMasterService;
    
    @Autowired
    private BexContactService bexContactService;
    
    /**
     * commonSearchService
     */
    @Autowired
    private CommonCacheService commonCacheService;

    
    /**
     * 대출심사 전체내역 BEX01
     *
     * @param request
     * @param response
     */
    @RequestMapping("/bex/master/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response,BexMasterRequestVO bexMasterRequestVO) throws Exception {
        
        // 로그인 & 권한체크
        /*super.LoginCheck(request,response);*/
        
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.addObject("code703", commonCacheService.getStCodeList("703")); //거래처
        modelAndView.addObject("code704", commonCacheService.getStCodeList("704")); //접수경로
        
        List<BexMasterResponseVO> masterList = bexMasterService.getExListAll(bexMasterRequestVO); 
        
        modelAndView.addObject("masterList", masterList);
        modelAndView.addObject("requestVO", bexMasterRequestVO);
        modelAndView.setViewName("/bex/bexMasterV.tiles");
        return modelAndView;

    }
    
    /**
     * 심사메모내역 팝업
     *
     * @param request
     * @param response
     */
    @RequestMapping("/bex/contact/select")
    public ModelAndView contactView(HttpServletRequest request, HttpServletResponse response,BexContactRequestVO bexContactRequestVO) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
         
        List<BexContactResponseVO> contactList = bexContactService.getExContact(bexContactRequestVO); 
        
        modelAndView.addObject("contactList", contactList);
        modelAndView.setViewName("/bex/bexContactPop.pop");
        return modelAndView;

    }
}