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
	
.welcomeWrap {
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
.resultTag {
	font-size: 10px;
	display:inline-block;
	width:50%;
	z-index: 99;
	text-transform: uppercase;
	font-weight: 700;
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
	display: inline-block;
	width: 40%;
}
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp" %>
		<div class="content">
			<div class="welcomeWrap">
				<div id="container">
					<div class="register_welcome">
						<form action="login.do" method="post" id="register_welcome">
							<div class="info">
								<div class="hello">
									<p>회원가입이 완료 되었습니다.</p>
									<p>
										<strong>${user.id}</strong> 님 환영합니다.
									</p>
									<br>
								</div>
								<ul>
									<li>
										<div class="resultTag">ID</div>
										<div class="resultText">
											<span>${user.id }</span>
										</div>
									</li>
									<br>
									<li>
										<div class="resultTag">이름</div>
										<div class="resultText">
											<span>${user.name }</span>
										</div>
									</li>
									<br>
									<li>
										<div class="resultTag">E-MAIL</div>
										<div class="resultText">
											<span>${user.email }</span>
										</div>
									</li>
								</ul>
								<br>
								<ul>
									<li>
										<input class="loginBtn" type="submit" value="로그인">
									</li>
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
			</div>
			<!-- end Content -->
			<%@include file="include/footer.jsp"%>
		</div>
	</div>
</body>
</html>