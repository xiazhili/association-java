package com.bjike.vo.addressBook;

import com.bjike.vo.BaseVO;

/**
 * 联盟活动
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-31 10:05]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class AllianceActivityVO extends BaseVO {
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

    public String getPulbisher() {
        return pulbisher;
    }

    public void setPulbisher(String pulbisher) {
        this.pulbisher = pulbisher;
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
