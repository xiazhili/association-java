package com.bjike.to.activity;

import com.bjike.to.BaseTO;


/**
 * 评论点赞表添加更新操作对象
 *
 * @Author:	[ chenjunhao ]
 * @Date: [  2017-09-04 14:05:33 ]
 * @Description: [ 评论点赞表 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
public class ThumbTO extends BaseTO{

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
