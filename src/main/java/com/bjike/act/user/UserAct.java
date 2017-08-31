package com.bjike.act.user;

import com.bjike.common.exception.ActException;
import com.bjike.common.exception.SerException;
import com.bjike.common.interceptor.login.LoginAuth;
import com.bjike.common.restful.ActResult;
import com.bjike.common.util.UserUtil;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.entity.user.User;
import com.bjike.ser.user.UserSer;
import com.bjike.vo.user.UserInfoVO;
import com.bjike.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户
 *
 * @Author: [liguiqin]
 * @Date: [2017-08-22 15:50]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */

@RestController
@RequestMapping("user")
public class UserAct {
    @Autowired
    private UserSer userSer;

    /**
     * 当前用户信息个人资料
     *
     * @return class UserInfoVO
     * @version v1
     */
    @LoginAuth
    @GetMapping("info")
    public ActResult userInfo() throws ActException {
        try {
            User user = UserUtil.currentUser();
            UserInfoVO vo = userSer.userInfo(user.getId());
            return ActResult.initialize(vo);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 编辑用户信息
     *
     * @throws ActException
     * @version v1
     * @return  class UserVO
     */
    @LoginAuth
    @GetMapping("edit/info")
    public ActResult editInfo() throws ActException {
        try {
            User user = UserUtil.currentUser();
            return ActResult.initialize(BeanCopy.copyProperties(user, UserVO.class));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 手机号昵称用户编号找人
     *
     * @param account 手机号昵称用户编号
     * @return class User
     * @throws ActException
     * @version v1
     */
    @GetMapping("search/{account}")
    public ActResult find(@PathVariable String account) throws ActException {
        try {
            List<User> users = userSer.findByAccount(account);
            return ActResult.initialize(BeanCopy.copyProperties(users, UserVO.class));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

}
