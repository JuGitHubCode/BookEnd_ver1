<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_order</title>
<link rel='stylesheet' href='./user/css/user_order.css'>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src='./lib/jquery-3.6.0.min.js'></script>
<script defer src='./user/js/user_order.js'></script>
</head>
	
		
	
<body>
<div class='user_order'>
<form name='frm_user_order' id='frm_user_order' method='post'>
	<h2>주문/결제</h2><br/>
	<div id='oOrder'>
		<h3>주문고객</h3>
		<hr/>
		<label>이름</label>
		<input type='text' name='uName' value='${vo.uName}' readonly/><br/>
		<label>연락처</label>
		<input type='text' name='phone' value='${vo.phone}' readonly/><br/>
		<label>이메일</label>
		<input type='text' name='email' value='${vo.email}' readonly/><br/>
		<input type='text' name='orderDate' id='orderDate' /> <!-- style='display:none' -->
		<input type='text' name='uId' value='${param.uId}'/>
		<input type='hidden' name='orderNo' id="orderNo" value=''/>
		<input type='hidden' name='zipCode' value='${vo.zipCode}'/>
		<input type='hidden' name='address1' value='${vo.address1}'/>
		<input type='hidden' name='address2' value='${vo.address2}'/>
	</div>

	<div id='oProduct'>
		<h3>주문상품</h3>
		<div class='title'>
			<span class='img'></span>
			<span class='codeName'>상품정보</span>
			<span class='orderEa'>수량</span>
			<span class='price'>상품금액</span>
		</div>
		
		<div class='items'>
			
			 <c:forEach var='vo' items='${list}' varStatus='sts'> 
			 	<div class='item'>
					<span class='img'><img src = "${vo.img}" width='100px'/></span>
					<span class='codeName'>${vo.codeName}</span>
					<span class='orderEa'>${vo.orderEa}</span>
					<span class='price'>${vo.price}</span>
				</div>
				<c:set var="amt" value="${amt + (vo.price * vo.orderEa)}" />
				<input type="hidden" name='orderEa' value="${vo.orderEa }">
				<input type='hidden' name='img' value='${vo.img}'/> 
				<input type='hidden' name='code' value='${vo.code}'/> 
				<input type='hidden' name='price' value='${vo.price}'/> 
			</c:forEach> 
			<input type='hidden' name='listSize' value='${listSize }'/>
		</div>
	</div>

	<div class='user_order' id='totP'>
		
			<label>총 주문 금액</label>
			<label class='amt'><c:out value=" ${amt }"></c:out>원</label>
			<input type="hidden" name='amt' value='${amt}'/>
		</div>
	<div id='oDeliver'>
		<h3>배송지정보</h3>
		<label class='setd'><input type="checkbox" name='setD'  value="same" id='setD' onclick="user_order.sameD()"/>주문정보와 동일</label>
		<hr/>
		<label>이름</label>
		<input type='text' name='rName' placeholder='수령인을 입력하세요.' /><br/>
		<label>연락처</label>
		<input type='text' name='rPhone' placeholder='연락처를 입력하세요.' /><br/>
		<label>주소</label>
		<input type='text' name='rZipcode' size='8' />
		<button type='button' id='btnZipFind' onclick="user_order.findZipCode()">우편번호</button><br/>
		<label></label>
		<input type='text' name='rAddress' size='35' placeholder='주소를 입력하세요.' /><br/>
		<label>상세주소</label>
		<input type='text' name='rAddressD' size='35' placeholder='상세주소를 입력하세요.' /><br/>
		<label>요청사항</label>
		<input type='text' name='remark'size='35' placeholder='배송시 요청사항을 입력하세요.' />
	</div>
	
	
	<div id='oPay'>
		<h3>결제수단</h3>
		<hr/>
		<input type="radio" id="card" name="pay" value='카드결제'><label for="card">카드 결제</label>
		<input type="radio" id="cash" name="pay" value='무통장입금'><label for="cash" >무통장 입금</label>
	</div>
	
	
	<div id='oLast'>
		<span>최종 결제금액</span>
		<label class='tot2'><c:out value=" ${amt}"></c:out>원</label><br/>
		<button type='button' class='btnOrder' onclick='user_order.orderPay(this.form)'>결제하기</button>
	</div>
</form>	
</div>

</body>
</html>



