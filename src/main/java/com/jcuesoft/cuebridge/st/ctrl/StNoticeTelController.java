package com.jcuesoft.cuebridge.st.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.st.service.StNoticeTelService;
import com.jcuesoft.cuebridge.st.vo.StNoticeTelRequestVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class StNoticeTelController extends BaseController {
    
    @Autowired
    private StNoticeTelService stNoticeTelService;
    
    @RequestMapping("/st/noticetel/insert")
    public ModelAndView insertStNoticeTel(HttpServletRequest request, HttpServletResponse response, StNoticeTelRequestVO stNoticeTelRequestVO) throws Exception {
        logger.debug("Call StNoticeController insertStNoticeTel...");
        
        stNoticeTelRequestVO.setIdReg(CommonSessionUtil.getIdUser());        
        stNoticeTelService.insertStNoticeTel(stNoticeTelRequestVO);
        String referer = request.getHeader("Referer");
        referer = "redirect:"+ referer;
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "등록되었습니다");
        modelAndView.setViewName(referer);
        return modelAndView;
    }

}
