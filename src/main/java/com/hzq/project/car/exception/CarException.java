package com.hzq.project.car.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hzq on 16/9/22.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CarException extends RuntimeException {

    public CarException() {
        this("请求参数不合法");
    }

    public CarException(String msg) {
        super(msg);
    }

}
