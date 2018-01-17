package com.atguigu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Student;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//从数据库中获取学生信息列表
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("刘在石", "男", "北京"));
		list.add(new Student("宋智孝", "女", "天津"));
		list.add(new Student("李光洙", "男", "石家庄"));
		list.add(new Student("金钟国", "男", "青岛"));
		
		//将数据放 域中
		//使用域对象有一个原则：能使用小的就不使用大的
		//而在servlet中我们只能获取到三个域对象：request session application
		request.setAttribute("list", list);
		
		//转发到jsp页面
		request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
