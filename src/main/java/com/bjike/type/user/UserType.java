package com.bjike.type.user;

/**
 * @Author: [liguiqin]
 * @Date: [2017-08-23 11:04]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum UserType {
    ORDINARY(0),//普通成员
    PERSONAL_VIP(1), //个人vip
    ENTERPRISE_VIP(2),//企业vip
    NEW_ENTERPRISE_VIP(3),;//新企业vip
    private int code;

    UserType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
