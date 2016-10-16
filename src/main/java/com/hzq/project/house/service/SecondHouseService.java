package com.hzq.project.house.service;

import com.hzq.project.house.dao.entity.SecondHouse;
import com.hzq.project.house.vo.SecondHouseListInfo;
import com.hzq.project.house.vo.SecondHouseParam;
import com.hzq.project.house.vo.SecondHouseVo;
import com.hzq.project.system.common.dao.PageResult;

/**
 * Created by hzq on 16/10/16.
 */
public interface SecondHouseService {
    boolean addSecondCar(SecondHouse house);

    PageResult<SecondHouseListInfo> getSecondHouseByParam(SecondHouseParam secondHouseParam);

    SecondHouseVo getByPk(Integer id);

    void addWatchCount(Integer id);
}

