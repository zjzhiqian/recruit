package com.hzq.project.car.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzq.project.system.common.util.DateFormatSerializer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 查询二手车列表
 * Created by hzq on 16/9/27.
 */
public class SecondCarInfo {
    private Integer id;

    private Integer userId;

    private Integer merchantId;

    private Integer isMerchant;

    private Integer type;

    private String title;

    private BigDecimal journey;

    private String buyTime;


    private String licenseTime;

    private String introduction;

    private BigDecimal exhaust;

    private String pictue;

    private BigDecimal price;

    private String carPic;

    private Integer watch;



    @JsonSerialize(using = DateFormatSerializer.class)
    private Date createdAt;

    public String getLicenseTime() {
        return licenseTime;
    }

    public void setLicenseTime(String licenseTime) {
        this.licenseTime = licenseTime;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
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
}
