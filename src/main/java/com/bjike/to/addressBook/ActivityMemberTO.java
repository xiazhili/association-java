package com.bjike.to.addressBook;

import com.bjike.common.aspect.ADD;
import com.bjike.to.BaseTO;
import com.bjike.type.addressBook.OutType;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Author: [chenjunhao]
 * @Date: [2017-08-31 10:06]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class ActivityMemberTO extends BaseTO {
    /**
     * 姓名
     */
    @NotBlank(groups = ADD.class,message = "姓名不能为空")
    private String name;

    /**
     * 电话
     */
    @NotBlank(groups = ADD.class,message = "电话不能为空")
    private String tel;

    /**
     * 微信号
     */
    @NotBlank(groups = ADD.class,message = "微信号不能为空")
    private String wechat;

    /**
     * 出发地
     */
    @NotBlank(groups = ADD.class,message = "出发地不能为空")
    private String place;

    /**
     * 出行方式
     */
    private OutType outType;

    /**
     * 是否愿意拼车
     */
    private Boolean together;

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
