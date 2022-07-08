<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jsp01/static/css/main.css">

<title>JSP - request</title>
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
	<h1>JSP - request</h1>
	<h2>request.getMethod()</h2>
	<p>
	request.getMethod() ->	<%= request.getMethod() %>
	</p>
	<form action="./request" method="get">
		<button type ="submit">GET 전송</button>
	</form>
	<form action="./request" method="post">
		<button type ="submit">POST 전송</button>
	</form>
	<hr>
	<h2>request.getParameter(name)</h2>
	<p>
		request.getParameter(name) --> <%=request.getParameter("param_name") %>
		<br>
		name 은 HTML 폼(form) 관련 속성 중 name 속성에 정의한 속성값이다.
	</p>
	<form action="./request" method="get">
		<div>
			<input type ="text" name="param_name"> <!-- getParameter 값과 name 값이 같아야한다. -->
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
	<hr>
	<h2>request.getParameterValues()</h2>
	<p>
		request.getParameterValues() --> <!-- 배열로 처리해서 출력 -->
		<% 
			if(request.getParameterValues("param_chk") != null){
				String[] sArr = request.getParameterValues("param_chk");
				for(String s : sArr){
			%>
					<%=s + " " %>
			<%
				}
			}
		%>
	</p>
	<form action="./request" method="get">
		<div> <!-- 체크박스로 많이 사용(배열로 출력되기 때문에) -->
			<input type ="checkbox" name="param_chk" value="a">
			<input type ="checkbox" name="param_chk" value="b">
			<input type ="checkbox" name="param_chk" value="c">
			<input type ="checkbox" name="param_chk" value="d">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
	<hr>
	<h2>request.getParameterNames()</h2>
	<p>
		request.getParameterNames() -->
		<%
			Iterator<String> iter = request.getParameterNames().asIterator();
			while(iter.hasNext()){
		%>
					<%=iter.next() + " " %>
		<% 		
			}
		%>
	</p>
	<form action="./request" method="get">
		<div>
			<input type="text" name="username">
		</div>	
		<div>
			<input type="text" name="password">
		</div>	
		<div>
			<button type="submit">전송</button>
		</div>	
	</form>
	<hr>
	<h2>request.setCharacterEncoding()</h2>
	<p>
		request.setCharacterEncoding("UTF-8") -->
		<%=request.getParameter("param_name") %>
		<br>
		servlet 파일에 작성 할 것.
	</p>
	<form action="./request" method="post">
		<div>
			<input type="text" name="param_name">
		</div>
		<button type="submit">전송</button>
	</form>
	<hr>
	<h2>request.getSession()</h2>
	<p>
		request.getSession() --> <%=request.getSession() %>
		JSESSIONID = "<%=request.getSession().getId() %>"
		<!-- 세션을 활용 -> 사용자(계정) 정보를 세션안에서 관리할 수 있다. -->
	</p>
	<form action="./request" method="get">
		<button type="submit">전송</button>
	</form>	
</body>
</html>