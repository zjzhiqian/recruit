package com.hzq.project.system.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * UnauthorizedException
 * Created by hzq on 16/9/20.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }
}