package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 描述：专门用来继承的servlet
 * 开发者：Miss Wang
 * 下午8:40:45
 */
public class BaseServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置请求编码
		//设置请求编码必须在第一次获取请求参数之前设置
		request.setCharacterEncoding("utf-8");
		
		//获取标识符
		String method = request.getParameter("method");
		try {
			//通过反射获取方法对象
			Method declaredMethod = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			//设置访问权限
			declaredMethod.setAccessible(true);
			//通过反射调用方法
			declaredMethod.invoke(this, request,response);
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
