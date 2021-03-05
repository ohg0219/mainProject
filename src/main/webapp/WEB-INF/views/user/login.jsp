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
	})
</script>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp" %>
		<div class="content">
			<div class="loginwrap">
				<div class="login" >
					<form action="login.do" method="post">
						<p class="box_title">LOG IN</p>
						<ul>
							<li>ID</li>
							<li><input class="inputId" type="text" name="id"></li>
							<li>PASSWORD</li>
							<li><input class="inputPw" type="password" name="password"></li>
							<li><input class="loginBtn" type="submit" value="로그인"></li>
							<li style="text-align: right;"><a href="#">FORGET YOUR PASSWORD?</a></li>
						</ul>
					</form>	
				</div>
				<div class="register">
					<form action="/register.do" method="post">
						<p class="box_title">REGISTER</p>
						<ul>
							<li><p>회원으로 가입하시면 여러가지 혜택과 함께<br>더 편리하게 사이트를 이용하실 수 있습니다.</p></li>
							<li><input class="loginBtn" type="submit" value="회원가입"></li>
						</ul>
					</form>	
				</div>
			</div>
		</div><!-- end Content -->
		<%@include file="include/footer.jsp" %>
	</div>
</body>
</html>