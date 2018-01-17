<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		$(".delA").click(function(){
			var $title = $(this).parents("tr").find("td:eq(0)").html();
			if(!confirm("您确认要删除<"+ $title +">图书吗？")){
				return false;
			}
		})
		$("#clearA").click(function(){
			if(!confirm("您确认要清空购物车吗？")){
				return false;
			}
		})
		$("[name=count]").change(function(){
			//获取用户输入的内容
			var count = $(this).val();
			//通过正则表达式对内容进行检查
			var reg = /[0-9]/;
			if(!reg.test(count)){
				alert("请输入一个正确格式的数字");
				//重新设置成之前的有效数字
				this.value = this.defaultValue;
				return false;
			}
			
			//向服务器发送请求
			//location.href = "${pageContext.request.contextPath}/client/CartServlet?method=updateCount&bookId="+this.id+"&count="+count;
			
			var url="${pageContext.request.contextPath}/client/CartServlet?method=updateCount&bookId="+this.id+"&count="+count;
			var $td = $(this).parents("tr").find("td:eq(3)");
			$.get(url,function(data){
				if(data){
					$td.html(data.amount);
					$(".b_count").html(data.totalCount);
					$(".b_price").html(data.totalAmount);
				}
				
			},"json");
		})
	})
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@ include file="/WEB-INF/include/menu.jsp" %>
	</div>
	
	<div id="main">
		<c:choose>
			<c:when test="${empty cart.list }">
				<br><br><br><h3 style="text-align:center">您的购物车中暂时没有商品，赶快去购物吧。。</h3><br><br><br><br>
			</c:when>
			<c:otherwise>
			<table>
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${cart.list }" var="item">
					<tr>
						<td>${item.book.title }</td>
						<td><input type="text" id="${item.book.id }" name="count" value="${item.count }" style="width:30px;text-align:center"></td>
						<td>${item.book.price }</td>
						<td>${item.amount }</td>
						<td><a class="delA" href="client/CartServlet?method=deleteCartItem&bookId=${item.book.id }">删除</a></td>
					</tr>	
				
				</c:forEach>		
				
			</table>
			
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount }</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${cart.totalAmount }</span>元</span>
				<span class="cart_span"><a id="clearA" href="client/CartServlet?method=clear">清空购物车</a></span>
				<span class="cart_span"><a href="client/OrderClientServlet?method=checkout">去结账</a></span>
			</div>
		
		</div>
			
			</c:otherwise>
		</c:choose>
	
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>