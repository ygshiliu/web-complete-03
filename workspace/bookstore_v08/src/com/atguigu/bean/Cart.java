package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：购物车，用来封装购买的图书信息
 * 开发者：Miss Wang
 * 2017年4月24日 上午11:22:36
 */
public class Cart implements Serializable{
	
	//用来保存单品种图书的列表
	private Map<String,CartItem> map = new HashMap<String,CartItem>();
	//购物车总数量 
	//int totalCount;
	//购物车总金额
	//double totalAmount;
	
	
	/**
	 * 计算得出
	 * @return
	 */
	public int getTotalCount() {
		int totalCount = 0;
		for (CartItem cartItem : getList()) {
			totalCount += cartItem.getCount();
		}		
		return totalCount;
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	/**
	 * 通过计算得出来的数据，不需要单独定义字段
	 * @return
	 */
	public double getTotalAmount() {
		
		BigDecimal totalAmount = new BigDecimal("0");
		for (CartItem item : getList()) {
			BigDecimal itemAmount = new BigDecimal(item.getAmount()+"");
			totalAmount = totalAmount.add(itemAmount) ;
		}
		
		return totalAmount.doubleValue();
		
		/*double totalaAmount = 0;
		for (CartItem item : getList()) {
			totalaAmount += item.getAmount();
		}
		return totalaAmount;*/
	}
	//获取cartItem列表 
	public List<CartItem> getList(){
		return new ArrayList<CartItem>(map.values());
	}
	//根据图书Id删除图书
	public void deleteBook(String bookId){
		map.remove(bookId);
	}
	//清空购物车
	public void clear(){
		map.clear();
	}
	//添加图书到购物车
	public void addBook2Cart(Book book){
		//获取购物车中的图书
		CartItem item = map.get(book.getId()+"");
		if(item==null){
			//说明购物车中没有此图书
			CartItem cartItem = new CartItem();
			cartItem.setBook(book);
			cartItem.setCount(1);
			
			map.put(book.getId()+"", cartItem);
		}else{
			//购物车中已经有此图书，更改数量就可以了
			int count = item.getCount();
			item.setCount(++count);
		}
		
	}
	//修改图书的购物项数量
	public void updateCount(String bookId,int count){
		CartItem cartItem = map.get(bookId);
		cartItem.setCount(count);
	}
}
