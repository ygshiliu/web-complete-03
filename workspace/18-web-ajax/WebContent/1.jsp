<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//js对象
	var obj = {
			name:"haha",
			age:13
	};
	
	//创建json对象与js对象很类
	//区别：Json对象的键必须加双引号
	var obj1={
			"name":"Tom",
			"age":15
	};
	
	
	/*
	<stu>
		<name>Tom</name>
		<age>15</age>
	</stu>
	
	var name = document.getElementsByTagName("name")[0].firstChild.nodeValue;
	
	Json与XML对比：
			   	 优点 				缺点
	Json	易传输，易解析			不方便读取
	XML		传输差，解析差			易读
	
	*/
	
	//alert(obj1.name+"--"+obj1.age);
	
	//Json 转  字符串
	var stustr = JSON.stringify(obj1);
	//将字符串转成JSON
	var obj2 = JSON.parse(stustr);
	
	alert(obj2.age);
</script>
</head>
<body>

</body>
</html>