package com.hzq.project.user.service;

import java.util.List;
import java.util.Map;

/**
 * Created by hzq on 17/2/10.
 */
public interface UserCenterService {
    List<Map<String,Object>> getPostList(Integer userType, Integer logInId);
}


