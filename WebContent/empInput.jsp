<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 추가</title>
</head>
<body>
<form action="EmpInsertServlet">
		<fieldset>
			<legend>사원 정보</legend>
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
					<td><input type="text" id="title" name="title"></td>
				</tr>
				
				<tr>
					<td><label for="manager">직속상사: </label></td>
					<td><input type="text" id="manager" name="manager"></td>
				</tr>
				
				<tr>
					<td><label for="salary">월급: </label></td>
					<td><input type="text" id="salary" name="salary"></td>
				</tr>
				
				<tr>
					<td><label for="dept">부서명: </label></td>
					<td><input type="text" id="dept" name="dept"></td>
				</tr>
			</table>
			<input type="submit" value="추가"> <input type="reset" value="취소">
		</fieldset>
	</form>

</body>
</html>