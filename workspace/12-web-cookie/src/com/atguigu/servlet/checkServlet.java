package com.atguigu.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkServlet
 */
public class checkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取cookie
		Cookie[] cookies = request.getCookies();
		if(cookies.length>0){
			for (Cookie cookie : cookies) {
				//获取cookie的键
				String name = cookie.getName();
				//获取cookie的值 
				String value = cookie.getValue();
				
				if("password".equals(name)){
					/*Cookie cookie2 = new Cookie(name, "567567");
					//要想让新cookie起作用，必须重新发送给浏览器
					response.addCookie(cookie2);*/
					
					cookie.setValue("090909");
					//让cookie失效
					cookie.setMaxAge(0);
					
					response.addCookie(cookie);
				}else if("name".equals(name)){
					
					String value2 = cookie.getValue();
					//解码
					String decode = URLDecoder.decode(value2, "utf-8");
					System.out.println("解码前："+value2);
					System.out.println("解码后："+decode);
					
				}else{
					//设置cookie有效时间
					cookie.setMaxAge(60*60*24*365*50);
					//发送给浏览器
					response.addCookie(cookie);
				}
				
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
