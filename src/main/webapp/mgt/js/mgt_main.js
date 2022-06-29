/**
 * 자바먹조 
 * 2022.06.13
 * 관리자 메인페이지
 * 
 */
//객체 선언
let cs={};
let od={};
let us={};

//객체 선언
//item = {};

(
	mgt=function(){
		$(".mgt_book_list").hide();	
		$(".mgt_info_list").hide();	
		let frm=$(".frm_log")[0]
		var mId=frm.mId.value;
		//console.log(mId);
		//console.log("test1");
		if(mId=="주승환"){
		$("#btn_login").css("display","none");
		}else{
		}
		/*cs=function(){
			console.log("customer");
		}
		od=function(){
			
		}*/
	}
	
)()	
//$.post("localhost:5555/bookend_ju/mgt_main/mgt_main.jsp");


//=================================================================
//input, list
item = {};
item.modifyCnt = 0; //이미지 수정시, 처음의 기존 파일명 가져올것

/*filetag */
item.showFileTag = function(){
	let fileTag = $('.file_tag');
	fileTag.click();
}
/*fileview */
item.fileView = function(f){	
	let files = f.files;
	let file = Array.prototype.slice.call(files)[0];
	let str = '';
	let size = parseInt(file.size/10*10*10);
	
	str += `<div>
				<span>${file.name}(${size}Kb)</span>
			</div>`
			
	$('.attList').html(str);
	
	let dt = new DataTransfer();
	dt.items.add(file);
		
	$('.file_tag')[0].files = dt.files;
	
	// 이미지 미리보기
	let preview = new FileReader();
	preview.onload = function(e){
		document.getElementById('pre_image').src = e.target.result;
	}
	preview.readAsDataURL(f.files[0]);

	// 수정시 삭제할 파일명 가지고 오기
	if(item.modifyCnt == 0){
		let temp = $('#pre_image').attr('src');
		let modifyFile = temp.split("/");
		modifyFile = modifyFile[modifyFile.length-1]; //마지막값
		//console.log('js : ' , modifyFile);
		$('.modifyFile').val(modifyFile);
		item.modifyCnt++;
	}
	//console.log(item.modifyCnt);
}
	
/*list */
item.input = function(frm){
	//frm.action = 'item.do?job=input';
	//frm.submit();
	$('#main_section').load("item.do?job=input");
}
//조회
item.find = function(frm){
	frm.nowPage.value = 1;
	item.select(frm);
}

item.select = function(frm){
	//frm.action = 'item.do?job=select';
	//frm.submit();
	let param = $(frm).serialize();
	$('#main_section').load("item.do?job=select",param);
}

/*input*/
item.inputR = function(frm){
	
	let param = $(frm).serialize();
	$.post('item.do?job=inputR', param, function(){ 
	
		code = $('.bookcode').val();
		$('.bookcode2').val(code);
		
		let temp = $('.frm_att')[0];
		let frmAtt = new FormData(temp);
		//console.log("frmAtt:" , frmAtt);
		
		$.ajax({
			data : frmAtt,
			url : 'fileUpload?flag=input',
			type : 'POST',
			enctype : 'multipart/form-data',
			cache : false,
			contentType : false,
			processData : false,
			success : function(resp){
				//frm.action = 'item.do?job=select';
				//frm.submit();
				$('#main_section').load("item.do?job=select");
			}
		})
	})
}

// 리스트에서 modify로 이동
item.modify = function(code){
	let frm = $('.frm_mgt_item_list')[0];
	frm.code.value = code;
	let param = $(frm).serialize();
	
	//frm.action = 'item.do?job=modify';
	//frm.submit();
	//item.modifyCnt = 0; //수정을 위해 수정할 파일갯수 초기화
	$('#main_section').load("item.do?job=modify",param),function(){
		item.modifyCnt = 0;
	}
	//console.log('modicnt', item.modifyCnt )
}

/*modify */
item.modifyR = function(frm){
	
	let param = $(frm).serialize();
	$.post('item.do?job=modifyR', param, function(resp){
		
		let temp = $('.frm_att')[0];
		let frmAtt = new FormData(temp);
		
		$.ajax({
			data : frmAtt,
			type : 'POST',
			url : 'fileUpload?flag=modify',
			enctype : 'multipart/form-data',
			cache : false,
			contentType : false,
			processData : false,
			success : function(resp){
				//frm.action='item.do?job=select';
				//frm.submit();
				$('#main_section').load("item.do?job=select");
			}
		})
	});
	$('#main_section').load("item.do?job=select");
}
/*delete*/
item.delete = function(frm){
	let param = $(frm).serialize();
	$.post('item.do?job=delete', param, function(resp){
			let temp = $('.frm_att')[0]; //첨부된파일
			
			let param = $(temp).serialize();
			$.post("fileUpload?flag=delete", param, function(){
				//frm.action='item.do?job=select';
				//frm.submit();
				$('#main_section').load("item.do?job=select");
			}) 
	})
}
/*movePage*/
item.movePage = function(page){
	//console.log("page");
	let frm = $('.frm_mgt_item_list')[0];
	frm.nowPage.value = page;
	let param = $('.frm_mgt_item_list').serializeArray();
	$('#main_section').load("item.do?job=select",param);
	
}

