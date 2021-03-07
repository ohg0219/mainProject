<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
.register{ 
	padding-top : 100px;
}
.register form{
	margin: 0 auto;
	width: 250px;
}

.register form ul {
	padding: 0;
}
.register form>ul>li{
	font-weight: bold;
}
.input_li{
	height: 70px;
}
.input{
	all:unset;
	width: 100%;
	border: 1px solid black;
	border-collapse:collapse;
	box-shadow: none;
	border-radius: 0;
	overflow: visible;
	font-weight: normal;
	padding: 7px 8px;
}
.register_comment{
	color: red;
	font-weight: normal;
	display: block;
}
.zipcode{
	all:unset;
	margin-bottom: 5px;
	width: 30%;
	border: 1px solid black;
	border-collapse:collapse;
	box-shadow: none;
	border-radius: 0;
	overflow: visible;
	padding: 7px 8px;
	font-weight: normal;
}
.address_{
	all:unset;
	margin-bottom: 5px;
	width: 100%;
	border: 1px solid black;
	border-collapse:collapse;
	box-shadow: none;
	border-radius: 0;
	overflow: visible;
	padding: 7px 8px;
	font-weight: normal;
}
.address_btn{
	all:unset;
	border: 1px solid black; 
	padding: 7px;
	background-color: black;
	color: white;
	cursor: pointer;
}
.input_tel{
	border: none;
	font-size: 11px;
	width: 60px;
	height: 22px;
}
.input_phone{
	all:unset;
	margin-bottom: 5px;
	border: 1px solid black;
	border-collapse:collapse;
	box-shadow: none;
	border-radius: 0;
	overflow: visible;
	padding: 7px 8px;
	font-weight: normal;
	width: 20%;
	
}
.register_btn{
	all:unset;
	padding: 0px 8px;
	margin-bottom: 20px;
	width: 100%;
	border-collapse:collapse;
	box-shadow: none;
	border-radius: 0;
	overflow: visible;
	height: 25px;
	border: 1px solid black;
	background: black;
	cursor: pointer;
	text-align: center;
	color: white;
	width: 100%;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$(".address_btn").on("click",function(e){
			e.preventDefault();
		});
		$("input[name=id]").focus();
		
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
			$.ajax({
				url : '/user/idCheck.do?userId='+ user_id,
				type : 'get',
				success : function(data) {
					console.log("1 = 중복o / 0 = 중복x : "+ data);							
					if (data==1) {
						$("input[name=id]").focus();
						$("#idCheck").text("사용중인 아이디입니다");
						$("#idCheck").css("color", "black");
					} else {
						$("#idCheck").text("");
					}
				},
				error : function(data) {
						console.log("실패");
				}
			});
		});//end idCheck
		// 비밀번호 유효성 검사
	    $("input[name=password]").keyup(function(){
	      $("#passwordCheck").text("");
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
								<span class="register_comment">아이디 제약사항</span>
								<span id="idCheck"></span>
							</li>
							<li>PASSWORD *</li>
							<li class="input_li">
								<input class="input" type="password" name="password">
								<span class="register_comment">비번 제약사항</span>
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
								<input class="zipcode" type="text" name="zipcode">
								<button class="address_btn" >우편번호</button>	
							</li>
							<li><input class="address_" type="text" name="address1"></li>
							<li style="height: 60px;"><input class="address_" type="text" name="address2"></li>
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