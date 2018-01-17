package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//验证正确性
		System.out.println("从数据库中获取用户名和密码");
		//根据验证结果返回不同的页面
		if("admin".equals(username) && "123456".equals(password)){
			//登录成功,重定向到login_success.html
			response.sendRedirect("login_success.html");
		}else{
			//登录失败
			request.getRequestDispatcher("error.html").forward(request, response);
		}
	}

}
