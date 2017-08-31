package com.bjike.ser.user;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.UserUtil;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dao.user.UserRep;
import com.bjike.dto.Restrict;
import com.bjike.dto.user.UserDTO;
import com.bjike.dto.user.UserInfoDTO;
import com.bjike.entity.user.User;
import com.bjike.entity.user.UserInfo;
import com.bjike.ser.ServiceImpl;
import com.bjike.vo.user.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: [liguiqin]
 * @Date: [2017-07-06 14:11]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class UserImpl extends ServiceImpl<User, UserDTO> implements UserSer {
    @Autowired
    private UserRep userRep;
    @Autowired
    private UserInfoSer userInfoSer;

    @Override
    public User findByUsername(String username) throws SerException {
        return userRep.findByUsername(username);
    }


    @Override
    public User findByPhone(String phone) throws SerException {
        return userRep.findByPhone(phone);
    }

    @Override
    public Boolean isLogin(String token) throws SerException {
        return null != UserUtil.currentUser(token);
    }

    @Override
    public UserInfoVO userInfo(String userId) throws SerException {
        UserInfoVO userInfoVO = new UserInfoVO();
        UserInfoDTO dto = new UserInfoDTO();
        dto.getConditions().add(Restrict.eq("user.id", userId));
        UserInfo info = userInfoSer.findOne(dto);
        User user = UserUtil.currentUser();
        BeanCopy.copyProperties(user, userInfoVO);
        BeanCopy.copyProperties(info, userInfoVO, "user");
        return userInfoVO;
    }

    @Override
    public List<User> findByAccount(String account) throws SerException {
        UserDTO dto = new UserDTO();
        dto.getConditions().add(Restrict.eq("phone", account));
        dto.getConditions().add(Restrict.or("number", account));
        dto.getConditions().add(Restrict.or("nickname", account));
        return super.findByCis(dto);
    }
}


