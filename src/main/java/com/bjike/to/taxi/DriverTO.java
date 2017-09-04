package com.bjike.to.taxi;

import com.bjike.common.aspect.ADD;
import com.bjike.common.aspect.EDIT;
import com.bjike.to.BaseTO;
import org.hibernate.validator.constraints.NotBlank;

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
    @NotBlank(message = "请填写城市", groups = {ADD.class, EDIT.class})
    private String address;
    /**
     * 身份证
     */
    @NotBlank(message = "请填写身份证", groups = {ADD.class, EDIT.class})
    private String idCard;
    /**
     * 车型
     */
    @NotBlank(message = "请填写车型", groups = {ADD.class, EDIT.class})
    private String motorcycleType;
    /**
     * 车牌
     */
    @NotBlank(message = "请填写车牌", groups = {ADD.class, EDIT.class})
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
