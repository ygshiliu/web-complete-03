package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.Utils.WEBUtils;
import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bs = new BookServiceImpl();

	protected void addBook2Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取bookId
		String bookId = request.getParameter("bookId");
		//获取book
		Book book = bs.getBookByBookId(bookId);
		//添加到购物车
		HttpSession session = request.getSession();
		Cart cart = WEBUtils.getCart(request);
		cart.addBook2Cart(book);
		session.setAttribute("title", book.getTitle());
		//从哪来的回哪去
		String referer = request.getHeader("referer");
		if(referer==null){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			response.sendRedirect(referer);
		}
		
	}

	protected void deleteCartItem(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取bookId
		String bookId = request.getParameter("bookId");
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		//删除购物项
		cart.deleteBook(bookId);
		//重定向到cart.jsp
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}
	
	protected void clear(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		//清空购物车
		cart.clear();
		//重定向到cart.jsp
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}
	
	protected void updateCount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取bookId
		String bookId = request.getParameter("bookId");
		String count = request.getParameter("count");
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		cart.updateCount(bookId, Integer.parseInt(count));
		
		//重定向到cart.jsp
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
		
	}
}
