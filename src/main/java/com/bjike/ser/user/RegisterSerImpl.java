package com.bjike.ser.user;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.PasswordHash;
import com.bjike.common.util.regex.Validator;
import com.bjike.entity.chat.Friend;
import com.bjike.entity.user.Recommend;
import com.bjike.entity.user.User;
import com.bjike.entity.user.UserInfo;
import com.bjike.redis.client.RedisClient;
import com.bjike.ser.chat.FriendSer;
import com.bjike.session.AuthCodeSession;
import com.bjike.to.user.LoginTO;
import com.bjike.to.user.RegisterTO;
import com.bjike.type.chat.ApplyType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: [liguiqin]
 * @Date: [2017-08-22 10:11]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class RegisterSerImpl implements RegisterSer {
    @Autowired
    private UserSer userSer;
    @Autowired
    private UserInfoSer userInfoSer;
    @Autowired
    private LoginSer loginSer;
    @Autowired
    private RedisClient redis;
    @Autowired
    private RecommendSer recommendSer;
    @Autowired
    private FriendSer friendSer;

    @Transactional
    @Override
    public String register(RegisterTO to) throws SerException {
        validRegister(to); //注册验证
        Recommend recommend = initRecommend(to);//验证邀请码并获得推荐详情信息
        String token = null;
        User user = new User();
        user.setPhone(to.getPhone());
        user.setUsername(to.getNickname());
        user.setNickname(to.getNickname());
        try {
            user.setPassword(PasswordHash.createHash(to.getPassword()));
        } catch (Exception e) {
            throw new SerException(e.getMessage());
        }
        userSer.save(user);
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        userInfoSer.save(userInfo);//初始化保存用户详情信息
        if(null != recommend){
            addFriend(recommend,user);//添加好友
            //邀请码注册,完善信息
            redis.remove(to.getInviteCode()); //删除校验码
        }
        token = loginUser(to);//登录用户
        return token;
    }

    @Override
    public void handleAuthCode(String sid, String code) throws SerException {
        AuthCodeSession.put(sid, code);
    }

    /**
     * 注册成功并登录用户
     *
     * @param to
     * @throws SerException
     */
    private String loginUser(RegisterTO to) throws SerException {
        LoginTO loginTO = new LoginTO();
        loginTO.setLoginType(to.getLoginType());
        loginTO.setAccount(to.getPhone());
        loginTO.setPassword(to.getPassword());
        loginTO.setIp(to.getIp());
        return loginSer.login(loginTO);
    }

    /**
     * 验证邀请码并获得推荐详情信息
     *
     * @param to
     * @return
     * @throws SerException
     */
    private Recommend initRecommend(RegisterTO to) throws SerException {
        String invite = to.getInviteCode();
        if (StringUtils.isNotBlank(invite)) { //邀请码注册
            String recommendId = redis.get(invite);
            if (StringUtils.isNotBlank(recommendId)) {
                return recommendSer.findById(recommendId); //获取推荐详细信息
            }
            throw new SerException("无效邀请码!");
        }
        return null;
    }

    /**
     * 注册验证
     *
     * @param to
     * @throws SerException
     */
    private void validRegister(RegisterTO to) throws SerException {
        if (!Validator.isPhone(to.getPhone())) {
            throw new SerException("手机号码格式错误!");
        } else if (false && !to.getAuthCode().equalsIgnoreCase(AuthCodeSession.get(to.getSid()))) {//验证码
            throw new SerException("验证码错误!");
        } else if (!to.getPassword().equals(to.getRePassword())) { //密码
            throw new SerException("密码不一致!");
        } else if (!Validator.isPassword(to.getPassword())) { //密码强度
            throw new SerException("密码过于简单！");
        }
    }

    /**
     * 注册完成添加好友
     * @param recommend
     */
    private void addFriend(Recommend recommend,User user)throws SerException{
        Friend friend = new Friend();
        friend.setUser(recommend.getUser());
        friend.setFriend(user);
        friend.setApplyType(ApplyType.PASS);
        friendSer.save(friend);
    }

}
