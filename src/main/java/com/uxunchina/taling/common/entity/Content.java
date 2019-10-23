package com.uxunchina.taling.common.entity;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.common.entity
 * @date 2019/9/22 11:01
 */
public class Content {

    /**
     * 修改用户状态
     */
    public static final String EDIT_TYPE_STATE = "ckStateUser";
    /**
     * 重置密码
     */
    public static final String EDIT_TYPE_RESET_PSW = "resetPsw";

    /**
     * 重置密码成功
     */
    public static final int RESTPSW_SUCCESS = 0;

    /**
     * 用户默认密码
     */
    public static final String DEFALT_PSW = "123";
    /**
     * 用户状态 0锁定 1正常
     */
    public static final String USER_VALID = "1";
    /**
     * 用户状态 0锁定 1正常
     */
    public static final String USER_LOCK = "0";

}
