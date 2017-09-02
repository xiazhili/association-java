package com.bjike.entity.taxi;

import com.bjike.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 测试实体
 *
 * @Author:	[ liguiqin ]
 * @Date: [  2017-09-02 15:13:45 ]
 * @Description: [ 测试实体 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "taxi_driving_licence")
public class DrivingLicence extends BaseEntity{

    /**
     * 所属人
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '所属人' ")
 	private Driver driver;
    /**
     * 驾驶证照片
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '驾驶证照片' ")
 	private String images;

 	public Driver getDriver () {
		return driver;
	}
	public void setDriver (Driver driver) {
		this.driver =driver;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
}
