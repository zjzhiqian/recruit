package com.hzq.project.system.common.dao;

/**
 * SqlMapStatementEnum
 * Created by hzq on 16/9/19.
 */
public enum SqlMapStatementEnum {
    GET_BY_ID(".getByPk", "根据ID去查询的通用statement"),
    INSERT_OBJECT(".insert", "插入对象的通用statement"),
    UPDATE_OBJECT(".update", "更新对象的通用statement"),
    DELETE_OBJECT(".delete", "删除对象的通用statement"),
    LIST_OBJECT(".list", "查询对象的通用statement"),
    LIST_PAGE_OBJECT(".selectPage", "查询对象的通用statement"),
    COUNT_OBJECT(".count", "查询总数的通用statement"),
    SELECT_ONE_OBJECT(".selectOne", "返回一个对象的通用statement");

    private String statementId;
    private String desc;

    private SqlMapStatementEnum(String statementId, String desc) {
        this.statementId = statementId;
        this.desc = desc;
    }

    public static String getExtNameByCode(String statementId) {
        SqlMapStatementEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SqlMapStatementEnum e = var1[var3];
            if(e.getStatementId().equals(statementId)) {
                return e.desc;
            }
        }

        return null;
    }

    public String getStatementId() {
        return this.statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
