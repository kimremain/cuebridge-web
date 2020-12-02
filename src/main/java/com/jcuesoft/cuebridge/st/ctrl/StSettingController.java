package com.jcuesoft.cuebridge.st.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.st.service.StSettingService;
import com.jcuesoft.cuebridge.st.vo.StSettingRequestVO;
import com.jcuesoft.cuebridge.st.vo.StSettingResponseVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class StSettingController extends BaseController {

    /**
     * StCustomerService
     */
    @Autowired
    private StSettingService stSettingService;

    /**
     * 시스템 주요설정 ST06
     *
     * @param request
     * @param response
     */
    @RequestMapping("/st/setting/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response, StSettingRequestVO stSettingRequestVO)
            throws Exception {
        
        // 로그인 & 권한체크
        /*super.LoginCheck(request,response);*/
        
        ModelAndView modelAndView = new ModelAndView();

        StSettingResponseVO setting = stSettingService.getSettingOne(stSettingRequestVO);
        modelAndView.addObject("setting", setting);
        modelAndView.setViewName("/st/stSettingV.tiles");
        return modelAndView;
    }

    /**
     * 거래처 수정
     * 
     * @param request
     * @param response
     * @param stCustomerRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/setting/update", method = RequestMethod.POST)
    public ModelAndView modifyCustomer(HttpServletRequest request, HttpServletResponse response, StSettingRequestVO stSettingRequestVO)
            throws Exception {
        stSettingService.updateSetting(stSettingRequestVO);
        return new ModelAndView("redirect:/st/setting/select");
    }
}