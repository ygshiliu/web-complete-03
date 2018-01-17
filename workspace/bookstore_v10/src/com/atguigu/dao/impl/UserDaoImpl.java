package com.atguigu.dao.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;

/**
 * 描述：UserDao实现类
 * 开发者：Miss Wang
 * 下午2:04:19
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public int save(User user) {
		String sql ="insert into bs_users(username,password,email) values(?,?,?)";
		return update(sql, user.getUsername(),user.getPassword(),user.getEmail());
	}

	@Override
	public User getUserByUsernameAndPassword(User user) {
		String sql = "select id,username,password,email from bs_users where username=? and password=?";
		return getBean(sql, user.getUsername(),user.getPassword());
	}

	@Override
	public User getUserByUsername(String username) {
		String sql = "select id,username,password,email from bs_users where username=?";
		return getBean(sql, username);
	}
	
}
