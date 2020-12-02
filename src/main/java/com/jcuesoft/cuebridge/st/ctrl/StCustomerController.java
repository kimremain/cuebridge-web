package com.jcuesoft.cuebridge.st.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.st.service.StCustomerService;
import com.jcuesoft.cuebridge.st.vo.StCustomerRequestVO;
import com.jcuesoft.cuebridge.st.vo.StCustomerResponseVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class StCustomerController extends BaseController {

    /**
     * StCustomerService
     */
    @Autowired
    private StCustomerService stCustomerService;

    /**
     * 거래처 관리 ST04
     *
     * @param request
     * @param response
     * @param stCustomerRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/st/customer/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response, StCustomerRequestVO stCustomerRequestVO)
            throws Exception {
        
        // 로그인 & 권한체크
        /*super.LoginCheck(request,response);*/
        
        ModelAndView modelAndView = new ModelAndView();

        // list 조회
        List<StCustomerResponseVO> list = stCustomerService.getStCustomerList(stCustomerRequestVO);
        modelAndView.addObject("list", list);

        // 수정 폼 셋팅
        boolean isUpdate = (stCustomerRequestVO.getNo() != null);
        if (isUpdate) {
            StCustomerResponseVO view01 = stCustomerService.getStCustomerOne(stCustomerRequestVO);
            modelAndView.addObject("view01", view01);
        }

        // modelAndView.addObject("requestVO", stCustomerRequestVO);
        modelAndView.addObject("isUpdate", isUpdate);
        modelAndView.setViewName("/st/stCustomerV.tiles");
        return modelAndView;

    }

    /**
     * 거래처 저장
     *
     * @param request
     * @param response
     * @param stCustomerRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/customer/insert", method = RequestMethod.POST)
    public ModelAndView registCustomer(HttpServletRequest request, HttpServletResponse response, StCustomerRequestVO stCustomerRequestVO)
            throws Exception {
        stCustomerService.insertCustomer(stCustomerRequestVO);
        return new ModelAndView("redirect:/st/customer/select");
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
    @RequestMapping(value = "/st/customer/update", method = RequestMethod.POST)
    public ModelAndView modifyCustomer(HttpServletRequest request, HttpServletResponse response, StCustomerRequestVO stCustomerRequestVO)
            throws Exception {
        stCustomerService.updateCustomer(stCustomerRequestVO);
        return new ModelAndView("redirect:/st/customer/select");
    }

    /**
     * 거래처 삭제
     * 
     * @param request
     * @param response
     * @param stCustomerRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/customer/delete", method = RequestMethod.POST)
    public ModelAndView removeCustomer(HttpServletRequest request, HttpServletResponse response, StCustomerRequestVO stCustomerRequestVO)
            throws Exception {
        stCustomerService.deleteCustomer(stCustomerRequestVO);
        return new ModelAndView("redirect:/st/customer/select");
    }

}