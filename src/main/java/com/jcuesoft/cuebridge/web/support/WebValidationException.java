package com.jcuesoft.cuebridge.web.support;

import org.springframework.validation.Errors;

import com.jcuesoft.cuebridge.common.exception.UncheckedException;

public class WebValidationException extends UncheckedException {
    private static final long serialVersionUID = 1L;

    private Errors errors;

    public WebValidationException(Errors errors) {
        super();
        this.errors = errors;
    }
}
