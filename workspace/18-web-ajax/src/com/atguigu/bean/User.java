package com.atguigu.bean;
/**
 * 描述：
 * 开发者：Miss Wang
 * 2017年4月27日 下午6:49:56
 */
public class User {
	
	private String name;
	private int age;
	private double price;
	private boolean flag;
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User(String name, int age, double price, boolean flag) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
		this.flag = flag;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", price=" + price
				+ ", flag=" + flag + "]";
	}
	
}
