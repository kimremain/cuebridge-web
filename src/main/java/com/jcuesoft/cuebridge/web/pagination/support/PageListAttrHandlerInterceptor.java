package com.jcuesoft.cuebridge.web.pagination.support;

import java.lang.invoke.MethodHandles;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jcuesoft.cuebridge.common.pagination.PageList;

/**
 */
public class PageListAttrHandlerInterceptor extends HandlerInterceptorAdapter {

    /*private Logger logger = LoggerFactory.getLogger(this.getClass());*/
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
            throws Exception {
        Enumeration enumeration = request.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            Object element = enumeration.nextElement();
            if (element instanceof String) {
                String name = (String) element;
                Object attr = request.getAttribute(name);
                if (attr instanceof PageList) {
                    PageList pageList = (PageList) attr;
                    request.setAttribute(name + "Paginator", pageList.getPaginator());
                }
            }
        }

        if (modelAndView != null) {
            try {
                Map<String, Object> model = new HashMap<String, Object>(modelAndView.getModel());

                String key = "";
                for (Map.Entry<String, Object> item : model.entrySet()) {
                    Object attr = item.getValue();
                    if (attr instanceof PageList) {
                        PageList pageList = (PageList) attr;
                        key = item.getKey() + "Paginator";

                        modelAndView.addObject(key, pageList.getPaginator());

                        if (logger.isDebugEnabled()) {
                            logger.debug(key + ":" + pageList.getPaginator());
                        }
                    }
                }
            } catch (ConcurrentModificationException cme) {
                if (logger.isErrorEnabled()) {
                    logger.error("Update random pattern thread. ");
                    cme.printStackTrace();
                }
            }
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, Exception e)
            throws Exception {

    }
}
