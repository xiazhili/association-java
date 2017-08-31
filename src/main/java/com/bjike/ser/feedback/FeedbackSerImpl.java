package com.bjike.ser.feedback;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.UserUtil;
import com.bjike.dto.Restrict;
import com.bjike.dto.feedback.FeedbackDTO;
import com.bjike.entity.feedback.Feedback;
import com.bjike.entity.user.User;
import com.bjike.ser.ServiceImpl;
import com.bjike.to.feedback.FeedbackTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: [liguiqin]
 * @Date: [2017-08-31 16:59]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class FeedbackSerImpl extends ServiceImpl<Feedback, FeedbackDTO> implements FeedbackSer {
    @Transactional
    @Override
    public void add(FeedbackTO to) throws SerException {
        User user = UserUtil.currentUser();
        Feedback feedback = new Feedback();
        feedback.setContent(to.getContent());
        feedback.setUser(user);
        feedback.setHandleTime(LocalDateTime.now());
        super.save(feedback);
    }

    @Override
    public List<Feedback> myFeedback(FeedbackDTO dto) throws SerException {
        String userId = UserUtil.currentUserID();
        dto.getConditions().add(Restrict.eq("user.id", userId));
        dto.getSorts().add("handle=asc");
        return super.findByCis(dto);
    }
}
