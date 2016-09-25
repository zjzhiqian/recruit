package com.hzq.project.user.dao;


import com.hzq.project.system.common.dao.Dao;
import com.hzq.project.user.dao.entity.User;

public interface UserMapper extends Dao<User,Integer> {

    User selectUserByUserName(String userName);

    Integer setUserAsCarMerchant(Integer userId);
}