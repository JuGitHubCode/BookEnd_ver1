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
<title>user_mypage_orderList</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel='stylesheet' href='./user/css/user_mypage.css'>
<script defer src='./user/js/userMypage.js'></script>

</head>
<body>
	<div id='order_list'>
		<h2>구매내역 조회</h2>
		<form name='frm_order_list' id='frm_order_list' class='frm_order_list' method="post">
			<input type='hidden' name='nowPage' value='${param.nowPage}'/>
			<input type='hidden' name='uId' id='uId' value='${param.uId}'/>
			<input type='hidden' name='orderNum'> 
			<br/>
			<br/>
			<div id='lists'>
				<div class='titles'>
					<span class='img'>도서 이미지</span>
					<span class='no'>No.</span>
					<span class='orderNo'>주문번호</span>
					<span class='code'>도서코드</span>
					<span class='codeName'>도서명</span>
					<span class='price'>판매가</span>
					<span class='orderEa'>수량</span>
					<span class='amt'>금액</span>
					<span class='orderDate'>구매일자</span>
					<span class='etc'></span>
				</div>
				
				<div class='items'>
					<c:set var='i' value='${page.startNo+1}'/> 
					<c:forEach var='vo' items='${list}' varStatus='sts'>
		                <c:set var='totAmt' value='${vo.orderEa * vo.price}'/>
						<div class='item' onclick='mypage.viewOrderDetail(${sts.index})'>
							<span class='img'><img src='./mgt/itemImg/${vo.img}' width='100px'/></span>
							<span class='no'>${i}</span> 
							<span class='orderNo'>${vo.orderNo}</span>
							<span class='code'>${vo.code}</span>
							<span class='codeName'>${vo.codeName}</span>
							<span class='price'><fmt:formatNumber>${vo.price}</fmt:formatNumber>원</span>
							<span class='orderEa'><fmt:formatNumber>${vo.orderEa}</fmt:formatNumber></span>
							<span class='amt'><fmt:formatNumber>${totAmt}</fmt:formatNumber>원</span>
							<span class='orderDate'>${vo.orderDate}</span>
							<c:choose>
								<c:when test='${vo.etc-1 > 0}'>
									<span class='etc'>외 ${vo.etc-1}건</span>
								</c:when>
								<c:otherwise>
									<span class='etc2'>외 0건</span>
								</c:otherwise>
							</c:choose>
						
						<%-- 	
							<c:if test='${vo.etc-1 > 0}'>
								<span class='etc'>외 ${vo.etc-1}건</span>
							</c:if>
							<c:if test='${vo.etc-1 < 0}'>
								<span class='etc2'>외 00건</span>
							</c:if>
						--%>
						</div>
						<c:set var='tot' value='${vo.orderNo}'/>
			            <c:set var='totAmt' value='0'/>
			            <input type='hidden' name='orderNo' class="orderNo1" value='${vo.orderNo}'/>
					<c:set var='i' value='${i=i+1}'/>
					</c:forEach>
				</div>
			</div>

		</form>
		<button type='button' class='btnToMain' onclick='mypage.toMainPage()'>이전 페이지</button>
	</div>
</body>
</html>