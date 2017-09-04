package com.bjike.to.activity;

import com.bjike.common.aspect.ADD;
import com.bjike.common.aspect.EDIT;
import com.bjike.entity.user.User;
import com.bjike.to.BaseTO;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;


/**
 * 活动评论添加更新操作对象
 *
 * @Author:	[ chenjunhao ]
 * @Date: [  2017-09-04 13:58:03 ]
 * @Description: [ 活动评论 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
public class ActivityCommentTO extends BaseTO{

    /**
     * 活动id
     */
    @NotBlank(groups = {ADD.class, EDIT.class},message = "活动id不能为空")
 	private String activityId;
    /**
     * 评论内容
     */
	@NotBlank(groups = {ADD.class, EDIT.class},message = "评论内容不能为空")
	private String content;

 	public String getActivityId () {
		return activityId;
	}
	public void setActivityId (String activityId) {
		this.activityId =activityId;
	}

 	public String getContent () {
		return content;
	}
	public void setContent (String content) {
		this.content =content;
	}

}
