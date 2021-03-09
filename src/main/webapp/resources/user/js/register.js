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
		if($("input[name=password]").val().trim() == ''){
			$("input[name=password]").focus();
			alert("비밀번호를 입력해주세요");
			return false;
		}
		if($("input[name=confirmPassword]").val().trim() == ''){
			$("input[name=confirmPassword]").focus();
			alert("비밀번호 확인을 입력해주세요");
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
		if($("input[name=email]").val().trim() == ''){
			$("input[name=email]").focus();
			alert("이메일을 입력해주세요");
			return false;
		}
		if($("input[name=phone2]").val().trim() == ''){
			$("input[name=phone2]").focus();
			alert("전화번호를 입력해주세요");
			return false;
		}
		if($("input[name=terms]").is(":checked")==false){
			alert("이용약관에 대한 동의를 해주세요");
			return false;
		}
		if($("input[name=privacyPolicy]").is(":checked")==false){
			alert("개인정보 수집 및 이용에 대한 동의를 해주세요");
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
			$("#idCheck").css("color", "black");
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
						$("#idCheck").text("");
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
	// 비밀번호 유효성 검사
	$("input[name=password]").on("keyup",function(){
        var password = $("input[name=password]").val();
        var regType2 = /^[A-za-z0-9]{8,16}/g;
        if(!regType2.test(password)){
            $('#passwordRegChk').text('영문 대,소문자/숫자  8~16자로 입력해 주세요.');
            $("#passwordRegChk").css("color", "red");
            $("input[name=password]").focus();
            btn_off();
        }else{
            $("#passwordRegChk").text("");
            btn_on();
        }
    });
    
    $("input[name=confirmPassword]").keyup(function(){
        if($('input[name=password]').val() != $('input[name=confirmPassword]').val()){
          $('#passwordCheck').text('비밀번호 일치하지 않음');
          $("#passwordCheck").css("color", "red");
          btn_off();
        } else{
          $('#passwordCheck').text('비밀번호 일치함');
          $("#passwordCheck").css("color", "black");
          btn_on();
        }
    });//end passwordCheck
});//end document ready function
//다음 주소 api
function DaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = '';
            var extraAddr = '';
            if (data.userSelectedType === 'R') {
                addr = data.roadAddress;
            } else {
                addr = data.jibunAddress;
            }
            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
            }
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("address1").value = addr + extraAddr;
            document.getElementById("address2").focus();
        }
    }).open();
}//end postcode function