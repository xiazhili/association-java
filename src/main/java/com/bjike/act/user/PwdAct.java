package com.bjike.act.user;

import com.bjike.common.exception.ActException;
import com.bjike.common.exception.SerException;
import com.bjike.common.interceptor.login.LoginAuth;
import com.bjike.common.restful.ActResult;
import com.bjike.common.util.PasswordHash;
import com.bjike.common.util.UserUtil;
import com.bjike.entity.user.User;
import com.bjike.ser.user.PwdSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 密码
 *
 * @Author: [liguiqin]
 * @Date: [2017-08-29 08:48]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@RequestMapping("pwd")
@RestController
public class PwdAct {
    @Autowired
    private PwdSer pwdSer;

    /**
     * 找回密码
     *
     * @param phone 手机
     * @throws ActException
     * @version v1
     */
    @PutMapping("find/{phone}")
    public ActResult findPwd(@PathVariable String phone, String password, String rePassword) throws ActException {
        try {
            if (password.equals(rePassword)) {
                pwdSer.findPwd(phone, password);
            } else {
                throw new ActException("密码不一致!");
            }
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
        return new ActResult("success");
    }

    /**
     * 更新密码
     *
     * @param oldPassword 旧密码
     * @param password    新密码
     * @param rePassword  确认新密码
     * @throws ActException
     * @version v1
     */
    @LoginAuth
    @PutMapping("edit")
    public ActResult editPwd(String oldPassword, String password, String rePassword) throws ActException {
        try {
            if (password.equals(rePassword)) {
                boolean pass = false;
                User user = UserUtil.currentUser();
                try {
                    pass = PasswordHash.validatePassword(oldPassword, user.getPassword());
                } catch (Exception e) {
                    throw new ActException("密码解析验证错误!");
                }
                if (pass) {
                    pwdSer.editPwd(user.getId(), password);
                } else {
                    throw new SerException("旧密码输入错误");
                }

            } else {
                throw new ActException("密码不一致!");
            }
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
        return new ActResult("success");
    }
}
