package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.Utils.WEBUtils;
import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bs = new BookServiceImpl();
	
	protected void findBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("/pages/user/home.jsp").forward(request, response);

	}
	protected void findBookListByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String pageNoStr = request.getParameter("pageNo");
		String pageSizeStr = request.getParameter("pageSize");
		String minStr = request.getParameter("min");
		String maxStr = request.getParameter("max");
		
		//调用业务层
		Page<Book> page = bs.findBookListByPrice(pageNoStr, pageSizeStr, minStr, maxStr);
		
		//提取请求路径
		String path = WEBUtils.getPath(request);
		System.out.println(path);
		page.setPath(path);
		//设置进域
		request.setAttribute("page", page);
		
		//转发到book_manager.jsp
		request.getRequestDispatcher("/pages/user/home.jsp").forward(request, response);
		
	}

}