item.itemEa = function(frm){
	//frm.action = 'item.do?job=selectEa';
	//frm.submit();
	$('#main_section').load("item.do?job=selectEa");
}
item.itemCode = function(frm){
	//frm.action = 'item.do?job=selectCode';
	//frm.submit();
	$('#main_section').load("item.do?job=selectCode");
}

//====================================================================










mgt.bookslide=function(list){
	if($(list).first().is(":hidden")){
		$(list).slideDown(300);
	
		if(list==".mgt_book_list"){
			$("#mgt_book_list_icon").css("transform","rotate(90deg)")
		}else{
			$("#mgt_info_list_icon").css("transform","rotate(90deg)")
		}
	}else{
		$(list).slideUp(300);
		if(list==".mgt_book_list"){
			$("#mgt_book_list_icon").css("transform","rotate(0deg)")
		}else{
			$("#mgt_info_list_icon").css("transform","rotate(0deg)")
		}
	}
}



mgt.movePage=function(url){
	console.log("movePage",url)
	$("#main_section").load(url);
}

mgt.create=function(){
	console.log("cerate")
	$("#main_section").load("logInOut/mgt_create_user.jsp");
}
mgt.input=function(){
	console.log("input");
	$("#main_section").load("item/mgt_item_input.jsp");
}

/*=================================================================*/
//고객 관리

cs.findSelect=function(frm){
	
	let fst=frm.findStr.value;
	
	frm.nowPage.value=1;
	let NM=frm.sort.value;
	console.log("NM:",NM);
	
	let st=frm.sortType.value;
	if(st=="asc"){
		st="desc"
	}
	
	let type=frm.type.value;
	
	let param=$(frm).serialize();
	$("#main_section").load("customer.do",param,function(){
		let frm=$(".frm_customer_list")[0];
		frm.findStr.value=fst;
		frm.sort.value=name;
		frm.sort.value=NM;
		frm.sortType.value=st;
		frm.type.value=type;
	});
}


cs.movePage=function(page){
	console.log("csmovePage",page);
	let frm=$(".frm_customer_list")[0];
	let fst=frm.findStr.value;
	
	frm.nowPage.value=page;
	let NM=frm.sort.value;
	console.log("NM:",NM);
	
	let st=frm.sortType.value;
	if(st=="asc"){
		st="desc"
	}
	
	let type=frm.type.value;
	
	let param=$(".frm_customer_list").serialize();
	console.log("csmovePage param" ,param);
	$("#main_section").load("customer.do",param,function(){
	console.log("NM f",NM);
	let frm=$(".frm_customer_list")[0];
	frm.findStr.value=fst;
	frm.sort.value=name;
	frm.sort.value=NM;
	frm.sortType.value=st;
	frm.type.value=type;
	});
}


cs.sort=function(name){
	console.log("name",name);
	let frm=$(".frm_customer_list")[0];
	let fst=frm.findStr.value;
	frm.sort.value=name;
	let NM=name;
	console.log("NM:",NM);
	
	let st=frm.sortType.value;
	if(st=="asc"){
		st="desc"
	}else{
		st="asc"
	}
	frm.sortType.value=st;
	
	let type=frm.type.value;
	
	let param=$(".frm_customer_list").serialize();
	console.log("csmovePage param" ,param);
	$("#main_section").load("customer.do",param,function(){
		console.log("NM f",NM);
		let frm=$(".frm_customer_list")[0];
		frm.findStr.value=fst;
		frm.sort.value=name;
		frm.sort.value=NM;
		frm.sortType.value=st;
		frm.type.value=type;
	});
}

