package com.atguigu.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 描述：用于定义数据库连接操作的方法
 * 开发者：Miss Wang
 * 上午11:36:30
 */
public class JDBCUtils {
	
	private static DataSource ds = new ComboPooledDataSource("webDataSource");
	
	//private static Connection conn= null;
	//private static ConcurrentHashMap<Thread, Connection> map = new ConcurrentHashMap<Thread, Connection>();
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	public static Connection getConnection(){
		 Connection connection = threadLocal.get();
		 if(connection==null){
			 try {
				connection = ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 threadLocal.set(connection);
		 }
		 return connection;
	}
	/*public static Connection getConnection(){
		//从map中根据当前线程获取connection
		Connection connection = map.get(Thread.currentThread());
		if(connection==null){
			try {
				connection=ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put(Thread.currentThread(), connection);
		}
		return connection;
	}*/
	/*public static Connection getConnection(){
		if(conn==null){
			try {
				conn=ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}*/
	
	//获取连接
	/*public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}*/
	//释放连接
	/*public static void releaseConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	/*public static void releaseConnection(){
		Connection conn = map.get(Thread.currentThread());
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			map.remove(Thread.currentThread());
		}
	}*/
	
	public static void releaseConnection(){
		Connection connection = threadLocal.get();
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadLocal.remove();
		}
	}
}
