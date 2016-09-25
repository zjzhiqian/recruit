package com.hzq.project.user.dao.impl;

import com.hzq.project.system.common.dao.BaseDao;
import com.hzq.project.user.dao.UserMapper;
import com.hzq.project.user.dao.entity.User;
import org.springframework.stereotype.Repository;

/**
 * UserMapperImpl
 * Created by hzq on 16/9/20.
 */
@Repository
public class UserMapperImpl extends BaseDao<User, Integer> implements UserMapper {
    @Override
    public User selectUserByUserName(String userName) {
        return selectOne("selectUserByUserName", userName);
    }

    @Override
    public Integer setUserAsCarMerchant(Integer userId) {
        return updateByParam("setUserAsCarMerchant",userId);
    }
}
