<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	
<%-- 	${pageContext}<br>
	${pageScope}<br>
	${requestScope}<br>
	${sessionScope}<br>
	${applicationScope}<br>
	请求参数 ： ${param}<br>
	多个请求参数 ： ${paramValues}<br>
	请求头：${header.referer}<br>
	获取多个请求头：${headerValues }<br>
	获取web应用的初始化参数：${initParam }<br>
	获取cookie信息：${cookie } --%>
	
	<%
	List list = new ArrayList();
	list.add("刘在石");
	list.add("宋智孝");
	list.add("狗哥");
	request.setAttribute("list", list);
	%>
	
	<!-- EL运算符 -->
	加运算 ： ${5+8 }<br>
	减运算 ： ${5-8 }<br>
	比较运算 ： ${5>8 }<br>
	比较运算 ： ${5 lt 8 }<br>
	逻辑运算 ： ${5 lt 8 && false}<br>
	empty运算：${empty "f" }<br>
	判断list是否为空：${!empty list }
	
</body>
</html>