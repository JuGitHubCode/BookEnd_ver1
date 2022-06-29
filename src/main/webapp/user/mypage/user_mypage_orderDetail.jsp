<%@page import="bean.PageMypage"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_mypage_orderDetail</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel='stylesheet' href='./user/css/user_mypage.css'>
<script defer src='./user/js/userMypage.js'></script>

</head>
<body>
	<div id='order_detail'>
		<h2>구매내역 상세보기</h2>
		<br/>
		<form name='frm_order_detail' id='frm_order_detail' class='frm_order_detail' method='post'>
			<input type='hidden' name='nowPage' value='${param.nowPage}'/>
			<input type='hidden' name='orderNo' value='${param.orderNo}'/>
			<input type='hidden' id='uId' name='uId' value='${param.uId}'/>
			<br/>
			<div id='lists'>
				<div class='titles'>
					<span class='no'>No.</span> 
					<span class='code'>도서코드</span>
					<span class='codeName'>도서명</span>
					<span class='price'>판매가</span>
					<span class='orderEa'>수량</span>
					<span class='amt'>금액</span>
					<span class='img'>도서 이미지</span>
				</div>
				
				<div class='items'>
					<c:set var='j' value='1'/>
					<c:forEach var='vo' items='${list}'> 					
						<c:set var='totAmt' value='${vo.orderEa * vo.price}'/>
						<div class='item'>
							<span class='no'>${j}</span> 
							<span class='code'>${vo.code}</span>
							<span class='codeName'>${vo.codeName}</span>
							<span class='price'><fmt:formatNumber>${vo.price}</fmt:formatNumber>원</span>
							<span class='orderEa'><fmt:formatNumber>${vo.orderEa}</fmt:formatNumber></span>
							<span class='amt'><fmt:formatNumber>${totAmt}</fmt:formatNumber>원</span>
							<span class='img'><img src="./mgt/itemImg/${vo.img}" width="100px"/></span>
						</div>
			            <c:set var='sum' value='${vo.amt}'/>
			            
			            <c:set var='dOrderNo' value='${vo.orderNo}'/>
						<c:set var='dOrderDate' value='${vo.orderDate}'/>
						<c:set var='dPaymentType' value='${vo.paymentType}'/>
						<c:set var='dRName' value='${vo.rName}'/>
						<c:set var='dRZipcode' value='${vo.rZipcode}'/>
						<c:set var='dRAddress' value='${vo.rAddress}'/>
						<c:set var='dRPhone' value='${vo.rPhone}'/>
						<c:set var='dRemark' value='${vo.remark}'/>
			            
			            <c:set var='totAmt' value='0'/>
			        <c:set var='j' value='${j=j+1}'/>
					</c:forEach>
				</div>
			</div>
			<br/>
			<div class='commonInfo'>
				<label>주문번호 : </label><span class='dOrderNo' id='dOrderNo'>${dOrderNo}</span><br/>
				<label>주문일 : </label><span class='dOrderDate' id='dOrderDate'>${dOrderDate}</span><br/>
				<label>결제방식 : </label><span class='dPaymentType' id='dPaymentType'>${dPaymentType}</span><br/>
				<label>수령인 : </label><span class='dRName' id='dRName'>${dRName}</span><br/>
				<label>우편번호 : </label><span class='dRZipcode' id='dRZipcode'>${dRZipcode}</span><br/>
				<label>수령지 : </label><span class='dRAddress' id='dRAddress'>${dRAddress}</span><br/>
				<label>연락처 : </label><span class='dRPhone' id='dRPhone'>${dRPhone}</span><br/>
				<label>배송메모 : </label><span class='dRemark' id='dRemark'>${dRemark}</span><br/>
				<hr/>
				<label>총 금액 : </label><span class='sum' id='sum'><fmt:formatNumber>${sum}</fmt:formatNumber>원</span>
			</div>
			<input type='hidden' name='findStr' id='findStr' value='${param.findStr}'/>
			<input type='hidden' name='nowPage' value='${param.nowPage}'/>
			
			<br/>
			<button type='button' class='btnToPrev' onclick='mypage.select(this.form)'>이전 페이지</button>
		</form>
		<br/>
	</div>
	
</body>
</html>