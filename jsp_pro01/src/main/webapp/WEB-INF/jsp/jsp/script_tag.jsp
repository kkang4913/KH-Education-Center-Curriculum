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
	<title>JSP - Script Tag</title>
</head>
<body>
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