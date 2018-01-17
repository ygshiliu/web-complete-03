package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;

/**
 * 描述：userservice实现类
 * 开发者：Miss Wang
 * 下午2:34:05
 */
public class UserServiceImpl implements UserService {
	
	private UserDao ud = new UserDaoImpl();

	@Override
	public boolean regist(User user) {
		int count = ud.save(user);
		return count>0;
	}

	@Override
	public User login(User user) {
		User user2 = ud.getUserByUsernameAndPassword(user);
		return user2;
	}

}
