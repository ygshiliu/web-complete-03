package com.atguigu.service.impl;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.service.BookService;

/**
 * 描述：BookService实现类
 * 开发者：Miss Wang
 * 2017年4月19日 上午10:44:14
 */
public class BookServiceImpl implements BookService {
	
	private BookDao bd = new BookDaoImpl();
	
	@Override
	public int saveBook(Book book) {
		return bd.saveBook(book);
	}

	@Override
	public int updateBook(Book book) {
		return bd.updateBook(book);
	}

	@Override
	public int deleteBook(String bookId) {
		return bd.deleteBook(bookId);
	}

	@Override
	public Book getBookByBookId(String bookId) {
		return bd.getBookByBookId(bookId);
	}

	@Override
	public List<Book> getBookAll() {
		return bd.getBookAll();
	}

	@Override
	public Page<Book> findBookList(String pageNostr, String pageSizestr) {
		//对pageNo、pageSize进行类型转换
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNostr);
		} catch (Exception e) {}
		
		int pageSize = 4;
		try {
			pageSize = Integer.parseInt(pageSizestr);
		} catch (Exception e) {}
		
		Page<Book> page = new Page<Book>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		page = bd.findBookList(page);
		
		return page;
	}

	@Override
	public Page<Book> findBookListByPrice(String pageNoStr, String pageSizeStr,
			String minStr, String maxStr) {
		//对pageNo、pageSize进行类型转换
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (Exception e) {}
		
		int pageSize = 4;
		try {
			pageSize = Integer.parseInt(pageSizeStr);
		} catch (Exception e) {}
		
		int min = 0;
		int max = Integer.MAX_VALUE;
		//对前台提交的查询价格进行类型转换
		try{
			min = Integer.parseInt(minStr);
		}catch(Exception e){}
		
		try{
			max = Integer.parseInt(maxStr);
		}catch(Exception e){}
		
		//封装成page
		Page<Book> page = new Page<Book>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		page = bd.findBookListByPricre(page, min, max);
		
		return page;
	}
	
}
