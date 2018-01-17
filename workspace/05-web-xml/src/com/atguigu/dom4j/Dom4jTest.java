package com.atguigu.dom4j;

import static org.junit.Assert.*;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.atguigu.bean.Student;

public class Dom4jTest {

	@Test
	public void testAll() throws Exception {
		SAXReader reader = new SAXReader();
        Document document = reader.read("students.xml");
        
        //dom4j的一切操作是基于根元素
        Element ele = document.getRootElement();
        //获取根元素的标签名
        String qName = ele.getQualifiedName();
       // System.out.println(qName);
        
        List<Element> list = ele.elements();
        for (Element element : list) {
        	//获取id属性
        	String id = element.attributeValue("id");
        	
        	//获取name标签
        	Element nameEle = element.element("name");
        	//获取name标签中的文本
        	String name = nameEle.getText();
        	
        	//age\sex\desc
        	String age = element.elementText("age");
        	String sex = element.elementText("sex");
        	String desc = element.elementText("desc");
        	
        	//将数据封装成student对象
        	Student student = new Student(name, Integer.parseInt(age), sex, desc);
        	System.out.println(student);
			
		}
	}

}
