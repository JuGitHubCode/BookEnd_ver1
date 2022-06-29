<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_order</title>
<link rel='stylesheet' href='./css/user_order.css'>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src='./lib/jquery-3.6.0.min.js'></script>
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
      <input type='date' name='orderDate' id='orderDate' /> <!-- style='display:none' -->
      <input type='hidden' name='uId' value='${vo.uId}'/>
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
               <span class='orderEa'>${vo.orderEa}원</span>
               <span class='price'>${vo.price}개</span>
            </div>
            <c:set var="total" value="${total + (vo.price * vo.orderEa)}" />
         </c:forEach> 
      </div>
   </div>

   <div class='user_order'>
      <!-- <form name='frm_totP' id='totP'> -->
         <label>총 주문 금액</label>
         <label class='tot'><c:out value=" ${total }원"></c:out></label>
      <!-- </form> -->
      </div>
   <div id='oDeliver'>
      <h3>배송지정보</h3>
      <hr/>
      <label>이름</label>
      <input type='text' name='rName' value='수령인을 입력하세요.'/><br/>
      <label>연락처</label>
      <input type='text' name='rPhone' value='연락처를 입력하세요.'/><br/>
      <label>주소</label>
      <input type='text' name='rZipcode' size='8'/>
      <button type='button' id='btnZipFind'>우편번호</button><br/>
      <label></label>
      <input type='text' name='rAddress' size='35' value='주소를 입력하세요.'/><br/>
      <label>상세주소</label>
      <input type='text' name='rAddressD' size='35' value='상세주소를 입력하세요.'/><br/>
      <label>요청사항</label>
      <input type='text' name='remark'size='35' value='배송시 요청사항을 입력하세요.' />
   </div>
   
   
   <div id='oPay'>
      <h3>결제수단</h3>
      <hr/>
      <input type="radio" id="card" name="pay"><label for="card">카드 결제</label>
      <input type="radio" id="cash" name="pay"><label for="cash">무통장 입금</label>
   </div>
   
   
   <div id='oLast'>
   <!-- <form name='frm_user_order_oLast' method='post'> -->
      <span>최종 결제금액</span>
      <label class='tot2'><c:out value=" ${total }원"></c:out></label><br/>
      <button type='button' class='btnOrder' onclick='user_order.orderPay()'>결제하기</button>
   <!-- </form> -->
   </div>
</form>   
</div>
    <script src='./js/user_order.js'></script>   
</body>
</html>


