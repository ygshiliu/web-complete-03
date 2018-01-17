<%@page import="com.atguigu.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center">
	<h1>学生列表</h1>
	
	<%
		//获取学生列表
		List<Student> list = (List<Student> )request.getAttribute("list") ;
	%>
	<table border="1px" align="center" cellpadding="10" cellspacing="0" width="60%" >
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>地址</td>
			<td colspan="2">操作</td>
		</tr>
				
	<%
	//遍历学生信息
	for(int i=0;i<list.size();i++){
		%>
		
		<tr>
			<td><%=list.get(i).getName() %></td>
			<td><%=list.get(i).getGender() %></td>
			<td><%=list.get(i).getAddress() %></td>
			<td><a href="#">修改</a></td>
			<td><a href="#">删除</a></td>
		</tr>
		
		<%
		
	}
		
	%>
	</table>	
	
			
	
</body>
</html>