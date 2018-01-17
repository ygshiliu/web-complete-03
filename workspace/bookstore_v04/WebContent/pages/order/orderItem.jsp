<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					
						<tr>
							<td><img class="book_img" alt="" style="width:50px;height:50px;" src="static/img/default.jpg" /></td>
							<td>生命不息,折腾不止</td>
							<td>罗永浩</td>
							<td>25.2</td>
							<td>1</td>
							<td>25.2</td>
						</tr>
					
						<tr>
							<td><img class="book_img" alt="" style="width:50px;height:50px;" src="static/img/default.jpg" /></td>
							<td>恰到好处的幸福</td>
							<td>毕淑敏</td>
							<td>16.4</td>
							<td>1</td>
							<td>16.4</td>
						</tr>
					
						<tr>
							<td><img class="book_img" alt="" style="width:50px;height:50px;" src="static/img/default.jpg" /></td>
							<td>图解机器学习</td>
							<td>杉山将</td>
							<td>33.8</td>
							<td>1</td>
							<td>33.8</td>
						</tr>
					
				</table>
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>