/**
 * 
 */

let userSubPage = {};


// 카테고리
$(".menuBar").on("click", function(){
	$(".submenu").slideDown(500);
})
$(".menu").on("mouseleave", function(){
	$(".submenu").slideUp(500);
})




//로그인 체크하여 버튼 text 변환, 버튼 추가
//2022.06.18 - 관리자 모드 버튼도 추가할 것
var userChk = $('#userID').val();
if(userChk == "" || userChk == null){
	//console.log("*1*");
	$('.login').html("<img src='./user/icon/login.png' width='2%'/>");
	$('.login').val("login");
	$('.myPage').css("display", "none");
	$('.hid_myPage').css("display", "none");
	
	$('.hid_logo').css("display", "none");
	$('#top_main_menu_sub').css("display", "none");
} else {
	//console.log("*2*");
	$('.login').html("<img src='./user/icon/logout.png' width='1.9%'/>&nbsp;&nbsp;");
	$('.login').val("logout");
	$('.myPage').css("display", "");
	$('.hid_myPage').css("display", "");
	
	$('.hid_logo').css("display", "none");
	$('#top_main_menu_sub').css("display", "none");
}



//스크롤 위치에 따라 로고 show
window.addEventListener("scroll", (event) => {
    if(this.scrollY < 80){
		$('.hid_logo').css("display", "none");
		$('#top_main_menu_sub').css("display", "none");
	}else if(this.scrollY >= 80){
		$('.hid_logo').css("display", "");
		$('#top_main_menu_sub').css("display", "");
	}
});



//메인페이지
userSubPage.index = function(){
	frm.action='userSubPage.do?job=index';
	frm.submit();
}

//로그인
userSubPage.login = function(frm){
	var userChk = $('#userID').val();
	if(userChk == "" || userChk == null){
		location.href = 'index_main.jsp?inc=user/member/user_member_login.jsp';
	}else{
		frm.action='userMember.do?job=memberLogout';
		frm.submit();
	}
}

//마이페이지
userSubPage.myPage = function(frm){
	
	frm.action = "userSubPage.do?job=myPage";
	frm.submit();
}

//장바구니
userSubPage.cart = function(frm) {
	//로그인 확인
	var userChk = $('#userID').val();
	
	if(userChk == "" || userChk == null){
		alert("로그인이 필요한 페이지입니다.");
		location.href ='index_main.jsp?inc=user/member/user_member_login.jsp';
	}
	else{
		frm.action = "./cart.do?job=select";
		frm.submit();
	}
}
//장바구니 추가
userSubPage.cartR = function(frm){
	let str = $('.login').val();
	if(str == "login"){
		console.log("로그인이 하지 않은 상태");
		alert("장바구니를 사용할려면 로그인이 필요합니다!!");
		location.href ='index_main.jsp?inc=user/member/user_member_login.jsp';
	}
	else{
		let param = $(frm).serialize();
		$.post('userSubPage.do?job=cartR', param, function(b){
			if(b == "true"){
				alert("장바구니 추가 완료!!");
			}
			else{
				alert("장바구니 상태를 확인하세요.");
			}
		});
	}
}


//장바구니 limit Check
userSubPage.limitCheck = function(btnType){
	let limitCount = Number($('#bookEa').val());
	let statusCount = Number($('#bookEaStatus').val());
	
	if(btnType == "up"){
		//up
		let temp = statusCount + 1;
		
		if(temp > limitCount){
			alert("책 수량을 더 이상 추가 할 수 없습니다.");
		}else{
			$('.text_Ea').html(temp + " 권");
			$('#bookEaStatus').val(temp);
		}
	}else{
		//down
		let temp = statusCount - 1;
		
		if(temp == 0){
			alert("책 수량을 더 이상 제거 할 수 없습니다.");
		}else{
			$('.text_Ea').html(temp + " 권");
			$('#bookEaStatus').val(temp);
		}
		
	}
	
}


