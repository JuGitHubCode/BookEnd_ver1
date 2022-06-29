<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script defer src="./user/js/user_member.js"> </script>
<link rel='stylesheet' type='text/css' href='./user/css/user_member.css'>
</head>
<body>
<div id="findPwd">
	<h2>비밀번호 찾기</h2>
	<form name="frm_user_findPwd" id="frm_user_findPwd" method="post">
		<div class="certify">
			이메일 인증
		</div>
		<div class="label_group">
			<label>아이디</label> <br/>
			<input type="text" name="uId" class="find_pwd_uId" placeholder="아이디를 입력해주세요."> <br/>
			<span id="uIdValidation"></span>
		</div>
		<div class="label_group findPwdEmail">
			<label>이메일</label> <br/>
			<input type="text" name="email" class="find_pwd_email" placeholder="이메일을 입력해주세요."> <br/>
			<span id="emailValidation"></span>
		</div>
		<div class="btns">
			<button type="button" onclick="member.findPwd(this.form)" id="btnFindPwd">확인</button> <br/>
			<button type="button" onclick="member.moveLogin()">취소</button>
		</div>
	</form>
</div>
</body>
<c:if test="${not empty msg }">
	<script>
		alert("${msg }");
	</script>
</c:if>
</html>