package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.Utils.WEBUtils;
import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

/**
 * 封装用户相关的信息
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService us = new UserServiceImpl();
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户提交的验证码
		String code = request.getParameter("code");
		//获取session中的验证码code
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute("code");
		//移除session中的验证码
		session.removeAttribute("code");
		//进行验证码对比 
		if(code.equals(sessionCode)){
			//正常提交表单
			User user = WEBUtils.param2Bean(request,new User());
			
			//调用业务逻辑层进行处理
			boolean flag = us.regist(user);
			
			//根据结果返回页面
			if(flag){
				//注册成功，重定向到regist_success.html
				response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
			}else{
				request.setAttribute("msg", "此用户已经存在，请重新注册");
				//注册失败，用户名已经存在,转发到regist.html
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
				
			}
			
		}else{
			request.setAttribute("msg", "请不要重复提交表单信息");
			//转发到regist.html
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

		}
		
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//组织请求参数
		User user = new User(null, username, password, null);*/
		
		User user = WEBUtils.param2Bean(request,new User());
		
		//调用业务层处理
		User loginuser = us.login(user);
		
		//根据结果返回页面
		if(loginuser == null){
			//说明用户名或密码不正确，需要重新登录，转发到登录页面
			//设置错误信息提示用户
			request.setAttribute("msg", "您输入的用户名或密码不正确，请重新输入");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			
		}else{
			//将用户信息放入session域
			HttpSession session = request.getSession();
			session.setAttribute("user", loginuser);
			//登录成功,重定向到login_success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}

	protected void logout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取session
		HttpSession session = request.getSession();
		//使session失效
		session.invalidate();
		//重定向到index.jsp
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
