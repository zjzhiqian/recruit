package com.hzq.project.system.common.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * GlobalExceptionController
 * Created by hzq on 16/9/19.
 */
@ControllerAdvice
public class GlobalExceptionController {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public final ErrorResult handleException(HttpServletRequest request, Exception e) {
        int code = 500;
        String message = "服务器开了小差,请稍后重试.";
        ResponseStatus status = e.getClass().getAnnotation(ResponseStatus.class);
        if (status != null) {
            code = status.value().value();
            if (!StringUtils.isEmpty(status.reason())) {
                message = status.reason();
            } else if (!StringUtils.isEmpty(e.getLocalizedMessage())) {
                message = e.getLocalizedMessage();
            }
        }
        if (code >= 500) {
            StringBuilder messageBuilder = new StringBuilder("Unhandled exception in request:\n");
            messageBuilder.append(request.getMethod());
            messageBuilder.append(" ");
            messageBuilder.append(request.getRequestURI());
            messageBuilder.append("\nHeader:");
            request.getClass();
            EnumerationUtils.toIterable(request::getHeaderNames).forEach((name) -> {
                messageBuilder.append("\n");
                String value = request.getHeader(name);
                messageBuilder.append(name);
                messageBuilder.append(": ");
                messageBuilder.append(value);
            });
            this.logger.error(messageBuilder.toString(), e);
        }
        return new ErrorResult(code, message);
    }
}
