package com.bjike.entity.activity;

import com.bjike.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 评论点赞表
 *
 * @Author: [ chenjunhao ]
 * @Date: [  2017-09-04 14:05:33 ]
 * @Description: [ 评论点赞表 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "activity_thumb")
public class Thumb extends BaseEntity {

    /**
     * 评论id
     */
    @Column(columnDefinition = "VARCHAR(36) COMMENT '评论id' ")
    private String commentId;
    /**
     * 点赞人id
     */
    @Column(columnDefinition = "VARCHAR(36) COMMENT '点赞人id' ", nullable = false)
    private String userId;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
