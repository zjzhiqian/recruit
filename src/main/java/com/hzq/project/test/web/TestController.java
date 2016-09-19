package com.hzq.project.test.web;

import com.hzq.project.system.common.web.BaseResult;
import com.hzq.project.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * TestController
 * Created by hzq on 16/4/21.
 */

@RestController
public class TestController {


    @Autowired
    private TestService testService;


    @RequestMapping(path = "/test")
    public BaseResult getById() {
        testService.aop01();
        return new BaseResult("添加成功");
    }
}
