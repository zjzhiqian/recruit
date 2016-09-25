package com.hzq.project.user.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * CompanyVo
 * Created by hzq on 16/9/20.
 */
public class CompanyVo {

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @Length(message = "登录名必须在3~6位之间")
    @NotEmpty(message = "登录名不能为空")
    private String userName;

    @Length(min = 1,max = 160,message = "照片url不合法,请联系管理员")
    @NotEmpty(message = "请上传照片")
    private String picture;


    @Length(min = 6,max = 15,message = "密码必须在6~15位之间")
    @NotNull(message = "密码不能为空")
    private String password;

    @Length(min = 6,max = 15,message = "确认密码必须在6~15位之间")
    @NotNull(message = "确认密码不能为空")
    private String password2;

    @Length(min = 1,max = 50,message = "邮箱必须在1~50位之间")
    @NotNull(message = "邮箱不能为空")
    private String email;

    @Length(min = 1,max = 50,message = "公司名称必须在1~50位之间")
    @NotNull(message = "公司名称不能为空")
    private String company;

    @Length(min = 1,max = 50,message = "所属行业必须在1~50位之间")
    @NotNull(message = "所属行业不能为空")
    private String industry;

    @Length(min = 1,max = 50,message = "公司性质必须在1~50位之间")
    @NotNull(message = "公司性质不能为空")
    private String type;

    @Length(min = 1,max = 15,message = "创建时间必须在1~15位之间")
    @NotNull(message = "创建时间不能为空")
    private String createDate;

    @Length(min = 1,max = 50,message = "员工人数位数必须在1~50位之间")
    @NotNull(message = "员工人数不能为空")
    private String employees;

    @Length(min = 1,max = 50,message = "注册资金位数必须在1~50位之间")
    @NotNull(message = "注册资金不能为空")
    private String money;

    @Length(min = 1,max = 50,message = "公司首页长度在1~50位之间")
    @NotNull(message = "公司首页不能为空")
    private String html;

    @Length(min = 1,max = 50,message = "公司所属地区必须在1~50位之间")
    @NotNull(message = "公司所属地区不能为空")
    private String area;

    @Length(min = 1,max = 50,message = "公司介绍必须在1~200位之间")
    @NotNull(message = "公司介绍不能为空")
    private String introduction;

    @Length(min = 1,max = 50,message = "联系人名称必须在1~50位之间")
    @NotNull(message = "联系人名称不能为空")
    private String concatName;

    @Length(min = 1,max = 50,message = "联系人电话必须在1~50位之间")
    @NotNull(message = "联系人电话不能为空")
    private String phone;

    @Length(min = 1,max = 50,message = "传真必须在1~50位之间")
    @NotNull(message = "传真不能为空")
    private String fax;

    @Length(min = 1,max = 50,message = "公司地址必须在1~50位之间")
    @NotNull(message = "公司地址不能为空")
    private String address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getConcatName() {
        return concatName;
    }

    public void setConcatName(String concatName) {
        this.concatName = concatName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
