package com.bjike.vo.feedback;

import com.bjike.vo.BaseVO;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * @Author: [liguiqin]
 * @Date: [2017-08-31 17:13]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class FeedbackVO extends BaseVO{
    /**
     * 反馈内容
     */
    private String content;

    /**
     * 处理时间
     */
    private String handleTime;

    /**
     * 是否已处理
     */
    private Boolean handle ;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public Boolean getHandle() {
        return handle;
    }

    public void setHandle(Boolean handle) {
        this.handle = handle;
    }
}
