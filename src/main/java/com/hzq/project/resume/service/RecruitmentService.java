package com.hzq.project.resume.service;

import com.hzq.project.resume.dao.entity.Recruitment;

import java.util.List;

/**
 * RecruitmentService
 * Created by hzq on 16/9/21.
 */
public interface RecruitmentService {
    /**
     * 新增招聘
     */
    boolean addRecruitment(Recruitment recruitment);

    /**
     * 查询招聘数量
     */
    Integer getRecruitmentCountByCompanyId(Integer companyId);

    /**
     * 查询公司下所有招聘
     */
    List<Recruitment> getRecruitmentsByCompanyId(Integer companyId);

    /**
     * 获取热门职位
     */
    List<Recruitment> getHotJobs();

}
