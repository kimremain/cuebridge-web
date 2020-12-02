package com.jcuesoft.cuebridge.st.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.st.service.StPermissionService;
import com.jcuesoft.cuebridge.st.service.StUserService;
import com.jcuesoft.cuebridge.st.vo.StPermissionRequestVO;
import com.jcuesoft.cuebridge.st.vo.StPermissionResponseVO;
import com.jcuesoft.cuebridge.st.vo.StUserRequestVO;
import com.jcuesoft.cuebridge.st.vo.StUserResponseVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class StPermissionController extends BaseController {

    @Autowired
    private StUserService stUserService;

    @Autowired
    private StPermissionService stPermissionService;
    /**
     * commonSearchService
     */
    @Autowired
    private CommonCacheService commonCacheService;

    /**
     * 사용자 권한관리 ST02
     *
     * @param request
     * @param response
     */
    @RequestMapping("/st/permission/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response, StPermissionRequestVO stPermissionRequestVO,
            StUserRequestVO stUserRequestVO) throws Exception {

        // 로그인 & 권한체크
        /*super.LoginCheck(request, response);*/

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("teamList", commonCacheService.getStTeamList()); // 팀

        // 사용자 리스트
        List<StUserResponseVO> userList = stUserService.getStUserList(stUserRequestVO);
        modelAndView.addObject("requestVO", stUserRequestVO);
        modelAndView.addObject("userList", userList);

        // 사용자를 선택한경우
        if (stPermissionRequestVO.getSelectIdUser() != null) {

            List<StPermissionResponseVO> permissionList = stPermissionService.getUserPermissionList(stPermissionRequestVO);
            modelAndView.addObject("permissionList", permissionList);
        }

        modelAndView.setViewName("/st/stPermissionV.tiles");
        return modelAndView;

    }
    
    @RequestMapping(value = "/st/permission/update", method = RequestMethod.POST  , produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody HashMap<String, String>  updatePermission(HttpServletRequest request, HttpServletResponse response, StPermissionRequestVO stPermissionRequestVO,
            StUserRequestVO stUserRequestVO)
            throws Exception {
        
        HashMap<String, String> result = new HashMap<String, String>();
        try{
            stPermissionService.updatePermission(stPermissionRequestVO);
            result.put("result", "success");
        }catch(Exception e){
            //에러처리
            result.put("result", "fail");
            result.put("message", e.getMessage());
        }           
        return result;
    }
        
/*
    @RequestMapping("/st/permission/update")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response, StPermissionRequestVO stPermissionRequestVO,
            StUserRequestVO stUserRequestVO) throws Exception {

        logger.debug("@@@"+stUserRequestVO);
        stPermissionService.updatePermission(stPermissionRequestVO);
        
        CommonUtil  commonUtil = new CommonUtil();
        String params = "?selectIdUser=" + stPermissionRequestVO.getSelectIdUser() + "&searchCdTeam=" + stUserRequestVO.getSearchCdTeam()
                + "&searchIdUser=" + stUserRequestVO.getSearchIdUser() + "&searchNmUser=" +commonUtil.urlEncode(stUserRequestVO.getSearchNmUser());
        
        logger.debug("@@@params"+params);
        return new ModelAndView("redirect:/st/permission/select" + params + "#" + stPermissionRequestVO.getSelectIdUser());

    }
*/
}