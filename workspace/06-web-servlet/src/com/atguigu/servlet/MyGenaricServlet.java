package com.atguigu.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 此类专门用于让其它类继承的
 * @author Administrator
 *
 */
public abstract class MyGenaricServlet implements Servlet,ServletConfig{
	
	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		init();
	}
	/**
	 * 之后重写init无参方法 
	 * @throws ServletException
	 */
	public void init() throws ServletException {}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public abstract void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException ;

	@Override
	public String getServletInfo() {
		return "";
	}

	@Override
	public void destroy() {}

	@Override
	public String getServletName() {
		return config.getServletName();
	}

	@Override
	public ServletContext getServletContext() {
		return config.getServletContext();
	}

	@Override
	public String getInitParameter(String name) {
		return config.getInitParameter(name);
	}

	@Override
	public Enumeration getInitParameterNames() {
		return config.getInitParameterNames();
	}
	

}
