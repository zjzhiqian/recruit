package com.hzq.project.system.common.web;

/**
 * ErrorResult
 * Created by hzq on 16/9/19.
 */
public class ErrorResult {

    private int code;
    private String error;

    ErrorResult(int code, String error) {
        this.code = code;
        this.error = error;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
