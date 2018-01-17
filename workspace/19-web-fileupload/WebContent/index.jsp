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
	
	<!-- 
		文件上传：
		1. 需要使用form标签，必须是post请求方式
		2. 使用file表单项上传文件
		3. 需要指定form标签的enctype属性为multipart/form-data，表示以多部件的形式发送给服务器。
			默认为application/x-www-form-urlencoded。
		4. 当enctype=multipart/form-data时，后台将不能通过getParament()方法获取到请求参数，
			我们需要通过流的方式来获取 。一般我们使用apache提供的commons-fileuplad来解析多部件，
			而commons-fileupload依赖commons-io包。所以我们需要导入：
			commons-fileupload-1.3.1.jar
			commons-io-2.4.jar
			
	 -->
	${msg }<br><br>
	<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
		文件名:<input type="text" name="nickname"><br><br>
		文件1：<input type="file" name="file1"><br><br>
		文件2：<input type="file" name="file2"><br><br>
		文件3：<input type="file" name="file3"><br><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>