package com.atguigu.dom;

import static org.junit.Assert.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.atguigu.bean.Student;

public class XpathTest {

	@Test
	public void testAll() throws Exception {
		//第一步：导入jar包：jaxen-1.1-beta-6.jar
		//第二步：创建解析器
		SAXReader reader = new SAXReader();
		//第三步：通过解析器加载xml文档
		Document document = reader.read("students.xml");
		
		//通过xpath表达式获取元素：/students/student[@id="01"]
		//通过xpath表达式获取单个元素
		Element ele = (Element) document.selectSingleNode("/students/student[@id='01']");
		//获取name/age/sex/desc
		String name = ele.elementText("name");
		String age = ele.elementText("age");
		String sex = ele.elementText("sex");
		String desc = ele.elementText("desc");
		
		Student student = new Student(name, Integer.parseInt(age), sex, desc);
    	System.out.println(student);
		
		
	}

}
