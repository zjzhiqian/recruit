package com.hzq.project.user.dao.entity;

import java.util.Date;

public class Favor {
    private Integer id;

    private String userId;

    private String url;

    private String title;

    private Integer type;

    private Integer isFavor;

    private Integer favorId;

    private Integer userType;

    private Date createdAt;

    private Date updatedAt;


    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsFavor() {
        return isFavor;
    }

    public void setIsFavor(Integer isFavor) {
        this.isFavor = isFavor;
    }

    public Integer getFavorId() {
        return favorId;
    }

    public void setFavorId(Integer favorId) {
        this.favorId = favorId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}