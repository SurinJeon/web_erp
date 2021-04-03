<%@page import="web_erp.dto.Department"%>
<%@page import="web_erp.service.DeptService"%>
<%@page import="web_erp.dto.Title"%>
<%@page import="java.util.List"%>
<%@page import="web_erp.service.TitleService"%>
<%@page import="web_erp.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Employee emp = (Employee)request.getAttribute("emp");
	TitleService service = new TitleService();
	List<Title> list = service.showTitles();
	DeptService service2 = new DeptService();
	List<Department> list2 = service2.showDepts();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록 정보</title>
</head>
<body>
<c:set var="list" value="<%=list %>"/>
<c:set var="list2" value="<%=list2 %>"/>
	<form action="EmpUpdateServlet?eNo=${emp.no }">
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
						<c:forEach var="i" begin="0" end="${list.size() - 1}">
							<c:choose>
								<c:when test="${emp.title.name eq list.get(i).name }">
									<option value=${list.get(i).name } selected="selected">${list.get(i).name }</option>
								</c:when>
								<c:otherwise>
									<option value=${list.get(i).name }>${list.get(i).name }</option>
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
						<c:forEach var="i" begin="0" end="${list2.size() - 1}">
							<c:choose>
								<c:when test="${emp.dept.name eq list2.get(i).name }">
									<option value=${list2.get(i).name } selected="selected">${list2.get(i).name }</option>
								</c:when>
								<c:otherwise>
									<option value=${list2.get(i).name }>${list2.get(i).name }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>
		</table>

		<br>
		<button>사원 수정</button>
	</form>


	<a href="EmpdeleteServlet?eNo=${emp.no }">
		<button>사원 삭제</button>
	</a>

</body>
</html>