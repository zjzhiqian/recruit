package com.hzq.project.car.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hzq on 16/9/22.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CarMerchantException extends RuntimeException {

    public CarMerchantException() {
        this("请求参数不合法");
    }

    public CarMerchantException(String msg) {
        super(msg);
    }

}
