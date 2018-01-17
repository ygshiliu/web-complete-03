package com.atguigu.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

/**
 * 描述：
 * 开发者：Miss Wang
 * 2017年4月27日 上午11:45:36
 */
public class MySessionAttrListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("向session中添加属性");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("从session中移除属性");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("替换session中属性");
		String name = se.getName();
		Object value = se.getValue();
		
		System.out.println(name+"--"+value);
	}
	

}
