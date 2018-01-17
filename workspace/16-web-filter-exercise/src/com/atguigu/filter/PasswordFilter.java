package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class PasswordFilter
 */
public class PasswordFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//获取请求参数 
		String password = request.getParameter("password");
		if("123123".equals(password)){
			chain.doFilter(request, response);
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/success.jsp");
		
	}
	
}
