package com.bjike.to.taxi;

import com.bjike.to.BaseTO;

/**
 * 司机传输实体
 *
 * @Author: [liguiqin]
 * @Date: [2017-09-02 15:12]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class DriverTO extends BaseTO {
    /**
     * 城市
     */

    private String address;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 车型
     */
    private String motorcycleType;
    /**
     * 车牌
     */
    private String plateNumber;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMotorcycleType() {
        return motorcycleType;
    }

    public void setMotorcycleType(String motorcycleType) {
        this.motorcycleType = motorcycleType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
