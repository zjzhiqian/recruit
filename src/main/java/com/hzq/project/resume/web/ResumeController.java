package com.hzq.project.resume.web;

import com.hzq.project.picture.web.UpLoadController;
import com.hzq.project.resume.dao.entity.Resume;
import com.hzq.project.resume.dao.entity.ResumeQueryParamList;
import com.hzq.project.resume.exception.ResumeException;
import com.hzq.project.resume.service.ResumeService;
import com.hzq.project.resume.vo.RecruitmentQueryParam;
import com.hzq.project.resume.vo.ResumeQueryParam;
import com.hzq.project.resume.vo.ResumeQueryParamListVo;
import com.hzq.project.resume.vo.ResumeVo;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
     * 搜索简历
     */
    @RequiresRoles(Roles.COMPANY)
    @RequestMapping(path = "/queryResult", method = RequestMethod.GET)
    public PageResult<Resume> queryResume(ResumeQueryParamListVo resumeQueryParamListVo) {
//        学历,职位类别,工作年限,工资范围,期望工作区域,发布时间
        return resumeService.queryResume(getParam(resumeQueryParamListVo));
    }


    private ResumeQueryParamList getParam(ResumeQueryParamListVo paramVo) {
        if (StringUtils.isBlank(paramVo.getTitle()) || "null".equals(paramVo.getTitle())) {
            paramVo.setTitle(null);
        }

        Integer education = paramVo.getEducation();
        if (education == null || education == -1 || education == 0) {
            paramVo.setEducation(null);
        }

        Integer type = paramVo.getType();
        if (type == null || type == -1) {
            paramVo.setType(null);
        }

        String workYear = paramVo.getWorkYear();
        if (StringUtils.isEmpty(workYear) || "-1".equals(workYear)) {
            paramVo.setWorkYear(null);
        }
        Integer salary = paramVo.getSalary();
        if (salary == null || salary == -1) {
            paramVo.setSalary(null);
        }
        Integer workArea = paramVo.getWorkArea();
        if (workArea == null || workArea == -1) {
            paramVo.setWorkArea(null);
        }
        ResumeQueryParamList param = Creator.newInstance(paramVo, ResumeQueryParamList.class);
        param.setPage(paramVo.getPage());
        //发布时间处理
        Integer postDate = paramVo.getPostDate();
        if (postDate != null && postDate != -1) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            if (postDate == 1)
                calendar.add(Calendar.DATE, -1);
            if (postDate == 2)
                calendar.add(Calendar.DATE, -3);
            if (postDate == 3)
                calendar.add(Calendar.DATE, -7);
            if (postDate == 4)
                calendar.add(Calendar.DATE, -30);
            param.setBeginDate(sdf.format(calendar.getTime()));
            //endDate
            Calendar calendar1 = Calendar.getInstance();
            calendar1.add(Calendar.DATE, 1);
            param.setEndDate(sdf.format(calendar1.getTime()));
        }
        return param;
    }

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
