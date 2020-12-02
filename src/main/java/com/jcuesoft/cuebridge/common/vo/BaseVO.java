package com.jcuesoft.cuebridge.common.vo;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class BaseVO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Map<String, String> errors;

    /*protected Logger logger = LoggerFactory.getLogger(this.getClass());*/
    final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(final Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public Map<String, String> setErrors(BindingResult result) {

        Map<String, String> errorMap = new HashMap<String, String>();

        if (result.hasFieldErrors()) {
            List<FieldError> errors = result.getFieldErrors();

            for (FieldError error : errors) {
                errorMap.put(error.getField(), error.getDefaultMessage());

                if (logger.isDebugEnabled()) {
                    logger.debug("@@@ error message:" + error.getField());
                    logger.debug("@@@ error message:" + error.getDefaultMessage());
                    logger.debug("@@@ error getCode:" + error.getCode());
                    logger.debug("@@@ error getObjectName:" + error.getObjectName());
                    logger.debug("@@@ error toString:" + error.toString());
                }
            }
        } else {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                errorMap.put(error.getCode(), error.getDefaultMessage());

                if (logger.isDebugEnabled()) {
                    logger.debug("@@@ error message:" + error.getDefaultMessage());
                    logger.debug("@@@ error getCode:" + error.getCode());
                    logger.debug("@@@ error getObjectName:" + error.getObjectName());
                    logger.debug("@@@ error toString:" + error.toString());
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("errorMap:" + errorMap.toString());
        }

        this.errors = errorMap;
        return getErrors();
    }

    public Map<String, String> getErrors() {
        return this.errors;
    }
    
    public Map<String, String> setError(Exception e){
        
        Map<String, String> errorMap = new HashMap<String, String>();
        errorMap.put(String.valueOf(e.hashCode()), e.getMessage());
        
        e.printStackTrace();
        if (logger.isDebugEnabled()) {
            logger.debug("@@@ error message:" + e.getMessage());
            logger.debug("@@@ error hashCode:" + e.hashCode());
        }
        
        this.errors = errorMap;
        return getErrors();
    }
    
    public Map<String, String> getError() {
        return this.errors;
    }
    
}
