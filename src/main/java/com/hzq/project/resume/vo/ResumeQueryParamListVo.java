package com.hzq.project.resume.vo;

/**
 * Created by hzq on 17/2/2.
 */
public class ResumeQueryParamListVo {
    //        关键词,学历,职位类别,工作年限,工资范围,期望工作区域,发布时间
    private String title;
    private Integer education;
    private Integer type;
    private String workYear;
    private Integer salary;
    private Integer workArea;
    private Integer postDate;
    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getWorkArea() {
        return workArea;
    }

    public void setWorkArea(Integer workArea) {
        this.workArea = workArea;
    }

    public Integer getPostDate() {
        return postDate;
    }

    public void setPostDate(Integer postDate) {
        this.postDate = postDate;
    }
}
