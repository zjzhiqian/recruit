package com.hzq.project.user.service.impl;

import com.hzq.project.user.dao.SysParamMapper;
import com.hzq.project.user.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hzq on 16/10/20.
 */
@Service
public class SysParamServiceImpl implements SysParamService {
    @Autowired
    SysParamMapper sysParamMapper;

    @Override
    public Integer getParamByKey(String key) {
        return sysParamMapper.getParamByKey(key);
    }

    @Override
    public void addLogCount() {
        sysParamMapper.addLogCount();
    }
}
