package com.hzq.project.house.dao;

import com.hzq.project.house.dao.entity.SecondHouse;
import com.hzq.project.house.vo.SecondHouseListInfo;
import com.hzq.project.house.vo.SecondHouseParam;
import com.hzq.project.system.common.dao.Dao;

import java.util.List;

public interface SecondHouseMapper extends Dao<SecondHouse,Integer> {
    List<SecondHouseListInfo> getSecondHouseParamList(SecondHouseParam param);

    Integer getSecondHouseParamCount(SecondHouseParam param);

    void addWatchCount(Integer id);


}