package com.hzq.project.system.common.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseDao
 * Created by hzq on 16/9/19.
 */
public class BaseDao<E, PK extends Serializable> extends SqlSessionDaoSupport implements Dao<E, PK> {
    private static Logger log = LoggerFactory.getLogger(BaseDao.class);
    private ThreadLocal<Boolean> batchMode = new ThreadLocal();
    private SqlSessionTemplate batchSqlSessionTemplate;

    public BaseDao() {
    }

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public SqlSession getSqlSession() {
        return (SqlSession)(!this.isInBatch()?super.getSqlSession():this.batchSqlSessionTemplate);
    }

    public E getByPk(PK primaryKey) throws DataAccessException {
        String sqlId0 = this.getFindByPrimaryKeyStatement();
        Object object = this.getSqlSession().selectOne(sqlId0, primaryKey);
        return (E) object;
    }

    public E selectOne(String sqlId, Object param) throws DataAccessException {
        String sqlId0 = this.buildFullSqlId(sqlId);
        Object object = this.getSqlSession().selectOne(sqlId0, param);
        return (E) object;
    }

    public int deleteByPk(PK primaryKey) throws DataAccessException {
        String sqlId0 = this.getDeleteStatement();
        return this.getSqlSession().delete(sqlId0, primaryKey);
    }

    public int insert(E entity) throws DataAccessException {
        this.prepareObjectBeforeSave(entity);
        int i = this.getSqlSession().insert(this.getInsertStatement(), entity);
        this.prepareObjectAfterSave(entity);
        return i;
    }

    public int update(E entity) throws DataAccessException {
        this.prepareObjectBeforeUpdate(entity);
        int i = this.getSqlSession().update(this.getUpdateStatement(), entity);
        return i;
    }

    public int updateByParam(String sqlId, Object param) {
        String sqlId0 = this.buildFullSqlId(sqlId);
        int i = this.getSqlSession().update(sqlId0, param);
        return i;
    }

    public int update(String sqlId, E entity) throws DataAccessException {
        String sqlId0 = this.buildFullSqlId(sqlId);
        this.prepareObjectBeforeUpdate(entity);
        int i = this.getSqlSession().update(sqlId0, entity);
        this.prepareObjectAfterUpdate(entity);
        return i;
    }

    public E selectOne(Object param) throws org.springframework.dao.DataAccessException {
        return this.selectOne(SqlMapStatementEnum.SELECT_ONE_OBJECT.getStatementId(), param);
    }

    public List<E> selectList(Object param) {
        return this.selectList(SqlMapStatementEnum.LIST_OBJECT.getStatementId(), param);
    }

    public List<E> selectList(String sqlId, Object param) {
        String sqlId0 = this.buildFullSqlId(sqlId);
        return this.getSqlSession().selectList(sqlId0, param);
    }

    public int delete(E entity) throws org.springframework.dao.DataAccessException {
        return this.getSqlSession().delete(SqlMapStatementEnum.DELETE_OBJECT.getStatementId(), entity);
    }

    public int delete(String sqlId, E entity) throws org.springframework.dao.DataAccessException {
        String sqlId0 = this.buildFullSqlId(sqlId);
        return this.getSqlSession().delete(sqlId0, entity);
    }

    public PageList<E> selectPage(QueryParam queryParam) {
        return this.selectPage(SqlMapStatementEnum.LIST_PAGE_OBJECT.getStatementId(), queryParam, (Object)null);
    }

    public PageList<E> selectPage(String sqlId, QueryParam queryParam, Object otherParam) {
        String sqlId0 = this.buildFullSqlId(sqlId);
        HashMap actualParam = new HashMap();
        if(queryParam.getPer() > queryParam.maxPer()) {
            queryParam.setPer(queryParam.maxPer());
        }

        actualParam.put("autoCount", Boolean.valueOf(queryParam.autoCount()));
        actualParam.put("offset", Integer.valueOf(queryParam.offset()));
        actualParam.put("pageSize", Integer.valueOf(queryParam.getPer()));
        actualParam.put("lastRows", Integer.valueOf(queryParam.offset() + queryParam.getPer()));
        Map newParamMap1 = queryParam != null?BeanUtil.bean2Map(queryParam):null;
        Map newParamMap2 = otherParam != null?BeanUtil.bean2Map(otherParam):null;
        if(newParamMap1 != null) {
            actualParam.putAll(newParamMap1);
        }

        if(newParamMap2 != null) {
            actualParam.putAll(newParamMap2);
        }

        List resultList = this.getSqlSession().selectList(sqlId0, actualParam);
        Integer totalCount = Integer.valueOf(0);
        if(null != actualParam.get("totalCount")) {
            totalCount = (Integer)actualParam.get("totalCount");
        } else if(resultList.size() >= 0) {
            totalCount = Integer.valueOf(resultList.size());
        }

        PageList pageList = new PageList();
        pageList.setPage(queryParam.getPage());
        pageList.setPer(queryParam.getPer());
        pageList.setResultList(resultList);
        pageList.setCount((long)totalCount.intValue());
        return pageList;
    }

