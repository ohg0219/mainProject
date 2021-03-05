$(document).ready(function(){	
	$(".menu > li").mouseleave(function(){
		 $(this).find(".sub_category").slideUp();  // 메뉴 슬라이드 업
	});
	$(".menu > li").mouseenter(function(){
		 $(this).find(".sub_category").slideDown();  // 메뉴 슬라이드 다운
	});
});	