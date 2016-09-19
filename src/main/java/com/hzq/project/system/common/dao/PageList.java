package com.hzq.project.system.common.dao;

/**
 * PageList
 * Created by hzq on 16/9/19.
 */
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class PageList<T> extends Page {
    private List<T> resultList = new ArrayList();

    public PageList() {
    }

    public List<T> getResultList() {
        return this.resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
