package com.hzq.project.house.web;

import com.hzq.project.car.exception.CarException;
import com.hzq.project.house.dao.entity.SecondHouse;
import com.hzq.project.house.service.SecondHouseService;
import com.hzq.project.house.vo.SecondHouseListInfo;
import com.hzq.project.house.vo.SecondHouseParam;
import com.hzq.project.house.vo.SecondHouseParamVo;
import com.hzq.project.house.vo.SecondHouseVo;
import com.hzq.project.picture.web.UpLoadController;
import com.hzq.project.system.common.dao.PageResult;
import com.hzq.project.system.common.util.Creator;
import com.hzq.project.system.common.util.ValidatorHelper;
import com.hzq.project.system.common.web.BaseController;
import com.hzq.project.system.common.web.BaseResult;
import com.hzq.project.system.security.annon.RequiresRoles;
import com.hzq.project.system.security.util.Roles;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by hzq on 16/10/16.
 */
@RestController
@RequestMapping("secondHouse")
public class SecondHouseController extends BaseController {
    @Autowired
    SecondHouseService secondHouseService;

    /**
     * 发布二手房
     */
    @RequiresRoles(Roles.USER)
    @RequestMapping(path = "/addSecondHouse", method = RequestMethod.POST)
    public BaseResult addSecondCar(@Valid SecondHouseVo secondHouseVo, BindingResult bindingResult) {
        secondHouseVo.setWatch(0);
        secondHouseVo.setUpdatedAt(null);


        ValidatorHelper.validBindingResult(bindingResult);
        secondHouseVo.setUserId(getUserId());
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


    /**
     * 查询所有二手房子
     */
    @RequestMapping(path = "/getSecondHouse/{id}", method = RequestMethod.GET)
    public SecondHouseVo getSecondCars(@PathVariable Integer id) {
        return secondHouseService.getByPk(id);
    }


    /**
     * 查询二手房详情
     */
    @RequestMapping(path = "/getSecondHouse", method = RequestMethod.GET)
    public PageResult<SecondHouseListInfo> getSecondCars(SecondHouseParamVo paramVo) {
        return secondHouseService.getSecondHouseByParam(buildSecondCarParam(paramVo));
    }


    /**
     * 查询所有二手房子
     */
    @RequestMapping(path = "/addWatchCount/{id}", method = RequestMethod.POST)
    public void addWatchCount(@PathVariable Integer id) {
        secondHouseService.addWatchCount(id);
    }



    private SecondHouseParam buildSecondCarParam(SecondHouseParamVo paramVo) {


        SecondHouseParam param = Creator.newInstance(paramVo, SecondHouseParam.class);
        String title = param.getTitle();
        if (StringUtils.isEmpty(title))
            param.setTitle(null);
        Integer area1 = param.getArea();
        if (area1 == -1) param.setArea(null);

        Integer priceBegin = null;
        Integer priceEnd = null;
        Integer price = paramVo.getPrice();
        if (price == 1) {
            priceBegin = 10;
            priceEnd = 20;
        } else if (price == 2) {
            priceBegin = 20;
            priceEnd = 30;
        } else if (price == 3) {
            priceBegin = 30;
            priceEnd = 50;
        } else if (price == 4) {
            priceBegin = 50;
            priceEnd = 80;
        } else if (price == 5) {
            priceBegin = 80;
            priceEnd = 100;
        } else if (price == 6) {
            priceBegin = 100;
            priceEnd = 120;
        } else if (price == 7) {
            priceBegin = 120;
            priceEnd = 150;
        } else if (price == 8) {
            priceBegin = 150;
        }
        param.setPriceBegin(priceBegin == null ? null : new BigDecimal(priceBegin));
        param.setPriceEnd(priceEnd == null ? null : new BigDecimal(priceEnd));

        Integer BigBegin = null;
        Integer BigEnd = null;
        Integer big = paramVo.getBig();
        if (big == 1) {
            BigBegin = 0;
            BigEnd = 50;
        } else if (big == 2) {
            BigBegin = 50;
            BigEnd = 70;
        } else if (big == 3) {
            BigBegin = 70;
            BigEnd = 100;
        } else if (big == 4) {
            BigBegin = 100;
            BigEnd = 130;
        } else if (big == 5) {
            BigBegin = 130;
            BigEnd = 150;
        } else if (big == 6) {
            BigBegin = 150;
            BigEnd = 200;
        } else if (big == 7) {
            BigBegin = 200;
            BigEnd = 300;
        } else if (big == 8) {
            BigBegin = 300;
            BigEnd = 500;
        } else if (big == 9) {
            BigBegin = 500;
        }
        param.setBigBegin(BigBegin == null ? null : BigBegin);
        param.setBigEnd(BigEnd == null ? null : BigEnd);

        Integer shiBegin = null;
        Integer shiEnd = null;
        Integer shi = paramVo.getShi();
        if (shi == 1) {
            shiBegin = 1;
            shiEnd = 1;
        } else if (shi == 2) {
            shiBegin = 2;
            shiEnd = 2;
        } else if (shi == 3) {
            shiBegin = 3;
            shiEnd = 3;
        } else if (shi == 4) {
            shiBegin = 4;
            shiEnd = 1;
        } else if (shi == 5) {
            shiBegin = 4;
        }
        param.setShiBeGin(shiBegin);
        param.setShiEnd(shiEnd);
        return param;
    }


}
