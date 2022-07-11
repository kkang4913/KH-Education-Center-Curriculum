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
		<title>Welcome Jsp/Servlet</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/default.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/form.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/navigation.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/paging.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/required.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/table.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/required.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/module/navigation.jsp" %>
	<h1>Welcome Jsp/Servlet</h1>
	<div>
		<hr>
		<h2>JSTL Core 기능 테스트</h2>
			<c:if test="${not empty data}">
				if 제어문 :  test에 작성한 조건식이 참이면 실행된다.<br>
				${data}
			</c:if>
			<hr>
			<c:choose>
				<c:when test="${param.x =='a'}">
					파라메터 x 의 값이 a 입니다.
				</c:when>
				<c:when test="${param.x =='b'}">
					파라메터 x 의 값이 b 입니다.
				</c:when>
				<c:when test="${param.x =='c'}">
					파라메터 x 의 값이 c 입니다.
				
				</c:when>
				<c:otherwise>
					파라메터 x 의 값이 a, b, c 가 아닙니다.
				</c:otherwise>
			</c:choose>
			<hr>
			<c:forEach begin="1" end="5" step="2" var="v" >
				${v}<br>
			</c:forEach>
			<%
				List<String> lst = new ArrayList<String>();
				lst.add("a"); lst.add("b"); lst.add("c"); lst.add("d");
				request.setAttribute("lst", lst);
			%>
			<c:forEach items="${lst}"  var="v">
				${v}<br>
			</c:forEach>
			<c:forTokens  items="홍길동,이순신,뀨리" delims="," var="v">
				${v}
			</c:forTokens><br>	
			
			<%
				Map<String,String> map = new HashMap<String,String>();
				map.put("a","가"); map.put("b","나"); map.put("c","다"); map.put("d","라");
				request.setAttribute("map", map);
			%>
			<c:forEach items="${map}"  var="v">
				${v.key} - ${v.value }<br>
			</c:forEach>
			<hr>
				<h2>JSTL Core 기능 테스트 : c:set</h2>
				<c:set var="d" value="Hello1"  scope="page"/>  <!-- scope : 변수 사용 범위 (지역 -> 전역) -->
				<c:set var="d" value="Hello2"  scope="request"/>
				<c:set var="d" value="Hello3"  scope="session"/>
				<c:set var="d" value="Hello4"  scope="application"/>
				${pageScope.d}<br>
				${requestScope.d}<br>
				${sessionScope.d}<br>
				${applicationScope.d}<br>
				<hr>
				<c:remove var="d" scope="page"/> 
				<c:remove var="d" scope="request"/>
				<c:remove var="d" scope="session"/>
				<c:remove var="d" scope="application"/>
				${pageScope.d}<br>
				${requestScope.d}<br>
				${sessionScope.d}<br>
				${applicationScope.d}<br>
				<hr>
				<c:url var="url1" value="/path">
					<c:param name="x" value="10" />
				</c:url>
				${url1}
	</div>
	<div>
		<h2>JSTL Core 기능 테스트 - fmt</h2>
		<fmt:formatNumber value="1000"/><br>
		<fmt:formatNumber value="0.1" type="percent"/><br>
		<fmt:formatNumber value="1000" type="currency"/><br>
		<fmt:formatNumber value="1000" type="currency" currencySymbol="$"/><br>
		<hr>
		<c:set var="date" value="<%=new Date() %>"/>
		<fmt:formatDate value="${date}" type="date"/><br>
		<fmt:formatDate value="${date}" type="date" dateStyle="full"/><br>
		<fmt:formatDate value="${date}" type="date" dateStyle="long"/><br>
		<fmt:formatDate value="${date}" type="date" dateStyle="medium"/><br>
		<fmt:formatDate value="${date}" type="date" dateStyle="short"/><br>
		<fmt:formatDate value="${date}" type="date" pattern="YYYY-MM-dd E EEEE"/><br>
		<hr>
		<fmt:formatDate value="${date}" type="time"/><br>
		<fmt:formatDate value="${date}" type="time" timeStyle="full"/><br>
		<fmt:formatDate value="${date}" type="time" timeStyle="long"/><br>
		<fmt:formatDate value="${date}" type="time" timeStyle="medium"/><br>
		<fmt:formatDate value="${date}" type="time" timeStyle="short"/><br>
		<fmt:formatDate value="${date}" type="time" pattern="a hh:mm:ss / HH:mm:ss.sss"/><br>
		<hr>
		<fmt:formatDate value="${date}" type="both"/><br>
		<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="short"/><br>
		<hr>
		<h2>JSTL Core 기능 테스트 - fn</h2>
		${fn:contains('Hello', 'e')}<br>
		${fn:containsIgnoreCase('Hello', 'E')}<br>
		${fn:startsWith('Hello', 'e')}<br>
		${fn:endsWith('Hello', 'e')}<br>
		${fn:indexOf('Hello', 'e')}<br>
		${fn:length('Hello')}<br>
		${fn:replace('Hello', 'e','a')}<br>
		${fn:substring('Hello', 1, 3)}<br>
		${fn:split('Hello, Hi ',', ')}<br>
	</div>
</body>
</html>