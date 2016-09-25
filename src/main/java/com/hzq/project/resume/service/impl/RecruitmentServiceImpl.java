package com.hzq.project.resume.service.impl;

import com.google.common.collect.ImmutableMap;
import com.hzq.project.resume.dao.RecruitmentMapper;
import com.hzq.project.resume.dao.entity.Recruitment;
import com.hzq.project.resume.dao.entity.RecruitmentSearchResult;
import com.hzq.project.resume.service.RecruitmentService;
import com.hzq.project.resume.vo.RecruitmentQueryParam;
import com.hzq.project.system.common.dao.PageResult;
import com.hzq.project.system.common.exception.BusyOperationException;
import com.hzq.project.system.common.redis.RedisHelper;
import com.hzq.project.user.dao.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
            throw new BusyOperationException("招聘发布中,请稍后");
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

    @Override
    public PageResult<RecruitmentSearchResult> getPageResult(RecruitmentQueryParam param) {
        Integer current = param.getCurrent();
        Integer per = param.getPer();
        List<RecruitmentSearchResult> pageData = recruitmentMapper.getRecruitmentParamList(param);
        Integer count = recruitmentMapper.getRecruitmentParamCount(param);
        return new PageResult<>(current, per, count, pageData);
    }

    @Override
    public PageResult<Recruitment> getPartTimeJob(Integer page) {
        Integer per = 10;
        if (page == null) page = 1;

        Map<String, Integer> map = ImmutableMap.of("start", (page - 1) * per, "per", per);
        List<Recruitment> pageData = recruitmentMapper.getPartTimeJobList(map);
        Integer count = recruitmentMapper.getPartTimeJobCount(map);
        return new PageResult<>(page, per, count, pageData);

    }

    @Override
    public PageResult<Recruitment> getHighJob(Integer page) {
        Integer per = 10;
        if (page == null) page = 1;

        Map<String, Integer> map = ImmutableMap.of("start", (page - 1) * per, "per", per);
        List<Recruitment> pageData = recruitmentMapper.getHighJobList(map);
        Integer count = recruitmentMapper.getHighJobCount(map);
        return new PageResult<>(page, per, count, pageData);
    }

}
