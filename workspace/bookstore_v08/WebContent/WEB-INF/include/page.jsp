<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div id="page_nav">
			<c:choose>
				<c:when test="${page.totalPage<=5 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${page.totalPage }"></c:set>
				</c:when>
				<c:when test="${page.pageNo<=3 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="5"></c:set>
				</c:when>
				<c:otherwise>
					<c:set var="begin" value="${page.pageNo-2 }"></c:set>
					<c:set var="end" value="${page.pageNo+2 }"></c:set>
					<c:if test="${end>page.totalPage }">
						<c:set var="begin" value="${page.totalPage-4 }"></c:set>
						<c:set var="end" value="${page.totalPage }"></c:set>
					</c:if>
				</c:otherwise>
			</c:choose>
			<a href="${page.path }&pageNo=1">首页</a>
			<a href="${page.path }&pageNo=${page.pageNo-1 }">上一页</a>
			<c:forEach begin="${begin }" end="${end}" var="index">
				<c:choose>
					<c:when test="${index==page.pageNo }">
						【${index }】
					</c:when>
					<c:otherwise>
						<a href="${page.path }&pageNo=${index}">${index}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<a href="${page.path }&pageNo=${page.pageNo+1 }">下一页</a>
			<a href="${page.path }&pageNo=${page.totalPage}">末页</a>
			共${page.totalPage }页，${page.totalRecord }条记录 到第<input value="${page.pageNo }" name="pn" id="pn_input"/>页
			<script type="text/javascript">
				$("#pn_input").change(function(){
					//获取跳转页码
					var pageNo = $(this).val();
					//跳转页面实际就设置window.location属性
					window.location = "${pageContext.request.contextPath}/${page.path }&pageNo="+pageNo;
				})
			</script>
		</div>