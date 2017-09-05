package com.bjike.to.chat;

/**
 * 好友传输对象
 *
 * @Author: [liguiqin]
 * @Date: [2017-07-21 11:47]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class FriendTO {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 朋友id
     */
    private String friendId;
    /**
     * 备注
     */
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
