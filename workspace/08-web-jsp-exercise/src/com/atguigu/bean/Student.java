package com.atguigu.bean;
/**
 * 描述：封装学生信息的类
 * 开发者：Miss Wang
 * 下午3:50:48
 */
public class Student {
	
	private String name;
	private String gender;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student(String name, String gender, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", address="
				+ address + "]";
	}
	
	
	
}
