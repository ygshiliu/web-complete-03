<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
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
<body>
	<h1>core.jsp</h1>
	
	<!-- c:set 用来向域中添加或修改属性 ,默认设置在pageScope中-->
	<!-- var:用来指定属性在域中的名 -->
	<!-- value：用来指定属性在域中的值  -->
	<!-- scope:用来指定将属性设置进哪个域中 .共有4个值可以指定分别是：page|request|session|application-->
	<c:set value="Jerry" var="name" scope="application" ></c:set>
	
	<!-- c:remove用来从或中移除指定属性，默认是全域移除 -->
	<!-- scope用来指定域 -->
	<c:remove var="name" scope="request"/>
	
	<!-- c:if用来做分支处理，与java中的if语句功能一样 -->
	<!-- test：用来接收一个boolean值，为true则执行标签体中的内容，false不执行 -->
	<!-- test属性值通常结合el表达式使用 -->
	<!-- 注意：没有else功能 -->
	<!-- var用来指定 保存结果的变量名-->
	<!-- scope用来指明将结果保存在哪个域中 -->
	<c:if test="${param.flag }" scope="application" var="name">
		<h5>你是正确的</h5>
	</c:if>
	
	<!-- c:choose|c:when|c:otherwise是组合标签，可以实现if..else if..else if..else功能 -->
	<!-- c:when可以有多个 ，等同于else if-->
	<!-- c:otherwise等同于else,即c:when条件都不满足时执行c:otherwise标签体中的部分 -->
	<!-- 注意：
		1. c:when与c:otherwise不可以脱离c:choose存在 
		2. 多个c:when之间需要注意条件的先后顺序，通常将条件范围更小的放在前面。
			一旦条件满足将会执行，同时跳出c:choose
		3. c:when一定写在c:otherwise前面
	-->
	<c:choose>
		<c:when test="${param.score >= 90 }">
			<h5>成绩优秀</h5>
		</c:when>
		<c:when test="${param.score >= 80 }">
			<h5>成绩良好</h5>
		</c:when>
		<c:when test="${param.score >= 60 }">
			<h5>成绩合格</h5>
		</c:when>
		<c:otherwise>
			<h5>成绩不合格</h5>
		</c:otherwise>
	</c:choose>
	
	<!-- c:forEach用来遍历，等同于 java中的for循环-->
	<!-- var用来保存每次遍历的值的属性名，默认将值保存在pageScope中 -->
	<!-- begin用来指定要遍历数据的开始值 ，类型int-->
	<!-- end用来指定遍历数据的结束值,类型int -->
	<!-- step:步长，递增数量 。默认为1-->
	<!-- 此种情况可以用来做分页页码处理 -->
	<c:forEach var="index" begin="1" end="10" step="2" >
		${index }<br>
	</c:forEach>
	
	
	<%
		List list = new ArrayList();
		list.add("宋智孝");
		list.add("刘在石");
		list.add("金钟国");
		list.add("李光洙"); 
		
		request.setAttribute("list",list);
	%>
	<br><br>List:<br>
	<!-- 使用forEach遍历list集合 -->
	<!-- items用来指向要遍历的对象，通常与EL接合使用，用来获取域中的集合对象 -->
	<!-- var：用来指定属性名，主要用来以var指定的值为键，以遍历的内容为值 ，保存到pageScope中 -->
	<c:forEach items="${list }" var="str">
		${str }<br>
	</c:forEach>
	
	<%
		Map map = new HashMap();
		map.put("name", "Tom");
		map.put("age", 16);
		map.put("gender", "男");
		
		pageContext.setAttribute("map", map);
	%>
	
	<br><br>map:<br>
	<!-- 遍历Map -->
	<!-- 遍历map时，每次是一个entry结构，可以通过属性key获取键，属性value获取值 -->
	<c:forEach items="${map }" var="v">
		${v.key }---${v.value }<br>
	</c:forEach>
	
	
	<!-- c:url用来重写url地址 -->
	<!-- value用来指定要重写的url地址 -->
	<!-- var用来指定属性名，它会将value属性的值以var指定的值作为键保存到域中 -->
	<!-- scope用来指定保存到哪个域中,默认是pageScope -->
	<!-- 注意：
		如果指定的是相对路径，它会原样设置。比如指定的是index.jsp那就是index.jsp;
		如果是绝对路径， 以/开头，会自动加上项目名，如：/10-web-jstl/index.jsp
	-->
	<c:url value="/index.jsp" var="url" scope="request">
		<!-- c:url可以使用 c:param子标签传递请求参数-->
		<!-- 
			c:param：可以自动进行url编码。如：
			/10-web-jstl/index.jsp?age=16&name=%E5%BC%A0%E4%B8%89
		 -->
		<c:param name="age" value="16"></c:param>
		<c:param name="name" value="张三"></c:param>
	</c:url>
	<br><br>url:${url }
	
	
	<!-- c:redirect可以实现请求的重定向 -->
	<!-- url用来指定要重定向的路径 -->
	<!-- 注意：这里的重定向会自动加上项目名 -->
	<c:redirect url="/index.jsp"></c:redirect>
</body>
</html>