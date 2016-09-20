package com.hzq.project.system.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 参数绑定失败Exception
 * Created by hzq on 16/7/15.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataBindException extends RuntimeException {
    public DataBindException(String msg) {
        super(msg);
    }
}
