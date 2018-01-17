<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	
	$(function(){
		//获取删除链接
		$(".delA").click(function(){
			var title = $(this).parents("tr").find("td:eq(0)").html();
			if(!confirm("您确认要删除《" +title+ "》图书吗？")){
				//不删除时
				return false;
			}
		})
		
	})

</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@ include file="/WEB-INF/include/manager.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>作者</td>
				<td>价格</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>		
		<c:forEach items="${page.list}" var="book">
		
			<tr>
				<td>${book.title }</td>
				<td>${book.author }</td>
				<td>${book.price }</td>
				<td>${book.sales }</td>
				<td>${book.stocks }</td>
				<td><a href="manager/BookManagerServlet?method=toPageBook&bookId=${book.id }">修改</a></td>
				<td><a class="delA" href="manager/BookManagerServlet?method=deleteBook&bookId=${book.id }">删除</a></td>
			</tr>	
		</c:forEach>	
		
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
	<%@ include file="/WEB-INF/include/page.jsp" %>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>