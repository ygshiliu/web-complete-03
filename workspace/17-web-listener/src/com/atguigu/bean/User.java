package com.atguigu.bean;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 描述：
 * 开发者：Miss Wang
 * 2017年4月27日 下午2:00:57
 */
public class User implements HttpSessionBindingListener,HttpSessionActivationListener ,Serializable{
	
	private String name;
	private int age;
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
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("user绑定到session中");
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("user从session中移除");
	}
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("user同session钝化到硬盘中");
		
	}
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("user同session一起活化到内存中");
	}
	
	
}



