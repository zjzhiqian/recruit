package com.hzq.project.test.service.impl;

import com.hzq.project.test.dao.BalanceMapper;
import com.hzq.project.test.dao.entity.Balance;
import com.hzq.project.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TestServiceImpl
 * Created by hzq on 16/5/17.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private BalanceMapper balanceMapper;

    @Override
    public void aop01() {
        Balance ba = new Balance();
        ba.setId(1);
        ba.setAmount(BigDecimal.ONE);
        ba.setBalanceableId(4);
        ba.setBalanceableType(4);
        ba.setCreatedAt(new Date());
        ba.setDeletedAt(new Date());
        ba.setUpdatedAt(new Date());
        balanceMapper.insert(ba);
    }
}
