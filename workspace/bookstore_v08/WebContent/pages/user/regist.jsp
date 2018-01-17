<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>

<script type="text/javascript">

	$(function(){
		
		//正则表达式：是用来检查文本内容是否符合规则，返回布尔值 
	/* 	var reg = /a/;
		var str = "ss";
		var flag = reg.test(str);
		alert(flag); */
		
		//获取按钮，绑定单击函数 
		$("#sub_btn").click(function(){
			
			//获取表单项信息
			var name = $("[name=username]").val();
			var password = $("[name=password]").val();
			var repwd = $("[name=repwd]").val();
			var email = $("[name=email]").val();
			var code = $("[name=code]").val();
			
			//对表单项信息进行验证
			//对用户名验证
			var reg = /^[a-z0-9_-]{3,16}$/;
			var flag = reg.test(name);
			if(!flag){
				alert("用户名不符合要求，请重新输入");
				return false;
			}
			
			//对密码验证
			reg=/^[a-z0-9_-]{6,18}$/;
			flag = reg.test(password);
			if(!flag){
				alert("密码不符合要求，请重新输入");
				return false;
			}
			
			//确认密码
			if(repwd != password){
				alert("密码与确认密码不一致，请重新输入");
				return false;
			}
			
			//邮箱
			reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			flag = reg.test(email);
			if(!flag){
				alert("邮箱格式不正确，请重新输入");
				return false;
			}
			
			//验证码
			if(code == ""){
				alert("验证码不能为空");
				return false;
			}
			
			//取消默认行为
			//return false;
		})
	})

</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${empty msg?"":msg }</span>
							</div>
							<div class="form">
								<form action="client/UserServlet?method=regist" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" value="${param.username }" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" value="${param.email }" name="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" value="${param.code }"/>
									<img alt="" src="code.jsp" style="float: right; margin-right: 40px;width:90px;height:35px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>