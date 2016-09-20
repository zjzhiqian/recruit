package com.hzq.project.security;

import com.hzq.project.security.annon.RequiresRoles;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 用于支持方法注解权限校验
 * Created by hzq on 16/8/3.
 */
@Component
public class AuthorizationAdvisor extends StaticMethodMatcherPointcutAdvisor {

    @SuppressWarnings("all")
    private static final Class<? extends Annotation>[] AUTH = new Class[]{RequiresRoles.class};


    public AuthorizationAdvisor() {
        setAdvice(new BeforeMethodInterceptor());
    }

    @Override
    public boolean matches(Method m, Class<?> clazz) {
        return Arrays.stream(AUTH)
                .anyMatch(annotation -> AnnotationUtils.findAnnotation(clazz, annotation) != null
                        || AnnotationUtils.findAnnotation(m, annotation) != null);

    }
}
