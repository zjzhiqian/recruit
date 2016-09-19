package com.hzq.project.system.common.web;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ReturnValueConverterAdvice implements ResponseBodyAdvice {

    public final boolean supports(final MethodParameter returnType, final Class converterType) {
        return true;
    }


    public final Object beforeBodyWrite(final Object body, final MethodParameter returnType, final MediaType selectedContentType, final Class selectedConverterType, final ServerHttpRequest request, final ServerHttpResponse response) {
        if (null == body)
            return new ReturnValue(true, null);
        else if (body instanceof ReturnValue)
            return body;
        else if (body instanceof ErrorResult)
            return new ReturnValue(false, body);
        else
            return new ReturnValue(true, body);
    }
}
