/* 회원가입 */

member = {};
member.uIdDuplication = true;	// true면 중복
member.emailDuplication = true;
member.phoneDuplication = true;

// 로그인 페이지
member.moveFindUid = function(){
	location.href = "index_main.jsp?inc=user/member/user_member_find_uId.jsp";
}
//location.href = "index.jsp?inc=user_member_find_uId.jsp";

member.moveFindPwd = function(){
	location.href = "index_main.jsp?inc=user/member/user_member_find_pwd.jsp";
}

member.moveJoin = function(){
	location.href = "index_main.jsp?inc=user/member/user_member_join.jsp";
}

member.moveLogin = function(){
	location.href = "index_main.jsp?inc=user/member/user_member_login.jsp";
}

member.login = function(frm){
	let param = $(frm).serialize();
	$.post("./userMember.do?job=memberLogin", param, function(){
		location.href = "index_main.jsp?inc=./temp.jsp";
	});
}	

// 아이디 찾기 페이지

//아이디 찾기 버튼에 따라 항목 보여주기
$("#btnPhoneCertify").on("click", function(){
	$(".findUidPhone").css("display", "block");
	$(".findUidEmail").css("display", "none");
	$(this).css("border-bottom", "2px solid #fec156");
	$("#btnEmailCertify").css("border-bottom", "none");
	$("#uName").val("")
	$("#email").val("")
	$("#uNameValidation").text("")
	$("#emailValidation").text("")
	$("#btnFindUid").attr("onclick", "member.findPhone(this.form)");
})
$("#btnEmailCertify").on("click", function(){
	$(".findUidPhone").css("display", "none");
	$(".findUidEmail").css("display", "block");
	$(this).css("border-bottom", "2px solid #fec156");
	$("#btnPhoneCertify").css("border-bottom", "none");
	$("#uName").val("")
	$("#phone").val("")
	$("#uNameValidation").text("")
	$("#phoneValidation").text("")
	$("#btnFindUid").attr("onclick", "member.findEmail(this.form)");
})

$(".find_uId_uName").on("blur", function(){
	let uName = $(this).val();	

	if(!isUname(uName)){
		$("#uNameValidation").text("한글 2~6자리의 이름을 입력해주세요.")
	} else{
		$("#uNameValidation").text("")
	}
})

$(".find_uId_phone").on("blur", function(){
	let email = $(this).val();
	
	if(!isEmail(email)){
		$("#emailValidation").text("이메일을 정확하게 입력해주세요.")
	} else{
		$("#emailValidation").text("")
	}
})

$(".find_uId_phone").on("blur", function(){
	let phone = $(this).val();
	
	if(!isPhone(phone)){
		$("#phoneValidation").text("휴대폰 번호를 다시 확인해주세요.")
	} else{
		$("#phoneValidation").text("")
	}
})

member.findPhone = function(frm){
	frm.action = "./userMember.do?job=memberFindPhone";
	frm.submit();
}

member.findEmail = function(frm){
	frm.action = "./userMember.do?job=memberFindEmail";
	frm.submit();
}

// 비밀번호 찾기 
$(".find_pwd_uId").on("blur", function(){
	let uId = $(this).val();	

	if(!isUid(uId)){
		$("#uIdValidation").text("영어 소문자, 숫자를 사용하여 6~12자리로 입력해주세요.")
	} else{
		$("#uIdValidation").text("")
	}
})

$(".find_pwd_email").on("blur", function(){
	let email = $(this).val();
	
	if(!isEmail(email)){
		$("#emailValidation").text("이메일을 정확하게 입력해주세요.")
	} else{
		$("#emailValidation").text("")
	}
})

member.findPwd = function(frm){
	frm.action = "./userMember.do?job=memberTempPwd";
	frm.submit();
}

// 회원가입 페이지
member.join = function(frm){
	let uId = frm.uId.value;
	let pwd = frm.pwd.value;
	let uName = frm.uName.value;
	let email = frm.email.value;
	let phone = frm.phone.value;
	let birth = frm.birth.value;
		
	if(!isUid(uId)) {
		alert("아이디를 확인해주세요.");
		return
	} else if(!isPwd(pwd)) {
		alert("비밀번호를 확인해주세요.");
		return
	} else if(!isUname(uName)) {
		alert("이름을 확인해주세요.");
		return
	} else if(!isEmail(email)) {
		alert("이메일을 확인해주세요.");
		return
	} else if(!isPhone(phone)) {
		alert("휴대폰 번호를 확인해주세요.");
		return
	} else if(!isBirth(birth)) {
		alert("생년월일을 확인해주세요.");
		return
	} else if(member.uIdDuplication || member.emailDuplication ||
			  member.phoneDuplication){
		alert("중복된 입력 사항이 있습니다. 확인해주세요");
	} else {
		frm.action = "./userMember.do?job=memberJoin";
		frm.submit();
	}
}

// 우편번호 검색
member.findZipcode = function(){
	let frm = document.frm_user_join;
	
	new daum.Postcode({
		oncomplete: function(data) {
			frm.zipCode.value = data.zonecode;
			frm.address1.value = data.address;
		}
   	}).open();
}

