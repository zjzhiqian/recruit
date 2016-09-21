package com.hzq.project.resume.dao;

import com.hzq.project.resume.dao.entity.Recruitment;
import com.hzq.project.system.common.dao.Dao;

import java.util.List;

public interface RecruitmentMapper extends Dao<Recruitment,Integer> {
    Integer getRecruitmentCountByCompanyId(Integer companyId);

    List<Recruitment> getRecruitmentsByCompanyId(Integer companyId);
}