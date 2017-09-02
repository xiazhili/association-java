package com.bjike.vo.addressBook;

import com.bjike.vo.BaseVO;

/**
 * 通讯录
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-29 16:25]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class AddressBookVO extends BaseVO {
    /**
     * 通讯录人id
     */
    private String bookId;
    /**
     * 通讯录头像
     */
    private String headPath;
    /**
     * 备注
     */
    private String remark;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
