package com.hzq.project.resume.service.impl;

import com.hzq.project.resume.dao.JobNewsMapper;
import com.hzq.project.resume.dao.entity.JobNews;
import com.hzq.project.resume.service.JobNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hzq on 16/9/22.
 */
@Service
public class JobNewsServiceImpl implements JobNewsService {
    @Autowired
    private JobNewsMapper jobNewsMapper;

    @Override
    public List<JobNews> getJobNews() {
        return jobNewsMapper.getJobNews();
    }

    @Override
    public JobNews getJobNewsDetail(Integer id) {
        return jobNewsMapper.getJobNewsDetail(id);
    }
}
