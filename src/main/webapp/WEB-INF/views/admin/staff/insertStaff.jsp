<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../include/css.jsp"%>
<title>thisisthat - 새글 등록</title>
</head>
<body>


<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="../include/sideMenu.jsp"%>

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<%@include file="../include/navbar.jsp"%>
				
				
				
				<div class="container-fluid">
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
								<span id="phoneCheck" style="display: block;"></span>
							</li>
							<li>E-MAIL *</li>
							<li class="input_li">
								<input class="input" type="email" name="email">
								<span id="emailCheck"></span>
							</li>
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
		</div>
	</div>
<script>

</script>
<%@include file="../include/js.jsp"%>

</body>
</html>