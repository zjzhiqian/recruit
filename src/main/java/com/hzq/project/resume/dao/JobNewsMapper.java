package com.hzq.project.resume.dao;

import com.hzq.project.resume.dao.entity.JobNews;
import com.hzq.project.system.common.dao.Dao;

import java.util.List;

public interface JobNewsMapper extends Dao<JobNews,Integer> {
    List<JobNews> getJobNews();
}