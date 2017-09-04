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
public enum VerifyType {
    /**
     * 审核中
     */
    PENDING(0),
    /**
     * 通过
     */
    PASS(1),
    /**
     * 取消
     */
    CANCEL(2),
    /**
     * 拒绝
     */
    REFUSE(3),;
    private int code;

    VerifyType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
