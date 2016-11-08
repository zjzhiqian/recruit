package com.hzq.project.car.dao;

import com.hzq.project.car.dao.entity.CarMerchant;
import com.hzq.project.system.common.dao.Dao;

public interface CarMerchantMapper extends Dao<CarMerchant,Integer> {
    CarMerchant getCarMerchantByUserId(Integer userId);

    int addWatchCount(Integer id);
}