$("#uId").on("blur", function(){
	let uId = $(this).val();
	let param = $("#frm_user_join").serialize();

	if(!isUid(uId)){
		$("#uIdValidation").text("영어 소문자, 숫자를 사용하여 6~12자리로 입력해주세요.")
	} else {
		// 중복 테스트
		$.ajax({
			url: "./userMember.do?job=memberUidValidation",
            type: "POST",
            cache: false,
            data: param, // data에 바로 serialze한 데이터를 넣는다.
            success: function(resp){
				if(resp=='validation'){
					$("#uIdValidation").text("중복된 아이디입니다.");
					$("#uIdValidation").css("color", "#dd3115")
					member.uIdDuplication = true;
				} else {
					$("#uIdValidation").text("사용가능한 아이디입니다.");
					$("#uIdValidation").css("color", "#00B700")
					member.uIdDuplication = false;
       			}
            }
		})
	}
})

$("#pwd").on("blur", function(){
	let pwd = $(this).val();
	
	if(!isPwd(pwd)){
		$("#pwdValidation").text("대소문자 영어, 숫자를 사용하여 8~16자리로 입력해주세요.")
	} else{
		$("#pwdValidation").text("")
	}
})

$("#uName").on("blur", function(){
	let uName = $(this).val();	

	if(!isUname(uName)){
		$("#uNameValidation").text("한글 2~6자리의 이름을 입력해주세요.")
	} else{
		$("#uNameValidation").text("")
	}
})
$("#email").on("blur", function(){
	let email = $(this).val();
	let param = $("#frm_user_join").serialize();
	
	if(!isEmail(email)){
		$("#emailValidation").text("이메일을 정확하게 입력해주세요.")
	} else{
		// 중복 테스트
		$.ajax({
			url: "./userMember.do?job=memberEmailValidation",
            type: "POST",
            cache: false,
            data: param, // data에 바로 serialze한 데이터를 넣는다.
            success: function(resp){
				if(resp=='validation'){
					$("#emailValidation").text("중복된 이메일입니다.");
					$("#emailValidation").css("color", "#dd3115");
					member.emailDuplication = true;
				} else {
					$("#emailValidation").text("사용가능한 이메일입니다.");
					$("#emailValidation").css("color", "#00B700")
					member.emailDuplication = false;
       			}
            }
		})
	}
})

$("#phone").on("blur", function(){
	let phone = $(this).val();
	let param = $("#frm_user_join").serialize();

	if(!isPhone(phone)){
		$("#phoneValidation").text("휴대폰 번호를 다시 확인해주세요.")
	} else {
		// 중복 테스트
		$.ajax({
			url: "./userMember.do?job=memberPhoneValidation",
            type: "POST",
            cache: false,
            data: param, // data에 바로 serialze한 데이터를 넣는다.
            success: function(resp){
				if(resp == 'validation'){
					$("#phoneValidation").text("중복된 휴대폰 번호입니다.");
					$("#phoneValidation").css("color", "#dd3115")
					member.phoneDuplication = true;
				} else {
					$("#phoneValidation").text("사용가능한 휴대폰 번호입니다.");
					$("#phoneValidation").css("color", "#00B700")
					member.phoneDuplication = false;
       			}
            }
		})
	}
})

$("#birth").on("blur", function(){
	let birth = $(this).val();
	
	if(!isBirth(birth)){
		$("#birthValidation").text("생년월일을 다시 확인해주세요.");
	} else {
		$("#birthValidation").text("");
	}
})

$("#pwdCheck").on("keyup", function(){
	if($("#pwd").val() != $("#pwdCheck").val()){
		$("#pwdCheckValidation").text("비밀번호를 확인해주세요");
	} else{
		$("#pwdCheckValidation").text("");
	}
})

// 정규식으로 유효성 검사
function isUid(uId){
	let uidRegExp = /^[a-z0-9]{6,12}$/;		// a~z,0~9를 포함한 6~12자리
	return uidRegExp.test(uId);
}

function isPwd(pwd){
	let pwdRegExp = /^(?=.*\d)(?=.*[A-Za-z]).{8,16}$/; 	// 대소문자 영어,숫자 1자리 이상 8~16자리
	return pwdRegExp.test(pwd);
} 

function isUname(uName){
	let uNameRegExp = /^[가-힣]{2,6}$/;	// 이름 2 ~ 6 자리
	return uNameRegExp.test(uName);
}

function isEmail(email){
	let emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;	
	return emailRegExp.test(email)
}

function isPhone(phone){
	let phoneRegExp = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/; 	
	return phoneRegExp.test(phone)
}

// 생년월일검사
function isBirth(birth) {
	var year = Number(birth.substr(0,4)); // 입력한 값의 0~4자리까지 (연)
	var month = Number(birth.substr(4,2)); // 입력한 값의 4번째 자리부터 2자리 숫자 (월)
	var day = Number(birth.substr(6,2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일)
	var today = new Date(); // 날짜 변수 선언
	var yearNow = today.getFullYear(); // 올해 연도 가져옴

	if (birth.length <=8) {
		if (1900 > year || year > yearNow){ // 연도의 경우 1900 보다 작거나 yearNow 보다 크다면 false를 반환합니다.
			return false;
		} else if (month < 1 || month > 12) {
			return false;
		} else if (day < 1 || day > 31) {
			return false;
		} else if ((month==4 || month==6 || month==9 || month==11) && day==31) {
			return false;
		} else if (month == 2) {
			var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)); //윤년
			if (day>29 || (day==29 && !isleap)) {
				return false;
			} else {
				return true;
			} //end of if (day>29 || (day==29 && !isleap))
		} else {
			return true;
		}
	}
	else {
		return false; // 입력된 생년월일이 8자 초과
	}
}
