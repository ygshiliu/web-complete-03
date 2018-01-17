package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.OrderItem;

/**
 * 描述：与订单项相关的操作
 * 开发者：Miss Wang
 * 2017年4月24日 下午7:53:41
 */
public interface OrderItemDao {
	
	/**
	 * 保存订单项
	 * @param item
	 * @return
	 */
	int saveOrderItem(OrderItem item);
	/**
	 * 查询当前订单的所有订单项
	 * @param orderId
	 * @return
	 */
	List<OrderItem> getOrderItemByOrderId(String orderId);
	
	/**
	 * 批量保存订单详情
	 * @param params
	 */
	void batchSaveOrderItem(Object[][] params);
	
}
