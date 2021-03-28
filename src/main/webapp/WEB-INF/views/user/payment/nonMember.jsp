<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
	.leftItem{
		float: left;
		width: 100px;
	}
	.rightItem{
		float: right;
		width: 180px;
		text-align: right;
	}
	#paymentBtn{
		all:unset;
		border: 1px solid black;
		background-color: black;
		color: white;
		padding: 4px;
		cursor: pointer;
		text-align: center;
		width: 100%;
	}
	#registBtn{
		all:unset;
		border-bottom: 1px solid black;
		font-size: 13px;
		font-weight: 700;
		cursor: pointer;
	}
	.title{
		font-weight: 700;
		font-size: 13px;
	}
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="../include/header.jsp" %>
		<div class="content" style="margin-top: 100px; display: flex;">
			
				<div class="divide" style="flex: 1; vertical-align: middle;">
					<div class="shipping" style=" width: 250px; float: right; margin-right: 20px;">
						
					</div>
				</div>
				<div class="divide" style="flex: 1;vertical-align: middle;">
					<div class="payment" style="width: 280px; float: left;margin-left: 20px;">
						<ul>
							<li class="title">비회원 구매</li>
							<li><br></li>
							<li>주문에 필요한 몇 가지 정보를 입력하시면<br>비회원으로 구매하실 수 있습니다.</li>
							<li><br></li>
							<li><input id="paymentBtn" type="button" value="결제 하기" onclick="location.href='/nonMemberPayment.do'"></li>
							<li><br></li>
							<li><input id="registBtn" type="button" value="회원가입" onclick="location.href='/register.do'"></li>
						</ul>
						
					</div>
				</div>
			
		</div><!-- end Content -->
		<%@include file="../include/footer.jsp" %>
	</div>
</body>
</html>