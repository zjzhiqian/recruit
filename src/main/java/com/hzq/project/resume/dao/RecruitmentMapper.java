package com.hzq.project.resume.dao;

import com.hzq.project.resume.dao.entity.Recruitment;
import com.hzq.project.resume.dao.entity.RecruitmentSearchResult;
import com.hzq.project.resume.dao.entity.Resume;
import com.hzq.project.resume.dao.entity.ResumeQueryParamList;
import com.hzq.project.resume.vo.RecruitmentQueryParam;
import com.hzq.project.resume.vo.ResumeQueryParam;
import com.hzq.project.system.common.dao.Dao;

import java.util.List;
import java.util.Map;

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


    /**
     * 兼职列表
     */
    List<Recruitment> getPartTimeJobList(Map<String, Integer> map);

    /**
     * 兼职数量
     */
    Integer getPartTimeJobCount(Map<String, Integer> map);

    /**
     * 高端招聘列表
     */
    List<Recruitment> getHighJobList(Map<String, Integer> map);

    /**
     * 高端招聘数量
     */
    Integer getHighJobCount(Map<String, Integer> map);

    int addWatchCount(Integer id);

    List<Resume> getReceivedResume(ResumeQueryParam param);

    Integer getReceivedResumeCount(ResumeQueryParam param);

}