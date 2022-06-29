<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>temp</title>

<style>


</style>

</head>
<body>
	
	<div class="mid_main">
		<div class="slide" >
			<div>
			<br><br>
				<span class='best'> BEST </span>
				<div class="recommend_slide_wrap">
					<ul class="recommend_slide"> 
						<li class="recommand_book">
							<div>
								<div>
									<img src='./mgt/itemImg/AD_1.jpg' id='img1'
									 onclick='userSubPage.AD("9788932922362")'>
								</div>
								 <div>
								 	<textarea>
								 		${vo.contents}
								 	</textarea>
								 </div>
								 
							</div>
						</li>
						<li class="recommand_book">
							<div>
								<img src='./mgt/itemImg/AD_2.jpg' id='img2' width='1400px' height='700px'
								onclick='userSubPage.AD("9788954686891")'>
							</div>
						</li>
						<li class="recommand_book">
							<div>
								<img src='./mgt/itemImg/AD_3.jpg' id='img3' width='1400px' height='700px'
								onclick='userSubPage.AD("9791191114225")'>
							</div>
						</li>
						<li class="recommand_book">
							<div>
								<img src='./mgt/itemImg/AD_4.jpg' id='img4' width='1400px' height='700px'
								onclick='userSubPage.AD("9791165345204")'>
							</div>
						</li>
						<li class="recommand_book">
							<div>
								<img src='./mgt/itemImg/AD_5.jpg' id='img5' width='1400px' height='700px'
								onclick='userSubPage.AD("9791191043518")'>
							</div>
						</li>
						<li class="recommand_book">
							<div>
								<img src='./mgt/itemImg/AD_6.jpg' id='img6' width='1400px' height='700px'
								onclick='userSubPage.AD("9791191043754")'>
							</div>
						</li>
					</ul>
				</div>
			
				<div class="slide_btns">
					<button type="button" class="slide_btn" onclick="userSubPage.slideMove(0)"></button>
					<button type="button" class="slide_btn" onclick="userSubPage.slideMove(1)"></button>
					<button type="button" class="slide_btn" onclick="userSubPage.slideMove(2)"></button>
					<button type="button" class="slide_btn" onclick="userSubPage.slideMove(3)"></button>
					<button type="button" class="slide_btn" onclick="userSubPage.slideMove(4)"></button>
					<button type="button" class="slide_btn" onclick="userSubPage.slideMove(5)"></button>
				</div>
				<div class="slide_nav">
					<!-- <img src='./user/icon/prev.png' width='5%' class="prev" onclick="userSubPage.slidePrev()"> -->
					<!-- <span class="prev" onclick="userSubPage.slidePrev()">Prev</span>
					<span class="control" onclick="userSubPage.slideControl(this)">Stop</span>
					<span class="next" onclick="userSubPage.slideNext()">Next</span>	 -->	
					
					<img src='./user/icon/prev.png' width='3%' class="prev" onclick="userSubPage.slidePrev()">
					<img src='./user/icon/next.png' width='3%' class="next" onclick="userSubPage.slideNext()">
							
				</div>				
			</div>
			<form name='frm_AD' id='frm_AD' method='post'>
			</form>
		</div>
				
		<br><br><br><br><br>
		
		<div class='today_book'>
			
			<span>오늘의 한 권</span><br>
			<img src='./mgt/itemImg/7777777778888.jpg' width='600px' height='800px'>
			
			<h2>이 외 수</h2><br>
			<h3>책 소개</h3>
			
			
			<textarea id='book_intro'>
				${vo.contents}
			</textarea>
			
		</div>
		
		<br><br><br><br><br>
			
	</div>
	
	<script>
	let frm = document.getElementById("frm_AD");
	if($.post('#bookintro').hrml == ""){
		frm.action();
		frm.submit();
	}
		
	</script>
	
		
</body>
</html>