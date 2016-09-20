package com.hzq.project.security.handler;

import com.hzq.project.system.common.entity.UserInfo;
import com.zhaimi.supers.nami.security.entity.Subject;

import java.lang.annotation.Annotation;

/**
 * 根据Annotation校验权限接口
 * Created by hzq on 16/8/3.
 */
public interface AuthorizingAnnotationHandler {
    /**
     * 判断用户subject 拥有 注解a的权限
     * @param a 权限注解
     * @param userInfo 用户主体
     */
    void assertAuthorized(Annotation a, UserInfo userInfo);
}
