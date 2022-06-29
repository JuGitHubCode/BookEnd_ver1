<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_cart</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gochi+Hand&family=Jua&family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script defer src="./user/js/user_cart.js"> </script>
<link rel='stylesheet' type='text/css' href='./user/css/user_cart.css'>
</head>
<body>
	<%	
		String uId = (String)session.getAttribute("uId");
		if(uId == null || uId == ""){ %>
		<script>
			alert("로그인을 해주세요!");
		</script>
	<% 	} %> 	
	
	<div id='cart'>
		<h2>장바구니</h2>

		<div class="cart_wrap">
			<div class="cart_list">
				<form name="frm_user_cart" id="frm_user_cart" method="post">
					<div class="item_control">
						<button type="button" class="btn_all_check">전체 선택</button> |
						<button type="button" class="btn_check_delete">선택 삭제</button>
					</div>
					<c:forEach var="vo" items="${list }">
						<div class="item item_${vo.code }">
							<label class="check item_css" ><input type="checkbox" value=${vo.code } name="item_check" class="item_check"></label>
							<div class="item_img"><img src="${vo.img }"></div>
							<span class="item_name ">${vo.codeName }</span>
							<div class="ea_btns item_css">
								<img src="./user/icon/minus.png" class="minus_icon cart_icon" onclick="minusItem('${vo.code }')" />
								<span class="item_ea ea_${vo.code }">${vo.orderEa }</span>
								<img src="./user/icon/plus.png" class="plus_icon cart_icon" onclick="plusItem('${vo.code }')">
							</div>
							<span class="item_amt amt_${vo.code} item_css"></span>
							<img src="./user/icon/delete.png" class="btn_delete item_css" onclick="deleteItem('${vo.code }', this)">
							<input type="hidden" value="${vo.price }" class="book_price">
							<input type="hidden" value="${vo.ea }" class="stock_${vo.code}"/>
						</div>
					</c:forEach>
					<input type="text" value="<%=uId %>" name="uId">	
				</form>
			</div>
			
			<div class="cart_order">
				<div class="cart_order_address">
					<span>배송지 : </span>
					<div class="cart_address1">${address1 }</div>
					<div class="cart_address2">${address2 }</div>
				</div>
				<div class="cart_order_amount">
					<span>결제 예정 금액 : </span>
					<span class="tot_amt"></span>
				</div>
				<button type="button" class="btn_cart_order" onclick="moveOrderPage()">주문하기</button>
			</div>
		</div>
	</div>
</body>
</html>