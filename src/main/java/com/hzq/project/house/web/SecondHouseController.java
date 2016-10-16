package com.hzq.project.house.web;

import com.hzq.project.car.dao.entity.SecondCar;
import com.hzq.project.car.exception.CarException;
import com.hzq.project.car.vo.SecondCarVo;
import com.hzq.project.house.dao.entity.SecondHouse;
import com.hzq.project.house.service.SecondHouseService;
import com.hzq.project.house.vo.SecondHouseVo;
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
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by hzq on 16/10/16.
 */
@RestController
@RequestMapping("secondHouse")
public class SecondHouseController extends BaseController{
    @Autowired
    SecondHouseService secondHouseService;

    /**
     * 发布二手房
     */
    @RequiresRoles(Roles.USER)
    @RequestMapping(path = "/addSecondHouse", method = RequestMethod.POST)
    public BaseResult addSecondCar(@Valid SecondHouseVo secondHouseVo, BindingResult bindingResult) {
        ValidatorHelper.validBindingResult(bindingResult);
        secondHouseVo.setUserId(getUserId());
//        secondCarVo.setPictue("/upload/" + UpLoadController.SECOND_HOUSE + "/" + secondCarVo.getPictue());
        //照片url
        StringJoiner joiner = new StringJoiner(",");
        String[] urls = secondHouseVo.getCarPic().split(",");
        if (urls.length > 8)
            throw new CarException("最多只能上传8张二手房图片");
        Arrays.stream(secondHouseVo.getCarPic().split(",")).forEach(str -> {
            str = "/upload/" + UpLoadController.SECOND_HOUSE + "/" + str;
            joiner.add(str);
        });
        secondHouseVo.setCarPic(joiner.toString());
        SecondHouse house = Creator.newInstance(secondHouseVo, SecondHouse.class);
        secondHouseService.addSecondCar(house);
        return new BaseResult("发布二手房信息成功");
    }
}
