<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_mypage_info_update_form</title>

<!-- 다음 API 연결 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel='stylesheet' href='./user/css/user_mypage.css'>
<script defer src='./user/js/userMypage.js'></script>

</head>
<body>
	<div id='mypage_info_update'>
		<h2>회원정보 수정</h2>
		<label class='basicInfo'>기본 정보 입력</label>
		<hr/>
		<form name='frm_info_update' id='frm_info_update' method='post'>
		<input type='hidden' name='uId' id='uId' value='${param.uId}'/><br/>
		
			<div class='label_group'>
				<label>아이디</label>
				<input type='text' name='uId' id='uId' class='readonly' value='${vo.uId}' readonly/><br/>
				<span>※아이디는 변경이 불가합니다.</span><br/>
			</div>
				
			<div class='label_group'>
				<label>이름</label>
				<input type='text' name='uName' id='uName' class='readonly' value='${vo.uName}' readonly/><br/>
				<span>※이름 변경이 필요하신 경우, 고객센터로 문의하여 주세요.</span><br/>
			</div>
			
			<div class='label_group'>
				<label>이메일주소</label>
				<input type='text' name='email' id='email' value='${vo.email}' placeholder='예) bookend@naver.com'/><br/>
				<span id='emailValidation'></span>
				<input type='hidden' name='tempEmail' id='tempEmail' value='${vo.email}'/>
			</div>
			
			<div class='label_group'>	
				<label>휴대폰번호</label>
				<input type='text' name='phone' id='phone' value='${vo.phone}' placeholder='- 를 제외한 숫자만 입력해주세요.'/><br/>
				<span id='phoneValidation'></span>
				<input type='hidden' name='tempPhone' id='tempPhone' value='${vo.phone}'/>
			</div>
			
			<div class='label_group'>
				<label>우편번호</label>
				<input type='text' name='zipCode' id='zipCode' value='${vo.zipCode}' readonly/>
				<button type='button' id='btnZipFind'>우편번호 찾기</button><br/>
				<label>주소</label>
				<input type='text' name='address1' id='address1' value='${vo.address1}' readonly/><br/>
				<label>상세주소</label>
				<input type='text' name='address2' id='address2' value='${vo.address2}'/><br/>
			</div>
			
			<div class='label_group'>
				<label>성별</label>
				<label><input type='radio' name='gender' value='m'  ${(vo.gender=='m')?'checked':''}/>남자</label>
				<label><input type='radio' name='gender' value='f' ${(vo.gender=='f')?'checked':''}/>여자</label><br/>
			</div>
			
			<div class='label_group'>
				<label>생년월일</label>
				<input type='text' name='birth' id='birth' placeholder='예)19930919' value='${vo.birth}'/><br/>
				<span id="birthValidation"></span>
			</div>
				
			<div class='btns'>
				<button type='button' id='btnUpdateInfo' onclick='mypage.updateInfo(this.form)'>저장</button>
				<button type='button' id='btnCancel' onclick='mypage.toMainPage()'>취소</button><br/>
			</div>
		</form>
	</div>
</body>
</html>