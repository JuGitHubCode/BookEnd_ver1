<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<!-- 다음 API 연결 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script defer src="./user/js/user_member.js"> </script>
<link rel='stylesheet' type='text/css' href='./user/css/user_member.css'>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<div id="join">
	<h2>회원가입</h2>
	<form name="frm_user_join" id="frm_user_join" method="post">
		<div class="label_group">
			<label>ID</label> <input type="text" name="uId" id="uId" placeholder="6~12자 사이로 소문자영문과 숫자를 조합"> <br/>
			<span id="uIdValidation"></span>
		</div>
		<div class="label_group">
			<label>비밀번호</label> <input type="password" name="pwd" id="pwd" placeholder="8~16자 사이로 영문과 숫자를 조합"> <br/>
			<span id="pwdValidation"> </span> <br/>
			<label>비밀번호확인</label> <input type="password" name="pwdCheck" id="pwdCheck" placeholder="비밀번호를 한 번 더 입력해주세요."><br/>
			<span id="pwdCheckValidation"> </span>
		</div>		
		<div class="label_group">
			<label>이름</label> <input type="text" name="uName" id="uName" placeholder="이름을 입력해주세요."> <br/>
			<span id="uNameValidation"></span>
		</div>		
		<div class="label_group">
			<label>이메일</label> <input type="text" name="email" id="email" placeholder="예) bookend@naver.com"> <br/>
			<span id="emailValidation"></span>
		</div>		
		<div class="label_group">
			<label>휴대폰</label> <input type="text" name="phone" id="phone" placeholder="- 를 제외한 숫자만 입력해주세요."> <br/>
			<span id="phoneValidation"></span>
		</div>		
		<div class="label_group">
			<label>우편번호</label> <input type="text" name="zipCode" readonly> 
			<button type="button" id="btnFindZipcode" onclick="member.findZipcode()">우편번호 찾기</button> <br/>
			<label>주소</label> <input type="text" name="address1" readonly> <br/>
			<label>상세주소</label> <input type="text" name="address2"> 
		</div>
		<div class="label_group">
			<label>성별</label> 
			<label><input type="radio" name="gender" value="m">남자</label>
			<label><input type="radio" name="gender" value="f">여자</label> <br/>
		</div>
		<div class="label_group">
			<label>생년월일</label> <input type="text" id="birth" name="birth" placeholder="예)19990303"> <br/>
			<span id="birthValidation"></span>
		</div>
		<div class="btns">
			<button type="button" id="btnJoin" onclick="member.join(this.form)">가입하기</button> <br/>
			<button type="button" onclick="member.moveLogin()">취소</button>
		</div>
	</form>
</div>
</body>
</html>