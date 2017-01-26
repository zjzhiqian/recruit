package com.hzq.project.user.service.impl;

import com.hzq.project.user.dao.FavorMapper;
import com.hzq.project.user.dao.entity.Favor;
import com.hzq.project.user.service.FavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hzq on 17/1/26.
 */
@Service
public class FavorServiceImpl implements FavorService {

    @Autowired
    FavorMapper favorMapper;

    @Override
    public void addFavor(Favor favor) {
        favorMapper.insert(favor);
    }

    @Override
    public void deleteByUserIdAndTypeAndRelationId(Integer userId, Integer type, Integer relationId,Integer userType) {
        favorMapper.deleteByUserIdAndTypeAndRelationId(userId, type, relationId,userType);
    }

    @Override
    public Integer getIsFavor(Integer userId, Integer type, Integer relationId, Integer isFavor,Integer userType) {
        return favorMapper.getFavorCount(userId, type, relationId, isFavor,userType) > 0 ? 1 : 0;

    }

    @Override
    public List<Favor> favorList(Integer userId,Integer userType) {
        return favorMapper.favorList(userId,userType);
    }
}
