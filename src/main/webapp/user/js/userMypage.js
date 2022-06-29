/**
 *  SCRIPT FOR MY PAGE
 */

let mypage = {};
mypage.phoneDuplication = true; // 핸드폰 번호가 중복이면 true
mypage.emailDuplication = true; // 이메일 주소가 중복이면 true

// job에 따라 관리자 페이지 바로가기 버튼 유무
mypage.init = function (uId, job){
	var IdCheck = document.getElementById('uId').value;
	var JobCheck = document.getElementById('job').value;
	
	if(IdCheck != "" && JobCheck == "a"){
		$('.button3').css('display', '');
	}else{
		$('.button3').css('display', 'none');
	}
}

// 모든 곳에 엔터치면 폼 submit하는 함수
function enterKey(b){
	if(window.event.keyCode == 13){
		b.click();
	}
}

// 주문내역 조회 화면으로
mypage.toPrevPage = function(){
	location.href = 'index_main.jsp?inc=./user/mypage/user_mypage_orderList.jsp';
}

// 마이페이지 메인 화면으로
mypage.toMainPage = function(){
	location.href = 'index_main.jsp?inc=./user/mypage/user_mypage_main.jsp';
}

// 홈화면(index)으로
mypage.toIndexPage = function(){
	location.href = 'index_main.jsp';
}

// 관리자 페이지로
mypage.toAdminPage = function(frm){
	frm.action = './mypage.do?job=toAdminPage';
	frm.submit();
}


/* ----- 회원정보 수정 페이지 ----- */


// 마이페이지 메인화면에서 회원정보 수정 클릭시 id 넘겨서 값 받아오기
mypage.selectOneInfo = function(frm){
	frm.action = './mypage.do?job=selectOneInfo';
	frm.submit();
}

// 회원정보 수정 (수정 페이지에서 저장 버튼 누를 때)
mypage.updateInfo = function(frm){
	let email = frm.email.value;
	let phone = frm.phone.value;
	let birth = frm.birth.value;
	
	if(!isEmail(email)) {
		alert("이메일 확인 후 다시 입력해주세요.");
		return;
	} else if(!isPhone(phone)) {
		alert("휴대폰번호 확인 후 다시 입력해주세요.");
		return;
	} else if(!isBirth(birth)) {
		alert("생년월일 확인 후 다시 입력해주세요.");
		return;
	} else if(mypage.phoneDuplication){	
		alert("중복된 휴대폰 번호가 존재합니다. 확인 후 다시 입력해주세요.");
	} else if(mypage.emailDuplication){
		alert("중복된 이메일 주소가 존재합니다. 확인 후 다시 입력해주세요.");
	} else {
		alert("회원정보가 수정되었습니다.");
		let param = $(frm).serialize();
		$.post("./mypage.do?job=updateInfo", param, function(){
			location.href="index_main.jsp?inc=./user/mypage/user_mypage_main.jsp";
		})
	}
}

// 우편번호 검색
var btnZipFind = document.getElementById('btnZipFind');
if(btnZipFind != null){	
	btnZipFind.onclick = function(){
		new daum.Postcode({
			oncomplete : function(data){
				let frm = document.frm_info_update;
				frm.zipCode.value = data.zonecode;
				frm.address1.value = data.address;
			}
		}).open();
	}
}

// 재입력 요청
$("#email").on("blur", function(){
	let email = $(this).val();
	let param = $("#frm_info_update").serialize();
	let tempEmail = $("#tempEmail").val();
	
	if(!isEmail(email)){
		$("#emailValidation").text("이메일 주소를 다시 확인해주세요.")
	} else {
		$.ajax({
	        url: "./mypage.do?job=emailValidation",
	        type: "POST",
	        cache: false,
	        data: param, // data에 바로 serialze한 데이터를 넣음.
	        success: function(resp){
				console.log(resp)
		        if(resp == tempEmail){
					$("#emailValidation").text("");
					mypage.emailDuplication = false;
				}else if(resp == 'null'){
		        	$("#emailValidation").text("사용 가능한 이메일 주소입니다.");
		           $("#emailValidation").css("color", "#00B700")
		           mypage.emailDuplication = false;
		        } else {
		           $("#emailValidation").text("중복된 이메일 주소입니다.");
		        	$("#emailValidation").css("color", "#dd3115");
		        	mypage.emailDuplication = true;
	            }
   	 		}
      })
	}
})

