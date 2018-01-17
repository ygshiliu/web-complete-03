<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>4.jsp</h1>
	
	<% 
		pageContext.setAttribute("pagecontext", "pageContext");
		request.setAttribute("request", "request");
		session.setAttribute("session", "session");
		application.setAttribute("application", "application");
	%>
	
	pageContext : <%=pageContext.getAttribute("pagecontext") %><br><br>
	request : <%=request.getAttribute("request") %><br><br>
	session : <%=session.getAttribute("session") %><br><br>
	application : <%=application.getAttribute("application") %><br><br>
</body>
</html>