package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BServlet implements Servlet {
	
	private ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//获取servletContext对象
		ServletContext context = config.getServletContext();
		
		/**
		 * ServletContext:
		 * 【代表】代表整个web应用，每一个web项目都有它唯一对应的servletContext对象
		 * 		它在项目启动时创建，在项目卸载时销毁
		 * 【获取】通过servletConfig对象可以获取到servletContext对象
		 * 【功能】
		 * 		1. 获取web应用的初始化参数
		 * 			<context-param>
						<param-name>username</param-name>
						<param-value>admin</param-value>
					</context-param>
		 * 		2. 获取web资源在服务器中的物理路径(注意：此路径不一定存在）
		 * 			物理路径：C:\Users\Administrator\Desktop\Third\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\06-web-servlet\WEB-INF
		 * 			虚拟路径：http://localhost:8080/06-web-servlet/BServlet
		 * 		3. 它可以作为一个最大域对象，在不同资源之间共享数据
		 */
		
		//1. 获取web应用的初始化参数
		String name = context.getInitParameter("username");
		System.out.println(name);
		
		//2. 获取物理路径
		String path = context.getRealPath("/pages/home");
		System.out.println(path);
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
