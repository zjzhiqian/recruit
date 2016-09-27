package com.hzq.project.resume.vo;

import com.hzq.project.system.common.entity.BasePage;

/**
 * Created by hzq on 16/9/24.
 */
public class RecruitmentQueryParam extends BasePage{


    private String title;
    private Integer workArea;
    private Integer salary;
    private Integer type;

    private String beginDate;
    private String endDate;



    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWorkArea() {
        return workArea;
    }

    public void setWorkArea(Integer workArea) {
        this.workArea = workArea;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
