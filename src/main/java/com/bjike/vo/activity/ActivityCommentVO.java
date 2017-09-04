package com.bjike.vo.activity;

import com.bjike.vo.BaseVO;


/**
 * 活动评论值对象
 *
 * @Author: [ chenjunhao ]
 * @Date: [  2017-09-04 13:58:03 ]
 * @Description: [ 活动评论 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
public class ActivityCommentVO extends BaseVO {

    /**
     * 活动id
     */
    private String activityId;
    /**
     * 评论标题
     */
    private String title;
    /**
     * 评论人头像
     */
    private String headPath;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论时间
     */
    private String time;
    /**
     * 回复评论id
     */
    private String repayId;

    public String getRepayId() {
        return repayId;
    }

    public void setRepayId(String repayId) {
        this.repayId = repayId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
