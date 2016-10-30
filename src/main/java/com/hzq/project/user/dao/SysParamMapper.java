package com.hzq.project.user.dao;

import com.hzq.project.system.common.dao.Dao;
import com.hzq.project.user.dao.entity.SysParam;

public interface SysParamMapper extends Dao<SysParam, Integer> {
    Integer getParamByKey(String key);

    void addLogCount();
}