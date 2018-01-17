<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.atguigu.bean.Person"%>
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
	
	<%
		pageContext.setAttribute("key", "pagevalue");
		request.setAttribute("key", "reqValue");
		session.setAttribute("key", "sessionValue");
		application.setAttribute("key", "appValue");
		
		request.setAttribute("person", new Person("haha",18,'男'));
		session.setAttribute("hello-Kity", "kity");
		
		List list = new ArrayList();
		list.add("刘在石");
		list.add("宋智孝");
		list.add("狗哥");
		request.setAttribute("list", list);
		
		Map map = new HashMap();
		map.put("name", "狗哥");
		map.put("age",35);
		map.put("gender","男");
		request.setAttribute("map", map);
		
	%>
	
	<!-- EL表达式 -->
	<!-- EL表达式用来替换jsp表达式，主要作用是向页面输出内容 ,不能用来设置内容-->
	<!-- 内容主要是获取域对象中设置的属性信息 -->
	<!-- 域对象：pageContext|request|session|application -->
	<!-- 但是在EL表达式中并没有提供直接除pageContext之外的域对象，
	而提供了与域对象对应的 pageScope|requestScope|sessionScope|applicationScope-->
	
	<!-- EL获取域中属性的一个顺序，它会从小到大依次查找，找到就返回 -->
	<%-- key : ${key} --%>
	<!-- 但是我们也可以指定查找域，比如就想查找requestScope中的属性 -->
	<%-- key : ${requestScope.key} --%>
	
	<!-- EL表达式获取对象 -->
	<!-- 会从四个域中依次查找属性 -->
	${person }<br>
	<!-- 获取对象的属性,可以直接通过点操作 -->
	<!-- EL表达式是通过调用对象的getter方法获取对象的属性值的 -->
	${person.name }<br>
	${person.age }<br>
	<!-- 获取对象的属性值还可以通过中括号方式 -->
	<!-- 这种方式适合名字中含有特殊字符的 -->
	${person['name'] }<br>
	${sessionScope['hello-Kity'] }<br><br>
	
	<!-- EL获取list -->
	${list }<br>
	<!-- 获取某一个元素,可以通过下标方式 -->
	${list[1] }<br><br>
	
	<!-- EL获取map -->
	${map }<br>
	<!-- 获取map中的指定元素，直接通过点操作 -->
	${map.name }<br><br>
	
	<!-- EL获取域中没有的属性 ,如果没有找到将什么都不返回-->
	获取域中没有的属性：${name }<br>
	JSP表达式：<%=request.getParameter("name") %>
	
	<br><br>
	
	<a href="1.jsp">1.jsp</a>
</body>
</html>