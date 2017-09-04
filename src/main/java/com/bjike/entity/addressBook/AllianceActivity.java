package com.bjike.entity.addressBook;

import com.bjike.entity.BaseEntity;

import javax.persistence.*;

/**
 * 联盟活动
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-30 18:05]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "addressBook_alliance_activity")
public class AllianceActivity extends BaseEntity {
    /**
     * 归属联盟
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "interestAlliance_id", columnDefinition = "VARCHAR(36) COMMENT '归属联盟' ", nullable = false)
    private InterestAlliance interestAlliance;

    /**
     * 发起人
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '发起人' ", nullable = false)
    private String pulbisher;

    /**
     * 活动主题
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '活动主题' ", nullable = false)
    private String topic;

    /**
     * 活动时间
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '活动时间' ", nullable = false)
    private String time;

    /**
     * 活动地点
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '活动地点' ", nullable = false)
    private String area;

    /**
     * 费用
     */
    @Column(columnDefinition = "DECIMAL(10,2) COMMENT '费用' ", nullable = false)
    private Double fee;

    /**
     * 活动参与人数最大额
     */
    @Column(columnDefinition = "INT(11) COMMENT '活动参与人数最大额' ", nullable = false)
    private Integer num;

    /**
     * 联系电话
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '联系电话' ", nullable = false)
    private String tel;

    /**
     * 活动详情
     */
    @Column(columnDefinition = "TEXT COMMENT '活动详情' ")
    private String detail;

    /**
     * 注意事项
     */
    @Column(columnDefinition = "TEXT COMMENT '注意事项' ")
    private String notice;

    public String getPulbisher() {
        return pulbisher;
    }

    public void setPulbisher(String pulbisher) {
        this.pulbisher = pulbisher;
    }

    public InterestAlliance getInterestAlliance() {
        return interestAlliance;
    }

    public void setInterestAlliance(InterestAlliance interestAlliance) {
        this.interestAlliance = interestAlliance;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
