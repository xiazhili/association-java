package com.bjike.entity.taxi;

import com.bjike.entity.BaseEntity;

import javax.persistence.*;

/**
 * 订单评价图片
 *
 * @Author:	[ liguiqin ]
 * @Date: [  2017-09-06 15:38:38 ]
 * @Description: [ 订单评价图片 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "taxi_evaluate_picture")
public class EvaluatePicture extends BaseEntity {

    /**
     * 评价
     */
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "evaluate_id", columnDefinition = "VARCHAR(36) COMMENT '所属评价' ", nullable = false)
	private Evaluate evaluate;
    /**
     * 图片路径
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '图片路径' ")
 	private String image;

 	public Evaluate getEvaluate () {
		return evaluate;
	}
	public void setEvaluate (Evaluate evaluate) {
		this.evaluate =evaluate;
	}
 	
 	public String getImage () {
		return image;
	}
	public void setImage (String image) {
		this.image =image;
	}
 	


}
