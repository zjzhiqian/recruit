package com.hzq.project.resume.vo;

import com.hzq.project.system.common.entity.BasePage;

/**
 * Created by hzq on 16/9/29.
 */
public class ResumeQueryParam extends BasePage {

    private Integer companyId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
