package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;

/**
 * 描述：订单业务
 * 开发者：Miss Wang
 * 2017年4月24日 下午9:08:31
 */
public interface OrderService {
	
	/**
	 * 保存订单
	 * @param cart
	 * @param user
	 * @return
	 */
	String saveOrder(Cart cart , User user);
	
	/**
	 * 查看当前用户的所有订单
	 * @param userId
	 * @return
	 */
	List<Order> getOrderListByUserId(int userId);
	
	/**
	 * 查看所有订单，专提供给管理员使用
	 * @return
	 */
	List<Order> getOrderList();
	/**
	 * 修改指定订单状态，管理员进行发货处理
	 * 状态设置为1
	 * @param orderId
	 * @param state
	 */
	void send(String orderId);
	/**
	 * 修改指定订单状态，客户进行收货处理
	 * 状态设置为2
	 * @param orderId
	 */
	void take(String orderId);
	
	/**
	 * 查询指定订单详情
	 * @param orderId
	 * @return
	 */
	List<OrderItem> info(String orderId);
}
