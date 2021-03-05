<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>
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
	height: 60px;
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
.address{
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
		$(".inputId").focus();
		$(".address_btn").on("click",function(e){
			e.preventDefault();
		});
	});

</script>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp" %>
		<div class="content">
			<div class="register_wrap">
				<div class="register" >
					<form action="register.do" method="post">
						<p class="box_title">SIGN UP</p>
						<ul>
							<li>ID *</li>
							<li class="input_li">
								<input class="input" type="text" name="id">
								<span class="register_comment">아이디 제약사항</span>
							</li>
							<li>PASSWORD *</li>
							<li class="input_li">
								<input class="input" type="password" name="password">
								<span class="register_comment">비번 제약사항</span>
							</li>
							<li>PASSWORD 확인 *</li>
							<li class="input_li"><input class="input" type="password" name="comfirmPassword"></li>
							<li>이름 *</li>
							<li class="input_li"><input class="input" type="text" name="name"></li>
							<li>주소</li>
							<li>
								<input class="zipcode" type="text" name="zipcode">
								<button class="address_btn" >우편번호</button>	
							</li>
							<li><input class="address" type="text" name="address1"></li>
							<li style="height: 60px;"><input class="address" type="text" name="address2"></li>
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
								<input type="checkbox" style="vertical-align: -2px;"><label style="font-weight: normal;">동의함</label>
							</li>
							<li class="input_li">
								<p>개인정보 수집 및 이용에 대한 동의</p>
								<input type="checkbox" style="vertical-align: -2px;"><label style="font-weight: normal;">동의함</label>
							</li>
							<li><input class="register_btn" type="submit" value="가입하기"></li>
						</ul>
					</form>	
				</div>
				
			</div>
		</div><!-- end Content -->
		<%@include file="include/footer.jsp" %>
	</div>
</body>
</html>