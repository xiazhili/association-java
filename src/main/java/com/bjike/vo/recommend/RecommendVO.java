package com.bjike.vo.recommend;

import com.bjike.vo.BaseVO;

/**
 * 推荐
 *
 * @Author: [liguiqin]
 * @Date: [2017-08-30 15:19]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class RecommendVO extends BaseVO{
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邀请码
     */
    private String inviteCode;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
