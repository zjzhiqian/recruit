package com.hzq.project.system.security.handler;

import com.hzq.project.system.security.annon.RequiresRoles;
import com.hzq.project.system.security.exception.MethodNotAllowedException;
import com.hzq.project.system.common.entity.UserInfo;
import com.hzq.project.system.security.util.Roles;
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
        if (!(a instanceof RequiresRoles)) return;
        RequiresRoles annotation = (RequiresRoles) a;
        String message = "您未登录,请前往登录";
        if (userInfo == null)
            throw new MethodNotAllowedException("您未登录,请前往登录");
        String[] roles = annotation.value();
        if (roles.length == 1) {
            if (roles[0].equals(Roles.COMPANY))
                message = "只有已登录企业才能进行此操作";
            if (roles[0].equals(Roles.USER))
                message = "只有已登录用户(非企业)才能进行此操作";
        }
        final Integer ownRoles = userInfo.getUserType();
        if (Arrays.stream(roles).noneMatch(role -> role.equals(ownRoles.toString())))
            throw new MethodNotAllowedException(message);
    }
}
