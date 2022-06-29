<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script defer src="./user/js/user_member.js"> </script>
<link rel='stylesheet' type='text/css' href='./user/css/user_member.css'>
</head>
<body>
<c:if test="${not empty uId }">
	<div id="find_uId_result">
	<h4>고객님의 아이디를 찾았습니다.</h4>
	<span class="guide">아이디 확인 후 로그인해주세요.</span>
		<div class="result">
			<span>아이디 : ${uId } </span><br/>
			<button type="button" class="btnLoginPage" onclick="member.moveLogin()">로그인</button> <br/>
		</div>
	</div>
</c:if>

<c:if test="${not empty isEmail }">
	<div id="find_pwd_result">
	<h4>임시 비밀번호를 고객님의 이메일로 <br/>발송했습니다.</h4>
	<span class="guide">비밀번호 확인 후 복사하여 로그인해주세요.</span> <br/>
	<span class="guide">로그인 후 비밀번호를 꼭 변경해주세요.</span>
	<div class="result">
		<button type="button" class="btnLoginPage" onclick="member.moveLogin()">로그인</button> <br/>
	</div>
	</div>
</c:if>

</body>
</html>