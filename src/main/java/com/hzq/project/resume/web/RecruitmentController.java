package com.hzq.project.resume.web;

import com.hzq.project.resume.dao.entity.Recruitment;
import com.hzq.project.resume.dao.entity.RecruitmentSearchResult;
import com.hzq.project.resume.exception.RecruitmentException;
import com.hzq.project.resume.service.RecruitmentService;
import com.hzq.project.resume.vo.RecruitmentQueryParam;
import com.hzq.project.resume.vo.RecruitmentQueryParamVo;
import com.hzq.project.resume.vo.RecruitmentVo;
import com.hzq.project.system.common.dao.PageResult;
import com.hzq.project.system.security.annon.RequiresRoles;
import com.hzq.project.system.security.util.Roles;
import com.hzq.project.system.common.util.Creator;
import com.hzq.project.system.common.util.ValidatorHelper;
import com.hzq.project.system.common.web.BaseController;
import com.hzq.project.system.common.web.BaseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
     * 查看公司招聘数量(用户查看)
     */
    @RequestMapping(path = "/getJobsByCompanyIdCount/{id}", method = RequestMethod.GET)
    public Integer getResumeCount(@PathVariable Integer id) {
        if (id == null) throw new RecruitmentException();
        return recruitmentService.getRecruitmentCountByCompanyId(id);
    }

    /**
     * 查看公司招聘数量(企业查看)
     */
    @RequestMapping(path = "/getRecruitmentCount", method = RequestMethod.GET)
    public Integer getResumeCount() {
        return recruitmentService.getRecruitmentCountByCompanyId(getCompanyId());
    }

    /**
     * 获取公司招聘的所有职位(企业查看)
     */
    @RequiresRoles((Roles.COMPANY))
    @RequestMapping(path = "/getJobsByCompanyId", method = RequestMethod.GET)
    public List<Recruitment> getResumeByCompanyId2() {
        return recruitmentService.getRecruitmentsByCompanyId(getCompanyId());
    }


    /**
     * 获取公司招聘的所有职位(用户查看)
     */
    @RequestMapping(path = "/getJobsByCompanyId/{id}", method = RequestMethod.GET)
    public List<Recruitment> getResumeByCompanyId(@PathVariable Integer id) {
        if (id == null) throw new RecruitmentException();
        return recruitmentService.getRecruitmentsByCompanyId(id);
    }

    /**
     * 获取热门职位
     */
    @RequestMapping(path = "/getHotJobs", method = RequestMethod.GET)
    public List<Recruitment> getHotJobs() {
        return recruitmentService.getHotJobs();
    }


    /**
     * 用户搜索职位
     */
    @RequestMapping(path = "/searchJob", method = RequestMethod.GET)
    public PageResult<RecruitmentSearchResult> searchJob(RecruitmentQueryParamVo paramVo) {
        return recruitmentService.getPageResult(buildQueryParam(paramVo));
    }

    private RecruitmentQueryParam buildQueryParam(RecruitmentQueryParamVo paramVo) {
        Integer type = paramVo.getType();
        if (type == null || type == -1)
            paramVo.setType(null);

        Integer workArea = paramVo.getWorkArea();
        if (workArea == null || workArea == -1)
            paramVo.setWorkArea(null);

        if (StringUtils.isBlank(paramVo.getTitle()) || "null".equals(paramVo.getTitle()))
            paramVo.setTitle(null);


        RecruitmentQueryParam param = Creator.newInstance(paramVo, RecruitmentQueryParam.class);

        //分页
        Integer per = 20;
        Integer page = paramVo.getPage();
        if (page == null) page = 1;
        param.setPer(20);
        param.setStart((page - 1) * per);
        param.setCurrent(page);

        return param;
    }
}
