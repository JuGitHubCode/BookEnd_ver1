<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_mypage_pwd_update</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel='stylesheet' href='./user/css/user_mypage.css'>
<script defer src='./user/js/userMypage.js'></script>
</head>
<body>
	<div id='mypage_pwd_update'>
		<h2>비밀번호 변경</h2>
		<hr/>
		<form name='frm_pwd_update' id='frm_pwd_update' method='post'>
			<input type='hidden' name='uId' id='uId' value='${param.uId}'/>
			<input type='hidden' name='tempPwd' id='tempPwd' value='${vo.pwd}'/>
				
			<div class='label_group'>
				<label>기존 비밀번호</label>
				<input type='password' name='oldPwd' id='oldPwd' placeholder='기존 비밀번호를 입력해주세요.'><br/>
				<span id='checkOldPwd'></span><br/>
				<label>새 비밀번호</label>
				<input type='password' name='newPwd' id='newPwd' class='readonly' placeholder='8~16자 사이로 영문과 숫자를 조합' readonly/><br/>
				<span id='pwdValidation'></span><br/>
				<label>새 비밀번호 확인</label>
				<input type='password' name='pwdCheck' id='pwdCheck' class='readonly' placeholder='비밀번호를 한 번 더 입력해주세요.' readonly/><br/>
				<span id='pwdCheckValidation'></span>			
			</div>											 

			<div class='btns'>
				<button type='button' id='btnUpdatePwd' onclick='mypage.updatePwd(this.form)'>저장</button>
				<button type='button' id='btnCancel' onclick='mypage.toMainPage()'>취소</button><br/>
			</div>
		</form>
	</div>
</body>
</html>