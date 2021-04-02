<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
	
	.soksung {
	color: #ffffff;
	background: black;
	font-size: 1.2em;
	padding: 0.3em 0.5em;
	margin-right: 0.1em;
	border-radius: 3px;
	}
	
</style>
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
								<td>[ ${user_Id} ] 회원님의 쿠폰List!</td>
							</tr>
						</table>
						<form method="get">
									<input type="hidden" name="user_id" value="${user_Id}"/>
									<input class="btn btn-dark" type="submit" name="allDelete" value="전체삭제" formaction="userCouponDeleteAll.mdo">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<c:if test="${not empty couponUserList}">
										<!-- <tr><td><label><input type="checkbox" id="checkAll" class="chk"/>전체선택</label></td></tr> -->
								<c:forEach var="couponList" items="${couponUserList}">
									<tr>
										<!-- <td><input type="checkbox"value="${couponList.coupon_no }" name="couponCheck" class="chk childChk">쿠폰 번호 : ${couponList.coupon_no }</td> -->
										<td>쿠폰 번호 : ${couponList.coupon_no }</td>
										<td>쿠폰명 : <a href="grantCouponView.mdo?coupon_no=${couponList.coupon_no }">${couponList.coupon_name }</a></td>
										<td>할인금액 : ${couponList.coupon_price }</td>
										<td>쿠폰 기한 : <fmt:formatDate
												value="${couponList.coupon_first }" pattern="yyyy-MM-dd " />
										</td>
										<td>쿠폰 만료일 : <fmt:formatDate
												value="${couponList.coupon_last }" pattern="yyyy-MM-dd " />
										</td>
										<td>사용 유무 : ${couponList.used }</td>
										<td><a class="btn btn-dark" href="userCouponDeleteSel.mdo?coupon_no=${couponList.coupon_no }&user_id=${user_Id}">삭제</a></td>
									</tr>
								</c:forEach>
							</c:if>
							</table>
							</form>
							<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<c:if test="${empty couponUserList}">
								<tr>
									<td colspan="5" align="center">
										<h1>정보가 없습니다.</h1>
									</td>
								</tr>
							</c:if>
						</table>
						<!-- <button class="btn btn-dark" type="button" id="allDelete">쿠폰전체삭제</button> -->
						
						<button class="btn btn-dark" type="button"
							onclick="location.href='grantCoupon.mdo' ">목록으로</button>
						<button class="btn btn-dark" type="button"
							onclick="location.href='userGrant.mdo' ">쿠폰 부여</button>
							
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
		
		//맨위에 버튼을 클릭하면 전체 선택되는 제이쿼리 함수
		$(function () {
			$("#checkAll").click(function() {
				//만약에 input태그안에checkbox의 name이 couponCheck인놈의 속성(.prop)가 checked면
				if($("#checkAll").prop("checked")){
					$("input[name=couponCheck]").prop("checked",true);
				}else{
					$("input[name=couponCheck]").prop("checked",false);
				}	
			})
		});
		//안씀
		$(function () {
			$("#allDelete").click(function () {
				location.href = "userCouponDelete.mdo"
			})
		})
	</script>
	<%@include file="../include/js.jsp"%>

</body>
</html>