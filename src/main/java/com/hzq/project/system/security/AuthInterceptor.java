package com.hzq.project.system.security;

import com.alibaba.fastjson.JSON;
import com.hzq.project.system.common.entity.UserInfo;
import com.hzq.project.system.common.redis.RedisHelper;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 拦截器
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
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

//        String uri = request.getRequestURI();
        // 如果是请求Token 则不进行拦截
//        if (uri.contains("/auth/token")) {
//            return true;
//        }
        return true;
    }


}