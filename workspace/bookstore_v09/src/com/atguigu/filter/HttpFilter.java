package com.atguigu.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 此抽象类专门用来继承
 * Servlet Filter implementation class HttpFilter
 */
public abstract class HttpFilter implements Filter,FilterConfig {
	
	private FilterConfig filterConfig;
	
	/**
	 * FilterConfig:用来封装web.xml中filter标签中的信息
	 * 可以使用此对象获取servletContext对象
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		init();
	}
	
	public void init(){}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		doFilter(req, resp, chain);
	}
	
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain) throws IOException, ServletException ;

	@Override
	public void destroy() {}

	@Override
	public String getFilterName() {
		return filterConfig.getFilterName();
	}

	@Override
	public ServletContext getServletContext() {
		return filterConfig.getServletContext();
	}

	@Override
	public String getInitParameter(String name) {
		return filterConfig.getInitParameter(name);
	}

	@Override
	public Enumeration getInitParameterNames() {
		return filterConfig.getInitParameterNames();
	}
	

}
