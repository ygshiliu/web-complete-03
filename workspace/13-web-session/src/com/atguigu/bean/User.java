package com.atguigu.bean;

import java.io.Serializable;

/**
 * 描述：
 * 开发者：Miss Wang
 * 2017年4月21日 下午3:36:50
 */
public class User implements Serializable{
	
	private String name;
	private int age;
	private boolean flag;
	private Address addr;
	
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
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
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public User(String name, int age, boolean flag) {
		super();
		this.name = name;
		this.age = age;
		this.flag = flag;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", flag=" + flag
				+ ", addr=" + addr + "]";
	}
	
	
}
