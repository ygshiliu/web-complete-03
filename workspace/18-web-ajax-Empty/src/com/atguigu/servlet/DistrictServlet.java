package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.District;
import com.atguigu.dao.DistrictDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class DistrictServlet
 */
public class DistrictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DistrictDao dd = new DistrictDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String cid = request.getParameter("cid");
		//调用业务逻辑层
		List<District> list = dd.getListByCityId(cid);
		//设置响应类型
		response.setContentType("text/json;charset=utf-8");
		//返回响应
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.getWriter().print(json);
		
	}


}
