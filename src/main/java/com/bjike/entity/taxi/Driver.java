package com.bjike.entity.taxi;

import com.bjike.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 司机信息
 *
 * @Author: [liguiqin]
 * @Date: [2017-09-02 09:17]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "taxi_driver")
public class Driver extends BaseEntity {
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

    /**
     * 审核
     */
    private Boolean verify;

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

    public Boolean getVerify() {
        return verify;
    }

    public void setVerify(Boolean verify) {
        this.verify = verify;
    }
}
