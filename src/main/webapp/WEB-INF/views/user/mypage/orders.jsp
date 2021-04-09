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

.xans-myshop-benefit .selectDate {
	padding: 0;
	font-size: 11px;
	text-align: center;
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
.pageBtn{
		padding: 8px;
		border: 1px solid black;
		text-decoration: none;
}
.pageBtn:hover{
	background-color: black;
	color: white;
}
.nowpageBtn{
	padding: 8px;
	border: 1px solid black;
	text-decoration: none;
	background-color: black;
	color: white;
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
});
function getData(){
	var sDate = $("#sDate").val();
	var eDate = $("#eDate").val();
	
	var split1 = sDate.split("-");
	var split2 = eDate.split("-");
	if(parseInt(split1[0])>parseInt(split2[0])){
		alert("종료일이 시작일보다 클 수 없습니다.");
		return false;
	}else if(parseInt(split1[0])==parseInt(split2[0])){
		if(parseInt(split1[1])>parseInt(split2[1])){
			alert("종료일이 시작일보다 클 수 없습니다.");
			return false;
		}else if(parseInt(split1[1])==parseInt(split2[1])){
			if(parseInt(split1[2])>parseInt(split2[2])){
				alert("종료일이 시작일보다 클 수 없습니다.");
				return false;
			}
		}
	}
	if(sDate == '' || eDate == ''){
		alert("조회 기간을 선택해주세요");
		return false;
	}
	location.href="/mypage/orderlist.do?sDate="+sDate+"&eDate="+eDate;
}
</script>
</head>
<body>
	<div class="wraped">
		<%@include file="../include/header.jsp"%>
		<div id="wrap">
			<div id="container">
				<div id="contents">
					<div class="inr">
						<div id="myshopMain"
							class="xans-element- xans-myshop xans-myshop-main ">

							<div id="boxsize">
								<a href="/mypage/mypage.do" class="sltd">my</a> 
								<a href="/mypage/modify.do">profile</a> 
								<a href="/mypage/address.do">address book</a> 
								<a href="/mypage/orderlist.do"><strong>orders</strong></a> 
								<a href="/mypage/userPoint.do">point</a> 
								<a href="/mypage/coupon.do">coupon</a>
							</div>
						</div>
						<div class="w-2">
							<div class="xans-element- xans-myshop xans-myshop-benefit">
								<div class="infoWrap">
									<div>
										<strong class="group">내 주문조회</strong>
									</div>
									<div class="selectDate">
										조회 기간 : 
										<input class="btn btn-dark" type="text" id="sDate" autocomplete="off" name="sDate" value="${sDate }">
										 ~ 
										<input class="btn btn-dark" type="text" id="eDate" autocomplete="off" name="eDate" value="${eDate }">
          				         		&nbsp;&nbsp;&nbsp;&nbsp;<input class="btn btn-dark" type="button" value="조회" onclick="getData()">
									</div>
								</div>
							</div>
							<div class="xans-element- xans-myshop xans-myshop-bankbook">
								<table border="1" style="border-collapse: collapse;width: 100%;">
									<tr>
										
										<th style="padding: 8px;">주문일자</th>
										<th style="padding: 8px;" width="80px;">주문번호</th>
										<th style="padding: 8px;" width="80px;">결제금액</th>
										<th style="padding: 8px;">상태</th>
										<th style="padding: 8px;" width="100px;">송장번호</th>
										<th style="padding: 8px;">상세보기</th>
									</tr>
									<c:forEach items="${orderList }" var="order">
									<tr>
										<td style="padding: 8px;"><fmt:formatDate value="${order.orderDate }" pattern="yyyy-MM-dd"/></td>
										<td style="padding: 8px;text-align: center">${order.orderNo }</td>
										<td style="padding: 8px;text-align: center"><fmt:formatNumber maxFractionDigits="3" value="${order.orderPrice }"/>원</td>
										<td style="padding: 8px;text-align: center">${order.orderState }</td>
										<td style="padding: 8px;text-align: center" >
											<c:if test="${order.invoiceNo == 0 }">
												-
											</c:if>
											<c:if test="${order.invoiceNo != 0 }">
												${order.invoiceNo }
											</c:if>
											
										</td>
										<td style="padding: 8px;text-align: center"><a href="/mypage/getorder.do?orderNo=${order.orderNo }">상세보기</a></td>
									</tr>
									</c:forEach>
								</table>
								<div align="center" style="margin-top: 10px;">
									<c:if test="${paging.startPage != 1 }">
										<a class="pageBtn" href="/mypage/orderlist.do?nowPage=${paging.startPage - 1 }&sDate=${sDate}&eDate=${eDate}">&lt;</a>
									</c:if>
									<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
										<c:choose>
											<c:when test="${p == paging.nowPage }">
												<b class="nowpageBtn">${p }</b>
											</c:when>
											<c:when test="${p != paging.nowPage }">
												<a class="pageBtn" href="/mypage/orderlist.do?nowPage=${p }&sDate=${sDate}&eDate=${eDate}">${p }</a>
											</c:when>
										</c:choose>
									</c:forEach>
									<c:if test="${paging.endPage != paging.lastPage}">
										<a class="pageBtn" href="/mypage/orderlist.do?nowPage=${paging.endPage+1 }&sDate=${sDate}&eDate=${eDate}">&gt;</a>
									</c:if>
								</div>
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