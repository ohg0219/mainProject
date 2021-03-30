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
<script src="/resources/user/js/register.js"></script>
<style type="text/css">
	.text_area{
	    overflow: auto;
    width:250px;
    height: 60px;
    padding: 12px;
    border: 1px solid #ddd;
    background: #fff;
    clear: both;
    margin: 8px 0;
    box-sizing: border-box;
        -webkit-writing-mode: horizontal-tb !important;
    text-rendering: auto;
    color: -internal-light-dark(black, white);
    letter-spacing: normal;
    word-spacing: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
    position: absolute;
	padding: 3px 10px;
	display: none;
    }
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="../include/header.jsp" %>
		<div class="content">
			<div class="register_wrap">
			 	<div class="register" > 
					<form action="register.do" method="post" id="registerForm">
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
							<li class="input_li">
								<input class="input" type="text" name="nickName">
								<span id="nickNameCheck"></span>	
							</li>
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
							<li class="">
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
								<span id="phoneCheck" style="display: block;"></span>
							</li>
							<li>SMS 수신</li>
							<li class="input_li">
								<label><input type="radio" name="smsOk" value="1">수신함</label>
								<label><input type="radio" name="smsOk" value="0" checked="checked">수신안함</label>					
							</li>
							<li>E-MAIL *</li>
							<li class="">
								<input class="input" type="email" name="email">
								<span id="emailCheck"></span>
							</li>
							<li>E-MAIL 수신</li>
							<li class="input_li">
								<label><input type="radio" name="emailOk" value="1">수신함</label>
								<label><input type="radio" name="emailOk" value="0" checked="checked">수신안함</label>					
							</li>
							<li class="input_li">
								<p>이용약관에 대한 동의</p><a class="utilizationDisplay" style="float: right">자세히 보기</a>
								<input type="checkbox" style="vertical-align: -2px;" name="terms"><label style="font-weight: normal;">동의함</label>
								
							</li>
							<li class="input_li" >
								<textarea id="utilizationDisplay" class="text_area"  readonly="readonly" required="required">${utilization}</textarea>
							</li>
							<li class="input_li">
								<p>개인정보 수집 및 이용에 대한 동의</p><a class="informationDisplay" style="float: right">자세히 보기</a>
								<input type="checkbox" name="privacyPolicy"><label style="font-weight: normal;">동의함</label>
							</li>
							<li class="input_li">
								<textarea id="informationDisplay" class="text_area" readonly="readonly" required="required">${information}</textarea>
							</li>
							<li><br><br><input id="registBtn" class="register_btn" type="submit" value="가입하기"></li>
						</ul>
					</form>	
			 	</div> 
				
			</div>
		</div><!-- end Content -->
		<%@include file="../include/footer.jsp" %>
	</div>
</body>
<script type="text/javascript">
$(document).ready(
		function() {
			$(".utilizationDisplay").on("click", function() {
				console.log('ad');
				var utilization = document.getElementById('utilizationDisplay');
				if(utilization.style.display == 'block'){
					utilization.style.display = 'none';
					return false;
				}else{
					utilization.style.display = 'block';
					
					return false;
				}
			});
			$(".informationDisplay").on("click", function() {
				console.log('ad');
				var information = document.getElementById('informationDisplay');
				if(information.style.display == 'block'){
					information.style.display = 'none';
					return false;
				}else{
					information.style.display = 'block';
					return false;
				}
			});
            
		
	});
</script>
</html>