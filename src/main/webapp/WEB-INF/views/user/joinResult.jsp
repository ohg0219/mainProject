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


.content {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: transparent;
	margin-top : 50px;
}	
	
.register {
	width: 320px;
	margin: 0 auto;
	display: block;
	position: relative;
}

#container {
	position: relative;
	display: block;
	box-sizing: border-box;
	width: 100%;
	top: 60px;
	min-height: 90px;
}

.info {
	float: center;
	width: 250px;
}

.oneOne {
	float: left;
	font-size: 10px;
	z-index: 99;
	text-transform: uppercase;
	font-weight: 700 !important;
}

.twoOne {
	float: left;
	font-size: 10px;
	z-index: 99;
	text-transform: uppercase;
	font-weight: 700 !important;
}

.threeOne {
	float: left;
	font-size: 10px;
	z-index: 99;
	text-transform: uppercase;
	font-weight: 700 !important;
}

.loginBtn {
	padding: 1px 3px;
	border: 5px solid black;
	background: black;
	cursor: pointer;
	text-align: center;
	color: white;
	width: 100%;
	
}
.resultText{
	text-align: left;
}

</style>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp" %>
		
		<div class="content">
			<div class="register">
				<div id="container"> 
					<div align="center" class="register_welcome">			
						<form action="login.do" method="post" id="register_welcome">
							<div class="info">
								<div class="hello">
									<p>회원가입이 완료 되었습니다.</p>
									<p><strong>양예진</strong> 님은 <strong>N01</strong> 회원입니다.</p>
									<br>
								</div>
								<ul>
									<li>
										<div class="oneOne">ID</div>
										<div class="resultText">
											<span>dpwls2136</span>
										</div>
									</li>
									<br>
									<li>
										<div class="twoOne">이름</div>
										<div class="resultText">
											<span>양예진</span>
										</div>
									</li>
									<br>
									<li>
										<div class="threeOne">E-MAIL</div>
										<div class="resultText">
											<sapn>dpwls2136@naver.com</sapn>
										</div>	
									</li>
								</ul>
								<br>
								<ul>
									<li><input class="loginBtn" type="submit" value="로그인"></li>
								</ul>
								<br>
								<ul>
									<li>
							
										<img alt="이미지를 불러올 수 없습니다" src="/resources/user/image/thisisthat_coupon.PNG" height="120" width="230">
									</li>
								
								</ul>
								
							</div>
						
														
			
			
			
			
			
			
					</form>
				</div>
			</div>
		</div><!-- end Content -->
		<%@include file="include/footer.jsp" %>
		</div>
	</div>
</body>
</html>