package com.jcuesoft.cuebridge.st.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.st.service.StUserService;
import com.jcuesoft.cuebridge.st.vo.StUserRequestVO;
import com.jcuesoft.cuebridge.st.vo.StUserResponseVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class StUserController extends BaseController{

    @Autowired
    private StUserService service;
    
    @Autowired
    private CommonCacheService commonCacheService;    
    /**
     * 사용자관리 ST01
     *
     * @param request
     * @param response
     */
    @RequestMapping("/st/user/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response, StUserRequestVO stUserRequestVO) throws Exception {
        
        // 로그인 & 권한체크
        /*super.LoginCheck(request,response);*/
        
        ModelAndView modelAndView = new ModelAndView();
        logger.info(stUserRequestVO.getSearchNmUser());
        logger.info(stUserRequestVO.getSearchCdTeam());
        
        // 초기검색조건
        if(stUserRequestVO.getSearchFlag() == null){
            stUserRequestVO.setSearchYnResign("N"); // 재직자
            stUserRequestVO.setSearchYnScreen("Y"); // 심사자인경우
        }
        
        List<StUserResponseVO> list = service.getStUserList(stUserRequestVO);
        
        boolean isUpdate = (stUserRequestVO.getSearchNo() != null);
        if(isUpdate){
            StUserResponseVO view = service.getStUserOne(stUserRequestVO);
            modelAndView.addObject("view", view);
        }
        
        modelAndView.addObject("teamList", commonCacheService.getStTeamList());       //팀
        //logger.info("팀", commonSearchService.getStTeamList());
        modelAndView.addObject("code701", commonCacheService.getStCodeList("701")); //담당업무코드
        modelAndView.addObject("code721", commonCacheService.getStCodeList("721")); //권한분류코드
        modelAndView.addObject("code133", commonCacheService.getStCodeList("133")); //직급코드
        modelAndView.addObject("code713", commonCacheService.getStCodeList("713")); //배정비율코드
        
        modelAndView.addObject("requestVO", stUserRequestVO);
        modelAndView.addObject("list", list);        
        modelAndView.setViewName("/st/stUserV.tiles");
        return modelAndView;

    }
    
    @RequestMapping(value = "/st/user/update", method = RequestMethod.POST)
    public ModelAndView updateStUserr(HttpServletRequest request, HttpServletResponse response, StUserRequestVO stUserRequestVO)
            throws Exception {
        service.updateStUser(stUserRequestVO);
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return new ModelAndView("redirect:/st/user/select?searchNo="+stUserRequestVO.getNo());
    }    
    
    
}