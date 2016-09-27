package com.hzq.project.car.service;

import com.hzq.project.car.dao.entity.SecondCar;
import com.hzq.project.car.vo.SecondCarInfo;
import com.hzq.project.car.vo.SecondCarParam;
import com.hzq.project.system.common.dao.PageResult;

/**
 * Created by hzq on 16/9/25.
 */
public interface SecondCarService {
    boolean addSecondCar(SecondCar secondCar);

    PageResult<SecondCarInfo> getSecondCarByParam(SecondCarParam secondCarParam);
}
