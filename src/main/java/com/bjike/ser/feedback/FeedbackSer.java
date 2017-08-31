package com.bjike.ser.feedback;

import com.bjike.common.exception.SerException;
import com.bjike.dto.feedback.FeedbackDTO;
import com.bjike.entity.feedback.Feedback;
import com.bjike.ser.Ser;
import com.bjike.to.feedback.FeedbackTO;

import java.util.List;

/**
 * @Author: [liguiqin]
 * @Date: [2017-08-31 16:55]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface FeedbackSer extends Ser<Feedback, FeedbackDTO> {
    /**
     * 添加反馈
     *
     * @param feedbackTO
     * @return
     * @throws SerException
     */
    default void add(FeedbackTO feedbackTO) throws SerException {

    }
    /**
     * 我的反馈
     *
     * @return
     * @throws SerException
     */
    default List<Feedback> myFeedback( FeedbackDTO dto) throws SerException {
        return  null;
    }

}
