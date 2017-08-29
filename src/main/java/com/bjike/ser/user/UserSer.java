package com.bjike.ser.user;

import com.bjike.common.exception.SerException;
import com.bjike.dto.user.UserDTO;
import com.bjike.entity.user.User;
import com.bjike.entity.user.UserInfo;
import com.bjike.ser.Ser;
import com.bjike.vo.user.UserInfoVO;

/**
 * 用户业务
 *
 * @Author: [liguiqin]
 * @Date: [2017-07-06 14:11]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserSer extends Ser<User, UserDTO> {
    /**
     * 是否已登录
     *
     * @param token
     * @return
     * @throws SerException
     */
    default Boolean isLogin(String token) throws SerException {
        return null;
    }

    /**
     * 通过用户名查询用户
     *
     * @param username
     * @return
     * @throws SerException
     */
    default User findByUsername(String username) throws SerException {
        return null;
    }

    /**
     * 通过手机号查询用户
     *
     * @param phone
     * @return
     * @throws SerException
     */
    default User findByPhone(String phone) throws SerException {
        return null;
    }

    /**
     * 获取用户详情
     *
     * @param userId
     * @return
     * @throws SerException
     */
    default UserInfoVO userInfo(String userId) throws SerException {
        return null;
    }



}
