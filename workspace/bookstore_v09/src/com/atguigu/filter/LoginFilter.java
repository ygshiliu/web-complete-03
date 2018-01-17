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
import javax.servlet.http.HttpSession;

import com.atguigu.bean.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//获取用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user==null){
			response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
			return;
		}
		
		//放行
		chain.doFilter(request, response);
		
	}
	
}
