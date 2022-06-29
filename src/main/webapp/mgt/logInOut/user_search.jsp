<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

/*search  */
#search{
	text-align:center;
}
#search>#frm_user_search{
	text-align: left;
}

#list #title{
	background-color:#aaa;
	color:#fff;
}

#title span{
	display: inline-block;
}
#list .uId{
	width: 90px;
	text-align: center;
}
#list .uName{
	width: 90px;
	text-align: center;
}
#list .job{
	width: 90px;
	text-align: center;
}
	
#list .item .uId{width: 90px; display: inline-block;}
#list .item .uName{width: 90px; display: inline-block;}r
#list .item .job{width: 90px; display: inline-block;}

#list #items>.item:nth-child(2n){
	background-color: #abc;
}

#list #items>.item:hover{
	background-color:#cba;
	cursor:pointer;
}
</style>
</head>
<body>
	<div id="search">
		<form name="frm_user_search" id="frm_user_search" method="post" action="../mgt_create_user.do?job=select">
			<label>아이디</label>
			<input type="text" id="uId">
			<input type="text" id="job">
			<!-- <label>성명</label>
			<input type="text" id="uName"> -->
			<input type="text" id="uId_select">
			<input type="text" id="job_select">
			<button type="submit" onclick="us.find(this.form)">검색</button>
		
		
			<div id="list">
				<div id=title>
					<span class="uId">아이디</span>
					<span class="uName">성명</span>
					<span class="job">권한</span>
				</div>
				<div id="items" >
				<c:forEach var="i" items="${list }">
					<div class="item" onclick="choice('${i.uId }', '${i.job }')">
						<span class="uId">${i.uId }</span>
						<span class="uName">${i.uName }</span>
						<span class="job">${i.job }</span>
					</div>
				</c:forEach>
				</div>
			</div>
		</form>
	</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script >
let us={};

console.log("test");
let openFrm=opener.document.frm_createUser;
let openFrm2=opener.document.frm_createUser;
let localFrm=document.frm_user_search;


/*localFrm.code.value=opeFrm.code.Value;*/

choice = function(uId, job){
let frm=$("#frm_user_search")[0];
frm.uId_select.value=uId;
frm.job_select.value=job;
console.log("uId"+frm.uId_select.value);

openFrm.uuId.value=frm.uId_select.value;
//openFrm2.job.value=frm.job_select.value;
self.close();
}

us.find=function(frm){
	console.log("find btn", frm);
	console.log("find uId", frm.uId.value);
	console.log("find job", frm.job.value);
	let param=$("#frm_user_search").serialize();
	console.log("frm param", param);
	//$.post("../mgt_create_user.do?job=select",param);
	
	//frm.action="../mgt_create_user.do?job=select";
	//frm.submit();
	
}
</script>
</body>
</html>