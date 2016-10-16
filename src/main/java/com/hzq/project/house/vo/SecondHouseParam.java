package com.hzq.project.house.vo;

import com.hzq.project.system.common.entity.BasePage;

import java.math.BigDecimal;

/**
 * Created by hzq on 16/10/16.
 */
public class SecondHouseParam extends BasePage{

    private String title;
    private Integer area;
    private BigDecimal priceBegin;
    private BigDecimal priceEnd;
    private Integer bigBegin;
    private Integer bigEnd;
    private Integer shiBeGin;
    private Integer shiEnd;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
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

    public Integer getBigBegin() {
        return bigBegin;
    }

    public void setBigBegin(Integer bigBegin) {
        this.bigBegin = bigBegin;
    }

    public Integer getBigEnd() {
        return bigEnd;
    }

    public void setBigEnd(Integer bigEnd) {
        this.bigEnd = bigEnd;
    }

    public Integer getShiBeGin() {
        return shiBeGin;
    }

    public void setShiBeGin(Integer shiBeGin) {
        this.shiBeGin = shiBeGin;
    }

    public Integer getShiEnd() {
        return shiEnd;
    }

    public void setShiEnd(Integer shiEnd) {
        this.shiEnd = shiEnd;
    }
}
