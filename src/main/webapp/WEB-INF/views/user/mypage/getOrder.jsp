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
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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

.inr {
	position: relative;
	display: block;
	box-sizing: border-box;
	width: 100%;
	height: auto;
	padding: 0 20px;
}

#myshopMain {
	display: block;
	position: relative;
	width: 50%;
	max-width: 720px;
	min-width: 560px;
	margin: 80px auto 40px;
	box-sizing: border-box;
	padding: 0 20px;
}

#myshopMain #boxsize {
	margin: 0 0;
	width: 100%;
	border-bottom: 1px solid #eee;
	overflow: auto;
	padding: 0 0 20px;
}

#myshopMain .xans-layout-statelogon a.btnlogin {
	position: relative;
	display: inline-block;
	font-size: 10px !important;
	background: transparent !important;
	border-radius: 0px;
	padding: 0 0 2px;
	height: auto !important;
	color: #111;
	margin: 0 0;
	text-decoration: none;
	border-bottom: 1px solid #111;
}

#myshopMain a {
	display: inline-block;
	cursor: pointer;
	width: auto;
	padding: 0 0;
	border-radius: 0px;
	background: transparent;
	color: #111;
	text-transform: uppercase;
	text-align: center;
	font-size: 10px;
	float: left;
	margin-right: 20px;
	margin-bottom: 8px;
}

#myshopMain .xans-layout-statelogon {
	vertical-align: top;
}

#myshopMain .xans-layout-statelogon {
	position: absolute;
	top: 0;
	right: 20px;
	margin: 0 0;
	z-index: 299;
	width: auto;
}

.w-2 {
	margin: 0 auto;
	*zoom: 1;
	width: 50%;
	max-width: 720px;
	min-width: 560px;
	padding: 0 20px !important;
}

.w-1, .w-2, .w-3 {
	box-sizing: border-box;
	display: block;
}

.xans-myshop-benefit {
	margin: 0 0 40px;
}

.xans-myshop-benefit .infoWrap {
	overflow: hidden;
	padding: 0;
	color: #111;
}

.xans-myshop-benefit .myInfo {
	padding: 0;
	font-size: 11px;
}

.xans-myshop-bankbook {
	padding: 0;
	border: 0;
	background: transparent;
	width: 100%;
	margin: 0 auto 0;
	display:;
	margin-top: 20px;
}

.xans-myshop-bankbook li .use {
	color: #111;
	font-size: 10px;
}

.xans-myshop-bankbook li .data {
	float: right;
	width: 35%;
	text-align: right;
	margin-right: 52px;
	font-size: 11px;
	font-weight: 400;
}

.xans-myshop-bankbook li strong {
	font-size: 11px;
}

.xans-myshop-bankbook li {
	display: inline-block;
	position: relative;
	overflow: auto;
	width: 40%;
	margin-right: 10%;
	line-height: 1.7;
	float: left;
	vertical-align: top;
	*display: inline;
	*zoom: 1;
	padding: 5px 0;
	font-size: 11px;
}

.xans-myshop-bankbook li .title {
	float: left;
	width: 40%;
	font-weight: normal;
	color: #111;
	font-size: 11px;
	font-weight: 400;
	padding-bottom: 4px;
	border-bottom: 1px solid #eee;
}

.xans-myshop-benefit .infoWrap {
	overflow: hidden;
	padding: 0;
	color: #111;
}

ul li {
	list-style: none;
	margin: 0 0;
}

li a.dual {
	width: auto;
	background: #fff;
	border-color: #111;
	font-weight: 400;
	line-height: 1.3;
}

.xans-myshop-bankbook li {
	display: inline-block;
	position: relative;
	overflow: auto;
	width: 40%;
	margin-right: 10%;
	line-height: 1.7;
	float: left;
	vertical-align: top;
	*display: inline;
	*zoom: 1;
	padding: 5px 0;
	font-size: 11px;
}

.xans-myshop-bankbook li a {
	position: absolute;
	right: 4px;
}

a.dual {
	display: inline-block;
	cursor: pointer;
	width: auto;
	height: auto;
	border-radius: 1px;
	margin-top: 0;
	margin-left: 4px;
	background: transparent;
	color: #111;
	background: #ccc;
	border: 1px solid #eee;
	text-align: center;
	padding: 1px 8px;
	font-size: 10px;
}

.info {
	float: center;
	width: 250px;
}

