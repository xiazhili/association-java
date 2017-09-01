package com.bjike.ser.user;

import com.bjike.common.exception.SerException;
import com.bjike.dto.user.SignDTO;
import com.bjike.entity.user.Sign;
import com.bjike.ser.Ser;

import java.util.List;

/**
 * @Author: [liguiqin]
 * @Date: [2017-08-29 17:29]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface SignSer  extends Ser<Sign, SignDTO> {

    /**
     * 签到
     *
     * @return
     * @throws
     */
    default Integer sign( ) throws SerException {
        return null;
    }
    /**
     * 当月签到列表
     *
     * @return
     * @throws
     */
    default List<Sign> signList(String startDate, String endDate ) throws SerException {
        return null;
    }

}
