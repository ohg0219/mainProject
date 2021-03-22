$(document).ready(function(){
	function btn_on(){
		$("#registBtn").attr("disabled",false);
		$("#registBtn").css('cursor','pointer');
	}
	function btn_off(){
		$("#registBtn").attr("disabled",true);
		$("#registBtn").css('cursor','no-drop');
	}
	btn_off();
	$("input[name=id]").focus();
	$(".address_btn").on("click",function(e){
		e.preventDefault();
		DaumPostcode();
	});
	$(".register_btn").on("click",function(){
		if($("input[name=id]").val().trim() == ''){
			$("input[name=id]").focus();
			alert("아이디를 입력해주세요");
			return false;
		}
		if($("input[name=name]").val().trim() == ''){
			$("input[name=name]").focus();
			alert("이름을 입력해주세요");
			return false;
		}
		if($("input[name=nickName]").val().trim() == ''){
			$("input[name=nickName]").focus();
			alert("닉네임을 입력해주세요");
			return false;
		}
		if($("input[name=phone2]").val().trim() == ''){
			$("input[name=phone2]").focus();
			alert("전화번호를 입력해주세요");
			return false;
		}
		if($("input[name=phone3]").val().trim() == ''){
			$("input[name=phone3]").focus();
			alert("전화번호를 입력해주세요");
			return false;
		}
		if($("input[name=phone2]").val().trim() == ''){
			$("input[name=phone2]").focus();
			alert("전화번호를 입력해주세요");
			return false;
		}
		return true;
	});//end regist check
	// 아이디 유효성 검사(1 = 중복 / 1 != 중복x)
	$("input[name=id]").on("blur",function() {
		var user_id = $('input[name=id]').val();
		var regType1 =/^[A-za-z0-9]{4,16}/g;
		if (!regType1.test(user_id)) { 
			$("#idCheck").text("영문 대,소문자/숫자  4~16자로 입력해 주세요.");
			$("#idCheck").css("color", "red");
			$("input[name=id]").focus();
			btn_off();
		}else{
			$.ajax({
				url : '/user/idCheck.do?userId='+ user_id,
				type : 'get',
				success : function(data) {
					if (data==1) {
						$("input[name=id]").focus();
						$("#idCheck").text("사용중인 아이디입니다");
						$("#idCheck").css("color", "black");
						btn_off();
					} else {
						$("#idCheck").text("사용 가능한 아이디입니다.");
						$("#idCheck").css("color", "green");
						btn_on();
					}
				},
				error : function(data) {
						console.log("실패");
				}
			});
		}
	});//end idCheck
	$("input[name=nickName]").blur(function() {
		var nickName = $('input[name=nickName]').val();
		$.ajax({
			url : '/user/nickNameCheck.do?nickName='+ nickName,
			type : 'get',
			success : function(data) {
				if (data==1) {
					$("input[name=nickName]").focus();
					$("#nickNameCheck").text("사용중인 닉네임입니다");
					$("#nickNameCheck").css("color", "black");
					btn_off();
				} else {
					$("#nickNameCheck").text("");
					btn_on();
				}
			},
			error : function(data) {
					console.log("실패");
			}
		});
	});//end nickNameCheck
	//핸드폰번호 정규표현식 체크
	$("input[name=phone2]").on("keyup",function(){
		var regType3 = /^[0-9]{4,4}/g;
		var phone2 = $("input[name=phone2]").val();
		if(!regType3.test(phone2) || phone2.length!=4){
			$('#phoneCheck').text('정확한 핸드폰번호를 입력하세요.');
			$("#phoneCheck").css("color", "red");
			$("input[name=phone2]").focus();
			btn_off();
		}else{
			btn_on();
			$('#phoneCheck').text('');
		}
	});
	$("input[name=phone3]").on("keyup",function(){
		var regType4 = /^[0-9]{4,4}/g;
		var phone3 = $("input[name=phone3]").val();
		if(!regType4.test(phone3) || phone3.length!=4){
			$('#phoneCheck').text('정확한 핸드폰번호를 입력하세요.');
			$("#phoneCheck").css("color", "red");
			$("input[name=phone3]").focus();
			btn_off();
		}else{
			btn_on();
			$('#phoneCheck').text('');
		}
	});



});//end document ready function

