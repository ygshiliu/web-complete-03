<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 使用taglib指令标签引入核心标签库 -->
<!-- prefix：用来指定前缀名，通常在页面中使用此前缀来调用标签 -->
<!-- uri:指明要引入哪一个标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp</h1>
	<%
		pageContext.setAttribute("name", "<script>alert('haha')</script>");
	%>
	<!-- out标签的作用与EL表达式一样，用来向页面输出内容 -->
	<!-- value:用来指定向页面输出的内容 -->
	<!-- default：在获取不到value属性值时输出的默认值 -->
	<!-- escapeXml：用来指定value属性值含有特殊字符时，是否进行转义。默认为true -->
	<!-- 向页面输出基本数据类型 -->
	<c:out value="name" ></c:out><br>
	<!-- 可以与EL表达式结合使用，从域中获取属性，然后输出到页面中 -->
	<c:out value="${pageScope.name }" default="Lucy" ></c:out><br>
	<%-- ${pageScope.name }<br> --%>
	
</body>
</html>