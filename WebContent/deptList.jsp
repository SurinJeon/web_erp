<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 목록</title>
</head>
<body>
	<h2>부서 목록</h2>
	<table border="1">
		<thead>
			<td>부서번호</td>
			<td>부서명</td>
			<td>부서 층수</td>
		</thead>
		<tbody>
			<c:forEach var="dept" items="${list }">
				<tr>
					<td>${dept.no }</td>
					<td><a href="DeptGetServlet?deptNo=${dept.no }"> ${dept.name}</a></td>
					<td>${dept.floor }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3"><a href="deptInput.jsp">부서 추가</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>