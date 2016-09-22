package com.hzq.project.resume.dao.impl;

import com.google.common.collect.ImmutableMap;
import com.hzq.project.resume.dao.ResumeJobRelationMapper;
import com.hzq.project.resume.dao.entity.ResumeJobRelation;
import com.hzq.project.system.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * ResumeJobRelationMapperImpl
 * Created by hzq on 16/9/22.
 */
@Repository
public class ResumeJobRelationMapperImpl extends BaseDao<ResumeJobRelation,Integer> implements ResumeJobRelationMapper {
    @Override
    public ResumeJobRelation getRelationByRsumeIdAndJobId(Integer resumeId, Integer jobId) {
        return selectOne("getRelationByRsumeIdAndJobId", ImmutableMap.of("resumeId", resumeId,"jobId",jobId));
    }
}
