<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 函数标签库要结合EL表达式使用
		主要用来对字符串进行操作
	 -->
	 <%
	 	String[] str = new String[]{"a","b","c","d"};
	 	request.setAttribute("str", str);
	 %>
	 ${fn:contains("asdfsdf","A") }前一字符串是否包含后一字符串，返回布尔值<br>
	 ${fn:containsIgnoreCase("sfas","A") }<br>
	 ${fn:endsWith("sfas","sas") }<br>
	 ${fn:escapeXml("<script>alert('haha')</script>") }<br>
	 ${fn:indexOf("asdfsdf","fs") }<br>
	 ${fn:join(str,"-")}<br>
	 ${fn:split("a,b,c,d",",")[0] }<br>
	 ${fn:trim("  adasd   ") }<br>
	 
	 
</body>
</html>