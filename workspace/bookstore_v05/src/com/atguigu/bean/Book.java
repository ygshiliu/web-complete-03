package com.atguigu.bean;
/**
 * 描述：封装图书相关的信息
 * 开发者：Miss Wang
 * 上午9:48:26
 */
public class Book {
	private Integer id;
	/**
	 * 书名
	 */
	private String title;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 价格
	 */
	private double price;
	/**
	 * 销量
	 */
	private int sales;
	/**
	 * 库存
	 */
	private int stocks;
	/**
	 * 封面
	 */
	private String imgPath = "static/img/default.jpg";
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
	public Book(Integer id, String title, String author, double price,
			int sales, int stocks) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stocks = stocks;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author
				+ ", price=" + price + ", sales=" + sales + ", stocks="
				+ stocks + ", imgPath=" + imgPath + "]";
	}
	
	
}
