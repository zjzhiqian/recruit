package com.hzq.project.user.dao.impl;

import com.hzq.project.system.common.dao.BaseDao;
import com.hzq.project.user.dao.SysParamMapper;
import com.hzq.project.user.dao.entity.SysParam;
import org.springframework.stereotype.Repository;

@Repository
public class SysParamMapperImpl extends BaseDao<SysParam, Integer> implements SysParamMapper {

    @Override
    public Integer getParamByKey(String key) {
        return getSqlSession().selectOne(getIbatisSqlMapNamespace() + ".getParamByKey", key);
    }

    @Override
    public void addLogCount() {
        getSqlSession().update(getIbatisSqlMapNamespace() + ".addLogCount", "logCount");
    }
}