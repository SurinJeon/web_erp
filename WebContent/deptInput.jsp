<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 추가</title>
<link rel="stylesheet" href="css/dept_style.css">
</head>
<body>
	<form action="DeptInsertServlet">
		<div class="input">
			<h2>부서 추가</h2>
			<fieldset>
				<table>
					<tr>
						<td><label for="dNo">부서 번호: </label></td>
						<td><input type="text" id="dNo" name="dNo"></td>
					</tr>
					<tr>
						<td><label for="dName">부서 이름: </label></td>
						<td><input type="text" id="dName" name="dName"></td>
					</tr>

					<tr>
						<td><label for="dFloor">부서 층수: </label></td>
						<td><input type="text" id="dFloor" name="dFloor"></td>
					</tr>
				</table>
				<br> <input type="submit" value="추가"> <input type="reset" value="취소">
			</fieldset>
		</div>
	</form>
</body>
</html>