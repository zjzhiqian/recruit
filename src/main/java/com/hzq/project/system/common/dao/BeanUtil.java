package com.hzq.project.system.common.dao;

import net.sf.cglib.beans.BeanMap;

import java.util.Map;

/**
 * BeanUtil
 * Created by hzq on 16/9/19.
 */
public class BeanUtil {

    public static Map<String, Object> bean2Map(Object bean) {
        BeanMap beanMap = BeanMap.create(bean);
        return beanMap;
    }
}
