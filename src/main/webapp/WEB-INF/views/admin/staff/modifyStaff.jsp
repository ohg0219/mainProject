<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="/resources/user/css/common.css">
<link rel="stylesheet" href="/resources/admin/css/register.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%@include file="../include/css.jsp"%>
<title>thisisthat - 내정보 수정</title>
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
					<form action="/admin/modifyStaff.mdo" method="post" id="registerForm">
						<p class="box_title">SIGN UP</p>
						
						<ul style="float: left">
							<li>ID *</li>
							<li class="input_li">
								<input class="input" type="text" name="userId" value="${staff.userId}" readonly="readonly">
							</li>
							<li>PASSWORD *</li>
							<li class="input_li">
								<input class="input" type="password" name="userPw"><br>
								<span id="passwordRegChk"></span>
							</li>
							<li>PASSWORD 확인 *</li>
							<li class="input_li">
								<input class="input" type="password" name="confirmPassword">
								<br>
								<span id="passwordCheck"></span>
							</li>
							<li>이름 </li>
							<li class="input_li"><input class="input" type="text" name="userName" value="${staff.userName}" readonly="readonly"></li>
							<li>닉네임 *</li>
							<li class="input_li">
								<input class="input" type="text" name="nickName" value="${staff.nickName }">
							</li>
							<li>주소</li>
							<li>
								<input class="zipcode" type="text" name="zipCode" id="zipcode" readonly="readonly" value="${staff.zipCode}" required="required">
								<button class="address_btn">우편번호</button>	
							</li>
							<li><input class="address_" type="text" name="firstAddress" id="address1" readonly="readonly" required="required" value="${staff.firstAddress}"></li>
							<li style="height: 60px;">
								<input class="address_" type="text" name="lastAddress" id="address2" required="required" value="${staff.lastAddress}">
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
							<li>E-MAIL *</li>
							<li class="">
								<input class="input" type="email" name="userEmail" value="${staff.userEmail }" required="required">
								<br>
								<span id="emailCheck"></span>
							</li>
							
							<li style="margin-top: 50px"><input id="registBtn" class="register_btn" type="submit" value="정보수정"></li>
						</ul>
					</form>	
				</div>
			</div>
		</div>
	</div>
<script>

</script>
<%@include file="../include/js.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	function btn_on(){
		$("#registBtn").attr("disabled",false);
		$("#registBtn").css('cursor','pointer');
	}
	function btn_off(){
		$("#registBtn").attr("disabled",true);
		$("#registBtn").css('cursor','no-drop');
	}
	btn_off();
	$(".address_btn").on("click",function(e){
		e.preventDefault();
		DaumPostcode();
	});
	//비밀번호 유효성 검사
	$("input[name=userPw]").on("keyup",function(){
	    var password = $("input[name=userPw]").val();
	    var regType2 = /^[A-za-z0-9]{8,16}/g;
	    if(!regType2.test(password)){
	        $('#passwordRegChk').text('영문 대,소문자/숫자  8~16자로 입력해 주세요.');
	        $("#passwordRegChk").css("color", "red");
	        $("input[name=userPw]").focus();
	        btn_off();
	    }else{
	        $("#passwordRegChk").text("");
	        btn_on();
	    }
	});
	// 비밀번호 와 비밀번호 확인 일치확인
	$("input[name=confirmPassword]").keyup(function(){
	    if($('input[name=userPw]').val() != $('input[name=confirmPassword]').val()){
	      $('#passwordCheck').text('비밀번호 일치하지 않음');
	      $("#passwordCheck").css("color", "red");
	      btn_off();
	    } else{
	      $('#passwordCheck').text('비밀번호 일치함');
	      $("#passwordCheck").css("color", "black");
	      btn_on();
	    }
	});//end passwordCheck
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
	$("input[name=userEmail]").on("blur",function(){
		var regType5 = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		var email = $("input[name=userEmail]").val();
		if(!regType5.test(email)){
			$("#emailCheck").text("정확한 이메일을 입력하세요.");
			$("#emailCheck").css("color","red");
			$("input[name=userEmail]").focus();
			btn_off();
		}else{
			$("#emailCheck").text("");
			btn_on();
		}
	});
});
</script>
</body>
</html>