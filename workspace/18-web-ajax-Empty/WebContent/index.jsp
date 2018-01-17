<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>三级联动</title>
<!-- 引入jQuery库 -->
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		
		//页面加载完成之后，先加载省份信息
		$.getJSON("${pageContext.request.contextPath}/ProvinceServlet",function(data){
			//获取省份下拉列表框
			var $province = $("[name=province]");
			//遍历服务器返回的省份信息
			for(var i=0;i<data.length;i++){
				//将省份包装成“<option>北京</option>” 设置进省份下拉列表
				$province.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>")
			}
		}) 
		
		$("[name=province]").change(function(){
			//准备请求参数，id
			var pId = this.value;
			//清空之前的信息
			$("[name=city] option:gt(0)").remove();
			$("[name=district] option:gt(0)").remove();
			//向服务器发送请求
			$.get("${pageContext.request.contextPath}/CityServlet?pId="+pId,function(data){
					//获取响应，遍历将其插入到city下拉列表框中
					for(var i=0;i<data.length;i++){
						$("[name=city]").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
					}
			},"json");
			
		})
		
		$("[name=city]").change(function(){
			//准备请求参数
			var cid = this.value;
			//清空之前的信息
			$("[name=district] option:gt(0)").remove();
			//发送请求
			$.get("${pageContext.request.contextPath}/DistrictServlet?cid="+cid,function(data){
				//获取响应数据，遍历插入到district下拉列表中
				for(var i=0;i<data.length;i++){
					$("[name=district]").append("<option>"+data[i].name+"</option>");
				}
			},"json");
			
		})
	})
</script>
</head>
<body>
<select name="province">
	<option>请选择省...</option>
</select>
<select name="city">
	<option>请选择市...</option>
</select>
<select name="district">
	<option>请选择区县...</option>
</select>
</body>
</html>