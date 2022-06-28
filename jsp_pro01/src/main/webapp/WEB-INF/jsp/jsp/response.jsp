<%@page import="java.net.http.HttpResponse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP - response</title>
</head>
<body>
	<h1>JSP - response</h1>
	<h2>setContentType()</h2>
	<p>
		브라우저에게 전송하는 데이터의 컨텐츠 종류를 알려주어 해당 컨텐츠로 인식하고 해석하게 만든다.
	</p>
	<%
		response.setContentType("text/html");
		//response.setContentType("text/javascript"); //스크립트로 해석
	%>
	<hr>
	<h2>setStatus()</h2>
	<%
		//response.setStatus(HttpServletResponse.SC_OK); 			  //응답코드 200
		//response.setStatus(HttpServletResponse.SC_CREATED);     //응답코드(개발자모드에서 확인 가능) 201
		//response.setStatus(HttpServletResponse.SC_ACCEPTED);    //응답코드 202
		//2xx :정상/ 3xx:리다이렉트/ 4xx: 요청오류/ 5xx :서버오류
		
		//response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	%>
	<p>
		개발자 모드에서 NetWork 탭의 Status 항목에서 변경된 상태를 확인 가능 하다.<br>
		HTTP 상태 코드는 크게 2XX / 3XX / 4XX /5XX 번대로 분류한다.<br>
		2XX: 정상 응답<br>
		3XX: 리다이렉트(다른 페이지로 재요청 해라.)<br>
		4XX: 요청 오류<br>
		5XX: 서버 오류<br>
	</p>
	<hr>
	<h2>sendError()</h2>
	<%
		//response.sendError(HttpServletResponse.SC_BAD_REQUEST );
		//response.sendError(HttpServletResponse.SC_BAD_REQUEST,"잘못된 요청입니다." );
	%>
	<p>
		setStatus() 와 동일한 기능을 수행하나, 별도의 Error 페이지를 출력하기 위해서 사용하는 메서드로<br>
		사용하면 된다. 메세지 출력도 가능.<br>
	</p>
	<hr>
	<h2>sendRedirect()</h2>
	<%
		//response.sendRedirect("/jsp01/main");
	%>
</body>
</html>