//카테고리 이동
userSubPage.category = function(frm, categoryType){
	frm.action='userSubPage.do?job=category&' + "cate=" + categoryType;
	frm.submit();
}
//카테고리_버튼이동
userSubPage.movePage_Category = function(page, categoryType){
	let frm = document.frm_item_list;
	frm.nowPage.value = page;
	frm.action='userSubPage.do?job=category&' + "cate=" + categoryType;
	frm.submit();
}

//검색 이동
userSubPage.findStr = function(frm){
	console.log("OKKK");
	frm.action='userSubPage.do?job=search';
	frm.submit();
}
//검색_버튼이동
userSubPage.movePage_Search = function(page){
	let frm = document.frm_item_list;
	frm.nowPage.value = page;
	frm.action='userSubPage.do?job=search';
	frm.submit();
}

//상세 이동
userSubPage.details = function(code){
	let frm = document.getElementById("frm_item_list");
	frm.action='userSubPage.do?job=details&' + "book=" + code;
	frm.submit();
}


//AD
userSubPage.AD = function(bookcode){
	let frm = document.getElementById("frm_AD");
	let param = $(frm).serialize();
	$.post('userSubPage.do?job=AD&bookcode=' + bookcode, param, function(b){
		console.log("b : " + b);
		if(b=="true"){
			frm.action='userSubPage.do?job=details&' + "book=" + bookcode;
	frm.submit();
		}else{
			alert("해당 아이템이 존재하지 않습니다, 관리자에게 문의하세요.");
		}
	});
}



//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ



// 슬라이드
let recommend_slide = document.querySelector(".recommend_slide")
let slideImg = document.querySelectorAll(".recommand_book");
let slideWidth = 0;
let slideIndex = 0;
let slideMove = true;
let movement = true;
let slideBtns = document.querySelectorAll(".slide_btn");

// 슬라이드 사이즈 구하기
userSubPage.slideSize = function(){
	for(let i = 0; i < slideImg.length; i++){
		slideWidth += slideImg[i].offsetWidth;
		recommend_slide.style.transition = 'transform 1.5s ease-out';
	}
}

// 슬라이드 재생, 일시정지
if(recommend_slide != null){   // inc에 슬라이드가 있을 때
   
   userSubPage.slideMoveControl = function(movement){
      if(movement == true){
         slideMove = false;
         timer = setInterval(function(){
            userSubPage.slideNext();
         }, 8000)
      } else {
         slideMove = true;
         clearInterval(timer);
      }
   }
   userSubPage.slideSize();
   userSubPage.slideMoveControl(movement);
}

// 슬라이드 움직임 이벤트
userSubPage.slidePrev = function(){
	slideIndex--;
	if(slideIndex < 0) {
		slideIndex = slideImg.length-1;
	}
	recommend_slide.style.transform = "translateX(" + -1400 * slideIndex +"px)";
	userSubPage.btnColorChange(slideIndex);
}
userSubPage.slideNext = function(){
	slideIndex++;
	if(slideIndex == slideImg.length) {
		slideIndex = 0;
	}
	recommend_slide.style.transform = "translateX(" + -1400 * slideIndex +"px)";
	userSubPage.btnColorChange(slideIndex);
}
userSubPage.slideControl = function(btn){
	let control = btn.innerHTML;
	userSubPage.slideMoveControl(slideMove)
	
	if(control == "Stop") btn.innerHTML = "Play";
	else btn.innerHTML = "Stop";
}
userSubPage.slideMove = function(moveIndex){
	recommend_slide.style.transform = "translateX(" + -1400 * moveIndex +"px)";
	slideIndex = moveIndex;
	userSubPage.btnColorChange(slideIndex);
}

// 슬라이드 움직이면 버튼 색상 변경
userSubPage.btnColorChange = function(slideIndex){
	for(let i = 0; i < slideBtns.length; i++){
		slideBtns[i].style.background = "#ddd";	
	}
	slideBtns[slideIndex].style.background = "#fff";
}
