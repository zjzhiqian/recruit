package com.hzq.project.car.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class SecondCarVo {

    private Integer userId;

    @NotNull(message = "汽车品牌不能为空")
    private Integer type; //汽车品牌

    @Length(min = 1,max = 80,message = "标题必须在1~80位之间")
    @NotEmpty(message = "标题不能为空")
    private String title; //标题

    @NotNull(message = "里程数不能为空")
    private BigDecimal journey; //里程数


    @Length(min = 1,max = 50,message = "购买时间必须在1~50位之间")
    @NotNull(message = "购买时间不能为空")
    private String buyTime; //购买时间

    @Length(min = 1,max = 50,message = "上牌时间必须在1~50位之间")
    @NotNull(message = "上牌时间不能为空")
    private String licenseTime; //上牌时间

    @Length(min = 1,max = 50,message = "交强险到期时间必须在1~50位之间")
    @NotNull(message = "交强险到期时间不能为空")
    private String insuranceDeadtime; //交强险导线时间

    @Length(min = 1,max = 500,message = "介绍必须在1~500位之间")
    @NotNull(message = "描述不能为空")
    private String introduction; //介绍

    @NotNull(message = "请选择是否营运")
    private String nature; //是否营运

    @NotNull(message = "排气量不能为空")
    private BigDecimal exhaust;  //排气量

    @Length(min = 1,max = 160,message = "驾照url不合法,请联系管理员")
    @NotNull(message = "请上传驾照")
    private String pictue; //驾照

    @NotNull(message = "请输入价格")
    private BigDecimal price; //价格

    @NotNull(message = "请选择汽车使用年数")
    private Integer year; //使用年数

    @NotNull(message = "请选择汽车颜色")
    private Integer color; //颜色

    @Length(min = 1,max = 2000,message = "汽车图片url不合法,请联系管理员")
    @NotNull(message = "请上传汽车图片")
    private String carPic; //汽车图片

    @Length(min = 1,max = 50,message = "联系人姓名长度必须在1~50位之间")
    @NotNull(message = "联系人姓名不能为空")
    private String concactName;

    @Length(min = 1,max = 50,message = "联系人电话长度必须在1~50位之间")
    @NotNull(message = "联系人电话不能为空")
    private String concactPhone;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getJourney() {
        return journey;
    }

    public void setJourney(BigDecimal journey) {
        this.journey = journey;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getLicenseTime() {
        return licenseTime;
    }

    public void setLicenseTime(String licenseTime) {
        this.licenseTime = licenseTime;
    }

    public String getInsuranceDeadtime() {
        return insuranceDeadtime;
    }

    public void setInsuranceDeadtime(String insuranceDeadtime) {
        this.insuranceDeadtime = insuranceDeadtime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public BigDecimal getExhaust() {
        return exhaust;
    }

    public void setExhaust(BigDecimal exhaust) {
        this.exhaust = exhaust;
    }

    public String getPictue() {
        return pictue;
    }

    public void setPictue(String pictue) {
        this.pictue = pictue;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
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