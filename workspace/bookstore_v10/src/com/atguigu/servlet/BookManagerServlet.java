package com.atguigu.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.atguigu.Utils.WEBUtils;
import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookManagerServlet
 */
public class BookManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bs = new BookServiceImpl();
	//添加图书请求
	protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取图书信息封装成book
		//Book book = WEBUtils.param2Bean(request, new Book());
		Book book = WEBUtils.getBook(request);
		
		//调用业务逻辑层保存图书
		bs.saveBook(book);
		
		//返回响应
		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=findBookList");
	}
	//查询图书列表 
	protected void bookList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取图书列表
		List<Book> list = bs.getBookAll();
		//将图书列表保存到域中
		request.setAttribute("bookList", list);
		//转发到pages/manager/book_manager.jsp
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	
	//删除图书请求
	protected void deleteBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取图书id
		String bookId = request.getParameter("bookId");
		//调用业务逻辑
		bs.deleteBook(bookId);
		
		//获取请求来源
		String referer = request.getHeader("referer");
		if(referer!=null){
			response.sendRedirect(referer);
		}else{
			//返回响应
			response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=findBookList");
		}
	}
	
	//修改图书
	protected void updateBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取图书信息
		//Book book = WEBUtils.param2Bean(request, new Book());
		
		Book book = WEBUtils.getBook(request);
		
		//调用业务层
		bs.updateBook(book);
		//获取请求来源
		String referer = request.getParameter("referer");
		if(referer!=null){
			response.sendRedirect(referer);
		}else{
			//响应图书列表
			response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=findBookList");
		}
	}
	//获取图书
	protected void toPageBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取图书id
		String bookId = request.getParameter("bookId");
		//调用业务层
		Book book = bs.getBookByBookId(bookId);
		//将图书设置到域中
		request.setAttribute("book", book);
		//响应编辑图书页面
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	
	//处理分页请求
	protected void findBookList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String pageNoStr = request.getParameter("pageNo");
		String pageSizeStr = request.getParameter("pageSize");
		
		//调用业务层
		Page<Book> page = bs.findBookList(pageNoStr, pageSizeStr);
		
		//提取请求路径
		String path = WEBUtils.getPath(request);
		page.setPath(path);
		//设置进域
		request.setAttribute("page", page);
		
		//转发到book_manager.jsp
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
}
