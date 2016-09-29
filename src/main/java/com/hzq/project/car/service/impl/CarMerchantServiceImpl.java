package com.hzq.project.car.service.impl;

import com.hzq.project.car.dao.CarMerchantMapper;
import com.hzq.project.car.dao.SecondCarMapper;
import com.hzq.project.car.dao.entity.CarMerchant;
import com.hzq.project.car.exception.CarException;
import com.hzq.project.car.exception.CarMerchantException;
import com.hzq.project.car.service.CarMerchantService;
import com.hzq.project.car.vo.CarMerchantView;
import com.hzq.project.system.common.exception.BusyOperationException;
import com.hzq.project.system.common.redis.RedisHelper;
import com.hzq.project.system.common.util.Creator;
import com.hzq.project.user.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * CarMerchantServiceImpl
 * Created by hzq on 16/9/25.
 */
@Service
public class CarMerchantServiceImpl implements CarMerchantService {

    @Autowired
    private CarMerchantMapper carMerchantMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SecondCarMapper secondCarMapper;

    @Override
    public boolean addCarMerchant(CarMerchant carMerchant) {
        Integer userId = carMerchant.getUserId();

        if (RedisHelper.compareAndSetRequest("CarMerchantServiceImpl ", "addCarMerchant:", userId.toString(), 5))
            throw new BusyOperationException("注册中,请稍后");
        CarMerchant dbCarMerchant = carMerchantMapper.getCarMerchantByUserId(userId);
        if (dbCarMerchant != null)
            throw new CarMerchantException("您已经注册成为商家,请勿重复注册");
        userMapper.setUserAsCarMerchant(userId);
        carMerchantMapper.insert(carMerchant);
        //注册成功后 将其之前发布的二手车信息标为商家
        secondCarMapper.setSecondCarIsMerchantByUserId(userId);
        return true;
    }

    @Override
    public CarMerchantView getCarMerchantById(Integer id) {
        CarMerchant carMerchant = Optional.ofNullable(carMerchantMapper.getByPk(id)).orElseThrow(() -> new CarException("商家不存在"));
        if (carMerchant.getUpdatedAt() == null) carMerchant.setUpdatedAt(carMerchant.getCreatedAt());
        return Creator.newInstance(carMerchant, CarMerchantView.class);
    }
}
