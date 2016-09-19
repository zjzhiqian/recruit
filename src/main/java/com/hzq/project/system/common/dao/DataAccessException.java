package com.hzq.project.system.common.dao;

/**
 * DataAccessException
 * Created by hzq on 16/9/19.
 */
public class DataAccessException extends org.springframework.dao.DataAccessException {
    private static final long serialVersionUID = 3352628982583502006L;

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
