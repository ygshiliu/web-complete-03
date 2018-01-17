package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EServlet
 */
public class EServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 请求报文的格式：
		 * 	请求报文首部
		 * 		报文首行
		 * 		报文头
		 * 	空行
		 * 	请求报文体
		 * （Get请求没有报文体，所以也没有空行）
		 * 
		 * HttpServletRequest:
		 * 【代表】浏览器发送给服务器的请求报文
		 * 【获取】由服务器创建，最终作为参数传递给doGet与doPost方法，可以直接使用
		 * 【功能】
		 * 		1. 获取请求参数
		 * 		2. 可以获取项目名
		 * 		3. 可以发起请求的转发
		 * 		4. 它本身也是一个域对象，在不同的web资源中共享数据
		 * 
		 *  什么转发？
		 *  当前Servlet收到浏览器发送的请求后，并没有直接进行处理而是调用服务器中的其它资源进行处理
		 *  
		 *  转发的特点：
		 *  浏览器地址栏不发生变化
		 *  浏览器发送1次请求
		 *  转发发生在服务器端
		 *  浏览器感知不到
		 *  
		 *  
		 */
		
		//1. 获取请求参数
		String username = request.getParameter("username");
		System.out.println("请求参数:"+username);
		
		//2. 可以获取项目名
		String path = request.getContextPath();
		System.out.println("项目名："+path);
		
		String localAddr = request.getLocalAddr();
		System.out.println("localAddr:"+localAddr);
		int localPort = request.getLocalPort();
		System.out.println("localPort:"+localPort);
		String remoteAddr = request.getRemoteAddr();
		System.out.println("remoteAddr:"+remoteAddr);
		String remoteHost = request.getRemoteHost();
		System.out.println("remoteHost:"+remoteHost);
		int remotePort = request.getRemotePort();
		System.out.println("remotePort:"+remotePort);
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("requestURL:"+requestURL);
		String requestURI = request.getRequestURI();
		System.out.println("requestURI:"+requestURI);
		
		String queryString = request.getQueryString();
		System.out.println("queryString:"+queryString);
		int serverPort = request.getServerPort();
		System.out.println("serverPort:"+serverPort);
		String serverName = request.getServerName();
		System.out.println("serverName:"+serverName);
		
		//3. 可以发起请求的转发
		//获取派发器
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		//发送请求
		dispatcher.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 响应报文的格式：
		 * 响应报文首部
		 * 		响应报文道行
		 * 		响应报文头
		 * 空行
		 * 响应报文体
		 * 
		 * 
		 * HttpServletResponse:
		 * 【代表】服务器发送给浏览器的响应报文
		 * 【获取】由服务器创建，最终作为参数传递给doGet与doPost方法，可以直接使用
		 * 【功能】
		 * 		1. 可以向浏览器返回一张页面或一个页面片段
		 * 			（操作的是响应报文的报文体部分）
		 * 		2. 可以发起请求的重定向
		 * 
		 * 什么是请求的重定向？
		 * 当前servlet收到请求后会向浏览器返回一个响应信息，
		 * 浏览器收到响应信息后，会重新向另一个url地址发送请求
		 * 
		 *  HTTP/1.1 302 Found
			Location: http://localhost:8080/06-web-servlet/target.html
		 * 
		 * 这个响应信息包括一个响应状态码302 和一个响应头location
		 * 浏览器收到响应状态码302后，会重新向location指定的url地址发送请求
		 * 
		 * 重定向的特点：
		 * 浏览器的地址栏发生改变
		 * 浏览器发送了2次请求
		 * 发生在浏览器端
		 * 浏览器感知到
		 * 
		 */
		
		//1. 可以向浏览器返回一张页面或一个页面片段
		//获取输出流
		/*PrintWriter writer = response.getWriter();
		//向页面输出一条信息
		writer.print("<h1>I come frome server</h1>");*/
		
		//2. 可以发起请求的重定向
		response.sendRedirect("target.html");
	}

}
