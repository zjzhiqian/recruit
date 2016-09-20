package com.hzq.project.user.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * UserVo
 * Created by hzq on 16/9/20.
 */
public class UserVo {

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @Length(message = "登录名必须在3~6位之间")
    @NotEmpty(message = "登录名不能为空")
    private String userName;

    @Length(min = 6,max = 15,message = "密码必须在6~15位之间")
    @NotNull(message = "密码不能为空")
    private String password;

    @Length(min = 6,max = 15,message = "确认密码必须在6~15位之间")
    @NotNull(message = "确认密码不能为空")
    private String password2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
