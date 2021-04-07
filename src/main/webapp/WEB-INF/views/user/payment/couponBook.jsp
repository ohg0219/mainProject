<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
	input{
		all:unset;
		border: 1px solid black;
		background-color: black;
		color: white;
		padding: 7px;
		cursor: pointer;
		text-align: center;
	}
</style>
<title>주소록</title>
</head>
<body>
	<div align="right">
		<input type="button" value="창 닫기" onclick="window.close()">
	</div>
	<h3 align="center">내 쿠폰 목록</h3>
	<table style="width: 90%;margin:0 auto; border-collapse: collapse;" border="1">
		<tr align="center">
			<td>쿠폰명</td>
			<td>쿠폰금액</td>
			<td>쿠폰유효기간</td>
			<td>선택</td>
		</tr>
		<c:forEach items="${couponList}" var="coupon">
		<tr align="center">
			<input class="couponNo" type="hidden" name="couponNo" value="${coupon.couponNo }">
			<input class="couponPrice" type="hidden" name="couponPrice" value="${coupon.couponPrice }">
			<td>${coupon.couponName }</td>
			<td>${coupon.couponPrice }</td>
			<td><fmt:formatDate value="${coupon.couponDate }" pattern="yyyy-MM-dd"/></td>
			<td>
				<input type="button" value="선택" class="couponSelect" >
			</td>
		</tr>
		</c:forEach>
		<c:if test="${empty couponList }">
			<tr>
				<td colspan="4" align="center">
					<h3>쿠폰이 없습니다.</h3>
				</td>
			</tr>
		</c:if>
	</table>
	<script type="text/javascript">
		$(".couponSelect").on("click", function(){
			var couponNo = $(this).closest('tr').find('.couponNo').val();
			var couponPrice = $(this).closest('tr').find('.couponPrice').val();
			$(opener.document).find("input[name=couponNo]").val(couponNo);
			$(opener.document).find("input[name=useCoupon]").val(couponPrice);
			$(opener.document).find("#couponPrice").html(couponPrice);
			$(opener.document).find("#usePoint").focus();
			
			window.close();
	    });
	</script>

</body>
</html>