package com.hzq.project.car.vo;

import com.hzq.project.system.common.entity.BasePage;

import java.math.BigDecimal;

/**
 * Created by hzq on 16/9/27.
 */
public class SecondCarParam  extends BasePage{
    private String title;
    private Integer type;
    private Integer year;
    private Integer isMerchant;

    private BigDecimal priceBegin;
    private BigDecimal priceEnd;


    public Integer getIsMerchant() {
        return isMerchant;
    }

    public void setIsMerchant(Integer isMerchant) {
        this.isMerchant = isMerchant;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public BigDecimal getPriceBegin() {
        return priceBegin;
    }

    public void setPriceBegin(BigDecimal priceBegin) {
        this.priceBegin = priceBegin;
    }

    public BigDecimal getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(BigDecimal priceEnd) {
        this.priceEnd = priceEnd;
    }
}
