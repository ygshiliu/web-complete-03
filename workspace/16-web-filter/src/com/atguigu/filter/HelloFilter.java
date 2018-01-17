package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 描述：过滤请求
 * 开发者：Miss Wang
 * 2017年4月25日 上午11:56:43
 */
public class HelloFilter implements Filter {
	
	public HelloFilter() {
		//System.out.println("HelloFilter构造器被调用");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		//System.out.println("init方法被调用");
	}
	
	//每次过滤请求都会调用doFilter方法
	/**
	 * ServletRequest:请求报文
	 * ServletResponse：响应报文
	 * FilterChain：过滤器链。当调用doFilter()时，用来调用下一个过滤器或目标资源。
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("doFilter方法被调用");
		
/*		//不调用doFilter()方法就是拦截请求
		System.out.println("请求被拦截");
		
		//放行请求
		chain.doFilter(request, response);
		
		response.setContentType("text/html;charset=utf-8");
		//可以对响应进行处理
		response.getWriter().print("被Filter处理过的响应");*/
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy方法被调用");
	}

}
