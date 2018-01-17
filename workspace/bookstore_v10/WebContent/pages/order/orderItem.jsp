<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> 
		<span class="wel_word">订单详情</span>
		<%@ include file="/WEB-INF/include/menu.jsp" %>
	</div>

	<div id="main">

				<table>
					<tr>
						<td></td>
						<td>书名</td>
						<td>作者</td>
						<td>价格</td>
						<td>数量</td>
						<td>金额</td>
					</tr>
					<c:forEach items="${orderItemList }" var="item">
					
						<tr>
							<td><img class="book_img" alt="" style="width:50px;height:50px;" src="${item.imgPath }" /></td>
							<td>${item.title }</td>
							<td>${item.author }</td>
							<td>${item.price }</td>
							<td>${item.count }</td>
							<td>${item.amount }</td>
						</tr>
					</c:forEach>
					
				</table>
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>