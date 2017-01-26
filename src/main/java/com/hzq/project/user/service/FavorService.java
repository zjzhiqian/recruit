package com.hzq.project.user.service;

import com.hzq.project.user.dao.entity.Favor;

import java.util.List;

/**
 * Created by hzq on 17/1/26.
 */
public interface FavorService {


    /**
     * 添加收藏 举报
     */
    void addFavor(Favor favor);

    /**
     * 取消收藏举报
     */
    void deleteByUserIdAndTypeAndRelationId(Integer userId, Integer type, Integer relationId,Integer userType);

    Integer getIsFavor(Integer userId, Integer type, Integer relationId, Integer isFavor,Integer userType);

    List<Favor> favorList(Integer userId,Integer userType);
}
