package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.City;
import com.atguigu.dao.CityDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CityDao cd = new CityDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数 
		String pId = request.getParameter("pId");
		//获取city列表
		List<City> list = cd.getCityByProId(pId);
		//设置响应类型
		response.setContentType("text/json;charset=utf-8");
		//返回json
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.getWriter().print(json);
	}


}
