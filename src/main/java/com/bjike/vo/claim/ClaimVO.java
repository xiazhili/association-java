package com.bjike.vo.claim;

import com.bjike.vo.BaseVO;

/**
 * @Author: [xiazhili]
 * @Date: [2017-08-31 13:56]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class ClaimVO extends BaseVO {

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
    /**
     * 认领时间
     */
    private String claimTime;

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

    public String getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(String claimTime) {
        this.claimTime = claimTime;
    }
}
