package com.hzq.project.car.service;

import com.hzq.project.car.dao.entity.CarMerchant;
import com.hzq.project.car.vo.CarMerchantView;

/**
 * Created by hzq on 16/9/25.
 */
public interface CarMerchantService {
    /**
     * 注册商家
     */
    boolean addCarMerchant(CarMerchant carMerchant);

    /**
     * 根据id查询商家
     */
    CarMerchantView getCarMerchantById(Integer id);
}
