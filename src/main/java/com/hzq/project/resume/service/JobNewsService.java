package com.hzq.project.resume.service;

import com.hzq.project.resume.dao.entity.JobNews;

import java.util.List;

/**
 * Created by hzq on 16/9/22.
 */
public interface JobNewsService {
    /**
     * 查询职位资讯
     */
    List<JobNews> getJobNews();

}
