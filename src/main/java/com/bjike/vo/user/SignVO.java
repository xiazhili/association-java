package com.bjike.vo.user;

import java.time.LocalDate;

/**
 * 签到
 *
 * @Author: [liguiqin]
 * @Date: [2017-08-29 18:08]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class SignVO {

    /**
     * 签到日期
     */
    protected LocalDate signDate;

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }
}
