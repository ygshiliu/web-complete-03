package com.atguigu.junit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.atguigu.bean.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 描述：测试GSon
 * 开发者：Miss Wang
 * 2017年4月27日 下午6:48:17
 */
public class GSonTest {
	
	@Test
	public void test02() {
		//创建一个list集合
		ArrayList<User> list = new ArrayList<User>();
		
		list.add(new User("Tom", 19, 10.0,true));
		list.add(new User("Jerry", 25, 20.0,false));
		list.add(new User("Gary", 30, 30.0,true));
		
		//将list转成字符串
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		
		//将字符串转成带泛弄的List对象
		List<User> list1 = gson.fromJson(json,new TypeToken<ArrayList<User>>(){}.getType());
		System.out.println("泛型list"+list1);
		
		
		List<Map<String,Object>> list2 = gson.fromJson(json, List.class);
		System.out.println("list"+list2);
		for (Object object : list2) {
			Map m = (Map) object;
			System.out.println(m.get("name"));
		}
	}
	
	@Test
	public void test01() {
		//Map 与 JSON字符串  互转
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Lucy");
		map.put("age", 23);
		map.put("address", "昌平");
		
		//将map 转成 JSON字符串
		Gson gson = new Gson();
		String json = gson.toJson(map);
		System.out.println(json);
		
		//将json字符串转成Map
		Map map1 = gson.fromJson(json, Map.class);
		System.out.println(map1);
	}

	@Test
	public void test() {
		//javaBean 与 Json字符串 互转
		
		User user = new User("haha", 16, 54.0,true);
		
		//创建gSON对象
		Gson gson = new Gson();
		//将对象转成json字符串
		String json = gson.toJson(user);
		System.out.println(json);
		
		//将json字符串转成java中对象
		User u = gson.fromJson(json, User.class);
		System.out.println(u);
		
		
	}

}