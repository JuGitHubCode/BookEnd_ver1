<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mgt_item_list</title>
<script src='./lib/jquery-3.6.0.min.js'></script>
<link rel='stylesheet' type='text/css' href='../mgt/css/mgt_main.css'/>
<script defer src="../js/mgt_main.js"></script>
</head>
<body>
<div id='mgt_item_list'>
	<h2>상품 관리 페이지</h2>
	<form name='frm_mgt_item_list' class='frm_mgt_item_list' method='post'>
		<input type='hidden' name='nowPage' value='${param.nowPage}'/>
		<input type='hidden' name='code' />
		
		<button type='button' onclick='item.input(this.form)' class='btnInput'>상품 등록</button>
		<input type='text' name='findStr' value='${param.findStr}' />
		<button type='button' onclick='item.find(this.form)'>조회</button><br/>
		
		<div class='sortbtn'>		
			<button type='button' name='easort' class='btnEa' onclick='item.itemEa(this.form)'>재고순정렬</button>
			<button type='button' name='codesort' class='btnCode' onclick='item.itemCode(this.form)'>도서명정렬</button>
		</div>
	</form>

	<div class='title'>
		<span class='no'>NO</span>
		<span class='code'>도서코드</span>
		<span class='codeName'>도서명</span>
		<span class='writer'>저자</span>
		<span class='company'>출판사</span>
		<span class='category'>장르</span>
		<span class='list'>목차</span>
		<span class='contents'>내용</span>
		<span class='nal'>출간일</span>
		<span class='price'>단가</span>
		<span class='ea'>재고수량</span>
		<span class='img'>이미지</span>
	</div>
	
	<div class='items'> 
		<c:set var='i' value='${page.startNo+1}'/>
		<c:forEach var='vo' items='${list}'>		
			<div class='item' onclick='item.modify("${vo.code}")'>
				<span class='no'>${i}</span>
				<span class='code'>${vo.code}</span>
				<span class='codeName'>${vo.codeName}</span>
				<span class='writer'>${vo.writer} 지음</span>
				<span class='company'>${vo.company}</span>
				<span class='category'>${vo.category}</span>
				<span class='list'>${vo.list}</span>
				<span class='contents'>${vo.contents}</span>
				<span class='nal'>${vo.nal}</span>
				<span class='price'><fmt:formatNumber>${vo.price}</fmt:formatNumber> 원</span>
				<span class='ea'><fmt:formatNumber>${vo.ea}</fmt:formatNumber> 권</span>
				<span class='img' ><img src='./itemImg/${vo.img}' width='50px'/></span>
			</div>
			<c:set var='i' value='${i=i+1}'/>
		</c:forEach>
	</div>
	
	<div class='btns'>
		<c:if test='${page.startPage>1}'>
			<button type='button' onclick='item.movePage(1)'>처음</button>
			<button type='button' onclick='item.movePage(${page.startPage-1})'>이전</button>
		</c:if>
		<c:forEach var='i' begin='${page.startPage}' end='${page.endPage}'>
			<button type='button' onclick='item.movePage(${i})'>${i}</button>
		</c:forEach>
		<c:if test='${page.totPage>page.endPage}'>
		<button type='button' onclick='item.movePage(${page.endPage+1})'>다음</button>
		<button type='button' onclick='item.movePage(${page.totPage})'>마지막</button>
		</c:if>
	</div>

</div>
</body>
</html>