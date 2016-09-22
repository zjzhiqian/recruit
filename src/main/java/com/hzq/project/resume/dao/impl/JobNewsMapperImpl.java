package com.hzq.project.resume.dao.impl;

import com.hzq.project.resume.dao.JobNewsMapper;
import com.hzq.project.resume.dao.entity.JobNews;
import com.hzq.project.system.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hzq on 16/9/22.
 */
@Repository
public class JobNewsMapperImpl extends BaseDao<JobNews, Integer> implements JobNewsMapper {
    @Override
    public List<JobNews> getJobNews() {
        return selectList("getJobNews", null);
    }
}
