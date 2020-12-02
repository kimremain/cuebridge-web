package com.jcuesoft.cuebridge.common.service;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcuesoft.cuebridge.common.module.CommonJPAUtil;
import com.jcuesoft.cuebridge.common.module.CommonUtil;

public class BaseService {

    /*protected Logger logger = LoggerFactory.getLogger(this.getClass());*/
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    protected static CommonUtil commonUtil = new CommonUtil();
    
    protected static CommonJPAUtil commonJPAUtil = new CommonJPAUtil();

}
