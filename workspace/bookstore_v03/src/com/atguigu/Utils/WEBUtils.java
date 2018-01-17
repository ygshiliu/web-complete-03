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

}
