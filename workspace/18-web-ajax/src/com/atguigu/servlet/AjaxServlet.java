package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("收到请求:"+username+"--"+password);
		
//		response.setContentType("text/xml;charset=utf-8");
		//返回响应
//		response.getWriter().print("Jerry");
//		response.getWriter().print("<name>Jerry</name>");
		
		response.setContentType("text/json;charset=utf-8");
		User user = new User("刘在石", 34, 45.0, true);
		Gson gson = new Gson();
		String json = gson.toJson(user);
		response.getWriter().print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		System.out.println(username+"--"+age);
		
		//返回响应
		//response.getWriter().print("<stu><name>Lucy</name><age>23</age></stu>");
		//response.getWriter().print("{\"name\":\"Lucy\",\"age\":23}");
		response.setContentType("text/json;charset=utf-8");
		User user = new User("Gray", 23, 45.0, true);
		//将java对象转成json字符串
		Gson gson = new Gson();
		String json = gson.toJson(user);
		response.getWriter().print(json);
	}

}
