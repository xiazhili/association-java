package com.bjike.to.user;

import com.bjike.type.user.LoginType;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 注册传输对象
 *
 * @Author: [liguiqin]
 * @Date: [2017-08-22 10:06]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class RegisterTO {
    /**
     * 邀请注册
     */
    public interface INVITE {

    }

    /**
     * 普通手机注册
     */
    public interface PHONE {

    }

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空!", groups = {RegisterTO.INVITE.class, RegisterTO.PHONE.class})
    private String phone;
    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空!", groups = {RegisterTO.PHONE.class})
    private String authCode;
    /**
     * ip
     */
    private String ip;
    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空!", groups = {RegisterTO.PHONE.class})
    private String nickname;
    /**
     * 确认密码
     */
    @NotBlank(message = "确认密码不能为空!", groups = {RegisterTO.INVITE.class, RegisterTO.PHONE.class})
    private String rePassword;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空!", groups = {RegisterTO.INVITE.class, RegisterTO.PHONE.class})
    private String password;
    /**
     * 邀请码
     */
    @NotBlank(message = "邀请码不能为空!", groups = {RegisterTO.INVITE.class})
    private String inviteCode;
    /**
     * 登录类型
     */
    private LoginType loginType;
    /**
     * 会话id
     */
    private String sid;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
