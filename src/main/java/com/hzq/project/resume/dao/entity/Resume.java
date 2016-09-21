package com.hzq.project.resume.dao.entity;

import java.util.Date;

public class Resume {
    private Integer id;

    private Integer userId;

    private String title;

    private Integer type;

    private String picture;

    private String name;

    private String sex;

    private String birthYear;

    private String birthDate;

    private String workYear;

    private String education;

    private Integer workArea;

    private String detailArea;

    private Integer salary;

    private String phone;

    private String email;

    private String address;

    private String introduction;

    private String concactName;

    private String concactPhone;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Integer watch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getWorkArea() {
        return workArea;
    }

    public void setWorkArea(Integer workArea) {
        this.workArea = workArea;
    }

    public String getDetailArea() {
        return detailArea;
    }

    public void setDetailArea(String detailArea) {
        this.detailArea = detailArea;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getConcactName() {
        return concactName;
    }

    public void setConcactName(String concactName) {
        this.concactName = concactName;
    }

    public String getConcactPhone() {
        return concactPhone;
    }

    public void setConcactPhone(String concactPhone) {
        this.concactPhone = concactPhone;
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

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getWatch() {
        return watch;
    }

    public void setWatch(Integer watch) {
        this.watch = watch;
    }
}