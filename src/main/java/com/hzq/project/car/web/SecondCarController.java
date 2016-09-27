package com.hzq.project.car.web;

import com.alibaba.fastjson.JSON;
import com.hzq.project.car.dao.entity.SecondCar;
import com.hzq.project.car.exception.CarException;
import com.hzq.project.car.service.SecondCarService;
import com.hzq.project.car.vo.SecondCarInfo;
import com.hzq.project.car.vo.SecondCarParam;
import com.hzq.project.car.vo.SecondCarParamVo;
import com.hzq.project.car.vo.SecondCarVo;
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
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * Created by hzq on 16/9/25.
 */
@RestController
@RequestMapping("secondCar")
public class SecondCarController extends BaseController {
    @Autowired
    private SecondCarService secondCarService;


    /**
     * 发布二手车
     */
    @RequiresRoles(Roles.USER)
    @RequestMapping(path = "/addSecondCar", method = RequestMethod.POST)
    public BaseResult addSecondCar(@Valid SecondCarVo secondCarVo, BindingResult bindingResult) {
        ValidatorHelper.validBindingResult(bindingResult);
        secondCarVo.setUserId(getUserId());

        //驾照
        secondCarVo.setPictue("/upload/" + UpLoadController.CAR_MERCHANT + "/" + secondCarVo.getPictue());
        //汽车照片url
        StringJoiner joiner = new StringJoiner(",");

        String[] urls = secondCarVo.getCarPic().split(",");
        if (urls.length > 8)
            throw new CarException("最多只能上传8张汽车图片");
        Arrays.stream(secondCarVo.getCarPic().split(",")).forEach(str -> {
            str = "/upload/" + UpLoadController.CAR_MERCHANT + "/" + str;
            joiner.add(str);
        });
        secondCarVo.setCarPic(joiner.toString());
        SecondCar secondCar = Creator.newInstance(secondCarVo, SecondCar.class);
        secondCarService.addSecondCar(secondCar);
        return new BaseResult("发布二手车信息成功");
    }

    /**
     * 查询所有二手车
     */
    @RequestMapping(path = "/getSecondCars", method = RequestMethod.GET)
    public PageResult<SecondCarInfo> getSecondCars(SecondCarParamVo secondCarVo) {
        return secondCarService.getSecondCarByParam(buildSecondCarParam(secondCarVo));
    }


    /**
     * 查询指定二手车
     */
    @RequestMapping(path = "/getSecondCar", method = RequestMethod.GET)
    public SecondCar getSecondCar(Integer id) {
        return Optional.ofNullable(secondCarService.getSecondCarById(id)).orElseThrow(() -> new CarException("此二手车信息不存在"));
    }

    private SecondCarParam buildSecondCarParam(SecondCarParamVo secondCarParamVo) {
        String title = secondCarParamVo.getTitle();
        if (StringUtils.isEmpty(title))
            secondCarParamVo.setTitle(null);
        //汽车类型
        Integer type = secondCarParamVo.getType();
        if (type == null || type == -1)
            secondCarParamVo.setType(null);
        //车龄
        Integer year = secondCarParamVo.getYear();
        if (year == null || year == -1)
            secondCarParamVo.setYear(null);

        Integer isMerchant = secondCarParamVo.getIsMerchant();
        if (isMerchant == null || isMerchant == -1)
            secondCarParamVo.setIsMerchant(null);

        SecondCarParam param = Creator.newInstance(secondCarParamVo, SecondCarParam.class);
        param.setPage(secondCarParamVo.getPage());
        //汽车价格
        BigDecimal priceBegin = null;
        BigDecimal priceEnd = null;
        Integer level = secondCarParamVo.getLevel();
        if (level != null) {
            if (level == 0) {
                priceBegin = BigDecimal.ZERO;
                priceEnd = new BigDecimal(3);
            } else if (level == 1) {
                priceBegin = new BigDecimal(3);
                priceEnd = new BigDecimal(5);
            } else if (level == 2) {
                priceBegin = new BigDecimal(5);
                priceEnd = new BigDecimal(10);
            } else if (level == 3) {
                priceBegin = new BigDecimal(10);
                priceEnd = new BigDecimal(15);
            } else if (level == 4) {
                priceBegin = new BigDecimal(15);
                priceEnd = new BigDecimal(20);
            } else if (level == 5) {
                priceBegin = new BigDecimal(20);
                priceEnd = new BigDecimal(30);
            } else if (level == 6) {
                priceBegin = new BigDecimal(30);
                priceEnd = new BigDecimal(60);
            } else if (level == 7) {
                priceBegin = new BigDecimal(60);
                priceEnd = new BigDecimal(9999);
            }
        }

        param.setPriceBegin(priceBegin);
        param.setPriceEnd(priceEnd);
        return param;
    }


}


