package com.bjike.type.chat;

/**
 * @Author: [liguiqin]
 * @Date: [2017-07-19 14:38]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum  MsgType {
    SYS(0), //系统
    POINT(1),//点对点
    GROUP(2),//群发
    ONLINE(3),//上线通知
    OFFLINE(4),;//下线通知
    private int value;
    MsgType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
