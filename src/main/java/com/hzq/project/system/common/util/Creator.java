package com.hzq.project.system.common.util;

import net.sf.cglib.core.ReflectUtils;
import org.springframework.beans.BeanUtils;

/**
 * Creator
 * Created by hzq on 16/9/20.
 */
public class Creator {


    public static <T, S> T newInstance(S s, Class<T> c) {
        if (s == null) return null;
        T t = (T) ReflectUtils.newInstance(c);
        BeanUtils.copyProperties(s, t);
        return t;
    }

}
