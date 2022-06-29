<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>order_list</title>
</head>
<body>
<div id="mgt_order">	
		<%--<a href="./mgt_main.jsp?inc=../mgt_customer/mgt_customer_graph.jsp">
		그래프로 확인
		</a>--%>
		<h2>판매 관리 페이지</h2>
		<form name="frm_order_list" class="frm_order_list" id="frm_order_list" method="post">
			<input type="date" id="std" name="std">
			<span>~</span>
			<input type="date" id="edd" name="edd">
			<select id="type" name="type" value="o.uId">
				<option value="o.orderNo" >오더넘버</option>
				<option value="o.uId" >아이디</option>
				<option value="u.uName">성명</option>
			</select>
			<input type="text" id="findStr" name="findStr">
			<input type="button" id="btnFind" name="btnFind" value="검색" onclick="od.findSelect(this.form)">
			<input type="button" id="btnSort" name="btnSort" value="오름차순" onclick="od.sort(this.form)">
			<input type="text" id="nowPage" name="nowPage">
			<input type="text" id="sortType" name="sortType" value="asc" >
			<input type="text" name="sno" value="${page.startPage }">	
		</form>
		
		<div id="list">
			<div class="title">
				<span class="sno" id="sno">순번</span>
				<span class="orderNo" id="orderNo">오더넘버</span>
				<span class="uId" id="uId">아이디</span>
				<span class="uName" id="uName">성명</span>
				<span class="code" id="code">도서코드</span>
				<span class="codeName" id="codeName">도서명</span>
				<span class="orderEa" id="orderEa">수량</span>
				<span class="price" id="price">단가</span>
				<span class="amt" id="amt">금액</span>
				<span class="orderDate" id="orderDate">주문일</span>
				<span class="remark" id="remark">메모</span>
				<span class="rName" id="rName">수령인</span>
				<span class="rPhone" id="rPhone">번호</span>
				<span class="rZipcode" id="rZipcode">우편번호</span>
				<span class="rAddress" id="rAddress">주소</span>
				<span class="paymentType" id="o.paymentType">결제유형</span>
				
			</div>
			<div class="items">
				<c:set var="i" value="${i=Page.startNo+1}"/>
				<c:forEach var="vo" items="${list }"  varStatus="status">
	               <c:set var="i" value="${i=i+1}"/>
	               <c:set var="amt" value="${vo.orderEa * vo.price}"/>
	               <c:if test="${vo.orderNo!=tot && tot!=null || vo.orderNo==null&&vo.orderNo==''}">
	                  <span class="sum" id="sum">
	                     총액 : ${sum }
	                     <c:set var="lastsum" value="0"/>
	                  </span>
	               </c:if>
	               <c:set var="lastsum" value="${lastsum=lastsum+amt}"/>
	               <div class="item">
	               <span class="sno" id="sno">${vo.sno }</span>
	               <span class="orderNo" id="orderNo">${vo.orderNo }</span>
	               <span class="uId" id="uId">${vo.uId }</span>
	               <span class="uName" id="uName">${vo.uName }</span>
	               <span class="code" id="code">${vo.code }</span>
	               <span class="codeName" id="codeName">${vo.codeName }</span>
	               <span class="orderEa" id="orderEa">${vo.orderEa }</span>
	               <span class="price" id="price">${vo.price }</span>
	               <span class="amt" id="amt">${amt}</span>
	               <span class="orderDate" id="orderDate">${vo.orderDate }</span>
	               <span class="remark" id="remark">${vo.remark }</span>
	               <span class="rName" id="rName">${vo.rName }</span>
	               <span class="rPhone" id="rPhone">${vo.rPhone }</span>
	               <span class="rZipcode" id="rZipcode">${vo.rZipcode }</span>
	               <span class="rAddress" id="rAddress">${vo.rAddress },${Page.startNo },${Page.endNo }</span>
	               <span class="paymentType" id="paymentType">${vo.paymentType },${Page.endPage },${Page.nowPage }</span>
	               </div>
	               <c:set var="tot" value="${vo.orderNo }"/>
	               <c:set var="sum" value="${vo.amt }"/>
	               <c:set var="amt" value="0"/>
	               
	               <c:if test="${Page.endNo==i }">
	               	  <span class="sum" id="sum">
	                     중간합계 : ${lastsum }
	                  </span>
	               </c:if>
	               
	                <c:if test="${status.last}">
	               	<span class="sum" id="sum">
	                     합계 : ${sum }
	               	</span>
	               </c:if>
            </c:forEach>


			</div>
		</div>
		<div class="paging">
				<c:if test="${Page.startPage>1}">
				<button type="button" class="btnFirst" onclick="od.movePage(1)">맨처음</button>
				<button type="button" class="btnPrev" onclick="od.movePage(${Page.startPage-1})">이전</button>
				</c:if>
				
				<c:forEach var="i" begin="${Page.startPage }" end="${Page.endPage }">
				<button type="button" class="first" onclick='od.movePage(${i})'>${i }</button>
				</c:forEach>
				
				<c:if test="${page.totPage>page.endPage}">
				<button type="button" class="btnNext"onclick="od.movePage(${Page.endPage+1})">다음</button>
				<button type="button" class="btnLast"onclick="od.movePage(${Page.totPage})">맨끝</button>
				</c:if>
		</div>
	</div>

</body>
</html>