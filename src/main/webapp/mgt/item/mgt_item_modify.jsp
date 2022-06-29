<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mgt_item_input</title>
<script src='./lib/jquery-3.6.0.min.js'></script>
<script defer src="../js/mgt_main.js"></script>
</head>
<body>
<div id='mgt_item'>
	<h2>상품 수정/삭제</h2>
	<form name='frm_mgt_item' class='frm_mgt_item' method='post'>
		<label>도서코드</label>
		<input type='text' name='code' class='bookcode' size='40' value='${vo.code}'/><br/>
		<label>도서명</label>
		<input type='text' name='codeName' size='40' value='${vo.codeName}'/><br/>
		<label>저자</label>
		<input type='text' name='writer' size='40' value='${vo.writer}'/><br/>
		<label>출판사</label>
		<input type='text' name='company' size='40' value='${vo.company}'/><br/>
		<label>장르</label>
		<select name='category' id='category' size='1' > 
			<option value='100' <c:if test="${vo.category == '100'}" >selected</c:if>>소설</option>
			<option value='200' <c:if test="${vo.category == '200'}" >selected</c:if>>시/에세이</option>
			<option value='300' <c:if test="${vo.category == '300'}" >selected</c:if>>인문</option>
			<option value='400' <c:if test="${vo.category == '400'}" >selected</c:if>>자기계발</option>
			<option value='500' <c:if test="${vo.category == '500'}" >selected</c:if>>교재/참고서</option>
		</select><br/>
		<label>목차</label><br/>
		<label></label>
		<textarea name='list'>${vo.list}</textarea><br/>
		<label>내용</label><br/>
		<label></label>
		<textarea name='contents'>${vo.contents}</textarea><br/>
		<label>출간일</label>
		<input type='date' name='nal' value='${vo.nal}'/><br/>
		<label>단가</label>
		<input type='text' name='price' size='40' value='${vo.price}'/><br/>
		<label>수량</label>
		<input type='text' name='ea' size='40' value='${vo.ea}'/><br/>
		<label>이미지</label>
		<button type='button' name='img' class='btnFile' onclick='item.showFileTag()'>파일선택</button>
		<label></label>
		<img id='pre_image' src='./itemImg/${vo.img}' alt=''/>
		<div class='attList'></div>
		<div class='btnsModify'>
			<button type='button' onclick='item.modifyR(this.form)'>수정</button>
			<button type='button' onclick='item.delete(this.form)'>삭제</button>
			<button type='button' onclick='item.select(this.form)'>취소</button>
		</div>
		<br/>
		<input type='hidden' name='findStr' value='${param.findStr}'/>
		<input type='hidden' name='nowPage' value='${param.nowPage}'/>
		<input type='hidden' name='code' value='${vo.code}'/>
	</form>
	
	<form name='frm_att' class='frm_att' method='post' enctype='multipart/form-data' action='fileUpload'>
		<input type='file' name='attFile' class='file_tag' onchange='item.fileView(this)' style='display:none' />
		<input type='hidden' name='code' class='bookcode2' value='${vo.code}'>
		<!-- 파일 수정시 사용하는 태그 -->
		<input type='hidden' name='modifyFile' class='modifyFile'/>
		<!-- 파일 삭제시 사용하는 태그 -->
		<input type='hidden' name='delFile' class='delFile' value='${vo.img}'/>
	</form>
</div>
</body>
</html>