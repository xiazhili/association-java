package com.bjike.vo.activity;

import com.bjike.vo.BaseVO;
import com.bjike.vo.addressBook.ActivityMemberVO;

import java.util.List;

/**
 * 活动详情
 *
 * @Author: [chenjunhao]
 * @Date: [2017-09-04 15:17]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class ActivityDetailVO extends BaseVO {
    /**
     * 发起人
     */
    private String pulbisher;
    /**
     * 活动主题
     */
    private String topic;

    /**
     * 活动时间
     */
    private String time;

    /**
     * 活动地点
     */
    private String area;

    /**
     * 费用
     */
    private Double fee;

    /**
     * 已报名人数
     */
    private Integer attend;
    /**
     * 余位
     */
    private Integer remain;
    /**
     * 联系电话
     */
    private String tel;

    /**
     * 活动详情
     */
    private String detail;

    /**
     * 注意事项
     */
    private String notice;

    /**
     * 已报名成员
     */
    private List<ActivityMemberVO> memberVOS;

    /**
     * 评论
     */
    private List<ActivityCommentVO> commentVOS;

    /**
     * 评论数
     */
    private Long commentNum;

    public String getPulbisher() {
        return pulbisher;
    }

    public void setPulbisher(String pulbisher) {
        this.pulbisher = pulbisher;
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

    public Integer getAttend() {
        return attend;
    }

    public void setAttend(Integer attend) {
        this.attend = attend;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
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

    public List<ActivityMemberVO> getMemberVOS() {
        return memberVOS;
    }

    public void setMemberVOS(List<ActivityMemberVO> memberVOS) {
        this.memberVOS = memberVOS;
    }

    public List<ActivityCommentVO> getCommentVOS() {
        return commentVOS;
    }

    public void setCommentVOS(List<ActivityCommentVO> commentVOS) {
        this.commentVOS = commentVOS;
    }

    public Long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Long commentNum) {
        this.commentNum = commentNum;
    }
}
