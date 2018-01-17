package com.atguigu.test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/**
 * 描述：
 * 开发者：Miss Wang
 * 下午9:00:26
 */
public class TestBean {
	
	@Test
	public void test02() throws Exception {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "haha");
		map.put("age", "20");
		map.put("flag", "true");
		
		Student stu = new Student();
		
		BeanUtils.populate(stu, map);
		
		System.out.println(stu);
	}
	
	@Test
	public void test01() throws Exception {
		//创建对象
		Student student = new Student();
		//第一参数是用来封装的对象
		//第二参数是封装对象的属性名
		//第三参数是一个Object类型，是属性值 
		BeanUtils.setProperty(student, "name1", "刘在石");
		
		//通过此方法可以实现类型的自动转换，可以实现 String 自动转成基本数据类型
		BeanUtils.setProperty(student, "age", "19");
		BeanUtils.setProperty(student, "flag", "true");
		
		System.out.println(student);
	}

}
