package com.hzq.project.system.common.util;

import com.hzq.project.system.common.exception.DataBindException;
import org.springframework.validation.BindingResult;

/**
 * ValidatorHelper
 * Created by hzq on 16/8/3.
 */
public class ValidatorHelper {

    /**
     * BindingResult参数校验
     * @param bindingResult bindingResult
     */
    public static void validBindingResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataBindException(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
    }
}
