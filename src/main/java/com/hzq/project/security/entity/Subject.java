package com.hzq.project.security.entity;

/**
 * 储存用户权限信息的subject
 * Created by hzq on 16/8/3.
 */
public class Subject {

    private String roles[];


    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
