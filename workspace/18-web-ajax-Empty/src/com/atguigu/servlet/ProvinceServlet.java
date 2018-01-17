package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Province;
import com.atguigu.dao.ProvinceDao;
import com.google.gson.Gson;

/**
 * 处理省份请求
 * Servlet implementation class ProvinceServlet1
 */
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProvinceDao pd = new ProvinceDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取省份
		List<Province> list = pd.getProvinceList();
		
		//转成json字符串
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		//设置响应头
		response.setContentType("text/json;charset=utf-8");
		//返回响应
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
