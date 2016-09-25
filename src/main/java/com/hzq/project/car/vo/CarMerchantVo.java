package com.hzq.project.car.vo;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class CarMerchantVo {

    @Length(min = 1, max = 50, message = "公司名称必须在1~50位之间")
    @NotNull(message = "公司名称不能为空")
    private String company;

    @NotNull(message = "店铺类型不能为空")
    private Integer type;

    private Integer userId;

    @Length(min = 1, max = 50, message = "负责人名称必须在1~50位之间")
    @NotNull(message = "负责人名称不能为空")
    private String name;

    @Length(min = 1, max = 50, message = "联系人电话必须在1~50位之间")
    @NotNull(message = "联系人电话不能为空")
    private String phone;

    @Length(min = 1, max = 160, message = "营业执照url不合法,请联系管理员")
    @NotEmpty(message = "请上传营业执照")
    private String picture;

    @Length(min = 1, max = 160, message = "身份证url不合法,请联系管理员")
    @NotEmpty(message = "请上传身份证")
    private String idCard;

    @NotNull(message = "请选择所属省份")
    private Integer province;
    @Length(min = 1, max = 50, message = "详细地址必须在1~50位之间")
    @NotNull(message = "详细地址不能为空")
    private String address;


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}