package com.hzq.project.system.common.dao;

/**
 * Dao
 * Created by hzq on 16/9/19.
 */

import java.io.Serializable;
import java.util.List;
import org.springframework.dao.DataAccessException;

public interface Dao<E, PK extends Serializable> {
    E getByPk(PK var1) throws DataAccessException;

    E selectOne(Object var1) throws DataAccessException;

    E selectOne(String var1, Object var2) throws DataAccessException;

    Long getCount(Object var1);

    Long getCount(String var1, Object var2);

    int deleteByPk(PK var1) throws DataAccessException;

    int delete(E var1) throws DataAccessException;

    int delete(String var1, E var2) throws DataAccessException;

    int insert(E var1) throws DataAccessException;

    int update(E var1) throws DataAccessException;

    int update(String var1, E var2) throws DataAccessException;

    int updateByParam(String var1, Object var2);

    List<E> selectList(Object var1);

    List<E> selectList(String var1, Object var2);

    PageList<E> selectPage(QueryParam var1);

    PageList<E> selectPage(String var1, QueryParam var2, Object var3);

    void startBatch() throws DataAccessException;

    int flushBatch() throws DataAccessException;

    void executeBatch() throws DataAccessException;

    void cancelBatch() throws DataAccessException;

    void executeBatch(boolean var1) throws DataAccessException;

    void cancelBatch(boolean var1) throws DataAccessException;
}
