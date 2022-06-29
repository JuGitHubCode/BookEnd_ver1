<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_order_detail</title>
<link rel='stylesheet' href='./user/css/user_order.css'>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
	
		
	
<body>
<div id='user_order_detail'>
<form name='frm_user_order_d' id='frm_user_order_d' method='post'>
	<h2>주문/결제</h2><br/>
	<h3>주문이 정상적으로 완료되었습니다.</h3>
	
	<label>주문번호</label>
	<input type='text' name='orderNum' value='${vo.orderNo }'/> 
	<input type='text' name='orderDate' id='orderDate' value='${vo.orderDate}'/>
	<input type='hidden' id="orderNo" value=''/>
	<input type='text' name='uId' value='${param.uId}'/>
	<h3>배송지정보</h3>
	<hr/>
	<label>이름</label>
	<input type='text' name='rName' value='${vo.rName}'/><br/>
	<label>연락처</label>
	<input type='text' name='rPhone' value='${vo.rPhone}'/><br/>
	<label>주소</label>
	<input type='text' name='rZipcode' size='8' value='${vo.rZipcode}'/>
	<label></label>
	<input type='text' name='rAddress' size='35' value='${vo.rAddress}'/><br/>
	<label>요청사항</label>
	<input type='text' name='remark' size='35' value='${vo.remark}' />
	<hr/>
	<label>결제금액</label>
	<input type='text' name='amt' value='${vo.amt}'/><br/>
	<button type='button' name='btnGoHome' onclick="user_order.moveMainPage(this.form)">홈으로</button>
	<button type='button' name='btnGoOrderDetail' onclick="moveMypageOrderDetail(this.form)">주문내역상세</button>
</form>
</div>
<script src='./user/js/user_order.js'></script>	
</body>
</html>


