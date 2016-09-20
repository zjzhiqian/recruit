package com.hzq.project.user.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * LogInVo
 * Created by hzq on 16/9/20.
 */
public class LogInVo {

    @NotNull(message = "登录类型不能为空")
    private Integer type;

    @Length(message = "登录名必须在3~6位之间")
    @NotEmpty(message = "登录名不能为空")
    private String userName;

    @Length(min = 6,max = 15,message = "密码必须在6~15位之间")
    @NotNull(message = "密码不能为空")
    private String password;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
