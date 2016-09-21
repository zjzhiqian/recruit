package com.hzq.project.system.common.entity;

/**
 * CookieInfo
 * Created by hzq on 16/9/20.
 */
public class CookieInfo {

    private String userName;
    private Integer userType;


    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
