package com.bjike.to.chat;

import com.bjike.to.BaseTO;

/**
 * 好友分组传输对象
 *
 * @Author: [liguiqin]
 * @Date: [2017-07-21 11:09]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class FriendGroupTO extends BaseTO {
    /**
     * 分组名
     */
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
