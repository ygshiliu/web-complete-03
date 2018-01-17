<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%
		Locale locale = request.getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("i18n",locale);
	
	%>
	<h1><%=bundle.getString("login") %></h1>
	
	<form action="">
	<%=bundle.getString("username") %>：<input type="text" name="username"><br><br>
	<%=bundle.getString("password") %>： <input type="password" name="password"><br><br>
	<input type="submit" value="<%=bundle.getString("login")%>">
	</form> --%>

	<fmt:setLocale value="${param.locale }"/>
	<fmt:setBundle basename="i18n"/>
	<h1><fmt:message key="login"></fmt:message></h1>
	
	<form action="">
	<fmt:message key="username"></fmt:message>：<input type="text" name="username"><br><br>
	<fmt:message key="password"></fmt:message>： <input type="password" name="password"><br><br>
	<input type="submit" value="<fmt:message key="login"></fmt:message>">
	</form>
	
	<br><br>
	<a href="login.jsp?locale=zh_CN">中文</a> | <a href="login.jsp?locale=en_US">English</a>
	
	<br><br>
	
	<fmt:message key="dateTime"/> : <fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd HH:mm:SS"/><br><br>
	<fmt:formatNumber pattern="#.###" value="12345678"></fmt:formatNumber>
</body>
</html>