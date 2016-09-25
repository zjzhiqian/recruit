package com.hzq.project.picture.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BusyOperationException
 * Created by hzq on 16/9/20.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PictureException extends RuntimeException {
    public PictureException(String msg) {
        super(msg);
    }
}