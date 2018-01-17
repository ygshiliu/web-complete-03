package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSPServlet
 */
public class JSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从数据库中获取数据
		String name = "Lucy";
		
		//返回一个页面或是一个页面片段
		//可以动态输出一个页面片段信息
		response.getWriter().print("<h1>"+name+"</h1>");
		//也可以动态输出一个完整的页面
		response.getWriter().print("<!DOCTYPE html>");
		response.getWriter().print("<html>");
		response.getWriter().print("</html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
