package com.bjike.act.feedback;

import com.bjike.common.exception.ActException;
import com.bjike.common.exception.SerException;
import com.bjike.common.interceptor.login.LoginAuth;
import com.bjike.common.restful.ActResult;
import com.bjike.common.restful.Result;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dto.feedback.FeedbackDTO;
import com.bjike.entity.feedback.Feedback;
import com.bjike.ser.feedback.FeedbackSer;
import com.bjike.to.feedback.FeedbackTO;
import com.bjike.vo.feedback.FeedbackVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 反馈
 *
 * @Author: [liguiqin]
 * @Date: [2017-08-31 17:00]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@RestController
@RequestMapping("feedback")
public class FeedbackAct {
    @Autowired
    private FeedbackSer feedbackSer;

    /**
     * 添加反馈
     *
     * @param feedbackTO 反馈内容
     * @return class ShopVO
     * @throws Exception
     * @version v1
     */
    @LoginAuth
    @GetMapping("add")
    public Result add(FeedbackTO feedbackTO) throws ActException {
        try {
            feedbackSer.add(feedbackTO);
            return ActResult.initialize("add success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 我的反馈
     *
     * @return class FeedbackVO
     * @version v1
     */
    @LoginAuth
    @GetMapping("list")
    public Result list(FeedbackDTO dto) throws ActException {
        try {
            List<Feedback> list = feedbackSer.myFeedback(dto);
            return ActResult.initialize(BeanCopy.copyProperties(list, FeedbackVO.class));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }
}
