package com.bjike.to.addressBook;

import com.bjike.common.aspect.ADD;
import com.bjike.to.BaseTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 通讯录
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-29 08:51]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class AddressBookTO extends BaseTO {
    /**
     * 通讯录人id
     */
    @NotBlank(groups = ADD.class,message = "通讯录人id不能为空")
    private String bookId;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
