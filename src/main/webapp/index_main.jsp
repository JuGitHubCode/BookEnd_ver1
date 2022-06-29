<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book& MainPage</title>
<link rel = 'stylesheet' type = 'text/css' href = './user/css/index_main.css'>
<!-- <script src='./WEB-INF/lib/jquery-3.6.0.min.js'></script>  -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script defer src='./user/js/user_subPage.js'></script>
<script>
	let sessionID = '${sessionScope.uId}';
</script>
</head>
<body>
<% String inc = request.getParameter("inc");
		if(inc == null){
			inc = "./temp.jsp";
		}
	%>

	<div id="index">
		<form name='frm_header' id='frm_header' method='post'>
			<input type='text' hidden='hidden' id='userID' name='userID' value='${sessionScope.uId}' />
			<header class="header">
				<div class='menu_category'>
					<nav id='nav'>
						<ul class='menu'>
							<li><img src='./user/icon/menuBar.png' width='25%' class='menuBar' name='menuBar' id='menuBar'>
								<ul class='submenu'>
									<li><a href='#' onclick='javascript:document.frm_header.btn0.onclick()'>소설</a></li>
									<li><a href='#' onclick='javascript:document.frm_header.btn1.onclick()'>시/에세이</a></li>
									<li><a href='#' onclick='javascript:document.frm_header.btn2.onclick()'>인문</a></li>
									<li><a href='#' onclick='javascript:document.frm_header.btn3.onclick()'>자기계발</a></li>
									<li><a href='#' onclick='javascript:document.frm_header.btn4.onclick()'>교재/참고서</a></li>
								</ul>
							</li>
						</ul>
					</nav>	
				</div>
				
				<div class='menu_sub'>
					<input type='text' hidden='hidden' id='testID' name='testID' size='15px' value='&nbsp;&nbsp;'/>
					<a href='#' class='login' onclick='javascript:document.frm_header.loginBtn.onclick()' ></a>
					<a href='#' class='myPage' onclick='javascript:document.frm_header.myPageBtn.onclick()'><img src='./user/icon/login.png' width='2%'/></a>&nbsp;&nbsp;&nbsp;
					<a href='#' class='cart' onclick='javascript:document.frm_header.cartBtn.onclick()'><img src='./user/icon/cart.png' width='2%'/></a>
				</div><br>
				
				<div class='header_main'>
					<img src='./user/icon/logo1.png' width='18%' class='logo' name='logo' onclick='location.href="userSubPage.do?job=index"'><br>
					<div class='searchLine'>
						<input type='search' id='findStr' name='findStr' size='140px' value='${param.findStr}' />
						<img src='./user/icon/search.png' width='30px' height='30px' name='searchIcon' id='searchIcon' onclick='javascript:document.frm_header.btnSearch.onclick()'>
					</div>
					
				</div>
				
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
		
		<hr>
		
		
		<div class='mid'>
			<jsp:include page="<%=inc%>" />
		</div>
		
		<hr>
		
		<footer class='footer'>
			서울 봉천 노랑달걀 7층</br>
			tel : 02-1111-2222</br>
			fax : 02-3333-4444
		</footer>
	</div>
</body>
</html>