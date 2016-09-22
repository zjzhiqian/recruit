package com.hzq.project.system.security;

import com.hzq.project.system.security.annon.RequiresRoles;
import com.hzq.project.system.security.exception.MethodNotAllowedException;
import com.hzq.project.system.security.handler.RoleAnnotationHandler;
import com.hzq.project.system.common.entity.UserInfo;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 角色校验拦截器,分为 运营角色,分销商角色
 * Created by hzq on 16/8/3.
 */
@Component
public class BeforeMethodInterceptor implements MethodBeforeAdvice {

    private static RoleAnnotationHandler roleAnnotationHandler;

    @Autowired
    private void setBeforeMethodInterceptor(RoleAnnotationHandler roleAnnotationHandler) {
        BeforeMethodInterceptor.roleAnnotationHandler = roleAnnotationHandler;
    }


    private static final Logger logger = LoggerFactory.getLogger(BeforeMethodInterceptor.class);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            UserInfo subject = (UserInfo) requestAttributes.getAttribute("subject", RequestAttributes.SCOPE_REQUEST);
            Annotation[] methodAnnotations = method.getAnnotations();
            Annotation[] clazzAnnotations = target.getClass().getAnnotations();
            Annotation[] annotations = ArrayUtils.addAll(methodAnnotations, clazzAnnotations);
            //RequireRoles注解 角色权限校验
            List<Annotation> roleAnnotations = Arrays.stream(annotations)
                    .filter(annotation -> annotation.annotationType() == RequiresRoles.class)
                    .collect(toList());
            roleAnnotations.forEach(annotation -> roleAnnotationHandler.assertAuthorized(annotation, subject));
        } catch (Exception e) {
            logger.error("校验权限异常{}", e);
            throw new MethodNotAllowedException("您未登录,请前往登录");
        }
    }

}