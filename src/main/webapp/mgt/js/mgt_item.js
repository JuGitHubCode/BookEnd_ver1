item = {}
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
		console.log('js : ' , modifyFile);
		$('.modifyFile').val(modifyFile);
		item.modifyCnt++;
	}
	console.log(item.modifyCnt);
}
	
/*list */
item.input = function(frm){
	frm.action = 'item.do?job=input';
	frm.submit();
}
//조회
item.find = function(frm){
	frm.nowPage.value = 1;
	item.select(frm);
}

item.select = function(frm){
	frm.action = 'item.do?job=select';
	frm.submit();
}

/*input*/
item.inputR = function(frm){

	let param = $(frm).serialize();
	
	$.post('item.do?job=inputR', param, function(){ 
	
		code = $('.bookcode').val();
		$('.bookcode2').val(code);
		
		let temp = $('.frm_att')[0];
		let frmAtt = new FormData(temp);
		
		$.ajax({
			data : frmAtt,
			url : 'fileUpload?flag=input',
			type : 'POST',
			enctype : 'multipart/form-data',
			cache : false,
			contentType : false,
			processData : false,
			success : function(resp){
				frm.action = 'item.do?job=select';
				frm.submit();
			}
		})
	})
}

// 리스트에서 modify로 이동
item.modify = function(code){
	let frm = $('.frm_mgt_item_list')[0];
	frm.code.value = code;
	frm.action = 'item.do?job=modify';
	frm.submit();
	
	item.modifyCnt = 0; //수정을 위해 수정할 파일갯수 초기화
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
				frm.action='item.do?job=select';
				frm.submit();
			}
		})
	});
	
	frm.action='item.do?job=select';
	frm.submit();
}
/*delete*/
item.delete = function(frm){
	let param = $(frm).serialize();
	$.post('item.do?job=delete', param, function(resp){
			let temp = $('.frm_att')[0]; //첨부된파일
			let param = $(temp).serialize();
			$.post("fileUpload?flag=delete", param, function(){
				//location.href = "item.do?job=select"; 
				frm.action='item.do?job=select';
				frm.submit();
			}) 
	})
}
/*movePage*/
item.movePage = function(page){
	let frm = $('.frm_mgt_item_list')[0];
	frm.nowPage.value = page;
	frm.action = 'item.do?job=select';
	frm.submit();
	
}

item.itemEa = function(frm){
	frm.action = 'item.do?job=selectEa';
	frm.submit();
}
item.itemCode = function(frm){
	frm.action = 'item.do?job=selectCode';
	frm.submit();
}
