package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 描述：
 * 开发者：Miss Wang
 * 2017年4月25日 下午3:09:16
 */
public class AFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("1.请求到达AFilter");
		chain.doFilter(request, response);
		System.out.println("2.回到AFilter");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
