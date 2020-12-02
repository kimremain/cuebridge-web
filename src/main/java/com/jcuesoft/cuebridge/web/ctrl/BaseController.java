package com.jcuesoft.cuebridge.web.ctrl;

import java.lang.invoke.MethodHandles;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.jcuesoft.cuebridge.common.module.CommonUtil;
import com.jcuesoft.cuebridge.common.vo.ErrorVO;
import com.jcuesoft.cuebridge.st.vo.StUserLogRequestVO;
import com.jcuesoft.cuebridge.web.support.WebValidationException;

public class BaseController {
    
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    protected MappingJackson2JsonView jsonView = new MappingJackson2JsonView();

    protected static CommonUtil commonUtil = new CommonUtil();
    
    /*
     * 일반 에러에 대해서 json, html으로 에러를 보낸다.
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    // @RequestMapping(produces = { "application/xml", "application/json"})
    public ModelAndView handleException(Exception ex, HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.debug("++ @ExceptionHandler : Exception.class");
            logger.debug("++ @ExceptionHandler : req.getContentType():" + req.getContentType());
        }
        StUserLogRequestVO filterUserLogRequestVO = (StUserLogRequestVO) req.getAttribute("filterUserLogRequestVO");

        ModelAndView mv;
        ErrorVO errorVO = new ErrorVO(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex);
        errorVO.setException(ex);

        if (null != filterUserLogRequestVO) {
            errorVO.setAction(filterUserLogRequestVO.getDsUrl());
            errorVO.setCode(filterUserLogRequestVO.getCdUserAction());
        }

        String contentType = req.getContentType();

        if (null != contentType && contentType.contains("json")) {
            if (logger.isDebugEnabled()) {
                logger.debug("++ @ExceptionHandler : json");
            }

            mv = new ModelAndView(this.jsonView).addObject(errorVO);
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("++ @ExceptionHandler : html");
            }

            mv = new ModelAndView("/error/500").addObject(errorVO);
            mv.addObject(ex);
        }
        ex.printStackTrace();
        return mv;
    }

    /*
     * Spring Errors 객체를 포함해서 json, html에러를 보낸다.
     */
    @ExceptionHandler(NoSuchRequestHandlingMethodException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleNoSuchRequestHandlingMethodException(NoSuchRequestHandlingMethodException ex, HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.debug("++ @ExceptionHandler : NoSuchRequestHandlingMethodException.class");
        }
        StUserLogRequestVO filterUserLogRequestVO = (StUserLogRequestVO) req.getAttribute("filterUserLogRequestVO");

        ModelAndView mv;
        ErrorVO errorVO = new ErrorVO(HttpStatus.NOT_FOUND.toString(), ex);

        if (null != filterUserLogRequestVO) {
            errorVO.setAction(filterUserLogRequestVO.getDsUrl());
            errorVO.setCode(filterUserLogRequestVO.getCdUserAction());
        }

        String contentType = req.getContentType();

        if (null != contentType && contentType.contains("json")) {
            if (logger.isDebugEnabled()) {
                logger.debug("++ @ExceptionHandler : json");
            }

            mv = new ModelAndView(this.jsonView).addObject(errorVO);
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("++ @ExceptionHandler : html");
            }

            mv = new ModelAndView("/error/404").addObject(errorVO);
            mv.addObject(ex);
        }
        return mv;
    }

    /*
     * Spring Errors 객체를 포함해서 json, html 에러를 보낸다.
     */
    @ExceptionHandler(WebValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleWebValidationException(WebValidationException ex, HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.debug("++ @ExceptionHandler : WebValidationException.class");
        }

        StUserLogRequestVO stUserLogRequestVO = (StUserLogRequestVO) req.getAttribute("filterUserLogRequestVO");

        ModelAndView mv;
        ErrorVO errorVO = new ErrorVO(HttpStatus.BAD_REQUEST.toString(), ex);

        if (null != stUserLogRequestVO) {
            errorVO.setAction(stUserLogRequestVO.getDsUrl());
            errorVO.setCode(stUserLogRequestVO.getCdUserAction());
        }

        String contentType = req.getContentType();

        if (null != contentType && contentType.contains("json")) {
            if (logger.isDebugEnabled()) {
                logger.debug("++ @ExceptionHandler : json");
            }

            mv = new ModelAndView(this.jsonView).addObject(errorVO);
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("++ @ExceptionHandler : html");
            }

            mv = new ModelAndView("/error/400").addObject(errorVO);
            mv.addObject(ex);
        }

        ex.printStackTrace();
        return mv;
    }

}
