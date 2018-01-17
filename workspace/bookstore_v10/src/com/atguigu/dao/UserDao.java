package com.atguigu.dao;

import com.atguigu.bean.User;

/**
 * 描述：用来操作users表
 * 开发者：Miss Wang
 * 下午1:59:15
 */
public interface UserDao {
	
	/**
	 * 向bs_users表中插入一条用户信息
	 * @param user
	 * @return
	 */
	int save(User user);
	/**
	 * 根据用户名和密码查找bs_users表中的用户信息
	 * @param user
	 * @return
	 */
	User getUserByUsernameAndPassword(User user);
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
}
