<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>메인 화면</title>
		<%@ include file="./module/head.jsp" %>
</head>
<body>
	<header class="mb-3">
		<%@ include file="./module/navigation.jsp" %>
	</header>
		<c:if test="${empty sessionScope.loginData}">
			<section class="container" style="width: 480px;">
				<%@ include file="./login/login_m.jsp"  %>
			</section>
		</c:if>
		<c:if test="${not empty sessionScope.loginData}">
			${sessionScope.loginData.empName} 님 환영합니다.
		</c:if>
</body>
</html>