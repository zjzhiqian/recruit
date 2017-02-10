package com.hzq.project.user.web;

import com.hzq.project.system.common.web.BaseController;
import com.hzq.project.user.service.UserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by hzq on 17/2/10.
 */
@RestController
@RequestMapping("center")
public class UserCenterController extends BaseController{

    @Autowired
    UserCenterService userCenterService;

    /**
     * 最近发布
     */
    @RequestMapping(path = "postList", method = RequestMethod.GET)
    public List<Map<String,Object>>  companyInfo() {
        return userCenterService.getPostList(getUserType(),getLogInId());
    }



}
