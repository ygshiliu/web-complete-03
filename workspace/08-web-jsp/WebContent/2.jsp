<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>2.jsp</h1>
	<!-- jsp动作标签：动态包含 -->
<%-- 	<jsp:include page="3.jsp"></jsp:include> --%>
	
	<!-- jsp动作标签：forward -->
	<!-- 当访问当前页面时，请求会转发到page属性指定的地址 -->
	<!-- 注意：如果没有标签体，开始标签和结束标签间是不能有任何空白的 -->
	<jsp:forward page="3.jsp">
		<jsp:param value="Tom" name="name"/>
	</jsp:forward>
</body>
</html>