/*=================================================================*/
//판매 관리
od.findSelect=function(frm){
	var date = new Date();
	var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
	var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
	console.log("firstDay",firstDay);
	console.log("lastDay",lastDay);
	
	console.log(od.date(firstDay));
	var std=od.date(firstDay);
	var edd=od.date(lastDay);
	console.log("std:",std);
	
	
	if(frm.std.value==""){
		$("#std").val(std);
		console.log("frm.std.value2 :",frm.std.value);
	}
	
	if(frm.edd.value==""){
		$("#edd").val(edd);
		console.log("frm.edd.value2 :",frm.edd.value);
	}
	
	let fst=frm.findStr.value;
	let st=frm.sortType.value;
	let type=frm.type.value;
	let btnSt=frm.btnSort.value;
	std=frm.std.value;
	edd=frm.edd.value
	
	console.log("fst",fst);
	console.log("st",st);
	console.log("std",std);
	console.log("edd",edd);
	console.log("type",type);
	
	frm.nowPage.value=1;
	
	
	let param=$(frm).serialize();
	$("#main_section").load("order.do",param,function(){
		let frm=$(".frm_order_list")[0];
		frm.findStr.value=fst;
		frm.sortType.value=st;
		frm.type.value=type;
		frm.btnSort.value=btnSt
		frm.std.value=std;
		frm.edd.value=edd;
	});
}

od.sort=function(frm){
	console.log("sort")
	if(frm.btnSort.value=="오름차순"){	
		$("#sortType").val("desc");
		$("#btnSort").val("내림차순");
	}else if(frm.btnSort.value=="내림차순"){
		console.log("내림차순")
		$("#sortType").val("asc");
		$("#btnSort").val("오름차순");
	}
	frm2=$(".frm_order_list")[0];
	console.log(frm.sortType.value);
	console.log(frm.btnSort.value);
	od.findSelect(frm2);
}



od.movePage=function(page){
	console.log("csmovePage",page);
	let frm=$(".frm_order_list")[0];
	
	frm.nowPage.value=page;
	
	let fst=frm.findStr.value;
	let st=frm.sortType.value;
	let type=frm.type.value;
	let btnSt=frm.btnSort.value;
	std=frm.std.value;
	edd=frm.edd.value
	
	
	let param=$(".frm_order_list").serialize();
	console.log("csmovePage param" ,param);
	$("#main_section").load("order.do",param,function(){
	frm=$(".frm_order_list")[0];
	frm.findStr.value=fst;
	frm.type.value=type;
	frm.sortType.value=st;
	frm.btnSort.value=btnSt
	frm.std.value=std;
	frm.edd.value=edd;
	});
}





od.date=function(date){
	console.log("date function:",date);
	var year =date.getFullYear();
	var month=(1+date.getMonth());
	console.log("date function month :",month);
	month = month>=10?month:'0'+month;
	console.log("date function month2 :",month);
	
	
	console.log("date function day :",day);
	var day=date.getDate();
	day=day>=10?day:'0'+day;
	console.log("date function day2 :",day);

	return year+"-"+month+"-"+day;
}


//=====================================================================================
//create user 

//=====================================================================================
//create user 

us.zipFind=function(){
	var btnZipFind=document.getElementById("btnZipcode");
	if(btnZipFind!=null){
	btnZipFind.onclick=function(){
		let frm=document.frm_createUser;
		new daum.Postcode({
				 oncomplete : function(data){
					 frm.zipCode.value=data.zonecode;
					 frm.address1.value=data.address;
				 }
			 }).open();
	}
}

}


us.type=function(value){
	console.log("type css", value);
	
	if(value=="i"){
		console.log("type if i", value);
		$("#i").css("display","");
		$("#u").css("display","none");
	}else{
		console.log("type if  u", value);
		$("#u").css("display","");
		$("#i").css("display","none");
	}
	//
}

us.save=function(frm){
	console.log("save btn", frm);
	console.log("i or u", frm.type.value);
	let type=frm.type.value;
	let uid=frm.uuId.value;
	let id=frm.uId.value;
	let pwd=frm.pwd.value;
	let uName=frm.uName.value;
	let phone=frm.phone.value;
	let email=frm.email.value;
	let zipCode=frm.zipCode.value;
	let address1=frm.address1.value;
	let address2=frm.address2.value;
	console.log("save",id);
	if(type=="i"){
		console.log("save type i");
		if(id==""||pwd==""||uName==""||phone==""||
		email==""||zipCode==""||address1==""||address2==""){
		alert("필수값을 입력해주십시오");
		}else{
		
		console.log("frm gender", frm.gender.value);
		let param=$("#frm_createUser").serialize();
		console.log("frm param", param);
		$("#main_section").load("mgt_create_user.do?job=insert",param);
		}
		
	}else{
		if(uid!=""){
			console.log("save type u")
		console.log("frm gender", frm.gender.value);
		let param=$("#frm_createUser").serialize();
		console.log("frm param", param);
		$("#main_section").load("mgt_create_user.do?job=update",param);
		}else{
			alert("필수값을 입력해주십시오");
		}
	}
	
}


us.find=function(){
	console.log("window");
	
	let frm=$("#frm_createUser")[0];

	var url="./logInOut/user_search.jsp";
	window.open(url,"win","width=300px", "height=600px");
}


