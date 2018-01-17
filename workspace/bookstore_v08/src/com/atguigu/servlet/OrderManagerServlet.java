package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

/**
 * 处理管理相关的订单请求
 * Servlet implementation class OrderManagerServlet
 */
public class OrderManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderService os = new OrderServiceImpl();
	
	protected void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取系统所有订单
		List<Order> orderList = os.getOrderList();
		//将订单设置进域中
		request.setAttribute("orderList", orderList);
		//转发到order_manager.jsp
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}
	
	protected void send(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取订单号
		String orderId = request.getParameter("orderId");
		//发货
		os.send(orderId);
		//回到之前页面
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
	}
	
	protected void info(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取订单号
		String orderId = request.getParameter("orderId");
		//获取订单详情
		List<OrderItem> list = os.info(orderId);
		//设置进域 
		request.setAttribute("orderItemList", list);
		//转发orderItem.jsp
		request.getRequestDispatcher("/pages/order/orderItem.jsp").forward(request, response);
	}
}
