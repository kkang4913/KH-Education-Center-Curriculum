<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.*, locs.model.LocsDTO" %>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/default.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/form.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/navigation.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/paging.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/required.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/table.css">
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/required.js"></script>
<title>지역 조회 결과</title>
</head>
<script type="text/javascript">
	window.onload = function() {
		var form = document.forms[0];
		form.addEventListener("submit",formCheck);
	}
	
	function formCheck(e) {
		var f = e.target;
		e.preventDefault();
	
		if(f.search.value.trim() ==="") {
		f.searh.value = f.search.value.trim();
		return;
	}
		f.submit();
	}
</script>
<body>
<body>
	<%@ include file="/WEB-INF/jsp/module/navigation.jsp" %>
	<section class="container">	
		<div>
			<form action="./locs" method="get">
			 		<div class="input-form form-right">
			 			<input class="input-text" type="text" name="search"> <!--name에 locsId가 들어간다  -->
			 			<button class="btn btn-outline" type="submit">조회</button>
			 		</div>
			</form>
		</div>
	<table class="table wide vertical-hidden hover">
		<colgroup>
			<col class="col-120">
			<col class="col-auto">
			<col class="col-120">
			<col class="col-120">
			<col class="col-120">
			<col class="col-120">
		</colgroup>
		<thead>
			<tr>
				<th>Location ID</th>
				<th>STREET Address</th>
				<th>Postal_Code</th>
				<th>City</th>
				<th>State_Province</th>
				<th>Country_Id</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty datas}">
				<c:forEach items="${datas}" var="data">
					<tr>
						<td>${data.locId}</td>
					    <td>${data.stAddr}</td>
						<td>${data.postal}</td>
						<td>${data.city}</td>
						<td>${data.state}</td>
						<td>${data.ctyId}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</section>
</body>
</html>