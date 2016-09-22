package com.hzq.project.user.dao;

import com.hzq.project.system.common.dao.Dao;
import com.hzq.project.user.dao.entity.Company;

public interface CompanyMapper extends Dao<Company,Integer>{

    /**
     * 根据企业名称查询企业
     */
    Company selectCompanyByUserName(String userName);

    /**
     * 更新企业最后更新时间
     */
    int updateCompanyUpdateTime(Integer companyId);

    int addWatchCount(Integer id);
}