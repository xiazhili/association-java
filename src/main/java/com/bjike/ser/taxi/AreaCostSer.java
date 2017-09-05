package com.bjike.ser.taxi;

import com.bjike.common.exception.SerException;
import com.bjike.dto.taxi.AreaCostDTO;
import com.bjike.entity.taxi.AreaCost;
import com.bjike.ser.Ser;
import com.bjike.to.taxi.AreaCostTO;

/**
 * 地区费用业务操作接口
 *
 * @Author: [ liguiqin ]
 * @Date: [  2017-09-05 10:30:15 ]
 * @Description: [ 地区费用 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
public interface AreaCostSer extends Ser<AreaCost, AreaCostDTO> {
    /**
     * 添加
     * @param to
     * @throws SerException
     */
    default void add(AreaCostTO to) throws SerException {

    }

}
