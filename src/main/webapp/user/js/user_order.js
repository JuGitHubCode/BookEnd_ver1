/**
 * user_order
 */

(
	// date 오늘로 설정하기
	setOrderDate = function(){
   		document.getElementById('orderDate').value = new Date().toISOString().substring(0, 10);
		var od=new Date().toISOString().substring(0, 10);
		var od2=od.replaceAll("-","").substring(2, 8);
		document.getElementById('orderNo').value=od2+"test";
	}
)()




let user_order = {}; //index 페이지에 있는 아이여서.....




//우편번호 검색
let frm = document.frm_user_order;
console.log(frm);
//if(frm.btnZipFind != null){
//	frm.btnZipFind.onclick = 
 user_order.findZipCode =function(){
 		new daum.Postcode({
   			oncomplete : function(data){
				frm.rZipcode.value = data.zonecode;
				frm.rAddress.value = data.address; 
   	 		}
    	}).open();
	}


//최종 구매하기 버튼 클릭
user_order.orderPay = function(frm){
	frm.pay.value = $("input[name='pay']:checked").val();
	frm.action = 'order?job=orderPay';
	frm.submit();
}

//체크박스 
//$('#setD').click(
user_order.sameD = function(){
	let frm = document.frm_user_order;
	if($('#setD').is(':checked')==true){
		console.log("okkkk");
		//frm.action = 'order?job=setD';
		//frm.submit();
		frm.rName.value = frm.uName.value;
		frm.rPhone.value = frm.phone.value;
		frm.rZipcode.value = frm.zipCode.value;
		frm.rAddress.value = frm.address1.value;
		frm.rAddressD.value = frm.address2.value;
	}else{
		frm.rName.value = '';
		frm.rPhone.value = '';
		frm.rZipcode.value ='';
		frm.rAddress.value = '';
		frm.rAddressD.value = '';
	}
}

// 메인 페이지로 이동
user_order.moveMainPage = function(){
	location.href = 'index_main.jsp';
	console.log("MOVE");
	//frm.action = '../index_main.jsp';
	//frm.submit();
	
}

// 주문 상세 페이지로 이동
function moveMypageOrderDetail(frm){
	frm.action = './mypage.do?job=viewOrderDetail';
	frm.submit();
}