package com.bjike.ser.taxi;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dto.taxi.AreaCostDTO;
import com.bjike.entity.taxi.AreaCost;
import com.bjike.ser.ServiceImpl;
import com.bjike.to.taxi.AreaCostTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 地区费用业务操作实现
 *
 * @Author: [ liguiqin ]
 * @Date: [  2017-09-05 10:30:15 ]
 * @Description: [ 地区费用 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
@Service
public class AreaCostSerImpl extends ServiceImpl<AreaCost, AreaCostDTO> implements AreaCostSer {

    @Transactional
    @Override
    public void add(AreaCostTO to) throws SerException {
        AreaCost cost = BeanCopy.copyProperties(to, AreaCost.class);
        if(null == cost.getEnable()){
            cost.setEnable(false);
        }
        super.save(cost);
    }
}


