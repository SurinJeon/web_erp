<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직책 목록</title>
<link rel="stylesheet" href="css/title_style.css">
</head>
<body>
	<%-- ${list } <!-- 자동으로 attribute에 있는 값 찾아서 가지고 옴 --> --%>
	<div class="list">
	<h2>직책 목록</h2>
		<table>
			<thead>
				<td>직책번호</td>
				<td>직책명</td>
			</thead>
			<tbody>
				<c:forEach var="title" items="${list }">
					<tr>
						<td>${title.no }</td>
						<td><a href="TitleGetServlet?titleNo=${title.no }"> ${title.name }</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><a href="titleInput.jsp"><button>직책 추가</button></a></td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>