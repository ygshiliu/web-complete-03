package com.atguigu.dom;

import static org.junit.Assert.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.atguigu.bean.Student;

public class DomTest {

	@Test
	public void testAll() throws Exception {
		
		//创建解析器
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//通过解析器解析xml文档
		Document document = builder.parse("students.xml");
		
		//获取student标签
		//xml是自定义标签，像id="01"有实际的意义吗？没有
		//在xml解析中不能通过getElementById()方法来解析标签
		//Element student = document.getElementById("01");
		NodeList list = document.getElementsByTagName("student");
		
		//遍历
		for(int i=0;i<list.getLength();i++){
			//获取指定的元素
			Element ele = (Element) list.item(i);
			//获取id属性值 
			String id = ele.getAttribute("id");
			
			//获取ele元素下的name元素
			Element nameEle = (Element) ele.getElementsByTagName("name").item(0);
			String name = nameEle.getTextContent();
			
			//获取age
			String age = ele.getElementsByTagName("age").item(0).getTextContent();
			
			//获取sex
			String sex = ele.getElementsByTagName("sex").item(0).getTextContent();
			
			//获取注释
			String desc = ele.getElementsByTagName("desc").item(0).getTextContent();
			
			//最终将xml文档中的数据提取出来，封装成我们熟悉的java类对象
			Student student = new Student(name, Integer.parseInt(age), sex, desc);
			System.out.println(student);
			
		}
		
		
	}

}
