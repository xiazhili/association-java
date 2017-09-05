package com.bjike.entity.addressBook;

import com.bjike.entity.BaseEntity;

import javax.persistence.*;

/**
 * 联盟成员
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-30 14:25]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "addressBook_alliance_member")
public class AllianceMember extends BaseEntity {
    /**
     * 归属联盟
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "interestAlliance_id", columnDefinition = "VARCHAR(36) COMMENT '归属联盟' ", nullable = false)
    private InterestAlliance interestAlliance;
    /**
     * 联盟成员id
     */
    @Column(columnDefinition = "VARCHAR(36) COMMENT '联盟成员id' ", nullable = false)
    private String userId;

    public InterestAlliance getInterestAlliance() {
        return interestAlliance;
    }

    public void setInterestAlliance(InterestAlliance interestAlliance) {
        this.interestAlliance = interestAlliance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
