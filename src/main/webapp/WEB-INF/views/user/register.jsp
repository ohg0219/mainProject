<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<link rel="stylesheet" href="/resources/user/css/register.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	var registerBtn = document.getElementById("registBtn");
	function btn_off(){
		registerBtn.disabled="disabled";
	}
	function btn_on(){
		registerBtn.disabled=false;
	}
	$(document).ready(function(){
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
		$("input[name=id]").blur(function() {
			var user_id = $('input[name=id]').val();
			var regType1 =/^[A-za-z0-9]{4,16}/g;
			if (!regType1.test(user_id)) { 
				$("#idCheck").text("영문 대,소문자/숫자  4~16자로 입력해 주세요.");
				$("#idCheck").css("color", "black");
				$("input[name=id]").focus();
			}else{
				$.ajax({
					url : '/user/idCheck.do?userId='+ user_id,
					type : 'get',
					success : function(data) {
						if (data==1) {
							$("input[name=id]").focus();
							$("#idCheck").text("사용중인 아이디입니다");
							$("#idCheck").css("color", "black");
						} else {
							$("#idCheck").text("");
							flag = true;
						}
					},
					error : function(data) {
							console.log("실패");
					}
				});
			}
		});//end idCheck
		// 비밀번호 유효성 검사
		
	    $("input[name=password]").on("keyup blur",function(){
	        var password = $("input[name=password]").val();
	        var regType2 = /^[A-za-z0-9]{8,16}/g;
	        if(!regType2.test(password)){
	            $('#passwordRegChk').text('영문 대,소문자/숫자  8~16자로 입력해 주세요.');
	            $("#passwordRegChk").css("color", "red");
	            $("input[name=password]").focus();
	        }else{
	            $("#passwordRegChk").text("");	
	        }
	    });
	    
	    $("input[name=confirmPassword]").keyup(function(){
	        if($('input[name=password]').val() != $('input[name=confirmPassword]').val()){
	          $('#passwordCheck').text('비밀번호 일치하지 않음');
	          $("#passwordCheck").css("color", "red");
	        } else{
	          $('#passwordCheck').text('비밀번호 일치함');
	          $("#passwordCheck").css("color", "black");
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
    
</script>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp" %>
		<div class="content">
			<div class="register_wrap">
				<div class="register" >
					<form action="regist.do" method="post" id="registerForm">
						<p class="box_title">SIGN UP</p>
						<ul>
							<li>ID *</li>
							<li class="input_li">
								<input class="input" type="text" name="id">
								<span class="register_comment">영문 대,소문자/숫자, 4~16자</span>
								<span id="idCheck"></span>
							</li>
							<li>PASSWORD *</li>
							<li class="input_li">
								<input class="input" type="password" name="password">
								<span class="register_comment">영문 대,소문자/숫자, 8~16자</span>
								<span id="passwordRegChk"></span>
							</li>
							<li>PASSWORD 확인 *</li>
							<li class="input_li">
								<input class="input" type="password" name="confirmPassword">
								<span id="passwordCheck"></span>
							</li>
							<li>이름 *</li>
							<li class="input_li"><input class="input" type="text" name="name"></li>
							<li>닉네임 *</li>
							<li class="input_li"><input class="input" type="text" name="nickName"></li>
							<li>주소</li>
							<li>
								<input class="zipcode" type="text" name="zipcode" id="zipcode">
								<button class="address_btn">우편번호</button>	
							</li>
							<li><input class="address_" type="text" name="address1" id="address1"></li>
							<li style="height: 60px;">
								<input class="address_" type="text" name="address2" id="address2">
							</li>
							<li>휴대전화 *</li>
							<li class="input_li">
								<select class="input_tel" name="phone1">
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>018</option>
									<option>019</option>
								</select>
								<span>-</span>
								<input class="input_phone" type="tel" name="phone2" size="4">
								<span>-</span>
								<input class="input_phone" type="tel" name="phone3" size="4">
							</li>
							<li>E-MAIL *</li>
							<li class="input_li"><input class="input" type="email" name="email"></li>
							<li class="input_li">
								<p>이용약관에 대한 동의</p>
								<input type="checkbox" style="vertical-align: -2px;" name="terms"><label style="font-weight: normal;">동의함</label>
							</li>
							<li class="input_li">
								<p>개인정보 수집 및 이용에 대한 동의</p>
								<input type="checkbox" style="vertical-align: -2px;" name="privacyPolicy"><label style="font-weight: normal;">동의함</label>
							</li>
							<li><input id="registBtn" class="register_btn" type="submit" value="가입하기"></li>
						</ul>
					</form>	
				</div>
				
			</div>
		</div><!-- end Content -->
		<%@include file="include/footer.jsp" %>
	</div>
</body>
</html>