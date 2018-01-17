package com.atguigu.bean;

import java.util.Date;

/**
 * 描述：封装订单信息
 * 开发者：Miss Wang
 * 2017年4月24日 下午6:08:17
 */
public class Order {
	//订单号：当前时间+""+用户id
	private String id;
	private int totalCount;
	private double totalAmount;
	//结账日期
	private Date createDate;
	//保存状态：0未发货，1已发货，2交易完成
	private int state;
	private int userId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Order(String id, int totalCount, double totalAmount,
			Date createDate, int state, int userId) {
		super();
		this.id = id;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
		this.createDate = createDate;
		this.state = state;
		this.userId = userId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", totalCount=" + totalCount
				+ ", totalAmount=" + totalAmount + ", createDate=" + createDate
				+ ", state=" + state + ", userId=" + userId + "]";
	}
	
	

}
