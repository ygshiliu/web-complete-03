package com.atguigu.Utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.bean.User;

/**
 * 描述：
 * 开发者：Miss Wang
 * 下午9:54:45
 */
public class WEBUtils {
	
	//封装请求参数
	public static <T>T param2Bean(HttpServletRequest request, T t) {
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public static String getPath(HttpServletRequest request) {
		//获取请求路径
		String url = request.getRequestURI();
		//获取请求参数字符串
		//getQueryString()只对发送的get请求有用
		String queryString = request.getQueryString();
		//对请求参数进行过滤
		if(queryString.contains("&pageNo")){
			queryString=queryString.substring(0, queryString.indexOf("&pageNo"));
		}
		return url+"?"+queryString;
	}

}
