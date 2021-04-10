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
#m19 {
    position: absolute;
    top: 0;
    left: 0;
    display: block;
    width: 100%;
    height: 100%;
    background: transparent;
}

.wrap {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: transparent;
	margin-top: 50px;
}

#container {
    width: 100%;
    max-width: 100%;
    margin: 0 auto;
}

#contents {
    position: relative;
    display: block;
    box-sizing: border-box;
    width: 100%;
}

#header > .inner {
    position: relative;
    top: 0px;
    width: 100%;
    max-width: 100%;
    margin: 0 0;
    box-sizing: border-box;
    border: 0px solid #111;
    display: block;
    height: auto;
    z-index: 99;
    padding: 8px 20px;
    *zoom: 1;
}
.inr {
    position: relative;
    display: block;
    box-sizing: border-box;
    width: 100%;
    height: auto;
    padding: 0 20px;
}

.w-1 {
	margin : 0 auto;
    padding: 0 0;
    min-width: 40px;
    box-sizing: border-box;
    display: block;
}

.xans-member-findid .findId {
    width: 240px;
    margin: 0 auto;
}
.xans-member-findid {
    height: 100%;
    margin-top: 80px; 
}	
.xans-member-findid .findId h3 {
    text-align: left;
    display: block;
    font-weight: 700 !important;
    font-size: 10px !important;
    color: #111;
    text-transform: uppercase;
}
fieldset {
    border: 0;
    padding: 0;
}
fieldset {
    display: block;
    margin-inline-start: -7px;	
    margin-inline-end: 2px;
    padding-block-start: 0.35em;
    padding-inline-start: 0.75em;
    padding-inline-end: 0.75em;
    padding-block-end: 0.625em;
    min-inline-size: min-content;
}
legend {
    display: block;
    padding-inline-start: 2px;
    padding-inline-end: 2px;
    border-width: initial;
    border-style: none;
    border-color: initial;
    border-image: initial;
}
legend {
    visibility: hidden;
    position: absolute;
    left: -9999px;
    top: -9999px;
    width: 0;
    height: 0;
    line-height: 0;
}

.xans-member-findid .findId .check {
    padding: 0;
    margin: 8px 0 28px 84px;
    color: #111;
}

.xans-member-findid .findId .check label {
    margin: 0 8px 0 0;
    font-size: 10px;
}

.xans-member-findid .findId input[type=radio], .xans-member-findid .findId input[type=checkbox] {
    width: 12px;
    height: 12px;
    margin: 0 4px 0 0;
    padding: 10;
    border: 0;
    vertical-align: -2px;
    *vertical-align: 2px;
}

p {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
}

.xans-member-findid .findId strong {
    font-size: 10px;
    position: relative;
    display: block;
    padding: 0 0 4px;
    z-index: 99;
    text-transform: uppercase;
    font-weight: 700;
}
.xans-member-findid .findId .method {
	margin-bottom: 20px;
}

.xans-member-findid .findId #name, .xans-member-findid .findId #email, .xans-member-findid .findId #id {
    width: 100%;
}

.xans-member-findid .findId .button {
    margin: 0 0;
    text-align: left;
}

.xans-member-findid .findId a.btn-1 {
    width: 100%;
    margin-top: 12px;
}

a.btn-1, input.btn-1 {
    display: inline-block;
    color: #fff;
    background: #111;
    border-radius: 1px;
    cursor: pointer;
    width: auto;
    height: auto;
    box-sizing: border-box !important;
    font-weight: 700 !important;
    border: 1px solid #111;
    margin-bottom: 4px;
    font-size: 11px;
    text-align: center;
    text-transform: uppercase;
    padding: 6px 20px;
}

a {
    text-decoration: none;
    color: #9a9592;
    
}

.xans-member-findid p.fpw {
    display: block;
    margin-top: 12px;
    text-align: right;
}

.xans-member-findid p.fpw a {
    text-transform: uppercase;
    font-size: 10px;
    color: #111;
}

.xans-member-findid .findId #pw_phone1, #id_phone1 {
    width: 53px;
    padding: 5px 8px;
}

.xans-member-findid .findId #pw_phone2, #id_phone2 {
    width: 65px;
    padding: 5px 8px;
}
.xans-member-findid .findId #pw_phone3, #id_phone3 {
    width: 65px;
    padding: 5px 8px;
}


.xans-member-findid .findId input {
    position: relative;
    height: auto;
    width: 100%;
    font-size: 11px;
    padding: 6px 8px;
    font-size: 11px;
    border: 1px solid #111;
    box-sizing: border-box;
    margin-bottom: 8px;
    text-transform: none;
}

