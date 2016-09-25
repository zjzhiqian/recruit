package com.hzq.project.car.web;

import com.hzq.project.car.dao.entity.CarMerchant;
import com.hzq.project.car.service.CarMerchantService;
import com.hzq.project.car.vo.CarMerchantVo;
import com.hzq.project.picture.web.UpLoadController;
import com.hzq.project.system.common.util.Creator;
import com.hzq.project.system.common.util.ValidatorHelper;
import com.hzq.project.system.common.web.BaseController;
import com.hzq.project.system.common.web.BaseResult;
import com.hzq.project.system.security.annon.RequiresRoles;
import com.hzq.project.system.security.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by hzq on 16/9/25.
 */
@RestController
@RequestMapping("cartMerchant")
public class CarMerchantController extends BaseController {
    @Autowired
    private CarMerchantService carMerchantService;


    /**
     * 新增注册商家
     */
    @RequiresRoles(Roles.USER)
    @RequestMapping(path = "/addCarMerchant", method = RequestMethod.POST)
    public BaseResult registerUser(@Valid CarMerchantVo carMerchantVo, BindingResult bindingResult) {
        ValidatorHelper.validBindingResult(bindingResult);
        carMerchantVo.setUserId(getUserId());
        carMerchantVo.setPicture("/upload/" + UpLoadController.CAR_MERCHANT + "/" + carMerchantVo.getPicture());
        carMerchantVo.setIdCard("/upload/" + UpLoadController.CAR_MERCHANT + "/" + carMerchantVo.getIdCard());
        CarMerchant carMerchant = Creator.newInstance(carMerchantVo, CarMerchant.class);
        carMerchantService.addCarMerchant(carMerchant);
        return new BaseResult("注册商家成功");
    }

}
