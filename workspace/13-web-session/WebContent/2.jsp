<%@page import="com.atguigu.bean.Address"%>
<%@page import="com.atguigu.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		//向session中保存属性
		session.setAttribute("name", "haha");
		session.setAttribute("age", 13);
		session.setAttribute("flag", true);
		
		//创建user对象
		User user = new User("Tom",13,false);
		Address addr = new Address("北京","北京","昌平");
		user.setAddr(addr);
		//保存到session中
		session.setAttribute("user", user);
		
	%>

</body>
</html>