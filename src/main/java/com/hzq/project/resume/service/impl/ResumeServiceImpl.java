package com.hzq.project.resume.service.impl;

import com.hzq.project.resume.dao.RecruitmentMapper;
import com.hzq.project.resume.dao.ResumeJobRelationMapper;
import com.hzq.project.resume.dao.ResumeMapper;
import com.hzq.project.resume.dao.entity.*;
import com.hzq.project.resume.exception.ResumeException;
import com.hzq.project.resume.service.ResumeService;
import com.hzq.project.resume.vo.ResumeQueryParam;
import com.hzq.project.system.common.dao.PageList;
import com.hzq.project.system.common.dao.PageResult;
import com.hzq.project.system.common.exception.BusyOperationException;
import com.hzq.project.system.common.redis.RedisHelper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * ResumeServiceImpl
 * Created by hzq on 16/9/20.
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    @Autowired
    private RecruitmentMapper recruitmentMapper;

    @Autowired
    private ResumeJobRelationMapper resumeJobRelationMapper;


    @Override
    public boolean addResume(Resume resume) {
        if (RedisHelper.compareAndSetRequest("ResumeServiceImpl ", "addResume:", resume.getUserId().toString(), 5))
            throw new BusyOperationException("简历新增中,请稍后");
        resumeMapper.insert(resume);
        return true;
    }

    @Override
    public Integer getResumeCountByUserId(Integer userId) {
        return resumeMapper.getResumeCountByUserId(userId);
    }

    @Override
    public List<Resume> getResumeByUserId(Integer userId) {
        return resumeMapper.getResumeByUserId(userId);
    }

    @Override
    public boolean postResume(Integer resumeId, Integer jobId, Integer userId) {
        if (RedisHelper.compareAndSetRequest("ResumeServiceImpl ", "postResume:" + resumeId + ":", jobId + "", 5))
            throw new BusyOperationException("投递中,请稍后");


        //校验简历存在不存在
        Optional.ofNullable(resumeMapper.getByPk(resumeId)).orElseThrow(() -> new ResumeException("简历不存在"));
        //校验是不是自己的简历
        List<Resume> ownResumes = resumeMapper.getResumeByUserId(userId);
        if (ownResumes.stream().noneMatch(resume -> resume.getId().equals(resumeId)))
            throw new ResumeException("不是您的简历,无法投递");
        //校验职位存在否
        Recruitment recruitment = recruitmentMapper.getByPk(jobId);
        if (recruitment == null)
            throw new ResumeException("职位不存在");
        //是否已投递
        ResumeJobRelation dbRelation = resumeJobRelationMapper.getRelationByRsumeIdAndJobId(resumeId, jobId);
        if (dbRelation != null)
            throw new ResumeException("您已经投递过此岗位!");
        ResumeJobRelation relation = new ResumeJobRelation();
        relation.setCompanyId(recruitment.getCompanyId());
        relation.setUserId(userId);
        relation.setResumeId(resumeId);
        relation.setRecruitmentId(jobId);
        //开始投递
        resumeJobRelationMapper.insert(relation);
        return true;
    }

    @Override
    public Integer getReceivedResumeCount(Integer companyId) {
        return resumeJobRelationMapper.getRelationByCompanyId(companyId).size();
    }

    @Override
    public PageResult<Resume> getReceivedResume(ResumeQueryParam param) {
        Integer current = param.getCurrent();
        Integer per = param.getPer();
        List<Resume> pageData = recruitmentMapper.getReceivedResume(param);
        Integer count = recruitmentMapper.getReceivedResumeCount(param);
        return new PageResult<>(current, per, count, pageData);

    }

    @Override
    public Resume getResumeByCompanyAndCompanyId(Integer resumeId, Integer companyId) {
//        List<ResumeJobRelation> relation = resumeJobRelationMapper.getRelationByCompanyId(companyId);
//        List<ResumeJobRelation> relations = relation.stream().filter(re -> re.getResumeId().equals(resumeId)).collect(toList());
//        if (relations.size() == 0)
//            throw new ResumeException("您无权查看简历");
        resumeMapper.addWatchCount(resumeId);
        return resumeMapper.getByPk(resumeId);
    }

    @Override
    public PageResult<Resume> queryResume(ResumeQueryParamList param) {
        Integer current = param.getCurrent();
        Integer per = param.getPer();
        List<Resume> pageData = resumeMapper.getResumeByParamList(param);
        Integer count = resumeMapper.getResumeCountByParamList(param);
        return new PageResult<>(current, per, count, pageData);
    }
}
