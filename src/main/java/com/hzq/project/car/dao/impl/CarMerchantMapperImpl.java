package com.hzq.project.car.dao.impl;

import com.hzq.project.car.dao.CarMerchantMapper;
import com.hzq.project.car.dao.entity.CarMerchant;
import com.hzq.project.system.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by hzq on 16/9/25.
 */
@Repository
public class CarMerchantMapperImpl extends BaseDao<CarMerchant,Integer> implements CarMerchantMapper {
    @Override
    public CarMerchant getCarMerchantByUserId(Integer userId) {
        return selectOne("getCarMerchantByUserId",userId);
    }

    @Override
    public int addWatchCount(Integer id) {
        return updateByParam("addWatchCount",id);
    }
}
