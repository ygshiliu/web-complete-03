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
 * 处理登录请求
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService us = new UserServiceImpl();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//组织请求参数
		User user = new User(null, username, password, null);
		
		//调用业务层处理
		User loginuser = us.login(user);
		
		//根据结果返回页面
		if(loginuser == null){
			//说明用户名或密码不正确，需要重新登录，转发到登录页面
			//设置错误信息提示用户
			request.setAttribute("msg", "您输入的用户名或密码不正确，请重新输入");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			
		}else{
			//登录成功,重定向到login_success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}

}
