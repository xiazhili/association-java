package com.bjike.entity.addressBook;

import com.bjike.entity.BaseEntity;
import com.bjike.type.addressBook.OutType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 活动参与人员
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-30 18:12]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "addressBook_activity_member")
public class ActivityMember extends BaseEntity {
    /**
     * 归属活动
     */
    @Column(name = "allianceActivity_id", columnDefinition = "VARCHAR(36) COMMENT '归属活动' ", nullable = false)
    private String allianceActivityId;

    /**
     * 姓名
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '姓名' ", nullable = false)
    private String name;

    /**
     * 电话
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '电话' ", nullable = false)
    private String tel;

    /**
     * 微信号
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '微信号' ", nullable = false)
    private String wechat;

    /**
     * 出发地
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '出发地' ", nullable = false)
    private String place;

    /**
     * 出行方式
     */
    @Column(columnDefinition = "TINYINT(2) COMMENT '出行方式' ")
    private OutType outType;

    /**
     * 是否愿意拼车
     */
    @Column(name = "is_together",columnDefinition = "TINYINT(1) COMMENT '是否愿意拼车' ")
    private Boolean together;

    public String getAllianceActivityId() {
        return allianceActivityId;
    }

    public void setAllianceActivityId(String allianceActivityId) {
        this.allianceActivityId = allianceActivityId;
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
