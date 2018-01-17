package com.atguigu.Utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.User;
import com.atguigu.service.impl.BookServiceImpl;

/**
 * 描述：
 * 开发者：Miss Wang
 * 下午9:54:45
 */
public class WEBUtils {
	
	//封装请求参数
	public static <T>T param2Bean(HttpServletRequest request, T t) {
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public static String getPath(HttpServletRequest request) {
		//获取请求路径
		String url = request.getRequestURI();
		//获取请求参数字符串
		//getQueryString()只对发送的get请求有用
		String queryString = request.getQueryString();
		//对请求参数进行过滤
		if(queryString.contains("&pageNo")){
			queryString=queryString.substring(0, queryString.indexOf("&pageNo"));
		}
		return url+"?"+queryString;
	}

	public static Cart getCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart==null){
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		return cart;
	}

	public static User getUser(HttpServletRequest request,HttpServletResponse response) {
		//检查用户是否登录
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null){
			//用户没有登录，重定向到login.jsp页面
			try {
				response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
			} catch (IOException e) {}
			return null;
		}
		return user;
	}

	public static Book getBook(HttpServletRequest request) {
				
		//通过fileupload解析输入流
		//创建工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		//预定义一个Book
		Book book = new Book();
		//解析httpServletRequest
		try {
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				//是否为表单项
				boolean flag = item.isFormField();
				if(flag){
					//获取普通表单项name属性值 与value属性值 
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					//通过反射封装book
					BeanUtils.setProperty(book, name, value);
				}else{
					//处理文件表单项
					
					//获取普通表单项name属性值 与value属性值 
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					
					//获取文件大小
					long size = item.getSize();
					
					if(size==0){
						if(book.getId()==null){
							//通过反射封装book
							BeanUtils.setProperty(book, name, "static/img/default.jpg");
						}else{
							Book oldBook = new BookServiceImpl().getBookByBookId(book.getId()+"");
							String imgPath = oldBook.getImgPath();
							BeanUtils.setProperty(book, name, imgPath);
						}
					}else{
						//保存/upload目录下
						ServletContext context = request.getSession().getServletContext();
						//获取物理路径
						String path = context.getRealPath("/upload");
						
						File file = new File(path);
						if(!file.exists()){
							file.mkdirs();
						}
						
						//获取原文件名
						String name2 = item.getName();
						if(name2.contains("/")){
							name2=name2.substring(name2.lastIndexOf("/")+1);
						}
						//确保唯一
						name2=System.currentTimeMillis()+"_"+name2;
						
						//将item保存到服务器
						File file2 = new File(path+"/"+name2);
						item.write(file2);
						
						//通过反射封装book
						BeanUtils.setProperty(book, name, "upload/"+name2);
						
					}
					
					
				}
				
			}
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
	}

}
