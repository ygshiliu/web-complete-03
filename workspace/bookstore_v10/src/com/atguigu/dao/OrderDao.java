package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Order;

/**
 * 描述：操作订单表
 * 开发者：Miss Wang
 * 2017年4月24日 下午7:29:32
 */
public interface OrderDao {
	/**
	 * 保存订单
	 * @param order
	 * @return
	 */
	int saveOrder(Order order);
	/**
	 * 修改订单状态
	 * @param orderId
	 * @param state
	 * @return
	 */
	int updateState(String orderId,int state);
	/**
	 * 查询所有订单
	 * 专提供给管理员使用
	 * @return
	 */
	List<Order> getOrderList();
	/**
	 * 查询当前用户的所有订单
	 * 专提供给用户使用
	 * @return
	 */
	List<Order> getOrderListByUserId(int userId);
}
