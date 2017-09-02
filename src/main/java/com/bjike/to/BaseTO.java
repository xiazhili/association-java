package com.bjike.to;

import com.bjike.common.aspect.DEL;
import com.bjike.common.aspect.EDIT;
import com.bjike.to.addressBook.InterestAllianceTO;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Author: [liguiqin]
 * @Date: [2017-06-27 17:56]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public abstract class BaseTO implements Serializable {
    /**
     * 数据行id
     */
    @NotBlank(message = "id不能为空", groups = {EDIT.class, DEL.class,InterestAllianceTO.ADDMEMBER.class})
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
