package com.hzq.project.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * UserException
 * Created by hzq on 16/9/19.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FavorException extends RuntimeException {
    public FavorException(){
        this("请求参数不合法");
    }

    public FavorException(String msg){
        super(msg);
    }

}
