package com.hzq.project.resume.dao;

import com.hzq.project.resume.dao.entity.ResumeJobRelation;
import com.hzq.project.system.common.dao.Dao;

public interface ResumeJobRelationMapper extends Dao<ResumeJobRelation,Integer> {
    /**
     * 根据 简历编号,职位编号查询关系
     * @param resumeId
     * @param jobId
     * @return
     */
    ResumeJobRelation getRelationByRsumeIdAndJobId(Integer resumeId, Integer jobId);
}