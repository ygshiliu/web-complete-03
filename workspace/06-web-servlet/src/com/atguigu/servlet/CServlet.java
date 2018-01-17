package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CServlet extends MyGenaricServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("CServlet初始化");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		System.out.println("CServlet");
		
		//获取servletContext
		ServletContext context = getServletContext();
		String username = context.getInitParameter("username");
		System.out.println(username);
		
	}

}
