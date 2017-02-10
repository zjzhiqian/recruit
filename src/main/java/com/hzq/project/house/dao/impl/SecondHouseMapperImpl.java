package com.hzq.project.house.dao.impl;

import com.hzq.project.house.dao.SecondHouseMapper;
import com.hzq.project.house.dao.entity.SecondHouse;
import com.hzq.project.house.vo.SecondHouseListInfo;
import com.hzq.project.house.vo.SecondHouseParam;
import com.hzq.project.system.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SecondHouseMapperImpl extends BaseDao<SecondHouse, Integer> implements SecondHouseMapper {
    @Override
    public List<SecondHouseListInfo> getSecondHouseParamList(SecondHouseParam param) {
        return getSqlSession().selectList(getIbatisSqlMapNamespace() + ".getSecondHouseParamList", param);
    }

    @Override
    public Integer getSecondHouseParamCount(SecondHouseParam param) {
        return getSqlSession().selectOne(getIbatisSqlMapNamespace() + ".getSecondHouseParamCount", param);
    }

    @Override
    public void addWatchCount(Integer id) {
        updateByParam("addWatchCount", id);
    }

    @Override
    public List<SecondHouse> getSecondHouseByUserId(Integer userId) {
        return selectList("getSecondHouseByUserId", userId);
    }
}