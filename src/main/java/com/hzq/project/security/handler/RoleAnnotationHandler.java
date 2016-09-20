package com.hzq.project.security.handler;

import com.hzq.project.security.annon.RequiresRoles;
import com.hzq.project.security.exception.MethodNotAllowedException;
import com.hzq.project.system.common.entity.UserInfo;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * Role权限校验Handler
 * Created by hzq on 16/8/3.
 */
@Component
public class RoleAnnotationHandler implements AuthorizingAnnotationHandler {

    @Override
    public void assertAuthorized(Annotation a, UserInfo userInfo) {
//        if (!(a instanceof RequiresRoles)) return;
//        RequiresRoles annotation = (RequiresRoles) a;
//        String[] roles = annotation.value();
//        final String[] ownRoles = subject.getRoles();
//        Arrays.stream(roles).forEach(role -> {
//            if (!ArrayUtils.contains(ownRoles, role))
//                throw new MethodNotAllowedException("无权访问方法");
//        });
    }
}
