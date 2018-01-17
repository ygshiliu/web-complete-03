package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * 用户登出？
		 * 1. 将session域中的用户信息移除
		 * 2. 直接将session失效
		 */
		
		//获取session
		HttpSession session = request.getSession();
		session.invalidate();
		
		//重定向到index.jsp
		response.sendRedirect("index.jsp");
	}


}
