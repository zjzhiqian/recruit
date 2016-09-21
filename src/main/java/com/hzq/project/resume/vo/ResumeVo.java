package com.hzq.project.resume.vo;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * ResumeVo
 * Created by hzq on 16/9/20.
 */
public class ResumeVo {

    private Integer userId;


    @Length(min = 1,max = 80,message = "简历标题必须在1~80位之间")
    @NotEmpty(message = "简历标题不能为空")
    private String title;

    private Integer type;

    @Length(min = 1,max = 160,message = "照片url不合法,请联系管理员")
    @NotEmpty(message = "请上传照片")
    private String picture;

    @Length(min = 1,max = 50,message = "姓名长度必须在1~50位之间")
    @NotEmpty(message = "请输入姓名")
    private String name;

    private String sex;

    @Length(max = 50,message = "出生年份长度必须在0~50位之间")
    private String birthYear;

    @Length(max = 50,message = "出生月份长度必须在0~50位之间")
    private String birthDate;

    @NotNull(message = "工作年限不能为空")
    private String workYear;

    @NotNull(message = "学历不能为空")
    private String education;

    @NotNull(message = "工作地点不能为空")
    private Integer workArea;

    @Length(max = 50,message = "工作区域地点必须在0~50位之间")
    private String detailArea;

    @NotNull(message = "期望月薪不能为空")
    private Integer salary;

    @NotNull(message = "手机号不能为空")
    private String phone;

    @Length(min = 1,max = 50,message = "邮箱长度必须在1~50位之间")
    private String email;

    @Length(max = 50,message = "籍贯长度必须在0~50位之间")
    private String address;

    @Length(min = 1,max = 200,message = "自我介绍必须在1~200位之间")
    @NotNull(message = "自我描述不能为空")
    private String introduction;


    @Length(min = 1,max = 50,message = "联系人姓名长度必须在1~50位之间")
    @NotNull(message = "联系人姓名不能为空")
    private String concactName;

    @Length(min = 1,max = 50,message = "联系人电话长度必须在1~50位之间")
    @NotNull(message = "联系人电话不能为空")
    private String concactPhone;

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
}
