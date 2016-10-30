package com.hzq.project.user.web;

import com.hzq.project.user.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hzq on 16/10/20.
 */
@RestController
@RequestMapping("sys")
public class SysParamController {

    @Autowired
    SysParamService sysParamService;

    @RequestMapping("sysCount")
    public Integer getLogCount() {
        return sysParamService.getParamByKey("logCount");
    }



}
