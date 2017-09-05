package com.bjike.vo.chat;

import com.bjike.vo.BaseVO;

/**
 * 好友分组
 *
 * @Author: [liguiqin]
 * @Date: [2017-07-21 13:56]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class FriendGroupVO extends BaseVO {
    /**
     * 好友分组名
     */
    private String name;
    /**
     * 成员数
     */
    private Integer counts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }
}
