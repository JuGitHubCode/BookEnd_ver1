<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script defer src="./user/js/user_member.js"> </script>
<link rel='stylesheet' type='text/css' href='./user/css/user_member.css'>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<div id="findId">
	<h2>아이디 찾기</h2>
	<form name="frm_user_findId" id="frm_user_findId" method="post">
		<div class="certify">
			<button type="button" id="btnPhoneCertify">휴대폰 인증</button>
			<button type="button" id="btnEmailCertify">이메일 인증</button> <br/>
		</div>
		<div class="label_group">
			<label>이름</label> <br/>
			<input type="text" name="uName" class="find_uId_uName" placeholder="이름을 입력해주세요."> <br/>
			<span id="uNameValidation"></span>
		</div>
		<div class="label_group findUidPhone">
			<label>휴대폰</label> <br/>
			<input type="text" name="phone" class="find_uId_phone" placeholder="핸드폰 번호를 입력해주세요."> <br/>
			<span id="phoneValidation"></span>
		</div>
		<div class="label_group findUidEmail">
			<label>이메일</label> <br/>
			<input type="text" name="email" class="find_uId_email" placeholder="이메일을 입력해주세요."> <br/>
			<span id="emailValidation"></span>
		</div>
		<div class="btns">
			<button type="button" onclick="member.findPhone(this.form)" id="btnFindUid">아이디 찾기</button> <br/>
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