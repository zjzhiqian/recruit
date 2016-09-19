package com.hzq.project.test.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Balance {
    private Integer id;

    private Integer balanceableId;

    private Integer balanceableType;

    private BigDecimal amount;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBalanceableId() {
        return balanceableId;
    }

    public void setBalanceableId(Integer balanceableId) {
        this.balanceableId = balanceableId;
    }

    public Integer getBalanceableType() {
        return balanceableType;
    }

    public void setBalanceableType(Integer balanceableType) {
        this.balanceableType = balanceableType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
}