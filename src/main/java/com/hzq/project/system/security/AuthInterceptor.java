package com.hzq.project.system.security;

import com.alibaba.fastjson.JSON;
import com.hzq.project.system.common.entity.UserInfo;
import com.hzq.project.system.common.redis.RedisHelper;
import com.hzq.project.user.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

/**
 * 拦截器
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private SysParamService sysParamService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String uri = request.getRequestURI();
        // 如果是请求Token 则不进行拦截
//        if (uri.contains("/auth/token")) {
//            return true;
//        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            List<Cookie> authCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("token")).collect(toList());
            if (authCookie.size() > 0) {
                Cookie cookie = authCookie.get(0);
                String token = cookie.getValue();
                String userInfo = RedisHelper.get(token);
                if (userInfo != null) {
                    UserInfo userBean = JSON.parseObject(userInfo, UserInfo.class);
                    request.setAttribute("subject", userBean);
                }
            }
        }
        Random random = new Random();
        if (random.nextBoolean() && random.nextBoolean())
            sysParamService.addLogCount();
        return true;
    }


}