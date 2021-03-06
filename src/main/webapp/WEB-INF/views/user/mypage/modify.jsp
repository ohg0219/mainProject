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
<script src="/resources/user/js/modify.js"></script>
</head>
<body>
	<div class="wrap">
		<%@include file="../include/header.jsp" %>
		<div class="content">
			<div class="register_wrap">
			 	<div class="register" > 
					<form action="mypageModify.do" method="post" id="registerForm">
						<input type="hidden" name="nickName" value=	"${modify.nickName}">
						<p class="box_title"> <strong>${modify.name} [${modify.id}]</strong></p>
						<br>
						<ul>
							<li>ID *</li>
							<li class="input_li">
								<input class="input" type="text" name="id" value="${modify.id }" readonly="readonly">
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
							<li class="input_li"><input class="input" type="text" name="name" value="${modify.name}" readonly="readonly"></li>
						
							<li>주소 *</li>
							<li>
								<input class="zipcode" type="text" name="zipcode" id="zipcode" value="${modify.zipcode}">
								<button class="address_btn">우편번호</button>	
							</li>
							<li><input class="address_" type="text" name="address1" id="address1" value="${modify.address1 }"></li>
							<li style="height: 60px;">
								<input class="address_" type="text" name="address2" id="address2" value="${modify.address2 }">
							</li>
							<li>휴대전화 *</li>
							<li class="input_li">
								<select class="input_tel" name="phone1">
									<option <c:if test="${phone1 =='010' }">selected</c:if>>010</option>
									<option <c:if test="${phone1 =='011' }">selected</c:if>>011</option>
									<option <c:if test="${phone1 =='016' }">selected</c:if>>016</option>
									<option <c:if test="${phone1 =='017' }">selected</c:if>>017</option>
									<option <c:if test="${phone1 =='018' }">selected</c:if>>018</option>
									<option <c:if test="${phone1 =='019' }">selected</c:if>>019</option>
								</select>
								<span>-</span>
								<input class="input_phone" type="tel" name="phone2" size="4" value="${phone2}">
								<span>-</span>
								<input class="input_phone" type="tel" name="phone3" size="4" value="${phone3}">
								<span id="phoneCheck" style="display: block;"></span>
							</li>
							
							<li>SMS 수신</li>
							<li class="input_li">
								<label><input type="radio" name="smsOk" value="1" <c:if test="${modify.smsOk == 1 }">checked</c:if>>수신함</label>
								<label><input type="radio" name="smsOk" value="0" <c:if test="${modify.smsOk == 0 }">checked</c:if>>수신안함</label>					
							</li>
							<li>E-MAIL *</li>
							<li class="">
								<input class="input" type="email" name="email" value="${modify.email }">
								<span id="emailCheck"></span>
							</li>
							<li>E-MAIL 수신</li>
							<li class="input_li">
								<label><input type="radio" name="emailOk" value="1" <c:if test="${modify.emailOk == 1 }">checked</c:if>>수신함</label>
								<label><input type="radio" name="emailOk" value="0" <c:if test="${modify.emailOk == 0 }">checked</c:if>>수신안함</label>					
							</li>
							<li></li>
							<li></li>
							
							<li><input id="registBtn" class="register_btn" type="submit" value="수정하기"></li>
						</ul>
						
						<h3>
							<a href="delUser.do" style="border-bottom: 1px solid #111; padding-bottom: 4px; text-decoration: none; color: black">
								<strong class="input_li">회원 탈퇴하기</strong>
							</a>
						</h3>
												
					</form>	
			 	</div> 
				
			</div>
							
		</div><!-- end Content -->
		
		<%@include file="../include/footer.jsp" %>
	</div>
</body>
<script type="text/javascript">
	function checkPW(){
		document.getElementById('userDelTable').style.display = 'block';
	}
</script>
</html>