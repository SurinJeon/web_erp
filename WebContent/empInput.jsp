<%@page import="web_erp.dto.Employee"%>
<%@page import="web_erp.service.EmpService"%>
<%@page import="web_erp.dto.Department"%>
<%@page import="web_erp.service.DeptService"%>
<%@page import="web_erp.dto.Title"%>
<%@page import="java.util.List"%>
<%@page import="web_erp.service.TitleService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	EmpService empService = new EmpService();
	List<Employee> eList = empService.showEmps();
	TitleService titleService = new TitleService();
	List<Title> tList = titleService.showTitles();
	DeptService deptService = new DeptService();
	List<Department> dList = deptService.showDepts();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 추가</title>
<link rel="stylesheet" href="css/emp_style.css">
</head>
<body>
	<c:set var="eList" value="<%=eList%>" />
	<c:set var="tList" value="<%=tList%>" />
	<c:set var="dList" value="<%=dList%>" />
	<form action="EmpInsertServlet">
		<div class="input">
			<h2>사원 추가</h2>
			<fieldset>
				<table>
					<tr>
						<td><label for="eNo">사원 번호: </label></td>
						<td><input type="text" id="eNo" name="eNo"></td>
					</tr>
					<tr>
						<td><label for="eName">사원명: </label></td>
						<td><input type="text" id="eName" name="eName"></td>
					</tr>

					<tr>
						<td><label for="title">직책명: </label></td>
						<td><select size="1" id="title" name="title">
						<option value=""></option>
								<c:forEach var="i" begin="0" end="${tList.size() - 1}">
									<option value=${tList.get(i).name }>${tList.get(i).name }</option>
								</c:forEach>
						</select></td>
					</tr>

					<tr>
						<td><label for="manager">직속상사: </label></td>
							<td><select size="1" id="manager" name="manager">
								<option value=""></option>
								<c:forEach var="i" begin="0" end="${eList.size() - 1}">
									<option value=${eList.get(i).name }>${eList.get(i).name }</option>
								</c:forEach>
						</select></td>
						
					</tr>

					<tr>
						<td><label for="salary">월급: </label></td>
						<td><input type="text" id="salary" name="salary"></td>
					</tr>

					<tr>
						<td><label for="dept">부서명: </label></td>
						<td><select size="1" id="dept" name="dept">
						<option value=""></option>
								<c:forEach var="i" begin="0" end="${dList.size() - 1}">
									<option value=${dList.get(i).name }>${dList.get(i).name }</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
				<input type="submit" value="추가"> <input type="reset" value="취소">
			</fieldset>
		</div>
	</form>

</body>
</html>