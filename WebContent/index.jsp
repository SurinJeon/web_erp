<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="web_erp.ds.JndiDS" %>

<c:set var="con" value="${JndiDS.getConnection() }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연동 테스트</title>
<link rel="stylesheet" href="css/index_style.css">
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="TitleListServlet">직책 관리</a></li>
			<li><a href="DeptListServlet">부서 관리 </a></li>
			<li><a href="EmpListServlet">사원 관리 </a></li>
		</ul>
	</div>
</body>
</html>