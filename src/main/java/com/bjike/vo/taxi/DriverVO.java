package com.bjike.vo.taxi;

import com.bjike.vo.BaseVO;


/**
 * 申请司机信息
 *
 * @Author: [ liguiqin ]
 * @Date: [  2017-09-02 15:13:45 ]
 * @Description: [ 申请司机信息 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
public class DriverVO extends BaseVO {
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
     * 驾驶证照片
     */
    private String[] images;


    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

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
