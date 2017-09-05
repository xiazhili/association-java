package com.bjike.vo.taxi;

import com.bjike.vo.BaseVO;


/**
 * 地区费用值对象
 *
 * @Author:	[ liguiqin ]
 * @Date: [  2017-09-05 10:30:15 ]
 * @Description: [ 地区费用 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [com.bjike]
 */
public class AreaCostVO extends BaseVO {

    /**
     * 地区
     */
 	private String area;
    /**
     * 每公里单价
     */
 	private Double unitPrice;
    /**
     * 每分钟单价
     */
 	private Double perMinute;
    /**
     * 是否启用
     */
 	private Boolean enable;

 	public String getArea () {
		return area;
	}
	public void setArea (String area) {
		this.area =area;
	}

 	public Double getUnitPrice () {
		return unitPrice;
	}
	public void setUnitPrice (Double unitPrice) {
		this.unitPrice =unitPrice;
	}

 	public Double getPerMinute () {
		return perMinute;
	}
	public void setPerMinute (Double perMinute) {
		this.perMinute =perMinute;
	}

 	public Boolean getEnable () {
		return enable;
	}
	public void setEnable (Boolean enable) {
		this.enable =enable;
	}



}
