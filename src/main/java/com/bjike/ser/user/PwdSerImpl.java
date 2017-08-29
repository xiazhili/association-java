package com.bjike.ser.user;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.PasswordHash;
import com.bjike.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: [liguiqin]
 * @Date: [2017-08-29 08:54]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class PwdSerImpl implements PwdSer {
    @Autowired
    private UserSer userSer;

    @Override
    public Boolean findPwd(String phone, String password) throws SerException {
        try {
            User user = userSer.findByPhone(phone);
            if (null != user) {
                user.setPassword(PasswordHash.createHash(password));
                userSer.update(user);
            } else {
                throw new SerException("手机号不存在!");
            }
        } catch (Exception e) {
            throw new SerException(e.getMessage());
        }
        return true;
    }

    @Override
    public Boolean editPwd(String userId, String password) throws SerException {
        User user = userSer.findById(userId);
        if (null != user) {
            try {
                user.setPassword(PasswordHash.createHash(password));
            } catch (Exception e) {
                throw new SerException(e.getMessage());
            }
            userSer.update(user);
            return true;
        }
        return false;
    }
}
