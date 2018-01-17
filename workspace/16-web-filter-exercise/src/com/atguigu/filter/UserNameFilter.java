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
 * Servlet Filter implementation class UserNameFilter
 */
public class UserNameFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//获取请求参数
		String username = request.getParameter("username");
		if(!"admin".equals(username)){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		chain.doFilter(request, response);
	}


	
}
