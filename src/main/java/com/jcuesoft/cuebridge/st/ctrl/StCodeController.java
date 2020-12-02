package com.jcuesoft.cuebridge.st.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.st.service.StCodeService;
import com.jcuesoft.cuebridge.st.service.StGroupCodeService;
import com.jcuesoft.cuebridge.st.vo.StCodeRequestVO;
import com.jcuesoft.cuebridge.st.vo.StCodeResponseVO;
import com.jcuesoft.cuebridge.st.vo.StGroupCodeRequestVO;
import com.jcuesoft.cuebridge.st.vo.StGroupCodeResponseVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class StCodeController extends BaseController {

    /**
     * StCustomerService
     */
    @Autowired
    private StGroupCodeService stGroupCodeService;
    @Autowired
    private StCodeService stCodeService;

    /**
     * commonSearchService
     */
    @Autowired
    private CommonCacheService commonCacheService;

    /**
     * 코드관리 ST05
     *
     * @param request
     * @param response
     * @param stGroupCodeRequestVO
     */
    @RequestMapping("/st/code/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response, StGroupCodeRequestVO stGroupCodeRequestVO,
            StCodeRequestVO stCodeRequestVO) throws Exception {
               
        // 로그인 & 권한체크 
        /*super.LoginCheck(request,response);*/
        
        ModelAndView modelAndView = new ModelAndView();
        
        // 그룹코드 리스트
        List<StGroupCodeResponseVO> groupList = stGroupCodeService.getGroupCodeList(stGroupCodeRequestVO);
        modelAndView.addObject("groupList", groupList);

        // 자식코드 리스트
        boolean isCodeSearch = (stCodeRequestVO.getSearchGroupCode() != null);
        if (isCodeSearch) {
            List<StCodeResponseVO> codeList = stCodeService.getCodeList(stCodeRequestVO);
            modelAndView.addObject("codeList", codeList);
        }

        modelAndView.setViewName("/st/stCodeV.tiles");
        return modelAndView;

    }

    /**
     * 그룹코드 추가
     * 
     * @param request
     * @param response
     * @param stGroupCodeRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/groupcode/insert", method = RequestMethod.POST)
    public ModelAndView registGroupCode(HttpServletRequest request, HttpServletResponse response, ModelAndView mv,
            @Valid StGroupCodeRequestVO stGroupCodeRequestVO, BindingResult result ) throws Exception {
        
        try {
            if (result.hasErrors()) {
                stGroupCodeRequestVO.setErrors(result);
                request.setAttribute("groupCodeResultVO", stGroupCodeRequestVO);
                mv.setViewName("forward:/st/code/select");
                return mv;  
            }
            stGroupCodeService.insertGroupCode(stGroupCodeRequestVO);
        } catch (Exception e) {
            stGroupCodeRequestVO.setError(e);
            request.setAttribute("groupCodeResultVO", stGroupCodeRequestVO);
            mv.setViewName("forward:/st/code/select");
            return mv;
        }
        mv.setViewName("redirect:/st/code/select");
        return mv;
        
    }

    /**
     * 그룹코드명 수정
     * 
     * @param request
     * @param response
     * @param stGroupCodeRequestVO
     * @return
     * @throws Exception
    */
    @RequestMapping(value = "/st/groupcode/update", method = RequestMethod.POST)
    public ModelAndView modifyGroupCode(HttpServletRequest request, HttpServletResponse response, StGroupCodeRequestVO stGroupCodeRequestVO)
            throws Exception {
        stGroupCodeService.updateGroupCode(stGroupCodeRequestVO);
        return new ModelAndView("redirect:/st/code/select");
    } 

    /**
     * 자식코드 추가
     * 
     * @param request
     * @param response
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/code/insert", method = RequestMethod.POST)
    public ModelAndView registCode(HttpServletRequest request, HttpServletResponse response, ModelAndView mv,
            @Valid StCodeRequestVO stCodeRequestVO, BindingResult result )
            throws Exception {
        
        try {
            if (result.hasErrors()) {
                stCodeRequestVO.setErrors(result);
                request.setAttribute("requestResultVO", stCodeRequestVO);
                mv.setViewName("forward:/st/code/select?searchGroupCode=" + stCodeRequestVO.getCdGroup());
                return mv;  
            }
            stCodeService.insertCode(stCodeRequestVO);
            
        } catch (Exception e) {
            stCodeRequestVO.setError(e);
            request.setAttribute("requestResultVO", stCodeRequestVO);
            logger.debug("@@@@@@@@@@@@/st/code/select?searchGroupCode=" + stCodeRequestVO.getCdGroup());
            mv.setViewName("forward:/st/code/select?searchGroupCode=" + stCodeRequestVO.getCdGroup());
            return mv;
        }
        mv.setViewName("redirect:/st/code/select?searchGroupCode=" + stCodeRequestVO.getCdGroup());
        return mv;
        
        
        //stCodeService.insertCode(stCodeRequestVO);
        //return new ModelAndView("redirect:/st/code/select?searchGroupCode=" + stCodeRequestVO.getCdGroup());
    }

    /**
     * 그룹코드 자식코드 수정
     * 
     * @param request
     * @param response
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/code/update", method = RequestMethod.POST)
    public ModelAndView modifyCode(HttpServletRequest request, HttpServletResponse response, StCodeRequestVO stCodeRequestVO)
            throws Exception {
        stCodeService.updateCode(stCodeRequestVO);
        return new ModelAndView("redirect:/st/code/select?searchGroupCode=" + stCodeRequestVO.getCdGroup());
    }

    /**
     * 자식코드 순서 일괄변경
     * 
     * @param request
     * @param response
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/code/updatebatch", method = RequestMethod.POST)
    public ModelAndView modifyCodeOrder(HttpServletRequest request, HttpServletResponse response, StCodeRequestVO stCodeRequestVO)
            throws Exception {
        stCodeService.updateCodeOrder(stCodeRequestVO);
        return new ModelAndView("redirect:/st/code/select?searchGroupCode=" + stCodeRequestVO.getCdGroup());
    }

    /**
     * 자식코드 삭제
     * 
     * @param request
     * @param response
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/st/code/delete", method = RequestMethod.POST)
    public ModelAndView removeCode(HttpServletRequest request, HttpServletResponse response, StCodeRequestVO stCodeRequestVO)
            throws Exception {
        stCodeService.deleteCode(stCodeRequestVO);
        return new ModelAndView("redirect:/st/code/select?searchGroupCode=" + stCodeRequestVO.getCdGroup());
    }

   
}