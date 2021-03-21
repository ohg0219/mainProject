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
	.payment_btn{
	all:unset;
	margin-bottom: 20px;
	border-collapse:collapse;
	box-shadow: none;
	height: 25px;
	border: 1px solid black;
	background: black;
	cursor: pointer;
	text-align: center;
	color: white;
	width: 100%;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp" %>
		<div class="content">
			<div class="basket" align="center" style="margin-top: 50px;">
				<div class="basket_item">
					<!-- 장바구니 아이템 1세트 -->
					<table style="border-bottom: 1px solid #444">
						<tr>
							<td rowspan="3" >
								<a href=""><img style="width: 80px; margin-right: 50px;" src="https://thisisthat.s3.ap-northeast-2.amazonaws.com/T-Logo+Tee+Black+(003)/main.jpg"></a>
							</td>
							<td width="300px;"><a href="">T-Logo Tee Black (003)</a></td>
							<td>&#8361; 39,000</td>
						</tr>
						<tr>
							<td>[옵션 : L]</td>
							<td><input type="button" value="삭제"></td>
						</tr>
						<tr>
							<td><div><input type="button" value="-"> 1 <input type="button" value="+"></div></td>
						</tr>
					</table>
					<!-- 장바구니 아이템 1세트 끝 -->
					<!-- 장바구니 아이템 2세트 -->
					<table>
						<tr>
							<td rowspan="3" >
								<a href=""><img style="width: 80px; margin-right: 50px;" src="https://thisisthat.s3.ap-northeast-2.amazonaws.com/T-Logo+Tee+Black+(003)/main.jpg"></a>
							</td>
							<td width="300px;"><a href="">T-Logo Tee Black (003)</a></td>
							<td>&#8361; 39,000</td>
						</tr>
						<tr>
							<td>[옵션 : S]</td>
							<td><input type="button" value="삭제"></td>
						</tr>
						<tr>
							<td><div><input type="button" value="-"> 1 <input type="button" value="+"></div></td>
						</tr>
					</table>
					<!-- 장바구니 아이템 2세트 끝 -->
				</div>
				<div class="basket_total" style="width:492px">
					<table style="float: right;">
						<tr height="30px;">
							<td width="150px;">SUBTOTAL</td>
							<td align="right">&#8361; 39,000</td>
						</tr>
						<tr height="30px;">
							<td>배송비</td>
							<td align="right">&#8361; 0 (무료)</td>
						</tr>
						<tr style="font-weight: 700; height:30px;">
							<td>TOTAL</td>
							<td align="right">&#8361; 39,000</td>
						</tr>
						<tr>
							<td colspan="2">
								<input id="paymentBtn" class="payment_btn" type="submit" value="결제하기">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div><!-- end Content -->
		<%@include file="include/footer.jsp" %>
	</div>
</body>
</html>