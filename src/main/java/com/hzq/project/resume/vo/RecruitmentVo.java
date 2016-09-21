package com.hzq.project.resume.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by hzq on 16/9/21.
 */
public class RecruitmentVo {

    private Integer companyId;

    @Length(min = 1,max = 160,message = "照片url不合法,请联系管理员")
    @NotEmpty(message = "请上传照片")
    private String picture;

    private Integer type;

    @NotNull(message = "学历不能为空")
    private Integer education;

    @NotNull(message = "招聘人数不能为空")
    private Integer peopleCount;

    @NotNull(message = "工作年限不能为空")
    private String workYear;

    @NotNull(message = "月薪不能为空")
    private Integer salary;

    @NotNull(message = "试用期不能为空")
    private Integer probation;

    @NotNull(message = "工作地点不能为空")
    private Integer workArea;

    @Length(max = 50,message = "工作区域地点必须在0~50位之间")
    private String detailArea;

    @Length(min = 1,max = 80,message = "招聘标题必须在1~80位之间")
    @NotEmpty(message = "招聘标题不能为空")
    private String title;

    @Length(min = 1,max = 500,message = "职位描述必须在1~500位之间")
    private String introduction;


    @Length(min = 1,max = 50,message = "联系人姓名长度必须在1~50位之间")
    @NotNull(message = "联系人姓名不能为空")
    private String concactName;

    @Length(min = 1,max = 50,message = "联系人电话长度必须在1~50位之间")
    @NotNull(message = "联系人电话不能为空")
    private String concactPhone;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
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

    public Integer getProbation() {
        return probation;
    }

    public void setProbation(Integer probation) {
        this.probation = probation;
    }

    public Integer getWorkArea() {
        return workArea;
    }

    public void setWorkArea(Integer workArea) {
        this.workArea = workArea;
    }

    public String getDetailArea() {
        return detailArea;
    }

    public void setDetailArea(String detailArea) {
        this.detailArea = detailArea;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
}
