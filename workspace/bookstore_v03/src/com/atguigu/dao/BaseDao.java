package com.atguigu.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.atguigu.Utils.JDBCUtils;

/**
 * 描述：专门用来被其它Dao继承的。主要用来操作数据库表的增删改查操作
 * 开发者：Miss Wang
 * 上午11:49:27
 */
public class BaseDao<T> {
	private QueryRunner qr = new QueryRunner();
	private Class<T> type;
	
	public BaseDao() {
		//获取实例的泛型父类
		 Type superclass = this.getClass().getGenericSuperclass();
		 //转换类型为ParameterizedType
		 ParameterizedType pt = (ParameterizedType)superclass;
		 //获取真正的参数类型
		 Type[] actualTypeArguments = pt.getActualTypeArguments();
		 //获取目标Class<T>
		 type = (Class<T>) actualTypeArguments[0];
	}
	
	//用于数据库表的增删改
	public int update(String sql, Object ... param ){
		int count = 0;
		Connection conn = JDBCUtils.getConnection();
		try {
			count = qr.update(conn, sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(conn);
		}
		return count;
	}
	//获取单个实例
	public T getBean(String sql,Object ... param){
		T t = null;
		Connection conn = JDBCUtils.getConnection();
		try {
			t = qr.query(conn, sql, new BeanHandler<T>(type), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(conn);
		}
		return t;
	}
	
	//获取所有对象实例
	public List<T> getAll(String sql,Object ... param){
		List<T> list = null;
		Connection conn = JDBCUtils.getConnection();
		try {
			list = qr.query(conn, sql, new BeanListHandler<T>(type), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.releaseConnection(conn);
		}
		return list;
	}
}
