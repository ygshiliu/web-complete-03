package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 创建servlet的步骤：
 * 第一步：创建一个类，实现servlet接口，并实现所有的抽象方法
 * 第二步：需要在web.xml中注册servlet
 * 
 * servlet是由我们定义，但由tomcat（servlet容器）来管理
 * servlet容器负责管理的是什么呢？主要是servlet的生命周期
 * 
 * 人的生命周期：是人从出生到死亡的过程，要经历出生、工作、死亡三个阶段
 * servlet的生命周期也是从被创建到被销毁的过程。
 * 显然servlet的生命周期就是servlet容器创建servlet实例到销毁servlet实例的过程。
 * 
 * 体现在程序中，servlet是一个java类，即servlet实例的创建和销毁是容器通过调用方法来实现
 * 也就是说，servlet的生命周期主要是指以下方法：
 * 	构造器
 * 	init()
 * 	service()
 * 	destroy()
 * 
 * 第一次访问servlet时：
 * 	构造器被调用
	init被调用
	service被调用
 * 
 * 第一次之后再访问servlet时：
 * 	service被调用
 * 
 * 当项目卸载时：
 * 	destroy被调用
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class HelloServlet implements Servlet{
	
	public HelloServlet() {
		System.out.println("构造器被调用");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init被调用");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig被调用");
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * ServletRequest:代表浏览器向服务器发送的请求报文
	 * ServletResponse：代表服务器向浏览器发送的响应报文
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		System.out.println("service被调用");
		
		/*//向控制台输出一条信息
		System.out.println("Hello Server!");
		
		//向页面输出信息
		res.getWriter().print("Hello Browser!");
		*/
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo被调用");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("destroy被调用");
		
	}

}
