package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderItemDao;

/**
 * 描述：OrderItemDao实现类 开发者：Miss Wang 2017年4月24日 下午7:55:43
 */
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements
		OrderItemDao {

	@Override
	public List<OrderItem> getOrderItemByOrderId(String orderId) {
		String sql = "select id,title,author,price,sales,stocks,img_path imgPath,count,amount,order_id orderId "
				+ " from bs_order_items where order_id=?";
		return getAll(sql, orderId);
	}

	@Override
	public int saveOrderItem(OrderItem item) {
		String sql = "insert into bs_order_items(title,author,price,sales,stocks,img_path,count,amount,order_id) "
				+ " values(?,?,?,?,?,?,?,?,?) ";
		return update(sql, item.getTitle(), item.getAuthor(), item.getPrice(),
				item.getSales(), item.getStocks(), item.getImgPath(),
				item.getCount(), item.getAmount(), item.getOrderId());
	}

	@Override
	public void batchSaveOrderItem(Object[][] params) {
		String sql = "insert into bs_order_items(title,author,price,sales,stocks,img_path,count,amount,order_id) "
				+ " values(?,?,?,?,?,?,?,?,?) ";
		batch(sql, params);
	}

}
