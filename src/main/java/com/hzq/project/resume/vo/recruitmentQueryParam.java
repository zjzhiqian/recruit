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

    private Integer education;
    private Integer workYear;
    private Integer probation;



    private String beginDate;
    private String endDate;


    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Integer workYear) {
        this.workYear = workYear;
    }

    public Integer getProbation() {
        return probation;
    }

    public void setProbation(Integer probation) {
        this.probation = probation;
    }

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
