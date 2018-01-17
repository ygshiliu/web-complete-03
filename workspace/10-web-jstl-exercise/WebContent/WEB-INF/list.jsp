<%@page import="com.atguigu.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center">
<c:if test="${!empty list}">
	<h1>学生列表</h1>
	
	<table border="1px" align="center" cellpadding="10" cellspacing="0" width="60%" >
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>地址</td>
			<td colspan="2">操作</td>
		</tr>
		<c:forEach items="${list }" var="stu">
			<tr>
				<td>${stu.name }</td>
				<td>${stu.gender }</td>
				<td>${stu.address }</td>
				<td><a href="#">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>
		
		</c:forEach>		
	</table>	

</c:if>
	
			
	
</body>
</html>