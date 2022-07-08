<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.*, dept.model.DeptDTO" %>    
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
<title>부서 조회 결과</title>
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
				<form action="./depts" method="get">
						<div class="input-form form-left">
							<button class="btn btn-outline" type="button" onclick="location.href='./depts/add'">추가</button>
						</div>
				 		<div class="input-form form-right">
				 			<input class="input-text" type="text" name="search"> <!--name에 deptId가 들어간다  -->
				 			<button class="btn btn-outline" type="submit">조회</button>
				 		</div>
				</form>
		</div>
	<table class="table wide vertical-hidden hover">
		<colgroup>
			<col class="col-60">
			<col class="col-auto">
			<col class="col-60">
			<col class="col-60">
			<col class="col-120">
		</colgroup>
		<thead>
			<tr class ="">
				<th>DeptId</th>
				<th>DeptName</th>
				<th>MngId</th>
				<th>LocId</th>
				<th class="border-hidden-right"></th>
			</tr>
		</thead>
		<tbody>
		<c:if test="${not empty datas}">
			<c:forEach items="${datas}" var="data">
				<tr>
					<td>${data.deptId}</td>
				    <td>${data.deptName}</td>
					<td>${data.mngId}</td>
					<td><a href="./locs?search=${data.locId }">${data.locId}</a></td>
					<td class="border-hidden-right">
						<button class="btn btn-icon" type="button" onclick="location.href='./depts/mod?id=${data.deptId }'">
							<span class="material-symbols-outlined">edit</span>
						</button>
						<button class="btn btn-icon" type="button" onclick="location.href='./depts/del?id=${data.deptId }'">
							<span class="material-symbols-outlined">delete</span>
						</button>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		</table>
		<c:if test="${not empty pageList}">
			<c:set var="currentPage" value="${page}" />
				<div class="paging">
				  <ul class="page center">
					<c:if test="${currentPage -1 > 0 }">
						<li class="page-item">
							<a class="page-link" href="./depts?page=${currentPage - 1 }">Prev</a>
						</li>
					</c:if>
					<c:set var="i" value="${currentPage - 1 }" />
					<c:set var="maxPage" value= "${i + 5 > pageList.size() ? pageList.size() : i + 5 }" />
					<c:forEach begin="${i}" end="${maxPage - 1}" var="num">
						<li class="page-item">
							<a class="page-link" href="./depts?page=${pageList.get(num)}">${pageList.get(num)}</a>
						</li>
					</c:forEach>
					<c:if test="${currentPage + 1 <= pageList.size()}">
						<li class="page-item">
							<a class="page-link" href="./depts?page=${currentPage + 1}">Next</a>
						</li>
					</c:if>
		 		   </ul>
			  </div>
		</c:if>
	</section>
</body>
</html>