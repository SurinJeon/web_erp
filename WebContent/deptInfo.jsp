<%@page import="web_erp.dto.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Department dept = (Department)request.getAttribute("dept");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 목록 정보</title>
</head>
<body>
	<form action="DeptUpdateServlet?dNo=${dept.no }">
		<table>

			<tr>
				<td><label for="dNo">부서 번호: </label></td>
				<td><input type="text" id="dNo" name="dNo" value="${dept.no }" readonly="readonly"></td>
			</tr>
			<tr>
				<td><label for="dName">부서 이름: </label></td>
				<td><input type="text" id="dName" name="dName" value="${dept.name }"></td>
			</tr>
			
			<tr>
				<td><label for="dFloor">부서 층수: </label></td>
				<td><input type="text" id="dFloor" name="dFloor" value="${dept.floor }"></td>
			</tr>
		</table>

		<br>
		<button>부서 수정</button>
	</form>


	<a href="DeptdeleteServlet?dNo=${dept.no }">
		<button>직책 삭제</button>
	</a>
</body>
</html>