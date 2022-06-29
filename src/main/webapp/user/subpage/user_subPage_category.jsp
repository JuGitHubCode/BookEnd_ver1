<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User SubPage Category</title>
<link rel = 'stylesheet' type = 'text/css' href = './user/css/user_subPage_category.css'>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script defer src='./user/js/user_subPage.js'></script>
<script>
	let sessionID = '${sessionScope.uId}';
	let category = '${page.categoryType}';
</script>
</head>
<body>
<input type='text' id='userID' name='userID' hidden='hidden' value='${sessionScope.uId}' />
	<div id='category'>
		<div id='top'>
			<form name='frm_top' id='frm_top' method='post'>
			
				<header class='top_header'>
					
					<img src='./user/icon/logo1.png' width='200px' height='80px' class='cate_logo' name='cate_logo' onclick='location.href="userSubPage.do?job=index"'>
					
					<!-- <div class='header_main'> -->
						<div class='searchLine'>
							<input type='search' id='findStr' name='findStr' size='70px' value='${param.findStr}' />
							<img src='./user/icon/search.png' width='40px' height='40px' name='searchIcon' id='searchIcon' onclick='javascript:document.frm_top.btnSearch.onclick()'>
						</div>	
					<!-- </div> -->
				
					<div class='menu_sub'>
						<input type='text' hidden='hidden' id='testID' name='testID' size='15px' value='&nbsp;&nbsp;'/>
						<a href='#' class='login' onclick='javascript:document.frm_top.loginBtn.onclick()'>로그인</a>&nbsp;&nbsp;&nbsp;
						<a href='#' class='myPage' onclick='javascript:document.frm_top.myPageBtn.onclick()'><img src='./user/icon/login.png'/></a>&nbsp;&nbsp;&nbsp;
						<a href='#' class='cart' onclick='javascript:document.frm_top.cartBtn.onclick()'><img src='./user/icon/cart.png'/></a>
					</div>
					
				</header>
				
				<button type='button' hidden='hidden' name="loginBtn" onclick='userSubPage.login(this.form)'>hidden_a태그 로그인</button>
				<button type='button' hidden='hidden' name="myPageBtn" onclick='userSubPage.myPage(this.form)'>hidden_a태그 마이페이지</button>
				<button type='button' hidden='hidden' name="cartBtn" onclick='userSubPage.cart(this.form)'>hidden_a태그 장바구니</button>
				<button type='button' hidden='hidden' name='btnSearch' onclick='userSubPage.findStr(this.form)'>hidden_a태그 검색</button>				
			</form>
			
		</div>
		
		<div id='top_main'>
			<form name='frm_top_main' id='frm_top_main' method='post'>
				<header class='top_main_header'>
					
					<!-- <img src='./user/icon/logo1.png' width='200px' height='80px' class='hid_logo' name='hid_logo' onclick='location.href="userSubPage.do?job=index"'><br> -->
					
					<div id='submenu_title'>
							<div><a href='#' id='fiction' onclick='javascript:document.frm_top_main.btn0.onclick()'>소설</a></div>
							<div><a href='#' id='essay' onclick='javascript:document.frm_top_main.btn1.onclick()'>시/에세이</a></div>
							<div><a href='#' id='cultural' onclick='javascript:document.frm_top_main.btn2.onclick()'>인문</a></div>
							<div><a href='#' id='self' onclick='javascript:document.frm_top_main.btn3.onclick()'>자기계발</a></div>
							<div><a href='#' id='reference_book' onclick='javascript:document.frm_top_main.btn4.onclick()'>교재/참고서</a></div>
						
					</div>
					
					<!-- <div id='top_main_menu_sub'>
						<input type='text' hidden='hidden' id='testID' name='testID' size='15px' value='&nbsp;&nbsp;'/>
						<a href='#' class='login' onclick='javascript:document.frm_top_main.loginBtn.onclick()'>login</a>&nbsp;&nbsp;&nbsp;
						<a href='#' class='hid_myPage' onclick='javascript:document.frm_top_main.myPageBtn.onclick()'>마이 페이지</a>&nbsp;&nbsp;&nbsp;
						<a href='#' class='cart' onclick='javascript:document.frm_top_main.cartBtn.onclick()'>cart</a>
					</div> -->
					
				</header>
				<button type='button' hidden='hidden' name="loginBtn" onclick='userSubPage.login(this.form)'>hidden_a태그 로그인</button>
				<button type='button' hidden='hidden' name="myPageBtn" onclick='userSubPage.myPage(this.form)'>hidden_a태그 마이페이지</button>
				<button type='button' hidden='hidden' name="cartBtn" onclick='userSubPage.cart(this.form)'>hidden_a태그 장바구니</button>
				<button type='button' hidden='hidden' name='btnSearch' onclick='userSubPage.findStr(this.form)'>hidden_a태그 검색</button>
				<button type='button' hidden='hidden' name='btn0' onclick='userSubPage.category(this.form, 0)'>hidden_a태그 소설 페이지이동</button>
				<button type='button' hidden='hidden' name='btn1' onclick='userSubPage.category(this.form, 1)'>hidden_a태그 시/에세이 페이지이동</button>
				<button type='button' hidden='hidden' name='btn2' onclick='userSubPage.category(this.form, 2)'>hidden_a태그 인문 페이지이동</button>
				<button type='button' hidden='hidden' name='btn3' onclick='userSubPage.category(this.form, 3)'>hidden_a태그 자기계발 페이지이동</button>
				<button type='button' hidden='hidden' name='btn4' onclick='userSubPage.category(this.form, 4)'>hidden_a태그 교재/참고서 페이지이동</button>
			</form>
		</div>
		
		<div class='mid'>
			<br><br><br><br><div class='cate_Name'>${page.categoryType}</div><br><br><br>
			<hr>
			<div class='itemslist'>
				<form name="frm_item_list" id="frm_item_list" method="post">
					<c:set var='bookcode' value='' />
					<c:forEach var='vo' items='${list}'>
						<c:set var='bookcode' value='${vo.code}' />
						<br><br>
						<div class='item' name='item' >
							<div class='item_img' name='item_img'>
								<img src='./mgt/itemImg/${vo.img}' width='250px' height='300px' class='img' name='img' onclick='userSubPage.details("${bookcode}")'>
							</div>
							<div class='item_info' name='item_info'>
								<a href='#' class='book_Name' onclick='userSubPage.details("${bookcode}")' >${vo.codeName}</a><br><br><br>
								<label name='writer'>${vo.writer}</label> | <label name='company'>${vo.company}</label> | <label name='nal' >${vo.nal}</label><br><br>
								<label name='category' >장르 : ${vo.viewCategory}</label><br><br>
								<label name='price' >${vo.price} 원</label><br><br>
								<label name='ea' >남은 수량 : ${vo.ea} 권</label>
							</div>
							<input type='text' hidden='hidden' value='${vo.code}' name='code'/>
							<input type='text' hidden='hidden' value='${vo.img }' size='30px' name='img'/>
						</div>
					<br><br><hr>
					</c:forEach><br><br>
					
					<div class='btns'>
						<c:if test="${page.startPage>1}">
							<button type='button' onclick='userSubPage.movePage_Category(1,${page.categoryType})'>맨첨</button>
							<button type='button' onclick='userSubPage.movePage_Category(${page.startPage-1},${page.categoryType})' >이전</button>
						</c:if>
						<c:forEach var='i' begin='${page.startPage}' end='${page.endPage}'>
							<button type='button' onclick='userSubPage.movePage_Category(${i},${page.categoryType})'>${i}</button>
						</c:forEach>
						
						<c:if test="${page.totPage > page.endPage}">
							<button type='button' onclick='userSubPage.movePage_Category(${page.endPage+1},${page.categoryType})'>다음</button>
							<button type='button' onclick='userSubPage.movePage_Category(${page.totPage},${page.categoryType})'>맨끝</button>
						</c:if>
					</div>
					
					<input type='text' hidden='hidden' value='${page.findStr}' name='findStr'/>
					<input type='text' hidden='hidden' value='${page.nowPage}' name='nowPage'/>
					<input type='text' hidden='hidden' value='${page.categoryType}' name='categoryType'/>
				</form>
			</div>
		</div>
		
		
		
		<footer class='footer'>
		 
			서울 봉천 노랑달걀 7층</br>
			tel : 02-1111-2222</br>
			fax : 02-3333-4444
		</footer>
	</div>
	
	<script>
		if(category == 0){
			$('.cate_Name').html("소설");
		}
		else if(category == 1){
			$('.cate_Name').html("시/에세이");
		}
		else if(category == 2){
			$('.cate_Name').html("인문");
		}
		else if(category == 3){
			$('.cate_Name').html("자기계발");
		}
		else if(category == 4){
			$('.cate_Name').html("교재/참고서");
		}
		
			
	</script>
</body>
</html>