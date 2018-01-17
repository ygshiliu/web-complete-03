<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@ include file="/WEB-INF/include/manager.jsp" %>
		</div>
		
		<div id="main">
				<c:choose>
					<c:when test="${empty book }">
						<form action="manager/BookManagerServlet?method=addBook" method="post" enctype="multipart/form-data">
						<!-- 如果为空说明是添加图书操作 -->
						<!-- <input type="hidden" name="method" value="addBook"> -->
					</c:when>
					<c:otherwise>
						<form action="manager/BookManagerServlet?method=updateBook" method="post" enctype="multipart/form-data">
						<!-- 修改图书操作 -->
						<!-- <input type="hidden" name="method" value="updateBook"> -->
						<input type="hidden" name="id" value="${book.id }">
						<input type="hidden" name="referer" value="${header.referer }">
					</c:otherwise>
				</c:choose>
				<table>
					<tr>
						<td>名称</td>
						<td>作者</td>
						<td>价格</td>
						<td>销量</td>
						<td>库存</td>
						<td>封面</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="title" type="text" value="${book.title }"/></td>
						<td><input name="author" type="text" value="${book.author }"/></td>
						<td><input name="price" type="text" value="${book.price }"/></td>
						<td><input name="sales" type="text" value="${book.sales }"/></td>
						<td><input name="stocks" type="text" value="${book.stocks }"/></td>
						<td><input name="imgPath" type="file" value="${book.imgPath }"/></td>
						<td><input name="book_amount" type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>