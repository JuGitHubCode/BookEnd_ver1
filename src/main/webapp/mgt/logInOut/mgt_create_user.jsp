<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="createUser">
		<form name="frm_createUser" id="frm_createUser" class="frm_createUser" method="post">
			<span><input type="radio" name="type" id="type" value="i" onclick="us.type(this.value)">생성</span>
			<span><input type="radio" name="type" id="type" value="u" onclick="us.type(this.value)">갱신</span>
			<br>
			<div class="u" id="u"  style="display:none">
			<label>아이디</label>
			<!-- <input type="text" name="job" id="job" > -->
			<input type="text" name="uuId" id="uuId" >
			
			<button type="button" onclick="us.find()">검색</button>
			<div id="btn">
				<button type="button" onclick="us.save(this.form)">저장</button>
			</div>
			</div>
			<div class="i"  id="i" style="display:none">
			<label>아이디*</label>
			<input type="text" name="uId" id="uId">
			<br>
			<label>암호*</label>
			<input type="text" name="pwd" id="pwd">
			<br>
			<label>성명*</label>
			<input type="text" name="uName" id="uName">
			<br>
			<label>생년월일</label>
			<input type="date" name="birth" id="birth">
			<br>
			<label>번호*</label>
			<input type="text" name="phone" id="phone">
			<br>
			<label>이메일*</label>
			<input type="text" name="email" id="email">
			<br>
			<label>우편번호*</label>
			<input type="text" name="zipCode" id="zipCode">
			<button type="button" id="btnZipcode" onclick="us.zipFind()">검색</button>
			<br>
			<label>주소*</label>
			<input type="text" name="address1" id="address1">
			<br>
			<label>상세주소*</label>
			<input type="text" name="address2" id="address2">
			<br>
			<label>성별</label>
			<span><input type="radio" name="gender" id="gender" value="m">남</span>
			<span><input type="radio" name="gender" id="gender" value="f">여</span>
			<br>
			<label>가입일</label>
			<input type="date" name="joinDate" id="joinDate">
			<br>
			<label>직책</label>
			<input type="text" name="job" id="job">
			<div id="btn">
				<button type="button" onclick="us.save(this.form)">저장</button>
			</div>
			</div>
			
		</form>
	</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>