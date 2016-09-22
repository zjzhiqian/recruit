package com.hzq.project.system.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * method不允许调用
 */
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowedException extends RuntimeException {

    public MethodNotAllowedException(String msg) {
        super(msg);
    }

}
