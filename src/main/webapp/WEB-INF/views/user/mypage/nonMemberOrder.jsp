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
	.title{
		font-weight: 700;
		font-size: 13px;
	}
	input{
		border: 1px solid black;
		width: 250px;
		padding: 4px;
	}
	.submit{
		all:unset;
		border: 1px solid black;
		background-color: black;
		color: white;
		padding: 4px;
		cursor: pointer;
		text-align: center;
		width: 100%;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$(".submit").on("click",function(){
			var name = $("input[name=name]").val();
			var orderNo = $("input[name=orderNo]").val();
			var password = $("input[name=password]").val();
			if(name==''||orderNo==''||password==''){
				alert("정보를 정확히 입력해주세요");
				return false;
			}
		});
	});
</script>
</head>
<body>
	<div class="wrap">
		<%@include file="../include/header.jsp" %>
		<div class="content" style="margin-top: 100px;">
			<div class="payment" style="width: 250px; margin: 0 auto">
				<form action="/searchOrder.do" method="post">
					<ul>
						<li class="title">비회원 주문조회</li>
						<li><br></li>
						<li>조회에 필요한 몇 가지 정보를 입력하시면<br>비회원 주문내역을 조회하실 수 있습니다.</li>
						<li><br></li>
						<li>이름</li>
						<li><input type="text" name="name"></li>
						<li><br></li>
						<li>주문번호</li>
						<li><input type="number" name="orderNo"></li>
						<li><br></li>
						<li>비밀번호</li>
						<li><input type="text" name="password"></li>
						<li><br></li>
						<li><input class="submit" type="submit" value="조회"></li>
					</ul>
				</form>
			</div>
		</div><!-- end Content -->
		<%@include file="../include/footer.jsp" %>
	</div>
</body>
</html>