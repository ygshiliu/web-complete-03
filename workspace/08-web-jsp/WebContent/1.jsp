<%@page import="java.util.Date"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>1.jsp</h1>
	
	<!-- 模版元素：就是页面中的html 
		最终作为out.write()方法的参数，如：
		out.write("\t<div>模版元素：就是页面中的html</div>\r\n");
	-->
	<div>模版元素：就是页面中的html</div>
	
	<!-- 脚本片段：使用<%%> 
		在其中可以书写java代码
		脚本片段中的java代码会原封不动的复制到翻译后的service方法中
		也就是说，在方法中我们怎么写代码，在脚本片段中就怎么写
		可以定义局部变量
		可以写语句
		但是可以定义方法吗？不能定义方法
		一个页面中可以有多个脚本片段
	 -->
	 <%	
	 	int i = 0;
	 	System.out.print("你好");
	 // 	public void setI(int j){
	 //		i = j;
	 //	}
	 %>
	 <%	
	 	int j = 0;
	 	String str = "JSP表达式";
	 %>
	 
	 <!-- JSP表达式：使用&nbsp;%= %> 
	 	  作用：可以向页面中输出信息
	 	  最终作为out.print()方法的参数，而print()可以接收任意类型，所以这里可以输出任何信息 ，如：
	 	  out.print(str );
	 	 注意：这里是作为方法的参数，所以不可以在这里写java语句,结果服务器会报错
	 	  out.print(System.out.print(j) );
	 -->
	<%=str %>
	
	<!-- html注释 :在jsp文件、java文件及页面中都可以显示-->
	<%-- JSP注释 ：只在jsp文件中显示--%>
	<%	
		//java注释在jsp文件与java文件中显示 
		//java单行注释
		/*
			java多行注释
		*/
		
	%>
	
	<!-- jsp声明 :
		作用：可以用来定义类的方法及全局变量
		在jsp声明中的java代码会被翻译到java文件的类中
		注意，在这里不能写java语句
	-->
	<%!
		private Date date = new Date();
		public int setStr(){
			System.out.print("setStr方法被调用");
			return 9;
		}
	%>
	<%=setStr() %>
</body>
</html>