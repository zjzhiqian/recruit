package com.hzq.project.resume.vo;


/**
 * Created by hzq on 16/9/24.
 */
public class RecruitmentQueryParamVo{

    private String title;
    private Integer workArea;
    private Integer type;
    private Integer salary;
    private Integer page;
    private Integer postDate;


    public Integer getPostDate() {
        return postDate;
    }

    public void setPostDate(Integer postDate) {
        this.postDate = postDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

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
