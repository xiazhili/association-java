package com.bjike.vo.activity;

import com.bjike.vo.BaseVO;


/**
 * 评论点赞表值对象
 *
 * @Author:	[ chenjunhao ]
 * @Date: [  2017-09-04 14:05:33 ]
 * @Description: [ 评论点赞表 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
public class ThumbVO extends BaseVO{

    /**
     * 评论id
     */
 	private String commentId;


 	public String getCommentId () {
		return commentId;
	}
	public void setCommentId (String commentId) {
		this.commentId =commentId;
	}


}
