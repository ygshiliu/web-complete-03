package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PathServlet
 */
public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建cookie
		Cookie cookie = new Cookie("username", "haha");
		//设置cookie有效路径
		//这里的路径是由浏览器来解析，所以这里要加上项目名
		//设置有效路径后，只有访问该目标下的资源时浏览器访问服务器才会发送此cookie
		//cookie.setPath(request.getContextPath()+"/aaa");
		
		//设置cookie的有效时间
		//当设置为0时,代表cookie会立即失效
		//Set-Cookie: username=haha; Expires=Thu, 01-Jan-1970 00:00:10 GMT
		//cookie.setMaxAge(0);
		
		//当指定一个正整数，代表有效时间为指定秒数
		//Set-Cookie: username=haha; Expires=Thu, 20-Apr-2017 08:15:28 GMT
		//这里是标准格林威治时间，与中国相差8小时
		//cookie.setMaxAge(30);
		
		//指定负数，与不设置一样，代表一次会话有效
		//Set-Cookie: username=haha
		cookie.setMaxAge(-15);
		
		//发送给浏览
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
