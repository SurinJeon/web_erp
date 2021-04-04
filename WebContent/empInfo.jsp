<%@page import="web_erp.dto.Department"%>
<%@page import="web_erp.service.DeptService"%>
<%@page import="web_erp.dto.Title"%>
<%@page import="java.util.List"%>
<%@page import="web_erp.service.TitleService"%>
<%@page import="web_erp.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록 정보</title>
<link rel="stylesheet" href="css/emp_style.css">
</head>
<body>
<c:set var="emp" value='<%=request.getAttribute("emp") %>'/>
<c:set var="tList" value='<%=request.getAttribute("tList") %>'/>
	<c:set var="dList" value='<%=request.getAttribute("dList")%>' />
	<form action="EmpUpdateServlet?eNo=${emp.no }">
		<div class="info">
			<h2>사원 정보</h2>
			<fieldset>
				<table>

					<tr>
						<td><label for="eNo">사원 번호: </label></td>
						<td><input type="text" id="eNo" name="eNo" value="${emp.no }" readonly="readonly"></td>
					</tr>
					<tr>
						<td><label for="eName">사원명: </label></td>
						<td><input type="text" id="eName" name="eName" value="${emp.name }"></td>
					</tr>

					<tr>
						<td><label for="title">직책명: </label></td>
						<td><select size="1" id="title" name="title">
								<c:forEach var="i" begin="0" end="${tList.size() - 1}">
									<c:choose>
										<c:when test="${emp.title.name eq tList.get(i).name }">
											<option value=${tList.get(i).name } selected="selected">${tList.get(i).name }</option>
										</c:when>
										<c:otherwise>
											<option value=${tList.get(i).name }>${tList.get(i).name }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>

					<tr>
						<td><label for="manager">직속상사: </label></td>
						<td><input type="text" id="manager" name="manager" value="${emp.manager.name }"></td>
					</tr>

					<tr>
						<td><label for="salary">월급: </label></td>
						<td><input type="text" id="salary" name="salary" value="${emp.salary }"></td>
					</tr>

					<tr>
						<td><label for="dept">부서명: </label></td>
						<td><select size="1" id="dept" name="dept">
								<c:forEach var="i" begin="0" end="${dList.size() - 1}">
									<c:choose>
										<c:when test="${emp.dept.name eq dList.get(i).name }">
											<option value=${dList.get(i).name } selected="selected">${dList.get(i).name }</option>
										</c:when>
										<c:otherwise>
											<option value=${dList.get(i).name }>${dList.get(i).name }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
				</table>

				<br>
				<button>사원 수정</button>
				<button>
					<a href="EmpdeleteServlet?eNo=${emp.no }">사원 삭제</a>
				</button>
				</fieldset>
		</div>
	</form>
</body>
</html>