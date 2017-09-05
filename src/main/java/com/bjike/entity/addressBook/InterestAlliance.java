package com.bjike.entity.addressBook;

import com.bjike.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 兴趣联盟
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-30 13:59]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "addressBook_interest_alliance")
public class InterestAlliance extends BaseEntity {
    /**
     * 联盟名称
     */
    @Column(columnDefinition = "VARCHAR(36) COMMENT '联盟名称' ", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(36) COMMENT '创建人' ", nullable = false)
    private String userId;//创建人

    @Column(columnDefinition = "VARCHAR(200) COMMENT '联盟头像' ")
    private String headPath;//联盟头像

    @Column(columnDefinition = "VARCHAR(500) COMMENT '群描述' ")
    private String description;//群描述

    @Column(columnDefinition = "VARCHAR(255) COMMENT '爱好标签' ")
    private String tag;//爱好标签

    @Column(columnDefinition = "VARCHAR(255) COMMENT '群号码' ",nullable = false,unique = true)
    private String number;//群号码

    @Column(columnDefinition = "VARCHAR(255) COMMENT '群公告' ")
    private String announcement;//群公告

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
}
