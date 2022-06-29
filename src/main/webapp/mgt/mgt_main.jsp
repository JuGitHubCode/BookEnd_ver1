<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mgt_main</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gochi+Hand&family=Jua&family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" href="mgt/css/mgt_main.css"></style>
<script src="mgt/WEB-INF/lib/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script defer src="mgt/js/mgt_main.js"></script>
</head>
<body>
<%
	String inc=request.getParameter("inc");
	String display="";
	if(inc==null){
		inc="";
		display="";
	}else{
		display="style='display: none'";
	}
%>
	<div id="mgt_main">
		<header class="header">
			<div class="main_title">
				<a href="./mgt/mgt_main.jsp" ><img src="mgt/icon/logo1.png"></a>
				<span class="title1">관리자 페이지</span>
			</div>
			<div class="log">
				<%@include file="/mgt/logInOut/login_out.jsp" %>
			</div>
			   <form>
      				<input type='text' name='uId' id='uId' value='${sessionScope.uId}'/>
   				</form>
		</header>
	
		<main class="main" >
			<div id="view">
			 <jsp:include page="<%=inc %>"/>
			</div>
			<div id="main_section">
				<form name="frm_main" id="frm_main" class="frm_main" method="post" <%-- <%=display %> --%>>
					<div class="category">
						<span class="mgt_book" onclick="mgt.bookslide('.mgt_book_list')">
						<img class="slide_icon" id="mgt_book_list_icon"src="mgt/icon/collapse.png" >
						도서 관리
						</span>
						<div class="mgt_book_list" >
							<div id="menu">
							
							<img src="mgt/icon/insert_book.png" class="./mgt/item/mgt_item_input.jsp" onclick="mgt.movePage(this.className)"><br>
							<span>도서 등록</span>
							
							</div>
							<div id="menu">
							
							<img src="mgt/icon/view_book.png" class="./mgt/item.do" onclick="mgt.movePage(this.className)"><br>
							<span>도서 조회</span>
							
							</div>
					<%--	<div id="menu">
							<a href="../test.jsp">
							<img src="./icon/update_book.png"><br>
							<span>도서 수정</span>
							</a>
							</div>
							<div id="menu">
							<a href="../test.jsp" >
							<img src="./icon/delete_book.png"><br>
							<span>도서 삭제</span>
							</a>
							</div> --%>
					 	</div>
					</div>
					<br>
					
					<div class="category">
						<span class="mgt_book" onclick="mgt.bookslide('.mgt_info_list')">
						<img class="slide_icon" id="mgt_info_list_icon"src="mgt/icon/collapse.png">
						정보 관리
						</span>
						<div class="mgt_info_list">
							<div id="menu" class="./mgt/customer/customer.do" onclick="mgt.movePage(this.className)">
							<!-- <a href="./mgt_main.jsp?inc=/customer.do?inc=./mgt_customer/mgt_customer.jsp"  > -->
							<img src="mgt/icon/customer.png"><br>
							<span>고객 관리</span>
							<!-- </a> -->
							</div>
							<div id="menu" class="./mgt/order/order.do" onclick="mgt.movePage(this.className)">
							<img src="mgt/icon/graph.png"><br>
							<span>판매 관리</span>
							</div>
						</div>
					</div>
				</form>
			</div>
		</main>
		
	</div>
	<div class="test">
			<a href="./mgt_main.jsp" >
			<img class="banner" src="mgt/icon/homepage.png">
			</a>
			<hr>
			<img  onclick="mgt.create()" class="banner" src="mgt/icon/create.png">

		</div>	
</body>
</html>