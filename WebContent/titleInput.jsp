<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직책 추가</title>
</head>
<body>
	<form action="TitleInsertServlet">
		<fieldset>
			<legend>직책 정보</legend>
			<table>
				<tr>
					<td><label for="tNo">직책 번호: </label></td>
					<td><input type="text" id="tNo" name="tNo"></td>
				</tr>
				<tr>
					<td><label for="tName">직책 이름: </label></td>
					<td><input type="text" id="tName" name="tName"></td>
				</tr>
			</table>
			<input type="submit" value="추가"> <input type="reset" value="취소">
		</fieldset>
	</form>
</body>
</html>