package com.junit;

import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/**
 * 描述：
 * 开发者：Miss Wang
 * 2017年5月2日 下午8:47:06
 */
public class ResourceBundleTest {
	
	@Test
	public void test01(){
		//Locale locale = new Locale("en");
//		Locale locale = new Locale("en","US");
		Locale locale = Locale.ITALIAN;
		System.out.println(locale.toString());
	}

	@Test
	public void test() {
		//使用默认的语言环境加载资源文件
		//ResourceBundle bundle = ResourceBundle.getBundle("i18n");
		//根据指定的locale加载资源文件，如果找不到指定的资源文件，则使用默认的资源文件
		Locale locale = new Locale("en","US");
		ResourceBundle bundle = ResourceBundle.getBundle("i18n",locale);
		
		//获取默认语言环境
		Locale locale1 = bundle.getLocale();
		System.out.println(locale1.toString());
		
		//获取资源中的信息
		String login = bundle.getString("login");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		System.out.println(login+"--"+username+"--"+password);
	}

}
