package com.jcuesoft.cuebridge.web.support;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//@Aspect
@ControllerAdvice
public class WebExceptionHandler {

    /*private static final Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);*/
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "SQLException occured")
    @ExceptionHandler(SQLException.class)
    public String handleSQLException(HttpServletRequest request, Exception ex) {
        logger.info("SQLException Occured:: URL=" + request.getRequestURL());
        return "database_error";
    }

    // validator exception
    // TODO

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IOException occured")
    @ExceptionHandler(value = IOException.class)
    public void handleIOException() {
        logger.error("IOException handler executed");
        // returning 404 error code
    }

    /*
     * @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Exception occured")
     * 
     * @ExceptionHandler(Exception.class) public ModelAndView exception(Exception exception, WebRequest request) { ModelAndView modelAndView
     * = new ModelAndView("error/general"); modelAndView.addObject("errorMessage", Throwables.getRootCause(exception)); return modelAndView;
     * }
     */
}