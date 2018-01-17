package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 描述：封装单品种图书的信息
 * 开发者：Miss Wang
 * 2017年4月24日 上午11:17:58
 */
public class CartItem implements Serializable{
	//图书
	private Book book;
	//单品种图书数量
	private int count;
	//单品种图书金额
	private double amount;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 *  单品图书价格 * 数量 = 单品图书金额
	 *  
	 * @return
	 */
	public double getAmount() {
		
		BigDecimal amount = new BigDecimal(getBook().getPrice()+"");
		BigDecimal count = new BigDecimal(getCount()+"");
		BigDecimal mul = amount.multiply(count);
		
		/*double amount = 0;
		amount = getBook().getPrice() * getCount();*/
		return mul.doubleValue();
	}

	
	
}
