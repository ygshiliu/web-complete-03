<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>index.jsp</h1>
		<!-- jsp本质是一个servlet,而servlet是一个java文件，所以在这里也可以写java代码  -->
		<%
			Date date = new Date();
			System.out.print(date);
		%>
		
		<!-- 将java对象显示在页面中 -->
		<%=date %>
		
</body>
</html>