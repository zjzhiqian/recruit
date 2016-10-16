package com.hzq.project.house.service.impl;

import com.hzq.project.car.vo.SecondCarInfo;
import com.hzq.project.house.dao.SecondHouseMapper;
import com.hzq.project.house.dao.entity.SecondHouse;
import com.hzq.project.house.exception.HouseException;
import com.hzq.project.house.service.SecondHouseService;
import com.hzq.project.house.vo.SecondHouseListInfo;
import com.hzq.project.house.vo.SecondHouseParam;
import com.hzq.project.house.vo.SecondHouseVo;
import com.hzq.project.system.common.dao.PageResult;
import com.hzq.project.system.common.exception.BusyOperationException;
import com.hzq.project.system.common.redis.RedisHelper;
import com.hzq.project.system.common.util.Creator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * Created by hzq on 16/10/16.
 */
@Service
public class SecondHouseServiceImpl implements SecondHouseService {

    @Autowired
    SecondHouseMapper secondHouseMapper;

    @Override
    public boolean addSecondCar(SecondHouse house) {
        if (RedisHelper.compareAndSetRequest("SecondHouseServiceImpl ", "addSecondCar:", house.getUserId().toString(), 5))
            throw new BusyOperationException("发布中,请稍后");
        return secondHouseMapper.insert(house) > 0;
    }

    @Override
    public PageResult<SecondHouseListInfo> getSecondHouseByParam(SecondHouseParam param) {
        Integer current = param.getCurrent();
        Integer per = param.getPer();
        List<SecondHouseListInfo> pageData = secondHouseMapper.getSecondHouseParamList(param);
        pageData.forEach(info -> info.setImg(info.getCarPic().split(",")[0]));
        Integer count = secondHouseMapper.getSecondHouseParamCount(param);
        return new PageResult<>(current, per, count, pageData);
    }

    @Override
    public SecondHouseVo getByPk(Integer id) {
        SecondHouse byPk = Optional.of(secondHouseMapper.getByPk(id)).orElseThrow(() -> new HouseException("二手房信息不存在"));
        SecondHouseVo vo = Creator.newInstance(byPk, SecondHouseVo.class);
        BigDecimal price = vo.getPrice();
        Integer big = vo.getBig();
        vo.setPerPrice(Integer.parseInt(price.multiply(new BigDecimal(10000)).divide(new BigDecimal(big), 0, RoundingMode.HALF_UP).toString()));
        String[] carPics = vo.getCarPic().split(",");
        vo.setImg(carPics[0]);
        StringJoiner joiner = new StringJoiner("");
        Arrays.stream(carPics).forEach(pic -> joiner.add("<img src=\"" + pic + "\">"));
        vo.setCarPic(joiner.toString());
        return vo;
    }

    @Override
    public void addWatchCount(Integer id) {
        secondHouseMapper.addWatchCount(id);
    }
}
