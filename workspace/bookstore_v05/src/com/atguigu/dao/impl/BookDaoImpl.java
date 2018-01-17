package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;

/**
 * 描述：BookDao实现类 开发者：Miss Wang 2017年4月19日 上午10:03:22
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public int saveBook(Book book) {
		String sql = "insert into bs_books(title,author,price,sales,stocks,img_path) "
				+ "values(?,?,?,?,?,?)";
		return update(sql, book.getTitle(), book.getAuthor(), book.getPrice(),
				book.getSales(), book.getStocks(), book.getImgPath());
	}

	@Override
	public int updateBook(Book book) {
		String sql = "update bs_books set title=?,author=?,price=?,sales=?,stocks=?,img_path=? where id=?";
		return update(sql, book.getTitle(), book.getAuthor(), book.getPrice(),
				book.getSales(), book.getStocks(), book.getImgPath(),book.getId());
	}

	@Override
	public int deleteBook(String bookId) {
		String sql = "delete from bs_books where id=?";
		return update(sql, bookId);
	}

	@Override
	public Book getBookByBookId(String bookId) {
		String sql = "select id,title,author,price,sales,stocks,img_path imgPath from bs_books where id=?";
		return getBean(sql, bookId);
	}

	@Override
	public List<Book> getBookAll() {
		String sql = "select id,title,author,price,sales,stocks,img_path imgPath from bs_books";
		return getAll(sql);
	}

	@Override
	public Page<Book> findBookList(Page<Book> page) {
		//查询图书记录总数
		String sql = "select count(id) from bs_books ";
		long totalRecord = (long) getSingle(sql);
		page.setTotalRecord((int)totalRecord);
		
		//查询图书信息
		sql = "select id,title,author,price,sales,stocks,img_path imgPath from bs_books order by id desc limit ?,? ";
		List<Book> list = getAll(sql, page.getIndex(),page.getPageSize());
		page.setList(list);
		
		return page;
	}

	@Override
	public Page<Book> findBookListByPricre(Page<Book> page, int min, int max) {
		//查询图书记录总数
		String sql = "select count(id) from bs_books where price>? and price<?";
		long totalRecord = (long) getSingle(sql,min,max);
		page.setTotalRecord((int)totalRecord);
		
		//查询图书信息
		sql = "select id,title,author,price,sales,stocks,img_path imgPath from bs_books where price>? and price<? order by id desc limit ?,? ";
		List<Book> list = getAll(sql,min,max, page.getIndex(),page.getPageSize());
		page.setList(list);
		
		return page;
	}

}
