package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AServlet implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		/**
		 * ServletConfig:
		 * 【代表】ServletConfig就是当前servlet在web.xml中配置的servlet标签，
		 * 		   每一个servlet都有它唯一对应的servletconfig对象
		 * 【获取】它是由服务器创建，并且最终作为init方法的参数传递进来，我们可以直接使用
		 * 【功能】
		 * 		1.获取servlet别名
		 * 		2.获取初始化参数 
		 * 		3.可以获取ServletContext对象
		 * 		这是web应用中最大的域对象，可以在不同web资源中共享数据
		 */
		
		//1.获取servlet别名
		String name = config.getServletName();
		//System.out.println(name);
		
		//2.获取初始化参数
		String init = config.getInitParameter("file");
		//System.out.println(init);
		
		//3.可以获取ServletContext对象
		ServletContext context = config.getServletContext();
		
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
