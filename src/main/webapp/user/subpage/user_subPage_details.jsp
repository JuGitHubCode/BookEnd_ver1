<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Book Details</title>
<link rel = 'stylesheet' type = 'text/css' href = './user/css/user_subPage_details.css'>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script defer src='./user/js/user_subPage.js'></script>
</head>
<body>

	<div id='category'>
		<div id='top'>
			<form name='frm_top' id='frm_top' method='post'>
			
				<header class='top_header'>
					
					
					<img src='./user/icon/logo1.png' width='200px' height='80px' class='cate_logo' name='cate_logo' onclick='location.href="userSubPage.do?job=index"'>
					
					<!-- <div class='header_main'> -->
						<div class='searchLine'>
							<input type='search' id='findStr' name='findStr' value='${param.findStr}' />
							<img src='./user/icon/search.png' width='3%'  name='searchIcon' id='searchIcon' onclick='javascript:document.frm_top.btnSearch.onclick()'>
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
		
		<div class='plz'>
			<div class='item'>
				<form name='frm_item_list' class='frm_item_list'>
					
					<label class='book_Name'>${vo.codeName}</label><br>
					
					<div class='item_img' name='item_img'>
						<img src='./mgt/itemImg/${vo.img}' class='img' width='400px' height='500px'>
					</div>
					<div class='item_info'><br><br>
						<h3>&nbsp;저자 | 출판사 | 출간일</h3><br>
						<label>&nbsp;${vo.writer}</label> | <label> ${vo.company}</label> | <label> ${vo.nal}</label><br><br><br>
						<h3>&nbsp;장르</h3><br>
						<label>&nbsp;${vo.viewCategory}</label><br><br><br>
						<h3>&nbsp;가격</h3><br>
						<label>&nbsp;${vo.price} 원</label><br><br><br>
						<label>
							&nbsp;수량 : &nbsp;<img src='./user/icon/minus.png' onclick='userSubPage.limitCheck("down")'
									width='15px' height='15px'>
							<label class='text_Ea'>
							1 권
							</label>
							 <img src='./user/icon/plus.png' size='15px' onclick='userSubPage.limitCheck("up")'
							 		width='15px' height='15px'>
						</label>&nbsp;&nbsp;&nbsp;
						<input type='button' class='cartAdd' value='장바구니 Add' onclick='userSubPage.cartR(this.form)'/>
					</div>
					<br><br><br><br><br><br>
					<div class='item_info2'>
						<label><h3>목차</h3></label><br>
						<textarea id='list' disabled >${vo.list}</textarea><br>
						<label><h3>내용</h3></label><br>
						<textarea id='contents' disabled >${vo.contents}</textarea><br>
					</div>
					
					
					<input type='text' id='userID' name='userID' hidden='hidden' value='${sessionScope.uId}' />
					<input type='text' id='bookCode' name='bookCode' hidden='hidden' value='${vo.code}' />
					
					<input type='text' id='bookEa' name='bookEa' hidden='hidden' value='${vo.ea}' />
					<input type='text' id='bookEaStatus' name='bookEaStatus' hidden='hidden' value='1' />
					
					<input type='text' name='findStr' value='${findStr}' hidden='hidden'/>
				
				</form>
			</div>
		
		</div>
		
		
		
		<footer class='footer'>
		 
			서울 봉천 노랑달걀 7층</br>
			tel : 02-1111-2222</br>
			fax : 02-3333-4444
		</footer>
	</div>
</body>
</html>