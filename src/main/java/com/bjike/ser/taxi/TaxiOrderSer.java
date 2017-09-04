package com.bjike.ser.taxi;

import com.bjike.common.exception.SerException;
import com.bjike.dto.taxi.TaxiOrderDTO;
import com.bjike.entity.taxi.TaxiOrder;
import com.bjike.ser.Ser;
import com.bjike.to.taxi.TaxiOrderTO;

/**
 * 叫车订单 业务操作接口
 *
 * @Author: [ liguiqin ]
 * @Date: [  2017-09-02 17:50:09 ]
 * @Description: [ 叫车订单 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
public interface TaxiOrderSer extends Ser<TaxiOrder, TaxiOrderDTO> {
    /**
     * 发布用车需求
     *
     * @param to 申请实体
     * @return
     * @throws SerException
     */
    default Boolean publish(TaxiOrderTO to) throws SerException {
        return null;

    }

    /**
     * 司机接单
     * @return
     * @throws SerException
     */
    default Boolean taking(String orderId ) throws SerException {
        return null;

    }


}
