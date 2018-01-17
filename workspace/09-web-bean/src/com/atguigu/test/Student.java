package com.atguigu.test;
/**
 * 描述：
 * 开发者：Miss Wang
 * 下午9:06:20
 */
public class Student {
	
	private String name;
	private int age;
	private String gender;
	private boolean flag;
	
	
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getName() {
		System.out.println("getname");
		return name;
	}
	public void setName(String name) {
		System.out.println("setname");
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender
				+ ", flag=" + flag + "]";
	}
	
	
	
}
