package com.hzq.project.car.service.impl;

import com.hzq.project.car.dao.CarMerchantMapper;
import com.hzq.project.car.dao.SecondCarMapper;
import com.hzq.project.car.dao.entity.CarMerchant;
import com.hzq.project.car.dao.entity.SecondCar;
import com.hzq.project.car.service.SecondCarService;
import com.hzq.project.system.common.exception.BusyOperationException;
import com.hzq.project.system.common.redis.RedisHelper;
import com.hzq.project.user.dao.UserMapper;
import com.hzq.project.user.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hzq on 16/9/25.
 */
@Service
public class SecondCarServiceImpl implements SecondCarService {

    @Autowired
    private SecondCarMapper secondCarMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CarMerchantMapper carMerchantMapper;

    @Override
    public boolean addSecondCar(SecondCar secondCar) {
        if (RedisHelper.compareAndSetRequest("SecondCarServiceImpl ", "addSecondCar:", secondCar.getUserId().toString(), 5))
            throw new BusyOperationException("二手车信息发布中,请稍后");
        //是否为商家
        Integer userId = secondCar.getUserId();
        User user = userMapper.getByPk(userId);
        Integer isMerchant = user.getIsMerchant();
        secondCar.setIsMerchant(isMerchant);
        if (isMerchant == 1) {
            //是商家,设置商家编号
            CarMerchant merchant = carMerchantMapper.getCarMerchantByUserId(userId);
            secondCar.setMerchantId(merchant.getId());
        }
        secondCarMapper.insert(secondCar);
        return true;
    }
}
