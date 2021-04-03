<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
</head>
<body>
	<h2>사원 목록</h2>
	<table border="1">
		<thead>
			<td>사원번호</td>
			<td>사원명</td>
			<td>직책명</td>
			<td>직속상사</td>
			<td>월급</td>
			<td>부서명</td>
			
		</thead>
		<tbody>
			<c:forEach var="emp" items="${list }">
				<tr>
					<td>${emp.no }</td>
					<td><a href="EmpGetServlet?eNo=${emp.no }"> ${emp.name}</a></td>
					<td>${emp.title.name }</td>
					<td>${emp.manager.name }</td>
					<td>${emp.salary }</td>
					<td>${emp.dept.name }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6"><a href="empInput.jsp">사원 추가</a></td>
			</tr>
		</tfoot>
	</table>

</body>
</html>