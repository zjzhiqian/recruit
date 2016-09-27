package com.hzq.project.car.dao;

import com.hzq.project.car.dao.entity.SecondCar;
import com.hzq.project.car.vo.SecondCarInfo;
import com.hzq.project.car.vo.SecondCarParam;
import com.hzq.project.system.common.dao.Dao;

import java.util.List;

public interface SecondCarMapper extends Dao<SecondCar,Integer> {
    /**
     * 根据userId把 二手车信息 是否为商家二手车设置为1
     */
    Integer setSecondCarIsMerchantByUserId(Integer userId);


    List<SecondCarInfo> getSecondCarParamList(SecondCarParam param);

    Integer getSecondCarParamCount(SecondCarParam param);
}