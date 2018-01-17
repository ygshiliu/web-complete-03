<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="http://localhost:8080/10-web-jstl/">
</head>
<body>
	<!-- 
		在页面中设置绝对路径的方式：
		第1种：通过base标签以相对路径的方式来实现绝对路径的使用：
			<base href="http://localhost:8080/10-web-jstl/">
		第2种：使用c:url实现路径的重写
			 <a href="<c:url value='/index.jsp'></c:url>">访问index.jsp</a>
		第3种：可以在域中设置一个变量，作为路径的前缀
			<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
	 		<a href="${ctx }/index.jsp">访问index.jsp</a>
			
	 -->
	 <!-- 第1种： -->
	 <!-- http://localhost:8080/10-web-jstl/index.jsp -->
	 <a href="index.jsp">访问index.jsp</a><br><br>
	 
	
	 <!-- 第2种： -->
	 <a href="<c:url value='/index.jsp'></c:url>">访问index.jsp</a><br><br>
	 
	 <!-- 第3种： -->
	 <c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
	 <a href="${ctx }/index.jsp">访问index.jsp</a>
</body>
</html>