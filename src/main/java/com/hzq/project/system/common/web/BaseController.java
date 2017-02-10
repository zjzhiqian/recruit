package com.hzq.project.system.common.web;

import com.hzq.project.system.common.entity.UserInfo;
import com.hzq.project.system.common.exception.UnauthorizedException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * BaseController
 * Created by hzq on 16/9/20.
 */
public class BaseController {


    /**
     * 获取用户Id
     */
    protected Integer getUserId() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        UserInfo userInfo = (UserInfo) requestAttributes.getAttribute("subject", RequestAttributes.SCOPE_REQUEST);
        if (userInfo == null)
            throw new UnauthorizedException("您未登录,请前往登录");
        if (userInfo.getUserType() != 1)
            throw new UnauthorizedException("非个人用户,操作失败");
        return userInfo.getId();
    }

    /**
     * 获取公司Id
     */
    protected Integer getCompanyId() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        UserInfo userInfo = (UserInfo) requestAttributes.getAttribute("subject", RequestAttributes.SCOPE_REQUEST);
        if (userInfo == null)
            throw new UnauthorizedException("您未登录,请前往登录");
        if (userInfo.getUserType() != 2)
            throw new UnauthorizedException("非企业用户,操作失败");
        return userInfo.getId();
    }


    protected Integer getUserType() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        UserInfo userInfo = (UserInfo) requestAttributes.getAttribute("subject", RequestAttributes.SCOPE_REQUEST);
        if (userInfo == null)
            throw new UnauthorizedException("您未登录,请前往登录");
        return userInfo.getUserType();
    }

    protected Integer getLogInId() {
        Integer type = getUserType();
        if (type == 2) return getCompanyId();
        if (type == 1) return getUserId();
        return null;
    }


}
