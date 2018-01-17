package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

/**
 * 处理注册请求
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService us = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		
		//组织请求参数 
		User user = new User(null, username, password, email);
		
		//调用业务逻辑层进行处理
		boolean flag = us.regist(user);
		
		//根据结果返回页面
		if(flag){
			//注册成功，重定向到regist_success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.html");
		}else{
			//注册失败，用户名已经存在,转发到regist.html
			request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
			
		}
	}

}
