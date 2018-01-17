package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取请求参数
		String username = request.getParameter("username");
		
		System.out.println(username);
		
		/**
		 * request | session | application
		 * 判断用户是否登录？
		 * 可以将用户信息保存在session中
		 * 如果在session中可以获取到用户信息说明用户登录，否则没登录
		 */
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
