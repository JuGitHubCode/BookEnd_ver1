<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer_list</title>
</head>
<body>
	<div id="mgt_customer">	
		<%-- <a href="./mgt_main.jsp?inc=../mgt_customer/mgt_customer_graph.jsp">
		그래프로 확인</a>--%>
		<h2>고객 관리 페이지</h2>
		<form name="frm_customer_list" class="frm_customer_list" id="frm_customer_list" method="post">
			<select id="type" name="type" value="uId">
				<option value="uId" >아이디</option>
				<option value="uName">성명</option>
				<option value="birth">생년월일</option>
				<option value="phone">전화번호</option>
				<option value="email">이메일</option>	
				<option value="zipCode">우편번호</option>	
				<option value="address">주소</option>
				<option value="gender">성별</option>
				<option value="joinDate">가입일자</option>	
			</select>
			<input type="text" id="findStr" name="findStr">
			<input type="button" id="btnFind" name="btnFind" value="검색" onclick="cs.findSelect(this.form)">
			<input type="hidden" id="nowPage" name="nowPage">
			<input type="hidden" id="sort" name="sort" value="uId">
			<input type="hidden" id="sortType" name="sortType" value="asc" >
			<input type="hidden" name="sno" value="${page.startPage }">	
		</form>
		
		<div id="list">
			<div class="title">
				<span class="uId" onclick="cs.sort(this.className)">아이디</span>
				<span class="pwd" onclick="cs.sort(this.className)">비밀번호</span>
				<span class="uName" onclick="cs.sort(this.className)">성명</span>
				<span class="birth" onclick="cs.sort(this.className)">생년월일</span>
				<span class="phone" onclick="cs.sort(this.className)">전화번호</span>
				<span class="email" onclick="cs.sort(this.className)">이메일</span>
				<span class="zipCode" onclick="cs.sort(this.className)">우편번호</span>
				<span class="address" onclick="cs.sort(this.className)">주소</span>
				<span class="gender" onclick="cs.sort(this.className)">성별</span>
				<span class="joinDate" onclick="cs.sort(this.className)">가입일자</span>
			</div>
			<div class="items">
				<c:forEach var="vo" items="${list }" >
					<div class="item">
						<span class="uId">"${vo.uId }"</span>
						<span class="pwd">"${vo.pwd }"</span>
						<span class="uName">"${vo.uName }"</span>
						<span class="birth">"${vo.birth }"</span>
						<span class="phone">"${vo.phone }"</span>
						<span class="email">"${vo.email }"</span>
						<span class="zipCode">"${vo.zipCode }"</span>
						<span class="address">"${vo.address }"</span>
						<span class="gender">"${vo.gender }"</span>
						<span class="joinDate">"${vo.joinDate }"</span>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="paging">
				<c:if test="${Page.startPage>=1}">
				<button type="button" class="btnFirst" onclick="cs.movePage(1)">맨처음</button>
				<button type="button" class="btnPrev" onclick="cs.movePage(${Page.startPage-1})">이전</button>
				</c:if>
				
				<c:forEach var="i" begin="${Page.startPage }" end="${Page.endPage }">
				<button type="button" class="first" onclick='cs.movePage(${i})'>${i }</button>
				</c:forEach>
				
				
				<button type="button" class="btnNext"onclick="cs.movePage(${Page.endPage+1})">다음</button>
				<button type="button" class="btnLast"onclick="cs.movePage(${Page.totPage})">맨끝</button>
		</div>
	</div>

</body>
</html>