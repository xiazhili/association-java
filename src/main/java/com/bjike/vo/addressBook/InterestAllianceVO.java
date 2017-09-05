package com.bjike.vo.addressBook;

import com.bjike.vo.BaseVO;

/**
 * 兴趣联盟
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-31 14:42]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class InterestAllianceVO extends BaseVO {
    /**
     * 联盟名称
     */
    private String name;

    private String userName;//盟主

    private String headPath;//联盟头像

    private String description;//群描述

    private String tag;//爱好标签

    private String number;//群号码

    private String announcement;//群公告

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
