package com.hzq.project.house.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hzq on 16/9/22.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HouseException extends RuntimeException {

    public HouseException() {
        this("请求参数不合法");
    }

    public HouseException(String msg) {
        super(msg);
    }

}
