package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodeServlet
 */
public class EncodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//必须 在第一次获取请求参数之前调用此方法才有效
		request.setCharacterEncoding("utf-8");
		//获取请求参数
		String name = request.getParameter("name");
		System.out.println(name);
		
		//指定服务器字符集
		//response.setCharacterEncoding("utf-8");
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("柳暗花明又一村");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//必须 在第一次获取请求参数之前调用此方法才有效
		request.setCharacterEncoding("utf-8");
		//获取请求参数
		String name = request.getParameter("name");
		System.out.println(name);
		//直接将请求参数发送给浏览器
	}

}
