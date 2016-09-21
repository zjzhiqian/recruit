package com.hzq.project.resume.web;

import com.hzq.project.resume.dao.entity.Resume;
import com.hzq.project.resume.service.ResumeService;
import com.hzq.project.resume.vo.ResumeVo;
import com.hzq.project.system.common.util.Creator;
import com.hzq.project.system.common.util.ValidatorHelper;
import com.hzq.project.system.common.web.BaseController;
import com.hzq.project.system.common.web.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * ResumeController
 * Created by hzq on 16/9/20.
 */
@RestController
@RequestMapping("/resume")
public class ResumeController extends BaseController{

    @Autowired
    private ResumeService resumeService;

    /**
     * 新增简历
     */
    @RequestMapping(path = "/addResume", method = RequestMethod.POST)
    public BaseResult registerUser(@Valid ResumeVo resumeVo, BindingResult bindingResult) {
        ValidatorHelper.validBindingResult(bindingResult);
        resumeVo.setUserId(getUserId());
        Resume resume = Creator.newInstance(resumeVo, Resume.class);
        resumeService.addResume(resume);
        return new BaseResult("新增简历成功");
    }


    /**
     * 新增简历
     */
    @RequestMapping(path = "/getResumeCount", method = RequestMethod.GET)
    public Integer getResumeCount() {
        return resumeService.getResumeCountByUserId(getUserId());
    }




}