package com.hzq.project.resume.dao;

import com.hzq.project.resume.dao.entity.Recruitment;
import com.hzq.project.resume.dao.entity.RecruitmentSearchResult;
import com.hzq.project.resume.vo.RecruitmentQueryParam;
import com.hzq.project.system.common.dao.Dao;

import java.util.List;

public interface RecruitmentMapper extends Dao<Recruitment,Integer> {
    Integer getRecruitmentCountByCompanyId(Integer companyId);

    List<Recruitment> getRecruitmentsByCompanyId(Integer companyId);

    /**
     * 获取热门职位
     */
    List<Recruitment> getHotJobs();

    /**
     *搜索列表
     */
    List<RecruitmentSearchResult> getRecruitmentParamList(RecruitmentQueryParam param);

    /**
     * 搜索列表数量
     */
    Integer getRecruitmentParamCount(RecruitmentQueryParam param);
}