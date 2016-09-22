package com.hzq.project.user.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzq.project.system.common.util.DateFormatSerializer;

import java.util.Date;

/**
 * CompanyInfo
 * Created by hzq on 16/9/22.
 */
public class CompanyInfo {
    private Integer id;

    private String email;

    private String company;

    private String industry;

    private String type;

    private String createDate;

    private String employees;

    private String money;

    private String html;

    private String area;

    private String introduction;

    private String concatName;

    private String phone;

    private String fax;

    private String address;

    @JsonSerialize(using = DateFormatSerializer.class)
    private Date createdAt;

    @JsonSerialize(using = DateFormatSerializer.class)
    private Date updatedAt;


    private Integer watch;


    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getWatch() {
        return watch;
    }

    public void setWatch(Integer watch) {
        this.watch = watch;
    }


}
