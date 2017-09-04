package com.bjike.vo.addressBook;

import com.bjike.type.addressBook.OutType;
import com.bjike.vo.BaseVO;

/**
 * 活动成员
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-31 15:13]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class ActivityMemberVO extends BaseVO {
    /**
     * 参与人id
     */
    private String userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String tel;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 出发地
     */
    private String place;

    /**
     * 出行方式
     */
    private OutType outType;

    /**
     * 是否愿意拼车
     */
    private Boolean together;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public OutType getOutType() {
        return outType;
    }

    public void setOutType(OutType outType) {
        this.outType = outType;
    }

    public Boolean getTogether() {
        return together;
    }

    public void setTogether(Boolean together) {
        this.together = together;
    }
}
