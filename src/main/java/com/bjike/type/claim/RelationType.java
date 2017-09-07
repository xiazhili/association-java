package com.bjike.type.claim;

/**
 * @Author: [xiazhili]
 * @Date: [2017-08-30 11:07]
 * @Description: [关系 ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum RelationType {
    /**
     * 亲人
     */
    RELATIVE(0),
    /**
     * 情侣
     */
    LOVES(1),
    /**
     * 闺蜜
     */
    BESTFRIEND(2),
    /**
     * 基友
     */
    GAYFRIEND(3),
    /**
     * 同事
     */
    WORKMATE(4),
    /**
     * 同学
     */
    SCHOOLMATE(4),
    /**
     * 校友
     */
    CLASSMATE(4),
    /**
     * 老乡
     */
    FELLOW(4),
    /**
     * 普通朋友
     */
    SIMPLYFRIEND(4),;
    private int code;

    RelationType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
