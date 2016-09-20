package com.hzq.project.user.dao;

import com.hzq.project.system.common.dao.Dao;
import com.hzq.project.user.dao.entity.Company;

public interface CompanyMapper extends Dao<Company,Integer>{

    Company selectCompanyByUserName(String userName);
}