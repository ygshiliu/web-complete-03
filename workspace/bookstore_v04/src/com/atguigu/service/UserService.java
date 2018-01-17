package com.atguigu.service;

import com.atguigu.bean.User;

/**
 * 描述：处理用户的业务操作
 * 开发者：Miss Wang
 * 下午2:31:39
 */
public interface UserService {
	/**
	 * 注册用户信息
	 * @param user
	 * @return
	 */
	boolean regist(User user);
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	User login(User user);
}
