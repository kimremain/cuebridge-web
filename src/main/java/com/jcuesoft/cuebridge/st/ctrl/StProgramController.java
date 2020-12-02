package com.jcuesoft.cuebridge.st.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.st.service.StProgramService;
import com.jcuesoft.cuebridge.st.vo.StProgramRequestVO;
import com.jcuesoft.cuebridge.st.vo.StProgramResponseVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class StProgramController extends BaseController {
    /**
     * StProgramService
     */
    @Autowired
    private StProgramService stProgramService;

    /**
     * commonSearchService
     */
    @Autowired
    private CommonCacheService commonCacheService;

    /**
     * 프로그램 관리 ST07
     *
     * @param request
     * @param response
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/st/program/select")
    public ModelAndView programMain(HttpServletRequest request, HttpServletResponse response,
            ModelAndView mv,
            @ModelAttribute("requestVO") StProgramRequestVO stProgramRequestVO) throws Exception {
//              StProgramRequestVO stProgramRequestVO) throws Exception {
        
        StProgramRequestVO requestResultVO = (StProgramRequestVO) request.getAttribute("requestResultVO");
        
        if (logger.isDebugEnabled()) {
            logger.debug("Call StProgramController programMain...");
            logger.debug("attribute stProgramRequestVO.toString():" + requestResultVO);
        }

        // 로그인 & 권한체크
        /*super.LoginCheck(request, response);*/

        // list 조회
        List<StProgramResponseVO> list01 = stProgramService.getProgramList(stProgramRequestVO); // list조회
        mv.addObject("list01", list01);

        // 수정 폼 셋팅
        boolean isUpdate = (stProgramRequestVO.getNo() != null && !stProgramRequestVO.getNo().isEmpty());
        if (isUpdate) {
            StProgramResponseVO view01 = stProgramService.getProgramOne(stProgramRequestVO); // view조회
            mv.addObject("view01", view01);
        }

        mv.addObject("code702", commonCacheService.getStCodeList("702")); // 온라인배치구분코드
        mv.addObject("isUpdate", isUpdate);
        // modelAndView.addObject("requestVO", stProgramRequestVO);
        mv.setViewName("/st/stProgramV.tiles");
        return mv;
    }

    /**
     * 프로그램 관리 ST07 - Insert
     *
     * @param request
     * @param response
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     * @RequestMapping(value = "/st/program/insert", method =
     *                       RequestMethod.POST) public ModelAndView
     *                       insertProgram(HttpServletRequest request,
     *                       HttpServletResponse response, @Valid
     *                       StProgramRequestVO stProgramRequestVO,
     *                       BindingResult result) throws Exception {
     *                       logger.debug
     *                       ("Call StProgramController insertProgram...");
     * 
     *                       if (result.hasErrors()) { return new
     *                       ModelAndView("forward:/st/program/select?errMsg="
     *                       +result.toString()); } else {
     *                       stProgramService.insertProgram(stProgramRequestVO);
     *                       }
     * 
     *                       return new
     *                       ModelAndView("redirect:/st/program/select"); }
     */
    // Test
    @RequestMapping(value = "/st/program/insert", method = RequestMethod.POST)
    public ModelAndView insertProgram2(HttpServletRequest request, HttpServletResponse response, 
            ModelAndView mv,
            @Valid StProgramRequestVO stProgramRequestVO, BindingResult result) throws Exception {

        try {
            if (result.hasErrors()) {
                stProgramRequestVO.setErrors(result);
                
                if(logger.isDebugEnabled()){
                    logger.debug("@@@ has error stProgramRequestVO:"+stProgramRequestVO);
                }
                request.setAttribute("requestResultVO", stProgramRequestVO);
                mv.setViewName("forward:/st/program/select");
                return mv;
            }
            stProgramService.insertProgram(stProgramRequestVO);

        } catch (Exception e) {
            e.printStackTrace();
            
            stProgramRequestVO.setErrMsg(e.getMessage());
            request.setAttribute("requestResultVO", stProgramRequestVO);
//            mv.setViewName("forward:/st/program/select?errMsg=" + e.getMessage());
            mv.setViewName("forward:/st/program/select");
            return mv;
        }

        mv.setViewName("redirect:/st/program/select");
        return mv;
    }

    /**
     * 프로그램 관리 ST07 - Delete
     *
     * @param request
     * @param response
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/program/delete", method = RequestMethod.POST)
    public ModelAndView deleteProgram(HttpServletRequest request, HttpServletResponse response,
            ModelAndView mv,
            @ModelAttribute("requestVO") StProgramRequestVO stProgramRequestVO) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Call StProgramController deleteProgram...");
        }

        stProgramService.deleteProgram(stProgramRequestVO);

        mv.setViewName("redirect:/st/program/select");
        return mv;
    }

    /**
     * 프로그램 관리 ST07 - Update
     *
     * @param request
     * @param response
     * @param stProgramRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/program/update", method = RequestMethod.POST)
    public ModelAndView updateProgram(HttpServletRequest request, HttpServletResponse response,
            ModelAndView mv,
            @ModelAttribute("requestVO") StProgramRequestVO stProgramRequestVO) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("Call StProgramController updateProgram...");
        }

        stProgramService.updateProgram(stProgramRequestVO);

        mv.setViewName("redirect:/st/program/select");
        return mv;
    }
}