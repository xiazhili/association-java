package com.bjike.ser.activity;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.UserUtil;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dto.Restrict;
import com.bjike.dto.activity.ActivityCommentDTO;
import com.bjike.dto.activity.ThumbDTO;
import com.bjike.entity.activity.ActivityComment;
import com.bjike.entity.activity.Thumb;
import com.bjike.entity.user.User;
import com.bjike.ser.ServiceImpl;
import com.bjike.ser.user.UserSer;
import com.bjike.to.activity.ActivityCommentTO;
import com.bjike.vo.activity.ActivityCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 活动评论业务操作实现
 *
 * @Author: [ chenjunhao ]
 * @Date: [  2017-09-04 13:58:03 ]
 * @Description: [ 活动评论 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
@Service
public class ActivityCommentSerImpl extends ServiceImpl<ActivityComment, ActivityCommentDTO> implements ActivityCommentSer {
    @Autowired
    private ThumbSer thumbSer;
    @Autowired
    private UserSer userSer;

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void comment(ActivityCommentTO to) throws SerException {
        String userId = UserUtil.currentUserID();
        ActivityComment entity = BeanCopy.copyProperties(to, ActivityComment.class, true);
        entity.setUserId(userId);
        entity.setTime(LocalDateTime.now());
        super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void delete(String id) throws SerException {
        super.remove(id);
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void repay(ActivityCommentTO to) throws SerException {
        String userId = UserUtil.currentUserID();
        String repayId = to.getId();
        ActivityComment entity = BeanCopy.copyProperties(to, ActivityComment.class, true, "id");
        entity.setUserId(userId);
        entity.setTime(LocalDateTime.now());
        entity.setRepayId(repayId);
        super.save(entity);
    }

    @Override
    public List<ActivityCommentVO> comments(String activityId) throws SerException {
        ActivityCommentDTO dto = new ActivityCommentDTO();
        dto.getConditions().add(Restrict.eq("activityId", activityId));
        List<ActivityComment> list = super.findByCis(dto);
        List<ActivityCommentVO> vos = new ArrayList<>();
        for (ActivityComment comment : list) {
            String userId = comment.getUserId();
            String repayId = comment.getRepayId();
            User user = userSer.findById(userId);
            ActivityCommentVO vo = BeanCopy.copyProperties(comment, ActivityCommentVO.class);
            vo.setHeadPath(user.getHeadPath());
            if (null != repayId) {
                ActivityComment repay = super.findById(repayId);
                vo.setTitle(user.getUsername() + " 回复 " + userSer.findById(repay.getUserId()).getUsername());
            } else {
                vo.setTitle(user.getUsername());
            }
            vos.add(vo);
        }
        return vos;
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void thumb(String id) throws SerException {
        String userId = UserUtil.currentUserID();
        Thumb thumb = new Thumb();
        thumb.setCommentId(id);
        thumb.setUserId(userId);
        thumbSer.save(thumb);
    }

    @Override
    public Long thumbNum(String id) throws SerException {
        ThumbDTO dto = new ThumbDTO();
        dto.getConditions().add(Restrict.eq("commentId", id));
        return thumbSer.count(dto);
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void cancelThumb(String id) throws SerException {
        ThumbDTO dto = new ThumbDTO();
        dto.getConditions().add(Restrict.eq("commentId", id));
        dto.getConditions().add(Restrict.eq("userId", UserUtil.currentUserID()));
        Thumb thumb = thumbSer.findOne(dto);
        if (null != thumb) {
            thumbSer.remove(thumb);
        }
    }

    @Override
    public Boolean check(String id) throws SerException {
        ThumbDTO dto = new ThumbDTO();
        dto.getConditions().add(Restrict.eq("commentId", id));
        dto.getConditions().add(Restrict.eq("userId", UserUtil.currentUserID()));
        Thumb thumb = thumbSer.findOne(dto);
        if (null != thumb) {
            return true;
        }
        return false;
    }

    @Override
    public Long commentNum(String activityId) throws SerException {
        ActivityCommentDTO dto = new ActivityCommentDTO();
        dto.getConditions().add(Restrict.eq("activityId", activityId));
        return super.count(dto);
    }
}


