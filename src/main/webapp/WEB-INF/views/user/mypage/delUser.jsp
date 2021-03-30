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
<style type="text/css">
	body {
	    margin: 0;
	    font: 500 11px/1.5 arial, sans-serif;
	    font-style: normal;
	    font-variant-ligatures: normal;
	    font-variant-caps: normal;
	    font-variant-numeric: normal;
	    font-variant-east-asian: normal;
	    font-weight: 500;
	    font-stretch: normal;
	    font-size: 11px;
	    line-height: 1.5;
	    font-family: arial, sans-serif;
	}
	form{
		padding: 10%;
	}
	.pass{
	 	width: 100%;
		 padding: 0px 8px;
		 margin-bottom: 20px;
    	 height: 25px;
	}
	.btn{
	    all: unset;
	    padding: 0px 8px;
	    margin-bottom: 20px;
	    width: 100%;
	    border-collapse: collapse;
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
</head>
<body>
<%@include file="../include/header.jsp" %>
	<form action="" method="post">
		<table>
			<tr>
				<td>
				<input type="password" required="required" placeholder="비밀번호를 입력해 주세요" class="pass" name="userPw">
				<input type="submit" class="btn">
				</td>
			</tr>
		</table>
	</form>

<%@include file="../include/footer.jsp" %>
</body>
<script type="text/javascript">
	var msg = '${msg}';
	if(msg ==='fail'){
		alert('비밀번호를 확인해 주세요.');
	}
</script>
</html>