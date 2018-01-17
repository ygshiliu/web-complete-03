package com.atguigu.Utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 描述：用于定义数据库连接操作的方法
 * 开发者：Miss Wang
 * 上午11:36:30
 */
public class JDBCUtils {
	
	private static DataSource ds = new ComboPooledDataSource("webDataSource");
	
	//获取连接
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//释放连接
	public static void releaseConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
