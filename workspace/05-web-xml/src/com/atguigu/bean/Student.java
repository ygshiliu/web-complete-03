package com.atguigu.bean;

public class Student {
	
	private String name;
	private int age;
	private String sex;
	private String desc;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Student(String name, int age, String sex, String desc) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.desc = desc;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex
				+ ", desc=" + desc + "]";
	}
	
	
}
