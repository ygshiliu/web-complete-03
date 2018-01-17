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
	<h1>1.jsp</h1>

	是否是新创建的session对象：<%= session.isNew() %><br><br>
	<%
	//设置session有效时间，单位秒	
	//session.setMaxInactiveInterval(2); 
	//设置为0，session会立即失效
	//session.setMaxInactiveInterval(0);
	//设置为负数，代表永远有效
	//session.setMaxInactiveInterval(-10); 
	
	//立即失效
	//session.invalidate();
	
	%>
	获取session空闭时间：<%=session.getMaxInactiveInterval() %><br><br>
	<%=session.getAttribute("name") %>
	<%=session.getAttribute("age") %>
	<%=session.getAttribute("flag") %><br><br>
	
	
	
	
</body>
</html>