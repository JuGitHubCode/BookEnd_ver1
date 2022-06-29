<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mgt_item_input</title>
<script src='./lib/jquery-3.6.0.min.js'></script>
<%-- <link rel='stylesheet' type='text/css' href='./mgt/css/mgt_item.css'>--%>
<script defer src="../js/mgt_main.js"></script>
<!-- <script defer src='./mgt/js/mgt_item.js'></script> -->
</head>
<body>
<div id='mgt_item'>
	<h2>상품 등록</h2>
	<form name='frm_mgt_item' class='frm_mgt_item' method='post'>
		<label>도서코드</label>
		<input type='text' name='code' class='bookcode' size='40'/><br/>
		<label>도서명</label>
		<input type='text' name='codeName' size='40'/><br/>
		<label>저자</label>
		<input type='text' name='writer' size='40'/><br/>
		<label>출판사</label>
		<input type='text' name='company' size='40'/><br/>
		<label>장르</label>
		<select name='category'size='1'>
			<option value='100'>소설</option>
			<option value='200'>시/에세이</option>
			<option value='300'>인문</option>
			<option value='400'>자기계발</option>
			<option value='500'>교재/참고서</option>
		</select><br/>
		<label>목차</label><br/>
		<label></label>
		<textarea name='list'></textarea><br/>
		<label>내용</label><br/>
		<label></label>
		<textarea name='contents'></textarea><br/>
		<label>출간일</label>
		<input type='date' name='nal' id='tnal'/><br/>
		<label>단가</label>
		<input type='text' name='price' size='40'/><br/>
		<label>수량</label>
		<input type='text' name='ea' size='40'/><br/>
		<label>이미지</label> 
		<button type='button' name='img' class='btnFile' onclick='item.showFileTag()'>파일선택</button>
		<label></label>
		<img id='pre_image' src='#' alt=''/>
		<div class='attList'></div>
		<div class='btns'>
			<button type='button' onclick='item.inputR(this.form)' >저장</button>
			<button type='button' onclick='item.select(this.form)'>취소</button>
		</div>
		<br/>
		<input type='hidden' name='findStr' value='${param.findStr}'/>
		<input type='hidden' name='nowPage' value='${param.nowPage}'/>
	</form>

	<form name='frm_att' class='frm_att' method='post' 
		  enctype='multipart/form-data' action='fileUpload'>
		<input type='file' name='attFile' id='attFile' class='file_tag' 
	      onchange='item.fileView(this)' style='display:none'/>
		<input type='hidden' name='code' size='40' class='bookcode2' value=''/>
	</form>
	
</div>
</body>
</html>