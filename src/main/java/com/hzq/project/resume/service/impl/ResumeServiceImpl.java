package com.hzq.project.resume.service.impl;

import com.hzq.project.resume.dao.ResumeMapper;
import com.hzq.project.resume.dao.entity.Resume;
import com.hzq.project.resume.service.ResumeService;
import com.hzq.project.system.common.exception.BusyOperationException;
import com.hzq.project.system.common.redis.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ResumeServiceImpl
 * Created by hzq on 16/9/20.
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

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
}
