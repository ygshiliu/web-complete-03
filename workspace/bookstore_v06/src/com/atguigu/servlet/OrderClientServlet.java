package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.Utils.WEBUtils;
import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

/**
 * 处理订单请求
 * Servlet implementation class OrderServlet
 */
public class OrderClientServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	
	private OrderService os = new OrderServiceImpl();
	
	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = WEBUtils.getUser(request,response);
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		//生成订单
		String orderId = os.saveOrder(cart, user);
		//转发到checkout.jsp
		request.setAttribute("orderId", orderId);
		request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);;
		
	}

	protected void orderList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取当前用户
		User user = WEBUtils.getUser(request, response);
		//查找当前用户所有订单
		List<Order> list = os.getOrderListByUserId(user.getId());
		//设置进域中
		request.setAttribute("orderList", list);
		//转发到order.jsp
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	
	protected void take(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取订单号
		String orderId = request.getParameter("orderId");
		//收货
		os.take(orderId);
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
		//转发到orderItem.jsp
		request.getRequestDispatcher("/pages/order/orderItem.jsp").forward(request, response);
		
	}
}
