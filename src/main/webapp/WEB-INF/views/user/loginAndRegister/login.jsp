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
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="/resources/user/js/naveridlogin_js_sdk_2.0.2.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="619294176541-km5g9ed08619ijmirsaj6i4bsqife0dm.apps.googleusercontent.com">
<style type="text/css">
.loginwrap {
	height: 480px;
	margin: 0 auto;
	display: flex;
}

.login, .register {
	flex: 1; padding-top : 100px;
	vertical-align: middle;
	padding-top: 100px;
}

.login form{
	float: right;
	margin-right: 50px;
	width: 234px;
}

.login form ul {
	padding: 0;
}

.inputId,.inputPw,.loginBtn {
	all:unset;
	margin-bottom: 20px;
	width: 100%;
	border: 1px solid black;
	border-collapse:collapse;
	box-shadow: none;
	border-radius: 0;
	overflow: visible;
	text-align: right;
	height: 25px;
}
.inputId,.inputPw{
	font-size: 9pt;
	padding: 0px 8px;
}
.loginBtn {
	padding: 0px 8px;
	border: 1px solid black;
	background: black;
	cursor: pointer;
	text-align: center;
	color: white;
	width: 100%;
}
.register form{
	float: left;
	margin-left: 50px;
	width: 250px;
}

.register form ul {
	padding: 0;
}
.box_title{
	margin-bottom: 30px; 
	font-weight: bold;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$(".inputId").focus();
		$(".loginBtn").on("click",function(){
			if($("input[name=id]").val()==''){
				alert("아이디를 입력해주세요");
				return false;
			}
			if($("input[name=password]").val()==''){
				alert("비밀번호를 입력해주세요");
				return false;
			}
		});
	});
</script>
</head>
<body>
	<div class="wrap">
		<%@include file="../include/header.jsp" %>
		<div class="content">
			<div class="loginwrap">
				<div class="login" >
					<form action="loginCheck.do" method="post">
						<p class="box_title">LOG IN</p>
						<ul>
							<li>ID</li>
							<li><input class="inputId" type="text" name="id"></li>
							<li>PASSWORD</li>
							<li><input class="inputPw" type="password" name="password"></li>
							<li><input class="loginBtn" type="submit" value="로그인"></li>
							<li style="text-align: right;">								
								<a href="findIdPassword.do">FORGET YOUR ID / PASSWORD ?</a>
							</li>
						</ul>
							<div class="social_login">
								<a href="https://kauth.kakao.com/oauth/authorize?client_id=7ff3d3c85953e4c8234ff377259bd06b&redirect_uri=http://localhost:8080/kakaologin.do&response_type=code">
									<img style="width: 208px; height: 45px;" src="/resources/user/image/kakao_login_medium_narrow.png"/>
								</a>
								<div id="naverIdLogin"></div>
								<script type="text/javascript">
									var naverLogin = new naver.LoginWithNaverId(
										{
											clientId: "OfSXR45Si2nhF2qCVIOX",
											callbackUrl: "http://localhost:8080/naverLoginResult.do",
											isPopup: false, /* 팝업을 통한 연동처리 여부 */
											loginButton: {color: "green", type: 3, height: 45} /* 로그인 버튼의 타입을 지정 */
										}
									);
									
									/* 설정정보를 초기화하고 연동을 준비 */
									naverLogin.init();
								</script>
								<div class="g-signin2" data-onsuccess="onSignIn" data-width="208" data-height="45" data-theme="dark" data-longtitle="true"></div>
								<script type="text/javascript">
									function onSignIn(googleUser) {
										var profile = googleUser.getBasicProfile();
										console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
										console.log('Name: ' + profile.getName());
										console.log('Image URL: ' + profile.getImageUrl());
										console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
										location.href="http://localhost:8080/googlelogin.do?id="+profile.getId()+"&name="+ profile.getName()+"&email="+profile.getEmail();
									}
								</script>
							</div>
					</form>	
				</div>
				<div class="register">
					<form action="/register.do" method="get">
						<p class="box_title">REGISTER</p>
						<ul>
							<li><p>회원으로 가입하시면 여러가지 혜택과 함께<br>더 편리하게 사이트를 이용하실 수 있습니다.</p></li>
							<li><input class="loginBtn" type="submit" value="회원가입"></li>
						</ul>
					</form>	
				</div>
			</div>
		</div><!-- end Content -->
		<%@include file="../include/footer.jsp" %>
	</div>
</body>
</html>