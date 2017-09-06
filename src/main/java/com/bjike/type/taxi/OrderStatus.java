package com.bjike.type.taxi;

/**
 * 司机申请状态
 *
 * @Author: [liguiqin]
 * @Date: [2017-09-04 09:22]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum OrderStatus {
    /**
     * 待接单
     */
    PENDING(0),
    /**
     * 已接单
     */
    RECEIVED(1),
    /**
     * 已成功
     */
    FINISH(2),
    /**
     * 未完成
     */
    UNFINISHED(3),
    /**
     * 已取消
     */
    CANCEL(4),;
    private int code;

    OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
