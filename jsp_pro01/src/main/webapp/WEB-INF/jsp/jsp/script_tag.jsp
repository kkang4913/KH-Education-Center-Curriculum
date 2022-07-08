<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 지시자 태그 : 페이지라는 이름의 지시자 / 언어설정 / 컨텐츠 타입(사용구조,인코딩 등) --> 
<%@ page import="java.util.*" %>   <!-- 자바 모듈을 임포트 가능 -->
<%!
	private String name = "Hello"; // 선언태그(%!), 함수, 맴버변수가 보통 들어간다

	public String hello(){
		return "Hello";
	}
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/jsp01/static/css/main.css">
	<title>JSP - Script Tag</title>
</head>
<body>
<header class = "p-1 mb-1 border-bottom">
	<div class = container>
<h1><a class="top-nav" href="../main">Welcome Jsp/Servlet</a></h1>
	<div class= "flex"> 
	<ul class = nav>
		<li><a class = nav href ="./script_tag">JSP - Script Tag</a></li>
		<li><a class = nav href ="./request">JSP - request</a></li>
		<li><a class = nav href="./response">Jsp - response</a></li>
		<li><a class = nav href="./mvc">Jsp/Servlet - MVC Model</a></li>
		<li><a class = nav href="../depts">부서 조회</a></li>
		<li><a class = nav href="../locs">지역 조회</a></li>
	</ul>
	<form action="" class="col-auto">
		<input type = "text" class="form-controller">
			<button type="submit" name="search" class="btn-controller">조회</button>
	</form>
	</div>
	</div>
	</header>
	<h1>JSP - Script Tag</h1>
	<%-- 주석 --%>
	<ul>
	<% //스크립트 릿 태그
		for(int i = 0; i < 5; i++){
		Random rd = new Random();
	%>
		<li><%= rd.nextInt(100) %></li>
	<%	
		}
	%>
	</ul>
	<br>
	<input type = "text" value="<%=name %>"><br> <!-- 표현식 태그 -->
	<input type = "text" value="<%=hello() %>"><br> <!-- 표현식 태그 -->
 </body>
</html>