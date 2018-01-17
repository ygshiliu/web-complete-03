package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

/**
 * 描述：与图书表相关的操作
 * 开发者：Miss Wang
 * 2017年4月19日 上午9:59:04
 */
public interface BookDao {
	/**
	 * 保存图书
	 * @param book
	 * @return
	 */
	int saveBook(Book book);
	/**
	 * 修改图书
	 * @param book
	 * @return
	 */
	int updateBook(Book book);
	/**
	 * 根据图书id删除一本图书
	 * @param bookId
	 * @return
	 */
	int deleteBook(String bookId);
	/**
	 * 根据图书id查找一本图书
	 * @param bookId
	 * @return
	 */
	Book getBookByBookId(String bookId);
	/**
	 * 查找所有图书列表
	 * @return
	 */
	List<Book> getBookAll();
	
	/**
	 * 与分页查询相关的图书信息
	 * @param page
	 * @return
	 */
	Page<Book> findBookList(Page<Book> page);
	/**
	 * 与分页查询相关的图书信息
	 * @param page
	 * @return
	 */
	Page<Book> findBookListByPricre(Page<Book> page,int min,int max);
}
