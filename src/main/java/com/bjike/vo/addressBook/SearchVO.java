package com.bjike.vo.addressBook;

import com.bjike.vo.user.UserVO;

/**
 * 搜索列表对象
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-31 15:57]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class SearchVO {
    /**
     * 用户对象
     */
    private UserVO userVO;
    /**
     * 备注
     */
    private String remark;
    /**
     * 共同好友人数
     */
    private Integer num;

    /**
     * 通讯录id
     */
    private String bookId;

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
