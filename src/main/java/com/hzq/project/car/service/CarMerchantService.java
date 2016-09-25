package com.hzq.project.car.service;

import com.hzq.project.car.dao.entity.CarMerchant;

/**
 * Created by hzq on 16/9/25.
 */
public interface CarMerchantService {
    /**
     * 注册商家
     */
    boolean addCarMerchant(CarMerchant carMerchant);
}
