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
	.itemCount{
		all : unset;
		cursor: pointer;
		width: 26px;
		text-align: center;
		margin: 0 5px;
	}
	.deleteBtn{
		all : unset;
		cursor: pointer;
		border: 1px solid black;
		text-align: center;
		width: 36px;
		height: 26px;
	}
	.itemTitle{
		width: 300px;
	}
	.itemTitle a{
		text-decoration: none;
		font-weight: 700;
		color: black;
		width: 300px;
	}
	.itemImg{
		width: 80px; 
		margin-right: 50px;
	}
	.itemTable{
		border-bottom: 1px solid #eee;
	}
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp" %>
		<div class="content">
			<div class="basket" align="center" style="margin-top: 100px;">
				<div class="basket_item">
				<c:choose>
					<c:when test="${sessionScope.userId != null }">
						<c:set var = "subtotal" value="0" />
						<c:forEach items="${basketList }" var="basket">
						<table class="itemTable">
							<tr>
								<td rowspan="3" >
									<a href="/itemList/getItem.do?productNo=${basket.productNo}&productCategory=${basket.productCategory}"><img class="itemImg" src="${basket.uploadPath }"></a>
								</td>
								<td class="itemTitle" ><a href="/itemList/getItem.do?productNo=${basket.productNo}&productCategory=${basket.productCategory}">${basket.productName }</a></td>
								<td>&#8361; <fmt:formatNumber maxFractionDigits="3" value="${basket.productPrice * basket.selectCount}"/></td>
							</tr>
							<tr>
								<td>[옵션 : ${basket.selectSize }]</td>
								<td align="right"><input type="button" class="deleteBtn" value="삭제"></td>
							</tr>
							<tr>
								<td><div><input type="button" class="itemCount" value="-"> ${basket.selectCount } <input type="button" class="itemCount" value="+"></div></td>
							</tr>
						</table>
						<c:set var="subtotal" value="${subtotal+ (basket.productPrice * basket.selectCount)}" />
						</c:forEach>
					</c:when>
					<c:when test="${sessionScope.userId == null }">
						<c:forEach items="${sessionScope.basketItem }" var="sessionBasket">
						<table class="itemTable">
							<tr>
								<td rowspan="3" >
									<a href="/itemList/getItem.do?productNo=${sessionBasket.productNo}&productCategory=${sessionBasket.productCategory}"><img class="itemImg" src="${sessionBasket.uploadPath }"></a>
								</td>
								<td class="itemTitle" ><a href="/itemList/getItem.do?productNo=${sessionBasket.productNo}&productCategory=${sessionBasket.productCategory}">${sessionBasket.productName }</a></td>
								<td>&#8361; <fmt:formatNumber maxFractionDigits="3" value="${sessionBasket.productPrice * sessionBasket.selectCount}"/></td>
							</tr>
							<tr>
								<td>[옵션 : ${sessionBasket.selectSize }]</td>
								<td align="right"><input type="button" class="deleteBtn" value="삭제"></td>
							</tr>
							<tr>
								<td><div><input type="button" class="itemCount" value="-"> ${sessionBasket.selectCount } <input type="button" class="itemCount" value="+"></div></td>
							</tr>
						</table>
						<c:set var="subtotal" value="${subtotal+ (sessionBasket.productPrice * sessionBasket.selectCount)}" />
						</c:forEach>
					</c:when>
				</c:choose>
				</div>
					<div class="basket_total" style="width:492px">
						<c:choose>
							<c:when test="${not empty sessionScope.basketItem || not empty basketList}">
								<table style="float: right;">
									<tr height="30px;">
										<td width="150px;">SUBTOTAL</td>
										<td align="right">&#8361; <fmt:formatNumber maxFractionDigits="3" value="${subtotal }"/></td>
									</tr>
									<tr height="30px;">
										<td>배송비</td>
										<c:set var="deliveryPay" value="2500"/>
										<td align="right">&#8361; 
											<c:if test="${subtotal < 30000}"><fmt:formatNumber maxFractionDigits="3" value="${deliveryPay }"/></c:if>
											<c:if test="${subtotal >= 30000}">0</c:if>
										</td>
									</tr>
									<tr style="font-weight: 700; height:30px;">
										<td>TOTAL</td>
										<td align="right">&#8361; 
											<c:if test="${subtotal < 30000 }"><fmt:formatNumber maxFractionDigits="3" value="${subtotal+deliveryPay }"/></c:if>
											<c:if test="${subtotal >= 30000}"><fmt:formatNumber maxFractionDigits="3" value="${subtotal }"/></c:if>
										</td>
									</tr>
									<tr>
										<td colspan="2">
											<input id="paymentBtn" class="payment_btn" type="submit" value="결제하기">
										</td>
									</tr>
								</table>
							</c:when>
							<c:otherwise>
								<h2>장바구니에 상품이 없습니다.</h2>
							</c:otherwise>
						</c:choose>
					</div>
			</div>
		</div><!-- end Content -->
		<%@include file="include/footer.jsp" %>
	</div>
</body>
</html>