$("#phone").on("blur", function(){
	let phone = $(this).val();
	let param = $("#frm_info_update").serialize();
	let tempPhone = $("#tempPhone").val();
	
	if(!isPhone(phone)){
		$("#phoneValidation").text("휴대폰 번호를 다시 확인해주세요.")
	} else {
		$.ajax({
	        url: "./mypage.do?job=phoneValidation",
	        type: "POST",
	        cache: false,
	        data: param, // data에 바로 serialze한 데이터를 넣음.
	        success: function(resp){
		        if(resp == tempPhone){
					$("#phoneValidation").text("");
					mypage.phoneDuplication = false;
				}else if(resp == 'null'){
		        	$("#phoneValidation").text("사용 가능한 휴대폰 번호입니다.");
		       		$("#phoneValidation").css("color", "#00B700")
		           mypage.phoneDuplication = false;
		        } else {
		         	$("#phoneValidation").text("중복된 휴대폰 번호입니다.");
		        	$("#phoneValidation").css("color", "#dd3115");
		        	mypage.phoneDuplication = true;
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

// 정규식으로 유효성 검사
function isEmail(email){
	let emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;	
	return emailRegExp.test(email)
}
function isPhone(phone){
	let phoneRegExp = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/; 	
	return phoneRegExp.test(phone)
}

// 생년월일 검사
function isBirth(birth) {
	var year = Number(birth.substr(0,4)); // 입력한 값의 0~4자리까지 (연)
	var month = Number(birth.substr(4,2)); // 입력한 값의 4번째 자리부터 2자리 숫자 (월)
	var day = Number(birth.substr(6,2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일)
	var today = new Date(); // 날짜 변수 선언
	var yearNow = today.getFullYear(); // 올해 연도 가져옴

	if (birth.length <=8) {
		if (1900 > year || year > yearNow){ // 연도의 경우 1900 보다 작거나 yearNow 보다 크다면 false를 반환
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


/* ----- 비밀번호 변경 ----- */


// 마이페이지 메인화면에서 비밀번호 변경 클릭시 id 넘겨서 비밀번호 값 받아오기
mypage.selectOnePwd = function(frm){
	frm.action = './mypage.do?job=selectOnePwd';
	frm.submit();
}

// 비밀번호 변경 (변경 페이지에서 저장 버튼 누를 때)
mypage.updatePwd = function(frm){
	let pwd = frm.newPwd.value;
	if(!isPwd(pwd)) {
		alert("비밀번호 확인 후 다시 입력해주세요.");
		return;
	} else if(isPwd(pwd)){
		alert("비밀번호가 수정되었습니다.");
		let param = $(frm).serialize();
		$.post("./mypage.do?job=updatePwd", param, function(){
			location.href="index_main.jsp?inc=./user/mypage/user_mypage_main.jsp";
		})
	}
}

// 기존 비밀번호 확인
$("#oldPwd").on("blur", function(){
	//let oldPwd = $(this).val();
	let param = $("#frm_pwd_update").serialize();
	let tempPwd = $("#tempPwd").val();
	
	$.ajax({
		url: "./mypage.do?job=pwdValidation",
		type: "POST",
		cache: false,
		data: param,
		success: function(resp){
			console.log(resp)
			if(resp == tempPwd){
				$("#checkOldPwd").text("비밀번호가 일치합니다. 하단에 새 비밀번호를 입력해주세요.");
				$("#checkOldPwd").css("color", "#00B700");
				$("#oldPwd").css("border", "1px solid #00B700");
				$("#oldPwd").css("box-shadow", "0 0 2px #00B700");
				$("#newPwd").attr("readonly",false);
				$("#pwdCheck").attr("readonly",false);
				$("#newPwd").css("background-color", "#fff");
				$("#pwdCheck").css("background-color", "#fff");
				$("#newPwd").css("color", "#000");
				$("#pwdCheck").css("color", "#000");
			} else if(resp != tempPwd){
				$("#checkOldPwd").text("비밀번호가 일치하지 않습니다. 비밀번호를 변경하실 수 없습니다.");
				$("#checkOldPwd").css("color", "#dd3115");
				$("#oldPwd").css("border", "1px solid #dd3115");
				$("#oldPwd").css("box-shadow", "0 0 2px #dd3115");
				$("#newPwd").attr("readonly",true);
				$("#pwdCheck").attr("readonly",true);
				$("#newPwd").css("background-color", "#fec156");
				$("#newPwd").css("color", "#fff");
				$("#pwdCheck").css("background-color", "#fec156");
				$("#pwdCheck").css("color", "#fff");
			} else {
				$("#checkOldPwd").text("");
			}
		}
	})
})

// 정규식으로 유효성 검사
function isPwd(pwd){
	let pwdRegExp = /^[A-Za-z0-9]{8,16}$/; 	// 대소문자 영어,숫자 8~16자리
	return pwdRegExp.test(pwd);
}

// 새 비밀번호 재입력 요청
$("#newPwd").on("blur", function(){
	let pwd = $(this).val();
	
	if(!isPwd(pwd)){
		$("#pwdValidation").text("대소문자 영어, 숫자를 사용하여 8~16자리로 입력해주세요.")
	} else{
		$("#pwdValidation").text("")
	}
})

// 새 비밀번호 확인 재입력 요청
$("#pwdCheck").on("keyup", function(){
	if($("#newPwd").val() != $("#pwdCheck").val()){
		$("#pwdCheckValidation").text("입력하신 비밀번호와 다릅니다. 비밀번호를 확인 후 다시 입력해주세요.");
		document.getElementById('btnUpdatePwd').disabled=true;
		$('#btnUpdatePwd').css('cursor','not-allowed');
	}else if($("#newPwd").val() == $("#pwdCheck").val()){
		$("#pwdCheckValidation").text("");
		document.getElementById('btnUpdatePwd').disabled=false;
		$('#btnUpdatePwd').css('cursor','pointer');
	}else {
		$("#pwdCheckValidation").text("");
		document.getElementById('btnUpdatePwd').disabled=false;
		$('#btnUpdatePwd').css('cursor','pointer');
	}
})


/* ----- 주문정보 조회 ----- */


// 마이페이지 메인화면에서 주문정보 조회 클릭시 id 넘겨서 값 받아오기
mypage.selectOrder = function(frm){
	let uId = frm.uId.value;
	frm.uId.value = uId;
	frm.action = './mypage.do?job=selectOrder';
	frm.submit();
}

// 조회
mypage.select = function(frm){
	frm.action = './mypage.do?job=selectOrder'; 
	frm.submit();
}

// 주문내역 상세보기 페이지로 이동
mypage.viewOrderDetail = function(index){
	let frm = $('.frm_order_list')[0];
	//let orderNo = frm.orderNo.value;
	let orderNumbers = document.querySelectorAll(".orderNo1");
	frm.orderNum.value = orderNumbers[index].value;
	frm.action = './mypage.do?job=viewOrderDetail';
	frm.submit();
}