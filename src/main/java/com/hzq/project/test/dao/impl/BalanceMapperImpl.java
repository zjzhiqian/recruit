package com.hzq.project.test.dao.impl;

import com.hzq.project.system.common.dao.BaseDao;
import com.hzq.project.test.dao.BalanceMapper;
import com.hzq.project.test.dao.entity.Balance;
import org.springframework.stereotype.Repository;

/**
 * BalanceMapperImpl
 * Created by hzq on 16/9/19.
 */
@Repository
public class BalanceMapperImpl  extends BaseDao<Balance,Integer> implements BalanceMapper {
}
