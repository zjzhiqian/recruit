package com.hzq.project.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 退款售后单Exception
 * Created by hzq on 16/7/15.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AfterMarketOrderException extends RuntimeException {

    public AfterMarketOrderException(String msg){
        super(msg);


    }

}
