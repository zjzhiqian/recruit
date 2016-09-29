package com.hzq.project.resume.dao;


import com.hzq.project.resume.dao.entity.Resume;
import com.hzq.project.system.common.dao.Dao;

import java.util.List;

public interface ResumeMapper extends Dao<Resume,Integer> {
    /**
     * 根据用户id查询用户简历数量
     * @param userId
     * @return
     */
    Integer getResumeCountByUserId(Integer userId);

    /**
     * 根据用户查询用户所有建立
     * @param userId
     * @return
     */
    List<Resume> getResumeByUserId(Integer userId);

    int addWatchCount(Integer resumeId);

}