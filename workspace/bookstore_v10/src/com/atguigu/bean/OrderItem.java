package com.atguigu.bean;
/**
 * 描述：封装订单项信息
 * 开发者：Miss Wang
 * 2017年4月24日 下午6:10:19
 */
public class OrderItem {
	private Integer id;
	private String title;
	private String author;
	private double price;
	private int sales;
	private int stocks;
	private String imgPath;
	//单订单项数量
	private int count;
	//单订单项金额
	private double amount;
	//隶属订单
	private String orderId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getStocks() {
		return stocks;
	}
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public OrderItem(Integer id, String title, String author, double price,
			int sales, int stocks, String imgPath, int count, double amount,
			String orderId) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stocks = stocks;
		this.imgPath = imgPath;
		this.count = count;
		this.amount = amount;
		this.orderId = orderId;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", title=" + title + ", author="
				+ author + ", price=" + price + ", sales=" + sales
				+ ", stocks=" + stocks + ", imgPath=" + imgPath + ", count="
				+ count + ", amount=" + amount + ", orderId=" + orderId + "]";
	}
	
	
}
