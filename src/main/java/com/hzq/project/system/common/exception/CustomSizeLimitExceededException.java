package com.hzq.project.system.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hzq on 16/9/24.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomSizeLimitExceededException extends RuntimeException {
    public CustomSizeLimitExceededException(String msg) {
        super(msg);
    }
}