package com.bjike.entity.taxi;

import com.bjike.entity.BaseEntity;
import com.bjike.entity.user.User;

import javax.persistence.*;

/**
 * 叫车订单
 *
 * @Author: [ liguiqin ]
 * @Date: [  2017-09-02 17:50:09 ]
 * @Description: [ 叫车订单 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "taxi_order")
public class TaxiOrder extends BaseEntity {

    /**
     * 发布人
     */
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "VARCHAR(36) COMMENT '发布人id' ", nullable = false)
    private User user;
    /**
     * 经度
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '经度' ", nullable = false)
    private String longitude;
    /**
     * 纬度
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '纬度' ", nullable = false)
    private String latitude;
    /**
     * 已接单
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '已接单' ")
    private Boolean received;
    /**
     * 司机
     */
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", columnDefinition = "VARCHAR(36) COMMENT '司机id' ")
    private Driver driver;
    /**
     * 估计费用
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '估计费用' ")
    private Double cost;
    /**
     * 每公里单价
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '每公里单价' ")
    private Double unitPrice;
    /**
     * 起始地
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '起始地' ", nullable = false)
    private String startPoint;
    /**
     * 目的地
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '目的地' ", nullable = false)
    private String destination;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


}
