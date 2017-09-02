package com.bjike.type.chat;

/**
 * 消息分类
 *
 * @Author: [liguiqin]
 * @Date: [2017-09-01 17:13]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum MsgCategory {
    /**
     * 文本
     */
    TEXT(0),
    /**
     * 声音
     */
    VOICE(1),
    /**
     * 视频
     */
    VIDEO(2),
    /**
     * 文件
     */
    FILE(3);
    private int value;

    MsgCategory(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
