package com.hzq.project.user.dao.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.hzq.project.system.common.dao.BaseDao;
import com.hzq.project.user.dao.FavorMapper;
import com.hzq.project.user.dao.entity.Favor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by hzq on 17/1/26.
 */
@Repository
public class FavorMapperImpl extends BaseDao<Favor, Integer> implements FavorMapper {
    @Override
    public int deleteByUserIdAndTypeAndRelationId(Integer userId, Integer type, Integer relationId,Integer userType) {
        return updateByParam(".deleteByUserIdAndTypeAndRelationId", ImmutableMap.of("userId", userId, "type", type, "relationId", relationId,"userType","userType"));
    }

    @Override
    public int getFavorCount(Integer userId, Integer type, Integer relationId, Integer isFavor,Integer userType) {;
        return getSqlSession().selectOne(getIbatisSqlMapNamespace() + ".getFavorCount", ImmutableMap.of("userId", userId, "type", type, "relationId", relationId, "isFavor", isFavor,"userType",userType));
    }

    @Override
    public List<Favor> favorList(Integer userId,Integer userType) {

        return selectList("favorList",ImmutableMap.of("userType",userType,"userId",userId));
    }
}
