package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.Order;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;

/**
 * 描述：OrderDao实现类
 * 开发者：Miss Wang
 * 2017年4月24日 下午7:34:20
 */
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public int saveOrder(Order order) {
		String sql = "!insert into bs_orders(id,total_count,total_amount,state,create_date,user_id) "
				+ " values (?,?,?,?,?,?)";
		return update(sql, order.getId(),order.getTotalCount(),order.getTotalAmount(),order.getState(),order.getCreateDate(),order.getUserId());
	}

	@Override
	public int updateState(String orderId, int state) {
		String sql = "update bs_orders set state=? where id=?";
		return update(sql, state,orderId);
	}

	@Override
	public List<Order> getOrderList() {
		String sql="select id,total_count totalCount,total_amount totalAmount,state,create_date createDate,user_id userId "
				+ " from bs_orders";
		return getAll(sql);
	}

	@Override
	public List<Order> getOrderListByUserId(int userId) {
		String sql="select id,total_count totalCount,total_amount totalAmount,state,create_date createDate,user_id userId "
				+ " from bs_orders where user_id=?";
		return getAll(sql,userId);
	}

}
