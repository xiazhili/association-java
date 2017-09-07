package com.bjike.vo.claim;

import com.bjike.vo.BaseVO;

/**
 * @Author: [xiazhili]
 * @Date: [2017-09-04 09:16]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class ClaimCenterVO  {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 头像
     */
    private String headPath;
    /**
     * 姓名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 编号
     */
    private String number;
    /**
     * 推荐人
     */
    private String recommend;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
}
