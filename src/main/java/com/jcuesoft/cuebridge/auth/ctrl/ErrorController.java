package com.jcuesoft.cuebridge.auth.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.web.ctrl.BaseController;


@Controller
public class ErrorController extends BaseController{
    
    /**
     * 403 에러페이지 
     *
     * @param request
     * @param response
     */
    @RequestMapping("/error/403/select")
    public ModelAndView forbiddenView(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //return
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error/403.tiles");
        return modelAndView;
    }
    
    /**
     * 404 에러페이지 
     *
     * @param request
     * @param response
     */
    @RequestMapping("/error/404/select")
    public ModelAndView notFoundView(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //return
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error/404.tiles");
        return modelAndView;
    }
    
    /**
     * expired
     *
     * @param request
     * @param response
     */
    @RequestMapping("/error/expired/select")
    public ModelAndView expiredView(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //return
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error/expired.tiles");
        return modelAndView;
    }    
}
