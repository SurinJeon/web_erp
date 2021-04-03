<%@page import="web_erp.dto.Title"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	Title title = (Title)request.getAttribute("title");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직책 목록 정보</title>
</head>
<body>
<form action="TitleUpdateServlet?titleNo=${title.no }">
	<table>
	
		<tr>
			<td><label for="tNo">직책 번호: </label></td>
			<td><input type="text" id="tNo" name="tNo" value="${title.no }" readonly="readonly"></td>
		</tr>
		<tr>
			<td><label for="tName">직책 이름: </label></td>
			<td>
				<input type="text" id="tName" name="tName" value="${title.name }">
			</td>
			
			
		</tr>
	</table>

	<br>
	<button>직책 수정</button>
</form>

	
	<a href="TitleDeleteServlet?tNo=${title.no }"> <button>직책 삭제</button></a>
</body>
</html>