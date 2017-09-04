package com.bjike.ser.taxi;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.UserUtil;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dto.Restrict;
import com.bjike.dto.taxi.TaxiOrderDTO;
import com.bjike.entity.taxi.TaxiOrder;
import com.bjike.entity.user.User;
import com.bjike.ser.ServiceImpl;
import com.bjike.to.taxi.TaxiOrderTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 叫车订单 业务操作实现
 *
 * @Author: [ liguiqin ]
 * @Date: [  2017-09-02 17:50:09 ]
 * @Description: [ 叫车订单 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
@Service
public class TaxiOrderSerImpl extends ServiceImpl<TaxiOrder, TaxiOrderDTO> implements TaxiOrderSer {

    @Transactional
    @Override
    public Boolean publish(TaxiOrderTO to) throws SerException {
        User user = UserUtil.currentUser(false);
        TaxiOrder taxiOrder = BeanCopy.copyProperties(to, TaxiOrder.class);
        taxiOrder.setUser(user);
        taxiOrder.setReceived(false);
        super.save(taxiOrder);
        return true;
    }

    @Override
    public Boolean taking(String orderId) throws SerException {
        TaxiOrderDTO dto = new TaxiOrderDTO();
        dto.getConditions().add(Restrict.eq("id", orderId));
        dto.getConditions().add(Restrict.eq("received", false));
        TaxiOrder taxiOrder = super.findOne(dto);
        if (null != taxiOrder) {
            taxiOrder.setReceived(true);
        } else {
            throw new SerException("订单不存在,或已被抢单了");
        }
        return true;
    }
}


