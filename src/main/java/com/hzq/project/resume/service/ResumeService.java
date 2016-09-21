package com.hzq.project.resume.service;

import com.hzq.project.resume.dao.entity.Resume;

import java.util.List;

/**
 * ResumeService
 * Created by hzq on 16/9/20.
 */
public interface ResumeService {
    boolean addResume(Resume resume);

    Integer getResumeCountByUserId(Integer userId);

    List<Resume> getResumeByUserId(Integer userId);
}
