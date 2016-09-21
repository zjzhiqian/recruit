package com.hzq.project.resume.service;

import com.hzq.project.resume.dao.entity.Resume;

/**
 * ResumeService
 * Created by hzq on 16/9/20.
 */
public interface ResumeService {
    boolean addResume(Resume resume);

    Integer getResumeCountByUserId(Integer userId);
}
