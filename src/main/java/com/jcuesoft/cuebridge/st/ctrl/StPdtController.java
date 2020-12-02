package com.jcuesoft.cuebridge.st.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.st.service.StPdtService;
import com.jcuesoft.cuebridge.st.vo.StPdtRequestVO;
import com.jcuesoft.cuebridge.st.vo.StPdtResponseVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class StPdtController extends BaseController {

    /**
     * StPdtService
     */
    @Autowired
    private StPdtService stPdtService;
    
    /**
     * commonSearchService
     */
    @Autowired
    private CommonCacheService commonCacheService;
    /**
     * 대출과목 관리 ST08
     *
     * @param request
     * @param response
     * @param stPdtRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/st/pdt/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response, 
            @ModelAttribute("brcLoanAllRequestVO") StPdtRequestVO stPdtRequestVO,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "15") int limit
            ) throws Exception {

        // 로그인 & 권한체크
        /*super.LoginCheck(request,response);*/
        
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.addObject("code113", commonCacheService.getStCodeList("113")); //상환방법    
        modelAndView.addObject("code703", commonCacheService.getStCodeList("703")); //거래처코드
        modelAndView.addObject("code720", commonCacheService.getStCodeList("720")); //영업분류코드
        
        // list 조회
        PageBounds pageBounds = new PageBounds(page, limit);
        PageList<StPdtResponseVO> pageList = stPdtService.getStPdtList(stPdtRequestVO, pageBounds);

        modelAndView.addObject("pageList", pageList);

        // 수정 폼 셋팅
        boolean isUpdate = (stPdtRequestVO.getNo() != null);
        if (isUpdate) {
            StPdtResponseVO view = stPdtService.getStPdtOne(stPdtRequestVO);
            modelAndView.addObject("view", view);
        }

        modelAndView.addObject("requestVO", stPdtRequestVO);
        modelAndView.addObject("isUpdate", isUpdate);
        modelAndView.setViewName("/st/stPdtV.tiles");
        return modelAndView;

    }

    /**
     * 대출과목  저장
     *
     * @param request
     * @param response
     * @param stPdtRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/pdt/insert", method = RequestMethod.POST)
    public ModelAndView registPdt(HttpServletRequest request, HttpServletResponse response, ModelAndView mv,
            @Valid StPdtRequestVO stPdtRequestVO, BindingResult result)
            throws Exception {
        
        try {
            if (result.hasErrors()) {
                stPdtRequestVO.setErrors(result);
                request.setAttribute("requestResultVO", stPdtRequestVO);
                request.setAttribute("view", stPdtRequestVO);
                mv.setViewName("forward:/st/pdt/select");
                return mv;  
            }
            stPdtService.insertPdt(stPdtRequestVO);
        } catch (Exception e) {
            stPdtRequestVO.setError(e);
            request.setAttribute("requestResultVO", stPdtRequestVO);
            mv.setViewName("forward:/st/pdt/select");
            return mv;
        }
        mv.setViewName("redirect:/st/pdt/select");
        return mv;
    }

    /**
     * 대출과목  수정
     * 
     * @param request
     * @param response
     * @param stPdtRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/pdt/update", method = RequestMethod.POST)
    public ModelAndView modifyPdt(HttpServletRequest request, HttpServletResponse response, ModelAndView mv,
            @Valid StPdtRequestVO stPdtRequestVO, BindingResult result)
            throws Exception {
       
        try {
            if (result.hasErrors()) {
                stPdtRequestVO.setErrors(result);
                request.setAttribute("requestResultVO", stPdtRequestVO);
                mv.setViewName("forward:/st/pdt/select?no="+stPdtRequestVO.getNo());
                return mv;  
            }
            stPdtService.updatePdt(stPdtRequestVO);
        } catch (Exception e) {
            stPdtRequestVO.setError(e);
            request.setAttribute("requestResultVO", stPdtRequestVO);
            mv.setViewName("forward:/st/pdt/select?no="+stPdtRequestVO.getNo());
            return mv;
        }
        mv.setViewName("redirect:/st/pdt/select?no="+stPdtRequestVO.getNo());
        return mv;

    }

    /**
     * 대출과목  삭제
     * 
     * @param request
     * @param response
     * @param stPdtRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/pdt/delete", method = RequestMethod.POST)
    public ModelAndView removePdt(HttpServletRequest request, HttpServletResponse response, StPdtRequestVO stPdtRequestVO)
            throws Exception {
        stPdtService.deletePdt(stPdtRequestVO);
        return new ModelAndView("redirect:/st/pdt/select");
    }

}