package com.atguigu.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建cookie
		Cookie cookie = new Cookie("username", "Tom");
		Cookie cookie2 = new Cookie("password", "123456");
//编码
String encode = URLEncoder.encode("刘在石", "utf-8");
Cookie cookie3 = new Cookie("name",encode);
		
		//发送给浏览器
		response.addCookie(cookie);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		
		//响应页面
		//response.sendRedirect(request.getContextPath()+"/index.html");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
