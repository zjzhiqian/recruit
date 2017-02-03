package com.hzq.project.resume.service;

import com.hzq.project.resume.dao.entity.Resume;
import com.hzq.project.resume.dao.entity.ResumeQueryParamList;
import com.hzq.project.resume.vo.ResumeQueryParam;
import com.hzq.project.system.common.dao.PageResult;

import java.util.List;

/**
 * ResumeService
 * Created by hzq on 16/9/20.
 */
public interface ResumeService {
    boolean addResume(Resume resume);

    Integer getResumeCountByUserId(Integer userId);

    List<Resume> getResumeByUserId(Integer userId);

    /**
     * 投递简历
     * @param resumeId 简历编号
     * @param jobId 岗位编号
     * @param userId 用户id
     * @return 结果
     */
    boolean postResume(Integer resumeId, Integer jobId, Integer userId);

    /**
     * 查询企业收到的简历数量
     */
    Integer getReceivedResumeCount(Integer companyId);

    PageResult<Resume> getReceivedResume(ResumeQueryParam param);

    Resume getResumeByCompanyAndCompanyId(Integer id, Integer companyId);

    PageResult<Resume> queryResume(ResumeQueryParamList param);
}
