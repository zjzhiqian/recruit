package com.hzq.project.user.service;

import com.hzq.project.user.dao.entity.Company;

/**
 * CompanyService
 * Created by hzq on 16/9/20.
 */
public interface CompanyService {
    boolean addCompany(Company company);

    Company selectCompanyByUserName(String compnayName);

}
