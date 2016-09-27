package com.hzq.project.car.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzq.project.system.common.util.DateFormatSerializer;

import java.math.BigDecimal;
import java.util.Date;

public class SecondCar {
    private Integer id;

    private Integer userId;

    private Integer merchantId;

    private Integer isMerchant;

    private Integer type;

    private String title;

    private BigDecimal journey;

    private String buyTime;

    private String licenseTime;

    private String insuranceDeadtime;

    private String introduction;

    private String nature;

    private BigDecimal exhaust;

    private String pictue;

    private BigDecimal price;

    private Integer year; //使用年数

    private Integer color;

    private String carPic;

    private String concactName;

    private String concactPhone;

    private Integer watch;

    private Date createdAt;

    @JsonSerialize(using = DateFormatSerializer.class)
    private Date updatedAt;

    private Date deletedAt;

    private Integer times;

    private String constrct;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

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

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getIsMerchant() {
        return isMerchant;
    }

    public void setIsMerchant(Integer isMerchant) {
        this.isMerchant = isMerchant;
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

    public Integer getWatch() {
        return watch;
    }

    public void setWatch(Integer watch) {
        this.watch = watch;
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

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getConstrct() {
        return constrct;
    }

    public void setConstrct(String constrct) {
        this.constrct = constrct;
    }
}