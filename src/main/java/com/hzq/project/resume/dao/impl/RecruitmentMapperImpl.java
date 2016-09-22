package com.hzq.project.resume.dao.impl;

import com.hzq.project.resume.dao.RecruitmentMapper;
import com.hzq.project.resume.dao.entity.Recruitment;
import com.hzq.project.system.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

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

}
