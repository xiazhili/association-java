package com.bjike.vo.user;

import com.bjike.vo.BaseVO;

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
public class SignVO extends BaseVO{

    /**
     * 签到日期
     */
    private String signDate;

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }
}
