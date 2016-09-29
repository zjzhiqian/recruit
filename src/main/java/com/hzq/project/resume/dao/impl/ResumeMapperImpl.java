package com.hzq.project.resume.dao.impl;

import com.hzq.project.resume.dao.ResumeMapper;
import com.hzq.project.resume.dao.entity.Resume;
import com.hzq.project.system.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ResumeMapperImpl
 * Created by hzq on 16/9/20.
 */
@Repository
public class ResumeMapperImpl extends BaseDao<Resume, Integer> implements ResumeMapper {
    @Override
    public Integer getResumeCountByUserId(Integer userId) {
        return getSqlSession().selectOne(getIbatisSqlMapNamespace() + ".getResumeCountByUserId", userId);
    }

    @Override
    public List<Resume> getResumeByUserId(Integer userId) {
        return selectList("getResumeByUserId", userId);
    }

    @Override
    public int addWatchCount(Integer id) {
        return updateByParam("addWatchCount", id);
    }
}