#boxsize a {
	text-decoration: none;
}
.cancel{
	display: table-row;
}
.ok{
	display: none;
}
</style>
<script type="text/javascript">
$(document).ready(function () {
	$("#sDate").datepicker({
		dateFormat: "yy-mm-dd",
		dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		maxDate:0
	});
	$("#eDate").datepicker({
		dateFormat: "yy-mm-dd",
		dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		maxDate:0
	});
	var orderNo = $("#orderNo").text();
	$("#orderCancel").on("click",function(){
		if(confirm("정말 취소하시겠습니까?")){
			location.href="updateState.do?orderNo="+orderNo+"&state=orderCancel";
		}
	});
	$("#refund").on("click",function(){
		if(confirm("정말로 환불 요청하시겠습니까?")){
			location.href="updateState.do?orderNo="+orderNo+"&state=refund";
		}
	});
	$("#trade").on("click",function(){
		if(confirm("정말로 교환 요청하시겠습니까?")){
			location.href="updateState.do?orderNo="+orderNo+"&state=trade";
		}
	});
});
</script>
</head>
<body>
	<div class="wraped">
		<%@include file="../include/header.jsp"%>
		<div id="wrap">
			<div id="container">
				<div id="contents">
					<div class="inr">
						<div id="myshopMain" class="xans-element- xans-myshop xans-myshop-main ">
							
							<div id="boxsize">
								<c:if test="${not empty sessionScope.userId }">
								<a href="/mypage/mypage.do" class="sltd">my</a> 
								<a href="/mypage/modify.do">profile</a> 
								<a href="/mypage/address.do">address book</a> 
								<a href="/mypage/orderlist.do"><strong>orders</strong></a> 
								<a href="/user/userPoint.do">point</a> 
								<a href="/mypage/coupon.do">coupon</a>
								</c:if>
								<c:if test="${empty sessionScope.userId }">
									<h2>비회원 주문 조회 결과</h2>
								</c:if>
							</div>
						</div>
						<div class="w-2">
							<div class="xans-element- xans-myshop xans-myshop-benefit">
								<div class="infoWrap">
									<div class="myInfo">
										
									</div>
								</div>
							</div>
							<div class="xans-element- xans-myshop xans-myshop-bankbook">
								<table border="1" style="border-collapse: collapse; width: 400px;">
									<tr>
										<td>주문번호</td>
										<td colspan="3" id="orderNo">${order.orderNo }</td>
									</tr>
									<tr>
										<td>주문일</td>
										<td colspan="3"><fmt:formatDate value="${order.orderDate }" pattern="yyyy-MM-dd"/></td>
									</tr>
								</table>
								<br><br>
								<table border="1" style="border-collapse: collapse; width: 400px;">
									<tr>
										<td colspan="4" align="center">주문상품정보</td>
									</tr>
									<tr>
										<td align="center">상품명</td>
										<td align="center">사이즈</td>
										<td align="center">수량</td>
										<td align="center">판매가</td>
									</tr>
									<c:forEach items="${orderList }" var="orders">
									<tr>
										<td>${orders.productName }</td>
										<td align="center">${orders.orderSize }</td>
										<td align="center">${orders.selectCount }</td>
										<td align="right"><fmt:formatNumber maxFractionDigits="3" value="${orders.productPrice }"/>원</td>
									</tr>
									</c:forEach>
								</table>
								<br><br>
								<table border="1" style="border-collapse: collapse; width: 400px;">
									<c:if test="${not empty sessionScope.userId }">
									<tr align="center">
										<td>총 상품구매금액</td>
										<td align="right" colspan="3"><fmt:formatNumber maxFractionDigits="3" value="${order.originalPrice }"/>원</td>
									</tr>
									<tr>
										<td>사용 포인트</td>
										<td align="right" colspan="3"><fmt:formatNumber maxFractionDigits="3" value="${order.usePoint }"/>점</td>
									</tr>
									<tr>
										<td>사용 쿠폰금액</td>
										<td align="right" colspan="3"><fmt:formatNumber maxFractionDigits="3" value="${order.useCoupon }"/></td>
									</tr>
									</c:if>
									<tr>
										<td>실 결제금액</td>
										<td align="right" colspan="3"><fmt:formatNumber maxFractionDigits="3" value="${order.orderPrice }"/>원</td>
									</tr>
									<tr>
										<td>주문상태</td>
										<td align="center" colspan="3">${order.orderState }</td>
									</tr>
									<tr>
										<td>송장번호</td>
										<td align="center" colspan="3">${order.invoiceNo }</td>
									</tr>
										
									<tr >
										<td colspan="4" align="center">
											<c:if test="${order.orderState eq '입금대기' }">
												<input type="button" value="주문취소" id="orderCancel">
											</c:if>
											<c:if test="${order.orderState eq '결제완료' || order.orderState eq '상품준비중' || order.orderState eq '배송준비중' || order.orderState eq '배송중' || order.orderState eq '배송완료'}">
												<input type="button" value="환불요청" id="refund">
											</c:if>
											<c:if test="${order.orderState eq '배송완료' }">
												<input type="button" value="교환요청" id="trade">
											</c:if>
											<c:if test="${not empty sessionScope.userId }">
												<input type="button" value="목록으로" onclick="location.href='/mypage/orderlist.do'">
											</c:if>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%@include file="../include/footer.jsp"%>
		</div>
	</div>
</body>
</html>