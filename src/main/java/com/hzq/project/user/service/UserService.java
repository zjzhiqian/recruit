package com.hzq.project.user.service;

import com.hzq.project.user.dao.entity.User;

/**
 * UserService
 * Created by hzq on 16/9/20.
 */
public interface UserService {
    boolean addUser(User user);
    User selectUserByUserName(String userName);
}
