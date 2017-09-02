package com.bjike.type.addressBook;

/**
 * 出行方式
 * @Author: [chenjunhao]
 * @Date: [2017-08-31 09:14]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum OutType {
    /**
     * 飞机
     */
    PLANE(0),
    /**
     * 高铁
     */
    HIGHLINE(1),
    /**
     * 动车
     */
    MOVECAR(2),
    /**
     * 大巴
     */
    BIGBUS(3),
    /**
     * 自驾车
     */
    DRIVER(4),
    /**
     * 的士
     */
    TAIX(5),
    /**
     * 地铁
     */
    UNDERROAD(6),
    /**
     * 公交
     */
    BUS(7),
    /**
     * 单车
     */
    BIKE(8),
    /**
     * 步行
     */
    FOOT(9)
    ;

    private int code;

    OutType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
