<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginOut</title>
</head>
<body>

	<div id="loginout">
		<form name="frm_log" class="frm_log" id="frm_log" method="post">
			
			<input type="hidden" name="mId" class="mId" value="${mId}" >
			<button type="button" id="btn_login" onclick="mgt.login()" style="display: inline-block">로그인</button>
			<output class="welcome">
			[${sessionScope.uName}]님 반갑습니다.
			</output>
			<button type="button" id="btn_logout" onclick="mgt.logout()">로그아웃</button>
		</form>
	</div>
<script src="../lib/jquery-3.6.0.min.js"></script>
<script defer src="../javascript/mgt_main.js"></script>
</body>
</html>