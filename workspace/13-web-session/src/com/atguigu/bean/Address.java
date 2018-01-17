package com.atguigu.bean;

import java.io.Serializable;

/**
 * 描述：
 * 开发者：Miss Wang
 * 2017年4月21日 下午3:47:21
 */
public class Address implements Serializable{
	
	private String province;
	private String city;
	private String district;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city
				+ ", district=" + district + "]";
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String province, String city, String district) {
		super();
		this.province = province;
		this.city = city;
		this.district = district;
	}
	
	
}
