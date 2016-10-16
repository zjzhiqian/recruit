package com.hzq.project.house.service.impl;

import com.hzq.project.house.dao.SecondHouseMapper;
import com.hzq.project.house.dao.entity.SecondHouse;
import com.hzq.project.house.service.SecondHouseService;
import com.hzq.project.system.common.exception.BusyOperationException;
import com.hzq.project.system.common.redis.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hzq on 16/10/16.
 */
@Service
public class SecondHouseServiceImpl implements SecondHouseService {

    @Autowired
    SecondHouseMapper secondHouseMapper;

    @Override
    public boolean addSecondCar(SecondHouse house) {
        if (RedisHelper.compareAndSetRequest("SecondHouseServiceImpl ", "addSecondCar:", house.getUserId().toString(), 5))
            throw new BusyOperationException("发布中,请稍后");
        return secondHouseMapper.insert(house) > 0;
    }
}
