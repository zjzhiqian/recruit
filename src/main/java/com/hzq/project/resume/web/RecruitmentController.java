package com.hzq.project.resume.web;

import com.hzq.project.resume.dao.entity.Recruitment;
import com.hzq.project.resume.dao.entity.Resume;
import com.hzq.project.resume.service.RecruitmentService;
import com.hzq.project.resume.vo.RecruitmentVo;
import com.hzq.project.resume.vo.ResumeVo;
import com.hzq.project.security.annon.RequiresRoles;
import com.hzq.project.security.util.Roles;
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
import java.util.List;

/**
 * 招聘
 * Created by hzq on 16/9/21.
 */
@RestController
@RequestMapping("/recruitment")
public class RecruitmentController extends BaseController {
    @Autowired
    private RecruitmentService recruitmentService;


    /**
     * 新增招聘
     */
    @RequiresRoles(Roles.COMPANY)
    @RequestMapping(path = "/addRecruitment", method = RequestMethod.POST)
    public BaseResult registerUser(@Valid RecruitmentVo recruitmentVo, BindingResult bindingResult) {
        ValidatorHelper.validBindingResult(bindingResult);
        recruitmentVo.setCompanyId(getCompanyId());
        Recruitment recruitment = Creator.newInstance(recruitmentVo, Recruitment.class);
        recruitmentService.addRecruitment(recruitment);
        return new BaseResult("新增招聘成功");
    }


    /**
     * 查看招聘数量
     */
    @RequiresRoles(Roles.COMPANY)
    @RequestMapping(path = "/getRecruitmentCount", method = RequestMethod.GET)
    public Integer getResumeCount() {
        return recruitmentService.getRecruitmentCountByCompanyId(getCompanyId());
    }

    /**
     * 获取用户所有简历
     */
    @RequiresRoles(Roles.COMPANY)
    @RequestMapping(path = "/getResumeByCompanyId", method = RequestMethod.GET)
    public List<Recruitment> getResumeByCompanyId(){
        return recruitmentService.getRecruitmentsByCompanyId(getCompanyId());
    }


}
