package com.hzq.project.resume.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hzq on 16/9/22.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecruitmentException extends RuntimeException {

    public RecruitmentException() {
        this("请求参数不合法");
    }

    public RecruitmentException(String msg) {
        super(msg);
    }

}
