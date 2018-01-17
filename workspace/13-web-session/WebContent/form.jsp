<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	window.onload = function(){
		//获取按钮，绑定单击事件
		var btn = document.getElementById("btn");
		btn.onclick = function(){
			this.disabled = true;
			//禁用按钮后，也会取消表单的提交行为，所以需要手动提交
			var form = this.parentNode;
			form.submit();
		}
	}

</script>
</head>
<body>
	<h1>form.jsp</h1>
	
	<%
		//创建token
		String token = UUID.randomUUID().toString().replace("-", "");
		
		//保存到session
		session.setAttribute("token", token);
	
	%>
	${msg }
	<form action="RegistServlet" method="post">
		<input type="text" name="token" value="<%=token%>" style="width:300px;"><br><br>
		姓名：<input type="text" name="username" ><br><br>
		密码：<input type="password" name="password"><br><br>
		性别：<input type="radio" name="gender" value="男">男
		     <input type="radio" name="gender" value="女">女<br><br>
		<input type="submit" value="注册" id="btn">
	</form>
</body>
</html>