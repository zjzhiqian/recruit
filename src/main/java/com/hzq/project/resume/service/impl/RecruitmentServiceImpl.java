package com.hzq.project.resume.service.impl;

import com.hzq.project.resume.dao.RecruitmentMapper;
import com.hzq.project.resume.dao.entity.Recruitment;
import com.hzq.project.resume.service.RecruitmentService;
import com.hzq.project.system.common.exception.BusyOperationException;
import com.hzq.project.system.common.redis.RedisHelper;
import com.hzq.project.user.dao.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hzq on 16/9/21.
 */
@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    @Autowired
    private RecruitmentMapper recruitmentMapper;


    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public boolean addRecruitment(Recruitment recruitment) {
        Integer companyId = recruitment.getCompanyId();

        if (RedisHelper.compareAndSetRequest("RecruitmentServiceImpl ", "addRecruitment:", companyId + "", 5))
            throw new BusyOperationException("简历新增中,请稍后");
        recruitmentMapper.insert(recruitment);
        companyMapper.updateCompanyUpdateTime(companyId);

        return true;
    }

    @Override
    public Integer getRecruitmentCountByCompanyId(Integer companyId) {
        return recruitmentMapper.getRecruitmentCountByCompanyId(companyId);
    }

    @Override
    public List<Recruitment> getRecruitmentsByCompanyId(Integer companyId) {
        return recruitmentMapper.getRecruitmentsByCompanyId(companyId);
    }

    @Override
    public List<Recruitment> getHotJobs() {
        return recruitmentMapper.getHotJobs();
    }

}
