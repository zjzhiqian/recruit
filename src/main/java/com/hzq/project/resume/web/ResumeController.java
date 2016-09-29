package com.hzq.project.resume.web;

import com.alibaba.fastjson.JSON;
import com.hzq.project.picture.web.UpLoadController;
import com.hzq.project.resume.dao.entity.Resume;
import com.hzq.project.resume.exception.ResumeException;
import com.hzq.project.resume.service.ResumeService;
import com.hzq.project.resume.vo.ResumeQueryParam;
import com.hzq.project.resume.vo.ResumeVo;
import com.hzq.project.system.common.dao.PageList;
import com.hzq.project.system.common.dao.PageResult;
import com.hzq.project.system.security.annon.RequiresRoles;
import com.hzq.project.system.security.util.Roles;
import com.hzq.project.system.common.util.Creator;
import com.hzq.project.system.common.util.ValidatorHelper;
import com.hzq.project.system.common.web.BaseController;
import com.hzq.project.system.common.web.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * ResumeController
 * Created by hzq on 16/9/20.
 */
@RestController
@RequestMapping("/resume")
public class ResumeController extends BaseController {

    @Autowired
    private ResumeService resumeService;

    /**
     * 新增简历
     */
    @RequiresRoles(Roles.USER)
    @RequestMapping(path = "/addResume", method = RequestMethod.POST)
    public BaseResult registerUser(@Valid ResumeVo resumeVo, BindingResult bindingResult) {
        ValidatorHelper.validBindingResult(bindingResult);
        resumeVo.setPicture("/upload/" + UpLoadController.USER_RESUME + "/" + resumeVo.getPicture());
        resumeVo.setUserId(getUserId());
        Resume resume = Creator.newInstance(resumeVo, Resume.class);
        resumeService.addResume(resume);
        return new BaseResult("新增简历成功");
    }

    /**
     * 查看简历数量
     */
    @RequiresRoles(Roles.USER)
    @RequestMapping(path = "/getResumeCount", method = RequestMethod.GET)
    public Integer getResumeCount() {
        return resumeService.getResumeCountByUserId(getUserId());
    }

    /**
     * 获取用户所有简历
     */
    @RequiresRoles(Roles.USER)
    @RequestMapping(path = "/getResumeByUserId", method = RequestMethod.GET)
    public List<Resume> getResumeByUserId() {
        return resumeService.getResumeByUserId(getUserId());
    }


    /**
     * 投递简历
     */
    @RequiresRoles(Roles.USER)
    @RequestMapping(path = "/postResume/{jobId}", method = RequestMethod.POST)
    public BaseResult postResume(@PathVariable Integer jobId, Integer resumeId) {
        if (resumeId == null || jobId == null)
            throw new ResumeException("请求参数不合法");
        resumeService.postResume(resumeId, jobId, getUserId());
        return new BaseResult("投递简历成功");
    }


    /**
     * 企业查看收到简历的数量
     */
    @RequiresRoles(Roles.COMPANY)
    @RequestMapping(path = "/receivedResumeCount", method = RequestMethod.GET)
    public Integer receivedResumeCount() {
        return resumeService.getReceivedResumeCount(getCompanyId());
    }

    /**
     * 企业查看收到简历列表
     */
    @RequiresRoles(Roles.COMPANY)
    @RequestMapping(path = "/receivedResume", method = RequestMethod.GET)
    public PageResult<Resume> receivedResume(Integer page) {
        ResumeQueryParam param = new ResumeQueryParam();
        param.setCompanyId(getCompanyId());
        param.setPer(8);
        param.setPage(page);
        return resumeService.getReceivedResume(param);
    }


    /**
     * 企业查看收到简历id
     */
    @RequiresRoles(Roles.COMPANY)
    @RequestMapping(path = "/receivedResume/{id}", method = RequestMethod.GET)
    public Resume receivedResumeById(@PathVariable Integer id) {
        return resumeService.getResumeByCompanyAndCompanyId(id, getCompanyId());
    }

}
