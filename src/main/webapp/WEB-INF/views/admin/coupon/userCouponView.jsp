<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../include/css.jsp"%>
<title>thisisthat - 회원 쿠폰 리스트</title>
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
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<tr>
								<td>${userIdCoupon}님의쿠폰List!</td>
							</tr>
						</table>

						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<c:if test="${not empty couponUserList}">
								<c:forEach var="couponList" items="${couponUserList}">
									<tr>
										<td>쿠폰 번호 : ${couponList.coupon_no }</td>
										<td>쿠폰명 : ${couponList.coupon_name }</td>
										<td>할인금액 : ${couponList.coupon_price }</td>
										<td>쿠폰 기한 : <fmt:formatDate
												value="${couponList.coupon_first }" pattern="yyyy-MM-dd " />
										</td>
										<td>쿠폰 만료일 : <fmt:formatDate
												value="${couponList.coupon_last }" pattern="yyyy-MM-dd " />
										</td>
										<td>사용 유무 : ${couponList.used }</td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${empty couponUserList}">
								<tr>
									<td colspan="5" align="center">
										<h1>정보가 없습니다.</h1>
									</td>
								</tr>
							</c:if>
						</table>
						<br>
						<button class="btn btn-dark" type="button"
							onclick="location.href='grantCoupon.mdo' ">목록으로</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(function() {//삭제 페이지로 가는 함수
			$("#deleteCoupon").click(function() {
				location.href = "/admin/deleteCoupon.mdo?coupon_no=" + $
				{
					article.coupon_no
				}
			});
			$("#CouponList").click(function() {
				location.href = "/admin/getCouponList.mdo"
			});
		});
	</script>
	<%@include file="../include/js.jsp"%>

</body>
</html>