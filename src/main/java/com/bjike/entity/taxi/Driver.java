package com.bjike.entity.taxi;

import com.bjike.entity.BaseEntity;
import com.bjike.entity.user.User;

import javax.persistence.*;

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
     * 所属人
     */
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "VARCHAR(36) COMMENT '所属人id' ", nullable = false)
    private User user;
    /**
     * 城市
     */
    @Column(columnDefinition = "VARCHAR(100) COMMENT '城市' ", nullable = false)

    private String address;
    /**
     * 身份证
     */
    @Column(columnDefinition = "VARCHAR(18) COMMENT '身份证' ", nullable = false)
    private String idCard;
    /**
     * 车型
     */
    @Column(columnDefinition = "VARCHAR(100) COMMENT '车型' ", nullable = false)
    private String motorcycleType;
    /**
     * 车牌
     */
    @Column(columnDefinition = "VARCHAR(8) COMMENT '车牌' ", nullable = false)
    private String plateNumber;

    /**
     * 审核
     */
    @Column(name = "is_verify", columnDefinition = "TINYINT(1) COMMENT '是否已审核'", nullable = false)
    private Boolean verify=false;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Boolean getVerify() {
        return verify;
    }

    public void setVerify(Boolean verify) {
        this.verify = verify;
    }
}