</style>
</head>
<body>
	<div class="wraped">
		<%@include file="../include/header.jsp"%>
		<div id="wrap">
        	<div id="container">
 	           <div id="contents">
               	  <div class="inr">
					<div class="w-1 f-i">
					
					<form action="findId.do" method="post" name="findIdForm" id="findIdForm">
						<input type="hidden" name="returnUrl" value="/member/id/find_id_result.html" id="returnUrl" >
						<div class="xans-element- xans-member xans-member-findid">
							<div class="findId">
							
							<h3>forgot your id?</h3>
    						<fieldset>
							<legend>아이디 찾기</legend>
    						<div class="method">
								<input type="radio" id="check_method1" name="check_method" value="email" checked="checked" onchange="setIdDisplay()">
									<label for="check_method1">이메일 &nbsp; </label>
								<input type="radio" id="check_method2" name="check_method" value="phone" onchange="setIdDisplay()">
									<label for="check_method2">
										<span id="search_type_phone_lable">휴대폰번호 </span>
									</label>
							</div>
							
           					<div id="id_name_view" class="name"><strong id="name_lable">이름</strong>
           						<input type="text" id="id_name" name="id_name" class="lostInput">
           					</div>
            				<div id="id_email_view" class="email"><strong>e-mail</strong>
            					<input type="text" id="id_email" name="id_email" class="lostInput">
            				</div>
           					<div id="id_phone_view" class="phone" style="display:none;"><strong>휴대폰 번호</strong>
           						<input id="id_phone1" name="id_phone1" class="phone1" maxlength="3" type="text">&nbsp;
           						- &nbsp;<input id="id_phone2" name="id_phone2" class="phone2" maxlength="4" type="text">&nbsp;
           						- &nbsp;<input id="id_phone3" name="id_phone3" class="phone3"maxlength="4" type="text">
           					</div>
            				<div class="button">
                				<a  onclick="idFind()" class="btn-1">보내기</a>
           					</div>
       					 	</fieldset>
							</div>
						</div>
					</form>
					
					<form id="findIdForm" name="findIdForm" action="findPassword.do" method="post">
						<input id="returnUrl" name="returnUrl" value="/member/id/find_id_result.html" type="hidden">
						<div class="xans-element- xans-member xans-member-findid">
							<div class="findId">
							<h3>forgot your password?</h3>
    						<fieldset>
							<legend>비밀번호 찾기</legend>
    						<div class="method">
								<input id="check_method3" name="check_method" value="2" type="radio" checked="checked" onchange="setPwDisplay()">
									<label for="check_method3">이메일 &nbsp; </label>
								<input id="check_method4" name="check_method" value="3" type="radio" onchange="setPwDisplay()">
									<label for="check_method4">
										<span id="search_type_phone_lable">휴대폰번호</span>
									</label>
							</div>
							
							<div id="pw_id_view" class="id">
           						<strong id="id_lable">ID</strong>
								<input type="text" id="pw_id" name="pw_id" class="lostInput">
							</div>
           					<div id="pw_name_view" class="name">
           						<strong id="name_lable">이름</strong>
           						<input type="text" id="pw_name" name="pw_name" class="lostInput">
           					</div>
            				<div id="pw_email_view" class="email">
            					<strong>e-mail</strong>
            					<input type="text" id="pw_email" name="pw_email" class="lostInput">
            				</div>
           					<div id="pw_phone_view" class="phone" style="display:none;">
           						<strong>휴대폰 번호</strong>
           						<input id="pw_phone1" name="pw_phone1" class="phone1" maxlength="3" type="text">&nbsp;
           						-&nbsp;<input id="pw_phone2" name="pw_phone2" class="phone2" maxlength="4" type="text">&nbsp;
           						-&nbsp;<input id="pw_phone3" name="pw_phone3" class="phone3" maxlength="4" type="text">
           					</div>
            				<div class="button">
                				<a onclick="pwFind()" class="btn-1">보내기</a>
           					</div>
       					 	</fieldset>
							</div>
						</div>
					</form>
					</div>			
			   	</div><!-- inr.end -->
		   	</div>
     	</div>
		<%@include file="../include/footer.jsp"%>
	</div>
</div>
</body> 

<script type="text/javascript">
function idFind() {
	if($('input:radio[id=check_method1]').is(':checked')) {
		var name = document.getElementById('id_name').value;
		var email = document.getElementById('id_email').value;
		location.href="/sendIdEmail.do?name=" +name+ "&email=" +email;
	} else if ($('input:radio[id=check_method2]').is(':checked')) {
		var name = document.getElementById('id_name').value;
		var phone1 = document.getElementById('id_phone1').value;
		var phone2 = document.getElementById('id_phone2').value;
		var phone3 = document.getElementById('id_phone3').value;
		location.href="/sendIdPhone.do?name=" +name+ "&phone1=" + phone1 + "&phone2=" + phone2 + "&phone3=" + phone3;		
	}
}

function setIdDisplay() {
	if($('input:radio[id=check_method1]').is(':checked')) {
		$('#id_phone_view').hide();
		$('#id_email_view').show();
	} else if($('input:radio[id=check_method2]').is(':checked')) {
		$('#id_phone_view').show();
		$('#id_email_view').hide();
	}
}

function pwFind() {
	if($('input:radio[id=check_method3]').is(':checked')) {
		var id = $('#pw_id').val();
		var name = $('#pw_name').val();
		var email = $('#pw_email').val();
		location.href="/sendPwEmail.do?id=" + id + "&name=" + name + "&email=" + email;
	} else if ($('input:radio[id=check_method4]').is(':checked')) {
		var id = $('#pw_id').val();
		var name = $('#pw_name').val();
		var phone1 = $('#pw_phone1').val();		
		var phone2 = $('#pw_phone2').val();		
		var phone3 = $('#pw_phone3').val();
		location.href="/sendPwPhone.do?id=" + id + "&name=" + name + "&phone1=" + phone1 + "&phone2=" + phone2 + "&phone3=" + phone3;
	}
}

function setPwDisplay() {
	if($('input:radio[id=check_method3]').is(':checked')) {
		$('#pw_email_view').show();
		$('#pw_phone_view').hide();
	} else if($('input:radio[id=check_method4]').is(':checked')) {
		$('#pw_email_view').hide();
		$('#pw_phone_view').show();
	}	
}

</script>
</html>