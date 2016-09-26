package com.hzq.project.car.dao.impl;

import com.hzq.project.car.dao.SecondCarMapper;
import com.hzq.project.car.dao.entity.SecondCar;
import com.hzq.project.system.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by hzq on 16/9/25.
 */
@Repository
public class SecondCarMapperImpl  extends BaseDao<SecondCar,Integer> implements SecondCarMapper{
    @Override
    public Integer setSecondCarIsMerchantByUserId(Integer userId) {
        return updateByParam("setSecondCarIsMerchantByUserId",userId);
    }
}
