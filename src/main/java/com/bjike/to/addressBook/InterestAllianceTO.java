package com.bjike.to.addressBook;

import com.bjike.common.aspect.ADD;
import com.bjike.common.aspect.EDIT;
import com.bjike.to.BaseTO;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 兴趣联盟
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-30 14:12]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class InterestAllianceTO extends BaseTO {
    public interface ADDMEMBER{}
    /**
     * 联盟名称
     */
    @NotBlank(groups = {ADD.class, EDIT.class}, message = "联盟名称不能为空")
    private String name;

//    private String headPath;//联盟头像

    private String description;//群描述

    @NotBlank(groups = {ADD.class, EDIT.class}, message = "爱好标签不能为空")
    private String tag;//爱好标签


    private String announcement;//群公告

    /**
     * 添加（或删除）的成员
     */
    @NotNull(groups = {InterestAllianceTO.ADDMEMBER.class},message = "添加（或删除）的成员不能为空")
    private List<String> userIds;

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getHeadPath() {
//        return headPath;
//    }
//
//    public void setHeadPath(String headPath) {
//        this.headPath = headPath;
//    }

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

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
}
