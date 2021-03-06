package com.hzq.project.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * UserException
 * Created by hzq on 16/9/19.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserException extends RuntimeException {
    public UserException(){
        this("请求参数不合法");
    }

    public UserException(String msg){
        super(msg);
    }

}
