package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

/**
 * 描述：处理图书的业务层
 * 开发者：Miss Wang
 * 2017年4月19日 上午10:43:09
 */
public interface BookService {
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
	 * 用来处分页业务的图书列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<Book> findBookList(String pageNo,String pageSize);
	/**
	 * 用来处理带查询条件的分页图书列表 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param minStr
	 * @param maxStr
	 * @return
	 */
	Page<Book> findBookListByPrice(String pageNoStr,String pageSizeStr,String minStr,String maxStr);
}
