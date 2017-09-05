package com.bjike.type.chat;

/**
 * 管理类型
 *
 * @Author: [liguiqin]
 * @Date: [2017-07-22 11:03]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum MemberType {
    /**
     * 群主
     */
    MASTER(0),
    /**
     * 管理员
     */
    MANAGER(1),
    /**
     * 普通的
     */
    ORDINARY(2),;
    private int code;

    MemberType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
