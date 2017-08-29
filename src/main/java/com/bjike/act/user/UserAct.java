package com.bjike.act.user;

import com.bjike.common.constant.UserCommon;
import com.bjike.common.exception.ActException;
import com.bjike.common.exception.SerException;
import com.bjike.common.interceptor.login.LoginAuth;
import com.bjike.common.restful.ActResult;
import com.bjike.common.util.PasswordHash;
import com.bjike.common.util.UserUtil;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.entity.user.User;
import com.bjike.ser.user.UserSer;
import com.bjike.vo.user.UserInfoVO;
import com.bjike.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: [liguiqin]
 * @Date: [2017-08-22 15:50]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@LoginAuth
@RestController
@RequestMapping("user")
public class UserAct {
    @Autowired
    private UserSer userSer;

    /**
     * 当前用户信息个人资料
     *
     * @return
     * @throws ActException
     */

    @GetMapping("/info")
    public ActResult userInfo() throws ActException {
        try {
            User user =UserUtil.currentUser();
            UserInfoVO vo = userSer.userInfo(user.getId());
            return ActResult.initialize(vo);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @GetMapping("edit/info")
    public ActResult editInfo(UserVO userVO) throws ActException {
        try {
            User user =UserUtil.currentUser();
            return ActResult.initialize(BeanCopy.copyProperties(user, UserVO.class));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }


}
