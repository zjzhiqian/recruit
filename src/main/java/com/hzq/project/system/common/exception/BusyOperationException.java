package com.hzq.project.system.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BusyOperationException
 * Created by hzq on 16/9/20.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusyOperationException extends RuntimeException {
    public BusyOperationException(String msg) {
        super(msg);
    }
}