package com.hzq.project.user.dao;

import com.hzq.project.system.common.dao.Dao;
import com.hzq.project.user.dao.entity.Favor;

import java.util.List;

public interface FavorMapper extends Dao<Favor,Integer> {
    int deleteByUserIdAndTypeAndRelationId(Integer userId, Integer type, Integer relationId ,Integer userType);

    int getFavorCount(Integer userId, Integer type, Integer relationId, Integer isFavor,Integer userType);

    List<Favor> favorList(Integer userId,Integer userType);
}
