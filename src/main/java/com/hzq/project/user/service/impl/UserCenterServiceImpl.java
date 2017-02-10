package com.hzq.project.user.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hzq.project.car.dao.SecondCarMapper;
import com.hzq.project.car.dao.entity.SecondCar;
import com.hzq.project.house.dao.SecondHouseMapper;
import com.hzq.project.house.dao.entity.SecondHouse;
import com.hzq.project.resume.dao.RecruitmentMapper;
import com.hzq.project.resume.dao.entity.Recruitment;
import com.hzq.project.system.common.dao.Dao;
import com.hzq.project.user.service.UserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by hzq on 17/2/10.
 */
@Service
public class UserCenterServiceImpl implements UserCenterService {

    @Autowired
    SecondHouseMapper secondHouseMapper;

    @Autowired
    SecondCarMapper secondCarMapper;

    @Autowired
    RecruitmentMapper recruitmentMapper;

    @Override
    public List<Map<String, Object>> getPostList(Integer userType, Integer logInId) {
        //url,title,create
        List<Map<String, Object>> resultList = Lists.newArrayList();
        //普通用户 二手车/二手房
        if (userType == 1) {
            List<SecondCar> secondCarList = secondCarMapper.getSecondCarByUserId(logInId);
            secondCarList.forEach(secondCar -> {
                HashMap<String, Object> map = Maps.newHashMap();
                map.put("createAt", secondCar.getCreatedAt());
                map.put("url", "TwBusDea.html?id=" + secondCar.getId());
                map.put("title", secondCar.getTitle());
                map.put("watch", secondCar.getWatch());
                resultList.add(map);
            });
            List<SecondHouse> secondHouseList = secondHouseMapper.getSecondHouseByUserId(logInId);
            secondHouseList.forEach(secondHouse -> {
                HashMap<String, Object> map = Maps.newHashMap();
                map.put("createAt", secondHouse.getCreatedAt());
                map.put("url", "TwHouDea.html?id=" + secondHouse.getId());
                map.put("title", secondHouse.getTitle());
                map.put("watch", secondHouse.getWatch());
                resultList.add(map);
            });
        }
        if (userType == 2) {
            List<Recruitment> recruitmentList = recruitmentMapper.getRecruitmentsByCompanyId(logInId);
            recruitmentList.forEach(recruitment -> {
                HashMap<String, Object> map = Maps.newHashMap();
                map.put("createAt", recruitment.getCreatedAt());
                map.put("url", "WorkInfo.html?id=" + recruitment.getId() + "companyId=" + recruitment.getCompanyId());
                map.put("title", recruitment.getTitle());
                map.put("watch", recruitment.getWatch());
                resultList.add(map);
            });
        }
        resultList.sort((o1, o2) -> {
            Date createAt = (Date) o1.get("createAt");
            Date createAt2 = (Date) o2.get("createAt");
            return createAt.before(createAt2) ? 1 : -1;
        });
        //企业用户 招聘信息
        return resultList.subList(0, resultList.size() > 15 ? 15 : resultList.size());
    }
}
