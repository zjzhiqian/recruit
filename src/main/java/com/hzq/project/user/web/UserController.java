package com.hzq.project.user.web;

import com.hzq.project.system.common.web.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 * Created by hzq on 16/9/19.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping(path = "/registerUser", method = RequestMethod.POST)
    public BaseResult registerUser() {
        return new BaseResult("注册用户成功");
    }
}
