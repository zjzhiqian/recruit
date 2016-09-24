package com.hzq.project.resume.dao.impl;

import com.hzq.project.resume.dao.RecruitmentMapper;
import com.hzq.project.resume.dao.entity.Recruitment;
import com.hzq.project.resume.dao.entity.RecruitmentSearchResult;
import com.hzq.project.resume.vo.RecruitmentQueryParam;
import com.hzq.project.system.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * RecruitmentMapperImpl
 * Created by hzq on 16/9/21.
 */
@Repository
public class RecruitmentMapperImpl extends BaseDao<Recruitment, Integer> implements RecruitmentMapper {
    @Override
    public Integer getRecruitmentCountByCompanyId(Integer companyId) {
        return getSqlSession().selectOne(getIbatisSqlMapNamespace() + ".getRecruitmentCountByCompanyId", companyId);
    }

    @Override
    public List<Recruitment> getRecruitmentsByCompanyId(Integer companyId) {
        return selectList("getRecruitmentsByCompanyId", companyId);
    }

    @Override
    public List<Recruitment> getHotJobs() {
        return selectList("getHotJobs", null);
    }

    @Override
    public List<RecruitmentSearchResult> getRecruitmentParamList(RecruitmentQueryParam param) {
        return getSqlSession().selectList("getRecruitmentParamList", param);
    }

    @Override
    public Integer getRecruitmentParamCount(RecruitmentQueryParam param) {
        return getSqlSession().selectOne("getRecruitmentParamCount", param);
    }

    @Override
    public List<Recruitment> getPartTimeJobList(Map<String, Integer> map) {
        return selectList("getPartTimeJobList", map);
    }

    @Override
    public Integer getPartTimeJobCount(Map<String, Integer> map) {
        return getSqlSession().selectOne("getPartTimeJobCount", map);
    }

    @Override
    public List<Recruitment> getHighJobList(Map<String, Integer> map) {
        return selectList("getHighJobList", map);
    }

    @Override
    public Integer getHighJobCount(Map<String, Integer> map) {
        return getSqlSession().selectOne("getHighJobCount", map);
    }

}
