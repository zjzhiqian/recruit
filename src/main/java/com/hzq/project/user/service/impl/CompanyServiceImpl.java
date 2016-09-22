package com.hzq.project.user.service.impl;

import com.hzq.project.system.common.exception.BusyOperationException;
import com.hzq.project.system.common.redis.RedisHelper;
import com.hzq.project.system.common.util.Creator;
import com.hzq.project.user.dao.CompanyMapper;
import com.hzq.project.user.dao.entity.Company;
import com.hzq.project.user.exception.UserException;
import com.hzq.project.user.service.CompanyService;
import com.hzq.project.user.vo.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CompanyService
 * Created by hzq on 16/9/20.
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;


    @Override
    public boolean addCompany(Company company) {
        if (RedisHelper.compareAndSetRequest("CompanyServiceImpl ", "addCompany:", company.getUserName(), 5))
            throw new BusyOperationException("注册中,请稍后");
        Company dbCompany = companyMapper.selectCompanyByUserName(company.getUserName());
        if (dbCompany != null) throw new UserException("用户名已存在");
        companyMapper.insert(company);
        return true;
    }


    @Override
    public Company selectCompanyByUserName(String userName) {
        return companyMapper.selectCompanyByUserName(userName);
    }

    @Override
    public CompanyInfo getCompanyInfoById(Integer id) {
        Company company = companyMapper.getByPk(id);
        if (company == null)
            throw new UserException("企业不存在");
        //添加已查看数
        companyMapper.addWatchCount(id);
        return Creator.newInstance(company, CompanyInfo.class);
    }
}
