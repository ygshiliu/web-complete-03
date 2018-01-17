package com.atguigu.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.Utils.JDBCUtils;

/**
 * Servlet Filter implementation class TransactionFilter
 */
public class TransactionFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Connection conn = JDBCUtils.getConnection();       
		try{                          
			//取消事务自动提交行为              
			conn.setAutoCommit(false);
			                          
			//操作数据库                   
			 chain.doFilter(request, response);
			 
			//没有异常，手动提交事务             
			conn.commit();            
		}catch(Exception e){          
			//出现异常，回滚事务        
			//e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
			
			request.setAttribute("msg", "系统出现问题，请联系管理员...");
			request.getRequestDispatcher("/pages/error/error.jsp").forward(request, response);
		}finally{                     
			//关闭连接                    
			JDBCUtils.releaseConnection();          
		} 
		
	}
	
}
