package com.hzq.project.system.common.web;

/**
 * BaseResult
 * Created by hzq on 16/9/19.
 */
public class BaseResult {

    private Object message;

    private Integer code = 200;

    public BaseResult(Object message) {
        this.message = message;
    }


    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
