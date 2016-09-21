package com.hzq.project.resume.dao;


import com.hzq.project.resume.dao.entity.Resume;
import com.hzq.project.system.common.dao.Dao;

public interface ResumeMapper extends Dao<Resume,Integer> {
    /**
     * 根据用户id查询用户简历数量
     * @param userId
     * @return
     */
    Integer getResumeCountByUserId(Integer userId);
}