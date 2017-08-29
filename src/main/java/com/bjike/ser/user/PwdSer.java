package com.bjike.ser.user;

import com.bjike.common.exception.SerException;

/**
 * 密码业务
 *
 * @Author: [liguiqin]
 * @Date: [2017-08-22 10:09]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface PwdSer {
    /**
     * 找回密码
     *
     * @param phone
     * @param password
     * @return
     * @throws SerException
     */
    default Boolean findPwd(String phone, String password) throws SerException {
        return null;
    }

    /**
     * 更改密码
     *
     * @param userId
     * @param password
     * @return
     * @throws SerException
     */
    default Boolean editPwd(String userId, String password) throws SerException {
        return null;
    }

}
