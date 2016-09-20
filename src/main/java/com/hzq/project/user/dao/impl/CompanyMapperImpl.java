package com.hzq.project.user.dao.impl;

import com.hzq.project.system.common.dao.BaseDao;
import com.hzq.project.user.dao.CompanyMapper;
import com.hzq.project.user.dao.entity.Company;
import org.springframework.stereotype.Repository;

/**
 * CompanyMapperImpl
 * Created by hzq on 16/9/20.
 */
@Repository
public class CompanyMapperImpl extends BaseDao<Company, Integer> implements CompanyMapper {
    @Override
    public Company selectCompanyByUserName(String userName) {
        return selectOne("selectCompanyByUserName", userName);
    }
}
