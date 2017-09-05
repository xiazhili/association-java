package com.bjike.ser.activity;

import com.bjike.common.exception.SerException;
import com.bjike.ser.Ser;
import com.bjike.dto.activity.ActivityCommentDTO;
import com.bjike.entity.activity.ActivityComment;
import com.bjike.to.activity.ActivityCommentTO;
import com.bjike.vo.activity.ActivityCommentVO;

import java.util.List;

/**
 * 活动评论业务操作接口
 *
 * @Author:	[ chenjunhao ]
 * @Date: [  2017-09-04 13:58:03 ]
 * @Description: [ 活动评论 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
public interface ActivityCommentSer extends Ser<ActivityComment, ActivityCommentDTO>{
    /**
     * 评论
     * @param to
     * @throws SerException
     */
    void comment(ActivityCommentTO to) throws SerException;

    /**
     * 删除评论
     * @param id
     * @throws SerException
     */
    void delete(String id) throws SerException;

    /**
     * 回复评论
     * @param to
     * @throws SerException
     */
    void repay(ActivityCommentTO to) throws SerException;

    /**
     * 查看某活动的所有评论
     * @param activityId
     * @return
     * @throws SerException
     */
    List<ActivityCommentVO> comments(String activityId) throws SerException;

    /**
     * 查看某活动的评论数
     * @param activityId
     * @return
     * @throws SerException
     */
    Long commentNum(String activityId) throws SerException;
    /**
     * 对评论点赞
     * @param id
     * @throws SerException
     */
    void thumb(String id) throws SerException;

    /**
     * 取消点赞
     * @param id
     * @throws SerException
     */
    void cancelThumb(String id) throws SerException;

    /**
     * 某条评论的点赞数
     * @param id
     * @return
     * @throws SerException
     */
    Long thumbNum(String id) throws SerException;

    /**
     * 查看当前用户对某条评论是否有点赞
     * @param id
     * @return
     * @throws SerException
     */
    Boolean check(String id) throws SerException;
}
