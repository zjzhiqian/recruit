package com.hzq.project.car.dao.impl;

import com.hzq.project.car.dao.SecondCarMapper;
import com.hzq.project.car.dao.entity.SecondCar;
import com.hzq.project.car.vo.SecondCarInfo;
import com.hzq.project.car.vo.SecondCarParam;
import com.hzq.project.system.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hzq on 16/9/25.
 */
@Repository
public class SecondCarMapperImpl extends BaseDao<SecondCar, Integer> implements SecondCarMapper {
    @Override
    public Integer setSecondCarIsMerchantByUserId(Integer userId) {
        return updateByParam("setSecondCarIsMerchantByUserId", userId);
    }


    @Override
    public List<SecondCarInfo> getSecondCarParamList(SecondCarParam param) {
        return this.getSqlSession().selectList(getIbatisSqlMapNamespace() + ".getSecondCarParamList", param);
    }

    @Override
    public Integer getSecondCarParamCount(SecondCarParam param) {
        return this.getSqlSession().selectOne(getIbatisSqlMapNamespace() + ".getSecondCarParamCount", param);
    }

    @Override
    public int addWatchCount(Integer id) {
        return updateByParam("addWatchCount",id);
    }

    @Override
    public List<SecondCarInfo> getCarMerchantRecommendedByMerchantId(Integer id) {
        return this.getSqlSession().selectList("getCarMerchantRecommendedByMerchantId",id);
    }
}
