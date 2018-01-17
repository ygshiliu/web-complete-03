package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		try {
//			//模拟网络慢的问题
//			Thread.sleep(1000*10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		request.setCharacterEncoding("utf-8");
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		//获取用户提交的token
		String token = request.getParameter("token");
		
		
		//检查token
		HttpSession session = request.getSession();
		String sessionToken = (String) session.getAttribute("token");
		System.out.println("session:"+sessionToken);
		//移除session中的token
		session.removeAttribute("token");
		
		if(!token.equals(sessionToken)){
			//重复提交请求
			request.setAttribute("msg", "请不要重复提交表单信息");
			request.getRequestDispatcher("form.jsp").forward(request, response);
			return;
		}
		
		//将请求参数保存到数据库中
		System.out.println(username+"--"+password+"--"+gender);
		
		//转发到成功页面
		//request.getRequestDispatcher("regist_success.jsp").forward(request, response);
		response.sendRedirect("regist_success.jsp");
	}

}
