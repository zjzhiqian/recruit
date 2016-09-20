package com.hzq.project.user.service.impl;

import com.hzq.project.system.common.exception.BusyOperationException;
import com.hzq.project.system.common.redis.RedisHelper;
import com.hzq.project.user.dao.UserMapper;
import com.hzq.project.user.dao.entity.User;
import com.hzq.project.user.exception.UserException;
import com.hzq.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 * Created by hzq on 16/9/20.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        if (RedisHelper.compareAndSetRequest("UserServiceImpl ", "addUser:", user.getUserName(), 5))
            throw new BusyOperationException("注册中,请稍后");
        User dbUser = userMapper.selectUserByUserName(user.getUserName());
        if (dbUser != null) throw new UserException("用户名已存在");
        userMapper.insert(user);
        return true;
    }


    @Override
    public User selectUserByUserName(String userName){
        return userMapper.selectUserByUserName(userName);
    }
}
