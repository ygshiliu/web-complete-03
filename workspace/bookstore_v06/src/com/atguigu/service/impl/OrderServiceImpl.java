package com.atguigu.service.impl;

import java.util.Date;
import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.service.OrderService;

/**
 * 描述：orderService实现类
 * 开发者：Miss Wang
 * 2017年4月24日 下午9:09:53
 */
public class OrderServiceImpl implements OrderService{
	
	private OrderDao od = new OrderDaoImpl();
	private OrderItemDao oid = new OrderItemDaoImpl();
	private BookDao bd = new BookDaoImpl();

	@Override
	public String saveOrder(Cart cart, User user) {
		//生成订单号
		String id = System.currentTimeMillis()+""+user.getId();
		Order order = new Order(id, cart.getTotalCount(), cart.getTotalAmount(), new Date(), 0, user.getId());
		//保存订单
		od.saveOrder(order);
		
		List<CartItem> list = cart.getList();
		//定义二维数据，用来分别保存订单项与修改的图书相关的库存与销量
		Object[][] itemParams = new Object[list.size()][];
		Object[][] bookParams = new Object[list.size()][];
		
		for(int i=0;i<list.size();i++){
			//获取购物项
			CartItem item = list.get(i);
			
			//获取单品种数量与金额
			int count = item.getCount();
			double amount = item.getAmount();
			
			//分别获取图书信息
			Book book = item.getBook();
			Integer bookId = book.getId();
			String title = book.getTitle();
			String author = book.getAuthor();
			double price = book.getPrice();
			int sales = book.getSales();
			int stocks = book.getStocks();
			String imgPath = book.getImgPath();
			
			//保存订单项
			OrderItem orderItem = new OrderItem(null, title, author, price, sales, stocks, imgPath, count, amount, id);
			//insert into bs_order_items(title,author,price,sales,stocks,img_path,count,amount,order_id) "
			itemParams[i]=new Object[]{title,author,price,sales,stocks,imgPath,count,amount,id};
			
			
			//修改图书库存和销量
			//update bs_books set sales=?,stocks=? where id=?
			bookParams[i]=new Object[]{sales,stocks,bookId};
					
			}
		oid.batchSaveOrderItem(itemParams);
		bd.batchUpdateSaleAndStock(bookParams);
		
		//清空购物车
		cart.clear();
		
		return id;
		}
/*		//生成订单号
		String id = System.currentTimeMillis()+""+user.getId();
		Order order = new Order(id, cart.getTotalCount(), cart.getTotalAmount(), new Date(), 0, user.getId());
		//保存订单
		od.saveOrder(order);
		
		List<CartItem> list = cart.getList();
		
		
		for(int i=0;i<list.size();i++){
			//获取购物项
			CartItem item = list.get(i);
			
			//获取单品种数量与金额
			int count = item.getCount();
			double amount = item.getAmount();
			
			//分别获取图书信息
			Book book = item.getBook();
			Integer bookId = book.getId();
			String title = book.getTitle();
			String author = book.getAuthor();
			double price = book.getPrice();
			int sales = book.getSales();
			int stocks = book.getStocks();
			String imgPath = book.getImgPath();
			
			//保存订单项
			OrderItem orderItem = new OrderItem(null, title, author, price, sales, stocks, imgPath, count, amount, id);
			oid.saveOrderItem(orderItem);
			
			//修改图书库存和销量
			bd.updateSalesAndStocks(bookId, sales, stocks);
		}
		//清空购物车
		cart.clear();
		
		return id;
*/	
		

	@Override
	public List<Order> getOrderListByUserId(int userId) {
		List<Order> list = od.getOrderListByUserId(userId);
		return list;
	}

	@Override
	public List<Order> getOrderList() {
		List<Order> list = od.getOrderList();
		return list;
	}

	@Override
	public void send(String orderId) {
		od.updateState(orderId, 1);
	}

	@Override
	public void take(String orderId) {
		od.updateState(orderId, 2);
	}

	@Override
	public List<OrderItem> info(String orderId) {
		List<OrderItem> list = oid.getOrderItemByOrderId(orderId);
		return list;
	}

}
