package com.bjike.act.taxi;

import com.bjike.common.exception.ActException;
import com.bjike.common.exception.SerException;
import com.bjike.common.restful.ActResult;
import com.bjike.common.restful.Result;
import com.bjike.ser.taxi.TaxiOrderSer;
import com.bjike.to.taxi.TaxiOrderTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 叫车订单控制器
 *
 * @Author: [ liguiqin ]
 * @Date: [  2017-09-02 17:50:09 ]
 * @Description: [ 叫车订单 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */

@RestController("order")
public class TaxiOrderAct {

    @Autowired
    private TaxiOrderSer taxiOrderSer;

    /**
     * 发布用车
     *
     * @param to 发布用车信息
     * @return
     * @throws ActException
     */
    @PostMapping("publish")
    public Result publish(@Validated({TaxiOrderTO.PUBLISH.class}) TaxiOrderTO to, BindingResult result) throws ActException {
        try {
            Boolean rs = taxiOrderSer.publish(to);
            return ActResult.initialize(rs);

        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 接单
     * @return
     * @throws ActException
     */
    @PutMapping("taking/{orderId}")
    public Result taking(@PathVariable String orderId) throws ActException {
        try {
            Boolean rs = taxiOrderSer.taking(orderId);
            return ActResult.initialize(rs);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }



}