    public Long getCount(Object param) {
        return this.getCount(SqlMapStatementEnum.COUNT_OBJECT.getStatementId(), param);
    }

    public Long getCount(String sqlId, Object param) {
        String sqlId0 = this.buildFullSqlId(sqlId);
        return (Long)this.getSqlSession().selectOne(sqlId0, param);
    }

    private String getFindByPrimaryKeyStatement() {
        return this.buildFullSqlId(SqlMapStatementEnum.GET_BY_ID.getStatementId());
    }

    private String getDeleteStatement() {
        return this.buildFullSqlId(SqlMapStatementEnum.DELETE_OBJECT.getStatementId());
    }

    private String getInsertStatement() {
        return this.buildFullSqlId(SqlMapStatementEnum.INSERT_OBJECT.getStatementId());
    }

    private String getUpdateStatement() {
        return this.buildFullSqlId(SqlMapStatementEnum.UPDATE_OBJECT.getStatementId());
    }

    private String getCountStatement() {
        return this.buildFullSqlId(SqlMapStatementEnum.COUNT_OBJECT.getStatementId());
    }

    private String getSelectOneStatement() {
        return this.buildFullSqlId(SqlMapStatementEnum.SELECT_ONE_OBJECT.getStatementId());
    }

    private String getListStatement() {
        return this.buildFullSqlId(SqlMapStatementEnum.LIST_OBJECT.getStatementId());
    }

    private String getListStatementForPage() {
        return this.buildFullSqlId(SqlMapStatementEnum.LIST_PAGE_OBJECT.getStatementId());
    }

    private String buildFullSqlId(String sqlId) {
        String sqlId0 = sqlId;
        if(!sqlId.startsWith(".")) {
            sqlId0 = "." + sqlId;
        }

        return this.getIbatisSqlMapNamespace() + sqlId0;
    }

    public String getIbatisSqlMapNamespace() {
        return this.getClass().getInterfaces()[0].getName();
    }

    protected void prepareObjectAfterUpdate(E o) {
    }

    protected void prepareObjectBeforeUpdate(E o) {
    }

    protected void prepareObjectBeforeSave(E o) {
    }

    protected void prepareObjectAfterSave(E o) {
    }

    @Autowired
    public void setBatchSqlSessionTemplate(SqlSessionTemplate batchSqlSessionTemplate) {
        this.batchSqlSessionTemplate = batchSqlSessionTemplate;
    }

    protected boolean isInBatch() {
        return this.batchMode.get() != null && ((Boolean)this.batchMode.get()).booleanValue()?((Boolean)this.batchMode.get()).booleanValue():false;
    }

    public void startBatch() throws DataAccessException {
        this.batchMode.set(Boolean.valueOf(true));
    }

    public int flushBatch() throws org.springframework.dao.DataAccessException {
        return this.batchSqlSessionTemplate.flushStatements().size();
    }

    public void executeBatch() throws DataAccessException {
        this.executeBatch(false);
    }

    public void cancelBatch() throws DataAccessException {
        this.cancelBatch(false);
    }

    public void executeBatch(boolean commitTx) throws DataAccessException {
        if(!this.isInBatch()) {
            throw new DataAccessException("Not in batch mode, but executeBatch() is called!");
        } else {
            try {
                this.batchSqlSessionTemplate.commit(commitTx);
                if(log.isInfoEnabled()) {
                    log.info("Batch operations ::: executeBatch(" + commitTx + ")---" + this.getClass().getSimpleName());
                }
            } finally {
                this.batchMode.set(Boolean.valueOf(false));
            }

        }
    }

    public void cancelBatch(boolean commitTx) throws DataAccessException {
        if(!this.isInBatch()) {
            throw new DataAccessException("Not in batch mode, but cancelBatch() is called!");
        } else {
            try {
                this.batchSqlSessionTemplate.rollback(commitTx);
                if(log.isInfoEnabled()) {
                    log.info("Batch operations ::: cancelBatch (" + commitTx + ")---" + this.getClass().getSimpleName());
                }
            } finally {
                this.batchMode.set(Boolean.valueOf(false));
            }

        }
    }
}

