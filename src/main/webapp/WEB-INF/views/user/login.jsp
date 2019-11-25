<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login 화면</title>
</head>
<body>
	<form action="loginPost" method="post">
		<div>
			<input type="text" name="userid" placeholder="USER ID" />
		</div>
		<div>
			<input type="text" name="userpass" placeholder="Password" />
		</div>
		<div>
		<label>
			<input type="checkbox" name="useCookie">ID 저장
		</label>
		</div>
		<div>
		<button type="submit">로그인하기</button>
		</div>


	</form>


</body>
</html>