package com.bjike.ser.user;

import com.bjike.common.exception.SerException;
import com.bjike.dto.Restrict;
import com.bjike.dto.user.UserInfoDTO;
import com.bjike.entity.user.UserInfo;
import com.bjike.ser.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: [liguiqin]
 * @Date: [2017-08-23 09:49]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class UserInfoSerImpl extends ServiceImpl<UserInfo, UserInfoDTO> implements UserInfoSer {
    @Override
    public UserInfo findByUserId(String userId) throws SerException {
        UserInfoDTO dto = new UserInfoDTO();
        dto.getConditions().add(Restrict.eq("user.id", userId));
        UserInfo userInfo = super.findOne(dto);
        if (null != userInfo) {
            return userInfo;
        } else {
            throw new SerException("获取不到该用户详细信息!");
        }
    }
}
