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
				<div class="input-form form-left">
					<button class="btn btn-outline" type="button" onclick="location.href='./locs/add'">추가</button>
				</div>
		 		<div class="input-form form-right">
						<input class="input-text" type="text" name="search">
						<button class="btn btn-outline" type="submit">조회</button>
						<select class="select-form" onchange="location.href='./locs?pgc=' + this.value">
							<option value="5" ${pgc == 5 ? 'selected' : ''}>5 개</option>
							<option value="10" ${pgc == 10 ? 'selected' : ''}>10 개</option>
							<option value="15" ${pgc == 15 ? 'selected' : ''}>15 개</option>
							<option value="20" ${pgc == 20 ? 'selected' : ''}>20 개</option>
					</select>
				</div>
			</form>
		</div>
	<table class="table wide vertical-hidden hover">
		<colgroup>
			<col class="col-130">
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
	<c:if test="${not empty pageList}">
			<c:set var="currentPage" value="${page}" />
			<div class="paging">
				<ul class="page center">
					<c:if test="${currentPage - 1 > 0}">
						<li class="page-item">
							<a class="page-link" href="./locs?page=${currentPage - 1}">Prev</a>
						</li>
					</c:if>
					<c:set var="i" value="${currentPage - 1}" />
					<c:set var="maxPage" value="${i + 5 > pageList.size() ? pageList.size() : i + 5}" />
					<c:forEach begin="${i}" end="${maxPage - 1}" var="num">
						<li class="page-item">
							<a class="page-link" href="./locs?page=${pageList.get(num)}">${pageList.get(num)}</a>
						</li>
					</c:forEach>
					<c:if test="${currentPage + 1 <= pageList.size()}">
						<li class="page-item">
							<a class="page-link" href="./locs?page=${currentPage + 1}">Next</a>
						</li>
					</c:if>
				</ul>
			</div>
		</c:if>
</section>
</body>
</html>