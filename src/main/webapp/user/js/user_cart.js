$(function(){
	compute();
})

function compute(){
	let itemEa = document.querySelectorAll(".item_ea");
	let itemPrice = document.querySelectorAll(".book_price");
	let itemAmt = document.querySelectorAll(".item_amt");
	let totAmt = 0;
	
	for(let i = 0; i < itemEa.length; i++){
		var ea = Number($(itemEa[i]).html());
		var price = Number($(itemPrice[i]).val());
		var amt = ea * price;
		$(itemAmt[i]).html(amt.toLocaleString()+"원");
		totAmt += amt;
	}
	
	$(".tot_amt").html(totAmt.toLocaleString()+"원");
}
	
function minusItem(code){
	let frm = $("#frm_user_cart")[0];
	let uId = frm.uId.value;
	let ea = $(".ea_"+code).html();
	
	if(ea == 1){
		alert("상품의 최소 갯수는 1개입니다.");
	} else {
		ea -= 1;
		$(".ea_"+code).html(ea);
		compute();
		// db 갯수 감소 적용
		$.post("./cart.do?job=minusItem", "ea="+ea+"&code="+code+"&uId="+uId);
	}
}

function plusItem(code){
	let frm = $("#frm_user_cart")[0];
	let uId = frm.uId.value;
	let ea = Number($(".ea_"+code).html());
	let stock = Number($(".stock_"+code).val());
	
	if(ea == stock){
		alert("현재 재고의 최대 갯수입니다.");
	} else {
		ea += 1;
		$(".ea_"+code).html(ea);
		compute();
		// db 갯수 증가 적용
		$.post("./cart.do?job=plusItem", "ea="+ea+"&code="+code+"&uId="+uId);
	}
}

function deleteItem(code, btn){
	let chk = confirm("장바구니에서 삭제하시겠습니까?");
	if(!chk) return;
	
	let frm = $("#frm_user_cart")[0];
	let uId = frm.uId.value;
	let item = $(btn).parent();
	$(item).remove();
	// db 삭제하기
	$.post("./cart.do?job=deleteItem", "code="+code+"&uId="+uId);
}

$(".btn_all_check").on("click", function(){
	let check = document.querySelectorAll(".item_check");
	for(let i = 0; i < check.length; i++){
		$(check[i]).prop("checked", true);
	}
})

$(".btn_check_delete").on("click", function(){
	let chk = confirm("선택한 상품을 장바구니에서 삭제하시겠습니까?");
	if(!chk) return;
	
	let frm = $("#frm_user_cart")[0];
	let uId = frm.uId.value;
	let check = document.querySelectorAll(".item_check");
	let item;
	
	for(let i = 0; i < check.length; i++){
		if($(check[i]).prop("checked")){
			item = $(check[i]).parent().parent();
			$(item).remove();
			// db삭제
			$.post("./cart.do?job=deleteAllItem", "uId="+uId);
		}
	}
})

function moveOrderPage(){
	// 주문하기 페이지로 이동
	let frm = $("#frm_user_cart")[0];
	frm.action = 'order?job=selectUId';
	frm.submit();
}
