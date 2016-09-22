package com.hzq.project.user.web;

import com.alibaba.fastjson.JSON;
import com.hzq.project.system.security.util.AESUtil;
import com.hzq.project.system.common.entity.CookieInfo;
import com.hzq.project.system.common.entity.UserInfo;
import com.hzq.project.system.common.redis.RedisHelper;
import com.hzq.project.system.common.util.Creator;
import com.hzq.project.system.common.util.ValidatorHelper;
import com.hzq.project.system.common.web.BaseResult;
import com.hzq.project.user.dao.entity.Company;
import com.hzq.project.user.dao.entity.User;
import com.hzq.project.user.exception.UserException;
import com.hzq.project.user.service.CompanyService;
import com.hzq.project.user.service.UserService;
import com.hzq.project.user.vo.CompanyInfo;
import com.hzq.project.user.vo.CompanyVo;
import com.hzq.project.user.vo.LogInVo;
import com.hzq.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * UserController
 * Created by hzq on 16/9/19.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    /**
     * 注册用户
     */
    @RequestMapping(path = "/registerUser", method = RequestMethod.POST)
    public BaseResult registerUser(@Valid UserVo userVo, BindingResult bindingResult) {
        ValidatorHelper.validBindingResult(bindingResult);
        if (!userVo.getPassword().equals(userVo.getPassword2()))
            throw new UserException("抱歉,输入密码不一致");
        User user = Creator.newInstance(userVo, User.class);
        userService.addUser(user);
        return new BaseResult("注册用户成功");
    }


    /**
     * 注册企业
     */
    @RequestMapping(path = "/registerCompany", method = RequestMethod.POST)
    public BaseResult registerCompany(@Valid CompanyVo companyVo, BindingResult bindingResult) {
        ValidatorHelper.validBindingResult(bindingResult);
        if (!companyVo.getPassword().equals(companyVo.getPassword2()))
            throw new UserException("抱歉,输入密码不一致");
        Company company = Creator.newInstance(companyVo, Company.class);
        companyService.addCompany(company);
        return new BaseResult("注册企业成功");
    }


    /**
     * 获取企业详情
     */
    @RequestMapping(path = "/companyInfo/{id}", method = RequestMethod.GET)
    public CompanyInfo registerCompany(@PathVariable Integer id) {
        if (id == null)
            throw new UserException();
        return companyService.getCompanyInfoById(id);
    }


    /**
     * 登录
     */
    @RequestMapping(path = "/logIn", method = RequestMethod.POST)
    public BaseResult registerUser(@Valid LogInVo logInVo, BindingResult bindingResult, HttpServletResponse response) {
        ValidatorHelper.validBindingResult(bindingResult);
        Integer type = logInVo.getType();
        String userName = logInVo.getUserName();
        String password = logInVo.getPassword();

        UserInfo info;
        long time = System.currentTimeMillis();
        if (type == 1) {
            User user = userService.selectUserByUserName(userName);
            if (user == null || !password.equals(user.getPassword()))
                throw new UserException("账号或密码错误");
            info = Creator.newInstance(user, UserInfo.class);
        } else {
            Company company = companyService.selectCompanyByUserName(userName);
            if (company == null || !password.equals(company.getPassword()))
                throw new UserException("账号或密码错误");
            info = Creator.newInstance(company, UserInfo.class);
            type = 2;
        }
        info.setUserType(type);
        info.setLogInTime(time);
        String key = AESUtil.encrypt(userName, time);

        RedisHelper.set(key, JSON.toJSONString(info));
        RedisHelper.expire(key, 12 * 60 * 60);

        //权限cookie
        Cookie cookie = new Cookie("token", key);
        cookie.setMaxAge(3600 * 12);
        cookie.setPath("/");
        response.addCookie(cookie);

        //信息cookie
        CookieInfo cookieInfo = new CookieInfo();
        cookieInfo.setUserName(userName);
        cookieInfo.setUserType(type);
        Cookie cookie2 = new Cookie("info", JSON.toJSONString(cookieInfo));
        cookie2.setMaxAge(3600 * 12);
        cookie2.setPath("/");
        response.addCookie(cookie2);

        return new BaseResult("登录成功");
    }


}
