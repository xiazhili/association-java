package com.bjike.to.addressBook;

import com.bjike.common.aspect.ADD;
import com.bjike.common.aspect.EDIT;
import com.bjike.to.BaseTO;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Author: [chenjunhao]
 * @Date: [2017-08-31 10:05]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class AllianceActivityTO extends BaseTO {
    /**
     * 活动主题
     */
    @NotBlank(groups = {ADD.class, EDIT.class},message = "活动主题不能为空")
    private String topic;

    /**
     * 活动时间
     */
    @NotBlank(groups = {ADD.class, EDIT.class},message = "活动时间不能为空")
    private String time;

    /**
     * 活动地点
     */
    @NotBlank(groups = {ADD.class, EDIT.class},message = "活动地点不能为空")
    private String area;

    /**
     * 费用
     */
    @NotNull(groups = {ADD.class, EDIT.class},message = "费用不能为空")
    private Double fee;

    /**
     * 活动参与人数最大额
     */
    @NotNull(groups = {ADD.class, EDIT.class},message = "活动参与人数最大额不能为空")
    private Integer num;

    /**
     * 联系电话
     */
    @NotBlank(groups = {ADD.class, EDIT.class},message = "联系电话不能为空")
    private String tel;

    /**
     * 活动详情
     */
    private String detail;

    /**
     * 注意事项
     */
    private String notice;

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
