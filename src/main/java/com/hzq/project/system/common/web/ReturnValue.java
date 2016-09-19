package com.hzq.project.system.common.web;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ReturnValue
 * Created by hzq on 16/9/19.
 */
public class ReturnValue implements Serializable {
    private boolean success;
    private Object data;

    public ReturnValue(boolean flag) {
        success = flag;
    }

    public ReturnValue(boolean flag, Object code, String error) {
        success = flag;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("code", code);
        paramMap.put("error", error);
        data = paramMap;
    }

    public ReturnValue(boolean flag, Object data) {
        success = flag;
        this.data = data;
    }

    public static ReturnValue generateFalseReturnValue(Object data) {
        ReturnValue rv = new ReturnValue(false);
        rv.setData(data);
        return rv;
    }

    public static ReturnValue generateFalseReturnValue(Object code, String error) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("code", code);
        paramMap.put("error", error);
        return generateFalseReturnValue(paramMap);
    }

    public static ReturnValue generateTrueReturnValue() {
        ReturnValue rv = new ReturnValue(true);
        return rv;
    }

    public static ReturnValue generateTrueReturnValue(Object data) {
        ReturnValue rv = generateTrueReturnValue();
        rv.setData(data);
        return rv;
    }

    public boolean isSuccess() {
        return this.success ? true : false;
    }

    public void setSuccess(boolean flag) {
        this.success = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
